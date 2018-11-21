<%-- 
    Document   : teacher-form
    Created on : May 18, 2017, 2:23:17 PM
    Author     : Avinash Kafle
--%>

<%@page import="com.info.model.Teacher"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>"Teacher Form"</h1>
        <% Teacher teacher = (Teacher)request.getAttribute("teacher"); 
        
        if(teacher== null){
            teacher = new Teacher();
            teacher.setTeacherId(0);
            teacher.setTeacherName("");
            teacher.setTeacherAddress("");
        }
        
        %>
        
        
        <form action="TeacherServlet" method="get">
            <input type="hidden" name="teacherId" value="<%=teacher.getTeacherId()%>">
            Teacher Name: <input type="text" name="teacherName" value="<%=teacher.getTeacherName()%>">
            Teacher Address: <input type="text" name="teacherAddress" value="<%= teacher.getTeacherAddress()%>">
            <input type="file" name="Image" value="<%= teacher.get%>"
            <%if(teacher.getTeacherId()==0){ %>
            <input type="submit" value="SUBMIT" name="add">
             <%}else{ %>
            <input type="submit" value="UPDATE" name ="update">
             <% }%>
        </form>
    </body>
</html>
