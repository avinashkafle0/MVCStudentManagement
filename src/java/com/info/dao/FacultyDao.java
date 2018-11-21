
package com.info.dao;

import com.info.model.Faculty;
import com.info.utils.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class FacultyDao {
    
    
    public List<Faculty> getFacultyList(){
    List<Faculty> facultylist = new ArrayList();
    
    try{
        Connection con = DBConnection.getConnection();
        String qry = "SELECT * FROM faculty ";
        PreparedStatement pst = con.prepareStatement(qry);
        ResultSet rs = pst.executeQuery();
        
        while(rs.next()){
           Faculty faculty = new Faculty();
           faculty.setFacultyId(rs.getInt("facultyId"));
           faculty.setFacultyName(rs.getString("facultyName"));
           facultylist.add(faculty);
        }
        
        return facultylist;
        
    }catch(Exception e){
        e.printStackTrace();
    }
    
    return null;
    }
}
