
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reportes;

import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import EstructuraBD.conexion;

/**
 *
 * @author Shary
 */
public class ReportesClassServer {

    private conexion con = new conexion();

    public Object[][] getDatos(DefaultTableModel modelo) {
        int registros = 0;
//obtenemos la cantidad de registros existentes en la tabla
        try {
            PreparedStatement pstm = (PreparedStatement) con.conectar().prepareStatement("SELECT count(1) as total FROM servidor;");
            ResultSet res = pstm.executeQuery();
            res.next();
            registros = res.getInt("total");
            res.close();
        } catch (SQLException e) {
            System.out.println(e);
        }

        Object[][] data = new String[registros][3];
        String[] Datos = new String[3];

//realizamos la consulta sql y llenamos los datos en "Object"
        try {
            PreparedStatement pstm = (PreparedStatement) con.conectar().prepareStatement("SELECT "
                    + "inicio,fin,empleado"
                    + " FROM servidor ORDER BY idserver;");
            ResultSet res = pstm.executeQuery();
            int i = 0;
            while (res.next()) {
                String estIni = res.getString("inicio");
                String estFin = res.getString("fin");
                String estEmpleado = res.getString("empleado");

                data[i][0] = estIni;
                data[i][1] = estFin;
                data[i][2] = estEmpleado;

                Datos[0] = (String) data[i][0];
                Datos[1] = (String) data[i][1];
                Datos[2] = (String) data[i][2];

                modelo.addRow(Datos);
                i++;
            }
            res.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return data;
    }

}
