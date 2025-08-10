package org.example.first_project;

import javafx.fxml.FXML;
import javafx.stage.Stage;

public class DirectorGoal3Controller {
    
    @FXML
    private void goBack() {
        Stage stage = (Stage) getClass().getResource("director-goal3.fxml").getScene().getWindow();
        stage.close();
    }
}
