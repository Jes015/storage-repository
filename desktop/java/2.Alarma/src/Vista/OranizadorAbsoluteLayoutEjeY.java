/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

/**
 *
 * @author Jes015
 */
public class OranizadorAbsoluteLayoutEjeY {
    
    /*
    Lo uso para el absoluteLayout
    Se utiliza la clase Dimension para almacenar el valor del eje Y y eje X.
    */
    
    private final int posicionesEnY[];
    private final boolean posicionEnYDisponible[];
    
    public OranizadorAbsoluteLayoutEjeY(int cantidadDePosiciones,int espacioEntreElementos,int margenDelPrimerElemento){
        this.posicionesEnY = new int[cantidadDePosiciones];
        this.posicionEnYDisponible = new boolean[cantidadDePosiciones];
        
        
        
        posicionesEnY[0] = margenDelPrimerElemento;
        
        for(int i = 1;i<this.posicionesEnY.length;i++){
            this.posicionesEnY[i] = i*espacioEntreElementos;
        }
        
        for(int i = 0;i<this.posicionEnYDisponible.length;i++){
            this.posicionEnYDisponible[i] = true;
        }
    }
    
    //Retorna la primera posicion de la lista
    public int obtenerPrimeraPosicion(){
        this.posicionEnYDisponible[0] = false;
        return posicionesEnY[0];
    }
    
    //Retornara el espacio que este disponible y lo marco como ocupado
    public int obtenerEspacioDisponible(){
        for(int i = 0;i<this.posicionesEnY.length;i++){
            if(this.posicionEnYDisponible[i]==true){
                this.posicionEnYDisponible[i] = false;
                return this.posicionesEnY[i];
            }
        }
        return -1;
    }
    
    //Reseetea la disponibilidad de los espacios
    public void resetearEspacios(){
        for(int i = 0;i<this.posicionesEnY.length;i++){
            this.posicionEnYDisponible[i] = true;
        }
    }
    
    
}
