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
/**
 *
 * @author skylar
 */
public class SignUp extends javax.swing.JFrame implements ActionListener{

    /**
     * Creates new form SignUp
     */
    Connection con=null;
    Statement ste=null;
    ResultSet rs=null;
    String sql="";
    int result=0;
    
    
    ImageIcon logo=new ImageIcon(getClass().getClassLoader().getResource("Images/TravelLogo.png"));
    JPanel p1,p2;
    JLabel l1,l2,l3,l4,l5,l6;
    JTextField t1,t2,t3,t4;
    JButton b1,b2;
    String[] Quests={"Select A Question"," What is your favourite Super Hero?", " What is your favourite food?"};
    JComboBox c1;
    
    public SignUp() {
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
        this.setTitle("Sign Up");
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
        p1.setBackground(Color.white);
        p1.setLayout(gbl);                   
                        
        gbc.gridx=1;
        gbc.gridy=1;
        gbc.gridwidth=1;
        gbc.gridheight=1;
        gbc.insets=new Insets(100,50,0,50);
        ImageIcon image1=new ImageIcon(ClassLoader.getSystemResource("Images/TravelLogo.png"));
        Image img1=image1.getImage().getScaledInstance(500, 500, Image.SCALE_DEFAULT);
        ImageIcon image2=new ImageIcon(img1);
        JLabel img2=new JLabel(image2);
        gbl.setConstraints(img2,gbc);
        p1.add(img2);
        
        gbc.gridy=2;
        gbc.insets=new Insets(0,50,100,50);
        l1 = new JLabel(" ::::::: SIGN UP :::::::");
        l1.setFont(new Font("Trebuchet M3",Font.BOLD,50));
        l1.setForeground(new Color(0,0,128));
        gbl.setConstraints(l1,gbc);
        p1.add(l1);
        
        //Panel 2
        p2=new JPanel();
        p2.setBackground(Color.white);
        p2.setLayout(gbl);
        
        gbc.gridy=1;   
        gbc.insets=new Insets(100,50,25,50);
        l2=new JLabel("User Name :");
        l2.setFont(new Font("Trebuchet M3",Font.PLAIN,25));
        l2.setForeground(new Color(0,0,128));
        gbl.setConstraints(l2,gbc);
        p2.add(l2);
        
        gbc.gridy=2;
        gbc.insets=new Insets(25,50,25,50);
        l3=new JLabel("Name :");
        l3.setFont(new Font("Trebuchet M3",Font.PLAIN,25));
        l3.setForeground(new Color(0,0,128));
        gbl.setConstraints(l3,gbc);
        p2.add(l3);
        
        gbc.gridy=3;
        gbc.insets=new Insets(25,50,25,50);
        l4=new JLabel("Password :");
        l4.setFont(new Font("Trebuchet M3",Font.PLAIN,25));
        l4.setForeground(new Color(0,0,128));
        gbl.setConstraints(l4,gbc);
        p2.add(l4);
        
        gbc.gridy=4;
        gbc.insets=new Insets(25,50,25,50);
        l5=new JLabel("Security Question :");
        l5.setFont(new Font("Trebuchet M3",Font.PLAIN,25));
        l5.setForeground(new Color(0,0,128));
        gbl.setConstraints(l5,gbc);
        p2.add(l5);
        
        gbc.gridy=5;
        gbc.insets=new Insets(25,50,25,50);
        l6=new JLabel("Answer :");
        l6.setFont(new Font("Trebuchet M3",Font.PLAIN,25));
        l6.setForeground(new Color(0,0,128));
        gbl.setConstraints(l6,gbc);
        p2.add(l6);
        
        gbc.gridy=6;
        gbc.insets=new Insets(50,100,100,-40);
        b1=new JButton("Create");
        b1.setFont(new Font("Trebuchet M3",Font.PLAIN,25));
        b1.setForeground(Color.orange);
        b1.setBackground(new Color(0,0,128));
        b1.addActionListener(this);
        gbl.setConstraints(b1,gbc);
        p2.add(b1);    
        
        gbc.gridx=2;
        gbc.gridy=1;
        gbc.insets=new Insets(100,0,25,100);
        t1=new JTextField();
        t1.setFont(new Font("Trebuchet M3",Font.PLAIN,25));
        t1.setForeground(new Color(0,0,128));
        t1.setBorder(border);
        gbl.setConstraints(t1,gbc);
        p2.add(t1);
        
        gbc.gridy=2;
        gbc.insets=new Insets(25,0,25,100);
        t2=new JTextField();
        t2.setFont(new Font("Trebuchet M3",Font.PLAIN,25));
        t2.setForeground(new Color(0,0,128));
        t2.setBorder(border);
        gbl.setConstraints(t2,gbc);
        p2.add(t2);
                
        gbc.gridy=3;
        gbc.insets=new Insets(25,0,25,100);
        t3=new JTextField();
        t3.setFont(new Font("Trebuchet M3",Font.PLAIN,25));
        t3.setForeground(new Color(0,0,128));
        t3.setBorder(border);
        gbl.setConstraints(t3,gbc);
        p2.add(t3);
        
        gbc.gridy=4;
        gbc.insets=new Insets(25,0,25,100);
        c1=new JComboBox(Quests);
        c1.setFont(new Font("Trebuchet M3",Font.PLAIN,25));
        c1.setForeground(new Color(0,0,128));
        gbl.setConstraints(c1,gbc);
        p2.add(c1);
        
        gbc.gridy=5;
        gbc.insets=new Insets(25,0,25,100);
        t4=new JTextField();
        t4.setFont(new Font("Trebuchet M3",Font.PLAIN,25));
        t4.setForeground(new Color(0,0,128));
        t4.setBorder(border);
        gbl.setConstraints(t4,gbc);
        p2.add(t4);        
        
        gbc.gridy=6;
        gbc.insets=new Insets(50,100,100,150);
        b2=new JButton("Cancel");
        b2.setFont(new Font("Trebuchet M3",Font.PLAIN,25));
        b2.setForeground(new Color(0,0,128));
        b2.setBackground(Color.orange);
        b2.addActionListener(this);
        gbl.setConstraints(b2,gbc);
        p2.add(b2);
        
        this.add(p1,BorderLayout.WEST);
        this.add(p2,BorderLayout.CENTER);
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
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource().equals(b1))
        {
            if(t1.getText().equals(""))
            {
                JOptionPane.showMessageDialog(this, "Please Enter User Name","Error",JOptionPane.WARNING_MESSAGE);
                t1.requestFocus();
            }
            else if(t2.getText().equals(""))
            {
                JOptionPane.showMessageDialog(this, "Please Enter Name","Error",JOptionPane.WARNING_MESSAGE);
                t2.requestFocus();
            }
            else if(t3.getText().equals(""))
            {
                JOptionPane.showMessageDialog(this, "Please Enter Password","Error",JOptionPane.WARNING_MESSAGE);
                t3.requestFocus();
            }
            else if(c1.getSelectedIndex()==0)
            {
                JOptionPane.showMessageDialog(this, "Please Select A Security Question","Error",JOptionPane.WARNING_MESSAGE);
                c1.requestFocus();
            }
            else if(t4.getText().equals(""))
            {
                JOptionPane.showMessageDialog(this, "Please Enter Answer","Error",JOptionPane.WARNING_MESSAGE);
                t4.requestFocus();
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
                        JOptionPane.showMessageDialog(this, "This User Name Is Already Existed.","Error",JOptionPane.WARNING_MESSAGE);
                        t1.requestFocus();
                        t1.selectAll();
                    }
                    else
                    {
                        sql="Insert UserSetting (UserName, Name, Password, SecurityQuest, Answer) Values ('"+t1.getText().toString()+"','"+t2.getText().toString()+"','"+t3.getText().toString()+"','"+c1.getSelectedItem().toString()+"','"+t4.getText().toString()+"')";
                        result=ste.executeUpdate(sql);
                        if(result>0)
                        {
                            JOptionPane.showMessageDialog(this,"This User Is Successfully Created.","Creating Process Accomplished",JOptionPane.INFORMATION_MESSAGE);
                            this.setVisible(false);
                            new LogIn().setVisible(true);
                        }
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
            new LogIn().setVisible(true);
            this.setVisible(false);
        }
    }
    
    public static void main(String args[]) {
        
                new SignUp().setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    
}
