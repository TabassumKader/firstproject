package org.example.first_project.models;

import java.util.ArrayList;
import java.util.List;

public class Zone {
    private String zoneId;
    private String name;
    private String description;
    private String status;
    private double supplyPressure;
    private double minimumPressure;
    private double maximumPressure;
    private int customerCount;
    private List<String> areas;
    private List<String> substations;
    private List<MaintenanceSchedule> maintenanceSchedules;
    private boolean isActive;
    private String supervisor;
    private double monthlyConsumption;
    private double capacityUtilization;

    public Zone(String zoneId, String name, String description) {
        this.zoneId = zoneId;
        this.name = name;
        this.description = description;
        this.status = "OPERATIONAL";
        this.supplyPressure = 0.0;
        this.minimumPressure = 0.0;
        this.maximumPressure = 0.0;
        this.customerCount = 0;
        this.areas = new ArrayList<>();
        this.substations = new ArrayList<>();
        this.maintenanceSchedules = new ArrayList<>();
        this.isActive = true;
        this.monthlyConsumption = 0.0;
        this.capacityUtilization = 0.0;
    }

    // Inner class for maintenance schedules
    public static class MaintenanceSchedule {
        private String scheduleId;
        private String type;
        private String description;
        private String frequency;
        private String lastMaintenance;
        private String nextMaintenance;
        private String assignedTeam;
        private String status;

        public MaintenanceSchedule(String scheduleId, String type, String description, String frequency) {
            this.scheduleId = scheduleId;
            this.type = type;
            this.description = description;
            this.frequency = frequency;
            this.status = "SCHEDULED";
        }

        // Getters and setters
        public String getScheduleId() {
            return scheduleId;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getFrequency() {
            return frequency;
        }

        public void setFrequency(String frequency) {
            this.frequency = frequency;
        }

        public String getLastMaintenance() {
            return lastMaintenance;
        }

        public void setLastMaintenance(String lastMaintenance) {
            this.lastMaintenance = lastMaintenance;
        }

        public String getNextMaintenance() {
            return nextMaintenance;
        }

        public void setNextMaintenance(String nextMaintenance) {
            this.nextMaintenance = nextMaintenance;
        }

        public String getAssignedTeam() {
            return assignedTeam;
        }

        public void setAssignedTeam(String assignedTeam) {
            this.assignedTeam = assignedTeam;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }

    public void addArea(String area) {
        if (!areas.contains(area)) {
            areas.add(area);
        }
    }

    public void addSubstation(String substation) {
        if (!substations.contains(substation)) {
            substations.add(substation);
        }
    }

    public void addMaintenanceSchedule(MaintenanceSchedule schedule) {
        maintenanceSchedules.add(schedule);
    }

    public void updateSupplyStatus(String status, double pressure) {
        this.status = status;
        this.supplyPressure = pressure;
    }

    public void updateCapacityUtilization(double consumption, int customers) {
        this.monthlyConsumption = consumption;
        this.customerCount = customers;
        // Assuming a standard capacity metric
        this.capacityUtilization = (consumption / (customers * 100)) * 100;
    }

    // Getters and setters
    public String getZoneId() {
        return zoneId;
    }

    public void setZoneId(String zoneId) {
        this.zoneId = zoneId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getSupplyPressure() {
        return supplyPressure;
    }

    public void setSupplyPressure(double supplyPressure) {
        this.supplyPressure = supplyPressure;
    }

    public double getMinimumPressure() {
        return minimumPressure;
    }

    public void setMinimumPressure(double minimumPressure) {
        this.minimumPressure = minimumPressure;
    }

    public double getMaximumPressure() {
        return maximumPressure;
    }

    public void setMaximumPressure(double maximumPressure) {
        this.maximumPressure = maximumPressure;
    }

    public int getCustomerCount() {
        return customerCount;
    }

    public List<String> getAreas() {
        return new ArrayList<>(areas);
    }

    public List<String> getSubstations() {
        return new ArrayList<>(substations);
    }

    public List<MaintenanceSchedule> getMaintenanceSchedules() {
        return new ArrayList<>(maintenanceSchedules);
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    public double getMonthlyConsumption() {
        return monthlyConsumption;
    }

    public double getCapacityUtilization() {
        return capacityUtilization;
    }
}
