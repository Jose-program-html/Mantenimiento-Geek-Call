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
public class ReportesClassCons {

    private conexion con = new conexion();

    public Object[][] getDatos(DefaultTableModel modelo, String resultado) {
        int registros = 0;
        PreparedStatement pstm;
//obtenemos la cantidad de registros existentes en la tabla
        try {
            if ("".equals(resultado)) {
                pstm = (PreparedStatement) con.conectar().prepareStatement("SELECT count(1) as total FROM consultante where resultado!= '" + resultado + "';");
            } else {
               pstm = (PreparedStatement) con.conectar().prepareStatement("SELECT count(1) as total FROM consultante where resultado= '" + resultado + "';");
            }
            ResultSet res = pstm.executeQuery();
            res.next();
            registros = res.getInt("total");
            res.close();
        } catch (SQLException e) {
            System.out.println(e);
        }

        Object[][] data = new String[registros][5];
        String[] Datos = new String[5];

//realizamos la consulta sql y llenamos los datos en "Object"
        try {
            if("".equals(resultado))
            {
                 pstm = (PreparedStatement) con.conectar().prepareStatement("SELECT "
                    + "ip,nombre,telefono,id_caso,comentario"
                    + " FROM consultante where resultado!= '" + resultado
                    + "' ORDER BY id;");
            }
            else
            {
                 pstm = (PreparedStatement) con.conectar().prepareStatement("SELECT "
                    + "ip,nombre,telefono,id_caso,comentario"
                    + " FROM consultante where resultado= '" + resultado
                    + "' ORDER BY id;");
            }
            
            ResultSet res = pstm.executeQuery();
            int i = 0;
            while (res.next()) {
                String estIp = res.getString("ip");
                String estNombre = res.getString("nombre");
                String estTel = res.getString("telefono");
                String estCaso = res.getString("id_caso");
                String estComentario = res.getString("comentario");

                data[i][0] = estIp;
                data[i][1] = estNombre;
                data[i][2] = estTel;
                data[i][3] = estCaso;
                data[i][4] = estComentario;

                Datos[0] = (String) data[i][0];
                Datos[1] = (String) data[i][1];
                Datos[2] = (String) data[i][2];
                Datos[3] = (String) data[i][3];
                Datos[4] = (String) data[i][4];

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
