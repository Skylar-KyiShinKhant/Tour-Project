/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TourJava;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author steve
 */
public class About extends javax.swing.JDialog {

    /**
     * Creates new form About
     */
    ImageIcon logo=new ImageIcon(getClass().getClassLoader().getResource("Images/TravelLogo.png"));
    JLabel l1,l2,l3;
    JButton b1;
    
    public About(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        super.setTitle("About");
        this.setIconImage(logo.getImage());
        this.setLayout(null);
        this.setResizable(false);
        this.setSize(500,400);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(240,240,240));
        
        l1=new JLabel("Travel Agent System");
        l1.setFont(new Font("Trebuchet M3",Font.BOLD,25));
        l1.setForeground(new Color(0,0,128));
        l1.setBounds(125,30,300,30);
        this.add(l1);
        
        ImageIcon image1=new ImageIcon(ClassLoader.getSystemResource("Images/TravelLogo.png"));
        Image img1=image1.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
        ImageIcon image2=new ImageIcon(img1);
        JLabel img2=new JLabel(image2);
        img2.setBounds(20,100,150,150);
        this.add(img2);
        
        l2=new JLabel("<html>This is a simple system for a travel agent. The agent has packages to take customers to such amazing countries as Myanmar, Japan, Brazil and French, with reasonable prices.</html>");
        l2.setFont(new Font("Trebuchet M3",Font.PLAIN,20));
        l2.setForeground(new Color(0,0,128));
        l2.setBounds(180,80,300,200);
        this.add(l2);
        
        l3=new JLabel("<html>Creater : Skylar Kyi Shin Khant</html>");
        l3.setFont(new Font("Trebuchet M3",Font.PLAIN,15));
        l3.setForeground(new Color(215,0,64));
        l3.setBounds(50,310,250,30);
        this.add(l3);
        
        b1=new JButton("OK");
        b1.setFont(new Font("Trebuchet M3",Font.BOLD,15));
        b1.setForeground(new Color(0,0,128));
        b1.setBackground(Color.orange);
        b1.setBounds(360,310,80,30);
        b1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                dispose();
            }
        });
        this.add(b1);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

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
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(About.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(About.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(About.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(About.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                About dialog = new About(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}