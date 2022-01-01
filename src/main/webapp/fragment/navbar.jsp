<%@ page import="model.bean.UserBean" %><%--
  Created by IntelliJ IDEA.
  User: roby-
  Date: 30/12/2021
  Time: 12:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%UserBean user = (UserBean) session.getAttribute("utente");%>
<nav class="navbar navbar-expand-lg navbar-light fixed-top shadow-sm" id="mainNav">
    <div class="container px-5">
        <a class="navbar-brand fw-bold" href="#page-top">EasyAid</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarResponsive"
                aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            Menu
            <i class="bi-list"></i>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ms-auto me-4 my-3 my-lg-0">
                <li class="nav-item"><a class="nav-link me-lg-3" href="HomePage.jsp">Home</a></li>
                <%
                    if (user != null) {
                        if (user.isPersonaleAmministrativo()) {
                %>

                <li class="nav-item"><a class="nav-link me-lg-3" href="AdminPage.jsp">Admin</a></li>
                <%} else {%>
                <li class="nav-item"><a class="nav-link me-lg-3" href="viewservices">Servizi</a></li>
                <li class="nav-item"><a class="nav-link me-lg-3" href="UserPage.jsp">Account</a></li>
                <li class="nav-item"><a class="nav-link me-lg-3" href="../logout">Logout</a></li>
                <%
                    }
                } else {
                %>
                <li class="nav-item"><a class="nav-link me-lg-3" href="LoginPage.jsp">Login</a></li>
                <%}%>
            </ul>
        </div>
    </div>
</nav>
