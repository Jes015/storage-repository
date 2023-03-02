/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Jes015
 */
public class Persona {
    
    private String nombre,direccion,sexo;
    private double telefono,identificacion;
    
    public Persona(){
        nombre = "";
        direccion = "";
        sexo = "";
        telefono = 0;
        identificacion = 0;
    }
    
    public void establecerDatos(String nombre,String direccion,String sexo,double telefono,double identificacion){
        this.nombre = nombre;
        this.direccion = direccion;
        this.sexo = sexo;
        this.telefono = telefono;
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getSexo() {
        return sexo;
    }

    public double getTelefono() {
        return telefono;
    }

    public double getIdentificacion() {
        return identificacion;
    }
    
    
    
}
