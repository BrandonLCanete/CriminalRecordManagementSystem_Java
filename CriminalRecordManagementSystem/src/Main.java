import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
public class Main {
    private static JButton button;
    private static JLabel welcome;
    Main(){
      JFrame frame = new JFrame();
      ImageIcon  background = new ImageIcon("C:\\CriminalRecordManagementSystem\\images\\loginbackground.jpg");
      JPanel panel = new JPanel(){
     
      protected void paintComponent(Graphics g)
       {
                 
         g.drawImage(background.getImage(), 0,0,670,315,null);
         super.paintComponent(g);
       }
     };
       
         panel.setOpaque(false);
         
      panel.setLayout(null);
      frame.add(panel);
      frame.setSize(670,350);
      frame.setResizable(false);
      frame.addWindowListener(new java.awt.event.WindowAdapter() {
        public void windowClosing(java.awt.event.WindowEvent windowEvent) {
            if (JOptionPane.showConfirmDialog(frame, 
                "Are you sure you want to close the Main page?", "Exit", 
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
            else{
              frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                }
           }
        });
      panel.setBackground(new Color(0,0,102));
      frame.setLocation(new Point(370, 180));
      ImageIcon image= new ImageIcon("C:\\CriminalRecordManagementSystem\\images\\logo.jpg");
      frame.setIconImage(image.getImage());
      welcome = new JLabel("Welcome to Our Criminal Record Management System!");
      welcome.setBounds(95,125,490,25);
      welcome.setFont(new Font("Arial",Font.BOLD,18));   
      welcome.setForeground(Color.RED);
      panel.add(welcome);
      button = new JButton("Click here to Start");  
      button.setBounds(255,180,150,21);
      button.setForeground(Color.RED);
      button.setBackground(Color.BLACK);
      panel.add(button);
      button.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
             frame.dispose();
             new Login();
        }
       });
      frame.setVisible(true);
     }
    public static void main(String args[])
    {
        new Main();
    }
    
}

