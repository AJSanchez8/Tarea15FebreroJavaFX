package com.example.tarea15febrero;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class AppController {
    @FXML
    private TextField nuevoTituloTarea;
    @FXML
    private TextArea nuevaDescripcionTarea;
    @FXML
    private VBox vBoxTarea;
    @FXML
    private VBox entrada;
    @FXML
    private VBox modificar;
    @FXML
    private TextField tituloEdit;

    @FXML
    private TextArea descEdit;
    @FXML
    protected void botonCrear() {

        var fila = new HBox();
        var elementosFila = fila.getChildren();
        var titulo = new Text(nuevoTituloTarea.getText());
        elementosFila.add(titulo);
        var descripcion = new Text(nuevaDescripcionTarea.getText());
        elementosFila.add(descripcion);
        var elementosContenedor = vBoxTarea.getChildren();

        fila.setSpacing(5);
        var botonBorrar = new Button("Borrar");
        elementosFila.add(botonBorrar);


        botonBorrar.setOnAction(e ->{
                    Parent hbox = botonBorrar.getParent();
                    Parent vbox = botonBorrar.getParent().getParent();
                    var titulo2 = (Text) ((HBox)hbox).getChildren().get(0);
                    //Tambien podemos crear una variable y castearla y abajo solo ponemos vbox. y el metodo
                    ((VBox) vbox).getChildren().remove(hbox);
        });



        var botonModificar = new Button("Modificar");
        elementosFila.add(botonModificar);

        botonModificar.setOnAction(e ->{
            Parent hbox = botonModificar.getParent();
            var titulo2 = (Text) ((HBox) hbox).getChildren().get(0);
            var desc = (Text) ((HBox) hbox).getChildren().get(1);
            tituloEdit.setText(titulo.getText());
            descEdit.setText(descripcion.getText());
            modificar.setVisible(true);
            entrada.setVisible(false);
            Text refModificarTitulo = titulo;
            Text refModDesc = desc;

        });



        elementosContenedor.add(fila);


    }

    public void botonModificar(ActionEvent actionEvent) {
    }

}