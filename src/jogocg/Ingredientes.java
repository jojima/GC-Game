package jogoCG;
import javax.swing.ImageIcon;

public class Ingredientes {
    private ImageIcon[] icones = new ImageIcon[6];
    
    public Ingredientes() {
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