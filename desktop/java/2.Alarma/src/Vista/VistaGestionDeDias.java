/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package Vista;

/**
 *
 * @author Jes015
 */
public class VistaGestionDeDias extends javax.swing.JDialog {

    private VistaPrincipalHorario padreComponente;

    private Modelo.Horario horario;
    private Modelo.Dia dia;
    private boolean modeSetActivities;
    private botonEstablecerActividadesDeDia botones[];

    public static final OranizadorAbsoluteLayoutEjeY organizadorDeActividadesEnJPanel = new OranizadorAbsoluteLayoutEjeY(Modelo.Dia.maximoActividadesPorDia, 55, 0);

    public VistaGestionDeDiasPanelActividad[] contenedoresDeActividades;

    /**
     * Creates new form NewJDialog
     */
    public VistaGestionDeDias(VistaPrincipalHorario parent, Modelo.Horario horario) {
        super(parent, true);
        this.initComponents();
        this.setSize(721, 501);
        this.setResizable(false);
        this.getContentPane().setBackground(new java.awt.Color(10, 13, 23));
        this.getContentPane().remove(jPanel2);
        this.getContentPane().add(jPanel1);
        this.setLocationRelativeTo(parent);

        this.padreComponente = parent;

        this.horario = horario;

        this.botones = new botonEstablecerActividadesDeDia[7];

        this.contenedoresDeActividades = new VistaGestionDeDiasPanelActividad[Modelo.Dia.maximoActividadesPorDia];

        //Se deja abajo de las lineas de arriba porque para utilizar este metodo el atributo global horario debe estar incializado.
        this.setButtonsOnJPanel();

    }

    public final void setButtonsOnJPanel() {
        for (int i = 0; i < horario.getDias().length; i++) {

            this.botones[i] = new botonEstablecerActividadesDeDia(this.horario.getDias()[i], this, (byte) (int) i); // i seria el indice del elemento en el JPanel

            this.jPanel1.add(botones[i]);

        }
    }

    public void setDayWithActivities(botonEstablecerActividadesDeDia boton) {
        this.getContentPane().removeAll();

        if (this.modeSetActivities == false) {
            this.modeSetActivities = true;
            
            //En caso de que el boton que permite agregar actividades halla sido deshabilitado se habilita nuevamente
            jButton2.setEnabled(true);

            getContentPane().add(boton, java.awt.BorderLayout.NORTH);
            boton.setPreferredSize(new java.awt.Dimension(87, 46));

            this.dia = boton.getDia();

            this.actualizarListaDeElementosConActividades(false, null);

            getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

            getContentPane().remove(jPanel1);

            restartComponents();
        } else {

            this.modeSetActivities = false;

            getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

            getContentPane().remove(boton);

            jPanel1.add(boton, boton.getIndexOnFather());

            getContentPane().remove(jPanel2);

            organizadorDeActividadesEnJPanel.resetearEspacios();

            restartComponents();
        }

    }

    public final void restartComponents() {
        for (int i = 0; i < 6; i++) {
            this.botones[i].updateUI();
            this.botones[i].setBorder(null);
        }
        this.jPanel1.updateUI();
        this.jPanel2.updateUI();
    }

    private void vaciarListaElementosConActividades() {
        for (int i = 0; i < Modelo.Dia.maximoActividadesPorDia; i++) {
            this.contenedoresDeActividades[i] = null;
        }
    }

    //su el modoAgregarElementos es true agregara como primer elemento el elemento que le pasamos por parametros, de lo contrarios solo actualizara la lista de elementos
    public final void actualizarListaDeElementosConActividades(boolean modoAgregarElementos, VistaGestionDeDiasPanelActividad actividad) {

        this.vaciarListaElementosConActividades();

        this.jPanel3.removeAll();

        VistaGestionDeDias.organizadorDeActividadesEnJPanel.resetearEspacios();

        if (modoAgregarElementos == true) {
            this.contenedoresDeActividades[0] = actividad;
            this.jPanel3.add(contenedoresDeActividades[0], new org.netbeans.lib.awtextra.AbsoluteConstraints(10, organizadorDeActividadesEnJPanel.obtenerPrimeraPosicion(), 670, 50));
        }

        for (int i = 0; i < Modelo.Dia.maximoActividadesPorDia; i++) {
            if (this.dia.getActividades()[i] != null) {
                this.contenedoresDeActividades[i] = new VistaGestionDeDiasPanelActividad(this, this.jPanel3, this.dia.getActividades()[i], this.dia, organizadorDeActividadesEnJPanel.obtenerEspacioDisponible());
                this.jPanel3.add(contenedoresDeActividades[i], new org.netbeans.lib.awtextra.AbsoluteConstraints(10, contenedoresDeActividades[i].getPosicionEnEjeY(), 670, 50));
            }
        }

        jPanel3.updateUI();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();

        jPanel1.setBackground(new java.awt.Color(10, 13, 20));
        jPanel1.setLayout(new java.awt.GridLayout(2, 3, 1, 1));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gestor de actividades");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(10, 13, 20));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton2.setBackground(new java.awt.Color(13, 24, 33));
        jButton2.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        jButton2.setForeground(new java.awt.Color(244, 232, 193));
        jButton2.setText("+");
        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.setFocusPainted(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 360, 100, 60));

        jScrollPane1.setBorder(null);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jPanel3.setBackground(new java.awt.Color(10, 13, 20));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jScrollPane1.setViewportView(jPanel3);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 710, 340));

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        if (jButton2.isEnabled()) {
            VistaGestionDeDiasPanelActividad nuevaActividad = new VistaGestionDeDiasPanelActividad(this, this.dia,this.jButton2);

            this.actualizarListaDeElementosConActividades(true, nuevaActividad);

            jButton2.setEnabled(false);
        }else{
            Modelo.ComplementaryMethods.showMessage("Solo puede agregar una actividad a la vez.");
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed

        //Evento para resetear la posicion en la que se agregaran las actividades nuevamente cuando se abra el dialog
        VistaGestionDeDias.organizadorDeActividadesEnJPanel.resetearEspacios();

        //Actualizamos los JTextArea que contienen los nombres de las actividades
        this.padreComponente.actualizarJPanelesDeActividadesDeDias();
        
        System.gc();

    }//GEN-LAST:event_formWindowClosed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
