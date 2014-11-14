/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package callcenter;

/**
 *
 * @author Lee
 */
import Supervisor.*;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
/**
 * @web http://www.jc-mouse.net
 * @author Mouse
 */
public class hilo_cerrarsesion implements Runnable{

    private JLabel logout;
    private boolean entrada;
    private int value = 5;//retardo en milisegundos

    /**
 * Constructor de clase
 */
    public hilo_cerrarsesion( JLabel barra , boolean version )
    {
        this.logout= barra;
        this.entrada= version;
        this.value = value;
    }

    @Override
    public void run() {
        int t=10000;
        int x, y, w, h;
        x = 759;
        y = 20;
        w = 10;
        h = 60;
        for (int i = 0; i < 140; i++) {
            logout.setSize(w, h);
            logout.setLocation(x, y);
            x--;
            w++;
            try {
                Thread.sleep(this.value);
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
        }
        for(int i=0;i < 2000;i++){
            logout.setBounds(x, y, w, h);
            try {
                Thread.sleep(this.value);
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
        }
        for (int i = 0; i < 140; i++) {
            logout.setSize(w, h);
            logout.setLocation(x, y);
            x++;
            w--;
            try {
                Thread.sleep(this.value);
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
        }
    }

}
