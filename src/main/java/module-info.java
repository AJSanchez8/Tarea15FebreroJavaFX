module com.example.tarea15febrero {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.tarea15febrero to javafx.fxml;
    exports com.example.tarea15febrero;
}