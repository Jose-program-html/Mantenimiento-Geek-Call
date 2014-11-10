/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SuperUsuario;

import java.sql.SQLException;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;


/**
 *
 * @author Lee
 */
public class Base_de_datos_metodos {
   EstructuraBD.conexion con;
   public Base_de_datos_metodos(){
   con = new EstructuraBD.conexion();
   }
   
   
   public int serial(){
       int serial2=0;
        try{
            PreparedStatement pstm = null;
            pstm = (PreparedStatement)con.conectar().prepareStatement("SELECT " + " serial " + " FROM superusuario");
            ResultSet res = pstm.executeQuery();
            res.next();
            serial2 = res.getInt("serial");
            res.close();
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
        return serial2;
   }
   
   public String serial_code(){
       String serial="";
       try{
           PreparedStatement pstm = null;
           pstm = (PreparedStatement)con.conectar().prepareStatement("SELECT " + " serial_code " + " FROM superusuario");
           ResultSet res = pstm.executeQuery();
           res.next();
           serial = res.getString("serial_code");
           res.close();
       }
       catch(SQLException e)
       {
           System.out.println(e);
       }
       return serial;
   }
   
   public void superusuario(String name, int password){
       String serial_codigo=serial_code();
       try{
           PreparedStatement pstm = null;
           pstm = (PreparedStatement)con.conectar().prepareStatement("UPDATE superusuario SET nombre_su=?, password_su=?, serial=? WHERE serial_code=? ");
           pstm.setString(1, name);
           pstm.setInt(2, password);
           pstm.setInt(3,1);
           pstm.setString(4, serial_codigo);
           pstm.executeUpdate();
           pstm.close();
       }
       catch(SQLException e)
       {
           System.out.println(e);
       }
   }
   
   public boolean usuarioexiste(int tipo, String usu){
        int row=0;
        String tipo_usu="",usu_tipo="";
        if(tipo==0){
            tipo_usu="supervisores";
            usu_tipo="nombre_supervisor";
        }else{
            tipo_usu="administrador";
            usu_tipo="nombre_admin";
        }
        try{
            PreparedStatement pstm = null;
            pstm = (PreparedStatement)con.conectar().prepareStatement("SELECT * FROM " + tipo_usu + " WHERE " + usu_tipo + "=? ");
            pstm.setString(1, usu);
            ResultSet res = pstm.executeQuery();
            res.next();
            row=res.getRow();
            res.close();
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
        if(row==0){
           return true;
       }
       else{
           return false;
       }
   }
   
   public boolean administradores(){
       int row=0;
       try{
           PreparedStatement pstm = null;
           pstm = (PreparedStatement)con.conectar().prepareStatement("SELECT * FROM administrador");
           ResultSet res = pstm.executeQuery();
           res.next();
           row=res.getRow();
           res.close();
       }
       catch(SQLException e)
       {
           System.out.println(e);
       }
       if(row==0){
           return true;
       }
       else{
           return false;
       }
   }
    
   public boolean log(int tipo, String usu, int pass){
        int row=0;
        String tipo_usu="",usu_tipo="",pass_tipo="";
        switch(tipo){
            case 2:tipo_usu="superusuario";
                usu_tipo="nombre_su";
                pass_tipo="password_su";
                break;
            case 1:tipo_usu="administrador";
                usu_tipo="nombre_admin";
                pass_tipo="password_admin";
                break;
            case 0:tipo_usu="supervisores";
                usu_tipo="nombre_supervisor";
                pass_tipo="password_supervisor";
                break;
        }
        try{
            PreparedStatement pstm = null;
            pstm = (PreparedStatement)con.conectar().prepareStatement("SELECT * FROM " + tipo_usu + " WHERE " + usu_tipo + "=? AND " + pass_tipo + "=? ");
            pstm.setString(1, usu);
            pstm.setInt(2, pass);
            ResultSet res = pstm.executeQuery(); 
            res.next();
            row=res.getRow();
            res.close();
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
        if(row==1){
           return true;
       }
       else{
           return false;
       }
   }
    
   public void join(String usu, int pass, int tipo){
        String tipo_usu="",usu_tipo="",pass_tipo="";
        switch(tipo){
            case 1:tipo_usu="superusuario";
                usu_tipo="nombre_su";
                pass_tipo="password_su";
                break;
            case 2:tipo_usu="administrador";
                usu_tipo="nombre_admin";
                pass_tipo="password_admin";
                break;
            case 3:tipo_usu="supervisores";
                usu_tipo="nombre_supervisor";
                pass_tipo="password_supervisor";
                break;
        }
        try{
            PreparedStatement pstm = null;
            pstm = (PreparedStatement)con.conectar().prepareStatement("INSERT INTO " + tipo_usu + " ("+usu_tipo+","+pass_tipo+") values (?,?)");
            pstm.setString(1, usu);
            pstm.setInt(2, pass);
            pstm.executeUpdate();
            pstm.close();
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
    }
}
