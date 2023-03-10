package com.example.tarea15febrero;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.kordamp.bootstrapfx.BootstrapFX;

import java.io.IOException;

public class App extends Application {

    // public static Modelo tareas = new Modelo("./src/main/resources/com/example/tarea15febrero/memorycard.txt");
    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("VentanaCrear.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());

        stage.setTitle("LISTA DE TAREAS");
        stage.setScene(scene);
        stage.show();
        stage.sizeToScene();
    }

    public static void main(String[] args) {
        launch();
    }
}