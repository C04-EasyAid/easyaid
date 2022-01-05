<%--
  Created by IntelliJ IDEA.
  User: Serena
  Date: 28/12/2021
  Time: 22:33
  To change this template use File | Settings | File Templates.
--%>

<%@ page import="model.bean.UserBean" %>
<%@ page import="model.bean.TutoratoDidatticoBean" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.bean.LezioneBean" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Collection" %>
<%@ page import="model.dao.LezioneDAO" %>
<html>
<head>
    <!-- Meta Tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="author" content="Webestica.com">
    <meta name="description" content="Eduport- LMS, Education and Course Theme">

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
    <title></title>
</head>
<body>
<header>
    <%@ include file="../fragment/navbar.jsp" %>
</header>
<%@ include file="../fragment/UserSection.jsp" %>
<%
    Collection<LezioneBean> lezioni = (Collection<LezioneBean>) session.getAttribute("listaLezioni");
    Collection<TutoratoDidatticoBean> tutorati = (Collection<TutoratoDidatticoBean>) session.getAttribute("richiesteTutorato");
%>

<div class="container">
    <div class="row">
        <div class="col-xl-9">
            <!-- Counter boxes START -->
            <div class="row mb-4">
                <!-- Counter item -->
                <div class="card bg-transparent stretch-card border rounded-3 ">
                    <!-- Card header START -->
                    <div class="card-header bg-transparent border-bottom">
                        <h3 class="mb-0">Lista Delle Lezioni</h3>
                    </div>
                    <div class="card-body">
                        <div class="table-responsive border-0">
                            <table class="table table-dark-gray align-middle p-4 mb-0 table-hover">
                                <thead style="background-color: #17a2b8 !important;">
                                <tr>
                                    <th scope="col" class="border-0 rounded-start" style="">Tutor</th>
                                    <th scope="col" class="border-0">Ora Inizio</th>
                                    <th scope="col" class="border-0">Ora Fine</th>
                                    <th scope="col" class="border-0">Insegnamento</th>
                                    <th scope="col" class="border-0 rounded-end"></th>
                                </tr>
                                </thead>
                                <!-- Table body START -->
                                <tbody>
                                <%
                                    for (LezioneBean lezione : lezioni) {

                                %>
                                <tr>
                                    <td>
                                        <div class="d-flex align-items-center">
                                            <!-- Image -->
                                            <div class="w-100px">
                                                <img src="../image/lavagna.png" class="rounded" alt="">
                                            </div>
                                            <div class="mb-0 ms-2">
                                                <h6><p class="card-description"><br><code>&lt;<%=lezione.getTutor()%>&gt;</code>
                                                </p></h6>
                                            </div>
                                        </div>
                                    </td>
                                    <td><%=lezione.getOraInizio()%>
                                    </td>
                                    <td><%=lezione.getOraFine()%>
                                    </td>
                                    <td><%=lezione.getInsegnamento()%>
                                    </td>
                                    <td><a class="btn btn-outline-info"
                                           href="../SingolaLezione?lezione=<%=lezione.getTutorato()%>" role="button">Visualizza</a>
                                    </td>
                                </tr>
                                <%}%>
                                </tbody>
                                <!-- Table body END -->

                            </table>
                        </div>

                        <!-- Course list table END -->

                        <!-- Pagination START -->

                        <!-- Pagination END -->
                    </div>
                    <!-- Card body START -->
                </div>
                <!-- Main content END -->
            </div>
        </div>
        <div class="col-sm-1">
            <button type="button" class="btn btn-outline-info" data-bs-toggle="modal" data-bs-target="#nuovaLezione" style="margin-top: 9.2em; width: 8em;">Aggiungi</button>
        </div>
    </div>
</div>
<form action="../InserimentoLezione" method="get">
    <div class="modal fade" id="nuovaLezione" tabindex="-1" aria-labelledby="nuovaLezione" aria-hidden="true">
        <div class="modal-dialog modal-xl">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="nuovaLezione">Inserimento Nuova Lezione</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <form action="../inserisciSupporto" method="get">
                        <div class="row">
                            <div class="col-md-6">
                                <div class="mb-3">
                                    <label for="tutorato" class="col-form-label">Seleziona Richiesta:</label>
                                    <select name="idTutorato" style=" width:19.6em" class="form-control" id="tutorato">
                                        <option value="">Seleziona Richiesta</option>
                                        <%for (TutoratoDidatticoBean tutoratoDidatticoBean : tutorati){%>
                                        <option value="<%=tutoratoDidatticoBean.getId()%>"><%="Email: "+tutoratoDidatticoBean.getStudenteEmail()+" Insegnamento: "+tutoratoDidatticoBean.getInsegnamento()%></option><%}%>
                                    </select>
                                </div>
                                <div class="mb-3">
                                    <label for="oraInizio" class="col-form-label">Ora Inizio:</label>
                                    <input type="time" name="oraInizio" class="form-control" id="oraInizio">
                                </div>
                                <div class="mb-3">
                                    <label for="ora" class="col-form-label">Ora Fine:</label>
                                    <input type="time" name="oraFine" class="form-control" id="ora">
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="mb-3">
                                    <label for="data" class="col-form-label">Data:</label>
                                    <input type="date" name="data" class="form-control" id="data">
                                </div>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                            <button type="submit" class="btn btn-outline-info">Inserisci</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <!-- Back to top -->
    <div class="back-top"><i class="bi bi-arrow-up-short position-absolute top-50 start-50 translate-middle"></i></div>

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

