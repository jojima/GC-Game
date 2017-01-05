/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogoCG;
import jogoCG.receita;
/**
 *
 * @author Yuela
 */
public class panela {
    private int y;
    private int altura;
    private int nIngredientes;
    private int[] ingredientes;
    public receita recipe = new receita();
    
    public panela() {
        this.ingredientes = new int[3];
        
        initCaldeirao();
    }
    
    private void initCaldeirao() {
        altura = 80;       
        this.ingredientes = new int[3];
        ingredientes[0] = 0;
        ingredientes[1] = 0;
        ingredientes[2] = 0;
        nIngredientes = 0;
    }
    public void setY(int y)
    {
        this.y = y;
    }
    
    public int getY() {
        return y;
    }
    
    public int getAltura() {
        return altura;
    }
    
    public int getNIngredientes() {
        return nIngredientes;
    }
    
    public int getIngrediente(int k) {
        return ingredientes[k];
    }
    
    public void colocaIngrediente(int ingrediente)
    {
        ingredientes[nIngredientes] = ingrediente;
        nIngredientes++;
    }
    public void cozinha(int ingrediente)
    {
        
    }
    
    public void zeraCalderao ()
    {
        ingredientes[0] = 0;
        ingredientes[1] = 0;
        ingredientes[2] = 0;
        nIngredientes = 0;
        recipe.novaReceita();
    }
}