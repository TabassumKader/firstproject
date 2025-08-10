module org.example.first_project {
    // JavaFX requirements
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    // Allow FXML loader to access our classes
    opens org.example.first_project to javafx.fxml;
    opens org.example.first_project.controllers to javafx.fxml;
    
    // Export our packages for dependency injection and general usage
    exports org.example.first_project;
    exports org.example.first_project.controllers;
    exports org.example.first_project.models;
    exports org.example.first_project.services;
}
