import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class Homepage {
     private static JLabel welcome,criminalRecords,addCriminal,logout,jail,pardon;
     private static JButton button1,button2,button3,button4,button5;
     Homepage(){
        JFrame frame = new JFrame("HOMEPAGE");
        frame.setLocation(new Point(400, 130));
        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                if (JOptionPane.showConfirmDialog(frame, 
                    "Are you sure you want to close Home page?", "Exit", 
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
                
				g.drawImage(background.getImage(), 0,0,650,605,null);
				super.paintComponent(g);
			}
		};
         
        panel.setOpaque(false);
        panel.setLayout(null);
        ImageIcon image= new ImageIcon("C:\\CriminalRecordManagementSystem\\images\\logo.jpg");
        frame.setIconImage(image.getImage());
        frame.setSize(650,630);
        frame.setResizable(false);
        frame.add(panel);
        panel.setBackground(new Color(0,0,102));
        welcome = new JLabel("Welcome Officers!");
        welcome.setBounds(237,120,190,20);
        welcome.setFont(new Font("Arial",Font.BOLD,18));
        welcome.setForeground(Color.RED);
        panel.add(welcome);
        ImageIcon icons =new ImageIcon("C:\\CriminalRecordManagementSystem\\images\\Criminals.png");
        Image newimgs = icons.getImage().getScaledInstance(150,150, java.awt.Image.SCALE_SMOOTH);
        icons=new ImageIcon(newimgs);
        button1= new JButton(icons);
        button1.setFocusPainted(false);
        button1.setBackground(Color.orange);
        button1.setBounds(50,150,150,145);
        panel.add(button1);
        button1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                    frame.dispose();
                    new addCriminal();
            }
        });
        addCriminal= new JLabel("Add Criminal");
        addCriminal.setFont(new Font("Arial",Font.BOLD,12));
        addCriminal.setBounds(87,300,120,21);
        addCriminal.setForeground(Color.RED);
        panel.add(addCriminal);
        ImageIcon icon =new ImageIcon("C:\\CriminalRecordManagementSystem\\images\\Criminal Record.png");
        Image newimg = icon.getImage().getScaledInstance(150,150, java.awt.Image.SCALE_SMOOTH);
        icon=new ImageIcon(newimg);
        button2= new JButton(icon);
        button2.setFocusPainted(false);
        button2.setBackground(Color.cyan);
        button2.setBounds(245,150,150,145);
        panel.add(button2);
        button2.addActionListener(new ActionListener(){
             public void actionPerformed(ActionEvent e){
                 if(e.getSource()==button2){
                    new CriminalRecord();
                    frame.dispose();
                 }
             }
        });
        criminalRecords = new JLabel("Criminal Records");
        criminalRecords.setFont(new Font("Arial",Font.BOLD,12));
        criminalRecords.setBounds(270,300,120,21);
        criminalRecords.setForeground(Color.red);
        panel.add(criminalRecords);
        jail = new JLabel("Jail Criminals");
        jail.setBounds(475,300,100,21);
        jail.setForeground(Color.red);
        panel.add(jail);
        ImageIcon iconss =new ImageIcon("C:\\CriminalRecordManagementSystem\\images\\JailCriminal.png");
        Image newimgss = iconss.getImage().getScaledInstance(150,150, java.awt.Image.SCALE_SMOOTH);
        iconss=new ImageIcon(newimgss);
        button3 = new JButton(iconss);
        button3.setBounds(445,150,150,145);
        button3.setFocusPainted(false);
        button3.setBackground(Color.yellow);
        panel.add(button3);
        button3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                 frame.dispose();
                 new Jail();
            }
        });
        pardon = new JLabel("Pardon Criminals");
        pardon.setBounds(150,500,100,21);
        pardon.setForeground(Color.red);
        panel.add(pardon);
        ImageIcon iconsss =new ImageIcon("C:\\CriminalRecordManagementSystem\\images\\pardon.png");
        Image newimgsss = iconsss.getImage().getScaledInstance(150,150, java.awt.Image.SCALE_SMOOTH);
        iconsss=new ImageIcon(newimgsss);
        button4= new JButton(iconsss);
        button4.setFocusPainted(false);
        button4.setBackground(Color.white);
        button4.setBounds(125,350,150,145);
        panel.add(button4);
        button4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                  frame.dispose();
                  new Pardon();
            }
        });
        logout = new JLabel("Log out");
        logout.setFont(new Font("Arial",Font.BOLD,12));
        logout.setBounds(400,500,100,21);
        logout.setForeground(Color.red);
        panel.add(logout);
        ImageIcon iconssss =new ImageIcon("C:\\CriminalRecordManagementSystem\\images\\logout.png");
        Image newimgssss = iconssss.getImage().getScaledInstance(150,150, java.awt.Image.SCALE_SMOOTH);
        iconssss=new ImageIcon(newimgssss);
        button5= new JButton(iconssss);
        button5.setFocusPainted(false);
        button5.setBackground(Color.green);
        button5.setBounds(350,350,150,145);
        panel.add(button5);
        button5.addActionListener(new ActionListener(){
            public void actionPerformed (ActionEvent e){
                if (JOptionPane.showConfirmDialog(button5, 
                "Are you sure you want to Log out?", "Logout", 
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
                frame.dispose();
                new Login();
             }
            else{
              frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                }
            }
        });
        frame.setVisible(true);
     }
    
    public static void main(String[]args)
    {
        new Homepage();
    }
}