/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Stagiaire
 */
public class Connect {
    private static String driver = "com.mysql.jdbc.Driver";    
    private static String url = "jdbc:mysql://localhost:3306/forum";
    private static String user = "root";
    private static String pwd = "";
    
    protected java.sql.Connection connect;
    protected PreparedStatement pst;
    protected ResultSet rs;
    
    public Connect(){
        seConnecter();
    }
    
    public void seConnecter(){
        
        try{
            Class.forName(driver);            
            connect = DriverManager.getConnection(url,user,pwd);
            System.out.println("Connexion ok");                        
        }catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();            
        }
    }
}
