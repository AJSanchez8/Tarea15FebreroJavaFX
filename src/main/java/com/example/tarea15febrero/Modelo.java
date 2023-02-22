package com.example.tarea15febrero;

import javafx.scene.text.Text;

import java.io.*;
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

    public void borrarTarea(Text titulo) {
        lista.remove(titulo);
        almacenar();
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
    public boolean cargarTareasArchivo () throws IOException{
        File archivo = new File(filepath);
        boolean existe = false;
        if ( archivo.exists() && archivo.isFile()){
            fis = new FileInputStream(filepath);
            lista.load(fis);
            existe = true;
        } else System.out.println("¡NO HAY ARCHIVO DE TAREAS!");
        return existe;
    }

    /*@Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

       try{
            // Leemos las tareas del archivo
            boolean hayTareas = lista.cargarTareasArchivo();
            if (hayTareas){
                Iterator<String> it = App.tareas.devuelveIteradorClaves();
                //Recorremos el iterador de las claves para obtener los valores de ir creando filas con ambos valores
                while (it.hasNext()) {
                    String k = it.next();
                    String d = App.tareas.getValor(k); //Gestion tarea modelo
                    crearTarea(k, d); //Gestion tarea vista
                }

            }
        } catch (IOException e){
            throw new RuntimeException(e);
        }

}
     */



}