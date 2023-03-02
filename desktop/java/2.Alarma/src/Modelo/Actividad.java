/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Jes015
 */
public class Actividad {

    private String nombre;
    private String horaSinProcesar;
    private byte hora,minutos;

    public Actividad(String nombre, String hora) {
        this.nombre = nombre;
        this.horaSinProcesar = hora;
        
        String[] horaProcesada = horaSinProcesar.split(":");
        
        this.hora = Byte.valueOf(horaProcesada[0]);
        this.minutos = Byte.valueOf(horaProcesada[1]);
        
    }

    public String getNombreActividad() {
        return this.nombre;
    }

    public String getHoraActividad() {
        return this.horaSinProcesar;
    }
    
    public byte getHora(){
        return this.hora;
    }
    
    public byte getMinutos(){
        return this.minutos;
    }

   

}
