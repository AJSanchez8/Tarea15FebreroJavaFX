package com.example.tarea15febrero;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.net.URL;
import java.util.Iterator;
import java.util.ResourceBundle;

public class AppController implements Initializable {
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
    private Text mensaje;
    @FXML
    private TextFlow informacion;
    @FXML
    private TextArea descEdit;

    private  Modelo cajon = new Modelo();
    @FXML
    protected void botonCrear() {
        var clases = informacion.getStyleClass();

        if(nuevoTituloTarea.getText().equals("") || nuevaDescripcionTarea.getText().equals("")){

            // Mostramos mensaje
            clases.remove(1);
            clases.add("alert-danger");
            mostrarMensaje("Tarea NO creada, CAMPOS VACIOS");
        } else {
            //Declaramos variables
            var fila = new HBox();
            var elementosFila = fila.getChildren();

            //Titulo
            var titulo = new Text(nuevoTituloTarea.getText());
            elementosFila.add(titulo);

            //Descripcion
            var descripcion = new Text(nuevaDescripcionTarea.getText());
            elementosFila.add(descripcion);

            nuevoTituloTarea.clear();
            nuevaDescripcionTarea.clear();
            var elementosContenedor = vBoxTarea.getChildren();
            fila.setSpacing(5);
            var botonBorrar = new Button("Borrar");
            elementosFila.add(botonBorrar);
            botonBorrar.getStyleClass().setAll("btn", "btn-danger");

            // Boton borrar dentro de la tarea
            botonBorrar.setOnAction(e -> {
                Parent hbox = botonBorrar.getParent();
                Parent vbox = botonBorrar.getParent().getParent();
                var titulo2 = (Text) ((HBox) hbox).getChildren().get(0);
                //Tambien podemos crear una variable y castearla y abajo solo ponemos vbox. y el metodo
                cajon.borrarTarea(titulo2.getText());
                ((VBox) vbox).getChildren().remove(hbox);
                clases.remove(1);
                clases.add("alert-warning");
                mostrarMensaje("Tarea "+titulo.getText()+" borrada");
                cajon.almacenar();
            });

            // Boton modificar dentro de la propia tarea
            var botonModificar = new Button("Modificar");
            elementosFila.add(botonModificar);
            botonModificar.getStyleClass().setAll("btn", "btn-info");
            botonModificar.setOnAction(e -> {
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
                var titulo3 = (Text) ((HBox) hbox1).getChildren().get(0);
                //Tambien podemos crear una variable y castearla y abajo solo ponemos vbox. y el metodo
                ((VBox) vbox).getChildren().remove(hbox1);
            });
            elementosContenedor.add(fila);
            cajon.meterTarea(titulo.getText(), descripcion.getText());
            cajon.almacenar();
            clases.remove(1);
            clases.add("alert-success");
            mostrarMensaje("Tarea "+titulo.getText()+" añadida");
        }
    }

    @FXML
    protected void botonModificar() {

        //Declaramos variables
        var fila = new HBox();
        var elementosFila = fila.getChildren();
        var titulo1 = new Text(tituloEdit.getText());
        elementosFila.add(titulo1);

        //Añadimos titulo
        var descripcion1 = new Text(descEdit.getText());
        elementosFila.add(descripcion1);

        //Añadimos descripcion
        var elementosContenedor = vBoxTarea.getChildren();
        elementosContenedor.add(fila);
        fila.setSpacing(5);

        //Añadimos botones
        var botonBorrar = new Button("Borrar");
        elementosFila.add(botonBorrar);
        botonBorrar.getStyleClass().setAll("btn", "btn-danger");
        var botonModificar = new Button("Modificar");
        elementosFila.add(botonModificar);
        botonModificar.getStyleClass().setAll("btn","btn-info");

        //Guardamos en el properties
        cajon.meterTarea(titulo1.getText(),descripcion1.getText());

        //Cajas invisibles y visibles
        modificar.setVisible(false);
        entrada.setVisible(true);
        vBoxTarea.setDisable(false);

        //Boton borrar
        botonBorrar.setOnAction(e ->{
            Parent hbox = botonBorrar.getParent();
            Parent vbox = botonBorrar.getParent().getParent();
            var titulo2 = (Text) ((HBox)hbox).getChildren().get(0);
            //Tambien podemos crear una variable y castearla y abajo solo ponemos vbox. y el metodo
            ((VBox) vbox).getChildren().remove(hbox);
            cajon.borrarTarea(titulo2.getText());
            cajon.almacenar();
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Iterator<String> iteradorTareas = cajon.DevolverIterador();

        while (iteradorTareas.hasNext()){
            String titulo = iteradorTareas.next();
            String descripcion = cajon.DevolverDesc(titulo);


        }

    }

    public void ocultar(){
        informacion.setVisible(false);
    }
    public void mostrarMensaje (String msj){
        mensaje.setText("Mensaje: "+msj);
        informacion.setVisible(true);

        // Llamamos al servicio

    }
}