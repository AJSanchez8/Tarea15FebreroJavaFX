package com.example.tarea15febrero;

import java.util.Properties;

public class Modelo {

    private Properties tarea;

    //Contructor tarea
    public Modelo() {
        tarea = new Properties();
    }

    public void crearTarea(String titulo, String descripcion){
        tarea.setProperty(titulo, descripcion);
    }
    public void borrarTarea(String titulo){
        tarea.remove(titulo);
    }
    public void modificarTarea(String titulo, String descripcion){
        tarea.remove(titulo);
        tarea.setProperty(titulo, descripcion);
    }



}
