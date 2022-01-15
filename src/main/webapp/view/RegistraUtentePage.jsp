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
                <%if(alert!=null) {%>
                <!-- Toast Alert Message -->
                <div class="alert alert-info d-flex align-items-center" role="alert">
                    <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="currentColor" class="bi bi-arrow-up-circle-fill flex-shrink-0 me-2" viewBox="0 0 16 16">
                        <path d="M16 8A8 8 0 1 0 0 8a8 8 0 0 0 16 0zm-7.5 3.5a.5.5 0 0 1-1 0V5.707L5.354 7.854a.5.5 0 1 1-.708-.708l3-3a.5.5 0 0 1 .708 0l3 3a.5.5 0 0 1-.708.708L8.5 5.707V11.5z"/>
                    </svg>
                    <div>
                        <%=alert%>
                    </div>
                </div>
                <!-- End Toast Alert Message -->
                <% session.removeAttribute("alertMsg");}%>
                <div class="col-3">
                    <br>
                    <%@ include file="../fragment/DashboardAdmin.jsp" %>
                </div>

                <div class="col-9">
                    <br>
                    <div class="page-content-wrapper border rounded-3">
                        <div class="container">
                            <div class="card">
                                <div class="row">
                                    <div class="col-12">
                                        <br>
                                        <h1 class="h3 mb-2 mb-sm-2">Registrazione <%=inserimento%></h1>
                                    </div>
                                </div>
                                <div class="card-body">
                                    <form action="../register" method="post" class="row g-4 align-items-center" autocomplete="off" onsubmit="return validateInserimento();">
                                    </h5></p>
                                        <input type="hidden" name="ruolo" value="<%=inserimento%>"/>

                                        <div class="row">
                                            <div class="col-md-6">
                                                <address>
                                                    <p class="fw-bold">Nome:</p>
                                                    <input type="text" name="nome" class="form-control"
                                                           placeholder="Nome" required>
                                                    <p class="fw-bold">Cognome:</p>
                                                    <input type="text" name="cognome" class="form-control"
                                                           placeholder="Cognome" required>
                                                    <p class="fw-bold">Email:</p>
                                                    <input type="email" name="email" class="form-control"
                                                           placeholder="Email" id="email"required>
                                                    <p class="fw-bold">Password:</p>
                                                    <input type="password" name="password" class="form-control"
                                                           placeholder="Password" id="password" required>
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
                                                            <input name="tipoDisabilita" value="Disabile" type="radio"
                                                                   id="disabile"
                                                                   checked onclick="changeInput()">
                                                            <label for="disabile">Disabile</label>
                                                        </div>
                                                        <div class="form-check">
                                                            <input name="tipoDisabilita" value="Dsa" type="radio"
                                                                   id="dsa" onclick="changeInput()">
                                                            <label for="dsa">DSA</label>
                                                        </div>
                                                    </div>
                                                    </p>
                                                    <p class="fw-bold">Specifiche Disturbo:</p>
                                                    <input type="text" name="specificheDisturbo" class="form-control"
                                                           placeholder="Specifiche Disturbo" value="nessuno" id="specifica" required>
                                                    </p>
                                                    <p class="fw-bold">Percentuale Disabilità:</p>
                                                    <input type="text" name="percentualeDisabilita" class="form-control"
                                                           placeholder="Percentuale Disabilità" required>
                                                    </p>
                                                    <p class="fw-bold">Ore Disponibili:</p>
                                                    <input type="text" name="oreDisponibiliStudente"
                                                           class="form-control"
                                                           placeholder="Ore Disponibili" required>
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
                                                    <select name="dipartimentoTutor" style=" width:19.6em"
                                                            class="form-control">
                                                        <option value="Fisica/DIF"> Fisica/DIF</option>
                                                        <option value="Chimica e Biologia/DICB"> Chimica e Biologia/DICB
                                                        </option>
                                                        <option value="Farmacia/DIFARM"> Farmacia/DIFARM</option>
                                                        <option value="Informatica/DI"> Informatica/DI</option>
                                                        <option value="Ingegneria Civile/DICIV"> Ingegneria Civile/DICIV
                                                        </option>
                                                        <option value="Ingegneria dell'Informazione ed Elettrica e Matematica applicata/DIEM">
                                                            Ingegneria dell'Informazione ed Elettrica e Matematica
                                                            applicata/DIEM
                                                        </option>
                                                        <option value="Ingegneria Industriale/DIIN"> Ingegneria
                                                            Industriale/DIIN
                                                        </option>
                                                        <option value="Matematica/DIPMAT"> Matematica/DIPMAT</option>
                                                        <option value="Medicina, Chirurgia e Odontoiatria/DIPMED">
                                                            Medicina,
                                                            Chirurgia e Odontoiatria/DIPMED
                                                        </option>
                                                        <option value="Scienze Aziendali-Managment & Innovation Systems/DISA-MIS">
                                                            Scienze Aziendali-Managment & Innovation Systems/DISA-MIS
                                                        </option>
                                                        <option value="Scienze del Patrimonio Culturale/DISPAT"> Scienze
                                                            del
                                                            Patrimonio Culturale/DISPAT
                                                        </option>
                                                        <option value="Scienza Economia e Statistiche/DISES"> Scienza
                                                            Economia e
                                                            Statistiche/DISES
                                                        </option>
                                                        <option value="Scienze Giuridiche"> Scienze Giuridiche</option>
                                                        <option value="Scienze Politiche e della Comunicazione/DISPC">
                                                            Scienze
                                                            Politiche e della Comunicazione/DISPC
                                                        </option>
                                                        <option value="Scienze Umane, Filosofiche e della Formazione/DISUFF">
                                                            Scienze Umane, Filosofiche e della Formazione/DISUFF
                                                        </option>
                                                        <option value="Studi Politici e Sociali/DISPS"> Studi Politici e
                                                            Sociali/DISPS
                                                        </option>
                                                        <option value="Studi Umanistici/DIPSUM"> Studi Umanistici/DIPSUM
                                                        </option>
                                                    </select>
                                                    </p>
                                                    <p class="fw-bold">Qualifica:</p>
                                                    <input type="text" name="qualifica" class="form-control"
                                                           placeholder="Qualifica" required>
                                                    </p>
                                                    <p class="fw-bold">Ore Disponibili:</p>
                                                    <input type="text" nam="dipartimentoTutor" class="form-control"
                                                           placeholder="Ore Disponibili" required>
                                                    </p>
                                                    <p class="fw-bold">Ore Svolte:</p>
                                                    <input type="text" name="oreDisponibiliTutor" class="form-control"
                                                           placeholder="Ore Svolte" required>
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
                                                    <select name="dipartimentoProf" style=" width:19.6em"
                                                            class="form-control">
                                                        <option value="Fisica/DIF"> Fisica/DIF</option>
                                                        <option value="Chimica e Biologia/DICB"> Chimica e Biologia/DICB
                                                        </option>
                                                        <option value="Farmacia/DIFARM"> Farmacia/DIFARM</option>
                                                        <option value="Informatica/DI"> Informatica/DI</option>
                                                        <option value="Ingegneria Civile/DICIV"> Ingegneria Civile/DICIV
                                                        </option>
                                                        <option value="Ingegneria dell'Informazione ed Elettrica e Matematica applicata/DIEM">
                                                            Ingegneria dell'Informazione ed Elettrica e Matematica
                                                            applicata/DIEM
                                                        </option>
                                                        <option value="Ingegneria Industriale/DIIN"> Ingegneria
                                                            Industriale/DIIN
                                                        </option>
                                                        <option value="Matematica/DIPMAT"> Matematica/DIPMAT</option>
                                                        <option value="Medicina, Chirurgia e Odontoiatria/DIPMED">
                                                            Medicina,
                                                            Chirurgia e Odontoiatria/DIPMED
                                                        </option>
                                                        <option value="Scienze Aziendali-Managment & Innovation Systems/DISA-MIS">
                                                            Scienze Aziendali-Managment & Innovation Systems/DISA-MIS
                                                        </option>
                                                        <option value="Scienze del Patrimonio Culturale/DISPAT"> Scienze
                                                            del
                                                            Patrimonio Culturale/DISPAT
                                                        </option>
                                                        <option value="Scienza Economia e Statistiche/DISES"> Scienza
                                                            Economia e
                                                            Statistiche/DISES
                                                        </option>
                                                        <option value="Scienze Giuridiche"> Scienze Giuridiche</option>
                                                        <option value="Scienze Politiche e della Comunicazione/DISPC">
                                                            Scienze
                                                            Politiche e della Comunicazione/DISPC
                                                        </option>
                                                        <option value="Scienze Umane, Filosofiche e della Formazione/DISUFF">
                                                            Scienze Umane, Filosofiche e della Formazione/DISUFF
                                                        </option>
                                                        <option value="Studi Politici e Sociali/DISPS"> Studi Politici e
                                                            Sociali/DISPS
                                                        </option>
                                                        <option value="Studi Umanistici/DIPSUM"> Studi Umanistici/DIPSUM
                                                        </option>
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
            </div>
        </div>
    </section>
</main>
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
<script src="../js/validazioneInput.js"></script>
</body>
</html>
