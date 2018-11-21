<%-- 
    Document   : Home
    Created on : May 21, 2017, 8:55:02 PM
    Author     : Avinash Kafle
--%>

<%@page import="com.info.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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
          <li class="selected"><a href="Home.jsp">Home</a></li>
          <li><a href="student-form.jsp">Student Form</a></li>
          <li><a href="StudentServlet">Student List</a></li>
          <li><a href="login.jsp">Log In</a></li>
          <li><a href="contact.jsp">Contact Us</a></li>
          <li><a href="logOut.jsp">Log Out</a></li>
        </ul>
      </div>
    </div>
    <div id="content_header"></div>
    <div id="site_content">
      <div id="banner"></div>
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
        <h1>Welcome to the student information system</h1>
        
        <p>This site provides the information of the student, also provides the authorized user to add , edit, delete the student</p>
        <p>Site can be opened in the following browser</p>
        <ul>
          <li>Internet Explorer </li>
          <li>FireFox </li>
          <li>Google Chrome </li>
          <li>Microsoft Edge </li>
          <li>Opera Menu </li>
          <li>Safari</li>
        </ul>
      </div>
    </div>
        <jsp:include page="footer.jsp"></jsp:include>
        <% }else{
            response.sendRedirect("login.jsp");
}%>
    </body>
</html>
