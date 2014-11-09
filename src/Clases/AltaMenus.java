/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Clases;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;


/**
 *
 * @author Mariana Valencia
 */
public class AltaMenus {

    
     
    Clases.VariablesCasos v= new Clases.VariablesCasos();
    String caso;

    public void altamenus(int x, int [] vector, int casos)
    {
        
        caso=Integer.toString(casos);
        UIManager UI=new UIManager();
        UI.put("OptionPane.background",new ColorUIResource(0,51,51));
        UI.put("Panel.background",new ColorUIResource(0,51,51));
        
        for (int i=0;i<x;i++)
            {
                int aux=vector[i];
                String menu0=caso+Integer.toString(i+1);
                String menu1=caso+"."+Integer.toString(i+1);
                
                if(aux!=0)
                {
                    for (int j=0;j<aux;j++)
                    {
                        String menu2=menu0+Integer.toString(j+1);
                        String menu3=menu1+"."+Integer.toString(j+1);
                        String[] choices = {"0","1", "2", "3","4", "5", "6","7", "8", "9","10"};
                        //JComboBox jcb = new JComboBox(list);
                        
                        
                    String input = (String) JOptionPane.showInputDialog(null, "<html><font color=#FFFFFF>Ingrese el numero de submenus para eel menu"+menu3+"\n",
        "Submenus "+menu3, JOptionPane.QUESTION_MESSAGE, null, // Use
                                                                        // default
                                                                        // icon
                choices, // Array of choices
                choices[0]); // Initial choice
    
                        //jcb.setEditable(false);
    //                    JOptionPane.showMessageDialog( null, "<html><font color=#FFFFFF>Ingrese el numero de submenus para eel menu "+menu3+"\n"+jcb, "Submenus "+menu3,JOptionPane.QUESTION_MESSAGE);
      //                  int opcion=Integer.parseInt(jcb.getSelectedItem().toString());
                    int opcion=Integer.parseInt(input);
                        altasubmenu(menu2,menu3,opcion);
                        
                    }
                    
                }
                
            }
        
        
        
        
    }
    
    public void altasubmenu(String menu1, String menu2, int opcion)
    {
        UIManager UI=new UIManager();
        UI.put("OptionPane.background",new ColorUIResource(0,51,51));
        UI.put("Panel.background",new ColorUIResource(0,51,51));
        String voz=JOptionPane.showInputDialog("<html><font color=#FFFFFF> Inserte la descripcion de voz para el menu "+menu2);
        //esoera, checo mi codigo
        
        VariablesCasos.altamenu(menu1, caso, opcion, voz);
        
        if(opcion!=0)
        {
            for (int i=0;i<opcion;i++)
            {
                String menu3=menu1+Integer.toString(i+1);
                String menu4=menu2+"."+Integer.toString(i+1);
                String[] choices = {"0","1", "2", "3","4", "5", "6","7", "8", "9","10"};
                String input = (String) JOptionPane.showInputDialog(null, "<html><font color=#FFFFFF>Ingrese el numero de submenus para el menu "+menu4+"\n",
        "Submenus "+menu4, JOptionPane.QUESTION_MESSAGE, null, // Use
                                                                        // default
                                                    // icon
                choices, // Array of choices
                choices[0]); // Initial choice
    
                        //jcb.setEditable(false);
                        //JComboBox jcb = new JComboBox(list);
                        //jcb.setEditable(false);
                       // JOptionPane.showMessageDialog( null, "<html><font color=#FFFFFF>Ingrese el numero de submenus para eel menu "+menu4+"\n"+jcb, "Submenus "+menu4, JOptionPane.QUESTION_MESSAGE);
                        //int opc=Integer.parseInt(jcb.getSelectedItem().toString());
                int opc= Integer.parseInt(input);
                        altasubmenu(menu3,menu4,opc);
                
            }
        }
        
        
        
    }
    
}
