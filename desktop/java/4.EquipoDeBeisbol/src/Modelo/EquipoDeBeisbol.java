package Modelo;

/**
 *
 * @author Jes015
 */
public class EquipoDeBeisbol {

    private ListaEnlazadaSimple lista;
    private MetodosDeBusqueda busqueda;
    private MetodosDeOrdenamiento ordenamiento;

    public EquipoDeBeisbol() {
        this.lista = new ListaEnlazadaSimple();
        this.busqueda = new MetodosDeBusqueda(lista);
        this.ordenamiento = new MetodosDeOrdenamiento(lista);
    }

    public boolean agregarJugador(Nodo nodo, String pos) {
        if (buscarJugador(nodo.getJugador().getNumIdentificacion()) == null) {
            if (pos.equalsIgnoreCase("inicio")) {
                this.lista.agregarNodoAlPrincipio(nodo);
            } else if (pos.equalsIgnoreCase("final")) {
                this.lista.agregarNodoAlFinal(nodo);
            }
            return true;
        }
        return false;

    }

    public void agregarJugador(Nodo nodoSeleccionado, Nodo nuevoNodo) {
        this.lista.agregarDespuesDeUnNodo(nodoSeleccionado, nuevoNodo);
    }

    public void ordenarLista() {
        this.ordenamiento.ordenarPorBurbuja();
    }

    public Nodo buscarJugador(String nombreOID) {
        return this.busqueda.buscarJugadorSequencial(nombreOID);
    }

    public void eliminarJugador(Nodo nodo) {
        this.lista.eliminarNodo(nodo);
    }

    public ListaEnlazadaSimple getLista() {
        return this.lista;
    }



}
