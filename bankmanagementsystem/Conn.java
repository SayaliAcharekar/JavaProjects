/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankmanagementsystem;

import java.sql.*;
 
public class Conn {
    Connection c;
    Statement s;
    public Conn(){
    try{
        c=DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root", "310906");
        s=c.createStatement();
    }
    catch(Exception e){
    }
    }
    
}
