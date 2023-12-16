/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TourJava;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
/**
 *
 * @author steve
 */
public class CreateAndEditPurchases extends javax.swing.JDialog implements ActionListener{

    Connection con=null;
    Statement ste=null;
    ResultSet rs=null;
    String sql,sql1;
    int result=0, result1=0,memory;
    String editID;
    boolean isEdited;
    
    SimpleDateFormat sdf;
    String pd;
    
    ImageIcon logo=new ImageIcon(getClass().getClassLoader().getResource("Images/TravelLogo.png"));
    JLabel l1,l2,l3,l4,l5,l6,l7;
    JTextField t1,t2;
    JButton b1,b2,b3;
    
    JComboBox c1,c2;
    String[] status={"Select Status","Booked","Paid"};
    
    JTable table;
    DefaultTableModel dtm;
    JScrollPane sp;
    
    public CreateAndEditPurchases(java.awt.Frame parent, boolean modal, String id, String d1, String people, boolean edit) {
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
        super.setTitle("Create And Edit Purchases");
        this.setIconImage(logo.getImage());
        this.setSize(700,630);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.getContentPane().setBackground(Color.white);
        
        //Label
        l1 =new JLabel("Customer Name :");
        l1.setFont(new Font("Trebuchet M3",Font.PLAIN,20));
        l1.setForeground(new Color(0,0,128));
        l1.setBounds(150,30,200,30);
        this.add(l1);
        
        l2 =new JLabel("PackageID :");
        l2.setFont(new Font("Trebuchet M3",Font.PLAIN,20));
        l2.setForeground(new Color(0,0,128));
        l2.setBounds(150,90,200,30);
        this.add(l2);
        
        l3 =new JLabel("Purchased Date :");
        l3.setFont(new Font("Trebuchet M3",Font.PLAIN,20));
        l3.setForeground(new Color(0,0,128));
        l3.setBounds(150,150,200,30);
        this.add(l3);
        
        l4 =new JLabel("No. of People :");
        l4.setFont(new Font("Trebuchet M3",Font.PLAIN,20));
        l4.setForeground(new Color(0,0,128));
        l4.setBounds(150,210,200,30);
        this.add(l4);
        
        l5 =new JLabel("Status :");
        l5.setFont(new Font("Trebuchet M3",Font.PLAIN,20));
        l5.setForeground(new Color(0,0,128));
        l5.setBounds(150,270,200,30);
        this.add(l5);
        
        l6 =new JLabel("Amount :");
        l6.setFont(new Font("Trebuchet M3",Font.PLAIN,20));
        l6.setForeground(new Color(0,0,128));
        l6.setBounds(150,330,200,30);
        this.add(l6);
                
        //Border
        Border line=new LineBorder(Color.darkGray);
        Border empty=new EmptyBorder(0,5,0,5);
        CompoundBorder border=new CompoundBorder(line,empty);
        
        //CustomerName TextField
        t1=new JTextField();
        t1.setFont(new Font("Trebuchet M3",Font.PLAIN,20));
        t1.setForeground(new Color(0,0,128));
        t1.setBounds(347,30,200,30);
        t1.setBorder(border);
        this.add(t1);
        
        //PackageID ComboBox
        c1=new JComboBox();
        c1.setFont(new Font("Trebuchet M3",Font.PLAIN,20));
        c1.setForeground(new Color(0,0,128));
        c1.setBounds(347,90,200,30);
        c1.addActionListener(this);
        this.add(c1);
        try
        {
            ste=con.createStatement();
            sql="Select PackageID From Packages";
            rs=ste.executeQuery(sql);
            c1.removeAllItems();
            c1.addItem("Select PackageID");
            while(rs.next())
            {
                c1.addItem(rs.getString(1));
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }               
        
        //No of People TextField
        t2=new JTextField();
        t2.setFont(new Font("Trebuchet M3",Font.PLAIN,20));
        t2.setForeground(new Color(0,0,128));
        t2.setBounds(347,210,200,30);
        t2.setBorder(border);
        t2.getDocument().addDocumentListener(new DocumentListener()
        {
            @Override
            public void insertUpdate(DocumentEvent e) {
                try
                {
                    if(dtm.getRowCount()>0)
                    {
                        int price=Integer.parseInt(dtm.getValueAt(0, 7).toString());
                        int temp=Integer.parseInt(t2.getText().toString())*price;
                        l7.setText(String.valueOf(temp));
                    }
                }
                catch(NumberFormatException nume)
                {
                    t2.selectAll();
                    JOptionPane.showMessageDialog(null, "The Input Should Be Number");
                    t2.requestFocus();
                    
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if(t2.getText().equals(""))
                {
                    l7.setText("0");
                }
                else
                {
                    if(dtm.getRowCount()>0)
                    {
                        int price=Integer.parseInt(dtm.getValueAt(0, 7).toString());
                        int temp=Integer.parseInt(t2.getText().toString())*price;
                        l7.setText(String.valueOf(temp));
                    }
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {}
        });
        this.add(t2);
        
        //Status ComboBox
        c2=new JComboBox(status);
        c2.setFont(new Font("Trebuchet M3",Font.PLAIN,20));
        c2.setForeground(new Color(0,0,128));
        c2.setBounds(347,270,200,30);
        this.add(c2);
        
        //Amount Label
        l7=new JLabel("0");
        l7.setFont(new Font("Trebuchet M3",Font.PLAIN,20));
        l7.setForeground(new Color(0,0,128));
        l7.setBackground(new Color(229, 228, 226));
        l7.setOpaque(true);
        l7.setBounds(347,330,200,30);
        l7.setBorder(border);
        this.add(l7);
        
        //Table
        //Table Column
        table=new JTable();
        table.setBackground(new Color(255,248,220));
        table.setForeground(new Color(0,0,128));
        JTableHeader header=table.getTableHeader();
        header.setBackground(new Color(0,0,128));//176,224,230
        header.setForeground(Color.orange);
        header.setFont(new Font("Trebuchet M3",Font.BOLD,13));
        
        dtm=new DefaultTableModel();
        dtm.addColumn("PackageID");
        dtm.addColumn("CreatedDate");
        dtm.addColumn("Country");
        dtm.addColumn("Destination");
        dtm.addColumn("DepartingDate");
        dtm.addColumn("TripLength");
        dtm.addColumn("Vacancy");
        dtm.addColumn("Price");
        //Table Row
        sql="Select * From Packages Order By Country";
        showData(sql);
        
        sp=new JScrollPane(table);
        sp.setBounds(15,390,665,100);
        this.add(sp);
        
        //Print Button
        ImageIcon icon1=new ImageIcon(ClassLoader.getSystemResource("Images/Print.png"));
        Image i1=icon1.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
        Icon icon2=new ImageIcon(i1);
        b1=new JButton("Print",icon2);
        b1.setFont(new Font("Trebuchet M3",Font.PLAIN,20));
        b1.setBackground(new Color(0,0,128));
        b1.setForeground(Color.orange);
        b1.setBounds(100,530,150,40);
        b1.addActionListener(this);
        this.add(b1);
        
        //Save Button
        ImageIcon icon3=new ImageIcon(ClassLoader.getSystemResource("Images/Save.png"));
        Image i2=icon3.getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT);
        Icon icon4=new ImageIcon(i2);
        b2=new JButton("Save",icon4);
        b2.setFont(new Font("Trebuchet M3",Font.PLAIN,20));
        b2.setBackground(new Color(0,0,128));
        b2.setForeground(Color.orange);
        b2.setBounds(280,530,150,40);
        b2.addActionListener(this);
        this.add(b2);
        
        //Cancel Button
        ImageIcon icon5=new ImageIcon(ClassLoader.getSystemResource("Images/Cancel.png"));
        Image i3=icon5.getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT);
        Icon icon6=new ImageIcon(i3);
        b3=new JButton("Cancel",icon6);
        b3.setFont(new Font("Trebuchet M3",Font.PLAIN,20));
        b3.setBackground(Color.orange);
        b3.setForeground(new Color(0,0,128));
        b3.setBounds(455,530,150,40);
        b3.addActionListener(this);
        this.add(b3);
        
        editID=id;
        isEdited=edit;
        if(isEdited)
        {
            try
            {
                sdf=new SimpleDateFormat("dd/MM/yyyy");
                date1.setDate(sdf.parse(d1));
                
                memory=Integer.parseInt(people);
            }
            catch(ParseException e)
            {
                e.printStackTrace();
            }
        }
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        //PackageID ComboBox Action
        if(ae.getSource().equals(c1))
        {
            if(c1.getSelectedIndex()!=0)
            {
                if(dtm.getRowCount()>0)
                {
                    for(int i=dtm.getRowCount()-1; i>=0;i--)
                    {
                        dtm.removeRow(i);
                    }
                    table.setModel(dtm);
                    sql="Select * From Packages Where PackageID='"+c1.getSelectedItem()+"'";
                    showData(sql);
                }
            }
        }
        //Print Button Action
        else if(ae.getSource().equals(b1))
        {
            try
            {
                sdf=new SimpleDateFormat("dd/MM/yyyy");
                pd=sdf.format(date1.getDate());
            
                if(t1.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(this,"Please Enter Customer Name","Error",JOptionPane.WARNING_MESSAGE);
                    t1.requestFocus();
                }
                else if(c1.getSelectedIndex()==0)
                {
                    JOptionPane.showMessageDialog(this,"Please Choose PackageID","Error",JOptionPane.WARNING_MESSAGE);
                    c1.requestFocus();
                }
                else if(t2.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(this,"Please Enter Number of People","Error",JOptionPane.WARNING_MESSAGE);
                    t2.requestFocus();
                }
                else if(Integer.parseInt(t2.getText().toString())<=0)
                {
                    JOptionPane.showMessageDialog(this,"The Number of People Must Be Greater Than 0","Error",JOptionPane.WARNING_MESSAGE);
                    t2.requestFocus();
                    t2.selectAll();
                }
                else if(c2.getSelectedIndex()==0)
                {
                    JOptionPane.showMessageDialog(this,"Please Choose Status","Error",JOptionPane.WARNING_MESSAGE);
                    c2.requestFocus();
                }
                else
                {
                    Printer print=new Printer(this,true,t1.getText().toString(),c1.getSelectedItem().toString(),pd,t2.getText().toString(),c2.getSelectedItem().toString(),l7.getText().toString());
                    print.setVisible(true);
                }
            }
            catch(NullPointerException e)
            {
                JOptionPane.showMessageDialog(this,"Please Check Purchased Date","Error",JOptionPane.WARNING_MESSAGE);
                date1.requestFocus();
            }
            catch(NumberFormatException e)
            {
                JOptionPane.showMessageDialog(this,"Please Check Number of People. They Should Be Numbers.","Error",JOptionPane.WARNING_MESSAGE);
                t2.requestFocus();
            }
        }
        //Save Button Action
        else if(ae.getSource().equals(b2))
        {
            try
            {
                sdf=new SimpleDateFormat("dd/MM/yyyy");
                pd=sdf.format(date1.getDate());
            
                if(t1.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(this,"Please Enter Customer Name","Error",JOptionPane.WARNING_MESSAGE);
                    t1.requestFocus();
                }
                else if(c1.getSelectedIndex()==0)
                {
                    JOptionPane.showMessageDialog(this,"Please Choose PackageID","Error",JOptionPane.WARNING_MESSAGE);
                    c1.requestFocus();
                }
                else if(t2.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(this,"Please Enter Number of People","Error",JOptionPane.WARNING_MESSAGE);
                    t2.requestFocus();
                }
                else if(Integer.parseInt(t2.getText().toString())<=0)
                {
                    JOptionPane.showMessageDialog(this,"The Number of People Must Be Greater Than 0","Error",JOptionPane.WARNING_MESSAGE);
                    t2.requestFocus();
                    t2.selectAll();
                }
                else if(c2.getSelectedIndex()==0)
                {
                    JOptionPane.showMessageDialog(this,"Please Choose Status","Error",JOptionPane.WARNING_MESSAGE);
                    c2.requestFocus();
                }
                else
                {
                    try
                    {
                        if(isEdited)
                        {
                            ste=con.createStatement();
                            sql="Update Purchases Set CustomerName='"+t1.getText().toString()+"', PackageID='"+c1.getSelectedItem().toString()+"', PurchasedDate='"+pd+"', NoOfPeople='"+t2.getText().toString()+"', Status='"+c2.getSelectedItem().toString()+"', Amount='"+l7.getText().toString()+"' Where PurchasedID='"+editID+"'";
                            result=ste.executeUpdate(sql);
                            sql1="Update Packages Set Vacancy=Vacancy+"+memory+"-"+Integer.parseInt(t2.getText().toString())+" Where PackageID='"+c1.getSelectedItem().toString()+"'";
                            result1=ste.executeUpdate(sql1);
                            if(result>0 && result1>0)
                            {
                                JOptionPane.showMessageDialog(this, "The Purchase Is Successfully Edited","Editing Process Accomplished",JOptionPane.INFORMATION_MESSAGE);
                                dispose();
                            }
                        }
                        else
                        {
                            ste=con.createStatement();
                            sql="Select * From Purchases Where CustomerName='"+t1.getText().toString()+"' And PackageID='"+c1.getSelectedItem().toString()+"'";
                            rs=ste.executeQuery(sql);
                            if(rs.next())
                            {
                                JOptionPane.showMessageDialog(this, "This Purchase Has Been Already Made","Error",JOptionPane.WARNING_MESSAGE);
                                t1.requestFocus();
                                t1.selectAll();
                            }
                            else
                            {
                                sql="Insert Purchases(CustomerName,PackageID,PurchasedDate,NoOfPeople,Status,Amount) Values('"+t1.getText().toString()+"','"+c1.getSelectedItem().toString()+"','"+pd+"','"+t2.getText().toString()+"','"+c2.getSelectedItem().toString()+"','"+l7.getText().toString()+"')";
                                result=ste.executeUpdate(sql);
                                sql1="Update Packages Set Vacancy=Vacancy-"+Integer.parseInt(t2.getText().toString())+" Where PackageID='"+c1.getSelectedItem().toString()+"'";
                                result1=ste.executeUpdate(sql1);
                                if(result>0 && result1>0)
                                {
                                    JOptionPane.showMessageDialog(this, "The Purchase Is Successfully Created","Creating Process Accomplished",JOptionPane.INFORMATION_MESSAGE);
                                    dispose();
                                }
                            }
                        }
                    }
                    catch(Exception e)
                    {
                        e.printStackTrace();
                    }
                }
            }
            catch(NullPointerException e)
            {
                JOptionPane.showMessageDialog(this,"Please Check Purchased Date","Error",JOptionPane.WARNING_MESSAGE);
                date1.requestFocus();
            }
            catch(NumberFormatException e)
            {
                JOptionPane.showMessageDialog(this,"Please Check Number of People. They Should Be Numbers.","Error",JOptionPane.WARNING_MESSAGE);
                t2.requestFocus();
            }
        }
        //Cancel Button Action
        else if(ae.getSource().equals(b3))
        {
            dispose();
        }
    }
    
    //Adding Table Rows
    private void showData(String sql)
    {
        try
        {
            ste=con.createStatement();
            rs=ste.executeQuery(sql);
            while(rs.next())
            {
                Object[] dataRow={rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8)};
                dtm.addRow(dataRow);
            }
            table.setModel(dtm);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        date1 = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        date1.setForeground(new java.awt.Color(0, 0, 128));
        date1.setFont(new java.awt.Font("Trebuchet MS", 0, 20)); // NOI18N
        date1.setPreferredSize(new java.awt.Dimension(200, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(347, Short.MAX_VALUE)
                .addComponent(date1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(153, 153, 153))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(154, 154, 154)
                .addComponent(date1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(616, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CreateAndEditPurchases dialog = new CreateAndEditPurchases(new javax.swing.JFrame(), true,"","","",false);
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
    // End of variables declaration//GEN-END:variables

    
}
