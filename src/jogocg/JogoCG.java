package jogoCG;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import java.awt.TexturePaint;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import jogocg.kirby;


class Surface extends JPanel {

    private BufferedImage bg;
    private TexturePaint bgtp;
    private kirby player = new kirby();
    private TexturePaint playertp;
    
    public Surface() {

        loadImages();
    }
    
    private void loadImages() {

        try {

            bg = ImageIO.read(new File("background.png"));            
        } catch (IOException ex) {

            Logger.getLogger(Surface.class.getName()).log(
                    Level.SEVERE, null, ex);
        }
    }

    private void doDrawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g.create();

        bgtp = new TexturePaint(bg, new Rectangle(0, 0, 690, 480));
        playertp = new TexturePaint(player.getImage(), new Rectangle(0, 0, 36, 40));
        
        
        g2d.setPaint(bgtp);
        g2d.fillRect(0, 0, 690, 480);
        
        g2d.setPaint(playertp);
        g2d.fillRect(player.getX(), player.getY(), 36, 40);
        
        g2d.dispose();
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        doDrawing(g);
    }
}

public class JogoCG extends JFrame {

    public JogoCG() {

        initUI();
    }
    
    private void initUI() {
        
        add(new Surface());

        setTitle("Jogo de CG MONSTRAO");
        setSize(700, 520);
        setLocationRelativeTo(null);        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
        
            @Override
            public void run() {
                JogoCG ex = new JogoCG();
                ex.setVisible(true);
            }
        });
    }
}