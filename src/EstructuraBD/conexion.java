package EstructuraBD;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;

public class conexion {

    private int registros;
    public String registro_busqueda;
    public String registro_busqueda1;
    public String registro_busqueda2;

    Connection con = null;
    variablesBD vBD = new variablesBD();

    public conexion() {
        String bd, user, pass, ax;
        bd = vBD.baseDeDatos;
        user = vBD.usuarioMysql;
        pass = vBD.passMysql;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + bd, user, pass);
            if (con != null) {
                System.out.println("Conectados");
            }
        } catch (Exception e) {
            System.out.println("Error en la conexion:\n" + e);
        }
    }

    public Connection conectar() {
        return con;
    }

    public void desconectar() {
        con = null;
    }

    public void busqueda_serial() {
        try {
            PreparedStatement pstm = (PreparedStatement) conectar().prepareStatement("SELECT " + " serial " + " FROM superusuario;");
            ResultSet res = pstm.executeQuery();
            res.next();
            registro_busqueda = res.getString("serial");
//            Variables_globales.getSerialBD(registro_busqueda);
            res.close();
        } catch (Exception e) {
        }
    }

    public void busqueda_gral(String tabla, String campo) {
        try {
            registro_busqueda = "";
            PreparedStatement pstm = (PreparedStatement) conectar().prepareStatement("SELECT " + campo + " FROM " + tabla + ";");
            ResultSet res = pstm.executeQuery();
            res.next();
            registro_busqueda = res.getString(campo);
//            JOptionPane.showMessageDialog(null, registro_busqueda);
            res.close();
        } catch (Exception e) {

        }

    }

    public void busqueda_supervisores(String tabla, String campo, String clausula) {
        try {
            registro_busqueda = "";
            registro_busqueda1 = "";
            registro_busqueda2 = "";
            PreparedStatement pstm = (PreparedStatement) conectar().prepareStatement("SELECT " + campo + " AS SP, password_supervisor AS PAS, id_supervisor AS ID FROM " + tabla + " WHERE " + campo + "= '" + clausula + "';");
            ResultSet res = pstm.executeQuery();
            res.next();
            registro_busqueda = res.getString("SP");
            registro_busqueda1 = res.getString("PAS");
            registro_busqueda2 = res.getString("ID");
            res.close();
        } catch (Exception e) {

        }

    }

    public void agregar(String tabla, String campos, String valores) {
        String query = "INSERT INTO " + tabla;
        String[] camp = campos.split(",");
        int max = camp.length;

        query += campos(max, camp);
        query += valores(max);

        if (prepararEstados(query, valores)) {
            System.out.println("False");
        } else {
            System.out.println("True");
        }
    }

    public void actualizar(String tabla, String campos, String valores, String clausula) {
        String[] camp = campos.split(",");
        int max = camp.length;
        String c;
        String query = "UPDATE " + tabla + " SET ", aux = "";
        if (clausula == null) {
            c = "1";
        } else {
            c = clausula;
        }
        for (int i = 0; i < max; i++) {
            aux += camp[i] + "=?";
            if (i != max - 1) {
                aux += ",";
            }
        }
        query += aux + " WHERE " + c;

        if (prepararEstados(query, valores)) {
            System.out.println("False");
        } else {
            System.out.println("True");
        }
    }

    public void eliminar(String tabla, String clausula) {
        String query = "DELETE FROM " + tabla + " WHERE " + clausula;
        if (prepararEstados(query, null)) {
            System.out.println("False");
        } else {
            System.out.println("True");
        }
    }

    public void eliminar_registros(String tabla) {
        String query = "DELETE FROM " + tabla;
        if (prepararEstados(query, null)) {
            System.out.println("False");
        } else {
            System.out.println("True");
        }
    }

    public boolean prepararEstados(String query, String values) {
        boolean r = true;
        String[] val = null;
        int max;
        if (values != null) {
            val = values.split(",");
            max = val.length;

            try {
                PreparedStatement pstm = (PreparedStatement) conectar().prepareStatement(query);
                for (int i = 0; i < max; i++) {
                    pstm.setString(i + 1, val[i]);
                }
                r = pstm.execute();
                System.out.println(pstm);
                pstm.close();
            } catch (Exception e) {
                System.out.println("Problemas de sincronizacion con la base de datos:\n " + e);
            }
        } else {
            try {
                PreparedStatement pstm = (PreparedStatement) conectar().prepareStatement(query);
                r = pstm.execute();
                pstm.close();
            } catch (Exception e) {
                System.out.println("PREPARAR ESTADOS. " + e);
            }
        }
        desconectar();
        return r;
    }

    private String campos(int max, String[] camp) {
        String str = "(";
        for (int i = 0; i < max; i++) {
            str += camp[i];
            if (i != max - 1) {
                str += ",";
            }
        }
        return str;
    }

    private String valores(int max) {
        String str = ") VALUES (";
        for (int i = 0; i < max; i++) {
            str += "?";
            if (i != max - 1) {
                str += ",";
            }
        }
        str += ")";
        return str;
    }

    public void busquedabaja1(String tabla, String campo, String clave) {
        try {
            PreparedStatement pstm = (PreparedStatement) conectar().prepareStatement("SELECT " + campo + " FROM " + tabla + " WHERE" + clave + ";");
            ResultSet res = pstm.executeQuery();
            try {
                res.next();
                registro_busqueda = res.getString(campo);
                res.close();
            } catch (Exception e) {
                UIManager UI = new UIManager();
                UI.put("OptionPane.background", new ColorUIResource(0, 51, 51));
                UI.put("Panel.background", new ColorUIResource(0, 51, 51));
                String titulo = "Campo vacios!";
                String mensaje = "<html><font color=#FFFFFF>La base indicada no existe!.";
                JOptionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (Exception e) {

        }
    }

    public void busquedaalta1(String tabla, String campo) {
        try {
            PreparedStatement pstm = (PreparedStatement) conectar().prepareStatement("SELECT " + campo + " FROM " + tabla + ";");
            ResultSet res = pstm.executeQuery();
            res.next();
            registro_busqueda = res.getString(campo);

            while (res.next()) {

                registro_busqueda = res.getString(campo);
            }
            res.close();

        } catch (Exception e) {

        }
    }

    public String busquedaespecifica(String tabla, String campo, String clausula) {
        try {
            String aux;
            aux = "SELECT " + campo + " FROM " + tabla + " WHERE " + clausula + ";";
            PreparedStatement pstm = (PreparedStatement) conectar().prepareStatement(aux);
            ResultSet res = pstm.executeQuery();
            res.next();
            String respuesta = res.getString(campo);
            res.close();
            return respuesta;

        } catch (SQLException e) {
            return null;

        }
    }

    public ResultSet busquedacasos(String tabla, String campos) {
        try {
            PreparedStatement pstm = (PreparedStatement) conectar().prepareStatement("SELECT " + campos + " FROM " + tabla + ";");
            ResultSet res = pstm.executeQuery();
            res.next();
            return res;

        } catch (SQLException e) {

            return null;

        }
    }

}
