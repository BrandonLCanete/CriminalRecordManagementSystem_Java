import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.Border;
import java.awt.Image;

public class CriminalRecord {
    private static JLabel criminal,criminaldata,criminalimage;
    private static JTextField Criminal;
    private static JTextPane CriminalData;
    private static JButton button1,button2,button3,button4,button5;
    
    public void JailData()throws IOException{
       BufferedReader input =null;
       List<String> name = new ArrayList<String>();
       try{
         input = new BufferedReader(new FileReader("C:\\CriminalRecordManagementSystem\\CriminalData\\CriminalData.txt"));
         FileWriter file = new FileWriter("C:\\CriminalRecordManagementSystem\\CriminalData\\JailCriminal.txt");
         String nm;
         while((nm=input.readLine())!=null){
              System.out.print(nm);
              Object[]Lines = input.lines().toArray();
              for(int i=0;i<Lines.length;i++){
              String Line = Lines[i].toString().trim();
              String dataEachLine[]= Line.split(",");
              name.add(dataEachLine[3]+",");
              name.add(dataEachLine[4]+",");
              name.add(dataEachLine[5]+",");
              name.add(dataEachLine[6]+",");
              name.add(dataEachLine[7]+",");
              name.add(dataEachLine[8]+",");
              name.add(dataEachLine[9]+","+"Jail"+"\n");
             }
              for(String str: name) {
                file.write(str);
                file.flush();
              }
              file.close();
         }
       }finally{
           if(input!=null)input.close();
       }
        
    }
    public void PardonData()throws IOException{
        BufferedReader input =null;
        List<String> name = new ArrayList<String>();
        try{
          input = new BufferedReader(new FileReader("C:\\CriminalRecordManagementSystem\\CriminalData\\CriminalData.txt"));
          FileWriter file = new FileWriter("C:\\CriminalRecordManagementSystem\\CriminalData\\PardonCriminal.txt");
          String nm;
          while((nm=input.readLine())!=null){
               System.out.print(nm);
               Object[]Lines = input.lines().toArray();
               for(int i=0;i<Lines.length;i++){
               String Line = Lines[i].toString().trim();
               String dataEachLine[]= Line.split(",");
               name.add(dataEachLine[3]+",");
               name.add(dataEachLine[4]+",");
               name.add(dataEachLine[5]+",");
               name.add(dataEachLine[6]+",");
               name.add(dataEachLine[7]+",");
               name.add(dataEachLine[8]+",");
               name.add(dataEachLine[9]+","+"Pardon"+"\n");
              }
               for(String str: name) {
                 file.write(str);
                 file.flush();
               }
               file.close();
          }
        }finally{
            if(input!=null)input.close();
        }
         
     }
 
    void purgeDirectory(File dir) {
        for (File file: dir.listFiles()) {
            if (file.isDirectory())
                purgeDirectory(file);
            file.delete();
        }
    }
    CriminalRecord(){
        JFrame frame = new JFrame("CRIMINAL RECORDS PAGE");
        frame.addWindowListener(new java.awt.event.WindowAdapter() {
         public void windowClosing(java.awt.event.WindowEvent windowEvent) {
             if (JOptionPane.showConfirmDialog(frame, 
                 "Are you sure you want to close Criminal Records Page?", "Exit", 
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
        frame.setLocation(new Point(400, 10));
        frame.setResizable(false);
        frame.add(panel);
        criminal = new JLabel("Control Number:");
        criminal.setBounds(220,140,100,21);
        criminal.setForeground(Color.red);
        panel.add(criminal);
        Criminal = new JTextField();
        Criminal.setBounds(340,140,130,21);
        panel.add(Criminal);
        button1 = new JButton("Enter");
        button1.setBounds(290,180,100,25);
        button1.setForeground(Color.red);
        button1.setBackground(Color.black);
        panel.add(button1);
        button1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try{
                String s;
                String crime ="Criminal";
                String[] array ;
                boolean isCorrect= false;
                BufferedReader br = new BufferedReader(new FileReader( "C:\\CriminalRecordManagementSystem\\CriminalData\\CriminalData.txt"));
                while((s=br.readLine())!=null) {
                    array=s.split(",");
                    if(Criminal.getText().equals(array[2])){
                        JOptionPane.showMessageDialog(null, "Criminal Data is Matched!");
                        criminalimage.setIcon(new ImageIcon(new ImageIcon(array[1]).getImage().getScaledInstance(125,125, Image.SCALE_SMOOTH)));
                        CriminalData.setText("\t"+"\t"+"Full Name:"+array[3]+"\n"+"\n"+"\t"+"\t"+"Gender:"+array[4]+"\n"+"\n"+"\t"+"\t"+"Age:"+array[5]+"\n"+"\n"+"\t"+"\t"+"Crime:"+array[6]+"\n"+"\n"+"\t"+"\t"+"Nationality:"+array[7]+"\n"+"\n"+"\t"+"\t"+"Bail Status:"+array[8]+"\n"+"\n"+"\t"+"\t"+"Jail Time:"+array[9]);
                        isCorrect = true;
                        break;
                    } else if(array.length != 0 &&crime.equals(Criminal.getText())){
                        JOptionPane.showMessageDialog(null, "Criminal Data is Matched!");
                        criminalimage.setIcon(new ImageIcon(new ImageIcon(array[1]).getImage().getScaledInstance(125,125, Image.SCALE_SMOOTH)));
                        CriminalData.setText("\t"+"\t"+"Full Name:"+array[3]+"\n"+"\n"+"\t"+"\t"+"Gender:"+array[4]+"\n"+"\n"+"\t"+"\t"+"Age:"+array[5]+"\n"+"\n"+"\t"+"\t"+"Crime:"+array[6]+"\n"+"\n"+"\t"+"\t"+"Nationality:"+array[7]+"\n"+"\n"+"\t"+"\t"+"Bail Status:"+array[8]+"\n"+"\n"+"\t"+"\t"+"Jail Time:"+array[9]);
                        isCorrect = true;
                        break;
                    }
                }
                if(!isCorrect) {
                    JOptionPane.showMessageDialog(null, "Criminal Data Does Not Matched!");
                }
                br.close();
              }catch(IOException ev){
                 ev.printStackTrace();
              }
            }
        });
        criminaldata = new JLabel("Criminal Data");
        criminaldata.setFont(new Font("Arial",Font.BOLD,19));
        criminaldata.setBounds(280,230,150,30);
        criminaldata.setForeground(Color.red);
        panel.add(criminaldata);
        CriminalData = new JTextPane();
        CriminalData.setBounds(140,400,410,225);
        CriminalData.setEditable(false);
        panel.add(CriminalData);
        button2 = new JButton("Go to Jail");
        button2.setBounds(110,640,120,30);
        button2.setForeground(Color.red);
        button2.setBackground(Color.black);
        panel.add(button2);
        button2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try{
                if(Criminal.getText()!=null&&criminalimage.getIcon()!=null&&CriminalData.getText()!=null){
                    JailData();
                    JOptionPane.showMessageDialog(null,"The Criminal Goes To Jail!");
                    Criminal.setText(null);
                    criminalimage.setIcon(null);
                    CriminalData.setText(null);
                  }
                  else{
                    JOptionPane.showMessageDialog(null,"Error No Data to Read!");
                  }
                }catch(IOException ev){ 
                      ev.printStackTrace();
                 } 
            
        }
        });
        button3 = new JButton("Pardon");
        button3.setBounds(250,640,100,30);
        button3.setForeground(Color.red);
        button3.setBackground(Color.black);
        panel.add(button3);
        button3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
            try{
              if(Criminal.getText()!=null&&criminalimage.getIcon()!=null&&CriminalData.getText()!=null){
                PardonData();
                JOptionPane.showMessageDialog(null,"The Criminal Receive Pardon!");
                Criminal.setText(null);
                criminalimage.setIcon(null);
                CriminalData.setText(null);
              }
              else{
                JOptionPane.showMessageDialog(null,"Error No Data to Read!");
              }
             }catch(IOException ev){ 
                ev.printStackTrace();
              } 
            }
        });
        button4 = new JButton("Delete");
        button4.setBounds(370,640,100,30);
        button4.setForeground(Color.red);
        button4.setBackground(Color.black);
        panel.add(button4);
        button4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try{
                if(Criminal.getText()!=null&&criminalimage.getIcon()!=null&&CriminalData.getText()!=null){
                purgeDirectory( new File("C:\\CriminalRecordManagementSystem\\CriminalImage\\"));
                FileWriter fwOb = new FileWriter("C:\\CriminalRecordManagementSystem\\CriminalData\\CriminalData.txt", false); 
                PrintWriter pwOb = new PrintWriter(fwOb, false);
                pwOb.flush();
                pwOb.close();
                fwOb.close();
                Criminal.setText(null);
                criminalimage.setIcon(null);
                CriminalData.setText(null);
                JOptionPane.showMessageDialog(null,"Sucessfully Deleted!");
                }else{
                    JOptionPane.showMessageDialog(null,"Error No Data to Delete!");
                }
                }catch(Exception ev){
                    ev.printStackTrace();
                }
            }
        });  
        button5 = new JButton("Back");
        button5.setBounds(490,640,100,30);
        button5.setForeground(Color.red);
        button5.setBackground(Color.black);
        panel.add(button5);
        button5.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                frame.dispose();
                new Homepage();
            }
        });
        criminalimage = new JLabel();
        Border border = BorderFactory.createLineBorder(new Color(192,192,192), 4);
        criminalimage.setBorder(border);
        criminalimage.setBounds(280,265, 125, 125);
        criminalimage.setBackground(Color.white);
        criminalimage.setOpaque(true);
        panel.add(criminalimage);
        frame.setVisible(true);
     }
     public static void main(String[]args){
        new CriminalRecord();
        
     }
}
