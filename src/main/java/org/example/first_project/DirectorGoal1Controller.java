package org.example.first_project;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DirectorGoal1Controller {
    
    @FXML
    private Label activeConnectionsLabel;
    
    @FXML
    private Label complaintsLabel;
    
    @FXML
    private Label billingLabel;
    
    @FXML
    private Label supplyLabel;
    
    @FXML
    private ComboBox<String> divisionComboBox;
    
    @FXML
    private ComboBox<String> timeframeComboBox;
    
    @FXML
    private ComboBox<String> departmentComboBox;
    
    @FXML
    public void initialize() {
        // Initialize combo boxes
        ObservableList<String> divisions = FXCollections.observableArrayList(
            "Dhaka Division", "Chittagong Division", "Rajshahi Division", 
            "Khulna Division", "Barisal Division", "Sylhet Division", 
            "Rangpur Division", "Mymensingh Division"
        );
        divisionComboBox.setItems(divisions);
        
        ObservableList<String> timeframes = FXCollections.observableArrayList(
            "Today", "This Week", "This Month", "Last Month", "This Quarter", "This Year"
        );
        timeframeComboBox.setItems(timeframes);
        
        ObservableList<String> departments = FXCollections.observableArrayList(
            "Operations", "Customer Service", "Billing", "Technical", "Maintenance", "Finance"
        );
        departmentComboBox.setItems(departments);
    }
    
    @FXML
    private void goBack() {
        Stage stage = (Stage) activeConnectionsLabel.getScene().getWindow();
        stage.close();
    }
    
    @FXML
    private void viewConnections() {
        showAlert("Active Connections", "Total Active Connections: 1,234\n\n" +
                "• New Connections: 156\n" +
                "• Disconnections: 23\n" +
                "• Maintenance: 45\n" +
                "• Emergency: 8");
    }
    
    @FXML
    private void viewComplaints() {
        showAlert("Pending Complaints", "Total Pending Complaints: 45\n\n" +
                "• High Priority: 12\n" +
                "• Medium Priority: 18\n" +
                "• Low Priority: 15\n" +
                "• Average Resolution Time: 2.3 days");
    }
    
    @FXML
    private void viewBilling() {
        showAlert("Billing Issues", "Total Billing Issues: 12\n\n" +
                "• Overbilling: 5\n" +
                "• Underbilling: 3\n" +
                "• Payment Disputes: 4\n" +
                "• Resolution Rate: 85%");
    }
    
    @FXML
    private void viewSupply() {
        showAlert("Supply Issues", "Total Supply Issues: 3\n\n" +
                "• Pipeline Leaks: 1\n" +
                "• Pressure Problems: 1\n" +
                "• Equipment Failure: 1\n" +
                "• Response Time: 4.2 hours");
    }
    
    @FXML
    private void applyFilters() {
        String division = divisionComboBox.getValue();
        String timeframe = timeframeComboBox.getValue();
        String department = departmentComboBox.getValue();
        
        if (division == null && timeframe == null && department == null) {
            showAlert("Filter Warning", "Please select at least one filter criteria.");
            return;
        }
        
        // Simulate data filtering
        String message = "Filters Applied:\n";
        if (division != null) message += "• Division: " + division + "\n";
        if (timeframe != null) message += "• Timeframe: " + timeframe + "\n";
        if (department != null) message += "• Department: " + department + "\n";
        
        message += "\nUpdated Dashboard Data:\n";
        message += "• Active Connections: 1,156\n";
        message += "• Pending Complaints: 38\n";
        message += "• Billing Issues: 9\n";
        message += "• Supply Issues: 2";
        
        showAlert("Filter Results", message);
    }
    
    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
