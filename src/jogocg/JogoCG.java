package jogoCG;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import jogocg.kirby;


class Objects extends JPanel implements ActionListener, KeyListener{
    private boolean animation = false;
    private Image background = new ImageIcon("background.png").getImage();
    private kirby player = new kirby();
    int fase_y_max = 432, fase_x_max = 636;
    int fase_y_min = 88, fase_x_min = 204;
    //vetor de obstaculos
    private Obstaculos obs = new Obstaculos();
    int num_obstaculos;
    
    Objects(){
        addKeyListener(this);
        setFocusable(true);
    }
    
     int Colision(){
        //caso passe alguma borda ou chegue em algum obstaculo
        if(player.getY() + player.getAltura() >= fase_y_max) // bateu na parede de baixo
            return 0;
        if(player.getY() <= fase_y_min) // bateu na parede de cima
            return 1;
        if(player.getX() + player.getLargura() >= fase_x_max) // bateu na parece da direita
            return 2;
        if(player.getX() <= fase_x_min) // bateu na parede da esquerda
            return 3;
        /*
        if(player.getY() + player.getAltura() >= 263 && player.getY() <= 319) // bateu na parede de baixo
            return 5;
        if(player.getX() + player.getLargura() >= 319 && player.getX() <= 394) // bateu na parece da direita
            return 6;
        */
        
        //para cada obstaculo
        /*
        if( (player.getY() + player.getAltura() <= obs.getY() && (player.getX()+player.getLargura() >= obs.getX() || player.getX() <= obs.getX() + obs.getLargura()))
            || player.getX() <= obs.getX()+ obs.getLargura() && (player.getY()+player.getAltura() >= obs.getY() || player.getY() <= obs.getY() + obs.getAltura())
            || player.getY() >= obs.getY() + obs.getAltura() && (player.getX()+player.getLargura() >= obs.getX() || player.getX() <= obs.getX() + obs.getLargura())
            || player.getX() + player.getLargura() >= obs.getX() && (player.getY()+player.getAltura() >= obs.getY() || player.getY() <= obs.getY() + obs.getAltura()))
            return true; */
        
        /*
        if( (player.getY() + player.getAltura() <= 110 && (player.getX()+player.getLargura() >= 220 || player.getX() <= 250))
            || player.getX() <= 250 && (player.getY()+player.getAltura() >= 110 || player.getY() <= 325)
            || player.getY() >= 325 && (player.getX()+player.getLargura() >= 220 || player.getX() <= 250)
            || player.getX() + player.getLargura() >= 220 && (player.getY()+player.getAltura() >= 110 || player.getY() <= 325))
            return true;
        */
        return 4;
    }
    
    private void Cozinha(Graphics g) {

        g.drawImage(background,0,0,null);
       
        repaint();
    }
    public void startAnimation() {
      animation = true;
    }

    public void stopAnimation() {
      animation = false;
    }
    
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Cozinha(g);
        if (player.getImage()[player.getCurrentImage()].getImageLoadStatus() == MediaTracker.COMPLETE && animation == true) {
            player.getImage()[player.getCurrentImage()].paintIcon(this, g, player.getX(), player.getY());
            player.setCurrentImage((player.getCurrentImage() + 1) % 3);
            try {
                TimeUnit.MILLISECONDS.sleep(60);
            } catch (InterruptedException ex) {
                Logger.getLogger(Objects.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        else
            player.getImage()[1].paintIcon(this, g, player.getX(), player.getY());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if(Colision() == 4)
            player.keyPressed(e);
        
        if(Colision() == 0)
            player.setY(-1);

        if(Colision() == 1)
            player.setY(1);     

        if(Colision() == 2)
            player.setX(-1);

        if(Colision() == 3)
            player.setX(1);
        
        /*
        if(Colision() == 5)
            if(key == KeyEvent.VK_DOWN)
                player.setY(-1);
            else
                player.setY(1);
        
        if(Colision() == 6)
            if(key == KeyEvent.VK_LEFT)
                player.setX(1);
            else
                player.setX(-1);
        */
        
        System.out.print(Colision()+ " ("+player.getY()+", "+player.getX()+") "+"\n");
        startAnimation();
    }

    @Override
    public void keyReleased(KeyEvent e) {
         player.keyReleased(e);
         stopAnimation();
    }
}

public class JogoCG extends JFrame {

    JogoCG() {

        add(new Objects());

        setTitle("Jogo de CG MONSTRAO");
        setSize(700, 520);
        setLocationRelativeTo(null);        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
   
    public static void main(String[] args) {

        JogoCG novo = new JogoCG();
    }
}