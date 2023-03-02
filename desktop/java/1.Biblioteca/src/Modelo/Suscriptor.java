/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Jes015
 */
public class Suscriptor extends Persona {

    //Declaramos los atributos globales y los encapsulamos
    private Libro[] libros;
    private short numeroMaximoDeLibros;
    private int codigo;

    //Constructor
    public Suscriptor(short numeroMaximoDeLibros) {
        super();

        //Inicializamos el numeroMaximoDeLibros que tendra el usuario y se lo asignamos a la cantidad de posiciones que tendra la lista.
        this.numeroMaximoDeLibros = numeroMaximoDeLibros;
        libros = new Libro[this.numeroMaximoDeLibros];

        codigo = 0;
    }

    //Método que permite agregarle un libro a un suscriptor : retornara true si el suscriptor puede prestar el libro, si no puede retornara false.
    public boolean prestarLibro(Libro libro) {

        //Usamos el metodo buscarEspacioDisponibleEnLista() de la clase metodosComplementarios para encontrar un espacio disponible en la lista.
        int posicion = metodosComplementarios.buscarEspacioDisponibleEnLista(libros);

        //Estructira de seleccion para determinar si el suscriptor puede prestar mas libros
        if (posicion == -1) {
            //Usamos el metodo mostrarMensaje() de la clase metodosComplementarios para mostrar al usuario un mensaje en pantalla.
            metodosComplementarios.mostrarMensaje("El suscriptor " + super.getNombre() + " no puede prestar mas libros.");
        } else {
            //Establecemos el objeto pasado por el parametro "libro" a la posicion que nos retorno el método buscarEspacioDisponibleEnLista()
            libros[posicion] = libro;
            metodosComplementarios.mostrarMensaje("Se ha prestado el libro " + libro.getNombre() + " al suscriptor " + this.getNombre() + ".");
            return true;
        }

        return false;
    }

    //Método que permite a un suscriptor devolver un libro : retornara true si el suscriptor puede devolver el libro, si no puede retornara false.
    public boolean devolverLibro(Libro libro) {

        //Usamos el metodo buscarIndiceDeElementoEnLista() de la clase metodosComplementarios para encontrar el indice del libro en la lista libros.
        int indiceLibro = metodosComplementarios.buscarIndiceDeElementoEnLista(this.libros, libro);

        //Estructura de seleccion para determinar si el suscriptor puede devolver un libro
        if (indiceLibro == -1) {
            return false;
        } else {
            //Le damos como valor null al elemento en la posicion indiceLibro de la lista libros debido a que el suscriptor devolvio el libro.
            this.libros[indiceLibro] = null;
            return true;
        }

    }

    //Métodos accesores
    public Libro[] getLibros() {
        return this.libros;
    }

    public void establecerDatos(String nombre, String direccion, String sexo, double telefono, double identificacion, int codigo) {
        super.establecerDatos(nombre, direccion, sexo, telefono, identificacion);
        this.codigo = codigo;
    }

    public int getCodigo() {
        return this.codigo;
    }

}
