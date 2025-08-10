package org.example.first_project;

import javafx.fxml.FXML;
import javafx.stage.Stage;

public class CustomerGoal3Controller {
    
    @FXML
    private void goBack() {
        // Simple placeholder - close current window
        Stage stage = (Stage) getClass().getResource("customer-goal3.fxml").getScene().getWindow();
        stage.close();
    }
}
