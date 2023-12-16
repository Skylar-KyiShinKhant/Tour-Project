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
 * @author steve
 */
public class PackagesSlides extends javax.swing.JFrame implements Runnable{

    /**
     * Creates new form PackagesSlides
     */Thread t;
    ImageIcon logo=new ImageIcon(getClass().getClassLoader().getResource("Images/TravelLogo.png"));
    
    ImageIcon i1,i2,i3,i4,i5;
    ImageIcon[] image={i1,i2,i3,i4,i5};
    
    Image img1, img2, img3,img4,img5;
    Image[] img={img1, img2, img3,img4,img5};
    
    ImageIcon j1,j2,j3,j4,j5;
    ImageIcon[] jimage={j1,j2,j3,j4,j5};
    
    JLabel jimg1, jimg2,jimg3,jimg4,jimg5;
    JLabel[] jimg={jimg1, jimg2,jimg3,jimg4,jimg5};
    
    String[] imgNames={"Intro.png","Myanmar.jpeg","Japan.jpeg","Brazil.jpeg","France.jpg"};
    
    JLabel label;
    String[] captions={"","Myanmar","Japan","Brazil","France"};
    
    public PackagesSlides() {
        initComponents();
        this.setIconImage(logo.getImage());
        this.setTitle("Package Slideshow");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setExtendedState(this.MAXIMIZED_BOTH);
        this.setLayout(null);
            
        label=new JLabel();
        label.setFont(new Font("Trebuchet M3",Font.BOLD,80));
        label.setForeground(new Color(0,0,128));
        label.setBounds(100,100,400,100);
        
        for(int i=0;i<5;i++)
        {
            image[i]=new ImageIcon(ClassLoader.getSystemResource("Images/"+imgNames[i]));
            img[i]=image[i].getImage().getScaledInstance(1600, 1000, Image.SCALE_DEFAULT);
            jimage[i]=new ImageIcon(img[i]);
            jimg[i]=new JLabel(jimage[i]);
            jimg[i].setBounds(0,0,1600,1000);
            this.add(jimg[i]);
        }
        
        t=new Thread(this);
        t.start();
        
    }

    @Override
    public void run() {
        
        for(int i=0;i<=5;i++)
        {
            if(i>4)
            {
                i=0;
                label.setText(captions[i]);
                jimg[i].add(label);
                jimg[i].setVisible(true);
                try
                {
                    Thread.sleep(3000);
                    jimg[i].setVisible(false);
                }
                catch(Exception e){}
            }
            else
            {
                label.setText(captions[i]);
                jimg[i].add(label);
                jimg[i].setVisible(true);
                try
                {
                    Thread.sleep(3000);
                    jimg[i].setVisible(false);
                }
                catch(Exception e){}
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
                new PackagesSlides().setVisible(true);
            
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
