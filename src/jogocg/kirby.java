/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogocg;

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
public class kirby {
    private int dx;
    private int dy;
    private int x;
    private int y;
    private int altura;
    private int largura;
    private BufferedImage image;

    public kirby() {
        
        initPlayer();
    }
    
    private void initPlayer() {
        try{
            image = ImageIO.read(new File("k.png"));
        
        } catch (IOException ex) {

        }
        
        x = 400;
        y = 300;        
    }

    public void move() {
        x += dx;
        y += dy;
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

    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = -1;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 1;
        }

        if (key == KeyEvent.VK_UP) {
            dy = -1;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 1;
        }
    }

    public void keyReleased(KeyEvent e) {
        
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_UP) {
            dy = 0;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 0;
        }
    }
}
