<%-- 
    Document   : teacher-list
    Created on : May 21, 2017, 2:25:12 PM
    Author     : Avinash Kafle
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.info.model.Teacher"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script>
           function ConfirmDelete()
    {
      var x = confirm("Are you sure you want to delete?");
      if (x)
          return true;
      else
        return false;
    }
    
    function ConfirmEdit()
    {
        var y = confirm("Are you sure you want to edit?");
        if(y)
            return true;
        else
            return false;
    }
        </script>
    </head>
    <body>
        <h1>Teacher List</h1>
        <form action="TeacherServlet" method="post">
            <input type="text" name="searchTeacher">   <input type="submit" name="search" value="SEARCH">
        </form>
        <% List<Teacher> teacherlist = (ArrayList)request.getAttribute("teacherlist"); %>
        <table>
            <tr>
                <td>Id</td>
                <td>Name</td>
                <td>Address</td>
                <td colspan="2">Action</td>
            </tr>
            <% for(Teacher teacher: teacherlist){ %>
             <tr>
                 <td><%= teacher.getTeacherId()%></td>
                <td><%= teacher.getTeacherName()%></td>
                <td><%= teacher.getTeacherAddress()%></td>
                <td><a href="TeacherServlet?teacherIdForEdit=<%= teacher.getTeacherId() %>" ><button Onclick="return ConfirmEdit();" type="submit" name="actionedit" value="2"> EDIT </button></a></td>
                <td><a href="TeacherServlet?teacherIdForDelete=<%= teacher.getTeacherId()%>" > <button Onclick="return ConfirmDelete();" type="submit" name="actiondelete" value="1">DELETE </button></a></td>
            </tr>
            <% } %>
        </table>
    </body>
</html>
