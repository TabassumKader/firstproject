package org.example.first_project;

import javafx.fxml.FXML;
import javafx.stage.Stage;

public class DirectorGoal7Controller {
    
    @FXML
    private void goBack() {
        Stage stage = (Stage) getClass().getResource("director-goal7.fxml").getScene().getWindow();
        stage.close();
    }
}