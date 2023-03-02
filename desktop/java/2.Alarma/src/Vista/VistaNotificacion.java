/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;


/**
 *
 * @author Jes015
 */
public class VistaNotificacion extends javax.swing.JFrame {

    /**
     * Creates new form VistaNotificacion
     */
    private Modelo.Actividad actividad;
    
    private double positionEjeX = java.awt.Toolkit.getDefaultToolkit().getScreenSize().getWidth()-this.getWidth();
    private double positionEjeY = java.awt.Toolkit.getDefaultToolkit().getScreenSize().getHeight()-this.getHeight();
    
   
    public VistaNotificacion(Modelo.Actividad actividad) {
        System.gc();
        initComponents();
        
        this.actividad = actividad;
        
        this.jTextField3.setText(this.actividad.getNombreActividad().toUpperCase());
        this.jTextField4.setText(this.actividad.getHoraActividad());
        
        this.setBackground(new java.awt.Color((float)0.01,(float)0.01,(float)0.01,(float)0.7));
        this.setLocation((int)(double)positionEjeX-440,(int)(double)positionEjeY-160);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(153, 153, 153));
        setUndecorated(true);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setForeground(new java.awt.Color(244, 232, 193));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("03:55");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 410, 80));

        jTextField3.setEditable(false);
        jTextField3.setBackground(new java.awt.Color(23, 34, 43));
        jTextField3.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        jTextField3.setForeground(new java.awt.Color(244, 232, 193));
        jTextField3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField3.setText("TAREA INGLES");
        jTextField3.setBorder(null);
        getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 230, 28));

        jTextField4.setEditable(false);
        jTextField4.setBackground(new java.awt.Color(13, 24, 33));
        jTextField4.setFont(new java.awt.Font("Noto Sans", 0, 10)); // NOI18N
        jTextField4.setForeground(new java.awt.Color(204, 204, 204));
        jTextField4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField4.setText("03:23");
        jTextField4.setBorder(null);
        getContentPane().add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 0, 50, 28));

        jButton1.setBackground(new java.awt.Color(13, 24, 33));
        jButton1.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(204, 204, 204));
        jButton1.setText("Ver Actividad");
        jButton1.setBorder(null);
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setFocusPainted(false);
        jButton1.setOpaque(true);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 430, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        this.dispose();
        
    }//GEN-LAST:event_formMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        VistaActividad vistaActividad = new VistaActividad(this.actividad);
        vistaActividad.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}