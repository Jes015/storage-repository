/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jes015
 */
public class Relog extends Thread {

    private String dia, hora;

    private byte horas, minutos, segundos;

    private java.util.GregorianCalendar calendario;

    private boolean modoInterfaz;

    private javax.swing.JLabel labelHoraInterfaz;

    public Relog() {

        this.modoInterfaz = true;

        this.calendario = new java.util.GregorianCalendar();

        this.horas = (byte) (int) calendario.get(java.util.GregorianCalendar.HOUR_OF_DAY);

        this.minutos = (byte) (int) calendario.get(java.util.GregorianCalendar.MINUTE);

        this.segundos = (byte) (int) calendario.get(java.util.GregorianCalendar.SECOND);

        //Obtener el dia en español segun las iniciales del dia en ingles
        String diaProcesado = calendario.getTime().toString().split(" ")[0];

        if (diaProcesado.equalsIgnoreCase("Mon")) {
            diaProcesado = Modelo.Horario.dias[0];
        } else if (diaProcesado.equalsIgnoreCase("Tue")) {
            diaProcesado = Modelo.Horario.dias[1];
        } else if (diaProcesado.equalsIgnoreCase("Wed")) {
            diaProcesado = Modelo.Horario.dias[2];
        } else if (diaProcesado.equalsIgnoreCase("Thu")) {
            diaProcesado = Modelo.Horario.dias[3];
        } else if (diaProcesado.equalsIgnoreCase("Fri")) {
            diaProcesado = Modelo.Horario.dias[4];
        } else if (diaProcesado.equalsIgnoreCase("Sat")) {
            diaProcesado = Modelo.Horario.dias[5];
        } else if (diaProcesado.equalsIgnoreCase("Sun")) {
            diaProcesado = Modelo.Horario.dias[6];
        }

        this.dia = diaProcesado;

    }

    @Override
    public void run() {
        try {
            while (true) {
                actualizarHora();
                Thread.sleep(1000);
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Relog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void actualizarHora() throws InterruptedException {

        this.labelHoraInterfaz.setText(this.getDiayHora());
        if (segundos < 60) {
            segundos++;
            if (segundos == 60) {
                segundos = 0;
                if (minutos < 60) {
                    minutos++;
                    if (minutos == 60) {
                        minutos = 0;
                        if (horas < 24) {
                            horas++;
                            if (horas == 24) {
                                horas = 0;
                            }
                        }
                    }
                }
            }

        }

    }

    public void setLabelHora(javax.swing.JLabel labelHora) {
        this.labelHoraInterfaz = labelHora;
    }

    public String getHoraMinutoaYSegundos() {

        String horaFormateada, minutoFormateada, segundoFormateada;

        horaFormateada = (this.horas < 10) ? "0" + String.valueOf(this.horas) : String.valueOf(this.horas);
        minutoFormateada = (this.minutos < 10) ? "0" + String.valueOf(this.minutos) : String.valueOf(this.minutos);
        segundoFormateada = (this.segundos < 10) ? "0" + String.valueOf(this.segundos) : String.valueOf(this.segundos);

        return horaFormateada + ":" + minutoFormateada + ":" + segundoFormateada;
    }

    public String getDia() {
        return this.dia;
    }
    
    public String getDiayHora(){
        return this.dia+", "+this.getHoraMinutoaYSegundos();
    }

}
