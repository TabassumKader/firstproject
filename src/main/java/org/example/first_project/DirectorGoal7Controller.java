package org.example.first_project;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class DirectorGoal7Controller {

    @FXML
    private Label titleLabel;

    @FXML
    private void goBack() {
        // Get the stage and close the window
        if (titleLabel != null) {
            Stage stage = (Stage) titleLabel.getScene().getWindow();
            stage.close();
        }
    }
}