
package bankmanagementsystem;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.regex.*;

    public class Signup2 extends JFrame implements  ActionListener {
    
    
    JComboBox religion,categeory,occupation,income,qulification;
    JTextField panno,Adhar;
    JButton next;
    JRadioButton sys,sysNo,acc,accNo;
    String formno;
    
    Signup2(String formno){
        this.formno=formno;
   
        setLayout(null);
        setTitle("New Account Application Form-Page2");
        JLabel additionalDetails=new JLabel("Page2:Additional Details");
        additionalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        additionalDetails.setBounds(290,80,400,30);
        add( additionalDetails);
        
        JLabel Religion=new JLabel("Religion:");
        Religion.setFont(new Font("Raleway",Font.BOLD,22));
        Religion.setBounds(100,140,100,30);
        add(Religion);
        
        String valReligion[]={"  ","Hindu","Muslim","Sikh","Christan","Other"};
        
        religion=new JComboBox(valReligion);
        religion.setBackground(Color.white);
        religion.setBounds(300,140,400,30);
        add(religion);
        
      
        JLabel Ctegeory=new JLabel("Categeory:");
        Ctegeory.setFont(new Font("Raleway",Font.BOLD,22));
        Ctegeory.setBounds(100,190,200,30);
        add(Ctegeory);
        
        String valCategeory[]={" ","General","OBC","SC","NT","SBC","OPEN","Other"};
        
        categeory=new JComboBox(valCategeory);
        categeory.setBackground(Color.white);
        categeory.setBounds(300,190,400,30);
        add(categeory);
        
      
        
        
        JLabel Income=new JLabel("Income:");
        Income.setFont(new Font("Raleway",Font.BOLD,22));
        Income.setBounds(100,240,200,30);
        add(Income);
        
        
         String valIncome[]={" ","Null","<150000","<2500000","<500000","upto 10,00000","Other"};
         
        income=new JComboBox(valIncome);
        income.setBackground(Color.white);
        income.setBounds(300,240,400,30);
        add(income);
        
        
        JLabel Qulification=new JLabel("Qualification:");
        Qulification.setFont(new Font("Raleway",Font.BOLD,22));
        Qulification.setBounds(100,315,200,30);
        add(Qulification);
        
       String valeducationvalues[]={" ","Non-Graduate","Graduate","Post-Graduate","Master","Doctarate","Other"};
       
       qulification=new JComboBox(valeducationvalues);
       qulification.setBackground(Color.white);
       qulification.setBounds(300,315,400,30);
       add(qulification);
        
       
        JLabel Occupation=new JLabel("Occupation:");
        Occupation.setFont(new Font("Raleway",Font.BOLD,22));
        Occupation.setBounds(100,390,200,30);
        add(Occupation);
        
        
       String valeOccupation[]={" ","Student","Unemployed","Engineer","Doctor","Lawyer", " Freelancer","Other"};
       
       occupation=new JComboBox(valeOccupation);
       occupation.setBackground(Color.white);
       occupation.setBounds(300,390,400,30);
       add(occupation);
        
      
         
         
        JLabel Panno=new JLabel("PanNO:");
        Panno.setFont(new Font("Raleway",Font.BOLD,22));
        Panno.setBounds(100,440,200,30);
        add(Panno);
        
        panno=new JTextField();
        panno.setBounds(300,440,400,30);
        add(panno);
        
        
        JLabel Adharno=new JLabel("Adhar-Card:");
        Adharno.setFont(new Font("Raleway",Font.BOLD,22));
       Adharno.setBounds(100,490,200,30);
        add(Adharno);
        
       Adhar=new JTextField();
       Adhar.setBounds(300,490,400,30);
       add(Adhar);
        
        
        JLabel Sys=new JLabel("senior Citizen:");
        Sys.setFont(new Font("Raleway",Font.BOLD,22));
        Sys.setBounds(100,540,200,30);
        add(Sys);
        
        
        sys=new JRadioButton("Yes");
        sys.setBackground(Color.WHITE);
        sys.setBounds(300,540,100,30);
        add(sys);
        
        sysNo=new JRadioButton("No");
        sysNo.setBackground(Color.WHITE);
        sysNo.setBounds(450,540,100,30);
        add(sysNo);
        
        
        ButtonGroup citizengroup=new ButtonGroup();
       citizengroup.add(sys);
       citizengroup.add(sysNo);
       
        
        
        JLabel Acc=new JLabel(" Existing Account:");
        Acc.setFont(new Font("Raleway",Font.BOLD,22));
        Acc.setBounds(100,590,200,30);
        add(Acc);
        
         acc=new JRadioButton("Yes");
         acc.setBackground(Color.WHITE);
        acc.setBounds(300,590,100,30);
        add(acc);
        
        accNo=new JRadioButton("No");
         accNo.setBackground(Color.WHITE);
        accNo.setBounds(450,590,400,30);
        add(accNo);
        
        
        ButtonGroup accgroup=new ButtonGroup();
       accgroup.add(acc);
       accgroup.add(accNo);
        
        
        next=new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Relway",Font.BOLD,14) );
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);
        
        
        
        getContentPane().setBackground(Color.WHITE);
       
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
        
    
    }
    public void actionPerformed(ActionEvent ae){
        String sReligion =(String)religion.getSelectedItem();
        String sCategeory=(String)categeory.getSelectedItem();
        String sIncome=(String)income.getSelectedItem();
        String sQulification=(String)qulification.getSelectedItem();
        String sOccupation=(String)occupation.getSelectedItem();
        
        String sSys=null;
        if(sys.isSelected()){
            sSys="Yes";
        
        }else if(sysNo.isSelected()){
              sSys="No";
        }
        String sAcc=null;
        if(acc.isSelected()){
            sAcc="Yes";
        
        }else if(accNo.isSelected()){
              sAcc="No";
        }
        
        String sPanno= panno.getText();
        
      String sAdhar=Adhar.getText();
       
        
       
        
        try {
            Conn c=new Conn();
        
          String query="insert into signup2 values('"+formno+"','"+sReligion+"','"+sCategeory+"','"+sIncome+"','"+sQulification+"','"+sOccupation+"','"+sPanno+"',"
                  + "'"+sAdhar+"','"+sSys+"','"+sAcc+"')";
              c.s.executeUpdate(query);
              
              //new Signup2(formno).setVisible(true);
              setVisible(false);
              new Signup3(formno).setVisible(true);
        }
        catch(Exception ex){
            System.out.println(ex);
        }
         
                 
    }
    public static void main(String args[]){
        new Signup2("").setVisible(true);
    }
}

