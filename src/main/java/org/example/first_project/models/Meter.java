package org.example.first_project.models;

import java.time.LocalDate;

public class Meter {
    private String meterNumber;
    private String customerId;
    private String meterType;
    private LocalDate installationDate;
    private LocalDate lastReadingDate;
    private double lastReading;
    private double currentReading;
    private String status;
    private String location;
    private boolean isActive;

    public Meter(String meterNumber, String customerId, String meterType) {
        this.meterNumber = meterNumber;
        this.customerId = customerId;
        this.meterType = meterType;
        this.installationDate = LocalDate.now();
        this.status = "ACTIVE";
        this.isActive = true;
        this.lastReading = 0.0;
        this.currentReading = 0.0;
    }

    public double calculateConsumption() {
        return currentReading - lastReading;
    }

    // Getters and setters
    public String getMeterNumber() {
        return meterNumber;
    }

    public void setMeterNumber(String meterNumber) {
        this.meterNumber = meterNumber;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getMeterType() {
        return meterType;
    }

    public void setMeterType(String meterType) {
        this.meterType = meterType;
    }

    public LocalDate getInstallationDate() {
        return installationDate;
    }

    public void setInstallationDate(LocalDate installationDate) {
        this.installationDate = installationDate;
    }

    public LocalDate getLastReadingDate() {
        return lastReadingDate;
    }

    public void setLastReadingDate(LocalDate lastReadingDate) {
        this.lastReadingDate = lastReadingDate;
    }

    public double getLastReading() {
        return lastReading;
    }

    public void setLastReading(double lastReading) {
        this.lastReading = lastReading;
    }

    public double getCurrentReading() {
        return currentReading;
    }

    public void setCurrentReading(double currentReading) {
        this.currentReading = currentReading;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
