module com.example.tarea15febrero {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    opens com.example.tarea15febrero to javafx.fxml;
    exports com.example.tarea15febrero;
}