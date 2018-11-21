/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.info.dao;

import com.info.model.Student;
import com.info.utils.DBConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.Part;

/**
 *
 * @author Avinash Kafle
 */
public class StudentDao {
    
    public void insertStudent(Student student){
        
        try{
            Connection con = DBConnection.getConnection();
           
            String qry = "INSERT INTO student(studentName, studentAddress, studentImage) VALUES(?,?,?)";
            
            PreparedStatement pst = con.prepareStatement(qry);
            
            pst.setString(1, student.getStudentName());
            pst.setString(2, student.getStudentAddress());
            pst.setBlob(3, ((Part)student.getStudentImage()).getInputStream());
            
            pst.execute();
            con.close();
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
    
    
    public List<Student> getStudentList(){
        
        List<Student> studentlist = new ArrayList();
        try{
            Connection con = DBConnection.getConnection();
            
            String qry = "SELECT * FROM student ";
            PreparedStatement pst = con.prepareStatement(qry);

            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                Student student = new Student();
                student.setStudentId(rs.getInt("studentId"));
                student.setStudentName(rs.getString("studentName"));
                student.setStudentAddress(rs.getString("studentAddress"));
                student.setStudentImage(rs.getBlob("studentImage"));
                studentlist.add(student);
            }
            return studentlist;
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return null;
    }
    
    
    public List<Student> getStudentList(String searchStudent){
        
        List<Student> studentlist = new ArrayList();
        try{
            Connection con = DBConnection.getConnection();
            
            String qry = "SELECT * FROM student WHERE studentName LIKE '"+searchStudent+"%'";//or searchAddress like
            PreparedStatement pst = con.prepareStatement(qry);

            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                Student student = new Student();
                student.setStudentId(rs.getInt("studentId"));
                student.setStudentName(rs.getString("studentName"));
                student.setStudentAddress(rs.getString("studentAddress"));
                studentlist.add(student);
            }
            return studentlist;
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return null;
    }
    
    public void deleteStudent(int studentId){
        try{
            Connection con = DBConnection.getConnection();
            String qry = "DELETE FROM student WHERE studentId = ?";
            PreparedStatement pst = con.prepareStatement(qry);
            pst.setInt(1, studentId);
            pst.executeUpdate();
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
     public Student getStudent(int studentId){
        
        try{
            Connection con = DBConnection.getConnection();
            
            String qry = "SELECT * FROM student WHERE studentId = ? ";
            PreparedStatement pst = con.prepareStatement(qry);
            pst.setInt(1, studentId);
            ResultSet rs = pst.executeQuery();
                while(rs.next()){
                Student student = new Student();
                student.setStudentId(rs.getInt("studentId"));
                student.setStudentName(rs.getString("studentName"));
                student.setStudentAddress(rs.getString("studentAddress"));
                student.setStudentImage(rs.getBlob("studentImage"));
                return student;
                }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return null;
    }
     
     public void updateStudent(Student student){
         try{
             Connection con = DBConnection.getConnection();
             String qry = "UPDATE student SET studentName = ?, studentAddress=?, studentImage=? WHERE studentId = ?";
             PreparedStatement pst = con.prepareStatement(qry);
             pst.setString(1, student.getStudentName());
             pst.setString(2, student.getStudentAddress());
             pst.setBlob(3, ((Part)student.getStudentImage()).getInputStream());
             pst.setInt(4, student.getStudentId());
             
             pst.executeUpdate();
             con.close();
         }catch(Exception e){
             e.printStackTrace();
         }
     }
    
}
