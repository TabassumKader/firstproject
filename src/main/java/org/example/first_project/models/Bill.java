package org.example.first_project.models;

import java.time.LocalDate;

public class Bill {
    private String billId;
    private String customerId;
    private String meterNumber;
    private LocalDate billDate;
    private LocalDate dueDate;
    private double consumption;
    private double rate;
    private double amount;
    private double vat;
    private double totalAmount;
    private boolean isPaid;
    private LocalDate paymentDate;
    private String paymentMethod;
    private String status;

    public Bill(String billId, String customerId, String meterNumber, double consumption, double rate) {
        this.billId = billId;
        this.customerId = customerId;
        this.meterNumber = meterNumber;
        this.consumption = consumption;
        this.rate = rate;
        this.billDate = LocalDate.now();
        this.dueDate = billDate.plusDays(30);
        this.isPaid = false;
        this.status = "PENDING";
        calculateBill();
    }

    private void calculateBill() {
        this.amount = consumption * rate;
        this.vat = amount * 0.15; // 15% VAT
        this.totalAmount = amount + vat;
    }

    public void processPayment(String paymentMethod) {
        this.isPaid = true;
        this.paymentDate = LocalDate.now();
        this.paymentMethod = paymentMethod;
        this.status = "PAID";
    }

    public boolean isOverdue() {
        if (!isPaid) {
            return LocalDate.now().isAfter(dueDate);
        }
        return false;
    }

    // Getters and setters
    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getMeterNumber() {
        return meterNumber;
    }

    public void setMeterNumber(String meterNumber) {
        this.meterNumber = meterNumber;
    }

    public LocalDate getBillDate() {
        return billDate;
    }

    public void setBillDate(LocalDate billDate) {
        this.billDate = billDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public double getConsumption() {
        return consumption;
    }

    public void setConsumption(double consumption) {
        this.consumption = consumption;
        calculateBill();
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
        calculateBill();
    }

    public double getAmount() {
        return amount;
    }

    public double getVat() {
        return vat;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
