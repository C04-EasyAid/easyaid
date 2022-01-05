<%@ page import="java.util.Collection" %>
<%@ page import="model.bean.TutoratoDidatticoBean" %>
<%@ page import="model.bean.SupportoEsameBean" %>
<%--
  Created by IntelliJ IDEA.
  User: Martina Giugliano
  Date: 29/12/2021
  Time: 15:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <!-- Meta Tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="author" content="Webestica.com">
    <meta name="description" content="Eduport- LMS, Education and Course Theme">


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
<div class="content-wrapper align-self-center">
    <%
        Collection<TutoratoDidatticoBean> richiesteTutorato = (Collection<TutoratoDidatticoBean>) session.getAttribute("richiesteTutoratoNonAccettate");
        Collection<SupportoEsameBean> richesteSupporto = (Collection<SupportoEsameBean>) session.getAttribute("richiesteEsamiNonAccettate");
    %>

    <% for (TutoratoDidatticoBean b : richiesteTutorato) {

    %>
    <div class="row d-flex justify-content-center">
        <div class="col-md-6 grid-margin stretch-card align-self-center">
            <div class="card">
                <div class="card shadow h-100 p-4 mb-4">
                    <h4 class="card-title">Richiesta Tutorato Didattico</h4>
                    <p class="card-description">
                        Studente <code>&lt;<%=b.getStudenteEmail()%>&gt;</code></p>
                    <div class="row">
                        <div class="col-md-6">
                            <address>
                                <p class="fw-bold">Giorni Disponibili:</p>
                                <p><%=b.getOreDisponibili()%>
                                </p>
                                <p class="fw-bold">Ore Richieste:</p>
                                <p><%=Integer.toString(b.getOreRichieste())%>
                                </p>
                            </address>
                        </div>
                        <div class="col-md-6">
                            <address>
                                <p class="fw-bold">Insegnamento:</p>
                                <p><%=b.getInsegnamento()%>
                                </p>
                                <p class="fw-bold">Dipartimento:</p>
                                <p><%=b.getDipartimento()%>
                                </p>
                            </address>
                        </div>
                        <div class="col-md-6">
                            <address>
                                <form action="../SingolaRichiestaServlet?idTutorato=<%=b.getId()%>" method="post">
                                    <button type="submit" class="btn btn-outline-info">Visualizza</button>
                                </form>
                            </address>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <%}%>
    <% for (SupportoEsameBean s : richesteSupporto) {

    %>
    <div class="row d-flex justify-content-center">
        <div class="col-md-6 grid-margin stretch-card align-self-center">
            <div class="card">
                <div class="card shadow h-100 p-4 mb-4">
                    <h4 class="card-title">Suppoto Esame</h4>
                    <p class="card-description">
                        Studente <code>&lt;<%=s.getStudenteEmail()%>&gt;</code></p>
                    <div class="row">
                        <div class="col-md-6">
                            <address>
                                <p class="fw-bold">Giorni dell'Esame:</p>
                                <p><%=s.getData()%>
                                </p>
                                <p class="fw-bold">Ore Richieste:</p>
                                <p><%=Integer.toString(s.getOreRichieste())%>
                                </p>
                            </address>
                        </div>
                        <div class="col-md-6">
                            <address>
                                <p class="fw-bold">Insegnamento:</p>
                                <p><%=s.getInsegnamento()%>
                                </p>
                                <p class="fw-bold">Docente:</p>
                                <p><%=s.getDocente()%>
                                </p>
                            </address>
                        </div>
                        <div class="col-md-6">
                            <address>
                                <p class="fw-bold">Tipo di Assistenza:</p>
                                <p><%=s.getTipoAssistenza()%>
                                </p>
                                <p class="fw-bold">Modalità Esame:</p>
                                <p><%=s.getModalitaEsame()%>
                                </p>
                            </address>
                        </div>
                        <div class="col-md-6">
                            <address>
                                <form action="../SingolaRichiestaServlet?idSupporto=<%=s.getId()%>" method="post">
                                    <button type="submit" class="btn btn-outline-info">Visualizza</button>
                                </form>
                            </address>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <%}%>
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
<footer>
    <%@ include file="../fragment/footer.html" %>
</footer>
</body>
</html>