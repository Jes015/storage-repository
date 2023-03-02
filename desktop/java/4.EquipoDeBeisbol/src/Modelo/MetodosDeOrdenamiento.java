package Modelo;

/**
 *
 * @author Jes015
 */
public class MetodosDeOrdenamiento {

    private ListaEnlazadaSimple lista;

    public MetodosDeOrdenamiento(ListaEnlazadaSimple lista) {
        this.lista = lista;
    }

    public void ordenarPorBurbuja() {
        Nodo actual;
        Jugador temporal;

        for (int i = 0; i < this.lista.getTamanio()-1; i++) {
            
            actual = this.lista.getCabeza();
            
            while (actual.getSiguienteNodo() != null) {

                if (actual.getJugador().getPromedioBateo() > actual.getSiguienteNodo().getJugador().getPromedioBateo()) {
                    
                    temporal = actual.getJugador();
                    actual.setJugador(actual.getSiguienteNodo().getJugador());
                    actual.getSiguienteNodo().setJugador(temporal);
                    
                }
                actual = actual.getSiguienteNodo();
            }
        }
    }

}
