/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuperUsuario;

import Clases.Iniciador;
import Clases.Music;

/**
 *
 * @author Lee
 */
public class main {

    public static void main(String[] args) {
        Base_de_datos_metodos metodo = new Base_de_datos_metodos();
        Serial ventana = new Serial();
        ventana.setLocationRelativeTo(null);
        int serial2 = metodo.serial();
        if (serial2 == 0) {
            ventana.setVisible(true);
        } else {
            if (metodo.administradores()) {
                try {
                    Clases.Music m = new Music();
                    m.reproduccion();
                    Thread.sleep(1);
                    Clases.Iniciador ini = new Iniciador();
                    ini.reproduccion();
                    Thread.sleep(1);
                } catch (InterruptedException ex) {

                }
                login_superusu m = new login_superusu();
                m.setLocationRelativeTo(null);
                m.setVisible(true);
            } else {
                try {
                    Clases.Music m = new Music();
                    m.reproduccion();
                    Thread.sleep(1);
                    Clases.Iniciador ini = new Iniciador();
                    ini.reproduccion();
                    Thread.sleep(1);
                } catch (InterruptedException ex) {

                }
                Supervisor.Login m = new Supervisor.Login();
                m.setLocationRelativeTo(null);
                m.setVisible(true);
            }
        }
    }
}
