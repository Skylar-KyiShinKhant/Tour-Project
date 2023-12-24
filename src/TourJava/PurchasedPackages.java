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
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author skylar
 */
public class PurchasedPackages extends javax.swing.JFrame implements ActionListener {

    Connection con=null;
    Statement ste=null;
    ResultSet rs=null;
    String sql="";
    
    ImageIcon logo=new ImageIcon(getClass().getClassLoader().getResource("Images/TravelLogo.png"));
    JPanel p1,p2;
    
    JTable table;
    DefaultTableModel dtm;
    JScrollPane sp;
    
    JLabel l1,l2;
    JComboBox c1,c2;
    JButton b1,b2,b3,b4,b5,b6,b7;
    String[] init={"Select Category"};
    String[] searchBy={"Select Category","CustomerName","PurchasedDate"};
    
    public PurchasedPackages() {
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
        this.setTitle("Purchased Packages");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setExtendedState(this.MAXIMIZED_BOTH);
        this.setLayout(new BorderLayout());
        
        //Layout
        GridBagLayout gbl=new GridBagLayout();
        GridBagConstraints gbc=new GridBagConstraints();
        gbc.weightx=1;
        gbc.weighty=1;
        gbc.fill=GridBagConstraints.BOTH;
        
        //p1
        p1=new JPanel();
        p1.setLayout(gbl);
        p1.setBackground(Color.white);
        this.add(p1,BorderLayout.PAGE_START);
        
        gbc.gridx=1;
        gbc.gridy=1;
        gbc.insets=new Insets(30,100,0,1);
        b1=new JButton("New");
        b1.setFont(new Font("Trebuchet M3",Font.PLAIN,20));
        b1.setBackground(new Color(0,0,128));
        b1.setForeground(Color.orange);
        gbl.setConstraints(b1,gbc);
        b1.addActionListener(this);
        p1.add(b1);
        
        gbc.gridx=2;
        gbc.insets=new Insets(30,0,0,1);
        b2=new JButton("Edit");
        b2.setFont(new Font("Trebuchet M3",Font.PLAIN,20));
        b2.setBackground(new Color(0,0,128));
        b2.setForeground(Color.orange);
        gbl.setConstraints(b2,gbc);
        b2.addActionListener(this);
        p1.add(b2);
        
        gbc.gridx=3;
        //gbc.insets=new Insets(30,5,0,5);
        b3=new JButton("Delete");
        b3.setFont(new Font("Trebuchet M3",Font.PLAIN,20));
        b3.setBackground(new Color(0,0,128));
        b3.setForeground(Color.orange);
        gbl.setConstraints(b3,gbc);
        b3.addActionListener(this);
        p1.add(b3);
        
        gbc.gridx=4;
        gbc.insets=new Insets(30,10,0,0);
        l1=new JLabel("   Search By");
        l1.setFont(new Font("Trebuchet M3",Font.PLAIN,20));
        l1.setBackground(Color.white);
        l1.setForeground(new Color(0,0,128));
        l1.setOpaque(true);
        gbl.setConstraints(l1,gbc);
        p1.add(l1);
        
        gbc.gridx=5;
        gbc.insets=new Insets(30,0,0,0);
        c1=new JComboBox(searchBy);
        c1.setFont(new Font("Trebuchet M3",Font.PLAIN,20));
        c1.setForeground(new Color(0,0,128));
        gbl.setConstraints(c1,gbc);
        c1.addActionListener(this);
        p1.add(c1);
        
        gbc.gridx=6;
        l2=new JLabel("     Search With");
        l2.setFont(new Font("Trebuchet M3",Font.PLAIN,20));
        l2.setBackground(Color.white);
        l2.setForeground(new Color(0,0,128));
        l2.setOpaque(true);
        gbl.setConstraints(l2,gbc);
        p1.add(l2);
        
        gbc.gridx=7;
        gbc.insets=new Insets(30,0,0,10);
        c2=new JComboBox(init);
        c2.setFont(new Font("Trebuchet M3",Font.PLAIN,20));
        c2.setForeground(new Color(0,0,128));
        gbl.setConstraints(c2,gbc);
        p1.add(c2);
        
        gbc.gridx=8;
        gbc.ipadx=0;
        gbc.insets=new Insets(30,10,0,5);
        b4=new JButton("Search");
        b4.setFont(new Font("Trebuchet M3",Font.PLAIN,20));
        b4.setBackground(new Color(0,0,128));
        b4.setForeground(Color.orange);
        gbl.setConstraints(b4,gbc);
        b4.addActionListener(this);
        p1.add(b4);
        
        gbc.gridx=9;
        gbc.insets=new Insets(30,5,0,100);
        b5=new JButton("Show All");
        b5.setFont(new Font("Trebuchet M3",Font.PLAIN,20));
        b5.setBackground(new Color(0,0,128));
        b5.setForeground(Color.orange);
        gbl.setConstraints(b5,gbc);
        b5.addActionListener(this);
        p1.add(b5);
        
        //p2
        p2=new JPanel();
        p2.setBackground(Color.white);
        p2.setLayout(null);
        this.add(p2,BorderLayout.CENTER);
        
        table=new JTable();
        JTableHeader header=table.getTableHeader();
        header.setBackground(new Color(0,0,128));
        header.setForeground(Color.orange);
        header.setFont(new Font("Trebuchet M3",Font.PLAIN,25));
        table.setBackground(new Color(255,248,220));
        table.setForeground(new Color(0,0,128));
        table.setFont(new Font("Trebuchet M3",Font.PLAIN,20));
        table.setRowHeight(30);
        
        dtm=new DefaultTableModel();
        dtm.addColumn("PurchasedID");
        dtm.addColumn("CustomerName");
        dtm.addColumn("PackageID");
        dtm.addColumn("PurchasedDate");
        dtm.addColumn("NoOfPeople");
        dtm.addColumn("Status");
        dtm.addColumn("Amount");
        sql="Select * From Purchases";
        showData(sql);
        
        sp=new JScrollPane(table);
        sp.setBounds(100,40,1335,600);
        p2.add(sp);
        
        ImageIcon icon1=new ImageIcon(ClassLoader.getSystemResource("Images/Print.png"));
        Image i1=icon1.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
        Icon icon2=new ImageIcon(i1);
        b6=new JButton("Print",icon2);
        b6.setFont(new Font("Trebuchet M3",Font.PLAIN,20));
        b6.setBackground(new Color(0,0,128));
        b6.setForeground(Color.orange);
        b6.setBounds(1100,660,150,40);
        b6.addActionListener(this);
        p2.add(b6);
        
        ImageIcon icon3=new ImageIcon(ClassLoader.getSystemResource("Images/Back.png"));
        Image i2=icon3.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
        Icon icon4=new ImageIcon(i2);
        b7=new JButton("Back",icon4);
        b7.setFont(new Font("Trebuchet M3",Font.PLAIN,20));
        b7.setBackground(Color.orange);
        b7.setForeground(new Color(0,0,128));
        b7.setBounds(1285,660,150,40);
        b7.addActionListener(this);
        p2.add(b7);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        //b1
        if(ae.getSource().equals(b1))
        {
            new CreateAndEditPurchases(this,true,"","","",false).setVisible(true);
            if(dtm.getRowCount()>0)
            {
                for(int i=dtm.getRowCount()-1; i>=0; i--)
                {
                    dtm.removeRow(i);
                }
                sql="Select * From Purchases";
                showData(sql);
            }
        }
        
        //b2
        else if(ae.getSource().equals(b2))
        {
            if(table.getSelectedRow()>=0)
            {
                int curRow=table.getSelectedRow();
                String val=dtm.getValueAt(curRow,0).toString();
                String val1=dtm.getValueAt(curRow,1).toString();
                String val2=dtm.getValueAt(curRow,2).toString();
                String val3=dtm.getValueAt(curRow,3).toString();
                String val4=dtm.getValueAt(curRow,4).toString();
                String val5=dtm.getValueAt(curRow,5).toString();
                String val6=dtm.getValueAt(curRow,6).toString();  
                 
                CreateAndEditPurchases edit=new CreateAndEditPurchases(this,true,val,val3,val4,true);
                edit.t1.setText(val1);
                edit.c1.setSelectedItem(val2);
                edit.t2.setText(val4);
                edit.c2.setSelectedItem(val5);
                edit.l7.setText(val6);             
                edit.setVisible(true);
                
                if(dtm.getRowCount()>0)
                {
                    for(int i=dtm.getRowCount()-1; i>=0; i--)
                    {
                        dtm.removeRow(i);
                    }
                    sql="Select * From Purchases";
                    showData(sql);
                }
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Please Select 1 Row Inside The Table To Edit","Error",JOptionPane.WARNING_MESSAGE);
                table.requestFocus();
            }
            
        }
        
        //b3
        else if(ae.getSource().equals(b3))
        {
            if(table.getSelectedRow()>=0)
            {
                if(JOptionPane.showConfirmDialog(this, "Are You Sure You Want To Delete?","Confirm",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
                {
                    int curRow=table.getSelectedRow();
                    String val=dtm.getValueAt(curRow,0).toString();

                    try
                    {
                        ste=con.createStatement();
                        sql="Delete From Purchases Where PurchasedID='"+val+"'";
                        int result=ste.executeUpdate(sql);
                        if(result>0)
                        {
                            JOptionPane.showMessageDialog(this, "The Purchase Is Successfully Deleted","Deleting Process Accomplished",JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                    catch(SQLException e)
                    {
                        e.printStackTrace();
                    }

                    if(dtm.getRowCount()>0)
                    {
                        for(int i=dtm.getRowCount()-1; i>=0; i--)
                        {
                            dtm.removeRow(i);
                        }
                        sql="Select * From Purchases";
                        showData(sql);
                    }
                }
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Please Select 1 Row Inside The Table To Delete","Error",JOptionPane.WARNING_MESSAGE);
                table.requestFocus();
            }
        }
        
        //c1
        else if(ae.getSource().equals(c1))
        {
            if(c1.getSelectedIndex()!=0)
            {
                try
                {
                    ste=con.createStatement();
                    sql="Select "+c1.getSelectedItem().toString()+" From Purchases Order By "+c1.getSelectedItem().toString();
                    rs=ste.executeQuery(sql);
                    c2.removeAllItems();
                    c2.addItem("Select Category");
                    while(rs.next())
                    {
                        c2.addItem(rs.getString(1));
                    }
                }
                catch(SQLException e)
                {
                    e.printStackTrace();
                }
            }
        }
        
        //b4
        else if(ae.getSource().equals(b4))
        {
            if(c1.getSelectedIndex()==0)
            {
                JOptionPane.showMessageDialog(this, "Please Choose Search By To Search","Error",JOptionPane.WARNING_MESSAGE);
                c1.requestFocus();
            }
            else if(c2.getSelectedIndex()==0)
            {
                JOptionPane.showMessageDialog(this, "Please Choose Search With To Search","Error",JOptionPane.WARNING_MESSAGE);
                c2.requestFocus();
            }
            else
            {
                if(dtm.getRowCount()>0)
                {
                    for(int i=dtm.getRowCount()-1; i>=0; i--)
                    {
                        dtm.removeRow(i);
                    }
                    sql="Select * From Purchases Where "+c1.getSelectedItem().toString()+"='"+c2.getSelectedItem().toString()+"'";
                    showData(sql);
                }                
            }
        }
        
        //b5
        else if(ae.getSource().equals(b5))
        {
            if(dtm.getRowCount()>0)
            {
                for(int i=dtm.getRowCount()-1; i>=0; i--)
                {
                    dtm.removeRow(i);
                }
                sql="Select * From Purchases";
                showData(sql);
            }
        }
        
        //b6
        else if(ae.getSource().equals(b6))
        {
            try
            {
                table.print();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        
        //b7
        else if(ae.getSource().equals(b7))
        {
            new Entries().setVisible(true);
            this.setVisible(false);
        }
    }
    
    public void showData(String sql)
    {
        try
        {
            ste=con.createStatement();
            rs=ste.executeQuery(sql);
            while(rs.next())
            {
                Object[] dataRow={rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)};
                dtm.addRow(dataRow);
            }
            table.setModel(dtm);
        }
        catch(SQLException e)
        {
            e.printStackTrace();
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
        
                new PurchasedPackages().setVisible(true);
            
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    
}
