
package Modelo;

/**
 *
 * @author Jes015
 */
public class Nodo {
    
    private Jugador jugador;
    private Nodo siguiente;
    
    public Nodo(){
        this.jugador = null;
    }
    
    public Nodo(Jugador jugador){
        this.jugador = jugador;
    }
    
    public void setJugador(Jugador jugador){
        this.jugador = jugador;
    }
    public Jugador getJugador(){
        return this.jugador;
    }
    
    public void setSiguienteNodo(Nodo nodo){
        this.siguiente = nodo;
    }
    public Nodo getSiguienteNodo(){
        return this.siguiente;
    }
    
    @Override
    public String toString(){
        return this.jugador.toString();
    }

}
