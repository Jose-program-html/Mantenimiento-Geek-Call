package callcenter;

import ConexionSocket.Hilo_Socket_Servidor;
import EstructuraBD.conexion;
import java.awt.Dimension;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
public class Contenido31 extends javax.swing.JInternalFrame {

    private conexion con = new conexion();
    private String fechaini_server = "";
    private String fechafin_server = "";
    private JComponent Barra = ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).getNorthPane();
    private Dimension dimBarra = null; 
    /**
     * Creates new form Contenido11
     */
    public Contenido31() {
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
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 0, 0));
        setBorder(null);
        setMaximumSize(new java.awt.Dimension(630, 430));
        setMinimumSize(new java.awt.Dimension(630, 430));
        setPreferredSize(new java.awt.Dimension(630, 430));
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

        boton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/server1.png"))); // NOI18N
        boton1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
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
        getContentPane().add(boton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 90, -1, -1));

        boton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/servidor2.png"))); // NOI18N
        boton2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
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
        getContentPane().add(boton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 200, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/fondo1v2.jpg"))); // NOI18N
        jLabel2.setMaximumSize(new java.awt.Dimension(630, 410));
        jLabel2.setMinimumSize(new java.awt.Dimension(630, 410));
        jLabel2.setPreferredSize(new java.awt.Dimension(630, 410));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 410));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton1MouseClicked
        if (!SuperUsuario.Variables_globales.servidor_status) {
            Date date = new Date();
            DateFormat hourdateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            fechaini_server = hourdateFormat.format(date);
            con = new conexion();
            con.agregar("servidor", "inicio,empleado", fechaini_server + "," + SuperUsuario.Variables_globales.getSesion_usuario());

            SuperUsuario.Variables_globales.servidor_status = true;
            ((Hilo_Socket_Servidor) new Hilo_Socket_Servidor()).start();
        }
    }//GEN-LAST:event_boton1MouseClicked

    private void boton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton1MouseEntered
        // TODO add your handling code here:
        boton1.setIcon(new ImageIcon(getClass().getResource("/recursos/server12.png")));
    }//GEN-LAST:event_boton1MouseEntered

    private void boton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton1MouseExited
        // TODO add your handling code here:
        boton1.setIcon(new ImageIcon(getClass().getResource("/recursos/server1.png")));
    }//GEN-LAST:event_boton1MouseExited

    private void boton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton2MouseClicked
        SuperUsuario.Variables_globales.servidor_status = false;
        Date date = new Date();
        DateFormat hourdateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        fechafin_server = hourdateFormat.format(date);
        con = new conexion();
        con.actualizar("servidor", "fin", fechafin_server, "inicio");
    }//GEN-LAST:event_boton2MouseClicked

    private void boton2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton2MouseEntered
        // TODO add your handling code here:
        boton2.setIcon(new ImageIcon(getClass().getResource("/recursos/servidor22.png")));
    }//GEN-LAST:event_boton2MouseEntered

    private void boton2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton2MouseExited
        // TODO add your handling code here:
        boton2.setIcon(new ImageIcon(getClass().getResource("/recursos/servidor2.png")));
    }//GEN-LAST:event_boton2MouseExited

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        Barra = ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).getNorthPane(); 
        dimBarra = Barra.getPreferredSize(); 
        Barra.setSize(0,0); 
        Barra.setPreferredSize(new Dimension(0,0)); 
        repaint(); 
    }//GEN-LAST:event_formInternalFrameOpened


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel boton1;
    private javax.swing.JLabel boton2;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
