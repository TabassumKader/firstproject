import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CreateRemainingGoals {
    public static void main(String[] args) {
        // Director goals 5-8
        String[] directorGoals = {"5", "6", "7", "8"};
        String[] directorTitles = {
            "Authorize High-Value Procurement",
            "Review Stakeholder Feedback", 
            "Assign Strategic Objectives",
            "Approve Organizational Policy"
        };
        
        // Customer goals 4-8
        String[] customerGoals = {"4", "5", "6", "7", "8"};
        String[] customerTitles = {
            "Track Connection Status",
            "Update Customer Profile",
            "Book a Technician Visit",
            "Request Billing Clarification",
            "Download Connection Certificate"
        };
        
        // Create director goal files
        for (int i = 0; i < directorGoals.length; i++) {
            createDirectorGoal(directorGoals[i], directorTitles[i]);
        }
        
        // Create customer goal files
        for (int i = 0; i < customerGoals.length; i++) {
            createCustomerGoal(customerGoals[i], customerTitles[i]);
        }
        
        System.out.println("All placeholder files created successfully!");
    }
    
    private static void createDirectorGoal(String goalNum, String title) {
        String fxmlContent = String.format(
            "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n\n" +
            "<?import javafx.geometry.Insets?>\n" +
            "<?import javafx.scene.control.*?>\n" +
            "<?import javafx.scene.layout.*?>\n" +
            "<?import javafx.scene.text.*?>\n\n" +
            "<VBox xmlns=\"http://javafx.com/javafx/21\" xmlns:fx=\"http://javafx.com/fxml/1\" fx:controller=\"org.example.first_project.DirectorGoal%sController\">\n" +
            "   <children>\n" +
            "      <HBox alignment=\"CENTER_RIGHT\" style=\"-fx-background-color: #2c3e50; -fx-padding: 10;\">\n" +
            "         <children>\n" +
            "            <Label text=\"Goal %s: %s\" style=\"-fx-text-fill: white; -fx-font-size: 18px; -fx-font-weight: bold;\" />\n" +
            "            <Region HBox.hgrow=\"ALWAYS\" />\n" +
            "            <Button text=\"Back to Dashboard\" style=\"-fx-background-color: #3498db; -fx-text-fill: white;\" onAction=\"#goBack\" />\n" +
            "         </children>\n" +
            "      </HBox>\n" +
            "      \n" +
            "      <VBox alignment=\"CENTER\" spacing=\"20\" style=\"-fx-background-color: #ecf0f1; -fx-padding: 50;\">\n" +
            "         <children>\n" +
            "            <Label text=\"%s\" style=\"-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: #2c3e50;\" />\n" +
            "            <Label text=\"This module is under development\" style=\"-fx-font-size: 16px; -fx-text-fill: #7f8c8d;\" />\n" +
            "            <Button text=\"Go Back\" style=\"-fx-background-color: #3498db; -fx-text-fill: white;\" onAction=\"#goBack\" />\n" +
            "         </children>\n" +
            "      </VBox>\n" +
            "   </children>\n" +
            "</VBox>",
            goalNum, goalNum, title, title
        );
        
        writeFile("src/main/resources/org/example/first_project/director-goal" + goalNum + ".fxml", fxmlContent);
        
        String controllerContent = String.format(
            "package org.example.first_project;\n\n" +
            "import javafx.fxml.FXML;\n" +
            "import javafx.stage.Stage;\n\n" +
            "public class DirectorGoal%sController {\n" +
            "    \n" +
            "    @FXML\n" +
            "    private void goBack() {\n" +
            "        Stage stage = (Stage) getClass().getResource(\"director-goal%s.fxml\").getScene().getWindow();\n" +
            "        stage.close();\n" +
            "    }\n" +
            "}",
            goalNum, goalNum
        );
        
        writeFile("src/main/java/org/example/first_project/DirectorGoal" + goalNum + "Controller.java", controllerContent);
    }
    
    private static void createCustomerGoal(String goalNum, String title) {
        String fxmlContent = String.format(
            "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n\n" +
            "<?import javafx.geometry.Insets?>\n" +
            "<?import javafx.scene.control.*?>\n" +
            "<?import javafx.scene.layout.*?>\n" +
            "<?import javafx.scene.text.*?>\n\n" +
            "<VBox xmlns=\"http://javafx.com/javafx/21\" xmlns:fx=\"http://javafx.com/fxml/1\" fx:controller=\"org.example.first_project.CustomerGoal%sController\">\n" +
            "   <children>\n" +
            "      <HBox alignment=\"CENTER_RIGHT\" style=\"-fx-background-color: #2c3e50; -fx-padding: 10;\">\n" +
            "         <children>\n" +
            "            <Label text=\"Goal %s: %s\" style=\"-fx-text-fill: white; -fx-font-size: 18px; -fx-font-weight: bold;\" />\n" +
            "            <Region HBox.hgrow=\"ALWAYS\" />\n" +
            "            <Button text=\"Back to Dashboard\" style=\"-fx-background-color: #3498db; -fx-text-fill: white;\" onAction=\"#goBack\" />\n" +
            "         </children>\n" +
            "      </HBox>\n" +
            "      \n" +
            "      <VBox alignment=\"CENTER\" spacing=\"20\" style=\"-fx-background-color: #ecf0f1; -fx-padding: 50;\">\n" +
            "         <children>\n" +
            "            <Label text=\"%s\" style=\"-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: #2c3e50;\" />\n" +
            "            <Label text=\"This module is under development\" style=\"-fx-font-size: 16px; -fx-text-fill: #7f8c8d;\" />\n" +
            "            <Button text=\"Go Back\" style=\"-fx-background-color: #3498db; -fx-text-fill: white;\" onAction=\"#goBack\" />\n" +
            "         </children>\n" +
            "      </VBox>\n" +
            "   </children>\n" +
            "</VBox>",
            goalNum, goalNum, title, title
        );
        
        writeFile("src/main/resources/org/example/first_project/customer-goal" + goalNum + ".fxml", fxmlContent);
        
        String controllerContent = String.format(
            "package org.example.first_project;\n\n" +
            "import javafx.fxml.FXML;\n" +
            "import javafx.stage.Stage;\n\n" +
            "public class CustomerGoal%sController {\n" +
            "    \n" +
            "    @FXML\n" +
            "    private void goBack() {\n" +
            "        Stage stage = (Stage) getClass().getResource(\"customer-goal%s.fxml\").getScene().getWindow();\n" +
            "        stage.close();\n" +
            "    }\n" +
            "}",
            goalNum, goalNum
        );
        
        writeFile("src/main/java/org/example/first_project/CustomerGoal" + goalNum + "Controller.java", controllerContent);
    }
    
    private static void writeFile(String path, String content) {
        try {
            File file = new File(path);
            file.getParentFile().mkdirs();
            FileWriter writer = new FileWriter(file);
            writer.write(content);
            writer.close();
            System.out.println("Created: " + path);
        } catch (IOException e) {
            System.err.println("Error creating file: " + path);
            e.printStackTrace();
        }
    }
}
