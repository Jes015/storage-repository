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
public class Alarma extends Thread {

    private Relog Fecha;
    private Dia diaActual;
    private final Actividad[] ActividadesActuales;
    private byte indiceActividadesyNotificaciones;
    private Notificacion[] notificaciones;

    public Alarma(Modelo.Relog horaActual) {
        this.Fecha = horaActual;

        int posicionDiaEnLista = -1;
        for (int i = 0; i < Modelo.Horario.dias.length; i++) {
            if(this.Fecha.getDia().equalsIgnoreCase(Modelo.Horario.dias[i])){
                posicionDiaEnLista = i;
            }
        }
        
        if (posicionDiaEnLista != -1) {
            this.diaActual = new Modelo.Dia(Modelo.Horario.dias[posicionDiaEnLista], Modelo.FileManager.listaRutasDias[posicionDiaEnLista]);
            this.ActividadesActuales = new Actividad[diaActual.getActividades().length];
            this.notificaciones = new Notificacion[diaActual.getActividades().length];
            this.indiceActividadesyNotificaciones = 0;
        }else{
            this.ActividadesActuales = null;
            ComplementaryMethods.showMessage("Error al momento de determinar el dia. clase Alarma");
        }
    }

    @Override
    public void run() {
        try {
            establecerActividad();
        } catch (InterruptedException ex) {
            Logger.getLogger(Alarma.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void establecerActividad() throws InterruptedException {
        while (true) {
            if (indiceActividadesyNotificaciones < diaActual.getActividades().length) {
                for (int i = 0; i < diaActual.getActividades().length; i++) {
                    if (diaActual.getActividades()[i] != null) {
                        String[] horaFormateada = Fecha.getHoraMinutoaYSegundos().split(":");
                        if ((diaActual.getActividades()[i].getHora() == Byte.valueOf(horaFormateada[0])) && ((diaActual.getActividades()[i].getMinutos() <= Byte.valueOf(horaFormateada[1]) + 5) && (diaActual.getActividades()[i].getMinutos() >= Byte.valueOf(horaFormateada[1]) - 2))) {

                            if (this.isDisponible(this.diaActual.getActividades()[i])) {
                                this.ActividadesActuales[indiceActividadesyNotificaciones] = this.diaActual.getActividades()[i];
                                this.notificaciones[indiceActividadesyNotificaciones] = new Notificacion(this.ActividadesActuales[indiceActividadesyNotificaciones]);
                                this.notificaciones[indiceActividadesyNotificaciones].mostrarNotificacion();
                                indiceActividadesyNotificaciones++;
                            }
                        }

                    }
                }
            }
            Thread.sleep(3000);
        }
    }

    private boolean isDisponible(Modelo.Actividad actividad) {
        for (int i2 = 0; i2 < indiceActividadesyNotificaciones; i2++) {
            if (this.ActividadesActuales[i2] != null) {
                if (this.ActividadesActuales[i2] == actividad) {
                    return false;
                }
            }
        }
        return true;
    }
}
