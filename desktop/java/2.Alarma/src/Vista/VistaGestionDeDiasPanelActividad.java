/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vista;

/**
 *
 * @author Jes015
 */
public class VistaGestionDeDiasPanelActividad extends javax.swing.JPanel {

    private Modelo.Dia dia;
    private Modelo.Actividad actividad;
    private javax.swing.JPanel panelPadre;
    private VistaGestionDeDias vistaPadre;

    private int posicionEnEjeY;

    private javax.swing.JButton botonPadre;

    //Para agregar
    public VistaGestionDeDiasPanelActividad(VistaGestionDeDias vistaPadre, Modelo.Dia dia, javax.swing.JButton botonPadre) {
        initComponents();

        this.dia = dia;
        this.vistaPadre = vistaPadre;

        this.remove(jButton1);

        this.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 0, 70, 50));

        this.jButton2.setBounds(600, 0, 70, 50);

        this.jTextField1.setEditable(true);

        this.botonPadre = botonPadre;
    }

    //Para mostrar todas
    public VistaGestionDeDiasPanelActividad(VistaGestionDeDias vistaPadre, javax.swing.JPanel panelPadre, Modelo.Actividad actividad, Modelo.Dia dia, int posicionEnEjeY) {
        initComponents();

        this.dia = dia;
        this.panelPadre = panelPadre;
        this.actividad = actividad;
        this.vistaPadre = vistaPadre;

        this.posicionEnEjeY = posicionEnEjeY;

        jTextField1.setText("  " + this.actividad.getNombreActividad() + " - " + this.actividad.getHoraActividad());

    }

    public int getPosicionEnEjeY() {
        return this.posicionEnEjeY;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();

        jButton2.setBackground(new java.awt.Color(23, 34, 43));
        jButton2.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jButton2.setForeground(new java.awt.Color(244, 232, 193));
        jButton2.setText("OK");
        jButton2.setToolTipText("Eliminar tarea");
        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.setFocusPainted(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        setPreferredSize(new java.awt.Dimension(670, 50));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(23, 34, 43));
        jButton1.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jButton1.setForeground(new java.awt.Color(244, 232, 193));
        jButton1.setText("X");
        jButton1.setToolTipText("Eliminar tarea");
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setFocusPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 0, 70, 50));

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(13, 24, 33));
        jTextField1.setForeground(new java.awt.Color(204, 204, 204));
        jTextField1.setBorder(null);
        add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 50));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (dia.deleteActividad(actividad)) {
            panelPadre.remove(this);
            Modelo.ComplementaryMethods.showMessage("Actividad eliminada.");
            panelPadre.updateUI();

            //Re-Escribimos el archivo del dia 
            Modelo.FileManager.writeTextFile(this.dia.getRuta(), this.dia.getActividades());

            //Cargamos las actividades nuevamente debido a que el usuario elimino esta
            this.dia.cargarActividades();

            //Actualizamos la lista de elementos con las actividades
            this.vistaPadre.actualizarListaDeElementosConActividades(false, null);
        } else {
            Modelo.ComplementaryMethods.showMessage("Error al eliminar actividad.");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        if (!(jTextField1.getText().trim().equalsIgnoreCase(""))) {

            String[] datosActividad = jTextField1.getText().split(" - ");

            if (datosActividad.length == 2) {

                if (datosActividad[0].trim().equalsIgnoreCase("") || datosActividad[1].trim().equalsIgnoreCase("")) {
                    Modelo.ComplementaryMethods.showMessage("Escriba la actividad y su hora.");
                } else {
                    if (datosActividad[1].length() == 5) {

                        char[] caracteresHora = datosActividad[1].toCharArray();

                        if (Character.isDigit(caracteresHora[0]) && Character.isDigit(caracteresHora[1]) && caracteresHora[2]==':'&& Character.isDigit(caracteresHora[3]) && Character.isDigit(caracteresHora[4])) {
                            Modelo.Actividad nuevaActividad = new Modelo.Actividad(datosActividad[0], datosActividad[1]);
                            this.dia.addActividad(nuevaActividad);

                            //Re-Escribimos el archivo del dia 
                            Modelo.FileManager.writeTextFile(this.dia.getRuta(), this.dia.getActividades());

                            //Cargamos las actividades nuevamente debido a que el usuario elimino esta
                            this.dia.cargarActividades();

                            this.vistaPadre.actualizarListaDeElementosConActividades(false, null);

                            //Hacemos que el boton que permite agregar actividades se habilite
                            this.botonPadre.setEnabled(true);
                        }else{
                            Modelo.ComplementaryMethods.showMessage("El formato para la hora es el siguiente 16:28");
                        }
                    } else {
                        Modelo.ComplementaryMethods.showMessage("El formato para la hora es el siguiente 02:08");
                    }
                }
            } else {
                Modelo.ComplementaryMethods.showMessage("Debe escribir el nombre la actividad y la hora con el siguiente formato : \n nombre actividad - hora");
            }
        } else {
            Modelo.ComplementaryMethods.showMessage("Debe escribir el nombre la actividad y la hora con el siguiente formato : \n nombre actividad - hora");
        }
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
