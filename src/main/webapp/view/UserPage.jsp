<%@ page import="model.bean.UserBean" %>
<%@ page import="model.bean.TutorBean" %>
<%@ page import="model.dao.UserDAO" %>
<%@ page import="model.bean.StudenteBean" %>
<%@ page import="model.bean.ProfessoreReferenteBean" %>
<%@ page import="model.dao.TutorDAO" %><%--
  Created by IntelliJ IDEA.
  User: Giovanni Toriello
  Date: 29/12/2021
  Time: 09:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="author" content="Webestica.com">
    <meta name="description" content="Eduport- LMS, Education and Course Theme">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3mipmap34MD+dH/1fQ784/j6cY/iQUITOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <!-- Favicon -->
    <link rel="shortcut icon" href="../assets/images/favicon.ico">

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
    <title>EasyAid</title>
</head>
<body>

<header>
    <%@ include file="../fragment/navbar.jsp" %>
</header>
<div class="bg-info h-100px h-md-200px rounded-0"
     style="background-size:cover;"></div>
<%
    UserBean utente = (UserBean) session.getAttribute("utenteSelezionato");
    String nome = "" + utente.getNome() + " " + utente.getCognome();
    String iniziale = utente.getNome().substring(0, 1) + utente.getCognome().substring(0, 1);
    String ruolo = utente.getRuolo();
    if (ruolo.equals("S")) {
        ruolo = "Studente";
    } else if (ruolo.equals("T")) {
        ruolo = "Tutor";
    } else if (ruolo.equals("P")) {
        ruolo = "Professore Referente";
    }
%>
<div class="page-content-wrapper border">

    <!-- Title -->
    <div class="row">
        <div class="col-12 mb-3">
            <h1 class="h3 mb-2 mb-sm-0">Profilo Utente</h1>
        </div>
    </div>

    <div class="row g-4">
        <div class="col-3">
            <%@ include file="../fragment/DashboardAdmin.jsp" %>
        </div>
        <div class="col-xxl-7">
            <div class="card bg-transparent border rounded-3 h-100">

                <!-- Card header -->
                <div class="card-header bg-light border-bottom">
                    <h5 class="card-header-title mb-0">Informazioni</h5>
                </div>

                <!-- Card body START -->
                <div class="card-body">
                    <!-- Profile picture -->
                    <div class="avatar avatar-md flex-shrink-0">
                        <% if (ruolo.equals("Professore Referente")) { %>
                        <div class="avatar-img rounded-circle bg-warning"><span
                                class="text-white position-absolute top-50 start-50 translate-middle fw-bold"><%=iniziale%></span>
                        </div>
                        <%} else if (ruolo.equals("Studente")) {%>
                        <div class="avatar-img rounded-circle bg-info"><span
                                class="text-white position-absolute top-50 start-50 translate-middle fw-bold"><%=iniziale%></span>
                        </div>
                        <%} else if (ruolo.equals("Tutor")) {%>
                        <div class="avatar-img rounded-circle bg-success"><span
                                class="text-white position-absolute top-50 start-50 translate-middle fw-bold"><%=iniziale%></span>
                        </div>
                        <%}%>
                    </div>

                    <!-- Information START -->
                    <div class="row">

                        <!-- Information item -->
                        <div class="col-md-6">
                            <ul class="list-group list-group-borderless">
                                <li class="list-group-item">
                                    <span>Nome:</span>
                                    <span class="h6 mb-0"><%=nome%></span>
                                </li>

                                <li class="list-group-item">
                                    <span>Email:</span>
                                    <span class="h6 mb-0"><%=utente.getEmail()%></span>
                                </li>

                                <li class="list-group-item">
                                    <span>Tipo di Utente:</span>
                                    <span class="h6 mb-0"><%=ruolo%></span>
                                </li>
                            </ul>
                        </div>

                        <% if (utente.isTutor()) {
                            TutorBean bean = (TutorBean) session.getAttribute("usrProfile");
                        %>
                        <div class="col-md-6">
                            <ul class="list-group list-group-borderless">
                                <li class="list-group-item">
                                    <span>Dipartimento:</span>
                                    <span class="h6 mb-0"><%=bean.getDipartimento()%></span>
                                </li>

                                <li class="list-group-item">
                                    <span>Qualifica:</span>
                                    <span class="h6 mb-0"><%=bean.getQualifica()%></span>
                                </li>

                                <li class="list-group-item">
                                    <span>Ore Disponibili:</span>
                                    <span class="h6 mb-0"><%=Integer.toString(bean.getOreDisponibili())%></span>
                                </li>
                                <li class="list-group-item">
                                    <span>Ore Svolte:</span>
                                    <span class="h6 mb-0"><%=Integer.toString(bean.getOreSvolte())%></span>
                                </li>
                            </ul>
                        </div>


                    </div>
                    <!-- Information END -->
                </div>
                <!-- Card body END -->
            </div>
        </div>
    </div>
</div>
<%
} else if (utente.isStudente()) {
    StudenteBean bean = (StudenteBean) session.getAttribute("usrProfile");
%>
<div class="col-md-6">
    <ul class="list-group list-group-borderless">
        <li class="list-group-item">
            <span>Tipo di Disabilità:</span>
            <span class="h6 mb-0"><%=bean.getTipoDisabilita()%></span>
        </li>

        <li class="list-group-item">
            <span>Specifiche Disturbo:</span>
            <span class="h6 mb-0"><%=bean.getSpecificheDisturbo()%></span>
        </li>

        <li class="list-group-item">
            <span>Ore Disponibili:</span>
            <span class="h6 mb-0"><%=Integer.toString(bean.getOreDisponibili())%></span>
        </li>
        <li class="list-group-item">
            <span>Percentuale disabilità:</span>
            <span class="h6 mb-0"><%=bean.getTipoDisabilita()%></span>
        </li>
    </ul>
</div>
<%
} else if (utente.isProfessoreReferente()) {
    ProfessoreReferenteBean bean = (ProfessoreReferenteBean) session.getAttribute("usrProfile");
%>
<div class="col-md-6">
    <ul class="list-group list-group-borderless">
        <li class="list-group-item">
            <span>Dipartimento:</span>
            <span class="h6 mb-0"><%=bean.getDipartimento()%></span>
        </li>
    </ul>
</div>
<%}%>
<div class="back-top"><i class="bi bi-arrow-up-short position-absolute top-50 start-50 translate-middle"></i></div>
<footer>
    <%@ include file="../fragment/footer.html" %>
</footer>
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
