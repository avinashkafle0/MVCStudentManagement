/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.info.dao;

import com.info.model.Teacher;
import com.info.utils.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Avinash Kafle
 */
public class TeacherDao {
    public void insertTeacher(Teacher teacher){
        
        try{
            Connection con = DBConnection.getConnection();
            
            String qry = "INSERT INTO teacher(Name, Address) VALUES(?,?)";
            
            PreparedStatement pst = con.prepareStatement(qry);
            
            pst.setString(1, teacher.getTeacherName());
            pst.setString(2, teacher.getTeacherAddress());
            
            pst.execute();
            
            con.close();
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
    public List<Teacher> getTeacherList(){
        
        List<Teacher> teacherlist = new ArrayList<>();
        try{
            Connection con = DBConnection.getConnection();
            
            String qry = "SELECT * FROM teacher";
            PreparedStatement pst = con.prepareStatement(qry);
            ResultSet rs = pst.executeQuery();
            
            
            while(rs.next()){
                Teacher teacher = new Teacher();
                teacher.setTeacherId(rs.getInt("Id"));
                teacher.setTeacherName(rs.getString("Name"));
                teacher.setTeacherAddress(rs.getString("Address"));
                teacherlist.add(teacher);
            }
            return teacherlist;
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return null;
    }
    
    public List<Teacher> getTeacherList(String searchTeacher){
        
        List<Teacher> teacherlist = new ArrayList<>();
        try{
            Connection con = DBConnection.getConnection();
            String qry = "SELECT * FROM teacher WHERE Name LIKE '"+searchTeacher+"%'";
            
            PreparedStatement pst = con.prepareStatement(qry);
            
            ResultSet rs = pst.executeQuery();
            
            
            while(rs.next()){
                Teacher teacher = new Teacher();
                teacher.setTeacherId(rs.getInt("Id"));
                teacher.setTeacherName(rs.getString("Name"));
                teacher.setTeacherAddress(rs.getString("Address"));
                teacherlist.add(teacher);
            }
            return teacherlist;
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return null;
    }
    
    public void deleteTeacher(int teacherId){
        try{
            Connection con = DBConnection.getConnection();
            String qry = "DELETE FROM teacher WHERE Id = ?";
            PreparedStatement pst = con.prepareStatement(qry);
            pst.setInt(1, teacherId);
            pst.executeUpdate();
            con.close();
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public Teacher getTeacher(int teacherId){
        
        try{
            Connection con = DBConnection.getConnection();
            
            String qry = "SELECT * FROM teacher WHERE Id =?";
            PreparedStatement pst = con.prepareStatement(qry);
            pst.setInt(1, teacherId);
            ResultSet rs = pst.executeQuery();
            
            
            while(rs.next()){
                Teacher teacher = new Teacher();
                teacher.setTeacherId(rs.getInt("Id"));
                teacher.setTeacherName(rs.getString("Name"));
                teacher.setTeacherAddress(rs.getString("Address"));
                return teacher;
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return null;
    }
    
    public void updateTeacher(Teacher teacher){
        try{
            Connection con = DBConnection.getConnection();
            String qry = "UPDATE teacher SET Name = ?, Address = ? WHERE Id = ?";
            PreparedStatement pst = con.prepareStatement(qry);
            pst.setString(1, teacher.getTeacherName());
            pst.setString(2, teacher.getTeacherAddress());
            pst.setInt(3, teacher.getTeacherId());
            
            pst.executeUpdate();
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
