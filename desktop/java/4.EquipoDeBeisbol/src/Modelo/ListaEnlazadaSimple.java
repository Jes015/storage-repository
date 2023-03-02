package Modelo;

/**
 *
 * @author Jes015
 */
public class ListaEnlazadaSimple {

    private Nodo cabeza;
    private int tamanio;

    public ListaEnlazadaSimple() {
        this.cabeza = null;
        this.tamanio = 0;
    }

    public int getTamanio() {
        return this.tamanio;
    }

    private void setCabeza(Nodo nodo) {
        this.cabeza = nodo;
    }

    public Nodo getCabeza() {
        return this.cabeza;
    }

    private Nodo getUltimoNodo() {

        Nodo temporal = cabeza;

        while (temporal != null) {
            if (temporal.getSiguienteNodo() == null) {
                break;
            } else {
                temporal = temporal.getSiguienteNodo();
            }
        }
        return temporal;
    }

    public void agregarNodoAlPrincipio(Nodo nodo) {

        if (cabeza == null) {
            this.cabeza = nodo;
        } else {
            nodo.setSiguienteNodo(this.cabeza);
            this.setCabeza(nodo);
        }
        this.tamanio++;
    }

    public void agregarNodoAlFinal(Nodo nodo) {

        if (cabeza == null) {
            this.cabeza = nodo;
        } else {
            this.getUltimoNodo().setSiguienteNodo(nodo);
        }
        this.tamanio++;
    }

    public void agregarDespuesDeUnNodo(Nodo nodop, Nodo nuevo) {

        nuevo.setSiguienteNodo(nodop.getSiguienteNodo());
        nodop.setSiguienteNodo(nuevo);
        this.tamanio++;
    }

    public void eliminarNodo(Nodo nodo) {

        if (this.cabeza == nodo) {
            this.setCabeza(this.cabeza.getSiguienteNodo());
        } else {

            Nodo temporal = this.cabeza;

            while (temporal.getSiguienteNodo() != nodo) {
                temporal = temporal.getSiguienteNodo();
            }

            temporal.setSiguienteNodo(nodo.getSiguienteNodo());
            nodo.setSiguienteNodo(null);
            this.tamanio--;
        }

    }
}
