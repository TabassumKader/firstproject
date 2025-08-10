import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FixPlaceholderFXMLs {
    
    public static void main(String[] args) {
        String[] fxmlFiles = {
            "director-goal3.fxml",
            "director-goal4.fxml", 
            "director-goal5.fxml",
            "director-goal6.fxml",
            "director-goal7.fxml",
            "director-goal8.fxml"
        };
        
        String[] goalNames = {
            "Review Performance Reports",
            "Manage Staff Assignments", 
            "Approve Maintenance Requests",
            "Review Safety Protocols",
            "Monitor Financial Reports",
            "Strategic Planning"
        };
        
        String[] goalNumbers = {"3", "4", "5", "6", "7", "8"};
        
        for (int i = 0; i < fxmlFiles.length; i++) {
            fixFXML(fxmlFiles[i], goalNames[i], goalNumbers[i]);
        }
        
        System.out.println("All placeholder FXML files have been fixed!");
    }
    
    private static void fixFXML(String fileName, String goalName, String goalNumber) {
        String content = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n\n" +
            "<?import javafx.geometry.Insets?>\n" +
            "<?import javafx.scene.control.*?>\n" +
            "<?import javafx.scene.layout.*?>\n\n" +
            "<VBox xmlns=\"http://javafx.com/javafx/21\" xmlns:fx=\"http://javafx.com/fxml/1\" fx:controller=\"org.example.first_project.DirectorGoal" + goalNumber + "Controller\">\n" +
            "   <children>\n" +
            "      <HBox alignment=\"CENTER_RIGHT\" spacing=\"10.0\">\n" +
            "         <children>\n" +
            "            <Label fx:id=\"titleLabel\" text=\"Goal " + goalNumber + ": " + goalName + "\" style=\"-fx-font-size: 20px; -fx-font-weight: bold;\" />\n" +
            "            <Region HBox.hgrow=\"ALWAYS\" />\n" +
            "            <Button text=\"Go Back\" onAction=\"#goBack\" />\n" +
            "         </children>\n" +
            "         <padding>\n" +
            "            <Insets bottom=\"10.0\" left=\"20.0\" right=\"20.0\" top=\"20.0\" />\n" +
            "         </padding>\n" +
            "      </HBox>\n" +
            "      \n" +
            "      <VBox alignment=\"CENTER\" spacing=\"20.0\">\n" +
            "         <children>\n" +
            "            <Label text=\"" + goalName + "\" style=\"-fx-font-size: 24px; -fx-font-weight: bold;\" />\n" +
            "            <Label text=\"This module is under development\" style=\"-fx-font-size: 16px;\" />\n" +
            "            <Label text=\"Coming soon with full functionality\" style=\"-fx-font-size: 14px;\" />\n" +
            "         </children>\n" +
            "         <padding>\n" +
            "            <Insets bottom=\"20.0\" left=\"20.0\" right=\"20.0\" top=\"20.0\" />\n" +
            "         </padding>\n" +
            "      </VBox>\n" +
            "   </children>\n" +
            "</VBox>";
        
        try {
            Path filePath = Paths.get("src/main/resources/org/example/first_project/" + fileName);
            Files.write(filePath, content.getBytes());
            System.out.println("Fixed: " + fileName);
        } catch (IOException e) {
            System.err.println("Error fixing " + fileName + ": " + e.getMessage());
        }
    }
}
