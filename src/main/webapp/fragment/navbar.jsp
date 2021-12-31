<%--
  Created by IntelliJ IDEA.
  User: roby-
  Date: 30/12/2021
  Time: 12:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<nav class="navbar navbar-expand-md navbar-light py-3" aria-label="Main">
    <div class="container">
        <div class="collapse navbar-collapse" id="navbar">
            <div class="navbar-nav mt-3 mt-md-0 ms-auto">
                <%if(session.getAttribute("studente")!=null || session.getAttribute("tutor")!=null || session.getAttribute("professore")!=null){ %>
                <a class="nav-link px-md-3" href="viewservices">Servizi</a>
                <a class="nav-link px-md-3" href="Account">Account</a>
                <a class="nav-link px-md-3" href="../logout">Logout</a>
                <%} else if(session.getAttribute("admin")!=null){ %>
                <a href="AdminPage.jsp">Admin</a>
                <a href="../logout">Logout</a>
                <%} else {%>
                <a href="LoginPage.jsp">Login</a>
                <%}%>
            </div>
        </div>
    </div>
</nav>
