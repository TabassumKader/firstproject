package org.example.first_project;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.collections.FXCollections;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    @FXML
    private TextField usernameField;
    
    @FXML
    private PasswordField passwordField;
    
    @FXML
    private ComboBox<String> userTypeComboBox;
    
    @FXML
    private Label errorLabel;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        userTypeComboBox.setItems(FXCollections.observableArrayList("Managing Director", "Domestic Customer"));
    }
    
    @FXML
    private void handleLogin() {
        String username = usernameField.getText();
        String password = passwordField.getText();
        String userType = userTypeComboBox.getValue();
        
        if (username.isEmpty() || password.isEmpty() || userType == null) {
            errorLabel.setText("Please fill in all fields");
            return;
        }
        

        if (isValidCredentials(username, password, userType)) {
            try {
                navigateToDashboard(userType);
            } catch (IOException e) {
                errorLabel.setText("Error loading dashboard: " + e.getMessage());
            }
        } else {
            errorLabel.setText("Invalid credentials");
        }
    }
    
    private boolean isValidCredentials(String username, String password, String userType) {
        // Simple validation for demo
        if ("Managing Director".equals(userType)) {
            return "director".equals(username) && "password".equals(password);
        } else if ("Domestic Customer".equals(userType)) {
            return "customer".equals(username) && "password".equals(password);
        }
        return false;
    }
    
    private void navigateToDashboard(String userType) throws IOException {
        String fxmlFile;
        if ("Managing Director".equals(userType)) {
            fxmlFile = "director-dashboard.fxml";
        } else {
            fxmlFile = "customer-dashboard.fxml";
        }
        
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(fxmlFile));
        Scene scene = new Scene(fxmlLoader.load(), 1200, 800);
        Stage stage = (Stage) usernameField.getScene().getWindow();
        stage.setScene(scene);
        stage.setMaximized(true);
    }
}
