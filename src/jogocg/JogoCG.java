package jogoCG;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import jogocg.kirby;


class Objects extends JPanel implements ActionListener, KeyListener{
    private Timer animationTimer;
    private Image background = new ImageIcon("background.png").getImage();
    private kirby player = new kirby();
    int fase_y_max = 430, fase_x_max = 635;
    int fase_y_min = 110, fase_x_min = 220;
    //vetor de obstaculos
    private Obstaculos obs = new Obstaculos();
    int num_obstaculos;
    
    Objects(){
        addKeyListener(this);
        setFocusable(true);
    }
    
     boolean Colision(){
        //caso passe alguma borda ou chegue em algum obstaculo
        if(  player.getY() + player.getAltura() <= fase_y_min 
          || player.getX() <= fase_x_min 
          || player.getY() >= fase_y_max 
          || player.getX() + player.getLargura() >= fase_x_max)
            return true;
        //para cada obstaculo
        /*
        if( (player.getY() + player.getAltura() <= obs.getY() && (player.getX()+player.getLargura() >= obs.getX() || player.getX() <= obs.getX() + obs.getLargura()))
            || player.getX() <= obs.getX()+ obs.getLargura() && (player.getY()+player.getAltura() >= obs.getY() || player.getY() <= obs.getY() + obs.getAltura())
            || player.getY() >= obs.getY() + obs.getAltura() && (player.getX()+player.getLargura() >= obs.getX() || player.getX() <= obs.getX() + obs.getLargura())
            || player.getX() + player.getLargura() >= obs.getX() && (player.getY()+player.getAltura() >= obs.getY() || player.getY() <= obs.getY() + obs.getAltura()))
            return true; */
        if( (player.getY() + player.getAltura() <= 110 && (player.getX()+player.getLargura() >= 220 || player.getX() <= 250))
            || player.getX() <= 250 && (player.getY()+player.getAltura() >= 110 || player.getY() <= 325)
            || player.getY() >= 325 && (player.getX()+player.getLargura() >= 220 || player.getX() <= 250)
            || player.getX() + player.getLargura() >= 220 && (player.getY()+player.getAltura() >= 110 || player.getY() <= 325))
            return true;
        return false;
    }
    
    private void Cozinha(Graphics g) {

        g.drawImage(background,0,0,null);
       
        repaint();
    }
    public void startAnimation() {
      if (animationTimer == null) {
        player.setCurrentImage(0);
        animationTimer = new Timer(0, this);
        animationTimer.start();
      } else if (!animationTimer.isRunning())
        animationTimer.restart();
    }

    public void stopAnimation() {
      animationTimer.stop();
    }
    
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Cozinha(g);
        if (player.getImage()[player.getCurrentImage()].getImageLoadStatus() == MediaTracker.COMPLETE) {
            player.getImage()[player.getCurrentImage()].paintIcon(this, g, player.getX(), player.getY());
            player.setCurrentImage((player.getCurrentImage() + 1) % 3);
        }
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
        if(Colision())
            player.keyPressed(e);
        
        System.out.print("olar");
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