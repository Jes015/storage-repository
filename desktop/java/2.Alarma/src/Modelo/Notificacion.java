/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Jes015
 */
public class Notificacion {
    
    private Actividad actividad;
    
    
    public Notificacion(Actividad actividad){
        this.actividad = actividad;
    }
    
    public void mostrarNotificacion(){
        
        Vista.VistaNotificacion VistaNotificacion = new Vista.VistaNotificacion(this.actividad);
        VistaNotificacion.setVisible(true);
    }
}
