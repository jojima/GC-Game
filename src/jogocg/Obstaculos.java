/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogoCG;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
/**
 *
 * @author Yuela
 */
public class Obstaculos {
    private ImageIcon[] icones = new ImageIcon[6];
    

    public Obstaculos() {
        icones[0] = new ImageIcon("ingredientes/arroz.png");
        icones[1] = new ImageIcon("ingredientes/boi.png");
        icones[2] = new ImageIcon("ingredientes/cebola.png");
        icones[3] = new ImageIcon("ingredientes/ovo.png");
        icones[4] = new ImageIcon("ingredientes/pao.png");
        icones[5] = new ImageIcon("ingredientes/peixe.png");
     
    }
    public ImageIcon[] getIcones(){
        return icones;
    }
}