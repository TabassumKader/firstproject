package org.example.first_project.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Budget {
    private String budgetId;
    private String title;
    private String department;
    private double allocatedAmount;
    private double utilizedAmount;
    private LocalDate fiscalYearStart;
    private LocalDate fiscalYearEnd;
    private String status;
    private String approvedBy;
    private LocalDate approvalDate;
    private String description;
    private List<BudgetItem> items;

    public Budget(String budgetId, String title, String department, double allocatedAmount) {
        this.budgetId = budgetId;
        this.title = title;
        this.department = department;
        this.allocatedAmount = allocatedAmount;
        this.utilizedAmount = 0.0;
        this.status = "DRAFT";
        this.items = new ArrayList<>();
        setFiscalYear(LocalDate.now().getYear());
    }

    private void setFiscalYear(int year) {
        // Fiscal year from July to June
        if (LocalDate.now().getMonthValue() > 6) {
            this.fiscalYearStart = LocalDate.of(year, 7, 1);
            this.fiscalYearEnd = LocalDate.of(year + 1, 6, 30);
        } else {
            this.fiscalYearStart = LocalDate.of(year - 1, 7, 1);
            this.fiscalYearEnd = LocalDate.of(year, 6, 30);
        }
    }

    public void addBudgetItem(BudgetItem item) {
        items.add(item);
        recalculateUtilizedAmount();
    }

    public void removeBudgetItem(BudgetItem item) {
        items.remove(item);
        recalculateUtilizedAmount();
    }

    private void recalculateUtilizedAmount() {
        this.utilizedAmount = items.stream()
                .mapToDouble(BudgetItem::getAmount)
                .sum();
    }

    public double getRemainingAmount() {
        return allocatedAmount - utilizedAmount;
    }

    public void approve(String approverId) {
        this.approvedBy = approverId;
        this.approvalDate = LocalDate.now();
        this.status = "APPROVED";
    }

    public void reject(String approverId) {
        this.approvedBy = approverId;
        this.approvalDate = LocalDate.now();
        this.status = "REJECTED";
    }

    // Inner class for budget items
    public static class BudgetItem {
        private String itemId;
        private String description;
        private double amount;
        private String category;
        private String status;

        public BudgetItem(String itemId, String description, double amount, String category) {
            this.itemId = itemId;
            this.description = description;
            this.amount = amount;
            this.category = category;
            this.status = "PENDING";
        }

        // Getters and setters
        public String getItemId() {
            return itemId;
        }

        public void setItemId(String itemId) {
            this.itemId = itemId;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
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
    }

    // Getters and setters
    public String getBudgetId() {
        return budgetId;
    }

    public void setBudgetId(String budgetId) {
        this.budgetId = budgetId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getAllocatedAmount() {
        return allocatedAmount;
    }

    public void setAllocatedAmount(double allocatedAmount) {
        this.allocatedAmount = allocatedAmount;
    }

    public double getUtilizedAmount() {
        return utilizedAmount;
    }

    public LocalDate getFiscalYearStart() {
        return fiscalYearStart;
    }

    public LocalDate getFiscalYearEnd() {
        return fiscalYearEnd;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getApprovedBy() {
        return approvedBy;
    }

    public LocalDate getApprovalDate() {
        return approvalDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<BudgetItem> getItems() {
        return new ArrayList<>(items);
    }
}
