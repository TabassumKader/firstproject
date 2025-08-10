package org.example.first_project.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Policy {
    private String policyId;
    private String title;
    private String description;
    private String category;
    private String status;
    private LocalDateTime creationDate;
    private LocalDateTime effectiveDate;
    private LocalDateTime expirationDate;
    private String createdBy;
    private String approvedBy;
    private LocalDateTime approvalDate;
    private List<PolicyRevision> revisions;
    private int currentVersion;
    private boolean isActive;
    private List<String> departments;

    public Policy(String policyId, String title, String description, String category) {
        this.policyId = policyId;
        this.title = title;
        this.description = description;
        this.category = category;
        this.status = "DRAFT";
        this.creationDate = LocalDateTime.now();
        this.revisions = new ArrayList<>();
        this.currentVersion = 1;
        this.isActive = false;
        this.departments = new ArrayList<>();
        addRevision("Initial policy creation");
    }

    public void addRevision(String revisionNotes) {
        PolicyRevision revision = new PolicyRevision(
            currentVersion,
            LocalDateTime.now(),
            revisionNotes
        );
        revisions.add(revision);
        currentVersion++;
    }

    public void approve(String approverId) {
        this.approvedBy = approverId;
        this.approvalDate = LocalDateTime.now();
        this.status = "APPROVED";
        this.isActive = true;
        addRevision("Policy approved");
    }

    public void reject(String approverId, String reason) {
        this.approvedBy = approverId;
        this.approvalDate = LocalDateTime.now();
        this.status = "REJECTED";
        addRevision("Policy rejected: " + reason);
    }

    public void deactivate(String reason) {
        this.isActive = false;
        this.status = "INACTIVE";
        addRevision("Policy deactivated: " + reason);
    }

    public void addDepartment(String department) {
        if (!departments.contains(department)) {
            departments.add(department);
        }
    }

    public void removeDepartment(String department) {
        departments.remove(department);
    }

    // Inner class for policy revisions
    public static class PolicyRevision {
        private int version;
        private LocalDateTime revisionDate;
        private String revisionNotes;

        public PolicyRevision(int version, LocalDateTime revisionDate, String revisionNotes) {
            this.version = version;
            this.revisionDate = revisionDate;
            this.revisionNotes = revisionNotes;
        }

        // Getters
        public int getVersion() {
            return version;
        }

        public LocalDateTime getRevisionDate() {
            return revisionDate;
        }

        public String getRevisionNotes() {
            return revisionNotes;
        }
    }

    // Getters and setters
    public String getPolicyId() {
        return policyId;
    }

    public void setPolicyId(String policyId) {
        this.policyId = policyId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public LocalDateTime getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(LocalDateTime effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDateTime expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getApprovedBy() {
        return approvedBy;
    }

    public LocalDateTime getApprovalDate() {
        return approvalDate;
    }

    public List<PolicyRevision> getRevisions() {
        return new ArrayList<>(revisions);
    }

    public int getCurrentVersion() {
        return currentVersion;
    }

    public boolean isActive() {
        return isActive;
    }

    public List<String> getDepartments() {
        return new ArrayList<>(departments);
    }
}
