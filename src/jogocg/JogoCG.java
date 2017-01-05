package jogoCG;
import java.awt.Color;
import java.util.Timer;
import java.util.Random;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
import jogocg.kirby;



class Objects extends JPanel implements ActionListener, KeyListener{
    private boolean animation = false;
    private Image background = new ImageIcon("background.png").getImage();
    private kirby player = new kirby();
    private int[] esteira = new int[13];
    int fase_y_max = 432, fase_x_max = 586;
    int fase_y_min = 88, fase_x_min = 204;
    //vetor de obstaculos
    private Obstaculos obs = new Obstaculos();
    Random rand = new Random();
    private Timer relogio;
    private int tempoRestante = 180;
    
    Objects(){
        Timer movEsteira = new Timer();
        relogio = new Timer();
        movEsteira.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                // Move fila
                esteira[11] = esteira[10];
                esteira[10] = esteira[9];
                esteira[9] = esteira[8];
                esteira[8] = esteira[7];
                esteira[7] = esteira[6];
                esteira[6] = esteira[5];
                esteira[5] = esteira[4];
                esteira[4] = esteira[3];
                esteira[3] = esteira[2];
                esteira[2] = esteira[1];
                esteira[1] = esteira[0];
                // Novo ingrediente
                int randomNum = rand.nextInt(6 - 0 + 1) + 0; 
                esteira[0] = randomNum;
            }
        }, 2*60*5, 2*60*5);
               
               
        relogio.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                // Printa pontos
                System.out.println(tempoRestante--);
                if (tempoRestante< 0)
                    relogio.cancel();
            }
        }, 0, 1000); 
        
        Obstaculos obs = new Obstaculos();
        int randomNum = rand.nextInt(6 - 0 + 1) + 0; 
        esteira[0] = randomNum;
        for(int i = 1; i <12;i++)
            esteira[i] = 6;
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
        if(player.getX() <= fase_x_min + 40 && player.getY() <= 290 )
            return 3;
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
        
        if(tempoRestante > 0){
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

            // Ingredientes na esteira
            for(int i = 0; i < 12;i++)
                if(esteira[i] < 6){
                    int posy = 55+i*30;
                    obs.getIcones()[esteira[i]].paintIcon(this,g,165,posy);
            }
            // Printa inventario
            if(player.getIndex() < 6)
               obs.getIcones()[player.getIndex()].paintIcon(this,g,715,50);

            // Printa receita
            obs.getIcones()[player.p1.recipe.getI1()].paintIcon(this,g,670,230);
            obs.getIcones()[player.p1.recipe.getI2()].paintIcon(this,g,670+40,230);
            obs.getIcones()[player.p1.recipe.getI3()].paintIcon(this,g,670+80,230);

            obs.getIcones()[player.p2.recipe.getI1()].paintIcon(this,g,670,280);
            obs.getIcones()[player.p2.recipe.getI2()].paintIcon(this,g,670+40,280);
            obs.getIcones()[player.p2.recipe.getI3()].paintIcon(this,g,670+80,280);

            obs.getIcones()[player.p3.recipe.getI1()].paintIcon(this,g,670,330);
            obs.getIcones()[player.p3.recipe.getI2()].paintIcon(this,g,670+40,330);
            obs.getIcones()[player.p3.recipe.getI3()].paintIcon(this,g,670+80,330);

            // Printa pontos
            g.setColor(Color.white);
            g.drawString(""+player.getScore(), 730, 170);

            // Printa tempo
            g.setColor(Color.white);
            g.drawString(""+tempoRestante, 730, 450);
        }
        // GameOver
        if(tempoRestante <= 0){
            g.setColor(Color.darkGray);
            g.fillRect(0, 0, 820, 520);
            g.setColor(Color.white);
            g.drawString("Game Over", 350, 230);
            g.drawString("Pontuação Final: "+player.getScore(),330,250);
            repaint();
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
        int key = e.getKeyCode();
        int aux = 6;
        
        if(player.getX() > 200 && player.getX() < 215 && key == KeyEvent.VK_SPACE)
        {    
            if(player.getY() > 305 && player.getY() < 335 ){
                aux = esteira[9];
                esteira[9] = 6;
                player.keyPressed(e,aux);
            }
            if(player.getY() > 335 && player.getY() < 365 ){
                aux = esteira[10];
                esteira[10] = 6;
                player.keyPressed(e,aux);
            }
            if(player.getY() > 365 && player.getY() < 395 ){
                aux = esteira[11];
                esteira[11] = 6;
                player.keyPressed(e,aux);
            }
        }      

        if(player.getX() > 515 && player.getX() < 545 && key == KeyEvent.VK_SPACE)
        {    
            if(player.getY() > 110 && player.getY() < 170 )
                aux = 11;
            if(player.getY() > 210 && player.getY() < 270 )
                aux = 12;
            if(player.getY() > 320 && player.getY() < 380 )
                aux = 13;
            player.keyPressed(e,aux);
        }  
        
        if(Colision() == 4){
            player.keyPressed(e,aux);
        }
        
        if(Colision() == 0)
            player.setY(-1);

        if(Colision() == 1)
            player.setY(1);     

        if(Colision() == 2)
            player.setX(-1);

        if(Colision() == 3)
            player.setX(1);
        
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
        setSize(820, 520);
        setLocationRelativeTo(null);        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
   
    public static void main(String[] args) {

        JogoCG novo = new JogoCG();
    }
}