import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Pardon {
    private static JTable table;
    private static JLabel tabletitle;
    private static JButton button1,button2,button3;
    Pardon(){
      JFrame frame = new JFrame("PARDON CRIMINAL PAGE");
      frame.addWindowListener(new java.awt.event.WindowAdapter() {
        public void windowClosing(java.awt.event.WindowEvent windowEvent) {
            if (JOptionPane.showConfirmDialog(frame, 
                "Are you sure you want to close Pardon Criminal Page?", "Exit", 
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
            else{
              frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                }
           }
        });
      ImageIcon  background = new ImageIcon("C:\\CriminalRecordManagementSystem\\images\\background.jpg");
     
      JPanel panel = new JPanel(){
  
      protected void paintComponent(Graphics g)
          {
              
              g.drawImage(background.getImage(), 0,0,600,570,null);
              super.paintComponent(g);
          }
      };
      panel.setOpaque(false);
      panel.setLayout(null);
      ImageIcon image= new ImageIcon("C:\\CriminalRecordManagementSystem\\images\\logo.jpg");
       frame.setIconImage(image.getImage());
       frame.setSize(600,600);
       frame.setLocation(new Point(400, 100));
       frame.setResizable(false);
       frame.add(panel);
       tabletitle = new JLabel("Pardon Criminals");
       tabletitle.setBounds(220,120,190,20);
       tabletitle.setForeground(Color.red);
       tabletitle.setFont(new Font("Arial",Font.BOLD,18));
       panel.add(tabletitle);
       String[][]body={{}};
       String[] Head={ "FullName","Gender","Age","Crime","Nationality","Bail","Jail Time","Status"};
       DefaultTableModel model = new DefaultTableModel(body,Head);
       table = new JTable(model);
       table.setDefaultEditor(Object.class, null);
       table.setPreferredScrollableViewportSize(table.getPreferredSize());
       table.setBounds(100,140,500,300);
       JScrollPane pane = new JScrollPane(table);
       pane.setBounds(50,140,500,300);
       pane.setEnabled(false);
       pane.setViewportView(table);
       panel.add(pane);
       button1 = new JButton("List");
       button1.setBounds(100,450,100,25);
       button1.setForeground(Color.red);
       button1.setBackground(Color.black);
       panel.add(button1);
       button1.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
          String path ="C:\\CriminalRecordManagementSystem\\CriminalData\\PardonCriminal.txt";
          File file = new File(path);
          try {
             BufferedReader reader = new BufferedReader(new FileReader(file));
             DefaultTableModel model =(DefaultTableModel)table.getModel();
            Object[]Lines = reader.lines().toArray();
             for(int i=0;i<Lines.length;i++){
              String Line = Lines[i].toString().trim();
              String[]Row = Line.split(",");
              model.addRow(Row);
           }
           reader.close();
         } catch (IOException e1) {
             Logger.getLogger(Jail.class.getName()).log(Level.SEVERE,null,e1);
         }
      }
       });
       button2 = new JButton("Clear");
       button2.setBounds(250,450,100,25);
       button2.setForeground(Color.red);
       button2.setBackground(Color.black);
       panel.add(button2);
       button2.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
          DefaultTableModel model = (DefaultTableModel) table.getModel();
          if(table.getSelectedRowCount()==1){
             model.removeRow(table.getSelectedRow());
          }else{
             if(table.getRowCount()==0){
               JOptionPane.showMessageDialog(null,"Table is Empty");
             }else{
               JOptionPane.showMessageDialog(null,"Please Select Row For Clear");
             }
          }
       }
       });
       button3 = new JButton("Back");
       button3.setBounds(400,450,100,25);
       button3.setForeground(Color.red);
       button3.setBackground(Color.black);
       panel.add(button3);
       button3.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e){
                  frame.dispose();
                  new Homepage();
         }
       });
      frame.setVisible(true);
    }
    public static void main(String[]args){
         new Pardon();
    }
}

