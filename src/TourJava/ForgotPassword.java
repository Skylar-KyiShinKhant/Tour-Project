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
import java.sql.*;
import javax.swing.event.*;
/**
 *
 * @author skylar
 */
public class ForgotPassword extends javax.swing.JFrame implements ActionListener {

    /**
     * Creates new form ForgotPassword
     */
    Connection con=null;
    Statement ste=null;
    ResultSet rs=null;
    String sql="";
    
    ImageIcon logo=new ImageIcon(getClass().getClassLoader().getResource("Images/TravelLogo.png"));
    JPanel p1,p2;
    JLabel l1,l2,l3,l4,l5,re1,re2,re3;
    JTextField t1,t2;
    JButton b1,b2,b3;
    
    public ForgotPassword() {
        try
        {
            con=DBConnection.getConnection();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        initComponents();
        this.setIconImage(logo.getImage());
        this.setTitle("Forgot Password");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setExtendedState(this.MAXIMIZED_BOTH);
        this.setLayout(new BorderLayout());
        
        //Layout
        GridBagLayout gbl=new GridBagLayout();
        GridBagConstraints gbc=new GridBagConstraints();
        gbc.weightx=1;
        gbc.weighty=1;
        gbc.fill=GridBagConstraints.BOTH;
        
        //Border
        Border line=new LineBorder(Color.darkGray);
        Border empty=new EmptyBorder(0,5,0,5);
        CompoundBorder border=new CompoundBorder(line,empty);
        
        //Panel 1
        p1=new JPanel();
        p1.setLayout(gbl);
        p1.setBackground(Color.white);
        
        gbc.gridx=1;
        gbc.gridy=2;
        gbc.gridwidth=1;
        gbc.gridheight=1;
        gbc.insets=new Insets(-250,300,100,0);
        ImageIcon Lock1=new ImageIcon(ClassLoader.getSystemResource("Images/Lock.png"));
        Image lock1=Lock1.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
        ImageIcon Lock2=new ImageIcon(lock1);
        JLabel lock2=new JLabel(Lock2);
        gbl.setConstraints(lock2, gbc);
        p1.add(lock2);
        
        
        gbc.gridy=1;
        gbc.insets=new Insets(100,50,0,50);
        ImageIcon image1=new ImageIcon(ClassLoader.getSystemResource("Images/TravelLogo.png"));
        Image img1=image1.getImage().getScaledInstance(500, 500, Image.SCALE_DEFAULT);
        ImageIcon image2=new ImageIcon(img1);
        JLabel img2=new JLabel(image2);
        gbl.setConstraints(img2, gbc);
        p1.add(img2);
        
        //Panel 2
        p2=new JPanel();
        p2.setBackground(Color.WHITE);
        p2.setLayout(gbl);
        
        gbc.gridx=1;
        gbc.gridy=1;
        gbc.gridwidth=1;
        gbc.gridheight=1;
        gbc.insets=new Insets(100,50,25,0);
        l1=new JLabel("User Name");
        l1.setFont(new Font("Trebuchet M3",Font.PLAIN,25));
        l1.setForeground(new Color(0,0,128));
        gbl.setConstraints(l1,gbc);
        p2.add(l1);
        
        gbc.gridy=2;
        gbc.insets=new Insets(25,50,25,0);
        l2=new JLabel("Name :");
        l2.setFont(new Font("Trebuchet M3",Font.PLAIN,25));
        l2.setForeground(new Color(0,0,128));
        gbl.setConstraints(l2,gbc);
        p2.add(l2);
                
        gbc.gridy=3;
        gbc.insets=new Insets(25,50,25,0);
        l3=new JLabel("Security Question :");
        l3.setFont(new Font("Trebuchet M3",Font.PLAIN,25));
        l3.setForeground(new Color(0,0,128));
        gbl.setConstraints(l3,gbc);
        p2.add(l3);
        
        gbc.gridy=4;
        gbc.insets=new Insets(25,50,25,0);
        l4=new JLabel("Answer :");
        l4.setFont(new Font("Trebuchet M3",Font.PLAIN,25));
        l4.setForeground(new Color(0,0,128));
        gbl.setConstraints(l4,gbc);
        p2.add(l4);
        
        gbc.gridy=5;
        gbc.insets=new Insets(25,50,25,0);
        l5=new JLabel("Password :");
        l5.setFont(new Font("Trebuchet M3",Font.PLAIN,25));
        l5.setForeground(new Color(0,0,128));
        gbl.setConstraints(l5,gbc);
        p2.add(l5);
        
        gbc.gridx=2;
        gbc.gridy=1;
        gbc.insets=new Insets(100,0,25,25);
        t1=new JTextField();
        t1.setFont(new Font("Trebuchet M3",Font.PLAIN,25));
        t1.setForeground(new Color(0,0,128));
        t1.setPreferredSize(new Dimension(400,25));
        t1.setBorder(border);
        gbl.setConstraints(t1,gbc);
        p2.add(t1);
        
        gbc.gridy=2;
        gbc.insets=new Insets(25,0,25,25);
        re1=new JLabel();
        re1.setFont(new Font("Trebuchet M3",Font.PLAIN,25));
        re1.setForeground(new Color(215,0,64));
        re1.setBackground(new Color(229, 228, 226));
        re1.setOpaque(true);
        re1.setBorder(border);
        gbl.setConstraints(re1,gbc);
        p2.add(re1);
        
        gbc.gridy=3;
        gbc.insets=new Insets(25,0,25,25);
        re2=new JLabel();
        re2.setFont(new Font("Trebuchet M3",Font.PLAIN,25));
        re2.setForeground(new Color(0,0,128));
        re2.setBackground(new Color(229, 228, 226));
        re2.setOpaque(true);
        re2.setBorder(border);
        gbl.setConstraints(re2,gbc);
        p2.add(re2);
                
        gbc.gridy=4;
        gbc.insets=new Insets(25,0,25,25);
        t2=new JTextField();
        t2.setFont(new Font("Trebuchet M3",Font.PLAIN,25));
        t2.setForeground(new Color(215,0,64));
        t2.setBorder(border);
        t2.getDocument().addDocumentListener(new DocumentListener()
        {
            @Override
            public void changedUpdate(DocumentEvent e) {               
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                re3.setText("");
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                re3.setText("");
            }
        });
        gbl.setConstraints(t2,gbc);
        p2.add(t2);
                        
        gbc.gridy=5;
        gbc.insets=new Insets(25,0,25,25);
        re3=new JLabel();
        re3.setFont(new Font("Trebuchet M3",Font.PLAIN,25));
        re3.setForeground(new Color(76, 187, 23));
        re3.setBackground(new Color(229, 228, 226));
        re3.setOpaque(true);
        re3.setBorder(border);
        gbl.setConstraints(re3,gbc);
        p2.add(re3);
                
        gbc.gridx=3;
        gbc.gridy=1;
        gbc.insets=new Insets(100,0,25,50);
        b1=new JButton("Search");
        b1.setFont(new Font("Trebuchet M3",Font.PLAIN,25));
        b1.setForeground(Color.orange);
        b1.setBackground(new Color(0,0,128));
        b1.addActionListener(this);
        gbl.setConstraints(b1,gbc);
        p2.add(b1);
        
        gbc.gridy=4;
        gbc.insets=new Insets(25,0,25,50);
        b2=new JButton("Retrieve");
        b2.setFont(new Font("Trebuchet M3",Font.PLAIN,25));
        b2.setForeground(Color.orange);
        b2.setBackground(new Color(0,0,128));
        b2.addActionListener(this);
        gbl.setConstraints(b2,gbc);
        p2.add(b2);
        
        gbc.gridx=2;
        gbc.gridy=6;
        gbc.insets=new Insets(50,80,100,90);
        b3=new JButton("Back");
        b3.setFont(new Font("Trebuchet M3",Font.PLAIN,25));
        b3.setForeground(new Color(0,0,128));
        b3.setBackground(Color.orange);
        b3.addActionListener(this);
        gbl.setConstraints(b3,gbc);
        p2.add(b3);

        
        this.add(p1,BorderLayout.WEST);
        this.add(p2,BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource().equals(b1))
        {
            if(t1.getText().equals(""))
            {
                JOptionPane.showMessageDialog(this, "Please Enter UserName To Search","Error",JOptionPane.WARNING_MESSAGE);
                t1.requestFocus();
            }
            else
            {
                try
                {
                    ste=con.createStatement();
                    sql="Select * From UserSetting Where UserName='"+t1.getText().toString()+"'";
                    rs=ste.executeQuery(sql);
                    if(rs.next())
                    {
                        re1.setText(rs.getString(3));
                        re2.setText(rs.getString(5));
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(this, "This Is An Unvalid UserName!","Error",JOptionPane.WARNING_MESSAGE);
                        t1.requestFocus();
                        t1.selectAll();
                    }
                }
                catch(SQLException e)
                {
                    e.printStackTrace();
                }
            }
        }
        else if(ae.getSource().equals(b2))
        {
            if(t1.getText().equals(""))
            {
                JOptionPane.showMessageDialog(this, "Please Enter UserName To Retrieve Security Question","Error",JOptionPane.WARNING_MESSAGE);
                t1.requestFocus();
            }
            else if(t2.getText().equals(""))
            {
                JOptionPane.showMessageDialog(this, "Please Type Answer To The Security Question","Error",JOptionPane.WARNING_MESSAGE);
                t2.requestFocus();
            }
            else
            {
                try
                {
                    ste=con.createStatement();
                    sql="Select * From UserSetting Where Answer='"+t2.getText().toString()+"'";
                    rs=ste.executeQuery(sql);
                    if(rs.next())
                    {
                        re3.setText(rs.getString(4));
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(this, "This Is The Wrong Answer!","Error",JOptionPane.WARNING_MESSAGE);
                        t2.requestFocus();
                        t2.selectAll();
                    }
                }
                catch(SQLException e)
                {
                    e.printStackTrace();
                }
            }
        }
        else if(ae.getSource().equals(b3))
        {
            new LogIn().setVisible(true);
            this.setVisible(false);
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
        
                new ForgotPassword().setVisible(true);
            
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    
}
