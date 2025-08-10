package org.example.first_project.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class GasSupply {
    private String supplyId;
    private String zoneId;
    private String status;
    private double currentPressure;
    private double flowRate;
    private double temperature;
    private double quality;
    private LocalDateTime lastUpdated;
    private List<SupplyReading> readings;
    private List<SupplyAlert> alerts;
    private boolean isOperational;
    private String maintenanceStatus;
    private double totalSupply;
    private double capacity;

    public GasSupply(String supplyId, String zoneId) {
        this.supplyId = supplyId;
        this.zoneId = zoneId;
        this.status = "OPERATIONAL";
        this.isOperational = true;
        this.maintenanceStatus = "NORMAL";
        this.readings = new ArrayList<>();
        this.alerts = new ArrayList<>();
        this.lastUpdated = LocalDateTime.now();
    }

    // Inner class for supply readings
    public static class SupplyReading {
        private LocalDateTime timestamp;
        private double pressure;
        private double flowRate;
        private double temperature;
        private double quality;

        public SupplyReading(double pressure, double flowRate, double temperature, double quality) {
            this.timestamp = LocalDateTime.now();
            this.pressure = pressure;
            this.flowRate = flowRate;
            this.temperature = temperature;
            this.quality = quality;
        }

        // Getters
        public LocalDateTime getTimestamp() {
            return timestamp;
        }

        public double getPressure() {
            return pressure;
        }

        public double getFlowRate() {
            return flowRate;
        }

        public double getTemperature() {
            return temperature;
        }

        public double getQuality() {
            return quality;
        }
    }

    // Inner class for supply alerts
    public static class SupplyAlert {
        private String alertId;
        private LocalDateTime timestamp;
        private String type;
        private String description;
        private String severity;
        private boolean isResolved;
        private LocalDateTime resolvedTime;
        private String resolution;

        public SupplyAlert(String alertId, String type, String description, String severity) {
            this.alertId = alertId;
            this.type = type;
            this.description = description;
            this.severity = severity;
            this.timestamp = LocalDateTime.now();
            this.isResolved = false;
        }

        public void resolve(String resolution) {
            this.isResolved = true;
            this.resolvedTime = LocalDateTime.now();
            this.resolution = resolution;
        }

        // Getters and setters
        public String getAlertId() {
            return alertId;
        }

        public LocalDateTime getTimestamp() {
            return timestamp;
        }

        public String getType() {
            return type;
        }

        public String getDescription() {
            return description;
        }

        public String getSeverity() {
            return severity;
        }

        public boolean isResolved() {
            return isResolved;
        }

        public LocalDateTime getResolvedTime() {
            return resolvedTime;
        }

        public String getResolution() {
            return resolution;
        }
    }

    public void addReading(double pressure, double flowRate, double temperature, double quality) {
        SupplyReading reading = new SupplyReading(pressure, flowRate, temperature, quality);
        readings.add(reading);
        updateCurrentMetrics(reading);
    }

    private void updateCurrentMetrics(SupplyReading reading) {
        this.currentPressure = reading.getPressure();
        this.flowRate = reading.getFlowRate();
        this.temperature = reading.getTemperature();
        this.quality = reading.getQuality();
        this.lastUpdated = reading.getTimestamp();
        checkAlerts();
    }

    private void checkAlerts() {
        if (currentPressure < 0.8 * capacity) {
            createAlert("LOW_PRESSURE", "Supply pressure below threshold", "HIGH");
        }
        if (quality < 0.95) {
            createAlert("QUALITY_ISSUE", "Gas quality below standard", "HIGH");
        }
    }

    public void createAlert(String type, String description, String severity) {
        SupplyAlert alert = new SupplyAlert(
            "ALERT_" + System.currentTimeMillis(),
            type,
            description,
            severity
        );
        alerts.add(alert);
    }

    public void updateMaintenanceStatus(String status) {
        this.maintenanceStatus = status;
        if ("MAINTENANCE".equals(status)) {
            this.isOperational = false;
            this.status = "UNDER_MAINTENANCE";
        } else if ("COMPLETED".equals(status)) {
            this.isOperational = true;
            this.status = "OPERATIONAL";
        }
    }

    // Getters and setters
    public String getSupplyId() {
        return supplyId;
    }

    public String getZoneId() {
        return zoneId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getCurrentPressure() {
        return currentPressure;
    }

    public double getFlowRate() {
        return flowRate;
    }

    public double getTemperature() {
        return temperature;
    }

    public double getQuality() {
        return quality;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public List<SupplyReading> getReadings() {
        return new ArrayList<>(readings);
    }

    public List<SupplyAlert> getAlerts() {
        return new ArrayList<>(alerts);
    }

    public boolean isOperational() {
        return isOperational;
    }

    public String getMaintenanceStatus() {
        return maintenanceStatus;
    }

    public double getTotalSupply() {
        return totalSupply;
    }

    public void setTotalSupply(double totalSupply) {
        this.totalSupply = totalSupply;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public double getUtilizationRate() {
        return capacity > 0 ? (totalSupply / capacity) * 100 : 0;
    }
}
