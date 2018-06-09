/* C:\Users\User\Desktop\Paralela\Labo3\src\labo3\chico.png
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labo3;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.io.IOException;
import static java.lang.Thread.sleep;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
/**
 *
 * @author User
 */
public class Chico extends JPanel{
    private int statute;
    private int start;
    private int x,pos, y;
    private int t;
    private Baño Total;
    Semaforo aforo;
    Semaforo usov;
    Semaforo usov_s;
    Semaforo usoM;
    Semaforo BloqChicas;
    
    public int getStatute() {
        return statute;
    }

    public void setStatute(int statute) {
        this.statute = statute;
    }

    public Chico(Baño E,int x, int y, int t,int pos,Semaforo aforo,Semaforo usov,Semaforo usov_s,Semaforo usoM,Semaforo BloqChicas) {
        this.x = x;
        this.y = y;
        this.t = t;
        this.pos = pos;
        this.aforo = aforo;
        this.usov = usov;
        this.usov_s = usov_s;
        this.usoM = usoM;
        this.BloqChicas = BloqChicas;
        Total = E;
        start = 0;
        statute = 1;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }
    
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    public int retardo (){ 
          return t;
    }
    public void trytouse() throws InterruptedException{
        if (statute == 1){
        
           if (start == 0){
                //System.out.println("Im been used " + pos +" "+Total.getCapacidad());
               BloqChicas.P();
               usov.P();
                   Total.setCapacidad(Total.getCapacidad()+1);
                   if ((Total.getCapacidad())>5){
                        System.out.println("I am a Boy .. It's Full .. :"+pos);
                         aforo.P(); }                  
                   System.out.println("Lets Go boys " + pos +"  we are :"+Total.getCapacidad());                   
               usov.V();
               BloqChicas.V();
               start = 1;
           }
           if (x < 1000){x = x+2;}
           if (x ==1000)
           {
               x = (int) (Math.random() * 100) + 990;
               y = (int) (Math.random() * 350) + 1;
               sleep((int) (Math.random() * 4000) + 3000);
               usov_s.P();
                    Total.setCapacidad(Total.getCapacidad()-1);
                    
                    if (Total.getCapacidad()<=5){
                        aforo.V();}
                    if ((Total.getCapacidad())==0)
                    {
                        usoM.V();
                    }
                    statute = 0;
               usov_s.V();
               start = 0;
           }
        }  
      }
    
    public void pintar (Graphics g) throws IOException{     
 
        ImageIcon I =  new ImageIcon("C:\\Users\\User\\Desktop\\Paralela\\Labo3\\src\\labo3\\chico.png");
        g.drawImage(I.getImage(), x, y,80,80, null);
      }
    
    
    
    
}