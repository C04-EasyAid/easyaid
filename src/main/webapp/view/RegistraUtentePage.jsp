<%--
  Created by IntelliJ IDEA.
  User: Giovanni Toriello
  Date: 29/12/2021
  Time: 15:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String inserimento = (String) request.getParameter("inserimento");

%>
<html>
<head>
    <title>EasyAid</title>
    <!-- Meta Tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="author" content="Webestica.com">
    <meta name="description" content="Eduport- LMS, Education and Course Theme">

    <!-- Favicon -->
    <link rel="shortcut icon" href="assets/images/favicon.ico">

    <!-- Google Font -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css2?family=Heebo:wght@400;500;700&family=Roboto:wght@400;500;700&display=swap">

    <!-- Plugins CSS -->
    <link rel="stylesheet" type="text/css" href="../assets/vendor/font-awesome/css/all.min.css">
    <link rel="stylesheet" type="text/css" href="../assets/vendor/bootstrap-icons/bootstrap-icons.css">
    <link rel="stylesheet" type="text/css" href="../assets/vendor/tiny-slider/tiny-slider.css">
    <link rel="stylesheet" type="text/css" href="../assets/vendor/glightbox/css/glightbox.css">

    <!-- Theme CSS -->
    <link rel="stylesheet" type="text/css" href="../assets/css/style.css">
    <!-- Global site tag (gtag.js) - Google Analytics -->
    <script async src="https://www.googletagmanager.com/gtag/js?id=G-7N7LGGGWT1"></script>

</head>
<body>
<header>
    <%@ include file="../fragment/navbar.jsp" %>
</header>
<div class="container-fluid px-0">
    <%@ include file="../fragment/UserSection.jsp" %>
    </div>
    <div class="content-wrapper align-self-center">
        <div class="row d-flex justify-content-center">
            <%@ include file="../fragment/DashboardAdmin.jsp" %>
            <div class="col-md-6 grid-margin stretch-card align-self-center">
                <div class="card">
                    <div class="card-body">
                        <form action="../register" method="get" class="row g-4 align-items-center">

                            <p class="card-description"><h5 class="card-header-title titolo">
                            Registrazione <%=inserimento%>
                        </h5></p>
                            <input type="hidden" name="ruolo" value="<%=inserimento%>"/>

                            <div class="row">
                                <div class="col-md-6">
                                    <address>
                                        <p class="fw-bold">Nome:</p>
                                        <input type="text" name="nome" class="form-control" placeholder="Nome">
                                        <p class="fw-bold">Cognome:</p>
                                        <input type="text" name="cognome" class="form-control" placeholder="Cognome">
                                        <p class="fw-bold">Email:</p>
                                        <input type="email" name="email" class="form-control" placeholder="Email">
                                        <p class="fw-bold">Password:</p>
                                        <input type="password" name="password" class="form-control"
                                               placeholder="Password">
                                    </address>
                                </div>

                                <%
                                    if (inserimento.equals("Studente")) {
                                %>
                                <div class="col-md-6">
                                    <address>
                                        <p class="fw-bold">Tipo Disabilità:</p>
                                        <div>
                                            <div class="form-check">
                                                <input name="tipoDisabilita" value="Disabile" type="radio" id="disabile"
                                                       checked>
                                                <label for="disabile">Disabile</label>
                                            </div>
                                            <div class="form-check">
                                                <input name="tipoDisabilita" value="Dsa" type="radio" id="dsa">
                                                <label for="dsa">DSA</label>
                                            </div>
                                        </div>
                                        </p>
                                        <p class="fw-bold">Specifiche Disturbo:</p>
                                        <input type="text" name="specificheDisturbo" class="form-control"
                                               placeholder="Specifiche Disturbo">
                                        </p>
                                        <p class="fw-bold">Percentuale Disabilità:</p>
                                        <input type="text" name="percentualeDisabilita" class="form-control"
                                               placeholder="Percentuale Disabilità">
                                        </p>
                                        <p class="fw-bold">Ore Disponibili:</p>
                                        <input type="text" name="oreDisponibiliStudente" class="form-control"
                                               placeholder="Ore Disponibili">
                                        </p>
                                    </address>
                                </div>

                                <%}%>
                                <%
                                    if (inserimento.equals("Tutor")) {
                                %>
                                <div class="col-md-6">
                                    <address>
                                        <p class="fw-bold">Dipartimento:</p>
                                        <select name="dipartimentoTutor" style=" width:19.6em" class="form-control">
                                            <option value="Fisica/DIF"> Fisica/DIF</option>
                                            <option value="Chimica e Biologia/DICB"> Chimica e Biologia/DICB</option>
                                            <option value="Farmacia/DIFARM"> Farmacia/DIFARM</option>
                                            <option value="Informatica/DI"> Informatica/DI</option>
                                            <option value="Ingegneria Civile/DICIV"> Ingegneria Civile/DICIV</option>
                                            <option value="Ingegneria dell'Informazione ed Elettrica e Matematica applicata/DIEM">
                                                Ingegneria dell'Informazione ed Elettrica e Matematica applicata/DIEM
                                            </option>
                                            <option value="Ingegneria Industriale/DIIN"> Ingegneria Industriale/DIIN
                                            </option>
                                            <option value="Matematica/DIPMAT"> Matematica/DIPMAT</option>
                                            <option value="Medicina, Chirurgia e Odontoiatria/DIPMED"> Medicina,
                                                Chirurgia e Odontoiatria/DIPMED
                                            </option>
                                            <option value="Scienze Aziendali-Managment & Innovation Systems/DISA-MIS">
                                                Scienze Aziendali-Managment & Innovation Systems/DISA-MIS
                                            </option>
                                            <option value="Scienze del Patrimonio Culturale/DISPAT"> Scienze del
                                                Patrimonio Culturale/DISPAT
                                            </option>
                                            <option value="Scienza Economia e Statistiche/DISES"> Scienza Economia e
                                                Statistiche/DISES
                                            </option>
                                            <option value="Scienze Giuridiche"> Scienze Giuridiche</option>
                                            <option value="Scienze Politiche e della Comunicazione/DISPC"> Scienze
                                                Politiche e della Comunicazione/DISPC
                                            </option>
                                            <option value="Scienze Umane, Filosofiche e della Formazione/DISUFF">
                                                Scienze Umane, Filosofiche e della Formazione/DISUFF
                                            </option>
                                            <option value="Studi Politici e Sociali/DISPS"> Studi Politici e
                                                Sociali/DISPS
                                            </option>
                                            <option value="Studi Umanistici/DIPSUM"> Studi Umanistici/DIPSUM</option>
                                        </select>
                                        </p>
                                        <p class="fw-bold">Qualifica:</p>
                                        <input type="text" name="qualifica" class="form-control"
                                               placeholder="Qualifica">
                                        </p>
                                        <p class="fw-bold">Ore Disponibili:</p>
                                        <input type="text" nam="dipartimentoTutor" class="form-control"
                                               placeholder="Ore Disponibili">
                                        </p>
                                        <p class="fw-bold">Ore Svolte:</p>
                                        <input type="text" name="oreDisponibiliTutor" class="form-control"
                                               placeholder="Ore Svolte">
                                        </p>
                                    </address>
                                </div>

                                <%}%>
                                <%
                                    if (inserimento.equals("Professore Referente")) {
                                %>
                                <div class="col-md-6">
                                    <address>
                                        <p class="fw-bold">Dipartimento:</p>
                                        <select name="dipartimentoProf" style=" width:19.6em" class="form-control">
                                            <option value="Fisica/DIF"> Fisica/DIF</option>
                                            <option value="Chimica e Biologia/DICB"> Chimica e Biologia/DICB</option>
                                            <option value="Farmacia/DIFARM"> Farmacia/DIFARM</option>
                                            <option value="Informatica/DI"> Informatica/DI</option>
                                            <option value="Ingegneria Civile/DICIV"> Ingegneria Civile/DICIV</option>
                                            <option value="Ingegneria dell'Informazione ed Elettrica e Matematica applicata/DIEM">
                                                Ingegneria dell'Informazione ed Elettrica e Matematica applicata/DIEM
                                            </option>
                                            <option value="Ingegneria Industriale/DIIN"> Ingegneria Industriale/DIIN
                                            </option>
                                            <option value="Matematica/DIPMAT"> Matematica/DIPMAT</option>
                                            <option value="Medicina, Chirurgia e Odontoiatria/DIPMED"> Medicina,
                                                Chirurgia e Odontoiatria/DIPMED
                                            </option>
                                            <option value="Scienze Aziendali-Managment & Innovation Systems/DISA-MIS">
                                                Scienze Aziendali-Managment & Innovation Systems/DISA-MIS
                                            </option>
                                            <option value="Scienze del Patrimonio Culturale/DISPAT"> Scienze del
                                                Patrimonio Culturale/DISPAT
                                            </option>
                                            <option value="Scienza Economia e Statistiche/DISES"> Scienza Economia e
                                                Statistiche/DISES
                                            </option>
                                            <option value="Scienze Giuridiche"> Scienze Giuridiche</option>
                                            <option value="Scienze Politiche e della Comunicazione/DISPC"> Scienze
                                                Politiche e della Comunicazione/DISPC
                                            </option>
                                            <option value="Scienze Umane, Filosofiche e della Formazione/DISUFF">
                                                Scienze Umane, Filosofiche e della Formazione/DISUFF
                                            </option>
                                            <option value="Studi Politici e Sociali/DISPS"> Studi Politici e
                                                Sociali/DISPS
                                            </option>
                                            <option value="Studi Umanistici/DIPSUM"> Studi Umanistici/DIPSUM</option>
                                        </select>
                                    </address>
                                </div>

                                <%}%>
                            </div>
                            <div class="d-sm-flex justify-content-end">
                                <button type="submit" class="btn btn-outline-info">Inserisci</button>
                            </div>

                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
<footer>
    <%@include file="../fragment/footer.html" %>
</footer>
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
