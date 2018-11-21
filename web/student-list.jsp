<%-- 
    Document   : student-list
    Created on : May 17, 2017, 3:35:26 PM
    Author     : Avinash Kafle
--%>

<%@page import="com.info.model.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.info.model.Student"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <style type="text/css">
        .cenTab{
           margin-left: 40px;
        }
        .righ{
            margin-top: 300px;
            margin-right: 300px;
            position:absolute;
            top:0;
            right:0;
            float: right;
        }
    </style>
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
<jsp:include page="header.jsp"></jsp:include>
    
    <body>
        <%
            User validatedUser = (User)session.getAttribute("validatedUser");
            
            if(validatedUser!= null){
            %>
            
        <div id="main">
    <div id="header">
      <div id="logo">
        <div id="logo_text">
          <!-- class="logo_colour", allows you to change the colour of the text -->
          <h1><a href="Home.jsp">STUDENT_<span class="logo_colour">WEBSITE</span></a></h1>
          <h2>Welcome   <strong><%= validatedUser.getUserName()%> </strong></h2>
        </div>
      </div>
          <div id="menubar">
        <ul id="menu">
          <!-- put class="selected" in the li tag for the selected page - to highlight which page you're on -->
          <li><a href="Home.jsp">Home</a></li>
          <li><a href="student-form.jsp">Student Form</a></li>
          <li  class="selected"><a href="StudentServlet">Student List</a></li>
          <li><a href="login.jsp">Log In</a></li>
          <li><a href="contact.jsp">Contact Us</a></li>
          <li><a href="logOut.jsp">Log Out</a></li>
        </ul>
      </div>
    </div>
    <br>
        <form action="StudentServlet" method="post" class="cenTab">
            <input type="text" name="searchStudent"><input type="submit" value="SEARCH" name="search">
        </form>
        <br>
        <h1 class="cenTab">Student List</h1>
        <% List<Student> studentlist = (ArrayList)request.getAttribute("studentlist");%>
        <table class="cenTab">
            <tr>
                <td>ID</td>
                <td>Name</td>
                <td>Address</td>
                <td>Image</td>
                <td colspan="3">Action</td>
            </tr>
            <%for(Student student: studentlist){ %>
             <tr>
                 <td><%= student.getStudentId() %></td>
                <td><%= student.getStudentName() %></td>
                <td><%= student.getStudentAddress() %></td>
                <td><img src="RetrieveImage?studentId=<%=student.getStudentId()%>" alt="" width="100" height="90"></td>
                <td><a href="StudentServlet?studentIdForEdit=<%=student.getStudentId() %>"><button Onclick="return ConfirmEdit();" type="submit" name="actionedit" value="2"> EDIT </button></td>
                <td><a href="StudentServlet?studentIdForDelete=<%=student.getStudentId() %>"> <button Onclick="return ConfirmDelete();" type="submit" name="actiondelete" value="1">DELETE </button></td>
                <td><a href="StudentServlet?studentIdForDetail=<%=student.getStudentId() %>">Detail</td>
            </tr>
            <% }%>
        </table>
        
        <table class="righ">
            <%
                Student studentDetail = (Student)request.getAttribute("student");
                if(studentDetail!=null){
            %>
            <tr>
                <td colspan="2">
            <img src="RetrieveImage?studentId=<%=studentDetail.getStudentId()%>" width="300" height="200" alt="Student Picture">
                </td>
            </tr>
            <tr>
                <td> Name: </td>
                <td><%= studentDetail.getStudentName()%> </td>
            </tr>
            <tr>
                <td>Address:</td>
                <td><%= studentDetail.getStudentAddress()%> </td>
            </tr>
            
        <%}%>
        
          <% }else{
            response.sendRedirect("login.jsp");
}%>
        </table>
<jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
