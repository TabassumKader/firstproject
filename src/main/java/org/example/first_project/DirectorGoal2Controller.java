package org.example.first_project;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;

public class DirectorGoal2Controller {
    
    @FXML
    private TableView<BudgetProposal> budgetTable;
    
    @FXML
    private TableColumn<BudgetProposal, String> proposalIdColumn;
    
    @FXML
    private TableColumn<BudgetProposal, String> departmentColumn;
    
    @FXML
    private TableColumn<BudgetProposal, String> amountColumn;
    
    @FXML
    private TableColumn<BudgetProposal, String> statusColumn;
    
    @FXML
    private TableColumn<BudgetProposal, String> actionColumn;
    
    @FXML
    private TextArea remarksArea;
    
    @FXML
    public void initialize() {
        // Set up table columns
        proposalIdColumn.setCellValueFactory(new PropertyValueFactory<>("proposalId"));
        departmentColumn.setCellValueFactory(new PropertyValueFactory<>("department"));
        amountColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        actionColumn.setCellValueFactory(new PropertyValueFactory<>("action"));
        
        // Load initial data
        loadBudgetProposals();
    }
    
    @FXML
    private void goBack() {
        Stage stage = (Stage) budgetTable.getScene().getWindow();
        stage.close();
    }
    
    @FXML
    private void refreshProposals() {
        loadBudgetProposals();
        showAlert("Success", "Budget proposals refreshed successfully.");
    }
    
    @FXML
    private void viewProposalDetails() {
        BudgetProposal selected = budgetTable.getSelectionModel().getSelectedItem();
        if (selected == null) {
            showAlert("Warning", "Please select a proposal to view details.");
            return;
        }
        
        String details = "Proposal Details:\n\n" +
                "Proposal ID: " + selected.getProposalId() + "\n" +
                "Department: " + selected.getDepartment() + "\n" +
                "Amount: " + selected.getAmount() + "\n" +
                "Status: " + selected.getStatus() + "\n\n" +
                "Breakdown:\n" +
                "• Equipment: 40%\n" +
                "• Labor: 30%\n" +
                "• Materials: 20%\n" +
                "• Contingency: 10%\n\n" +
                "Justification: This budget is required for network expansion and maintenance.";
        
        showAlert("Proposal Details", details);
    }
    
    @FXML
    private void approveSelected() {
        BudgetProposal selected = budgetTable.getSelectionModel().getSelectedItem();
        if (selected == null) {
            showAlert("Warning", "Please select a proposal to approve.");
            return;
        }
        
        if (remarksArea.getText().trim().isEmpty()) {
            showAlert("Warning", "Please add remarks before approving.");
            return;
        }
        
        selected.setStatus("Approved");
        selected.setAction("Approved");
        budgetTable.refresh();
        
        showAlert("Success", "Proposal " + selected.getProposalId() + " has been approved.");
    }
    
    @FXML
    private void requestModification() {
        BudgetProposal selected = budgetTable.getSelectionModel().getSelectedItem();
        if (selected == null) {
            showAlert("Warning", "Please select a proposal to request modification.");
            return;
        }
        
        if (remarksArea.getText().trim().isEmpty()) {
            showAlert("Warning", "Please add remarks for modification request.");
            return;
        }
        
        selected.setStatus("Modification Requested");
        selected.setAction("Modification Requested");
        budgetTable.refresh();
        
        showAlert("Success", "Modification requested for proposal " + selected.getProposalId());
    }
    
    @FXML
    private void signAndSubmit() {
        if (remarksArea.getText().trim().isEmpty()) {
            showAlert("Warning", "Please add remarks before signing.");
            return;
        }
        
        showAlert("Success", "Digital signature applied and remarks submitted successfully.");
    }
    
    private void loadBudgetProposals() {
        ObservableList<BudgetProposal> proposals = FXCollections.observableArrayList(
            new BudgetProposal("BP001", "Engineering", "5,000,000 BDT", "Pending", "Review"),
            new BudgetProposal("BP002", "Finance", "3,200,000 BDT", "Pending", "Review"),
            new BudgetProposal("BP003", "Operations", "2,800,000 BDT", "Pending", "Review"),
            new BudgetProposal("BP004", "Technical", "4,500,000 BDT", "Pending", "Review"),
            new BudgetProposal("BP005", "Maintenance", "1,800,000 BDT", "Pending", "Review")
        );
        
        budgetTable.setItems(proposals);
    }
    
    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
    
    // Inner class for budget proposal data
    public static class BudgetProposal {
        private String proposalId;
        private String department;
        private String amount;
        private String status;
        private String action;
        
        public BudgetProposal(String proposalId, String department, String amount, String status, String action) {
            this.proposalId = proposalId;
            this.department = department;
            this.amount = amount;
            this.status = status;
            this.action = action;
        }
        
        // Getters and setters
        public String getProposalId() { return proposalId; }
        public void setProposalId(String proposalId) { this.proposalId = proposalId; }
        
        public String getDepartment() { return department; }
        public void setDepartment(String department) { this.department = department; }
        
        public String getAmount() { return amount; }
        public void setAmount(String amount) { this.amount = amount; }
        
        public String getStatus() { return status; }
        public void setStatus(String status) { this.status = status; }
        
        public String getAction() { return action; }
        public void setAction(String action) { this.action = action; }
    }
}
