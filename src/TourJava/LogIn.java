/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TourJava;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.sql.*;
/**
 *
 * @author steve
 */
public class LogIn extends javax.swing.JFrame implements ActionListener{

    /**
     * Creates new form LogIn
     */
    Connection con=null;
    Statement ste=null;
    ResultSet rs=null;
    String sql="";
    
    ImageIcon logo=new ImageIcon(getClass().getClassLoader().getResource("Images/TravelLogo.png"));
    JLabel l1, l2, l3;
    JTextField t1;
    JPasswordField p1;
    JButton b1,b2,b3;
    JCheckBox cb1;
    
    public LogIn() {
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
        this.setTitle("Log In");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setExtendedState(this.MAXIMIZED_BOTH);
        this.setLayout(null);
        this.getContentPane().setBackground(Color.white);
        
        ImageIcon image1=new ImageIcon(ClassLoader.getSystemResource("Images/TravelLogo.png"));
        Image img1=image1.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
        ImageIcon image2=new ImageIcon(img1);
        JLabel img2=new JLabel(image2);
        img2.setBounds(600,10,300,300);
        this.add(img2);
        
        //Border
        Border line=new LineBorder(Color.DARK_GRAY);
        Border empty=new EmptyBorder(0,5,0,5);
        CompoundBorder border=new CompoundBorder(line,empty);
        
        l1=new JLabel("User Name");
        l1.setFont(new Font("Trebuchet M3",Font.PLAIN,20));
        l1.setForeground(new Color(0,0,128));
        l1.setBounds(590,350,350,40);
        this.add(l1);
        
        t1=new JTextField();
        t1.setFont(new Font("Trebuchet M3",Font.PLAIN,20));
        t1.setForeground(new Color(0,0,128));
        t1.setBorder(border);
        t1.setBounds(590,390,350,40);
        this.add(t1);
        
        l2=new JLabel("Password");
        l2.setFont(new Font("Trebuchet M3",Font.PLAIN,20));
        l2.setForeground(new Color(0,0,128));
        l2.setBounds(590,440,350,40);
        this.add(l2);
        
        p1=new JPasswordField();
        p1.setFont(new Font("Trebuchet M3",Font.PLAIN,20));
        p1.setForeground(new Color(0,0,128));
        p1.setEchoChar('#');
        p1.setBorder(border);        
        p1.setBounds(590,480,350,40);
        this.add(p1);
        
        cb1=new JCheckBox("Show Password");
        cb1.setFont(new Font("Trebuchet M3",Font.PLAIN,16));
        cb1.setForeground(new Color(0,0,128));
        cb1.setBackground(Color.white);
        cb1.setBounds(590,520,150,30);
        cb1.addActionListener(this);
        this.add(cb1);
        
        b1=new JButton("Log In");
        b1.setFont(new Font("Trebuchet M3",Font.PLAIN,20));
        b1.setForeground(Color.orange);
        b1.setBackground(new Color(0,0,128));
        b1.setBounds(590,580,150,40);
        b1.addActionListener(this);
        this.add(b1);
        
        b2=new JButton("Sign Up");
        b2.setFont(new Font("Trebuchet M3",Font.PLAIN,20));
        b2.setForeground(new Color(0,0,128));
        b2.setBackground(Color.orange);
        b2.setBounds(790,580,150,40);
        b2.addActionListener(this);
        this.add(b2);
        
        l3=new JLabel("Trouble In Login?");
        l3.setFont(new Font("Trebuchet M3",Font.PLAIN,20));
        l3.setForeground(new Color(215,0,64));
        l3.setBounds(690,650,200,40);
        this.add(l3);
        
        b3=new JButton("Forgot Password");
        b3.setFont(new Font("Trebuchet M3",Font.PLAIN,20));
        b3.setForeground(new Color(0,0,128));
        b3.setBackground(Color.orange);
        b3.setBounds(665,690,200,40);
        b3.addActionListener(this);
        this.add(b3);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource().equals(cb1))
        {
            if(cb1.isSelected())
            {
                p1.setEchoChar('\u0000');
            }
            else
            {
                p1.setEchoChar('#');
            }
        }
        else if(ae.getSource().equals(b1))
        {
            if(t1.getText().equals(""))
            {
                JOptionPane.showMessageDialog(this, "Please Enter User Name","Error",JOptionPane.WARNING_MESSAGE);
                t1.requestFocus();
            }
            else if(p1.getText().equals(""))
            {
                JOptionPane.showMessageDialog(this, "Please Enter Password","Error",JOptionPane.WARNING_MESSAGE);
                p1.requestFocus();
            }
            else
            {
                try
                {
                    ste=con.createStatement();
                    sql="Select * from UserSetting Where UserName='"+t1.getText().toString()+"' and Password='"+p1.getText().toString()+"'";
                    rs=ste.executeQuery(sql);
                    if(rs.next())
                    {
                        new Entries().setVisible(true);
                        this.setVisible(false);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(this, "Invalid UserName And Password","Error",JOptionPane.WARNING_MESSAGE);
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
           new SignUp().setVisible(true);
           this.setVisible(false);  
        }
        else if(ae.getSource().equals(b3))
        {
           new ForgotPassword().setVisible(true);
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
                new LogIn().setVisible(true);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

   
