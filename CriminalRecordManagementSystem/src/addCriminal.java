import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;

public class addCriminal {
     private static JLabel imageprint,fullname,gender,age,controlnumber,crime,nationality,bail,jail,picname;
     private static JTextField FullName,Age,ControlNumber,Nationality;
     private static JRadioButton genderMale,genderFemale;
     private static ButtonGroup group;
     private static JComboBox<String> Crime,Bail,Jail;
     private static JButton button1,button2,button3,button4;
     File selectedImageFile=null;
     
     
     public void saveImage()throws IOException{
      BufferedImage image = ImageIO.read(selectedImageFile);
      File file = new File(selectedImageFile.getPath());
      ImageInputStream iis = ImageIO.createImageInputStream(file);
      Iterator<ImageReader> imageReaders = ImageIO.getImageReaders(iis);
      while (imageReaders.hasNext()) {
        ImageReader reader = (ImageReader) imageReaders.next();
          String Format = reader.getFormatName();
          System.out.print(reader.getFormatName());
          String format1 = "png";
          String format2 = "JPEG";
          if(Format==format1){
            String Location = "C:\\CriminalRecordManagementSystem\\CriminalImage\\"+picname.getText()+".png";
            ImageIO.write(image, format1,new File(Location));
              }
          else if(Format==format2){
          String Locations =  "C:\\CriminalRecordManagementSystem\\CriminalImage\\"+picname.getText()+".jpeg";
          ImageIO.write(image, format2,new File(Locations));
            }
          }
        iis.close();
      }
     public void Data()throws IOException{
        File file = new File("C:\\CriminalRecordManagementSystem\\CriminalData\\CriminalData.txt");
        if(!file.exists()){
           file.createNewFile();
        }
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        Object[]Lines = buffer.lines().toArray();
        int i=0;
        int id=0;
        buffer.close();
        for(i=0;i<Lines.length;i++){
           String Line = Lines[i].toString().trim();
           String[]Row = Line.split(",");
           id=Integer.parseInt(Row[0]);
        }
        
        int number = id+1;
        FileWriter fw = new FileWriter(file,true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter  pw = new PrintWriter(bw);
        pw.println(number+","+selectedImageFile.getPath()+","+ControlNumber.getText()+","+FullName.getText()+","+group.getSelection().getActionCommand().toString()+","+Age.getText()+","+Crime.getSelectedItem().toString()+","+Nationality.getText()+","+Bail.getSelectedItem().toString()+","+Jail.getSelectedItem().toString());
        pw.flush();
        pw.close();
        bw.close();
     }
   
    addCriminal(){
       JFrame frame = new JFrame("ADD CRIMINAL PAGE");
       frame.addWindowListener(new java.awt.event.WindowAdapter() {
        public void windowClosing(java.awt.event.WindowEvent windowEvent) {
            if (JOptionPane.showConfirmDialog(frame, 
                "Are you sure you want to close Add Criminal Page?", "Exit", 
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
               
               g.drawImage(background.getImage(), 0,0,700,770,null);
               super.paintComponent(g);
           }
       };
       panel.setOpaque(false);
       panel.setLayout(null);
       ImageIcon image= new ImageIcon("C:\\CriminalRecordManagementSystem\\images\\logo.jpg");
       frame.setIconImage(image.getImage());
       frame.setSize(700,800);
       frame.setLocation(new Point(400, 30));
       frame.setResizable(false);
       frame.add(panel);
       imageprint = new JLabel();
       imageprint.setBounds(500,160,125,125);
       Border border = BorderFactory.createLineBorder(new Color(192,192,192), 4);
       imageprint.setBackground(Color.white);
       imageprint.setOpaque(true);
       imageprint.setBorder(border);
       panel.add(imageprint);
       button1= new JButton("Add Image");
       button1.setBounds(513, 310,100,31);
       button1.setForeground(Color.black);
       button1.setBackground(Color.white);
       panel.add(button1);
       button1.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e){
              JFileChooser fileopen = new JFileChooser();
              FileNameExtensionFilter filter = new FileNameExtensionFilter("Images","jpg","png","jpeg");
              fileopen.addChoosableFileFilter(filter);
              int res = fileopen.showOpenDialog(null);
              if(res==JFileChooser.APPROVE_OPTION){
                 selectedImageFile = fileopen.getSelectedFile();
                 String selectedImagePath = selectedImageFile.getAbsolutePath();
                 JOptionPane.showMessageDialog(null,selectedImagePath);
                 ImageIcon image = new ImageIcon(selectedImageFile.getAbsolutePath());
                 Rectangle rec =imageprint.getBounds();
                 Image scaledimage = image.getImage().getScaledInstance(rec.width,rec.height,Image.SCALE_SMOOTH);
                 image = new ImageIcon(scaledimage);
                 imageprint.setIcon(image);
                 picname.setText(selectedImageFile.getName());
              }
              else{
                JOptionPane.showMessageDialog(null,"No Image Selected");
              }
            }
        });
      controlnumber = new JLabel("Case Number:");
      controlnumber.setBounds(150,160,100,21);
      controlnumber.setForeground(Color.red);
      panel.add(controlnumber);
      ControlNumber = new JTextField();
      ControlNumber.setBounds(270,160,170,21);
      panel.add(ControlNumber);
      fullname = new JLabel("Full Name:");
      fullname.setBounds(150,210,100,21);
      fullname.setForeground(Color.red);
      panel.add(fullname);
      FullName = new JTextField();
      FullName.setBounds(270,210,170,21);
      panel.add(FullName);
      gender = new JLabel("Gender:");
      gender.setBounds(150,260,100,21);
      gender.setForeground(Color.red);
      panel.add(gender);
      genderMale = new JRadioButton("Male");
      genderMale.setActionCommand("Male");
      genderMale.setBounds(270,260,70,21);
      panel.add(genderMale);
      genderFemale=new JRadioButton("Female");
      genderFemale.setActionCommand("Female");
      genderFemale.setBounds(370,260,70,21);
      panel.add(genderFemale);
      genderMale.setSelected(true);
      group=new ButtonGroup();
      group.add(genderMale);
      group.add(genderFemale);
      genderMale.setSelected(true);
      genderFemale.setSelected(true);
      age = new JLabel("Age:");
      age.setBounds(150,310,100,21);
      age.setForeground(Color.red);
      panel.add(age);
      Age = new JTextField();
      Age.setBounds(270,310,170,21);
      panel.add(Age);
      crime = new JLabel("Crime:");
      crime.setBounds(150,360,100,21);
      crime.setForeground(Color.red);
      panel.add(crime);
      Crime = new JComboBox<String>();
      Crime.addItem("Illegal drug trade");
      Crime.addItem("Human trafficking");
      Crime.addItem("Arms trafficking");
      Crime.addItem("Murder");
      Crime.addItem("Robbery");
      Crime.addItem("Corruption");
      Crime.addItem("Domestic Violence");
      Crime.addItem("Fraud");
      Crime.addItem("Rape");
      Crime.addItem("Physical Injury");
      Crime.addItem("Tax Evasion");
      Crime.addItem("Petty crime");
      Crime.addItem("Homicide");
      Crime.addItem("Prostitution");
      Crime.addItem("Organized crime");
      Crime.addItem("Police Misconduct");
      Crime.addItem("Terrorism");
      Crime.addItem("Sextortion");
      Crime.addItem("Identity Theft");
      Crime.addItem("Violent Crimes Against Women And Children");
      Crime.addItem("Drugs");
      Crime.addItem("Abortion");
      Crime.setBounds(220,360,290,25);
      panel.add(Crime);
      nationality = new JLabel("Nationality:");
      nationality.setBounds(150,410,100,21);
      nationality.setForeground(Color.red);
      panel.add(nationality);
      Nationality = new JTextField();
      Nationality.setBounds(270,410,170,21);
      panel.add(Nationality);
      bail = new JLabel("Bail Status:");
      bail.setBounds(150,460,100,21);
      bail.setForeground(Color.red);
      panel.add(bail);
      Bail = new JComboBox<String>();
      Bail.addItem("Yes");
      Bail.addItem("No");
      Bail.setBounds(270,460,170,25);
      panel.add(Bail);
      jail = new JLabel("Jail Time:");
      jail.setBounds(150,510,100,21);
      jail.setForeground(Color.red);
      panel.add(jail);
      Jail = new JComboBox<String>();
      Jail.addItem("1 Month");
      for (int i=2;i<=12;i++){
        Jail.addItem(i+" "+"Months");
      }
      Jail.addItem("1 Year");
      for(int i=2;i<=100;i++){
        Jail.addItem(i+" "+"Years");
      }
      Jail.addItem("Lifetime");
      Jail.setBounds(270,510,170,21);
      panel.add(Jail);
      button2 = new JButton("Add");
      button2.setBounds(150,580,100,30);
      button2.setBackground(Color.black);
      button2.setForeground(Color.red);
      panel.add(button2);
      button2.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
          try{
            if(!"".equals(ControlNumber.getText())&&!"".equals(FullName.getText())&&!"".equals(group.getSelection().getActionCommand().toString())&&!"".equals(Age.getText())&&!"".equals(Crime.getSelectedItem().toString())&&!"".equals(Nationality.getText())&&!"".equals(Bail.getSelectedItem().toString())&&!"".equals(Jail.getSelectedItem().toString())&&!"".equals(picname.getText())&&!"".equals(imageprint.getName())&&!"".equals(selectedImageFile.getPath())){
            saveImage();
            Data();
            JOptionPane.showMessageDialog(null,"The Criminal is Successfully added!");
            imageprint.setIcon(null);
            ControlNumber.setText(null);
            FullName.setText(null);
            group.clearSelection();
            Age.setText(null);
            Crime.setSelectedIndex(0);
            Nationality.setText(null);
            Bail.setSelectedIndex(0);
            Jail.setSelectedIndex(0);
            picname.setText(null);
           }
           else{
              JOptionPane.showMessageDialog(null,"Please Fill all the Fields!");
           }
          }catch(IOException ev){
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE,null,ev);
          }
        }
      });
      button3 = new JButton("Clear");
      button3.setBounds(290,580,100,30);
      button3.setForeground(Color.red);
      button3.setBackground(Color.black);
      panel.add(button3);
      button3.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e){
              imageprint.setIcon(null);
              ControlNumber.setText(null);
              FullName.setText(null);
              group.clearSelection();
              Age.setText(null);
              Crime.setSelectedIndex(0);
              Nationality.setText(null);
              Bail.setSelectedIndex(0);
              Jail.setSelectedIndex(0);
              picname.setText(null);
         }
      });
      button4 = new JButton("Back");
      button4.setBounds(430,580,100,30);
      button4.setForeground(Color.red);
      button4.setBackground(Color.black);
      panel.add(button4);
      button4.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
             frame.dispose();
             new Homepage();
        }
      });
      picname = new JLabel();
      picname.setHorizontalAlignment(JLabel.CENTER);
      picname.setBounds(500,282,125,29);
      Border borders = BorderFactory.createLineBorder(new Color(192,192,192), 4);
      picname.setBorder(borders);
      picname.setForeground(Color.black);
      picname.setBackground(Color.white);
      panel.add(picname);
      picname.setOpaque(true);
      frame.setVisible(true);
    }
    
    
    public static void main(String[]args){
        new addCriminal();

    }
}