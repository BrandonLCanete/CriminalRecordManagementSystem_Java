import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.WindowAdapter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.event.ItemListener;
public class Register {
    private static JLabel name1,username1,rank,gender,createPassword,stateName;
    private static JTextField name,username,state;
    private static JPasswordField password;
    private static JButton button1,button2,button3;
    private static JRadioButton genderMale,genderFemale;
    private static ButtonGroup group;
    private static JComboBox<String> rankLists;
    public void setData()throws IOException{
        File f = new File("C:\\CriminalRecordManagementSystem\\UserData\\UserData.txt");
        if(!f.exists()){
           f.createNewFile();
        }
        BufferedReader br = new BufferedReader(new FileReader(f));
        Object[]Lines = br.lines().toArray();
        int i=0;
        int id=0;
        br.close();
        for( i=0;i<Lines.length;i++){
            String Line = Lines[i].toString().trim();
            String[] Row = Line.split(",");
            id=Integer.parseInt(Row[0]);
        }
        char[]pass=password.getPassword();
        String passString =  new String(pass);
        int number = id +1;
        FileWriter fw = new FileWriter(f,true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter pw = new PrintWriter(bw);
        pw.println(number+","+name.getText()+","+username.getText()+","+passString+","+group.getSelection().getActionCommand().toString()+","+rankLists.getSelectedItem().toString()+","+state.getText());
        pw.flush();
        pw.close();
        bw.close();
    }
   
    Register(){
       JFrame frame = new JFrame("CREATE ACCOUNT PAGE");
       ImageIcon background = new ImageIcon("C:\\CriminalRecordManagementSystem\\images\\background.jpg");
     
       JPanel panel = new JPanel(){
   
       protected void paintComponent(Graphics g)
           {
               
               g.drawImage(background.getImage(), 0,0,500,470,null);
               super.paintComponent(g);
           }
       };
       panel.setOpaque(false);
       ImageIcon image= new ImageIcon("C:\\CriminalRecordManagementSystem\\images\\logo.jpg");
       frame.setIconImage(image.getImage());
       panel.setLayout(null);
       frame.setLocation(new Point(400, 150));
       frame.add(panel);
       frame.setSize(500,500);
       frame.setResizable(false);
       frame.addWindowListener(new WindowAdapter() {
        public void windowClosing(java.awt.event.WindowEvent windowEvent) {
            if (JOptionPane.showConfirmDialog(frame, 
                "Are you sure you want to close Register page?", "Exit", 
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
            else{
                frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            }
        }
    });
    name1 = new JLabel("Name:");
    name1.setBounds(90, 100, 70, 20);
    name1.setForeground(Color.RED);
    panel.add(name1);
    name = new JTextField();
    name.setBounds(180,100,130,21);
    panel.add(name);
    username1= new JLabel("Username:");
    username1.setBounds(90,140,70,20);
    username1.setForeground(Color.RED);
    panel.add(username1);
    username = new JTextField();
    username.setBounds(180,140,130,21);
    panel.add(username);
    createPassword = new JLabel("Create Password:");
    createPassword.setBounds(90,180,110,20);
    createPassword.setForeground(Color.RED);
    panel.add(createPassword);
    password = new JPasswordField();
    password.setBounds(220,180,130,21);
    panel.add(password);
    gender = new JLabel("Gender:");
    gender.setBounds(90,220,70,20);
    gender.setForeground(Color.RED);
    panel.add(gender);
    genderMale = new JRadioButton("Male");
    genderMale.setActionCommand("Male");
    genderMale.setBounds(180,220,70,21);
    panel.add(genderMale);
    genderFemale=new JRadioButton("Female");
    genderFemale.setActionCommand("Female");
    genderFemale.setBounds(280,220,70,21);
    panel.add(genderFemale);
    genderMale.setSelected(true);
    group=new ButtonGroup();
    group.add(genderMale);
    group.add(genderFemale);
    genderMale.setSelected(true);
    genderFemale.setSelected(true);
    rank = new JLabel("Rank:");
    rank.setBounds(90,260,70,20);
    rank.setForeground(Color.RED);
    panel.add(rank);
    rankLists = new JComboBox<String>();
    rankLists.addItem("Patrolman / Patrolwoman (Pat.)");
    rankLists.addItem("Police Corporal (PCpl.)");
    rankLists.addItem("Police Staff Sergeant (PSSgt.)");
    rankLists.addItem("Police Master Sergeant (PMSgt.)");
    rankLists.addItem("Police Senior Master Sergeant (PSMS))");
    rankLists.addItem("Police Chief Master Sergeant (PCMS)");
    rankLists.addItem("Police Executive Master Sergeant (PEMS)");
    rankLists.addItem("Police Lieutenant (P/LT)");
    rankLists.addItem("Police Captain (P/CAPT)");
    rankLists.addItem("Police Major (P/MAJ)");
    rankLists.addItem("Police Lieutenant Colonel (PLTCOL)");
    rankLists.addItem("Police Colonel (P/COL)");
    rankLists.addItem("Police Brigadier General (PBGEN)");
    rankLists.addItem("Police Major General (PMGEN)");
    rankLists.addItem("Police Lieutenant General (PLTGEN)");
    rankLists.addItem("Police General (P/GEN)");
    rankLists.setBounds(180,260,280,24);
    panel.add(rankLists);
    stateName= new JLabel("State or City:");
    stateName.setBounds(90,300,100,20);
    stateName.setForeground(Color.RED);
    panel.add(stateName);
    state = new JTextField();
    state.setBounds(220,300,130,21);
    panel.add(state);
    button1 = new JButton("Create");
    button1.setBounds(70,340,100,30);
    button1.setForeground(Color.RED);
    button1.setBackground(Color.BLACK);
    panel.add(button1);
    button1.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e) {
            char[]pass=password.getPassword();
            String passString =  new String(pass);
            try{
             if(!"".equals(name.getText())&&!"".equals(username.getText())&&!"".equals(passString)&&!"".equals(group.getSelection().getActionCommand().toString())&&!"".equals(rankLists.getSelectedItem().toString())&&!"".equals(state.getText())){
             setData();
             JOptionPane.showMessageDialog(null,"User Registration Successfully!");
             name.setText(null);
             username.setText(null);
             password.setText(null);
             group.clearSelection();
             rankLists.setSelectedIndex(0);
             state.setText(null);
            }
            else{
                JOptionPane.showMessageDialog(null,"Please Fill all the Fields!");
            }
            }catch(IOException ex){
                Logger.getLogger(Register.class.getName()).log(Level.SEVERE,null,ex);
            }
    
        }
    });
    button2 = new JButton("Clear");
    button2.setBounds(200,340,100,30);
    button2.setForeground(Color.RED);
    button2.setBackground(Color.BLACK);
    panel.add(button2);
    button2.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            name.setText(null);
            username.setText(null);
            password.setText(null);
            group.clearSelection();
            rankLists.setSelectedIndex(0);
            state.setText(null);
        }
    });
    button3 = new JButton("Back");
    button3.setBounds(330,340,100,30);
    button3.setForeground(Color.RED);
    button3.setBackground(Color.BLACK);
    panel.add(button3);
    button3.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            new Login();
            frame.dispose();
        }
    });
    ImageIcon icon =new ImageIcon("C:\\CriminalRecordManagementSystem\\images\\showpassword.png");
    Image newimg = icon.getImage().getScaledInstance(25,20, java.awt.Image.SCALE_SMOOTH);
    icon=new ImageIcon(newimg);
    JCheckBox button4 = new JCheckBox(icon);
    button4.setFocusPainted(false);
    button4.setBackground(Color.white);
    button4.setBounds(355,180,32,21);
    panel.add(button4);
    button4.addItemListener(new ItemListener(){
        @Override
        public void itemStateChanged(ItemEvent e) {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                password.setEchoChar('*');
            } else {
                 password.setEchoChar((char) 0);
            }
        
            
        }
    });
    frame.setVisible(true);
     }
    public static void main(String[]args)
    {
       new Register();
    }
}