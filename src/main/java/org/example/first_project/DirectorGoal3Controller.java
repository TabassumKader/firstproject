package org.example.first_project;

import javafx.fxml.FXML;
import javafx.stage.Stage;

public class DirectorGoal3Controller {

    @FXML
    private void goBack() {
        // Simple placeholder - close current window
        System.out.println("Goal 3: Review Monthly Performance Report - Module under development");
        // Close the current window
        try {
            // This is a simplified approach for placeholder controllers
            // In a real implementation, you would get the stage properly
            System.out.println("Closing window...");
        } catch (Exception e) {
            System.err.println("Could not close window: " + e.getMessage());
        }
    }
}
