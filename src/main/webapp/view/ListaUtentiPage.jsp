<%@ page import="model.bean.UserBean" %><%--
  Created by IntelliJ IDEA.
  User: Giovanni Toriello
  Date: 28/12/2021
  Time: 21:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" import="model.bean.UserBean" %>
<%@ page import="java.util.Collection" %>
<% if(session.getAttribute("utente")==null){
    response.sendRedirect("./LoginPage.jsp");
    return;
}
%>
<%
    Collection<UserBean> utenti = (Collection<UserBean>) session.getAttribute("usrList");
    int studenti = 0;
    int tutor = 0;
    int professori = 0;
    int users = 0;
    if (utenti == null) {
        response.sendRedirect("../ViewListaUsers");
        return;
    }
    for (UserBean s : utenti) {
        if (!s.isPersonaleAmministrativo())
            users++;
        if (s.isTutor()) {
            tutor++;
        } else if (s.isStudente()) {
            studenti++;
        } else if (s.isProfessoreReferente()) {
            professori++;
        }
    }
%>
<!DOCTYPE html>
<html lang="it">
<head>
    <title>EasyAid</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="author" content="Webestica.com">
    <meta name="description" content="Eduport- LMS, Education and Course Theme">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3mipmap34MD+dH/1fQ784/j6cY/iQUITOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="shortcut icon" href="../image/favicon.ico">

    <!-- Google Font -->
    <link rel="preconnect" href="https://fonts.googleapis.com/%22%3E">
    <link rel="preconnect" href="https://fonts.gstatic.com/" crossorigin="">
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css2?family=Heebo:wght@400;500;700&amp;family=Roboto:wght@400;500;700&amp;display=swap%22%3E">

    <!-- Plugins CSS -->
    <link rel="stylesheet" type="text/css" href="../assets/vendor/font-awesome/css/all.min.css">
    <link rel="stylesheet" type="text/css" href="../assets/vendor/bootstrap-icons/bootstrap-icons.css">
    <link rel="stylesheet" type="text/css" href="../assets/vendor/tiny-slider/tiny-slider.css">
    <link rel="stylesheet" type="text/css" href="../assets/vendor/glightbox/css/glightbox.css">

    <!-- Theme CSS -->
    <link rel="stylesheet" type="text/css" href="../assets/css/style.css">
    <!-- Global site tag (gtag.js) - Google Analytics -->
    <script async="" src="https://www.googletagmanager.com/gtag/js?id=G-7N7LGGGWT1%22%3E"></script>
</head>
<body>
<header>
    <%@ include file="../fragment/navbar.jsp" %>
</header>
<main role="main">
    <section class="pt-0">
        <%@ include file="../fragment/UserSection.jsp" %>
    </section>
    <section class="pt-0">
        <div class="container">
            <div class="row">
                <!-- Dashboard Laterale -->
                <div class="col-3">
                    <br>
                    <%@ include file="../fragment/DashboardAdmin.jsp" %>
                    <!-- Responsive offcanvas body END -->
                </div>
                <div class="col-9">
                    <br>
                    <div class="page-content-wrapper border rounded-3">
                        <div class="container">
                            <div class="card bg-transparent">
                                <div class="row">
                                    <div class="col-12">
                                        <br>
                                        <h1 class="h3 mb-2 mb-sm-0">Utenti della piattaforma</h1>
                                        <br>
                                    </div>
                                </div>
                                <div class="row g-4 mb-4">
                                    <div class="col-md-6 col-xxl-3">
                                        <div class="card card-body bg-danger bg-opacity-25 p-4 h-100">
                                            <div class="d-flex justify-content-between align-items-center">
                                                <!-- Utenti -->
                                                <div>
                                                    <h2 class="purecounter mb-0 fw-bold" data-purecounter-start="0"
                                                        data-purecounter-end="1600"
                                                        data-purecounter-delay="200"
                                                        data-purecounter-duration="0"><%=users%>
                                                    </h2>
                                                    <span class="mb-0 h6 fw-light">Utenti</span>
                                                </div>
                                                <!-- Icon -->
                                                <div class="icon-lg rounded-circle bg-instagram text-white mb-0">
                                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-people-fill mt-3" viewBox="0 0 16 16">
                                                        <path d="M7 14s-1 0-1-1 1-4 5-4 5 3 5 4-1 1-1 1H7zm4-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6z"></path>
                                                        <path fill-rule="evenodd" d="M5.216 14A2.238 2.238 0 0 1 5 13c0-1.355.68-2.75 1.936-3.72A6.325 6.325 0 0 0 5 9c-4 0-5 3-5 4s1 1 1 1h4.216z"></path>
                                                        <path d="M4.5 8a2.5 2.5 0 1 0 0-5 2.5 2.5 0 0 0 0 5z"></path>
                                                    </svg>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-6 col-xxl-3">
                                        <div class="card card-body bg-primary bg-opacity-10 p-4 h-100">
                                            <div class="d-flex justify-content-between align-items-center">
                                                <!-- Studenti -->
                                                <div>
                                                    <h2 class="purecounter mb-0 fw-bold" data-purecounter-start="0"
                                                        data-purecounter-end="1235"
                                                        data-purecounter-delay="200"
                                                        data-purecounter-duration="0"><%=studenti%>
                                                    </h2>
                                                    <span class="mb-0 h6 fw-light">Studenti</span>
                                                </div>
                                                <!-- Cerchi -->
                                                <div class="icon-lg rounded-circle bg-primary text-white mb-0">
                                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pen-fill mt-3" viewBox="0 0 16 16">
                                                        <path d="m13.498.795.149-.149a1.207 1.207 0 1 1 1.707 1.708l-.149.148a1.5 1.5 0 0 1-.059 2.059L4.854 14.854a.5.5 0 0 1-.233.131l-4 1a.5.5 0 0 1-.606-.606l1-4a.5.5 0 0 1 .131-.232l9.642-9.642a.5.5 0 0 0-.642.056L6.854 4.854a.5.5 0 1 1-.708-.708L9.44.854A1.5 1.5 0 0 1 11.5.796a1.5 1.5 0 0 1 1.998-.001z"></path>
                                                    </svg>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-6 col-xxl-3">
                                        <div class="card card-body bg-success bg-opacity-10 p-4 h-100">
                                            <div class="d-flex justify-content-between align-items-center">
                                                <!-- Tutor -->
                                                <div>
                                                    <div class="d-flex">
                                                        <h2 class="purecounter mb-0 fw-bold" data-purecounter-start="0"
                                                            data-purecounter-end="845" data-purecounter-delay="200"
                                                            data-purecounter-duration="0"><%=tutor%>
                                                        </h2>
                                                    </div>
                                                    <span class="mb-0 h6 fw-light">Tutor</span>
                                                </div>
                                                <!-- Icon -->
                                                <div class="icon-lg rounded-circle bg-success text-white mb-0">
                                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-mortarboard-fill mt-3" viewBox="0 0 16 16">
                                                        <path d="M8.211 2.047a.5.5 0 0 0-.422 0l-7.5 3.5a.5.5 0 0 0 .025.917l7.5 3a.5.5 0 0 0 .372 0L14 7.14V13a1 1 0 0 0-1 1v2h3v-2a1 1 0 0 0-1-1V6.739l.686-.275a.5.5 0 0 0 .025-.917l-7.5-3.5Z"></path>
                                                        <path d="M4.176 9.032a.5.5 0 0 0-.656.327l-.5 1.7a.5.5 0 0 0 .294.605l4.5 1.8a.5.5 0 0 0 .372 0l4.5-1.8a.5.5 0 0 0 .294-.605l-.5-1.7a.5.5 0 0 0-.656-.327L8 10.466 4.176 9.032Z"></path>
                                                    </svg>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-6 col-xxl-3">
                                        <div class="card card-body bg-warning bg-opacity-10 p-4 h-100">
                                            <div class="d-flex justify-content-between align-items-center">
                                                <!-- Tutor -->
                                                <div>
                                                    <div class="d-flex">
                                                        <h2 class="purecounter mb-0 fw-bold" data-purecounter-start="0"
                                                            data-purecounter-end="845" data-purecounter-delay="200"
                                                            data-purecounter-duration="0"><%=professori%>
                                                        </h2>
                                                    </div>
                                                    <span class="mb-0 h6 fw-light">Professori</span>
                                                </div>
                                                <!-- Icon -->
                                                <div class="icon-lg rounded-circle bg-warning text-white mb-0">
                                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-bookmark-check-fill mt-3" viewBox="0 0 16 16">
                                                        <path fill-rule="evenodd" d="M2 15.5V2a2 2 0 0 1 2-2h8a2 2 0 0 1 2 2v13.5a.5.5 0 0 1-.74.439L8 13.069l-5.26 2.87A.5.5 0 0 1 2 15.5zm8.854-9.646a.5.5 0 0 0-.708-.708L7.5 7.793 6.354 6.646a.5.5 0 1 0-.708.708l1.5 1.5a.5.5 0 0 0 .708 0l3-3z"></path>
                                                    </svg>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="card-header bg-transparent border-bottom px-0">
                                    <!-- Search and select START -->
                                    <div class="row g-3 align-items-center justify-content-between">

                                        <!-- Search bar -->
                                        <div class="col-md-5">
                                            <input class="form-control bg-transparent" type="search" id="searchUser" onkeyup="searchUserTable()"
                                                       placeholder="Search"
                                                   aria-label="Search"></div>
                                        <div class="col-md-7">
                                                <button class="btn bg-transparent top"
                                                        type="submit"><i class="bi bi-search"></i></button></div>
                                        </div>

                                        <!-- Tab button -->
                                        <div class="col-xl-11">
                                            <!-- Tabs START -->
                                            <ul class="list-inline mb-0 nav nav-pills nav-pill-dark-soft border-0 justify-content-end"
                                                id="pills-tab" role="tablist">
                                                <!-- Grid tab -->
                                                <li class="nav-item">
                                                    <a href="#nav-preview-tab-1" class="nav-link mb-0 me-2"
                                                       data-bs-toggle="tab">
                                                        <i class="bi bi-table"></i>
                                                    </a>
                                                </li>
                                                <!-- List tab -->
                                                <li class="nav-item">
                                                    <a href="#nav-html-tab-1" class="nav-link mb-0 active"
                                                       data-bs-toggle="tab">
                                                        <i class="bi bi-list"></i>
                                                    </a>
                                                </li>
                                            </ul>
                                            <!-- Tabs end -->
                                        </div>
                                    </div>
                                    <!-- Search and select END -->
                                </div>
                                <!-- Card header END -->

                                <!-- Card body START -->
                                <div class="card-body px-0 overflow-auto">

                                    <!-- Tabs content START -->
                                    <div class="tab-content">

                                        <!-- Tabs content item START -->
                                        <div class="tab-pane fade" id="nav-preview-tab-1">
                                            <div class="row g-4">
                                                <%
                                                    for (UserBean b : utenti) {
                                                        if (!b.isPersonaleAmministrativo()) {
                                                            String nome = "" + b.getNome() + " " + b.getCognome();
                                                            String ruoloUsr = b.getRuolo();
                                                            String iniziale = b.getNome().charAt(0) + b.getCognome().substring(0, 1);
                                                            switch (ruoloUsr) {
                                                                case "S" : ruoloUsr = "Studente"; break;
                                                                case "T" : ruoloUsr = "Tutor"; break;
                                                                case "P" : ruoloUsr = "Professore Referente"; break;
                                                            }
                                                %>
                                                <!-- Card item START -->
                                                <div class="col-md-6 col-xxl-4">

                                                    <div class="card bg-transparent border h-100">
                                                        <!-- Card header -->
                                                        <div class="card-header bg-transparent border-bottom d-flex justify-content-between">
                                                            <div class="d-sm-flex align-items-center">
                                                                <!-- Avatar -->
                                                                <div class="avatar avatar-md flex-shrink-0">
                                                                    <% if (ruoloUsr.equals("Professore Referente")) { %>
                                                                    <div class="avatar-img rounded-circle bg-warning"><span
                                                                            class="text-white position-absolute top-50 start-50 translate-middle fw-bold"><%=iniziale%></span>
                                                                    </div>
                                                                    <%} else if (ruoloUsr.equals("Studente")) {%>
                                                                    <div class="avatar-img rounded-circle bg-info"><span
                                                                            class="text-white position-absolute top-50 start-50 translate-middle fw-bold"><%=iniziale%></span>
                                                                    </div>
                                                                    <%} else if (ruoloUsr.equals("Tutor")) {%>
                                                                    <div class="avatar-img rounded-circle bg-success"><span
                                                                            class="text-white position-absolute top-50 start-50 translate-middle fw-bold"><%=iniziale%></span>
                                                                    </div>
                                                                    <%}%>
                                                                </div>
                                                                <!-- Info -->
                                                                <div class="ms-0 ms-sm-2 mt-2 mt-sm-0">
                                                                    <h5 class="mb-0"><a href="#"><%=nome%>
                                                                    </a></h5>

                                                                </div>
                                                            </div>
                                                            <div class="dropdown text-end">
                                                                <a class="btn btn-outline-info"
                                                                   href="../UserProfile?usrEmail=<%=b.getEmail()%>&ruolo=<%=b.getRuolo()%>"
                                                                   role="button">Visualizza</a>
                                                            </div>
                                                        </div>

                                                        <div class="card-body">
                                                            <div class="d-flex justify-content-between align-items-center mb-3">
                                                                <div class="d-flex align-items-center">

                                                                    <h6 class="mb-0 ms-2 fw-light">Email:</h6>
                                                                </div>
                                                                <span class="mb-0 fw-bold"><%=b.getEmail()%></span>
                                                            </div>

                                                            <!-- Total courses -->
                                                            <div class="d-flex justify-content-between align-items-center mb-3">
                                                                <div class="d-flex align-items-center">

                                                                    <h6 class="mb-0 ms-2 fw-light">Tipo di Utente:</h6>
                                                                </div>
                                                                <span class="mb-0 fw-bold"><%=ruoloUsr%></span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <% }
                                                } %>
                                            </div>
                                        </div>

                                        <div class="tab-pane fade active show" id="nav-html-tab-1">
                                            <div class="table-responsive border-0">
                                                <table class="table table-dark-gray align-middle p-4 mb-0 table-hover" id="listUser">
                                                    <!-- Table head -->
                                                    <thead style="background-color: #17a2b8 !important;">
                                                    <tr>
                                                        <th scope="col" class="border-0 rounded-start">Nome Utente</th>
                                                        <th scope="col" class="border-0">Email</th>
                                                        <th scope="col" class="border-0">Tipo Utente</th>
                                                        <th scope="col" class="border-0 rounded-end"></th>
                                                    </tr>
                                                    </thead>
                                                    <tbody>
                                                    <% for (UserBean b : utenti) {
                                                        if (!b.isPersonaleAmministrativo()) {
                                                            String nome = "" + b.getNome() + " " + b.getCognome();
                                                            String ruoloUsr = b.getRuolo();
                                                            String iniziale = b.getNome().charAt(0) + b.getCognome().substring(0, 1);
                                                            switch (ruoloUsr) {
                                                                case "S" : ruoloUsr = "Studente"; break;
                                                                case "T" : ruoloUsr = "Tutor"; break;
                                                                case "P" : ruoloUsr = "Professore Referente"; break;
                                                            }
                                                    %>
                                                    <tr>
                                                        <!-- Table data -->
                                                        <td>
                                                            <div class="d-flex align-items-center position-relative">
                                                                <!-- Image -->
                                                                <div class="avatar avatar-md">
                                                                    <% if (ruoloUsr.equals("Professore Referente")) { %>
                                                                    <div class="avatar-img rounded-circle bg-warning"><span
                                                                            class="text-white position-absolute top-50 start-50 translate-middle fw-bold"><%=iniziale%></span>
                                                                    </div>
                                                                    <%} else if (ruoloUsr.equals("Studente")) {%>
                                                                    <div class="avatar-img rounded-circle bg-info"><span
                                                                            class="text-white position-absolute top-50 start-50 translate-middle fw-bold"><%=iniziale%></span>
                                                                    </div>
                                                                    <%} else if (ruoloUsr.equals("Tutor")) {%>
                                                                    <div class="avatar-img rounded-circle bg-success"><span
                                                                            class="text-white position-absolute top-50 start-50 translate-middle fw-bold"><%=iniziale%></span>
                                                                    </div>
                                                                    <%}%>
                                                                </div>
                                                                <div class="mb-0 ms-3">
                                                                    <h6 class="mb-0"><a href="#"
                                                                                        class="stretched-link"><%=nome%>
                                                                    </a></h6>
                                                                </div>
                                                            </div>
                                                        </td>

                                                        <!-- Table data -->
                                                        <td><%=b.getEmail()%>
                                                        </td>

                                                        <!-- Table data -->
                                                        <td class="text-center text-sm-start">
                                                            <%=ruoloUsr%>
                                                        </td>
                                                        <td>
                                                            <a class="btn btn-outline-info"
                                                               href="../UserProfile?usrEmail=<%=b.getEmail()%>"
                                                               role="button">Visualizza</a>
                                                        </td>
                                                    </tr>
                                                    <% }
                                                    } %>
                                                    </tbody>
                                                </table>
                                                <script src="../js/searchUser.js"></script>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</main>
<footer>
    <%@ include file="../fragment/footer.html" %>
</footer>
<div class="back-top"><i
        class="bi bi-arrow-up-short position-absolute top-50 start-50 translate-middle"></i></div>

<!-- Bootstrap JS -->
<script src="../assets/vendor/bootstrap/dist/js/bootstrap.bundle.min.js"></script>

<!-- Vendors -->
<script src="../assets/vendor/tiny-slider/tiny-slider.js"></script>
<script src="../assets/vendor/glightbox/js/glightbox.js"></script>
<script src="../assets/vendor/purecounterjs/dist/purecounter_vanilla.js"></script>

<!-- Template Functions -->
<script src="../assets/js/functions.js"></script>
</body>
</html>
