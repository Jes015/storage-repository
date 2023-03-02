/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
/**
 *
 * @author Jes015
 */
import javax.swing.JOptionPane;

public class metodosComplementarios {

    public final static int buscarEspacioDisponibleEnLista(Object[] lista) {
        for (int i = 0; i < lista.length; i++) {
            if (lista[i] == null) {
                return i;
            }
        }
        return -1;
    }

    public final static void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Biblioteca", 1);
    }
    
    public final static int buscarIndiceDeElementoEnLista(Object[] lista, Object elemento) {

        for (int i = 0; i < lista.length; i++) {
            if (lista[i] != null) {
                if (lista[i].equals(elemento)) {
                    return i;
                }
            }
        }

        return -1;
    }

}
