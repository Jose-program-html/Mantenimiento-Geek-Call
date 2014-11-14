/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ConexionSocket;

import java.io.*;
import java.net.*;
import java.util.logging.*;

public class Hilo_Socket_Servidor extends Thread {

    public Hilo_Socket_Servidor(){
        
    }
    public void run() {
        ServerSocket ss;
        try {
            int puerto=10578;
            ss = new ServerSocket(puerto,100,InetAddress.getLocalHost());
            int idSession = 0;
            while (SuperUsuario.Variables_globales.isServidor_status()) {
                Socket socket;
                socket = ss.accept();
                ((Hilo_Servidor) new Hilo_Servidor(socket, idSession)).start();
                idSession++;
            }
        } catch (IOException ex) {
            Logger.getLogger(Hilo_Socket_Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
