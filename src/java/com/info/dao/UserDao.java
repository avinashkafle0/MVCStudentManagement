
package com.info.dao;

import com.info.model.User;
import com.info.utils.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class UserDao {
    
    public User validatedUser(User user){
        try{
            Connection con = DBConnection.getConnection();
            String qry = "SELECT * FROM user WHERE userName =? AND userPassword =? ";
            PreparedStatement pst = con.prepareStatement(qry);
            pst.setString(1, user.getUserName());
            pst.setString(2, user.getUserPassword());
            
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                User validatedUser = new User();
                validatedUser.setUserName(rs.getString("userName"));
                validatedUser.setUserPassword(rs.getString("userPassword"));
                
                return validatedUser;
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return null;
    }
    
}
