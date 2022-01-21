<%@ page import="model.bean.TutoratoDidatticoBean" %>
<%@ page import="model.bean.SupportoEsameBean" %>
<%@ page import="java.util.Collection" %><%--
  Created by IntelliJ IDEA.
  User: Martina Giugliano
  Date: 28/12/2021
  Time: 22:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<% if(session.getAttribute("utente")==null){
    response.sendRedirect("./LoginPage.jsp");
    return;
}
%>
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
    Collection<TutoratoDidatticoBean> richiesteTutorato = (Collection<TutoratoDidatticoBean>) session.getAttribute("richiesteTutoratoCompletate");
    Collection<SupportoEsameBean> supportoEsami = (Collection<SupportoEsameBean>) session.getAttribute("richiesteEsamiCompletate");
    for(TutoratoDidatticoBean tutorato : richiesteTutorato){
%>

<div class="content-wrapper align-self-center">
    <div class="row d-flex justify-content-center">
        <div class="col-md-6 grid-margin stretch-card align-self-center">
            <div class="card shadow bg-info p-2 mb-4">
                <div class="card shadow bg-light p-4">
                    <h4 class="card-title pl-2">Tutorato Didattico</h4>
                    <p class="card-description">
                        Tutor <code>&lt;<%=tutorato.getTutorEmail()%>&gt;</code></p>
                    <div class="row">
                        <div class="col-md-6">
                            <address>
                                <p class="fw-bold">Email:</p>
                                <p><%=tutorato.getStudenteEmail()%>
                                </p>
                                <p class="fw-bold">Ore Disponibili:</p>
                                <p><%=tutorato.getOreDisponibili()%>
                                </p>
                            </address>
                        </div>
                        <div class="col-md-6">
                            <address>
                            <p class="fw-bold">Insegnamento:</p>
                            <p><%=tutorato.getInsegnamento()%>
                            </p>
                            <p class="fw-bold">Dipartimento:</p>
                            <p><%=tutorato.getDipartimento()%>
                            </p>
                            <form action="../SingolaRichiestaServlet?idTutorato=<%=tutorato.getId()%>" method="post">
                                <button type="submit" class="btn btn-outline-info">Visualizza</button>
                            </form>
                            </address>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%
    }
    for(SupportoEsameBean supporto: supportoEsami){

%>
<div class="content-wrapper align-self-center">
    <div class="row d-flex justify-content-center">
        <div class="col-md-6 grid-margin stretch-card align-self-center">
            <div class="card shadow bg-info p-2 mb-4">
                <div class="card shadow bg-light p-4">
                    <h4 class="card-title pl-2">Supporto Esame</h4>
                    <p class="card-description">
                        Tutor <code>&lt;<%=supporto.getTutorEmail()%>&gt;</code></p>
                    <div class="row">
                        <div class="col-md-6">
                            <address>
                                <p class="fw-bold">Email:</p>
                                <p><%=supporto.getStudenteEmail()%>
                                </p>
                                <p class="fw-bold">Data:</p>
                                <p><%=supporto.getData()%>
                                </p>
                                <p class="fw-bold">Ora:</p>
                                <p><%=supporto.getOra()%>
                                </p>
                            </address>
                        </div>
                        <div class="col-md-6">
                            <address>
                            <p class="fw-bold">Luogo:</p>
                            <p><%=supporto.getLuogo()%>
                            </p>
                            <p class="fw-bold">Insegnamento:</p>
                            <p><%=supporto.getInsegnamento()%>
                            </p>
                            <p class="fw-bold">Dipartimento:</p>
                            <p><%=supporto.getDipartimento()%>
                            </p>
                            <form action="../SingolaRichiestaServlet?idSupporto=<%=supporto.getId()%>" method="post">
                                <button type="submit" class="btn btn-outline-info">Visualizza</button>
                            </form>
                            </address>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%
    }%>
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