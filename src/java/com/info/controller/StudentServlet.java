/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.info.controller;

import com.info.dao.StudentDao;
import com.info.model.Student;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author Avinash Kafle
 */
@WebServlet(name = "StudentServlet", urlPatterns = {"/StudentServlet"})
@MultipartConfig(maxFileSize = 16177215)
public class StudentServlet extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            StudentDao sd = new StudentDao();
            if(request.getParameter("add")!= null){
            String name = request.getParameter("studentName");
            String address = request.getParameter("studentAddress");
            
            Part studentImage = request.getPart("studentImage");
            Student student = new Student();
            student.setStudentName(name);
            student.setStudentAddress(address);
            student.setStudentImage(studentImage);
            
            sd.insertStudent(student);
            
//            List<Student> studentlist = sd.getStudentList();
//            
//            request.setAttribute("studentlist", studentlist);
//            RequestDispatcher rd = request.getRequestDispatcher("student-list.jsp");
//            rd.forward(request, response);
//            response.sendRedirect("student-list.jsp");
        }else if(request.getParameter("studentIdForDelete")!= null){
            int studentId = Integer.parseInt(request.getParameter("studentIdForDelete"));
            
            sd.deleteStudent(studentId);
            
        } else if(request.getParameter("studentIdForEdit")!=null){
            int studentId = Integer.parseInt(request.getParameter("studentIdForEdit"));
            
            Student student = sd.getStudent(studentId);
            
            request.setAttribute("student", student);
            RequestDispatcher rd = request.getRequestDispatcher("student-form.jsp");
            rd.forward(request, response);  
            
        }else if(request.getParameter("update")!= null){
            int studentId = Integer.parseInt(request.getParameter("studentId"));
            String name = request.getParameter("studentName");
            String address = request.getParameter("studentAddress");
            Part studentImage = request.getPart("studentImage"); 
            
            Student student = new Student();
            student.setStudentId(studentId);
            student.setStudentName(name);
            student.setStudentAddress(address);
            student.setStudentImage(studentImage);
            
            sd.updateStudent(student);
        }else if(request.getParameter("search")!=null){
            List<Student> studentlist = sd.getStudentList(request.getParameter("searchStudent"));
            
            request.setAttribute("studentlist", studentlist);
            RequestDispatcher rd = request.getRequestDispatcher("student-list.jsp");
            rd.forward(request, response);  
        }else if(request.getParameter("studentIdForDetail")!=null){
            Student student = sd.getStudent(Integer.parseInt(request.getParameter("studentIdForDetail")));
            
            List<Student> studentlist = sd.getStudentList();
            request.setAttribute("studentlist", studentlist);
            request.setAttribute("student", student);
            RequestDispatcher rd = request.getRequestDispatcher("student-list.jsp");
            rd.forward(request, response);
        }
           List<Student> studentlist = sd.getStudentList();
            
            request.setAttribute("studentlist", studentlist);
            RequestDispatcher rd = request.getRequestDispatcher("student-list.jsp");
            rd.forward(request, response);  
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
