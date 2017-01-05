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
    private int x;
    private int y;
    private int altura;
    private int largura;
    private BufferedImage image;

    public Obstaculos() {
        
        initBarrier();
    }
    
    private void initBarrier() {
        x = 0;
        y = 0;        
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getAltura() {
        return altura;
    }
    
    public int getLargura() {
        return largura;
    }
    
    public BufferedImage getImage() {
        return image;
    }
}