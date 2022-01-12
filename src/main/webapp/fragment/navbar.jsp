<%@ page import="model.bean.UserBean" %><%--
  Created by IntelliJ IDEA.
  User: roby-
  Date: 30/12/2021
  Time: 12:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    UserBean user = (UserBean) session.getAttribute("utente");
    String alert= (String) session.getAttribute("alertMsg");
%>
<!-- Logo Nav START -->
<nav class="navbar navbar-expand-xl">
    <div class="container-fluid px-3 px-xl-5">
        <!-- Logo START -->
        <a class="navbar-brand pt-0 pb-0 w-50" href="#">
            <img style="width: auto !important; height:60px !important;" src="../image/PS-LOGO-DEFINITIVO-2.png"
                 alt="logo">
        </a>
        <!-- Logo END -->

        <!-- Responsive navbar toggler -->
        <button class="navbar-toggler ms-auto" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse"
                aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
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
                    <a class="nav-link active text-black" href="HomePage.jsp" id="demoMenu" aria-haspopup="true"
                       aria-expanded="false">Home</a>
                </li>
                <%
                    if (user != null) {
                %>
                <!-- Nav Servizi -->
                <li class="nav-item dropdown">
                    <%if (!user.isPersonaleAmministrativo()) {%>
                    <a class="nav-link text-black" href="#" id="pagesMenu" data-bs-toggle="dropdown"
                       aria-haspopup="true" aria-expanded="false">Servizi</a>
                    <ul class="dropdown-menu" aria-labelledby="pagesMenu">
                        <% if (user.isStudente()) {%>
                        <li><a class="dropdown-item text-black" href="RichiediServizioPage.jsp">Richiedi Servizio</a>
                        </li>
                        <li><a class="dropdown-item text-black" href="../ListaRichieste">Elenco Richieste</a></li>
                        <li><a class="dropdown-item text-black" href="../LezioniServlet">Elenco Lezioni</a></li>
                        <%} else if (user.isTutor()) {%>
                        <li><a class="dropdown-item text-black" href="../viewRichiesteServizio">Bacheca Richieste</a>
                        </li>
                        <li><a class="dropdown-item text-black" href="../viewRichiesteAccettate">Elenco Richieste
                            Accettate</a></li>
                        <li><a class="dropdown-item text-black" href="../LezioniServlet">Elenco Lezioni</a></li>
                        <%} else if (user.isProfessoreReferente()) {%>
                        <li><a class="dropdown-item text-black" href="../viewRichiesteCompletate">Richieste da
                            Approvare</a></li>
                        <%}%>
                    </ul>
                    <% } else {%>
                    <a class="nav-link text-black" href="#" id="pagesMenu" data-bs-toggle="dropdown"
                       aria-haspopup="true" aria-expanded="false">Management</a>
                    <ul class="dropdown-menu" aria-labelledby="pagesMenu">
                        <li><a class="dropdown-item text-black" href="../ViewListaUsers">Elenco Utenti</a></li>
                    </ul>
                    <%}%>
                </li>
                <!-- Nav About -->
                <li class="nav-item">
                    <a class="nav-link text-black" href="#" id="demoMenu" aria-haspopup="true" aria-expanded="false">About</a>
                </li>
                <!-- Nav Nome Cognome -->
                <li class="nav-item">
                    <a class="nav-link text-black" href="#" id="demoMenu" aria-haspopup="true"
                       aria-expanded="false"><%=user.getNome() + " " + user.getCognome()%>
                    </a>
                </li>
                <%} else {%>
                <li class="nav-item">
                    <a class="nav-link text-black text-black" href="LoginPage.jsp" id="demoMenu" aria-haspopup="true"
                       aria-expanded="false">Login</a>
                </li>
                <%}%>
            </ul>
            <!-- Nav Main menu END -->

        </div>
        <!-- Main navbar END -->
        <%if (user != null) {%>
        <!-- Profile START -->
        <div class="dropdown ms-1 ms-lg-0">
            <a class="avatar avatar-sm p-0 text-black" href="#" id="profileDropdown" role="button"
               data-bs-auto-close="outside" data-bs-display="static" data-bs-toggle="dropdown" aria-expanded="false">
                <% if (user.isProfessoreReferente()) { %>
                <div class="avatar-img rounded-circle bg-warning"><span
                        class="text-white position-absolute top-50 start-50 translate-middle fw-bold"><%=user.getNome().substring(0, 1) + user.getCognome().substring(0, 1)%></span>
                </div>
                <%} else if (user.isStudente()) {%>
                <div class="avatar-img rounded-circle bg-info"><span
                        class="text-white position-absolute top-50 start-50 translate-middle fw-bold"><%=user.getNome().substring(0, 1) + user.getCognome().substring(0, 1)%></span>
                </div>
                <%} else if (user.isTutor()) {%>
                <div class="avatar-img rounded-circle bg-success"><span
                        class="text-white position-absolute top-50 start-50 translate-middle fw-bold"><%=user.getNome().substring(0, 1) + user.getCognome().substring(0, 1)%></span>
                </div>
                <%} else if (user.isPersonaleAmministrativo()) {%>
                <div class="avatar-img rounded-circle bg-blue"><span
                        class="text-white position-absolute top-50 start-50 translate-middle fw-bold"><%=user.getNome().substring(0, 1) + user.getCognome().substring(0, 1)%></span>
                </div>
                <%}%>
            </a>
            <ul class="dropdown-menu dropdown-animation dropdown-menu-end shadow pt-3"
                aria-labelledby="profileDropdown">
                <!-- Profile info -->
                <li class="px-3">
                    <div class="d-flex align-items-center">
                        <!-- Avatar -->
                        <div class="avatar me-3">
                            <% if (user.isProfessoreReferente()) { %>
                            <div class="avatar-img rounded-circle bg-warning"><span
                                    class="text-white position-absolute top-50 start-50 translate-middle fw-bold"><%=user.getNome().substring(0, 1) + user.getCognome().substring(0, 1)%></span>
                            </div>
                            <%} else if (user.isStudente()) {%>
                            <div class="avatar-img rounded-circle bg-info"><span
                                    class="text-white position-absolute top-50 start-50 translate-middle fw-bold"><%=user.getNome().substring(0, 1) + user.getCognome().substring(0, 1)%></span>
                            </div>
                            <%} else if (user.isTutor()) {%>
                            <div class="avatar-img rounded-circle bg-success"><span
                                    class="text-white position-absolute top-50 start-50 translate-middle fw-bold"><%=user.getNome().substring(0, 1) + user.getCognome().substring(0, 1)%></span>
                            </div>
                            <%} else if (user.isPersonaleAmministrativo()) {%>
                            <div class="avatar-img rounded-circle bg-blue"><span
                                    class="text-white position-absolute top-50 start-50 translate-middle fw-bold"><%=user.getNome().substring(0, 1) + user.getCognome().substring(0, 1)%></span>
                            </div>
                            <%}%>
                        </div>
                        <div>
                            <a class="h6 text-black" href="#"><%=user.getNome() + " " + user.getCognome()%>
                            </a>
                            <p class="small m-0 text-black"><%=user.getEmail()%>
                            </p>
                        </div>
                    </div>
                    <hr>
                </li>
                <!-- Links -->
                <li><a class="dropdown-item text-black" href="ProfiloPage.jsp"><i class="bi fa-fw me-2"></i>Account
                    Settings</a></li>
                <li><a class="dropdown-item bg-danger-soft-hover text-black" href="../logout"><i
                        class="bi fa-fw me-2"></i>Logout</a></li>
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