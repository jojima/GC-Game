package jogocg;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import jogoCG.panela;

public class kirby extends JPanel implements ActionListener {
    private int dx;
    private int dy;
    private int x;
    private int y;
    public ImageIcon[] images,imagesF,imagesC,imagesD,imagesE;
    private int currentImage = 0,totalImages = 3;
    private int image_index;
    public panela p1 = new panela();
    public panela p2 = new panela();
    public panela p3 = new panela();
    int score = 0;
    
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
        
        x = 450;
        y = 350;     
        image_index = 6; //default sem nada
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
     
    public void setIndex(int i)
    {
        image_index = i;
    }
    
    public int getIndex()
    {
        return image_index;
    }
    
    public void move() {
        x += dx;
        y += dy;
    }
    /*

*/
    public int getScore() {
        return score;
    }
    
    public void setScore(int value) {
        score += value;
    }
    
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    public void setX(int newX){
        this.x += newX;
    }
    
    public void setY(int newY){
        this.y += newY;
    }

    public ImageIcon[] getImage() {
        return images;
    }

    public void keyPressed(KeyEvent e, int i) {

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
        if (key == KeyEvent.VK_SPACE) {
            trocaIngrediente(i, 0);
        }
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
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    private void trocaIngrediente(int i, int param) {
        if (i < 10)//esteira
        {
            if(i != 6)
                this.setIndex(i);
        }
        else if(this.getIndex() != 6)
        {
            if(i == 11)
            {
                p1.colocaIngrediente(this.getIndex());
                this.setIndex(6);
                if(p1.getNIngredientes() == 3)//panela cheia
                {
                    int aux = 0;
                    boolean contains;
                    //ganha ou perde score
                    for(int j = 0; j < 3;j++)
                    {
                        if(p1.getIngrediente(j) == p1.recipe.getI1())
                            aux++;
                        if(p1.getIngrediente(j) == p1.recipe.getI2())
                            aux++;
                        if(p1.getIngrediente(j) == p1.recipe.getI3())
                            aux++;
                    }
                    if(aux == 3)
                        this.setScore(1000);
                    else
                        this.setScore(((aux-3)*500));
                    //esvazia a panela
                    p1.zeraCalderao();
                }
            }
            if(i == 12)
            {
                p2.colocaIngrediente(this.getIndex());
                this.setIndex(6);
                if(p2.getNIngredientes() == 3)//panela cheia
                {
                    int aux = 0;
                    boolean contains;
                    //ganha ou perde score
                    for(int j = 0; j < 3;j++)
                    {
                        if(p2.getIngrediente(j) == p2.recipe.getI1())
                            aux++;
                        if(p2.getIngrediente(j) == p2.recipe.getI2())
                            aux++;
                        if(p2.getIngrediente(j) == p2.recipe.getI3())
                            aux++;
                    }
                    if(aux == 3)
                        this.setScore(1000);
                    else
                        this.setScore(((aux-3)*500));
                    //esvazia a panela
                    p2.zeraCalderao();
                }
            }
            if(i == 13)
            {
                p3.colocaIngrediente(this.getIndex());
                this.setIndex(6);
                if(p3.getNIngredientes() == 3)//panela cheia
                {
                    int aux = 0;
                    boolean contains;
                    //ganha ou perde score
                    for(int j = 0; j < 3;j++)
                    {
                        if(p3.getIngrediente(j) == p3.recipe.getI1())
                            aux++;
                        if(p3.getIngrediente(j) == p3.recipe.getI2())
                            aux++;
                        if(p3.getIngrediente(j) == p3.recipe.getI3())
                            aux++;
                    }
                    if(aux == 3)
                        this.setScore(1000);
                    else
                        this.setScore(((aux-3)*500));
                    //esvazia a panela
                    p3.zeraCalderao();
                }
            }
        }
    }
}
