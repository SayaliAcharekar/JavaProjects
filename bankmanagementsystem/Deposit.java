
package bankmanagementsystem;

import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import javax.swing.*;



public class Deposit extends JFrame implements ActionListener{
    JLabel image,text;
    JTextField amount;
    JButton deposit,back;
    String pin;
    
    Deposit(String pin){
        this.pin=pin;
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900, 900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        text =new JLabel("Enter the Amount you want to Deposit");
        text.setForeground(Color.WHITE);
        text.setFont(new Font ("System",Font.BOLD,16));
        text.setBounds(170,300,400,20);
        image.add(text);
        
        amount=new  JTextField();
        amount.setFont(new Font ("Relway",Font.BOLD,22));
        amount.setBounds(170,350,320,25);
        image.add(amount);
        
        deposit=new JButton ("Deposit");
        deposit.setBounds(355,450,150,30);
       deposit.addActionListener(this);
       image.add(deposit);
       
         back=new JButton ("Back");
        back.setBounds(355,485,150,30);
       back.addActionListener(this);
       image.add(back);
       
       

        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==deposit){
            String number=amount.getText();
            Date date=new Date();
            if(number.equals("")){
            JOptionPane.showMessageDialog(null, "Please Enter  the Amount you want to deposit");
                    }
            else{
                try{
                Conn conn=new Conn();
                String query ="insert into  bank values ('"+pin+"','"+date+"','Deposit','"+number+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs "+number+"Deposited Sucessfully");
                setVisible(false);
                new Transaction(pin).setVisible(true);
                }
                catch (Exception e){
                    System.out.println(e);
                
                }
                
            }
            
        }
        else if(ae.getSource()==back){
            setVisible(false);
            new Transaction(pin).setVisible(true);
        }
        
    }
        
    
    public static void main (String args[]){
        new Deposit("").setVisible(true);
        
    }
}
