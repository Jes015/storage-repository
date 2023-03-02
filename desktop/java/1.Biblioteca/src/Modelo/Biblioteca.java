/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Modelo;

/**
 *
 * @author Jes015
 */
public class Biblioteca {

    private Libro[] librosDisponibles;
    private Suscriptor[] suscriptores;
    private Bibliotecario bibliotecario;
    private String[] historialDePrestamos;
    private int posHistorialDePrestamos;

    public Biblioteca(int tamañoLibrosDisponibles, int tamañoSuscriptores) {
        librosDisponibles = new Libro[tamañoLibrosDisponibles];

        this.addLibro("el nombre", "la sinopsis", 123, "");
        this.addLibro("la emvra", "la sinopsis", 324, "");
        this.addLibro("la gallina mataraza", "la sinopsis", 345, "");
        this.addLibro("esperanza y su lucha", "la sinopsis", 234, "");
        this.addLibro("las cosas", "la sinopsis", 654, "");
        this.addLibro("las cosas 2", "la sinopsis", 765, "");
        this.addLibro("las cosas 3: revolucion", "la sinopsis", 4325, "");
        this.addLibro("pepe", "la sinopsis", 987, "");
        this.addLibro("el gallo lucas", "la sinopsis", 7655, "");
        this.addLibro("el zorro", "la sinopsis", 679, "");
        this.addLibro("el gato con botas", "la sinopsis", 354, "");
        this.addLibro("el dicho", "la sinopsis", 54637, "");
        this.addLibro("mas perro que nunca", "la sinopsis", 67845, "");
        this.addLibro("el paseo 132", "la sinopsis", 25467, "");
        this.addLibro("la emvra: reencarnacion", "la sinopsis", 6784, "");
        this.addLibro("la emvra: el apocalipsis", "la sinopsis", 3454376, "");
        this.addLibro("el nombre: sus juegos", "la sinopsis", 65743, "");
        this.addLibro("sociedad y monos", "la sinopsis", 4325345, "");
        this.addLibro("pepe: el loro segund parte", "la sinopsis", 5674, "");
        this.addLibro("como puede ser", "la sinopsis", 54647, "");
        this.addLibro("lo imposible", "la sinopsis", 678786, "");
        this.addLibro("la naturaleza", "la sinopsis", 56754, "");

        suscriptores = new Suscriptor[tamañoSuscriptores];
        suscriptores[2] = new Suscriptor((short) (int) 2);
        suscriptores[2].establecerDatos("pepe", "asd", "macho", 324324432, 32432, 4);
        historialDePrestamos = new String[500];
        posHistorialDePrestamos = 0;

        bibliotecario = new Bibliotecario();
    }

    public void prestarLibro(Libro libro, int codigoSuscriptor) {

        //Variable local para almacenar el indice que retorna el metodo buscarSuscriptor
        int posicionSuscriptor = buscarSuscriptor(codigoSuscriptor);

        /*Estructura de seleccion para evaluar lo que le retorno el método buscarSuscriptor a la variable posicionSuscriptor, si no encontro ningun suscriptor con ese codigo directamente mostrara un mensaje en pantalla
          Si lo encontro creara e inicializara una variable de tipo Suscriptor la cual se le pasa como argumento al metodo prestarLibro del objeto bibliotecario
        
         */
        if (posicionSuscriptor == -1) {
            metodosComplementarios.mostrarMensaje("El codigo de suscriptor que ingresó no es valido");
        } else {
            Suscriptor suscriptor = suscriptores[posicionSuscriptor];
            //El método prestarLibro de la clase biblioteca devuelve true si logra prestar el libro, sino devuelve false.
            if (bibliotecario.prestarLibro(libro, suscriptor)) {
                historialDePrestamos[posHistorialDePrestamos] = (posHistorialDePrestamos + 1) + ". " + suscriptor.getNombre() + " presto con exito el libro " + libro.getNombre() + ".";
                posHistorialDePrestamos++;
            } else {
                historialDePrestamos[posHistorialDePrestamos] = (posHistorialDePrestamos + 1) + ". " + suscriptor.getNombre() + " intento prestar el " + libro.getNombre() + " pero no fue aceptada su peticion.";
                posHistorialDePrestamos++;
            }
        }
    }

    public void devolverLibro(int codigoLibro, Suscriptor suscriptor) {

        int posicionLibro = buscarLibro(codigoLibro);
        
        if(posicionLibro==-1){
            metodosComplementarios.mostrarMensaje("Libro no encontrado.");
        }else{
            bibliotecario.recibirLibros(librosDisponibles[posicionLibro], suscriptor);
        }
        
        

    }

    //Método que busca el indice de un suscriptor en la lista suscriptores por su codigo,si encuentra que el codigo pasado por parametro es igual a algun codigo de algun suscriptor de la lista suscriptores retornara la posicion del suscriptor en la lista, sino encuentra nada retornara -1
    private int buscarSuscriptor(int codigo) {
        for (int i = 0; i < suscriptores.length; i++) {
            if (suscriptores[i] != null) {
                if (suscriptores[i].getCodigo() == codigo) {
                    return i;
                }
            }
        }
        return -1;
    }

    //Metodo que nos permite buscar a un libro por su codigo, si encuentra el codigo que paso el usuario en alguno de los libros de la lista retornara true, de lo contrario retornara false 
    private int buscarLibro(int codigo) {
        for (int i = 0; i < librosDisponibles.length; i++) {
            if (librosDisponibles[i] != null) {
                if (librosDisponibles[i].getCodigoLibro() == codigo) {
                    return i;
                }
            }
        }
        return -1;
    }

    public final void addLibro(String nombre, String sinopsis, int codigoLibro, String rutaImagen) {

        //Estructura de seleccion para determinar si el codigo de libro que esta intentando ingresar el usuario esta libre o no
        if (buscarLibro(codigoLibro) == -1) {
            //Declaramos e inicializamos una variable local de tipo libro,usamos el metodo establecer datos y le asignamos la variable de tipo local a la lista en la posicion que nos retorne el metodo buscarEspacioDIsponibleEnLista de la clase MetodosComplementarios
            Libro libro = new Libro();
            libro.establecerDatos(nombre, sinopsis, codigoLibro, rutaImagen);
            librosDisponibles[metodosComplementarios.buscarEspacioDisponibleEnLista(librosDisponibles)] = libro;
            metodosComplementarios.mostrarMensaje("Libro " + libro.getNombre() + " agregado al sistema.");
        } else {
            metodosComplementarios.mostrarMensaje("El codigo que intenta ingresar para el libro no esta disponible.");
        }
    }

    public void addSuscriptor(String nombre, String direccion, String sexo, double telefono, double identificacion, int codigoSuscriptor, short maximoDeLibros) {

        if (buscarSuscriptor(codigoSuscriptor) == -1) {
            //Declaramos e inicializamos una variable local de tipo libro,usamos el metodo establecer datos y le asignamos la variable de tipo local a la lista en la posicion que nos retorne el metodo buscarEspacioDIsponibleEnLista de la clase MetodosComplementarios
            Suscriptor suscriptor = new Suscriptor(maximoDeLibros);
            suscriptor.establecerDatos(nombre, direccion, sexo, telefono, identificacion, codigoSuscriptor);
            suscriptores[metodosComplementarios.buscarEspacioDisponibleEnLista(suscriptores)] = suscriptor;
            metodosComplementarios.mostrarMensaje("Suscriptor " + suscriptor.getNombre() + " agregado al sistema.");

        } else {
            metodosComplementarios.mostrarMensaje("El codigo que intenta ingresar para el suscriptor no esta disponible.");
        }
    }

    // Atributo : hola
    //texto : hola
    public Libro[] buscarLibros(String texto) {

        if (texto.trim().equals("")) {
            return getLibros();
        } else {
            byte pos = 0;
            Libro[] librosEncontrados = new Libro[20];
            for (int i = 0; i < this.librosDisponibles.length; i++) {
                if (librosDisponibles[i] != null) {
                    if (texto.length() <= librosDisponibles[i].getNombre().length()) {
                        if (texto.trim().equalsIgnoreCase(librosDisponibles[i].getNombre().substring(0, texto.length()))) {
                            librosEncontrados[pos] = librosDisponibles[i];
                            pos++;
                        }
                    }
                }
            }
            return librosEncontrados;
        }

    }

    
    public Suscriptor getSuscriptor(int codigo) {
        int posicionSuscriptor = buscarSuscriptor(codigo);
        if(posicionSuscriptor==-1){
            metodosComplementarios.mostrarMensaje("Suscriptor no encontrado.");
            return null;
        }else{
            return this.suscriptores[posicionSuscriptor];
        }
        
    }
    
    //Métodos accesores
    public Libro[] getLibros() {
        return this.librosDisponibles;
    }
    
    public String[] getHistorialDePrestamos() {
        return this.historialDePrestamos;
    }

}
