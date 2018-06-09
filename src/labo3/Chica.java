/*
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
public class Chica extends JPanel{
    private int statute;
    private int start;
    private int x,pos,y;
    private int t;
    private Baño Total;
    Semaforo Chicas;
    Semaforo usoM;
    Semaforo usov;
    Semaforo usov_s;
    Semaforo BloqChicas;

    public Chica(Baño E,int x, int y, int t,int pos,Semaforo usov,Semaforo usov_s,Semaforo Chicas,Semaforo usoM,Semaforo BloqChicas) {
        this.x = x;
        this.y = y;
        this.t = t;
        this.pos = pos;
        this.Chicas = Chicas;
        this.usov = usov;
        this.usov_s = usov_s;
        this.usoM = usoM;
        this.BloqChicas = BloqChicas;
        Total = E;
        start = 0;
        statute = 1;
    }

    public int getStatute() {
        return statute;
    }

    public void setStatute(int statute) {
        this.statute = statute;
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
              Chicas.P();
              System.out.println("Im a lucky girl  c:" + Total.getCapacidad());
              if (Total.getCapacidad() > 0)
              {
                  System.out.println("Ups .. Those boys >:u  " + pos);
                  usoM.P();
              }
              BloqChicas.P();
              usov.P();
                   Total.setCapacidad(Total.getCapacidad()+1);                               
              usov.V();
               start = 1;}
           if (x < 1000){x = x+1;}
            
           if (x ==1000)
           {
               System.out.println("jejeje .. boys !! boys !!   " + pos);
               sleep(3000);
               usov_s.P();
                    Total.setCapacidad(Total.getCapacidad()-1);
                    BloqChicas.V(); Chicas.V();
                    statute = 0;
               usov_s.V();
                start = 0;
           }
      }
    }
    public void pintar (Graphics g) throws IOException{     
 
        ImageIcon I =  new ImageIcon("C:\\Users\\User\\Desktop\\Paralela\\Labo3\\src\\labo3\\chica.png");
        g.drawImage(I.getImage(), x, y,80,80, null);
      }
    
    
    
    
}
