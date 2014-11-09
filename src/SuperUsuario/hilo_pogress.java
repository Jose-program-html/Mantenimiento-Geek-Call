/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SuperUsuario;

/**
 *
 * @author Lee
 */
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
/**
 * @web http://www.jc-mouse.net
 * @author Mouse
 */
public class hilo_pogress implements Runnable{

    private JProgressBar jProgressBar;
    private int i = 1;
    private int value = 50;//retardo en milisegundos
    private boolean log=true;

    /**
 * Constructor de clase
 */
    public hilo_pogress( JProgressBar jProgressBar , int value , boolean log)
    {
        this.jProgressBar = jProgressBar;
        this.value = value;
        this.log=log;
    }

    @Override
    public void run() {
        i=1;        
        //mientra el trabajo en paralelo no finalice el jProgressBar continuara su animacion una y otra vez
        while(i!=100)
        {
            //si llega al limite 100 comienza otra vez desde 1, sino incrementa i en +1
            jProgressBar.setValue(i);
            jProgressBar.repaint();
            i++;
            //retardo en milisegundos
            try{Thread.sleep( this.value );}            
            catch (InterruptedException e){ System.err.println( e.getMessage() ); }            
            //si el trabajo en paralelo a terminado        
        }
        if(!log){
            JOptionPane.showMessageDialog(null, "Nombre de usuario no encontrado", "Usuario Incorrecto", JOptionPane.WARNING_MESSAGE);
        }
    }

}
