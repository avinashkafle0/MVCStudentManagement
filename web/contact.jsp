<%-- 
    Document   : contact
    Created on : May 25, 2017, 9:18:00 PM
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
          <li ><a href="Home.jsp">Home</a></li>
          <li><a href="student-form.jsp">Student Form</a></li>
          <li><a href="StudentServlet">Student List</a></li>
          <li><a href="login.jsp">Log In</a></li>
          <li class="selected"><a href="contact.jsp">Contact Us</a></li>
          <li><a href="logOut.jsp">Log Out</a></li>
        </ul>
      </div>
          
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
        <h1>Contact Us</h1>
        <form action="ContactServlet" method="post">
          <div class="form_settings">
              <input type="hidden" name="id" value="<%= validatedUser.getUserId() %>">
            <p><span>Name</span><input class="contact" type="text" name="your_name" value="" /></p>
            <p><span>Email Address</span><input class="contact" type="email" name="your_email" value="" /></p>
            <p><span>Message</span><textarea class="contact textarea" rows="8" cols="50" name="your_enquiry"></textarea></p>
            <p style="padding-top: 15px"><span>&nbsp;</span>
                <input class="submit" type="submit" name="contact_submitted" value="submit" /></p>
          </div> 
        </form>
      </div>
          <% }else{
            response.sendRedirect("login.jsp");
}%>
    </div>
    
    
          <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
