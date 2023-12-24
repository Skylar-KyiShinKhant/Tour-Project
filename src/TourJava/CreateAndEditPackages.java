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
import java.text.*;
import java.sql.*;
/**
 *
 * @author skylar
 */
public class CreateAndEditPackages extends javax.swing.JDialog implements ActionListener{
   
    Connection con=null;
    Statement ste=null;
    ResultSet rs=null;
    String sql="";
    int result=0;
    boolean isEdited;
    String editID;
    
    SimpleDateFormat sdf;
    String cd,dd;
    
    ImageIcon logo=new ImageIcon(getClass().getClassLoader().getResource("Images/TravelLogo.png"));
    JLabel l1,l2,l3,l4,l5,l6,l7;
    JTextField t1,t2,t3,t4,t5;
    JButton b1,b2;
    
    public CreateAndEditPackages(java.awt.Frame parent, boolean modal,String id,String d1,String d2,boolean edit) {
        super(parent, modal);
        try
        {
            con=DBConnection.getConnection();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        initComponents();
        super.setTitle("Create And Edit Packages");
        this.setIconImage(logo.getImage());
        this.setSize(450,570);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.getContentPane().setBackground(Color.white);
        
        l1 =new JLabel("Created Date :");
        l1.setFont(new Font("Trebuchet M3",Font.PLAIN,20));
        l1.setForeground(new Color(0,0,128));
        l1.setBounds(40,35,200,30);
        this.add(l1);
        
        l2 =new JLabel("Country :");
        l2.setFont(new Font("Trebuchet M3",Font.PLAIN,20));
        l2.setForeground(new Color(0,0,128));
        l2.setBounds(40,95,200,30);
        this.add(l2);
        
        l3 =new JLabel("Destination :");
        l3.setFont(new Font("Trebuchet M3",Font.PLAIN,20));
        l3.setForeground(new Color(0,0,128));
        l3.setBounds(40,155,200,30);
        this.add(l3);
        
        l4 =new JLabel("Departing Date :");
        l4.setFont(new Font("Trebuchet M3",Font.PLAIN,20));
        l4.setForeground(new Color(0,0,128));
        l4.setBounds(40,215,200,30);
        this.add(l4);
        
        l5 =new JLabel("Trip Length :");
        l5.setFont(new Font("Trebuchet M3",Font.PLAIN,20));
        l5.setForeground(new Color(0,0,128));
        l5.setBounds(40,275,200,30);
        this.add(l5);
        
        l6 =new JLabel("Vacancy :");
        l6.setFont(new Font("Trebuchet M3",Font.PLAIN,20));
        l6.setForeground(new Color(0,0,128));
        l6.setBounds(40,335,200,30);
        this.add(l6);
        
        l7 =new JLabel("Price :");
        l7.setFont(new Font("Trebuchet M3",Font.PLAIN,20));
        l7.setForeground(new Color(0,0,128));
        l7.setBounds(40,395,200,30);
        this.add(l7);
                
        //Border
        Border line=new LineBorder(Color.darkGray);
        Border empty=new EmptyBorder(0,5,0,5);
        CompoundBorder border=new CompoundBorder(line,empty);
        
        t1=new JTextField();
        t1.setFont(new Font("Trebuchet M3",Font.PLAIN,20));
        t1.setForeground(new Color(0,0,128));
        t1.setBounds(200,95,200,30);
        t1.setBorder(border);
        this.add(t1);
        
        t2=new JTextField();
        t2.setFont(new Font("Trebuchet M3",Font.PLAIN,20));
        t2.setForeground(new Color(0,0,128));
        t2.setBounds(200,155,200,30);
        t2.setBorder(border);
        this.add(t2);
        
        t3=new JTextField();
        t3.setFont(new Font("Trebuchet M3",Font.PLAIN,20));
        t3.setForeground(new Color(0,0,128));
        t3.setBounds(200,275,200,30);
        t3.setBorder(border);
        this.add(t3);
        
        t4=new JTextField();
        t4.setFont(new Font("Trebuchet M3",Font.PLAIN,20));
        t4.setForeground(new Color(0,0,128));
        t4.setBounds(200,335,200,30);
        t4.setBorder(border);
        this.add(t4);
        
        t5=new JTextField();
        t5.setFont(new Font("Trebuchet M3",Font.PLAIN,20));
        t5.setForeground(new Color(0,0,128));
        t5.setBounds(200,395,200,30);
        t5.setBorder(border);
        this.add(t5);
        
        ImageIcon icon1=new ImageIcon(ClassLoader.getSystemResource("Images/Save.png"));
        Image i1=icon1.getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT);
        Icon icon2=new ImageIcon(i1);
        b1=new JButton("Save",icon2);
        b1.setFont(new Font("Trebuchet M3",Font.PLAIN,20));
        b1.setBackground(new Color(0,0,128));
        b1.setForeground(Color.orange);
        b1.setBounds(45,460,150,40);
        b1.addActionListener(this);
        this.add(b1);
        
        ImageIcon icon3=new ImageIcon(ClassLoader.getSystemResource("Images/Cancel.png"));
        Image i2=icon3.getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT);
        Icon icon4=new ImageIcon(i2);
        b2=new JButton("Cancel",icon4);
        b2.setFont(new Font("Trebuchet M3",Font.PLAIN,20));
        b2.setBackground(Color.orange);
        b2.setForeground(new Color(0,0,128));
        b2.setBounds(245,460,150,40);
        b2.addActionListener(this);
        this.add(b2);
        
        editID=id;
        isEdited=edit;
        if(isEdited)
        {
            try
            {
                sdf=new SimpleDateFormat("dd/MM/yyyy");
                date1.setDate(sdf.parse(d1));
                date2.setDate(sdf.parse(d2));
            }
            catch(ParseException e)
            {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource().equals(b1))
        {
            try
            {
                sdf=new SimpleDateFormat("dd/MM/yyyy");
                cd=sdf.format(date1.getDate());
                dd=sdf.format(date2.getDate());
                
                //t1
                if(t1.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(this, "Please Enter Country","Error",JOptionPane.WARNING_MESSAGE);
                    t1.requestFocus();
                }
                //t2
                else if(t2.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(this, "Please Enter Destination","Error",JOptionPane.WARNING_MESSAGE);
                    t2.requestFocus();
                }

                //t3
                else if(t3.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(this, "Please Enter Trip Length","Error",JOptionPane.WARNING_MESSAGE);
                    t3.requestFocus();
                }
                else if(Integer.parseInt(t3.getText().toString())<=0 || Integer.parseInt(t3.getText().toString())>15)
                {
                    JOptionPane.showMessageDialog(this, "Trip Length Must Be Between 1 and 15","Error",JOptionPane.WARNING_MESSAGE);
                    t3.requestFocus();
                    t3.selectAll();
                }

                //t4
                else if(t4.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(this, "Please Enter Vacancy","Error",JOptionPane.WARNING_MESSAGE);
                    t4.requestFocus();
                }
                else if(Integer.parseInt(t4.getText().toString())<0 || Integer.parseInt(t4.getText().toString())>200)
                {
                    JOptionPane.showMessageDialog(this, "Vacancy Must Be Between 0 And 200","Error",JOptionPane.WARNING_MESSAGE);
                    t4.requestFocus();
                    t4.selectAll();
                }
                
                //t5
                else if(t5.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(this, "Please Enter Price","Error",JOptionPane.WARNING_MESSAGE);
                    t5.requestFocus();
                }
                else if(Integer.parseInt(t5.getText().toString())<=10 || Integer.parseInt(t5.getText().toString())>=10000)
                {
                    JOptionPane.showMessageDialog(this, "Price Must Be Between 10 And 10,000","Error",JOptionPane.WARNING_MESSAGE);
                    t5.requestFocus();
                    t5.selectAll();
                }


                else
                {
                    try
                    {
                        if(isEdited)
                        {
                            System.out.println(cd);
                            System.out.println(dd);
                            System.out.println(t1.getText().toString());
                            System.out.println(t2.getText().toString());
                            System.out.println(t3.getText().toString());
                            System.out.println(t4.getText().toString());
                            System.out.println(t5.getText().toString());
                            System.out.println(editID);
                            ste=con.createStatement();
                            sql="Update Packages Set CreatedDate='"+cd+"', Country='"+t1.getText().toString()+"', Destination='"+t2.getText().toString()+"', DepartingDate='"+dd+"', TripLength='"+t3.getText().toString()+"', Vacancy='"+t4.getText().toString()+"', Price='"+t5.getText().toString()+"' Where PackageID='"+editID+"'";
                            result=ste.executeUpdate(sql);
                            if(result>0)
                            {
                                JOptionPane.showMessageDialog(this, "The Package Is Successfully Edited","Editing Process Accomplished",JOptionPane.INFORMATION_MESSAGE);
                                dispose();
                            }
                        }
                        else
                        {
                            ste=con.createStatement();
                            sql="Select * From Packages Where Destination='"+t2.getText().toString()+"' And DepartingDate='"+dd+"' And TripLength='"+t3.getText().toString()+"'";
                            rs=ste.executeQuery(sql);
                            if(rs.next())
                            {
                                JOptionPane.showMessageDialog(this, "This Package Is Already Existed","Error",JOptionPane.WARNING_MESSAGE);
                                t1.requestFocus();
                                t1.selectAll();
                            }                            
                            else
                            {
                                sql="Insert Packages(CreatedDate,Country,Destination,DepartingDate,TripLength,Vacancy,Price) Values('"+cd+"','"+t1.getText().toString()+"','"+t2.getText().toString()+"','"+dd+"','"+t3.getText().toString()+"','"+t4.getText().toString()+"','"+t5.getText().toString()+"')";
                                result=ste.executeUpdate(sql);
                                if(result>0)
                                {
                                    JOptionPane.showMessageDialog(this, "The Package Is Successfully Created","Creating Process Accomplished",JOptionPane.INFORMATION_MESSAGE);
                                    dispose();
                                }
                            }
                        }
                    }
                    catch(SQLException e)
                    {
                        e.printStackTrace();
                    }
                }
            }
            catch(NullPointerException e)
            {
                JOptionPane.showMessageDialog(this,"Please Check Dates","Error",JOptionPane.WARNING_MESSAGE);
                date1.requestFocus();
            }
            catch(NumberFormatException e)
            {
                JOptionPane.showMessageDialog(this,"Please Check Trip Length, Vacancy And Price. They Should Be Numbers.","Error",JOptionPane.WARNING_MESSAGE);
                t3.requestFocus();
            }
        }
        else if(ae.getSource().equals(b2))
        {
            dispose();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        date1 = new com.toedter.calendar.JDateChooser();
        date2 = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        date1.setForeground(new java.awt.Color(0, 0, 128));
        date1.setFont(new java.awt.Font("Trebuchet MS", 0, 20)); // NOI18N
        date1.setPreferredSize(new java.awt.Dimension(200, 30));

        date2.setForeground(new java.awt.Color(0, 0, 128));
        date2.setFont(new java.awt.Font("Trebuchet MS", 0, 20)); // NOI18N
        date2.setPreferredSize(new java.awt.Dimension(200, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 199, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(date2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(date1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(date1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(146, 146, 146)
                .addComponent(date2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(229, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CreateAndEditPackages dialog = new CreateAndEditPackages(new javax.swing.JFrame(), true,"","","",false);
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
    private com.toedter.calendar.JDateChooser date1;
    private com.toedter.calendar.JDateChooser date2;
    // End of variables declaration//GEN-END:variables

    
}
