package com.fhbs.deneme;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author furkankykc
 */
public class ConnectionManager {
 private static String url = "jdbc:mysql://localhost:3306/cezaEvi";
   private static String driver = "com.mysql.jdbc.Driver";
   private static  String user = "root";
    private static String password = "fur3808535qQ@";
    private static Connection con;
    public static Connection getConnection(){
        try{
            Class.forName(driver);
            try{
                con = DriverManager.getConnection(url,user,password);
                
                System.out.println("Connection cannot be established");
                
            }
            catch(SQLException ex){
                System.err.println("Failed to create the database connection");
                
            }
        }
        catch (ClassNotFoundException ex){
            System.out.println("driver not found");
        }
            return con;
       
    }
}
