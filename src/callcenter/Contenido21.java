package callcenter;

import Reportes.ReportesClassCons;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import Clases.Variables;
import ReportClients.ListaClientes;
import java.awt.Dimension;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Mariana Valencia
 */
import java.io.File;
import javax.swing.JComponent;
import net.sf.jasperreports.view.JasperViewer;

public class Contenido21 extends javax.swing.JInternalFrame {

    DefaultTableModel modelo;
    private JComponent Barra = ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).getNorthPane();
    private Dimension dimBarra = null;
    /**
     * Creates new form Contenido11
     */
    public Contenido21() {
        initComponents();
        tablaContenido();
        carpeta();
    }

    private void tablaContenido() {
        String res = "";
        modelo = new DefaultTableModel();
        modelo.addColumn("IP");
        modelo.addColumn("Nombre");
        modelo.addColumn("Telefono");
        modelo.addColumn("ID Caso");
        modelo.addColumn("Comentario");
        this.jTable1.setModel(modelo);
        Reportes.ReportesClassCons rp = new ReportesClassCons();
        rp.getDatos(modelo, res);
    }

    public void carpeta() {
        try {
            File folder = new File("C:/ReportesClientes");
            folder.mkdir();
        } catch (Exception e) {
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
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

        jTable1.setFont(new java.awt.Font("Agency FB", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.setOpaque(false);
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 550, 270));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        jButton1.setText("Generar Reporte");
        jButton1.setToolTipText("Presiona");
        jButton1.setInheritsPopupMenu(true);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 350, 160, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/fondo1v2.jpg"))); // NOI18N
        jLabel2.setMaximumSize(new java.awt.Dimension(630, 410));
        jLabel2.setMinimumSize(new java.awt.Dimension(630, 410));
        jLabel2.setPreferredSize(new java.awt.Dimension(630, 410));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 410));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {
            List lista1 = new ArrayList();
            for (int i = 0; i < jTable1.getRowCount(); i++) {
                ListaClientes client = new ListaClientes(jTable1.getValueAt(i, 0).toString(), jTable1.getValueAt(i, 1).toString(), jTable1.getValueAt(i, 2).toString(), jTable1.getValueAt(i, 3).toString(), jTable1.getValueAt(i, 4).toString());
                lista1.add(client);
            }
            URL in = this.getClass().getResource("Clientes.jasper");
            JasperReport reporte = (JasperReport) JRLoader.loadObject(in);

            JasperPrint pr = JasperFillManager.fillReport(reporte, null, new JRBeanCollectionDataSource(lista1));
//            JasperViewer.viewReport(pr);
            JasperExportManager.exportReportToPdfFile(pr, "C:/ReportesClientes/" + Variables.getHora_reporte() + "CO.pdf");
            JOptionPane.showMessageDialog(null, "Reporte guardada con exito.\nPuede localizarlo en la ruta: C:/ReportesClientes/" + Variables.getHora_reporte() + "CO.pdf");
        } catch (Exception e) {

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        Barra = ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).getNorthPane(); 
        dimBarra = Barra.getPreferredSize(); 
        Barra.setSize(0,0); 
        Barra.setPreferredSize(new Dimension(0,0)); 
        repaint();
    }//GEN-LAST:event_formInternalFrameOpened


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
