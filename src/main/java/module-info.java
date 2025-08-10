module org.example.first_project {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.first_project to javafx.fxml;
    exports org.example.first_project;
}