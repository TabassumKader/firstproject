package org.example.first_project;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CustomerDashboardController {
    
    @FXML
    private void handleLogout() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 800, 600);
            Stage stage = (Stage) scene.getWindow();
            stage.setScene(scene);
            stage.setMaximized(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    private void openGoal1() {
        openGoalScene("customer-goal1.fxml", "Apply for New Gas Connection");
    }
    
    @FXML
    private void openGoal2() {
        openGoalScene("customer-goal2.fxml", "Pay Monthly Gas Bill");
    }
    
    @FXML
    private void openGoal3() {
        openGoalScene("customer-goal3.fxml", "Submit a Service Complaint");
    }
    
    @FXML
    private void openGoal4() {
        openGoalScene("customer-goal4.fxml", "Track Connection Status");
    }
    
    @FXML
    private void openGoal5() {
        openGoalScene("customer-goal5.fxml", "Update Customer Profile");
    }
    
    @FXML
    private void openGoal6() {
        openGoalScene("customer-goal6.fxml", "Book a Technician Visit");
    }
    
    @FXML
    private void openGoal7() {
        openGoalScene("customer-goal7.fxml", "Request Billing Clarification");
    }
    
    @FXML
    private void openGoal8() {
        openGoalScene("customer-goal8.fxml", "Download Connection Certificate");
    }
    
    private void openGoalScene(String fxmlFile, String title) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(fxmlFile));
            Scene scene = new Scene(fxmlLoader.load(), 1200, 800);
            Stage stage = new Stage();
            stage.setTitle(title);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
