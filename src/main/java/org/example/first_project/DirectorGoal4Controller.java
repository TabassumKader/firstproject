package org.example.first_project;

import javafx.fxml.FXML;
import javafx.stage.Stage;

public class DirectorGoal4Controller {
    
    @FXML
    private void goBack() {
        Stage stage = (Stage) getClass().getResource("director-goal4.fxml").getScene().getWindow();
        stage.close();
    }
}
