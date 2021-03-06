package callcenter;


import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JComponent;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mariana Valencia
 */
public class Panel3 extends javax.swing.JInternalFrame {

    private JComponent Barra = ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).getNorthPane();
    private Dimension dimBarra = null; 
    /**
     * Creates new form Panel1
     */
    public Panel3() {
        initComponents();
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        boton1 = new javax.swing.JLabel();
        boton2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        PanelContenido = new javax.swing.JDesktopPane();
        jLabel2 = new javax.swing.JLabel();

        setBackground(null);
        setBorder(null);
        setMaximumSize(new java.awt.Dimension(820, 400));
        setMinimumSize(new java.awt.Dimension(820, 400));
        setPreferredSize(new java.awt.Dimension(820, 400));
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        boton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/activardes1.png"))); // NOI18N
        boton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        boton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                boton1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                boton1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                boton1MouseExited(evt);
            }
        });
        getContentPane().add(boton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 160, 70));

        boton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Historial1.png"))); // NOI18N
        boton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        boton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                boton2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                boton2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                boton2MouseExited(evt);
            }
        });
        getContentPane().add(boton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 160, 70));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/fondopaneles.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 200, 375));

        PanelContenido.setMaximumSize(new java.awt.Dimension(630, 430));
        PanelContenido.setMinimumSize(new java.awt.Dimension(630, 430));
        PanelContenido.setOpaque(false);

        javax.swing.GroupLayout PanelContenidoLayout = new javax.swing.GroupLayout(PanelContenido);
        PanelContenido.setLayout(PanelContenidoLayout);
        PanelContenidoLayout.setHorizontalGroup(
            PanelContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 630, Short.MAX_VALUE)
        );
        PanelContenidoLayout.setVerticalGroup(
            PanelContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 430, Short.MAX_VALUE)
        );

        getContentPane().add(PanelContenido, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, 620, 400));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/fondo1v2.jpg"))); // NOI18N
        jLabel2.setMaximumSize(new java.awt.Dimension(630, 400));
        jLabel2.setMinimumSize(new java.awt.Dimension(630, 400));
        jLabel2.setPreferredSize(new java.awt.Dimension(630, 400));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -160, 820, 620));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton1MouseEntered
        // TODO add your handling code here:
        boton1.setIcon(new ImageIcon(getClass().getResource( "/recursos/activardes2.png" )));
    }//GEN-LAST:event_boton1MouseEntered

    private void boton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton1MouseExited
        // TODO add your handling code here:
        boton1.setIcon(new ImageIcon(getClass().getResource( "/recursos/activardes1.png" )));
    }//GEN-LAST:event_boton1MouseExited

    private void boton2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton2MouseEntered
        // TODO add your handling code here:
        boton2.setIcon(new ImageIcon(getClass().getResource( "/recursos/Historial2.png" )));
    }//GEN-LAST:event_boton2MouseEntered

    private void boton2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton2MouseExited
        // TODO add your handling code here:
        boton2.setIcon(new ImageIcon(getClass().getResource( "/recursos/Historial1.png" )));
    }//GEN-LAST:event_boton2MouseExited

    private void boton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton1MouseClicked
        // TODO add your handling code here:
        Contenido31 p= new Contenido31();
        PanelContenido.removeAll();
        PanelContenido.add(p);
        p.setVisible(true);
        
        
    }//GEN-LAST:event_boton1MouseClicked

    private void boton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton2MouseClicked
        // TODO add your handling code here:
        Contenido32 p= new Contenido32();
        PanelContenido.removeAll();
        PanelContenido.add(p);
        p.setVisible(true);
    }//GEN-LAST:event_boton2MouseClicked

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        Barra = ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).getNorthPane(); 
        dimBarra = Barra.getPreferredSize(); 
        Barra.setSize(0,0); 
        Barra.setPreferredSize(new Dimension(0,0)); 
        repaint();
    }//GEN-LAST:event_formInternalFrameOpened


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JDesktopPane PanelContenido;
    private javax.swing.JLabel boton1;
    private javax.swing.JLabel boton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
