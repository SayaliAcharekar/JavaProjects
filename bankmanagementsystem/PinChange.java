
package bankmanagementsystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



public class PinChange extends JFrame implements ActionListener {
      JLabel image,text ,pintext,repintext;
      JPasswordField pin1,repin;
      JButton change,back;
      String pin;
   PinChange(String pin){
       this.pin=pin;
              setLayout(null);
       
         ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
         Image i2=i1.getImage().getScaledInstance(900, 900,Image.SCALE_DEFAULT);
         ImageIcon i3=new ImageIcon(i2);
        image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        
         text=new JLabel("CHANGE PIN");
        text.setBounds(250,280,500,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font ("System",Font.BOLD,16));
        image.add(text);
        
        pintext=new JLabel("NEW PIN");
        pintext.setBounds(165,320,180,25);
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font ("System",Font.BOLD,16));
        image.add(pintext);
        
        pin1=new  JPasswordField();
        pin1.setBounds(330,320,180,25);
        pin1.setForeground(Color.WHITE);
        pin1.setFont(new Font ("System",Font.BOLD,16));
        image.add(pin1);
        
        repin=new  JPasswordField();
        repin.setBounds(330,360,180,25);
        repin.setForeground(Color.WHITE);
        repin.setFont(new Font ("System",Font.BOLD,16));
        image.add(repin);
        
        change=new JButton ("Change");
         change.setBounds(355,485,150,30);
        change.addActionListener(this);
        add(change);
        
         back=new JButton ("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        add(back);
        
        
        
        repintext=new JLabel("Re-Enter-PIN");
        repintext.setBounds(165,360,180,25);
        repintext.setForeground(Color.WHITE);
       repintext.setFont(new Font ("System",Font.BOLD,16));
        image.add(repintext);
        
        add(image);
      setSize(900,900);
        setLocation(300 ,0);
        setUndecorated(true);
        setVisible(true);
   }
   public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==change){
            setVisible(false);
            //new Transaction(pin).setVisible(true);
      
            
            try{
                String npin=pin1.getText();
                String rpin=repin.getText();
                if(!npin.equals(rpin)){
                    JOptionPane.showMessageDialog(null, "Pin Does not Match");
                    return;
                }
                
                  if(npin.equals("")){
                        JOptionPane.showMessageDialog(null, "Pin Enter Pin");
                        return;
                  }
                  if(rpin.equals("")){
                        JOptionPane.showMessageDialog(null, "Please Re-Enter Pin ");
                        return ;
                  }
                  Conn c1 = new Conn();
                String q1 = "update bank set pin = '"+rpin+"' where pin = '"+pin+"' ";
                String q2 = "update login set pin = '"+rpin+"' where pin = '"+pin+"' ";
                String q3 = "update signup3 set pin = '"+rpin+"' where pin = '"+pin+"' ";

                c1.s.executeUpdate(q1);
                c1.s.executeUpdate(q2);
                c1.s.executeUpdate(q3);

                JOptionPane.showMessageDialog(null, "PIN changed successfully");
                setVisible(false);
                new Transaction(rpin).setVisible(true);
            
            }
           
            
            catch(Exception e){
                System.out.println(e);
            
            }
                }
            else{
            setVisible(false);
            new Transaction(pin).setVisible(true);
            
            
                    }
        }

 public static void main(String args[]){
        new  PinChange("").setVisible(true);
    }
}
