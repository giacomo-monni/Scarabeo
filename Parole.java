/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parole;

import static java.lang.Thread.sleep;
/**
 *
 * @author giacomo-monni
 */
public class Parole
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // TODO code application logic here
        JFrameParole finestra = new JFrameParole(args[0]);
        finestra.setVisible(true);
        finestra.setExtendedState(JFrameParole.MAXIMIZED_BOTH);
        finestra.setDefaultCloseOperation(JFrameParole.EXIT_ON_CLOSE);
        
        
    }
}
