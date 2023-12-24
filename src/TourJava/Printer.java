/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TourJava;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author skylar
 */
public class Printer extends javax.swing.JDialog implements ActionListener {

    /**
     * Creates new form Printer
     */
    
    ImageIcon logo=new ImageIcon(getClass().getClassLoader().getResource("Images/Print.png"));
    JTextArea ta;
    JScrollPane sp;
    JButton b1,b2;
    
    public Printer(java.awt.Dialog parent, boolean modal,String info1,String info2,String info3,String info4,String info5,String info6) {
        super(parent, modal);
        initComponents();
        super.setTitle("Print Reciept");
        this.setIconImage(logo.getImage());
        this.setSize(500,700);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        
        ta=new JTextArea();
        ta.setFont(new Font("Trebuchet M3",Font.PLAIN,20));
        ta.setForeground(new Color(0,0,128));
        ta.setBorder(new EmptyBorder(10,10,5,5));
        ta.append("\t     Travel Agent\n");
        ta.append("-------------------------------------------------------------\n");
        ta.append("\t         Receipt\n");
        ta.append("-------------------------------------------------------------\n\n");
        ta.append("Customer Name\t"+info1+"\n\n");
        ta.append("PackageID\t\t"+info2+"\n\n");
        ta.append("Purchased Date\t"+info3+"\n\n");
        ta.append("Number of People\t"+info4+"\n\n");
        ta.append("Status\t\t"+info5+"\n\n");
        ta.append("Amount\t\t$ "+info6+"\n\n");
        ta.append("-------------------------------------------------------------\n");
        ta.append("\t***THANK YOU***\n");
        ta.append("-------------------------------------------------------------");
        ta.setEditable(false);
        sp=new JScrollPane(ta);
        sp.setBounds(25,25,450,550);
        this.add(sp);
        
        //Print Button
        ImageIcon icon1=new ImageIcon(ClassLoader.getSystemResource("Images/Print.png"));
        Image i1=icon1.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
        Icon icon2=new ImageIcon(i1);
        b1=new JButton("Print",icon2);
        b1.setFont(new Font("Trebuchet M3",Font.PLAIN,20));
        b1.setBackground(new Color(0,0,128));
        b1.setForeground(Color.orange);
        b1.setBounds(80,600,150,40);
        b1.addActionListener(this);
        this.add(b1);
        
        //Cancel Button
        ImageIcon icon3=new ImageIcon(ClassLoader.getSystemResource("Images/Cancel.png"));
        Image i2=icon3.getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT);
        Icon icon4=new ImageIcon(i2);
        b2=new JButton("Cancel",icon4);
        b2.setFont(new Font("Trebuchet M3",Font.PLAIN,20));
        b2.setBackground(Color.orange);
        b2.setForeground(new Color(0,0,128));
        b2.setBounds(270,600,150,40);
        b2.addActionListener(this);
        this.add(b2);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource().equals(b1))
        {
            try
            {
                ta.print();
            }
            catch(Exception e){}
        }
        else if(ae.getSource().equals(b2))
        {
            dispose();
        }
    }
    
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

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Printer dialog = new Printer(new javax.swing.JDialog(), true, "info1","info2","info3","info4","info5","info6");
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
