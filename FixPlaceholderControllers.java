import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FixPlaceholderControllers {
    
    public static void main(String[] args) {
        String[] controllerFiles = {
            "DirectorGoal3Controller.java",
            "DirectorGoal4Controller.java", 
            "DirectorGoal5Controller.java",
            "DirectorGoal6Controller.java",
            "DirectorGoal7Controller.java",
            "DirectorGoal8Controller.java"
        };
        
        String[] goalNames = {
            "Review Performance Reports",
            "Manage Staff Assignments", 
            "Approve Maintenance Requests",
            "Review Safety Protocols",
            "Monitor Financial Reports",
            "Strategic Planning"
        };
        
        for (int i = 0; i < controllerFiles.length; i++) {
            fixController(controllerFiles[i], goalNames[i]);
        }
        
        System.out.println("All placeholder controllers have been fixed!");
    }
    
    private static void fixController(String fileName, String goalName) {
        String content = "package org.example.first_project;\n\n" +
            "import javafx.fxml.FXML;\n" +
            "import javafx.scene.control.Alert;\n" +
            "import javafx.scene.control.Label;\n" +
            "import javafx.stage.Stage;\n\n" +
            "public class " + fileName.replace(".java", "") + " {\n\n" +
            "    @FXML\n" +
            "    private Label titleLabel;\n\n" +
            "    @FXML\n" +
            "    private void goBack() {\n" +
            "        // Get the stage and close the window\n" +
            "        if (titleLabel != null) {\n" +
            "            Stage stage = (Stage) titleLabel.getScene().getWindow();\n" +
            "            stage.close();\n" +
            "        }\n" +
            "    }\n" +
            "}";
        
        try {
            Path filePath = Paths.get("src/main/java/org/example/first_project/" + fileName);
            Files.write(filePath, content.getBytes());
            System.out.println("Fixed: " + fileName);
        } catch (IOException e) {
            System.err.println("Error fixing " + fileName + ": " + e.getMessage());
        }
    }
}
