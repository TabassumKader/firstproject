package org.example.first_project.models;

import java.time.LocalDate;

public class DomesticCustomer extends User {
    private static final String ROLE = "DOMESTIC_CUSTOMER";
    private String customerId;
    private String address;
    private String meterNumber;
    private LocalDate connectionDate;
    private String zone;
    private boolean isActive;
    private double monthlyConsumption;
    private String connectionStatus;

    public DomesticCustomer(String userId, String username, String password) {
        super(userId, username, password, ROLE);
        this.isActive = true;
        this.connectionStatus = "PENDING";
    }

    @Override
    public boolean hasPermission(String operation) {
        // Define customer-specific permissions
        switch (operation.toUpperCase()) {
            case "VIEW_BILL":
            case "PAY_BILL":
            case "SUBMIT_COMPLAINT":
            case "VIEW_PROFILE":
            case "UPDATE_PROFILE":
            case "REQUEST_SERVICE":
            case "VIEW_CONSUMPTION":
            case "DOWNLOAD_DOCUMENTS":
                return true;
            default:
                return false;
        }
    }

    // Getters and setters
    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMeterNumber() {
        return meterNumber;
    }

    public void setMeterNumber(String meterNumber) {
        this.meterNumber = meterNumber;
    }

    public LocalDate getConnectionDate() {
        return connectionDate;
    }

    public void setConnectionDate(LocalDate connectionDate) {
        this.connectionDate = connectionDate;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    @Override
    public boolean isActive() {
        return isActive;
    }

    @Override
    public void setActive(boolean active) {
        this.isActive = active;
    }

    public double getMonthlyConsumption() {
        return monthlyConsumption;
    }

    public void setMonthlyConsumption(double monthlyConsumption) {
        this.monthlyConsumption = monthlyConsumption;
    }

    public String getConnectionStatus() {
        return connectionStatus;
    }

    public void setConnectionStatus(String connectionStatus) {
        this.connectionStatus = connectionStatus;
    }
}
