package org.example.first_project;

import javafx.fxml.FXML;
import javafx.stage.Stage;

public class CustomerGoal7Controller {
    
    @FXML
    private void goBack() {
        Stage stage = (Stage) getClass().getResource("customer-goal7.fxml").getScene().getWindow();
        stage.close();
    }
}