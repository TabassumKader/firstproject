package org.example.first_project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.first_project.models.User;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TitasGasApp extends Application {
    private static TitasGasApp instance;
    private Stage primaryStage;
    private User currentUser;
    private Map<String, Scene> sceneCache;
    
    @Override
    public void start(Stage stage) throws IOException {
        instance = this;
        this.primaryStage = stage;
        this.sceneCache = new HashMap<>();
        
        initializeApplication();
    }

    private void initializeApplication() throws IOException {
        // Set up the primary stage
        primaryStage.setTitle("Titas Gas Management System");
        
        // Load and display the login scene
        showLoginScreen();
        
        // Configure the primary stage
        primaryStage.setMinWidth(800);
        primaryStage.setMinHeight(600);
        primaryStage.show();
    }

    public void showLoginScreen() throws IOException {
        Scene loginScene = loadScene("login-view.fxml");
        setScene(loginScene, "Titas Gas - Login");
    }

    public void showDirectorDashboard() throws IOException {
        Scene dashboard = loadScene("director-dashboard.fxml");
        setScene(dashboard, "Director Dashboard - Titas Gas");
    }

    public void showCustomerDashboard() throws IOException {
        Scene dashboard = loadScene("customer-dashboard.fxml");
        setScene(dashboard, "Customer Dashboard - Titas Gas");
    }

    private Scene loadScene(String fxmlFile) throws IOException {
        if (sceneCache.containsKey(fxmlFile)) {
            return sceneCache.get(fxmlFile);
        }

        FXMLLoader fxmlLoader = new FXMLLoader(TitasGasApp.class.getResource(fxmlFile));
        Scene scene = new Scene(fxmlLoader.load());
        sceneCache.put(fxmlFile, scene);
        return scene;
    }

    private void setScene(Scene scene, String title) {
        primaryStage.setScene(scene);
        primaryStage.setTitle(title);
        primaryStage.show();
    }

    public void clearSceneCache() {
        sceneCache.clear();
    }

    public void logout() throws IOException {
        currentUser = null;
        clearSceneCache();
        showLoginScreen();
    }

    // Getters and setters
    public static TitasGasApp getInstance() {
        return instance;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User user) {
        this.currentUser = user;
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch();
    }
}
