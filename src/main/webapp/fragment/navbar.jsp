<%@ page import="model.bean.UserBean" %><%--
  Created by IntelliJ IDEA.
  User: roby-
  Date: 30/12/2021
  Time: 12:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%UserBean user = (UserBean) session.getAttribute("utente");%>
<!-- Logo Nav START -->
<nav class="navbar navbar-expand-xl">
    <div class="container-fluid px-3 px-xl-5">
        <!-- Logo START -->
        <a class="navbar-brand" href="#">
            <img class="light-mode-item navbar-brand-item" src="../image/PS-LOGO-DEFINITIVO-2.png" alt="logo">
        </a>
        <!-- Logo END -->

        <!-- Responsive navbar toggler -->
        <button class="navbar-toggler ms-auto" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-animation">
					<span></span>
					<span></span>
					<span></span>
				</span>
        </button>

        <!-- Main navbar START -->
        <div class="navbar-collapse w-100 collapse" id="navbarCollapse">

            <!-- Nav category menu START -->
            <ul class="navbar-nav navbar-nav-scroll me-auto">
            </ul>
            <!-- Nav category menu END -->

            <!-- Nav Main menu START -->
            <ul class="navbar-nav navbar-nav-scroll me-5">
                <!-- Nav Home -->
                <li class="nav-item">
                    <a class="nav-link active" href="HomePage.jsp" id="demoMenu" aria-haspopup="true" aria-expanded="false">Home</a>
                </li>
                <%if(user!=null){%>
                <!-- Nav Servizi -->
                <li class="nav-item dropdown">

                    <a class="nav-link " href="#" id="pagesMenu" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Servizi</a>
                    <ul class="dropdown-menu" aria-labelledby="pagesMenu">
                        <%if(!user.isPersonaleAmministrativo()){%>
                        <li> <a class="dropdown-item" href="RichiediServizioPage.jsp">Richiedi Servizio</a></li>
                        <li> <a class="dropdown-item" href="../ListaRichieste">Elenco Richieste</a></li>
                        <%}else{%>
                        <li> <a class="dropdown-item" href="../admin">Management</a></li>
                        <%}%>
                    </ul>
                </li>
                <!-- Nav About -->
                <li class="nav-item">
                    <a class="nav-link" href="#" id="demoMenu" aria-haspopup="true" aria-expanded="false">About</a>
                </li>
                <!-- Nav Nome Cognome -->
                <li class="nav-item">
                    <a class="nav-link" href="#" id="demoMenu" aria-haspopup="true" aria-expanded="false"><%=user.getNome()+" "+user.getCognome()%></a>
                </li>
                <%}else{%>
                <li class="nav-item">
                    <a class="nav-link" href="LoginPage.jsp" id="demoMenu" aria-haspopup="true" aria-expanded="false">Login</a>
                </li>
                <%}%>
            </ul>
            <!-- Nav Main menu END -->

        </div>
        <!-- Main navbar END -->
    <%if(user!=null){%>
        <!-- Profile START -->
        <div class="dropdown ms-1 ms-lg-0">
            <a class="avatar avatar-sm p-0" href="#" id="profileDropdown" role="button" data-bs-auto-close="outside" data-bs-display="static" data-bs-toggle="dropdown" aria-expanded="false">
                <div class="avatar-img rounded-circle bg-info"><span class="text-white position-absolute top-50 start-50 translate-middle fw-bold"><%=user.getNome().substring(0,1)+user.getCognome().substring(0,1)%></span></div>
            </a>
            <ul class="dropdown-menu dropdown-animation dropdown-menu-end shadow pt-3" aria-labelledby="profileDropdown">
                <!-- Profile info -->
                <li class="px-3">
                    <div class="d-flex align-items-center">
                        <!-- Avatar -->
                        <div class="avatar me-3">
                            <div class="avatar-img rounded-circle bg-info"><span class="text-white position-absolute top-50 start-50 translate-middle fw-bold"><%=user.getNome().substring(0,1)+user.getCognome().substring(0,1)%></span></div>
                        </div>
                        <div>
                            <a class="h6" href="#"><%=user.getNome()+" "+user.getCognome()%></a>
                            <p class="small m-0"><%=user.getEmail()%></p>
                        </div>
                    </div>
                    <hr>
                </li>
                <!-- Links -->
                <li><a class="dropdown-item" href="ProfilePage.jsp"><i class="bi fa-fw me-2"></i>Account Settings</a></li>
                <li><a class="dropdown-item bg-danger-soft-hover" href="../logout"><i class="bi fa-fw me-2"></i>Logout</a></li>
                <li>
                    <hr class="dropdown-divider">
                </li>
            </ul>
        </div>
        <!-- Profile START -->
        <%}%>
    </div>
</nav>
<!-- Logo Nav END -->