package org.example.first_project.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import org.example.first_project.TitasGasApp;
import org.example.first_project.models.*;
import org.example.first_project.services.DirectorService;
import org.example.first_project.services.UtilityService;

import java.io.IOException;
import java.util.List;

public class DirectorDashboardController {
    @FXML
    private Label welcomeLabel;
    
    @FXML
    private VBox dashboardContent;
    
    @FXML
    private Label systemStatusLabel;
    
    @FXML
    private Label customerCountLabel;
    
    @FXML
    private Label revenueLabel;

    private DirectorService directorService; // Will be injected
    private UtilityService utilityService; // Will be injected

    @FXML
    private void initialize() {
        loadDashboardData();
    }

    private void loadDashboardData() {
        try {
            // Set welcome message
            User currentUser = TitasGasApp.getInstance().getCurrentUser();
            welcomeLabel.setText("Welcome, " + currentUser.getUsername());

            // Load system metrics
            systemStatusLabel.setText("System Efficiency: " + 
                String.format("%.2f%%", directorService.getOverallSystemEfficiency()));
            customerCountLabel.setText("Total Customers: " + directorService.getTotalCustomers());
            revenueLabel.setText("Total Revenue: $" + 
                String.format("%.2f", directorService.getTotalRevenue()));

            // Load alerts and notifications
            loadActiveAlerts();
            loadPendingApprovals();

        } catch (Exception e) {
            showError("Error", "Failed to load dashboard data");
            utilityService.logSystemError("Dashboard Load Error", e.toString());
        }
    }

    @FXML
    private void handleBudgetManagement() {
        try {
            List<Budget> pendingBudgets = directorService.getPendingBudgets();
            // Navigate to budget management view
            // Implementation depends on your navigation system
        } catch (Exception e) {
            showError("Error", "Failed to load budget data");
        }
    }

    @FXML
    private void handlePolicyManagement() {
        try {
            List<Policy> pendingPolicies = directorService.getPendingPolicies();
            // Navigate to policy management view
        } catch (Exception e) {
            showError("Error", "Failed to load policy data");
        }
    }

    @FXML
    private void handleEmergencyManagement() {
        try {
            List<Incident> activeIncidents = directorService.getActiveIncidents();
            // Navigate to emergency management view
        } catch (Exception e) {
            showError("Error", "Failed to load incident data");
        }
    }

    @FXML
    private void handleSystemMonitoring() {
        try {
            List<Zone> zones = directorService.getAllZones();
            List<GasSupply> supplyStatus = directorService.getSupplyStatus();
            // Navigate to system monitoring view
        } catch (Exception e) {
            showError("Error", "Failed to load system data");
        }
    }

    @FXML
    private void handleReportGeneration() {
        try {
            // Show report generation dialog
        } catch (Exception e) {
            showError("Error", "Failed to generate report");
        }
    }

    @FXML
    private void handlePerformanceAnalysis() {
        try {
            List<Zone> underperformingZones = directorService.getUnderperformingZones();
            // Navigate to performance analysis view
        } catch (Exception e) {
            showError("Error", "Failed to load performance data");
        }
    }

    private void loadActiveAlerts() {
        try {
            List<SupplyAlert> alerts = directorService.getActiveAlerts();
            // Update alerts section in the dashboard
        } catch (Exception e) {
            utilityService.logSystemError("Alert Load Error", e.toString());
        }
    }

    private void loadPendingApprovals() {
        try {
            List<Budget> pendingBudgets = directorService.getPendingBudgets();
            List<Policy> pendingPolicies = directorService.getPendingPolicies();
            // Update pending approvals section
        } catch (Exception e) {
            utilityService.logSystemError("Approvals Load Error", e.toString());
        }
    }

    @FXML
    private void handleLogout() {
        try {
            utilityService.logUserAction(
                TitasGasApp.getInstance().getCurrentUser().getUserId(),
                "LOGOUT",
                "User logged out"
            );
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

    // Setters for dependency injection
    public void setDirectorService(DirectorService directorService) {
        this.directorService = directorService;
    }

    public void setUtilityService(UtilityService utilityService) {
        this.utilityService = utilityService;
    }
}
