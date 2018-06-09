/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labo3;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Panel_Baño extends JPanel implements Runnable {
    Object [] Lista;
    Thread[] Hilos_Control;
    
    public Panel_Baño(Object [] Entrada) throws InterruptedException
    {
        Hilos_Control = new Thread[Entrada.length];
        Lista = Entrada;
         for (int i=0; i<Entrada.length; ++i)
            Hilos_Control[i]= new Thread(this);

        for (int i=0; i<Hilos_Control.length; ++i) 
        {   
            Hilos_Control[i].start();
            //Hilos_Control[i].sleep(1000);
        }
    }
    public void run(){
        for (int i=0; i<Hilos_Control.length; ++i){
          while (Hilos_Control[i].currentThread()== Hilos_Control[i]) {
                    //System.out.println(Hilos_Control[i].getName());
                    
                    if( Lista[i] instanceof Chica){try {
                        Hilos_Control[i].sleep(((Chica) Lista[i]).retardo());
                        ((Chica) Lista[i]).trytouse();
                         
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Panel_Baño.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    } 
                    else {try {
                        Hilos_Control[i].sleep(((Chico) Lista[i]).retardo());
                        ((Chico) Lista[i]).trytouse();
                            
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Panel_Baño.class.getName()).log(Level.SEVERE, null, ex);
                        }
                       }    
                  repaint();
            }
        }
    }
    
    public void paintComponent(Graphics g) {       
      super.paintComponent(g);
      ImageIcon I =  new ImageIcon("C:\\Users\\User\\Desktop\\Paralela\\Labo3\\src\\labo3\\baño.png");
      g.drawImage(I.getImage(), 0, 0,1180,450, null);
      I =  new ImageIcon("C:\\Users\\User\\Desktop\\Paralela\\Labo3\\src\\labo3\\cartel.png");
      g.drawImage(I.getImage(), 860,110,80,60, null);
      I =  new ImageIcon("C:\\Users\\User\\Desktop\\Paralela\\Labo3\\src\\labo3\\viga.png");
      g.drawImage(I.getImage(), 900,20,80,150, null);
      g.drawImage(I.getImage(), 900,260,80,170, null);
      for(int i=0; i<Lista.length;++i)
          try {
              if( Lista[i] instanceof Chica)
              { if (((Chica) Lista[i]).getStatute() ==1){  
                  ((Chica) Lista[i]).pintar(g);} }
              else 
              { if (((Chico) Lista[i]).getStatute() ==1){
                  ((Chico) Lista[i]).pintar(g);}
              }    
          } catch (IOException ex) {
              Logger.getLogger(Panel_Baño.class.getName()).log(Level.SEVERE, null, ex);
          }     
    }

}
