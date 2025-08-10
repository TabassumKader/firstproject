package org.example.first_project.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import org.example.first_project.TitasGasApp;
import org.example.first_project.models.*;
import org.example.first_project.services.CustomerService;
import org.example.first_project.services.UtilityService;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class CustomerDashboardController {
    @FXML
    private Label welcomeLabel;
    
    @FXML
    private Label customerIdLabel;
    
    @FXML
    private Label connectionStatusLabel;
    
    @FXML
    private Label meterNumberLabel;
    
    @FXML
    private Label currentReadingLabel;
    
    @FXML
    private Label billAmountLabel;

    @FXML
    private ListView<Bill> billsList;
    
    @FXML
    private ListView<Complaint> complaintsList;

    private CustomerService customerService; // Will be injected
    private UtilityService utilityService; // Will be injected
    private String customerId;

    @FXML
    private void initialize() {
        customerId = TitasGasApp.getInstance().getCurrentUser().getUserId();
        loadDashboardData();
    }

    private void loadDashboardData() {
        try {
            // Load customer profile
            DomesticCustomer customer = customerService.getCustomerProfile(customerId);
            welcomeLabel.setText("Welcome, " + customer.getUsername());
            customerIdLabel.setText("Customer ID: " + customer.getCustomerId());
            connectionStatusLabel.setText("Status: " + customer.getConnectionStatus());

            // Load meter details
            Meter meter = customerService.getMeterDetails(customerId);
            if (meter != null) {
                meterNumberLabel.setText("Meter No: " + meter.getMeterNumber());
                currentReadingLabel.setText("Current Reading: " + 
                    customerService.getCurrentReading(customerId));
            }

            // Load current bill
            Bill currentBill = customerService.getCurrentBill(customerId);
            if (currentBill != null) {
                billAmountLabel.setText("Current Bill: $" + 
                    String.format("%.2f", currentBill.getTotalAmount()));
            }

            loadBillHistory();
            loadComplaints();

        } catch (Exception e) {
            showError("Error", "Failed to load dashboard data");
            utilityService.logSystemError("Customer Dashboard Load Error", e.toString());
        }
    }

    @FXML
    private void handlePayBill() {
        try {
            Bill currentBill = customerService.getCurrentBill(customerId);
            if (currentBill != null && !currentBill.isPaid()) {
                // Show payment dialog
                // Implementation depends on your payment workflow
            } else {
                showInfo("Bill Payment", "No pending bills to pay");
            }
        } catch (Exception e) {
            showError("Error", "Failed to process bill payment");
        }
    }

    @FXML
    private void handleSubmitComplaint() {
        try {
            // Show complaint submission dialog
            // Implementation depends on your complaint workflow
        } catch (Exception e) {
            showError("Error", "Failed to submit complaint");
        }
    }

    @FXML
    private void handleBookTechnician() {
        try {
            List<String> availableSlots = customerService.getAvailableTimeSlots(LocalDate.now());
            // Show technician booking dialog
        } catch (Exception e) {
            showError("Error", "Failed to load available time slots");
        }
    }

    @FXML
    private void handleViewConsumption() {
        try {
            List<Double> history = customerService.getConsumptionHistory(customerId, 12);
            // Show consumption history dialog
        } catch (Exception e) {
            showError("Error", "Failed to load consumption history");
        }
    }

    @FXML
    private void handleUpdateProfile() {
        try {
            DomesticCustomer profile = customerService.getCustomerProfile(customerId);
            // Show profile update dialog
        } catch (Exception e) {
            showError("Error", "Failed to load profile data");
        }
    }

    @FXML
    private void handleViewDocuments() {
        try {
            List<String> documents = customerService.getAvailableDocuments(customerId);
            // Show documents dialog
        } catch (Exception e) {
            showError("Error", "Failed to load documents");
        }
    }

    private void loadBillHistory() {
        try {
            List<Bill> bills = customerService.getCustomerBills(customerId);
            billsList.getItems().setAll(bills);
        } catch (Exception e) {
            utilityService.logSystemError("Bill History Load Error", e.toString());
        }
    }

    private void loadComplaints() {
        try {
            List<Complaint> complaints = customerService.getCustomerComplaints(customerId);
            complaintsList.getItems().setAll(complaints);
        } catch (Exception e) {
            utilityService.logSystemError("Complaints Load Error", e.toString());
        }
    }

    @FXML
    private void handleLogout() {
        try {
            utilityService.logUserAction(customerId, "LOGOUT", "Customer logged out");
            TitasGasApp.getInstance().logout();
        } catch (IOException e) {
            showError("Error", "Failed to logout");
        }
    }

    private void showError(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    private void showInfo(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    // Setters for dependency injection
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    public void setUtilityService(UtilityService utilityService) {
        this.utilityService = utilityService;
    }
}
