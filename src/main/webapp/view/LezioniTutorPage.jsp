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
<!DOCTYPE html>
<html lang="it">
<head>
    <!-- Meta Tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="author" content="Webestica.com">
    <meta name="description" content="Eduport- LMS, Education and Course Theme">
    <link rel="shortcut icon" href="../image/favicon.ico">

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
                        <div class="col-sm-6"><%if(alert!=null) {%>
                            <!-- Toast Alert Message -->
                            <div class="alert alert-primary d-flex align-items-center" role="alert">
                                <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="currentColor" class="bi bi-exclamation-triangle-fill flex-shrink-0 me-2" viewBox="0 0 16 16" role="img" aria-label="Warning:">
                                    <path d="M8.982 1.566a1.13 1.13 0 0 0-1.96 0L.165 13.233c-.457.778.091 1.767.98 1.767h13.713c.889 0 1.438-.99.98-1.767L8.982 1.566zM8 5c.535 0 .954.462.9.995l-.35 3.507a.552.552 0 0 1-1.1 0L7.1 5.995A.905.905 0 0 1 8 5zm.002 6a1 1 0 1 1 0 2 1 1 0 0 1 0-2z"/>
                                </svg>
                                <div>
                                    <%=alert%>
                                </div>
                            </div>
                            <!-- End Toast Alert Message -->
                            <% session.removeAttribute("alertMsg");}%></div>
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
                                           href="../SingolaLezione?lezione=<%=lezione.getId()%>" role="button">Visualizza</a>
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
    </div>
</div>
<div class="col-sm-1">
    <button type="button" class="btn btn-primary btn-round zoom-hover me-3" data-bs-toggle="modal" data-bs-target="#nuovaLezione" style="position: absolute;left: 1000px;right: 20px;background: #59cfcd;"> <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-plus-lg" viewBox="0 0 16 16">
        <path fill-rule="evenodd" d="M8 2a.5.5 0 0 1 .5.5v5h5a.5.5 0 0 1 0 1h-5v5a.5.5 0 0 1-1 0v-5h-5a.5.5 0 0 1 0-1h5v-5A.5.5 0 0 1 8 2Z"/>
    </svg> </button>
</div>
<form action="../InserimentoLezione" onsubmit="return inserimentoLezione();" method="post">
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
                                    <select name="idTutorato" style=" width:36em" class="form-control" id="tutorato">
                                        <option value="">Seleziona Richiesta</option>
                                        <%for (TutoratoDidatticoBean tutoratoDidatticoBean : tutorati){ if(tutoratoDidatticoBean.getStatus() == 1){%>
                                        <option value="<%=tutoratoDidatticoBean.getId()%>"><%="Email: "+tutoratoDidatticoBean.getStudenteEmail()+" Insegnamento: "+tutoratoDidatticoBean.getInsegnamento()%></option><%}}%>
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
                                <div class="mb-3">
                                    <label for="luogo" class="col-form-label">Luogo:</label>
                                    <input type="text" name="luogo" class="form-control" id="luogo" minlength="2" maxlength="250">
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
    <script src="../js/validazioneInput.js"></script>
</body>
</html>

