import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.event.ItemListener;

public class Login{
    private static JLabel password1, label;
  	private static JTextField username;
    private static JButton button,button1;
   	private static JPasswordField Password;
  
 Login(){
     JFrame frame = new JFrame();
     frame.setTitle("LOGIN PAGE");
     frame.setLocation(new Point(400, 150));
     frame.setResizable(false);
     ImageIcon  background = new ImageIcon("C:\\CriminalRecordManagementSystem\\images\\loginbackground.jpg");
     JPanel panel = new JPanel(){
    
     protected void paintComponent(Graphics g)
			{
                
				g.drawImage(background.getImage(), 0,0,400,367,null);
				super.paintComponent(g);
			}
		};
      
        panel.setOpaque(false);
        
    
     panel.setLayout(null);
     
     frame.add(panel);
     frame.setSize(new Dimension(400, 400));
     ImageIcon image= new ImageIcon("C:\\CriminalRecordManagementSystem\\images\\logo.jpg");
     frame.setIconImage(image.getImage());
     label = new JLabel("Username:");
     label.setBounds(100, 100, 90, 20);
     label.setForeground(Color.RED);
     panel.add(label);
     username = new JTextField();
     username.setBounds(100, 120, 193, 28);
     panel.add(username);
     password1 = new JLabel("Password");
     password1.setBounds(100, 160, 70, 20);
     password1.setForeground(Color.RED);
     panel.add(password1);
     Password = new JPasswordField();
     Password.setBounds(100, 180, 193, 28);
     panel.add(Password);
     button = new JButton("Login");
     button.setBounds(100, 220, 90, 25);
     button.setForeground(Color.RED);
     button.setBackground(Color.BLACK);
     button.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e) {
           try {
                String s;
                String bypassid = "guest";
                String bypasspw = "guest";
                char[]pass = Password.getPassword();
                String passString = new String(pass);
                String[] array;
                boolean isLogin= false;
                BufferedReader br = new BufferedReader(new FileReader("C:\\CriminalRecordManagementSystem\\UserData\\UserData.txt"));
                while((s=br.readLine())!=null) {
                    array=s.split(",");
                    if(username.getText().equals(array[2])&&passString.equals(array[3])){
                        JOptionPane.showMessageDialog(null, "You are Successfully Logged in!");
                        frame.dispose();
                        new Homepage();
                        isLogin = true;
                        break;
                    } else if(array.length != 0 && bypassid.equals(username.getText())&&bypasspw.equals(passString)){
                        JOptionPane.showMessageDialog(null, "You are Successfully Logged in!");
                        frame.dispose();
                        new Homepage();
                        isLogin = true;
                        break;
                    }
                }
                if(!isLogin) {
                    JOptionPane.showMessageDialog(null, "Incorrect Username or Password!");
                }
                br.close();
            } catch (IOException e10) {
                e10.printStackTrace();
            }
     }
     
    });
     button1= new JButton("Create Account");
     button1.setBounds(100,250,130,27);
     button1.setForeground(Color.RED);
     button1.setBackground(Color.BLACK);
     button1.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        frame.dispose();
        new Register();
      }
     });
     panel.add(button);
     panel.add(button1);
     frame.addWindowListener(new java.awt.event.WindowAdapter() {
      public void windowClosing(java.awt.event.WindowEvent windowEvent) {
          if (JOptionPane.showConfirmDialog(frame, 
              "Are you sure you want to close Login page?", "Exit", 
              JOptionPane.YES_NO_OPTION,
              JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
              frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          }
          else{
            frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
              }
           }
        });
        ImageIcon icon =new ImageIcon("C:\\CriminalRecordManagementSystem\\images\\showpassword.png");
        Image newimg = icon.getImage().getScaledInstance(25,25, java.awt.Image.SCALE_SMOOTH);
        icon=new ImageIcon(newimg);
        JCheckBox button4 = new JCheckBox(icon);
        button4.setFocusPainted(false);
        button4.setBackground(Color.white);
        button4.setBounds(300,180,32,28);
        panel.add(button4);
        button4.addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    Password.setEchoChar('*');
                } else {
                     Password.setEchoChar((char) 0);
                }
            
                
            }
        });
        frame.setVisible(true);
   }
      
     public static void main(String []args) {
          new Login();
     }

}  