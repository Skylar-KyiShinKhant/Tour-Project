/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TourJava;
import javax.swing.*;
import java.awt.*;
/**
 *
 * @author skylar
 */
public class Splash {
    public static void main(String args[]){
        sframe f=new sframe("Travel Agent System");
        f.setVisible(true);
        int i;
        for(i=2;i<=1575;i+=5)
        {
            f.setLocation((1500/2)-(i/2)+25,(1000/2)-(i*36/100)+25);
            f.setSize(i,i*36/55);
            try
            {
               Thread.sleep(8);
            }
            catch(Exception e)  { }
        }
    }
}

class sframe extends JFrame implements Runnable{
    Thread t;
    ImageIcon logo=new ImageIcon(getClass().getClassLoader().getResource("Images/TravelLogo.png"));
    
    public sframe(String n){
        super(n);
        this.setLayout(new FlowLayout());  
        this.setIconImage(logo.getImage());
        this.setUndecorated(true);
        
        ImageIcon image1=new ImageIcon(ClassLoader.getSystemResource("Images/Splash.jpeg"));
        Image img1=image1.getImage().getScaledInstance(1600, 1000, Image.SCALE_DEFAULT);
        ImageIcon image2=new ImageIcon(img1);
        
        JLabel img2=new JLabel(image2);
        this.add(img2);
        t=new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        try
        {
            Thread.sleep(6000);
            new Progress().setVisible(true);
            this.setVisible(false);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
}
