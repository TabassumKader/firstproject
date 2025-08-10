package org.example.first_project;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.stage.FileChooser;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.io.File;

public class CustomerGoal1Controller {
    
    @FXML
    private TextField nameField;
    
    @FXML
    private TextField nidField;
    
    @FXML
    private TextField phoneField;
    
    @FXML
    private TextField emailField;
    
    @FXML
    private TextArea addressArea;
    
    @FXML
    private ComboBox<String> connectionTypeComboBox;
    
    @FXML
    private ComboBox<String> propertyTypeComboBox;
    
    @FXML
    private TextField nidFileField;
    
    @FXML
    private TextField utilityFileField;
    
    @FXML
    private TextField photoFileField;
    
    @FXML
    public void initialize() {
        // Initialize combo boxes
        ObservableList<String> connectionTypes = FXCollections.observableArrayList(
            "Domestic", "Commercial", "Industrial", "Institutional"
        );
        connectionTypeComboBox.setItems(connectionTypes);
        
        ObservableList<String> propertyTypes = FXCollections.observableArrayList(
            "Apartment", "House", "Office", "Shop", "Factory", "School", "Hospital"
        );
        propertyTypeComboBox.setItems(propertyTypes);
    }
    
    @FXML
    private void goBack() {
        Stage stage = (Stage) nameField.getScene().getWindow();
        stage.close();
    }
    
    @FXML
    private void browseNID() {
        File file = showFileChooser("Select NID Copy", "*.pdf", "*.jpg", "*.png");
        if (file != null) {
            nidFileField.setText(file.getName());
        }
    }
    
    @FXML
    private void browseUtilityBill() {
        File file = showFileChooser("Select Utility Bill", "*.pdf", "*.jpg", "*.png");
        if (file != null) {
            utilityFileField.setText(file.getName());
        }
    }
    
    @FXML
    private void browsePhoto() {
        File file = showFileChooser("Select Photo", "*.jpg", "*.png", "*.jpeg");
        if (file != null) {
            photoFileField.setText(file.getName());
        }
    }
    
    @FXML
    private void clearForm() {
        nameField.clear();
        nidField.clear();
        phoneField.clear();
        emailField.clear();
        addressArea.clear();
        connectionTypeComboBox.setValue(null);
        propertyTypeComboBox.setValue(null);
        nidFileField.clear();
        utilityFileField.clear();
        photoFileField.clear();
    }
    
    @FXML
    private void submitApplication() {
        if (!validateForm()) {
            return;
        }
        
        // Generate application ID
        String applicationId = "GC" + System.currentTimeMillis();
        
        String message = "Application Submitted Successfully!\n\n" +
                "Application ID: " + applicationId + "\n" +
                "Name: " + nameField.getText() + "\n" +
                "Connection Type: " + connectionTypeComboBox.getValue() + "\n" +
                "Property Type: " + propertyTypeComboBox.getValue() + "\n\n" +
                "Please save your Application ID for future reference.\n" +
                "You will receive updates via SMS and email.";
        
        showAlert("Application Submitted", message);
        clearForm();
    }
    
    private boolean validateForm() {
        if (nameField.getText().trim().isEmpty()) {
            showAlert("Validation Error", "Please enter your full name.");
            return false;
        }
        
        if (nidField.getText().trim().isEmpty()) {
            showAlert("Validation Error", "Please enter your NID number.");
            return false;
        }
        
        if (phoneField.getText().trim().isEmpty()) {
            showAlert("Validation Error", "Please enter your phone number.");
            return false;
        }
        
        if (emailField.getText().trim().isEmpty()) {
            showAlert("Validation Error", "Please enter your email address.");
            return false;
        }
        
        if (addressArea.getText().trim().isEmpty()) {
            showAlert("Validation Error", "Please enter your address.");
            return false;
        }
        
        if (connectionTypeComboBox.getValue() == null) {
            showAlert("Validation Error", "Please select connection type.");
            return false;
        }
        
        if (propertyTypeComboBox.getValue() == null) {
            showAlert("Validation Error", "Please select property type.");
            return false;
        }
        
        if (nidFileField.getText().trim().isEmpty()) {
            showAlert("Validation Error", "Please upload your NID copy.");
            return false;
        }
        
        if (utilityFileField.getText().trim().isEmpty()) {
            showAlert("Validation Error", "Please upload your utility bill.");
            return false;
        }
        
        if (photoFileField.getText().trim().isEmpty()) {
            showAlert("Validation Error", "Please upload your photo.");
            return false;
        }
        
        return true;
    }
    
    private File showFileChooser(String title, String... extensions) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle(title);
        
        FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter(
            "Supported Files", extensions
        );
        fileChooser.getExtensionFilters().add(filter);
        
        return fileChooser.showOpenDialog(nameField.getScene().getWindow());
    }
    
    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
