/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

/**
 *
 * @author Jes015
 */
public class botonEstablecerActividadesDeDia extends javax.swing.JButton implements java.awt.event.MouseListener{
    
    private Modelo.Dia dia;
    
    private javax.swing.JDialog dialogpadre;
    
    private byte index = 0;
    
    public botonEstablecerActividadesDeDia(Modelo.Dia dia,javax.swing.JDialog dialogPadre,byte index){
        this.setPreferredSize(new java.awt.Dimension(200,200));
        this.setText(dia.getNombre());
        this.setName(dia.getNombre());
        this.setContentAreaFilled(false);
        this.setOpaque(true);
        this.setFocusPainted(false);
        this.setBackground(new java.awt.Color(13,24,33));
        this.setForeground(new java.awt.Color(205,173,31));
        this.setBorder(null);
        this.addMouseListener(this);
        this.setFont(new java.awt.Font("Arial",1,16));
        this.setCursor(java.awt.Cursor.getPredefinedCursor(12));
        
        this.dialogpadre = dialogPadre;
        this.index = index;
        this.dia = dia;
        
    }
    
    public int getIndexOnFather(){
        return this.index;
    }

    @Override
    public void mouseClicked(java.awt.event.MouseEvent e) {
        
    }

    @Override
    public void mousePressed(java.awt.event.MouseEvent e) {
        //Uso el casteo para probarlo :3
        VistaGestionDeDias dialogopadremetodo = (VistaGestionDeDias) dialogpadre;
        dialogopadremetodo.setDayWithActivities(this);
    }

    @Override
    public void mouseReleased(java.awt.event.MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(java.awt.event.MouseEvent e) {
        this.setBackground(new java.awt.Color(23,34,43));
        this.setForeground(new java.awt.Color(244,232,193));
        
    }

    @Override
    public void mouseExited(java.awt.event.MouseEvent e) {
        this.setBackground(new java.awt.Color(13,24,33));
        this.setForeground(new java.awt.Color(205,173,31));
    }
    
    public Modelo.Dia getDia(){
        return this.dia;
    }
}
