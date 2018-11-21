/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.info.utils;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Avinash Kafle
 */
public class DBConnection {
    
    static public Connection getConnection(){
        
        try{
             //load driver
            Class.forName("com.mysql.jdbc.Driver");
            //Establish Connection
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/broaddb", "root", "");
            
            return con;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
