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

    private  Modelo cajon;
    @FXML
    protected void botonCrear() {

        var fila = new HBox();
        var elementosFila = fila.getChildren();
        var titulo = new Text(nuevoTituloTarea.getText());

        elementosFila.add(titulo);
        var descripcion = new Text(nuevaDescripcionTarea.getText());
        elementosFila.add(descripcion);
        nuevoTituloTarea.clear();
        nuevaDescripcionTarea.clear();
       // cajon.crearTarea(titulo.getText(),descripcion.getText());
       // cajon.almacenar();
        var elementosContenedor = vBoxTarea.getChildren();
        fila.setSpacing(5);
        var botonBorrar = new Button("Borrar");
        elementosFila.add(botonBorrar);

        // Boton borrar dentro de la tarea
        botonBorrar.setOnAction(e ->{
                    Parent hbox = botonBorrar.getParent();
                    Parent vbox = botonBorrar.getParent().getParent();
                    var titulo2 = (Text) ((HBox)hbox).getChildren().get(0);
                    //Tambien podemos crear una variable y castearla y abajo solo ponemos vbox. y el metodo
                    ((VBox) vbox).getChildren().remove(hbox);
        });
        // Boton modificar dentro de la propia tarea
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
            vBoxTarea.setDisable(true);
            Text refModificarTitulo = titulo;
            Text refModDesc = desc;
            // Borramos la tarea, se queda el texto anterior en la modificacion para no perderla
            Parent hbox1 = botonBorrar.getParent();
            Parent vbox = botonBorrar.getParent().getParent();
            var titulo3 = (Text) ((HBox)hbox1).getChildren().get(0);
            //Tambien podemos crear una variable y castearla y abajo solo ponemos vbox. y el metodo
            ((VBox) vbox).getChildren().remove(hbox1);
        });
        elementosContenedor.add(fila);


    }

    @FXML
    protected void botonModificar() {

        var fila = new HBox();
        var elementosFila = fila.getChildren();
        var titulo1 = new Text(tituloEdit.getText());
        elementosFila.add(titulo1);
        var descripcion1 = new Text(descEdit.getText());
        elementosFila.add(descripcion1);
        var elementosContenedor = vBoxTarea.getChildren();
        elementosContenedor.add(fila);
        fila.setSpacing(5);
        var botonBorrar = new Button("Borrar");
        elementosFila.add(botonBorrar);
        var botonModificar = new Button("Modificar");
        elementosFila.add(botonModificar);
        modificar.setVisible(false);
        entrada.setVisible(true);
        vBoxTarea.setDisable(false);
        botonBorrar.setOnAction(e ->{
            Parent hbox = botonBorrar.getParent();
            Parent vbox = botonBorrar.getParent().getParent();
            var titulo2 = (Text) ((HBox)hbox).getChildren().get(0);
            //Tambien podemos crear una variable y castearla y abajo solo ponemos vbox. y el metodo
            ((VBox) vbox).getChildren().remove(hbox);
        });

        botonModificar.setOnAction(e ->{
            Parent hbox = botonModificar.getParent();
            var titulo2 = (Text) ((HBox) hbox).getChildren().get(0);
            var desc = (Text) ((HBox) hbox).getChildren().get(1);
            tituloEdit.setText(titulo1.getText());
            descEdit.setText(descripcion1.getText());
            modificar.setVisible(true);
            entrada.setVisible(false);
            vBoxTarea.setDisable(true);
            Text refModificarTitulo = titulo1;
            Text refModDesc = desc;
            // Borramos la tarea, se queda el texto anterior en la modificacion para no perderla
            Parent hbox1 = botonBorrar.getParent();
            Parent vbox = botonBorrar.getParent().getParent();
            var titulo3 = (Text) ((HBox)hbox1).getChildren().get(0);
            //Tambien podemos crear una variable y castearla y abajo solo ponemos vbox. y el metodo
            ((VBox) vbox).getChildren().remove(hbox1);
        });


    }

}