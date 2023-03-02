
package Modelo;

/**
 *
 * @author Jes015
 */
public class Jugador {
    
    private String nombre,numIdentificacion;
    private byte edad;
    private Posicion posicion;
    private float promedioBateo;
    
    public Jugador(){
        this.numIdentificacion = "";
        this.nombre = "";
        this.edad = 0;
        this.posicion = null;
        this.promedioBateo = 0;
    }
    
    public Jugador(String numID,String nombre,byte edad,Posicion posicion,float promedioBateo){
        this.numIdentificacion = numID;
        this.nombre = nombre;
        this.edad = edad;
        this.posicion = posicion;
        this.promedioBateo = promedioBateo;
    }
    
    public void setNumIdentificacion(String num){
        this.numIdentificacion = num;
    }
    public String getNumIdentificacion(){
        return this.numIdentificacion;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public String getNombre(){
        return this.nombre;
    }
    
    public void setEdad(byte edad){
        this.edad = edad;
    }
    public byte getEdad(){
        return this.edad;
    }
    
    public void setPosicion(Posicion pos){
        this.posicion = pos;
    }
    public Posicion getPosicion(){
        return this.posicion;
    }
    
    public void setPromedioBateo(float promedio){
        this.promedioBateo = promedio;
    }
    public float getPromedioBateo(){
        return this.promedioBateo;
    }
    
    @Override
    public String toString(){
        return this.getNombre()+", "+this.getNumIdentificacion()+", "+this.getEdad()+", "+this.getPosicion()+", "+this.getPromedioBateo();
    }
}
