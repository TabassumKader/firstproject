package org.example.first_project.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.example.first_project.TitasGasApp;
import org.example.first_project.models.User;
import org.example.first_project.services.UtilityService;

public class LoginController {
    @FXML
    private TextField usernameField;
    
    @FXML
    private PasswordField passwordField;
    
    @FXML
    private Button loginButton;

    private UtilityService utilityService; // Will be injected

    @FXML
    private void initialize() {
        // Add any initialization logic here
        loginButton.setOnAction(event -> handleLogin());
    }

    @FXML
    private void handleLogin() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (username.isEmpty() || password.isEmpty()) {
            showError("Error", "Please enter both username and password.");
            return;
        }

        try {
            User user = utilityService.authenticateUser(username, password);
            if (user != null) {
                TitasGasApp.getInstance().setCurrentUser(user);
                utilityService.updateLastLogin(user.getUserId());
                utilityService.logUserAction(user.getUserId(), "LOGIN", "User logged in successfully");

                // Redirect based on user role
                if ("MANAGING_DIRECTOR".equals(user.getRole())) {
                    TitasGasApp.getInstance().showDirectorDashboard();
                } else if ("DOMESTIC_CUSTOMER".equals(user.getRole())) {
                    TitasGasApp.getInstance().showCustomerDashboard();
                } else {
                    showError("Error", "Invalid user role");
                }
            } else {
                showError("Authentication Failed", "Invalid username or password.");
                utilityService.logSecurityEvent(username, "FAILED_LOGIN", "Authentication failed for user");
            }
        } catch (Exception e) {
            showError("System Error", "An error occurred during login. Please try again.");
            utilityService.logSystemError("Login Error", e.toString());
        }
    }

    @FXML
    private void handleForgotPassword() {
        String username = usernameField.getText();
        if (username.isEmpty()) {
            showError("Error", "Please enter your username to reset password.");
            return;
        }

        try {
            // In a real application, this would trigger a password reset workflow
            showInfo("Password Reset", "If the username exists, you will receive password reset instructions via email.");
            utilityService.logUserAction(username, "PASSWORD_RESET_REQUEST", "User requested password reset");
        } catch (Exception e) {
            showError("System Error", "An error occurred. Please try again later.");
            utilityService.logSystemError("Password Reset Error", e.toString());
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

    // Setter for dependency injection
    public void setUtilityService(UtilityService utilityService) {
        this.utilityService = utilityService;
    }
}
