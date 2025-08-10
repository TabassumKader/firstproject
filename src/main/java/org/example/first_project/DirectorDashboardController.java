package org.example.first_project;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class DirectorDashboardController {
    
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
        openGoalScene("director-goal1.fxml", "Monitor Operational Dashboard");
    }
    
    @FXML
    private void openGoal2() {
        openGoalScene("director-goal2.fxml", "Approve Budget for Network");
    }
    
    @FXML
    private void openGoal3() {
        openGoalScene("director-goal3.fxml", "Review Monthly Performance Report");
    }
    
    @FXML
    private void openGoal4() {
        openGoalScene("director-goal4.fxml", "Overseas Emergency Incident");
    }
    
    @FXML
    private void openGoal5() {
        openGoalScene("director-goal5.fxml", "Authorize High-Value Procurement");
    }
    
    @FXML
    private void openGoal6() {
        openGoalScene("director-goal6.fxml", "Review Stakeholder Feedback");
    }
    
    @FXML
    private void openGoal7() {
        openGoalScene("director-goal7.fxml", "Assign Strategic Objectives");
    }
    
    @FXML
    private void openGoal8() {
        openGoalScene("director-goal8.fxml", "Approve Organizational Policy");
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
