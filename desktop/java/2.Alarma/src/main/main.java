/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.io.IOException;

/**
 *
 * @author Jes015
 */
public class main {

    public static void main(String[] args) throws IOException, InterruptedException {

        
        //Reloj
        Modelo.Relog horitas = new Modelo.Relog();
        
        
        Vista.VistaPrincipalHorario vista = new Vista.VistaPrincipalHorario(horitas);
        vista.setVisible(true);
        
        horitas.setLabelHora(vista.getLabelHora());
        
        
        Modelo.Alarma aa = new Modelo.Alarma(horitas);
        
        
        horitas.start();//Primero la hora*********
        
        aa.start(); 
        System.out.println("aaaaaaaa");
        
        
        
        
        

    }
}
