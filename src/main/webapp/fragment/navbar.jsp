<%--
  Created by IntelliJ IDEA.
  User: roby-
  Date: 30/12/2021
  Time: 12:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%if(session.getAttribute("utente")!=null || session.getAttribute("tutor")!=null || session.getAttribute("professore")!=null){ %>
<a href="Home.jsp">Home</a>
<a href="viewServices.jsp">Servizi</a>
<a href="UserPage.jsp">Account</a>
<a href="../logout">Logout</a>
<%} else if(session.getAttribute("admin")!=null){ %>
<a href="AdminPage.jsp">Admin</a>
<a href="../logout">Logout</a>
<%} else {%>
<a href="LoginPage.jsp">Login</a>
<%}%>

