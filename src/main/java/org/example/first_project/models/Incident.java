package org.example.first_project.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Incident {
    private String incidentId;
    private String type;
    private String location;
    private String description;
    private String severity;
    private String status;
    private LocalDateTime reportedTime;
    private LocalDateTime resolvedTime;
    private String reportedBy;
    private String assignedTo;
    private List<String> affectedAreas;
    private List<String> affectedCustomers;
    private List<Response> responses;
    private String resolution;
    private boolean isEmergency;
    private String impact;
    private int casualtyCount;
    private double estimatedCost;

    public Incident(String incidentId, String type, String location, String description, String severity) {
        this.incidentId = incidentId;
        this.type = type;
        this.location = location;
        this.description = description;
        this.severity = severity;
        this.status = "REPORTED";
        this.reportedTime = LocalDateTime.now();
        this.affectedAreas = new ArrayList<>();
        this.affectedCustomers = new ArrayList<>();
        this.responses = new ArrayList<>();
        this.isEmergency = "HIGH".equals(severity);
        this.casualtyCount = 0;
        this.estimatedCost = 0.0;
    }

    // Inner class to track incident responses
    public static class Response {
        private String responseId;
        private LocalDateTime timestamp;
        private String responderId;
        private String action;
        private String result;
        private String notes;

        public Response(String responseId, String responderId, String action) {
            this.responseId = responseId;
            this.responderId = responderId;
            this.action = action;
            this.timestamp = LocalDateTime.now();
        }

        // Getters and setters
        public String getResponseId() {
            return responseId;
        }

        public LocalDateTime getTimestamp() {
            return timestamp;
        }

        public String getResponderId() {
            return responderId;
        }

        public String getAction() {
            return action;
        }

        public void setAction(String action) {
            this.action = action;
        }

        public String getResult() {
            return result;
        }

        public void setResult(String result) {
            this.result = result;
        }

        public String getNotes() {
            return notes;
        }

        public void setNotes(String notes) {
            this.notes = notes;
        }
    }

    public void addResponse(Response response) {
        responses.add(response);
    }

    public void escalate(String reason) {
        this.severity = "HIGH";
        this.isEmergency = true;
        addResponse(new Response(
            "ESCALATION_" + System.currentTimeMillis(),
            "SYSTEM",
            "Incident escalated: " + reason
        ));
    }

    public void resolve(String resolution) {
        this.resolution = resolution;
        this.status = "RESOLVED";
        this.resolvedTime = LocalDateTime.now();
    }

    public void addAffectedArea(String area) {
        if (!affectedAreas.contains(area)) {
            affectedAreas.add(area);
        }
    }

    public void addAffectedCustomer(String customerId) {
        if (!affectedCustomers.contains(customerId)) {
            affectedCustomers.add(customerId);
        }
    }

    // Getters and setters
    public String getIncidentId() {
        return incidentId;
    }

    public void setIncidentId(String incidentId) {
        this.incidentId = incidentId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
        this.isEmergency = "HIGH".equals(severity);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getReportedTime() {
        return reportedTime;
    }

    public LocalDateTime getResolvedTime() {
        return resolvedTime;
    }

    public String getReportedBy() {
        return reportedBy;
    }

    public void setReportedBy(String reportedBy) {
        this.reportedBy = reportedBy;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public List<String> getAffectedAreas() {
        return new ArrayList<>(affectedAreas);
    }

    public List<String> getAffectedCustomers() {
        return new ArrayList<>(affectedCustomers);
    }

    public List<Response> getResponses() {
        return new ArrayList<>(responses);
    }

    public String getResolution() {
        return resolution;
    }

    public boolean isEmergency() {
        return isEmergency;
    }

    public String getImpact() {
        return impact;
    }

    public void setImpact(String impact) {
        this.impact = impact;
    }

    public int getCasualtyCount() {
        return casualtyCount;
    }

    public void setCasualtyCount(int casualtyCount) {
        this.casualtyCount = casualtyCount;
    }

    public double getEstimatedCost() {
        return estimatedCost;
    }

    public void setEstimatedCost(double estimatedCost) {
        this.estimatedCost = estimatedCost;
    }
}
