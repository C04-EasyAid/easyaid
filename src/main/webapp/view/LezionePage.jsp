<%@ page import="model.bean.LezioneBean" %>
<%@ page import="java.util.Collection" %>
<%@ page import="model.bean.CommentoBean" %>
<%--
  Created by IntelliJ IDEA.
  User: Mariagiovanna
  Date: 29/12/2021
  Time: 12:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="it">
<head>
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
    <title>EasyAid</title>
</head>
<body>
<header>
    <%@ include file="../fragment/navbar.jsp" %>
</header>
<%@ include file="../fragment/UserSection.jsp" %>

<%
    LezioneBean lezione = (LezioneBean) session.getAttribute("lezione");
    Collection<CommentoBean> commenti = (Collection<CommentoBean>) session.getAttribute("listaCommenti");
%>

<div class="content-wrapper align-self-center">
    <div class="row d-flex justify-content-center">
        <div class="col-md-6 grid-margin stretch-card align-self-center">
            <div class="card shadow bg-info p-2 mb-4">
                <div class="card shadow bg-light p-4">
                    <h4 class="card-title pl-2">Lezione</h4>
                    <p class="card-description">
                        Tutor <code>&lt;<%=lezione.getTutor()%>&gt;</code></p>
                    <div class="row">
                        <div class="col-md-6">
                            <address>
                                <p class="fw-bold">Data:</p>
                                <p><%=lezione.getData()%>
                                </p>
                                <p class="fw-bold">Ora Inizio:</p>
                                <p><%=lezione.getOraInizio()%>
                                </p>
                                <p class="fw-bold">Ora Fine:</p>
                                <p><%=lezione.getOraFine()%>
                                </p>
                            </address>
                        </div>
                        <div class="col-md-6">
                            <address>
                                <p class="fw-bold">Insegnamento:</p>
                                <p><%=lezione.getInsegnamento()%>
                                </p>
                                <p class="fw-bold">Luogo:</p>
                                <p><%=lezione.getLuogo()%></p>
                                <!-- Button trigger modal -->
                                <% if(user.isTutor() && !lezione.isStatus()){%>
                                <button type="button" class="btn btn-outline-info" data-bs-toggle="modal" data-bs-target="#confermaLezione">Conferma Lezione</button><%}%>
                            </address>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="row d-flex justify-content-center">
        <div class="col-md-6 grid-margin stretch-card align-self-center">
            <div class="card shadow bg-info p-2 mb-4">
                <div class="card-body bg-light">
                    <div class="row bootstrap snippets bootdeys">
                        <div class="col-md-8 col-sm-12">
                            <div class="comment-wrapper">
                                <div class="panel panel-info">
                                    <div class="panel-heading">
                                        <h4> Commenti</h4>
                                    </div>
                                </div>
                                <br>
                                <div class="row">
                                    <%
                                        String mittente = null;
                                        for (CommentoBean bean : commenti) {
                                            if (bean.getStudente() != null) {
                                                mittente = bean.getStudente();
                                            } else if(bean.getTutor() != null){
                                                mittente = bean.getTutor();
                                            }
                                    %>

                                    <ul class="media-list">
                                        <li class="media">

                                            <div class="card bg-info-transparent border rounded-3 p-4 mb-4">
                                                <div class="media-body">
                                                    <strong class="text-success"><%=mittente%>
                                                    </strong>
                                                    <small class="text"><%=bean.getOra()%>
                                                    </small>
                                                    <small class="text"><%=bean.getData()%>
                                                    </small>
                                                    <p>
                                                        <%=bean.getTesto()%>
                                                    </p>
                                                    <span class="text-muted pull-right"></span>
                                                </div>
                                            </div>
                                        </li>
                                    </ul>
                                    <%}%>
                                    <div class="panel-body">
                                        <form action="../CommentoServlet" method="post" onsubmit="return inserimentoCommento();">
                                            <input type="text" name="commento" class="form-control" placeholder="scrivi un commento..."
                                                                         rows="3" id="commento" maxlength="250" required>
                                            <br>

                                            <button type="submit" class="btn btn-outline-info">Commenta</button>
                                        </form>
                                        <div class="clearfix"></div>
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
<!-- Modal -->
<div class="modal fade" id="confermaLezione" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Conferma Lezione</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">Vuoi confermare la lezione?</div>
            <div class="modal-footer">
                <form action="../ConfermaLezioneServlet" method="get">
                    <button type="submit" class="btn btn-outline-info">Conferma</button>
                </form>
            </div>
        </div>
    </div>
</div>
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
<script src="../js/validazioneInput.js"></script>
<footer>
    <%@include file="../fragment/footer.html" %>
</footer>
</body>
</html>