package com.example.tarea15febrero;
import java.io.*;
import java.util.Iterator;
import java.util.Properties;


public class Modelo {

    private FileOutputStream fos;
    private FileInputStream fis;
    private String filepath = "./src/main/resources/com/example/tarea15febrero/memorycard.txt";
    private Properties lista;

    //Contructor tarea
    public Modelo() {
        lista = new Properties();
    }

    public void borrarTarea(String titulo) {
        lista.remove(titulo);
        almacenar();
        System.out.println(lista);
    }

    public void modificarTarea(String titulo, String descripcion) {
        lista.remove(titulo);
        lista.setProperty(titulo, descripcion);
    }

    public void almacenar() {
        try {
            fos = new FileOutputStream(filepath);
            lista.store(fos, "Tareas pendientes");
            fos.close();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void meterTarea(String titulo, String descripcion) {
        lista.setProperty(titulo, descripcion);
        almacenar();
    }

    @Override
    public String toString() {
        return "Modelo{tarea=" + lista + '}';
    }

    // CARGAR DESPUES DE ALMACENAR
    public boolean cargarTareasArchivo(){


        File archivo = new File(filepath);
        boolean existe = false;
        if ( archivo.exists() && archivo.isFile()){
            try {
                fis = new FileInputStream(filepath);
                lista.load(fis);
                fis.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            existe = true;
        } else System.out.println("¡NO HAY ARCHIVO DE TAREAS!");
        return existe;
    }
    public String DevolverDesc (String titulo){
        return (String) lista.get(titulo);
    }

    public Iterator DevolverIterador(){
        return lista.keySet().iterator();
    }
}