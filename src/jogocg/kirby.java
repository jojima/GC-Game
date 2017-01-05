/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogocg;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;
/**
 *
 * @author Yuela
 */
public class kirby extends JPanel implements ActionListener {
    private int dx;
    private int dy;
    private int x;
    private int y;
    public ImageIcon[] images,imagesF,imagesC,imagesD,imagesE;
    private int animationDelay = 10,currentImage = 0,totalImages = 3;
    private Timer animationTimer;

    public kirby() {
        
        initCraft();
    }
    
    private void initCraft() {      
      
        imagesF = new ImageIcon[totalImages];
        for (int i = 0; i < imagesF.length; ++i){
            int j = i+1;
            imagesF[i] = new ImageIcon("garcom/F" + j + ".png");
        }
        imagesC = new ImageIcon[totalImages];
        for (int i = 0; i < imagesC.length; ++i){
            int j = i+1;
            imagesC[i] = new ImageIcon("garcom/C" + j + ".png");
        }
        imagesD = new ImageIcon[totalImages];
        for (int i = 0; i < imagesD.length; ++i){
            int j = i+1;
            imagesD[i] = new ImageIcon("garcom/D" + j + ".png");
        }
        imagesE = new ImageIcon[totalImages];
        for (int i = 0; i < imagesE.length; ++i){
            int j = i+1;
            imagesE[i] = new ImageIcon("garcom/E" + j + ".png");
        }
        images = new ImageIcon[totalImages];
        images = imagesF;
        
        x = 400;
        y = 300;        
    }
    
    public int getLargura() {
        return 50;
    }
    
    public int getAltura() {
        return 50;
    }
    
    public int getCurrentImage(){
        return currentImage;
    }
    
    public void setCurrentImage(int x){
        currentImage = x;
    }
    
    public void move() {
        x += dx;
        y += dy;
    }
    /*

*/
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public ImageIcon[] getImage() {
        return images;
    }

    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = -4;
            images = imagesE;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 4;
            images = imagesD;
        }

        if (key == KeyEvent.VK_UP) {
            dy = -4;
            images = imagesC;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 4;
            images = imagesF;
        }
       // startAnimation();
        move();
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
     //   stopAnimation();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}
