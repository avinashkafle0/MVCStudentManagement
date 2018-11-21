<%-- 
    Document   : student-form
    Created on : May 17, 2017, 3:33:29 PM
    Author     : Avinash Kafle
--%>

<%@page import="com.info.model.Faculty"%>
<%@page import="com.info.model.User"%>
<%@page import="com.info.model.Student"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
     <style type="text/css">
.form-style-1 {
    margin:10px auto;
    max-width: 400px;
    padding: 20px 12px 10px 20px;
    font: 13px "Lucida Sans Unicode", "Lucida Grande", sans-serif;
}
.form-style-1 li {
    padding: 0;
    display: block;
    list-style: none;
    margin: 10px 0 0 0;
}
.form-style-1 label{
    margin:0 0 3px 0;
    padding:0px;
    display:block;
    font-weight: bold;
}
.form-style-1 input[type=text],
.form-style-1 input[type=date],
.form-style-1 input[type=datetime],
.form-style-1 input[type=number],
.form-style-1 input[type=search],
.form-style-1 input[type=time],
.form-style-1 input[type=url],
.form-style-1 input[type=email],
textarea,
select{
    box-sizing: border-box;
    -webkit-box-sizing: border-box;
    -moz-box-sizing: border-box;
    border:1px solid #BEBEBE;
    padding: 7px;
    margin:0px;
    -webkit-transition: all 0.30s ease-in-out;
    -moz-transition: all 0.30s ease-in-out;
    -ms-transition: all 0.30s ease-in-out;
    -o-transition: all 0.30s ease-in-out;
    outline: none; 
}
.form-style-1 input[type=text]:focus,
.form-style-1 input[type=date]:focus,
.form-style-1 input[type=datetime]:focus,
.form-style-1 input[type=number]:focus,
.form-style-1 input[type=search]:focus,
.form-style-1 input[type=time]:focus,
.form-style-1 input[type=url]:focus,
.form-style-1 input[type=email]:focus,
.form-style-1 textarea:focus,
.form-style-1 select:focus{
    -moz-box-shadow: 0 0 8px #88D5E9;
    -webkit-box-shadow: 0 0 8px #88D5E9;
    box-shadow: 0 0 8px #88D5E9;
    border: 1px solid #88D5E9;
}
.form-style-1 .field-divided{
    width: 49%;
}

.form-style-1 .field-long{
    width: 100%;
}
.form-style-1 .field-select{
    width: 100%;
}
.form-style-1 .field-textarea{
    height: 100px;
}
.form-style-1 input[type=submit], .form-style-1 input[type=button]{
    background: #4B99AD;
    padding: 8px 15px 8px 15px;
    border: none;
    color: #fff;
}
.form-style-1 input[type=submit]:hover, .form-style-1 input[type=button]:hover{
    background: #4691A4;
    box-shadow:none;
    -moz-box-shadow:none;
    -webkit-box-shadow:none;
}
.form-style-1 .required{
    color:red;
}
</style>
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
          <li  class="selected"><a href="student-form.jsp">Student Form</a></li>
          <li><a href="StudentServlet">Student List</a></li>
          <li><a href="login.jsp">Log In</a></li>
          <li><a href="contact.jsp">Contact Us</a></li>
          <li><a href="logOut.jsp">Log Out</a></li>
        </ul>
      </div>
    </div>
        <%
            Student student = (Student)request.getAttribute("student");
            if(student == null){
               student= new Student();
               student.setStudentId(0);
               student.setStudentName("");
               student.setStudentAddress("");
            }
        %>
        <div id="content_header"></div>
    <div id="site_content">
      <div id="sidebar_container">
        <div class="sidebar">
          <div class="sidebar_top"></div>
          <div class="sidebar_item">
            <!-- insert your sidebar items here -->
            <h3>Latest News</h3>
            <h4>New Website Launched</h4>
            <h5>June 1st, 2014</h5>
            <p>2014 sees the redesign of our website. Take a look around and let us know what you think.<br /><a href="#">Read more</a></p>
          </div>
          <div class="sidebar_base"></div>
        </div>
        <div class="sidebar">
          <div class="sidebar_top"></div>
          <div class="sidebar_item">
            <h3>Useful Links</h3>
            <ul>
              <li><a href="#">link 1</a></li>
              <li><a href="#">link 2</a></li>
              <li><a href="#">link 3</a></li>
              <li><a href="#">link 4</a></li>
            </ul>
          </div>
          <div class="sidebar_base"></div>
        </div>
        <div class="sidebar">
          <div class="sidebar_top"></div>
          <div class="sidebar_item">
            <h3>Search</h3>
            <form method="post" action="#" id="search_form">
              <p>
                <input class="search" type="text" name="search_field" value="Enter keywords....." />
                <input name="search" type="image" style="border: 0; margin: 0 0 -9px 5px;" src="style/search.png" alt="Search" title="Search" />
              </p>
            </form>
          </div>
          <div class="sidebar_base"></div>
        </div>
      </div>
      <div id="content">
        <!-- insert the page content here -->
              <div id="content">
          <form action="StudentServlet" method="post" enctype="multipart/form-data">
               <input type="hidden" name="studentId" value="<%= student.getStudentId()%>">
<ul class="form-style-1">
    <li><label>Student Name <span class="required">*</span></label><input type="text" name="studentName" class="field-divided" value="<%= student.getStudentName()%>" /></li>
    <li>
        <label>Student Address<span class="required">*</span></label>
        <input type="text" name="studentAddress" class="field-divided" value= "<%= student.getStudentAddress() %> " />
    </li>

    <li>
        <label>Student Image<span class="required">*</span></label>
        <input type="file" name="studentImage" />
    </li>
    
    <li>
        <%if(student.getStudentId() == 0){ %>
            <input type="submit" value="SUBMIT" name="add" >
            <%}else{ %>
            <input type="submit" value="UPDATE" name="update">
            <% }%>
    </li>
</ul>
</form>
      </div>
       
      </div>
    </div>
        
        <% }else{
            response.sendRedirect("login.jsp");
}%>
<jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
