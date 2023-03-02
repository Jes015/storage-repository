/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Jes015
 */
public class Libro {

    private String nombre, sinopsis, rutaImagen;
    private int codigoLibro;
    private boolean disponibilidad;

    public Libro() {
        nombre = "";
        sinopsis = "";
        codigoLibro = 0;
        disponibilidad = true;
    }

    public void establecerDatos(String nombre, String sinopsis,int codigoLibro, String rutaImagen) {
        this.nombre = nombre;
        this.codigoLibro = codigoLibro;
        this.sinopsis = sinopsis;
        if (rutaImagen.trim().equalsIgnoreCase("")) {
            this.rutaImagen = "/home/joyolaa/Documents/Imagenes Creativas/NO IMAGEN.png";
        } else {
            this.rutaImagen = rutaImagen;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public int getCodigoLibro() {
        return codigoLibro;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

}
