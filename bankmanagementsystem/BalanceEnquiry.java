
package bankmanagementsystem;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;
import java.sql.*;


public class BalanceEnquiry extends JFrame implements ActionListener {
    
    JLabel image,text ,pintext,repintext;
    JButton back;
    String pin;
     BalanceEnquiry(String pin){
         this.pin=pin;
         
         
           ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
         Image i2=i1.getImage().getScaledInstance(900, 900,Image.SCALE_DEFAULT);
         ImageIcon i3=new ImageIcon(i2);
        image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        
        
         back=new JButton ("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        add(back);
        
        Conn c=new Conn();
         int balance=0;
         try{
               ResultSet rs= c.s.executeQuery ("select * from bank where  pin = '"+pin+"'");
              
               while(rs.next()){
                   if (rs.getString("type").equals("Deposit")){
                       balance+=Integer.parseInt(rs.getString("amount"));
                   }
             
                   else{
                       balance -=Integer.parseInt(rs.getString("amount"));
                   }
               }
               
       }
            catch(Exception e){
                System.out.println(e);
                
            }
        
        text=new JLabel("Your Current Account Balance Is RS"+balance);
        text.setBounds(170,300,400,30);
        text.setForeground(Color.WHITE);
        text.setFont(new Font ("System",Font.BOLD,16));
        image.add(text);
        
        
        
        
         setLayout(null);
         setSize(900,900);
        setLocation(300 ,0);
        setUndecorated(true);
        setVisible(true);
         
     }
    
       public void actionPerformed(ActionEvent ae){
             if (ae.getSource()==back){
            setVisible(false);
            new Transaction(pin).setVisible(true);
           
             }
       }
    public static void main(String args[]){
        new  BalanceEnquiry("").setVisible(true);
        
       
    }
    
}
