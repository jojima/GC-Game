/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jogoCG;
import java.util.Random;
/**
 * 
 *
 * @author Yuela
 */
public class receita {
    private int[] ingredientes;
    Random rand = new Random();
    
    public receita() {
        
        initRecipe();
    }
    
    private void initRecipe() {
        this.ingredientes = new int[3];
        ingredientes[0] = 0;
        ingredientes[1] = 0;
        ingredientes[2] = 0;
        this.novaReceita();
    }
    public int getI1() {
        return ingredientes[0];
    }
    
    public int getI2() {
        return ingredientes[1];
    }
    
    public int getI3() {
        return ingredientes[2];
    }
    
    public void novaReceita()
    {
        ingredientes[0] = rand.nextInt(5 - 0 + 1) + 0;
        ingredientes[1] = rand.nextInt(5 - 0 + 1) + 0;
        ingredientes[2] = rand.nextInt(5 - 0 + 1) + 0;
    }
}