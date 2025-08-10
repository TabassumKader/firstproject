package org.example.first_project.models;

import java.time.LocalDateTime;

public class Complaint {
    private String complaintId;
    private String customerId;
    private String meterNumber;
    private String category;
    private String description;
    private String status;
    private LocalDateTime submissionDate;
    private LocalDateTime resolutionDate;
    private String assignedTo;
    private String priority;
    private String resolution;
    private String feedback;
    private int customerSatisfaction;

    public Complaint(String complaintId, String customerId, String category, String description) {
        this.complaintId = complaintId;
        this.customerId = customerId;
        this.category = category;
        this.description = description;
        this.status = "PENDING";
        this.submissionDate = LocalDateTime.now();
        this.priority = "MEDIUM";
    }

    public void assignTechnician(String technicianId) {
        this.assignedTo = technicianId;
        this.status = "ASSIGNED";
    }

    public void updateStatus(String status, String resolution) {
        this.status = status;
        this.resolution = resolution;
        if (status.equals("RESOLVED")) {
            this.resolutionDate = LocalDateTime.now();
        }
    }

    public void provideFeedback(String feedback, int satisfaction) {
        this.feedback = feedback;
        this.customerSatisfaction = satisfaction;
    }

    // Getters and setters
    public String getComplaintId() {
        return complaintId;
    }

    public void setComplaintId(String complaintId) {
        this.complaintId = complaintId;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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

    public LocalDateTime getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(LocalDateTime submissionDate) {
        this.submissionDate = submissionDate;
    }

    public LocalDateTime getResolutionDate() {
        return resolutionDate;
    }

    public void setResolutionDate(LocalDateTime resolutionDate) {
        this.resolutionDate = resolutionDate;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public int getCustomerSatisfaction() {
        return customerSatisfaction;
    }

    public void setCustomerSatisfaction(int customerSatisfaction) {
        this.customerSatisfaction = customerSatisfaction;
    }
}
