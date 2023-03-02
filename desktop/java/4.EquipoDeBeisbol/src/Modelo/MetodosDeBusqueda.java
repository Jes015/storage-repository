package Modelo;

/**
 *
 * @author Jes015
 */
public class MetodosDeBusqueda {

    ListaEnlazadaSimple lista;

    public MetodosDeBusqueda(ListaEnlazadaSimple lista) {
        this.lista = lista;
    }

    public Nodo buscarJugadorSequencial(String busqueda) {

        Nodo nodoTemporal = this.lista.getCabeza();

        while (nodoTemporal != null) {
            if (nodoTemporal.getJugador().getNombre().equalsIgnoreCase(busqueda) || nodoTemporal.getJugador().getNumIdentificacion().equalsIgnoreCase(busqueda)) {
                return nodoTemporal;
            }
            nodoTemporal = nodoTemporal.getSiguienteNodo();
        }

        return null;
    }
}
