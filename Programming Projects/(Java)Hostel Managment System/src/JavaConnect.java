/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Wael
 */
import java.sql.*;
import javax.swing.*;
public class JavaConnect {
    Connection conn= null;
    public static Connection Connectrb(){
    
    try{
    Class.forName("org.sqlite.JDBC");
    Connection conn =DriverManager.getConnection("jdbc:sqlite:Assignment.sqilte");
    //"jdbc:sqlite:C:\\Users\\Wael\\Desktop\\HostelManagement\\Assignment.sqilte"
    //JOptionPane.showMessageDialog(null, "Connection Established");//C:\Users\9589693153\Documents\NetBeansProjects\PROMA
    return conn;
       }catch (Exception e){
           JOptionPane.showMessageDialog(null, e);
       return null;
       }
    }
}
