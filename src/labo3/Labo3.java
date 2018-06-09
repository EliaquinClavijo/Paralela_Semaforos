/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labo3;


import javax.swing.JFrame;
/**
 *
 * @author User
 */
public class Labo3 extends JFrame {

    /**s
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
        Semaforo Chicas = new Semaforo(1);
        Semaforo BloqChicas = new Semaforo(1);
        Semaforo aforo = new Semaforo(0);
        Semaforo usoM = new Semaforo(0);
        Semaforo usov = new Semaforo(1);
        Semaforo usov_s = new Semaforo(1);
        Baño B = new Baño();
        
        // cero es mujer y  uno es varon  ... :'u q sed , q sueño alv  
        
        int[] Personas = {0,1,0,0,0,0,1,1,0,1,0,0,1,0,1,1,1,1,1,0};
        Object [] Lista = new Object[Personas.length];
        int init = 700; 
        
        for (int i =0; i< Personas.length;i++)
        {
            if (Personas[i]==1)
            {
                Lista[i]= new Chico(B,init, 180, 3,i+1,aforo,usov,usov_s,usoM,BloqChicas);init-=40;
            }
            else
            {
                Lista[i]= new Chica(B,init, 180, 1,i+1,usov,usov_s,Chicas,usoM,BloqChicas);init-=40;
            }
        }
        Panel_Baño  G = new Panel_Baño(Lista);
        Labo3 f = new Labo3();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setContentPane(G);
        f.setSize(1200, 500);
        f.setVisible(true);
    }
    
}
