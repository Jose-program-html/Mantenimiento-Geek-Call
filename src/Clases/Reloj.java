/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.Calendar;
import javax.swing.JLabel;

/**
 *
 * @author Shary
 */
public class Reloj {

    JLabel hr;
    Calendar calendario;
    int hora, minutos, segundos;
    public  String hour;

    public Reloj(JLabel hrs) {
        hr = hrs;
        calendario = new java.util.GregorianCalendar();
        segundos = calendario.get(Calendar.SECOND);
        javax.swing.Timer timer = new javax.swing.Timer(1000, new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                java.util.Date actual = new java.util.Date();
                calendario.setTime(actual);
                hora = calendario.get(Calendar.HOUR_OF_DAY);
                minutos = calendario.get(Calendar.MINUTE);
                segundos = calendario.get(Calendar.SECOND);
                hour = String.format("%02d:%02d:%02d", hora, minutos, segundos);
                hr.setText(hour);
            }
        });
        timer.start();
    }

}
