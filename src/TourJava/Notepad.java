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
import java.io.*;
import javax.swing.filechooser.FileNameExtensionFilter;
/**
 *
 * @author skylar
 */


public class Notepad extends javax.swing.JFrame implements ActionListener{
        
    ImageIcon logo=new ImageIcon(getClass().getClassLoader().getResource("Images/Notepad.png"));
    JMenuBar mb;
    JMenu file,edit,help;
    JMenuItem New,open,save,print,exit,copy,cut,paste,selectAll,about; 
    JTextArea ta;
    JScrollPane sp;
    String memory;
    
    public Notepad() {
        initComponents();
        this.setIconImage(logo.getImage());
        this.setTitle("NotePad");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setSize(400,550);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
                       
        ta=new JTextArea();        
        ta.setFont(new Font("Trebuchet M3",Font.PLAIN,20));
        ta.setBackground(Color.white);
        ta.setForeground(new Color(0,0,128));
        ta.setBorder(new EmptyBorder(10,10,10,10));
        sp=new JScrollPane(ta);
        this.add(sp,BorderLayout.CENTER);
                        
        mb=new JMenuBar();
        mb.setBorder(null);
        this.add(mb,BorderLayout.NORTH);

        file=new JMenu("File");
        file.setBorder(null);
        file.setFont(new Font("Trebuchet M3",Font.PLAIN,20));
        mb.add(file);
        
        edit=new JMenu("Edit");
        edit.setBorder(null);
        edit.setFont(new Font("Trebuchet M3",Font.PLAIN,20));
        mb.add(edit);
        
        help=new JMenu("Help");
        help.setBorder(null);
        help.setFont(new Font("Trebuchet M3",Font.PLAIN,20));
        mb.add(help);
        
        New=new JMenuItem("New");
        New.setBorder(null);
        New.setFont(new Font("Trebuchet M3",Font.PLAIN,20));
        New.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK));
        New.addActionListener(this);
        file.add(New);
        
        open=new JMenuItem("Open");
        open.setBorder(null);
        open.setFont(new Font("Trebuchet M3",Font.PLAIN,20));
        open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_0,ActionEvent.CTRL_MASK));
        open.addActionListener(this);
        file.add(open);
        
        save=new JMenuItem("Save");
        save.setBorder(null);
        save.setFont(new Font("Trebuchet M3",Font.PLAIN,20));
        save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,ActionEvent.CTRL_MASK));
        save.addActionListener(this);
        file.add(save);
        
        print=new JMenuItem("Print");
        print.setBorder(null);
        print.setFont(new Font("Trebuchet M3",Font.PLAIN,20));
        print.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,ActionEvent.CTRL_MASK));
        print.addActionListener(this);
        file.add(print);
        
        file.add(new JSeparator());
        
        exit=new JMenuItem("Exit");
        exit.setBorder(null);
        exit.setFont(new Font("Trebuchet M3",Font.PLAIN,20));
        exit.setForeground(new Color(0,0,128));
        exit.setBackground(Color.orange);
        exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE,0));
        exit.addActionListener(this);
        file.add(exit);
        
        copy=new JMenuItem("Copy");
        copy.setBorder(null);
        copy.setFont(new Font("Trebuchet M3",Font.PLAIN,20));
        copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK));
        copy.addActionListener(this);
        edit.add(copy);
        
        cut=new JMenuItem("Cut");
        cut.setBorder(null);
        cut.setFont(new Font("Trebuchet M3",Font.PLAIN,20));
        cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,ActionEvent.CTRL_MASK));
        cut.addActionListener(this);
        edit.add(cut);
        
        paste=new JMenuItem("Paste");
        paste.setBorder(null);
        paste.setFont(new Font("Trebuchet M3",Font.PLAIN,20));
        paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,ActionEvent.CTRL_MASK));
        paste.addActionListener(this);
        edit.add(paste);
        
        selectAll=new JMenuItem("Select All");
        selectAll.setBorder(null);
        selectAll.setFont(new Font("Trebuchet M3",Font.PLAIN,20));
        selectAll.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,ActionEvent.CTRL_MASK));
        selectAll.addActionListener(this);
        edit.add(selectAll);
        
        about=new JMenuItem("About");
        about.setBorder(null);
        about.setFont(new Font("Trebuchet M3",Font.PLAIN,20));
        about.setForeground(new Color(0,0,128));
        about.setBackground(Color.orange);
        about.addActionListener(this);
        help.add(about);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getActionCommand().equals("New"))
        {
            ta.setText("");
        }
        else if(ae.getActionCommand().equals("Open"))
        {
            JFileChooser chooser=new JFileChooser();
            chooser.setAcceptAllFileFilterUsed(false);
            FileNameExtensionFilter restrict=new FileNameExtensionFilter("Only .txt files",".txt");
            chooser.addChoosableFileFilter(restrict);
            
            int action=chooser.showOpenDialog(this);
            if(action != JFileChooser.APPROVE_OPTION)
            {
                return;
            }
            
            File file=chooser.getSelectedFile();
            try
            {
                BufferedReader br=new BufferedReader(new FileReader(file));
                ta.read(br,null);
            }
            catch(Exception e){}
        }
        else if(ae.getActionCommand().equals("Save"))
        {
            JFileChooser saveAs=new JFileChooser();
            
            int action=saveAs.showSaveDialog(this);
            if(action != JFileChooser.APPROVE_OPTION)
            {
                return;
            }
            
            File filename= new File(saveAs.getSelectedFile()+".txt");
            try
            {
                BufferedWriter br=new BufferedWriter(new FileWriter(filename));
                ta.write(br);
            }
            catch(Exception e){}
        }
        else if(ae.getActionCommand().equals("Print"))
        {
            try
            {
                ta.print();
            }
            catch(Exception e){}
        }
        else if(ae.getActionCommand().equals("Exit"))
        {
            dispose();
        }
        else if(ae.getActionCommand().equals("Copy"))
        {
            memory=ta.getSelectedText();
        }
        else if(ae.getActionCommand().equals("Cut"))
        {
            memory=ta.getSelectedText();
            ta.replaceRange("", ta.getSelectionStart(), ta.getSelectionEnd());
        }
        else if(ae.getActionCommand().equals("Paste"))
        {
            ta.insert(memory, ta.getCaretPosition());
        }
        else if(ae.getActionCommand().equals("Select All"))
        {
            ta.selectAll();
        }
        else if(ae.getSource().equals(about))
        {
            new NotepadAbout(this,true).show();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(400, 800));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 433, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 531, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    
}
