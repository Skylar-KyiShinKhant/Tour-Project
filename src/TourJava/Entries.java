/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TourJava;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.border.*;
/**
 *
 * @author steve
 */
public class Entries extends javax.swing.JFrame implements ActionListener, Runnable{
    
    ImageIcon logo=new ImageIcon(getClass().getClassLoader().getResource("Images/TravelLogo.png"));
    JPanel panel;
    JButton b1,b2,b3,b4,b5,b6;
    JLabel label;
    Thread t;
    
    public Entries() {
        initComponents();
        this.setIconImage(logo.getImage());
        this.setTitle("Travel Agent System");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setExtendedState(this.MAXIMIZED_BOTH);
        this.setLayout(new BorderLayout());
        
        ImageIcon image1=new ImageIcon(ClassLoader.getSystemResource("Images/Entries.jpeg"));
        Image img1=image1.getImage().getScaledInstance(1300, 800, Image.SCALE_DEFAULT);
        ImageIcon image2=new ImageIcon(img1);
        JLabel img2=new JLabel(image2);
        this.add(img2,BorderLayout.CENTER);
                
        label=new JLabel(" Travel Agent System ");
        label.setForeground(Color.orange);
        label.setFont(new Font("Trebuchet M3",Font.BOLD,50));
        label.setLocation(350,700);
        label.setSize(800,60);
        img2.add(label);
        
        //Layout
        GridBagLayout gbl=new GridBagLayout();
        GridBagConstraints gbc=new GridBagConstraints();
        gbc.weightx=1;
        gbc.weighty=1;
        gbc.fill=GridBagConstraints.BOTH;
        
        panel=new JPanel();        
        panel.setLayout(gbl);
        this.add(panel,BorderLayout.WEST);
        
        gbc.gridx=1;
        gbc.gridy=1;
        gbc.gridwidth=1;
        gbc.gridheight=1;
        b1=new JButton("Create Packages");
        b1.setBackground(new Color(0,0,128));
        b1.setForeground(Color.orange);
        b1.setFont(new Font("Trebuchet M3",Font.PLAIN,25));
        b1.addActionListener(this);
        gbl.setConstraints(b1, gbc);
        panel.add(b1);
        
        gbc.gridy=2;
        b2=new JButton("Purchased Packages");
        b2.setBackground(new Color(0,0,128));
        b2.setForeground(Color.orange);
        b2.setFont(new Font("Trebuchet M3",Font.PLAIN,25));
        b2.addActionListener(this);
        gbl.setConstraints(b2, gbc);
        panel.add(b2);
        
        gbc.gridy=3;
        b3=new JButton("Packages Slideshow");
        b3.setBackground(new Color(0,0,128));
        b3.setForeground(Color.orange);
        b3.setFont(new Font("Trebuchet M3",Font.PLAIN,25));
        b3.addActionListener(this);
        gbl.setConstraints(b3, gbc);
        panel.add(b3);
        
        gbc.gridy=4;
        b4=new JButton("Calculator");
        b4.setBackground(new Color(0,0,128));
        b4.setForeground(Color.orange);
        b4.setFont(new Font("Trebuchet M3",Font.PLAIN,25));
        b4.addActionListener(this);
        gbl.setConstraints(b4, gbc);
        panel.add(b4);
        
        gbc.gridy=5;
        b5=new JButton("Notepad");
        b5.setBackground(new Color(0,0,128));
        b5.setForeground(Color.orange);
        b5.setFont(new Font("Trebuchet M3",Font.PLAIN,25));
        b5.addActionListener(this);
        gbl.setConstraints(b5, gbc);
        panel.add(b5);
        
        gbc.gridy=6;
        gbc.insets=new Insets(0,0,0,0);
        b6=new JButton("About");
        b6.setBackground(Color.orange);
        b6.setForeground(new Color(0,0,128));
        b6.setFont(new Font("Trebuchet M3",Font.PLAIN,25));
        b6.addActionListener(this);
        gbl.setConstraints(b6, gbc);
        panel.add(b6);
        
        gbc.gridy=7;
        ImageIcon image3=new ImageIcon(ClassLoader.getSystemResource("Images/TravelLogo.png"));
        Image img3=image3.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
        ImageIcon image4=new ImageIcon(img3);
        JLabel img4=new JLabel(image4);
        gbl.setConstraints(img4, gbc);
        panel.add(img4);
        
        t=new Thread(this);
        t.start();
    }
    
    @Override
    public void run() {
        while(true)
        {
            label.setVisible(true);
            try
            {
                Thread.sleep(800);
            }
            catch(Exception e){}
            
            label.setVisible(false);
            try
            {
                Thread.sleep(800);
            }
            catch(Exception e){}
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource().equals(b1))
        {
            new CreatePackages().setVisible(true);
            this.setVisible(false);
        }
        else if(ae.getSource().equals(b2))
        {
            new PurchasedPackages().setVisible(true);
            this.setVisible(false);
        }
        else if(ae.getSource().equals(b3))
        {
            new PackagesSlides().setVisible(true);
        }
        else if(ae.getSource().equals(b4))
        {
            try
            {
                Runtime.getRuntime().exec("calc");
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
        }
        else if(ae.getSource().equals(b5))
        {
            UIManager.put("MenuBar.background", new Color(0,0,128));
                
            UIManager.put("Menu.foreground", Color.orange);
            UIManager.put("Menu.selectionBackground", Color.orange);
            UIManager.put("Menu.selectionForeground", new Color(0,0,128));
                
            UIManager.put("MenuItem.background", new Color(0,0,128));
            UIManager.put("MenuItem.foreground", Color.orange);
            UIManager.put("MenuItem.selectionBackground", Color.orange);
            UIManager.put("MenuItem.selectionForeground", new Color(0,0,128));
                
            UIManager.getLookAndFeelDefaults().put("MenuItem.acceleratorForeground", Color.orange);
            UIManager.getLookAndFeelDefaults().put("MenuItem.acceleratorSelectionForeground", Color.red);
            new Notepad().setVisible(true);
        }
        else if(ae.getSource().equals(b6))
        {
            new About(this,true).setVisible(true);
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

    
    public static void main(String args[]) {
        
                new Entries().setVisible(true);
            
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    

    
}
