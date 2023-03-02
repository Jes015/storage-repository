/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Jes015
 */
public class Horario {

    public static final String dias[] = {"Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo"};

    private Dia[] diasClase;

    public Horario() {

        try {
            if (FileManager.mkdirs() && FileManager.verificarExistenciaOCrearArchivos()) {
                this.inicializarAtributosGlobales();
            } else {
                ComplementaryMethods.showMessage("Error al cargar o crear los archivos y directorios.");
            }
        }catch(Exception io){
            System.out.println("Error clase horario : "+ io);
        }

    }

    public final void inicializarAtributosGlobales() {
        this.diasClase = new Dia[dias.length];

        for (int i = 0; i < dias.length; i++) {
            diasClase[i] = new Dia(dias[i], FileManager.listaRutasDias[i]);
        }
    }

    public void addActividadADia(Dia dia, Actividad actividad) {

    }

    public void eliminarActividadADia(Dia dia, Actividad actividad) {
    }

    public Dia[] getDias() {
        return this.diasClase;
    }

    private Dia buscarDia(String nombreDia) {
        for (int i = 0; i < diasClase.length; i++) {
            if (diasClase[i].getNombre().equalsIgnoreCase(nombreDia)) {
                return diasClase[i];
            }
        }
        return null;
    }
}
