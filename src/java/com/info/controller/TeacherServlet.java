/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.info.controller;

import com.info.dao.TeacherDao;
import com.info.model.Teacher;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Avinash Kafle
 */
@WebServlet(name = "TeacherServlet", urlPatterns = {"/TeacherServlet"})
public class TeacherServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            TeacherDao td = new TeacherDao();
            if(request.getParameter("add")!= null){
            String name = request.getParameter("teacherName");
            String address = request.getParameter("teacherAddress");
            
            Teacher teacher = new Teacher();
            teacher.setTeacherName(name);
            teacher.setTeacherAddress(address);
            
            td.insertTeacher(teacher);
            
            List<Teacher> teacherlist = td.getTeacherList();
            
            request.setAttribute("teacherlist", teacherlist);
            RequestDispatcher rd = request.getRequestDispatcher("teacher-list.jsp");
            rd.forward(request, response);
            
//            response.sendRedirect("student-list.jsp");
            }else if(request.getParameter("teacherIdForDelete")!= null){
                int teacherId = Integer.parseInt(request.getParameter("teacherIdForDelete"));
                td.deleteTeacher(teacherId);
                
                List<Teacher> teacherlist = td.getTeacherList();
                
                request.setAttribute("teacherlist", teacherlist);
                RequestDispatcher rd = request.getRequestDispatcher("teacher-list.jsp");
                rd.forward(request, response);
            }else if(request.getParameter("teacherIdForEdit")!= null){
                int teacherId = Integer.parseInt(request.getParameter("teacherIdForEdit"));
                Teacher teacher = td.getTeacher(teacherId);
                
                request.setAttribute("teacher", teacher);
                RequestDispatcher rd = request.getRequestDispatcher("teacher-form.jsp");
                rd.forward(request, response);
            }else if(request.getParameter("update")!=null){
                int teacherId =Integer.parseInt(request.getParameter("teacherId"));
                String teacherName = request.getParameter("teacherName");
                String teacherAddress = request.getParameter("teacherAddress");
                
                Teacher teacher = new Teacher();
                
                teacher.setTeacherId(teacherId);
                teacher.setTeacherName(teacherName);
                teacher.setTeacherAddress(teacherAddress);
                
                td.updateTeacher(teacher);
                
                List <Teacher> teacherlist = td.getTeacherList();
                
                request.setAttribute("teacherlist", teacherlist);
                RequestDispatcher rd = request.getRequestDispatcher("teacher-list.jsp");
                rd.forward(request, response);
            }else if(request.getParameter("search")!=null){
                List<Teacher> teacherlist = td.getTeacherList(request.getParameter("searchTeacher"));
                
                request.setAttribute("teacherlist", teacherlist);
                RequestDispatcher rd = request.getRequestDispatcher("teacher-list.jsp");
                rd.forward(request, response);
            }else{
                List <Teacher> teacherlist = td.getTeacherList();
                
                request.setAttribute("teacherlist", teacherlist);
                RequestDispatcher rd = request.getRequestDispatcher("teacher-list.jsp");
                rd.forward(request, response);
            }
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
