/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

/**
 *
 * @author Shary
 */
public class Music {

    public void reproduccion() {
        try {
            FileInputStream fis;
            Player player;
            File f = new File("Callcenter.mp3");
            fis = new FileInputStream(f);
            BufferedInputStream bis = new BufferedInputStream(fis);

            player = new Player(bis);
            player.play();
        } catch (JavaLayerException | FileNotFoundException e) {
        }

    }
}
