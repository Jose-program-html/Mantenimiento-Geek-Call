package callcenter;


import Clases.VariablesCasos;
import java.awt.Dimension;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mariana Valencia
 */
public class Contenido43 extends javax.swing.JInternalFrame {
    private JComponent Barra = ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).getNorthPane();
    private Dimension dimBarra = null;
    /**
     * Creates new form Contenido11
     */
    public Contenido43() {
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

        base = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        boton3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        submenu = new javax.swing.JTextField();
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

        base.setBackground(new java.awt.Color(235, 253, 253));
        base.setFont(new java.awt.Font("Courier New", 3, 24)); // NOI18N
        base.setMaximumSize(new java.awt.Dimension(360, 80));
        base.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                baseKeyPressed(evt);
            }
        });
        getContentPane().add(base, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 80, 190, 30));

        jLabel3.setFont(new java.awt.Font("Courier New", 3, 24)); // NOI18N
        jLabel3.setText("Nombre de la base:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, 290, 30));

        boton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/continuar1.png"))); // NOI18N
        boton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        boton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                boton3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                boton3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                boton3MouseExited(evt);
            }
        });
        getContentPane().add(boton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 250, -1, -1));

        jLabel4.setFont(new java.awt.Font("Courier New", 3, 24)); // NOI18N
        jLabel4.setText("Submenu a modificar:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 290, 30));

        submenu.setBackground(new java.awt.Color(235, 253, 253));
        submenu.setFont(new java.awt.Font("Courier New", 3, 24)); // NOI18N
        submenu.setToolTipText("Submenu a modificar sin puntos. Ejemplo Menu 122 (base 1, menu 2, submenu 3)");
        submenu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                submenuKeyPressed(evt);
            }
        });
        getContentPane().add(submenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 160, 190, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/fondo1v2.jpg"))); // NOI18N
        jLabel2.setMaximumSize(new java.awt.Dimension(630, 410));
        jLabel2.setMinimumSize(new java.awt.Dimension(630, 410));
        jLabel2.setPreferredSize(new java.awt.Dimension(630, 410));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-200, -160, 820, 620));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton3MouseClicked
        // TODO add your handling code here:
        UIManager UI = new UIManager();
        UI.put("OptionPane.background", new ColorUIResource(110, 149, 164));
        UI.put("Panel.background", new ColorUIResource(110, 149, 164));
        String titulo, mensaje;
        String resultado1 = "", resultado2 = "";
        //Si la base existe y el submenu
        EstructuraBD.conexion c = new EstructuraBD.conexion();
        resultado1 = c.busquedaespecifica("casos", "nombre", "nombre='" + base.getText() + "'");
        if (base.getText().length() != 0 && submenu.getText().length() != 0) {
            if (resultado1 != null) {
                resultado2 = c.busquedaespecifica("menu", "idmenu", "idmenu=" + submenu.getText());
                if (resultado2 != null) {

                    Clases.VariablesCasos.base = base.getText();
                    Clases.VariablesCasos.submenu = submenu.getText();
                    ModificarBase m = new ModificarBase();
                    m.show();
                } else {
                    titulo = "Submenu no valido!";
                    mensaje = "<html><font color=#FFFFFF>El submenu indicado no se encontro en la base de informacion.";
                    JOptionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                titulo = "Base no valida!";
                mensaje = "<html><font color=#FFFFFF>Nombre de base no encontrado.";
                JOptionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.INFORMATION_MESSAGE);
            }

        } else {
            titulo = "Campos vacios!";
            mensaje = "<html><font color=#FFFFFF>Debe colocar el nombre de la base y el submenu.";
            JOptionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.INFORMATION_MESSAGE);
        }
        //si no
        //mandar mensaje de que no existe x cosa
    }//GEN-LAST:event_boton3MouseClicked

    private void boton3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton3MouseEntered
        // TODO add your handling code here:
        boton3.setIcon(new ImageIcon(getClass().getResource("/recursos/continuar2.png")));
    }//GEN-LAST:event_boton3MouseEntered

    private void boton3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton3MouseExited
        // TODO add your handling code here:

        boton3.setIcon(new ImageIcon(getClass().getResource("/recursos/continuar1.png")));
    }//GEN-LAST:event_boton3MouseExited

    private void submenuKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_submenuKeyPressed
        // TODO add your handling code here:
        char c;

        c = evt.getKeyChar();
        if (c < '0' || c > '9') {
            evt.consume();//ignora el caracter digitado 
        }

    }//GEN-LAST:event_submenuKeyPressed

    private void baseKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_baseKeyPressed
        // TODO add your handling code here:
        char c; 
        c=evt.getKeyChar(); 
            if(!(c<'0'||c>'9')) 
                evt.consume(); 

    }//GEN-LAST:event_baseKeyPressed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        Barra = ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).getNorthPane(); 
        dimBarra = Barra.getPreferredSize(); 
        Barra.setSize(0,0); 
        Barra.setPreferredSize(new Dimension(0,0)); 
        repaint();
    }//GEN-LAST:event_formInternalFrameOpened


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField base;
    private javax.swing.JLabel boton3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField submenu;
    // End of variables declaration//GEN-END:variables
}
