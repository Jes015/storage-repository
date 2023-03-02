/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.io.IOException;

/**
 *
 * @author Jes015
 */
public final class FileManager {

    //Directorios
    private final static java.io.File directorioPrincipal = new java.io.File("principal"), directoriodias = new java.io.File("principal/dias");

    //Lista que almacena la ruta de los archivos que almacenan las actividades de los dias
    public final static String[] listaRutasDias = {"principal/dias/lunes.txt", "principal/dias/martes.txt", "principal/dias/miercoles.txt", "principal/dias/jueves.txt", "principal/dias/viernes.txt", "principal/dias/sabado.txt", "principal/dias/domingo.txt"};

    //Archivos
    private final static java.io.File listaArchivosDias[] = {new java.io.File(FileManager.listaRutasDias[0]), new java.io.File(FileManager.listaRutasDias[1]), new java.io.File(FileManager.listaRutasDias[2]), new java.io.File(FileManager.listaRutasDias[3]), new java.io.File(FileManager.listaRutasDias[4]), new java.io.File(FileManager.listaRutasDias[5]), new java.io.File(FileManager.listaRutasDias[6])};

    /*
    Dias en las listas
    
    0 -> Lunes
    
    1 -> Martes
    
    2 -> Miercoles
    
    3 -> Jueves
    
    4 -> Viernes
    
    5 -> Sabado
    
    6 -> Domingo
     */
    private FileManager() {
    }

    //Crea o verifica la existencia de los directorios necesarios
    public static final boolean mkdirs() {
        try {
            if (directoriodias.mkdirs()) {
                ComplementaryMethods.showMessage("Directorios necesarios para el funcionamiento del programa fueron creados.");
            }
            return true;
        } catch (Exception io) {
            ComplementaryMethods.showMessage("Error al crear o verificar existencia de directorios");
            return false;
        }
    }

    //Crear o verificar la existencia de archivos necesatrios
    public static final boolean verificarExistenciaOCrearArchivos() throws IOException {

        String mensajeEnPantalla = "Archivos de dias creados : ";

        for (int i = 0; i < FileManager.listaArchivosDias.length; i++) {
            if (FileManager.listaArchivosDias != null) {
                if (FileManager.listaArchivosDias[i] != null) {
                    if (FileManager.listaArchivosDias[i].createNewFile()) {
                        mensajeEnPantalla += i + ", ";
                    }
                } else {
                    ComplementaryMethods.showMessage("El elemento en la posicion " + i + " de la lista listaRutasDias no ha sido inicializado contacte al programador.");
                    return false;
                }
            } else {
                ComplementaryMethods.showMessage("La lista donde estan la ruta de los dias no ha sido inicializada contacte al programador.");
                return false;
            }
        }

        if (!(mensajeEnPantalla.equalsIgnoreCase("Archivos de dias creados : "))) {
            mensajeEnPantalla = mensajeEnPantalla.substring(0, mensajeEnPantalla.length() - 2);
            mensajeEnPantalla += ".";
            ComplementaryMethods.showMessage(mensajeEnPantalla);
        }
        return true;

    }

    public static String readTextFile(String RutaArchivoDia) {

        try {
            java.io.BufferedReader reader = null;

            //Buscamos la ruta y le asigamos el archivo al BufferedReader
            for (int i = 0; i < FileManager.listaArchivosDias.length; i++) {
                if (RutaArchivoDia.equalsIgnoreCase(FileManager.listaRutasDias[i])) {
                    reader = new java.io.BufferedReader(new java.io.FileReader(FileManager.listaArchivosDias[i]));
                    break;
                } else {
                    if (i == FileManager.listaArchivosDias.length - 1) {
                        System.out.println("Reader : Ruta desconocida.");
                        return null;
                    }
                }
            }

            if (reader != null) {

                String texto = "";
                String textoaretornar = "";
                while (texto != null) {
                    textoaretornar += texto;
                    texto = reader.readLine();

                }
                reader.close();
                return textoaretornar;
            }
        } catch (Exception io) {
            System.out.println("Reader : error al leer el archivo.");
        }

        return null;
    }

    public static final void writeTextFile(String rutaArchivo, Modelo.Actividad[] actividades) {
        try {
            java.io.BufferedWriter writer = null;

            //Buscamos la ruta y le asigamos el archivo BufferedWriter
            for (int i = 0; i < FileManager.listaArchivosDias.length; i++) {
                if (rutaArchivo.equalsIgnoreCase(FileManager.listaRutasDias[i])) {
                    writer = new java.io.BufferedWriter(new java.io.FileWriter(FileManager.listaArchivosDias[i]));
                    break;
                } else {
                    if (i == FileManager.listaArchivosDias.length - 1) {
                        System.out.println("Writer : Ruta desconocida.");
                    }
                }
            }

            if (writer != null) {
                writer.write("Actividades");
                writer.newLine();
                writer.write("&");
                for (int i = 0; i < actividades.length; i++) {
                    if (actividades[i] != null) {
                        writer.write(actividades[i].getNombreActividad() + " - " + actividades[i].getHoraActividad());
                        writer.newLine();
                        writer.write("&");
                    }
                }

                writer.close();
            }

        } catch (Exception io) {
            System.out.println("Writer : error al escribir el archivo.");

        }
    }
}
