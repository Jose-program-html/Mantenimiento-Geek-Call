/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Clases;

import callcenter.AltaBases;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;

/**
 *
 * @author Mariana Valencia
 */
public class VariablesCasos {
    
   public static String base="", descripcion="", submenu="";
    public static int menuprincipal=0;
    public static int caso=0;
    public static int id=1;
    
    public static int altasbase()
    {
        String campos="id_caso,nombre,numeromenus,descripcion";
        String tabla="casos";
        
        EstructuraBD.conexion C= new EstructuraBD.conexion();    
        C.registro_busqueda="";
        C.busqueda_gral(tabla,"id_caso");
        if(C.registro_busqueda.length()!=0)
        {
        C.registro_busqueda="";
        C.busquedaalta1(tabla,"id_caso");
        id=Integer.parseInt(C.registro_busqueda);
        id=id+1;
        }
        
        String valores=Integer.toString(id)+","+base+","+menuprincipal+","+descripcion;
        C.agregar(tabla, campos, valores);
        AltaBases a= new AltaBases();
        return id;
    }
    
    public static  void altamenu(String menu, String casos, int opciones, String vozdescripcion)
    {
        String campos="idmenu,id_caso,numero_opciones,descripcion";
        String tabla="menu";
        EstructuraBD.conexion C= new EstructuraBD.conexion();    
        
        String valores=menu+","+casos+","+Integer.toString(opciones)+","+vozdescripcion;
        C.agregar(tabla, campos, valores);
    }
    
    
    public static void bajabases()
    {
        String tabla="casos";
        EstructuraBD.conexion C= new EstructuraBD.conexion();
        C.registro_busqueda="";
        String aux2="nombre='"+base+"'";
        String par2=")";
        String par1="(";
        aux2=par1+aux2+par2;
        String aux1="id_caso";
        C.busquedabaja1(tabla, aux1, aux2);
        if(C.registro_busqueda.length()!=0)
        {
             UIManager UI=new UIManager();
             UI.put("OptionPane.background",new ColorUIResource(0,51,51));
             UI.put("Panel.background",new ColorUIResource(0,51,51));
             String titulo="",mensaje="";
            titulo="Confirmacion!!";
            mensaje="<html><font color=#FFFFFF>¿Esta seguro de borrar la Base "+base+"?.";
            int respuesta = JOptionPane.showConfirmDialog(null, mensaje,titulo, JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE );
            if (respuesta == JOptionPane.YES_OPTION)
            {
            String clausula="Id_caso="+C.registro_busqueda;
            C.eliminar("menu",clausula);
            C.registro_busqueda="";
            EstructuraBD.conexion E= new EstructuraBD.conexion();
            E.eliminar("casos",clausula);
             
            titulo="Campo vacios!";
            mensaje="<html><font color=#FFFFFF>Base "+base+" borrada con exito!.";
            JOptionPane.showMessageDialog(null,mensaje,titulo,JOptionPane.INFORMATION_MESSAGE);
            }
            else
            {
                titulo="Atencion!!";
            mensaje="<html><font color=#FFFFFF>Base "+base+" no eliminada!";
            JOptionPane.showMessageDialog(null,mensaje,titulo,JOptionPane.INFORMATION_MESSAGE);
            }
            
            
        }
        
    }

}
