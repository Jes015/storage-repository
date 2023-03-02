/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Jes015
 */
public class Bibliotecario extends Persona {

    //Constructor
    public Bibliotecario() {
        super();
    }

    //Método que le permite a la/el bibliotecari@ prestar libros.
    public boolean prestarLibro(Libro libro, Suscriptor suscriptor) {

        //Estructuras de seleccion para determinar si el libro esta disponible y si el suscriptor puede prestar mas libros.
        if (libro.isDisponibilidad() == true) {
            if (suscriptor.prestarLibro(libro)) {
                //Si el suscriptor presto el libro, la disponibilidad del libro se establece como false.
                libro.setDisponibilidad(false);
                return true;
            }
        } else {
            metodosComplementarios.mostrarMensaje("No se puede prestar este libro debido que ya ha sido prestado.");
        }

        return false;
    }

    //Método que le permite a la/el bibliotecari@ recibir libros. en la vista mostrar los libros que tiene el suscriptor y asi establecer el libro como argumento
    public boolean recibirLibros(Libro libro, Suscriptor suscriptor) {

        if (libro.isDisponibilidad() == false) {
            if (suscriptor.devolverLibro(libro)) {
                //Si el suscriptor presto el libro y lo devolvió, la disponibilidad del libro se establece como true.
                libro.setDisponibilidad(true);
                return true;
            } else {
                //Usamos el metodo mostrarMensaje() de la clase metodosComplementarios para mostrar al usuario un mensaje en pantalla.
                metodosComplementarios.mostrarMensaje("El suscriptor " + suscriptor.getNombre() + " no puede devolver este libro debido a que el no lo prestó.");
            }
        } else {
            metodosComplementarios.mostrarMensaje("Este libro no ha sido prestado.");
        }
        return false;

    }

}
