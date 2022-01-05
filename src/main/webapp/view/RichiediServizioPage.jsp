<%--
  Created by IntelliJ IDEA.
  User: Riccardo
  Date: 27/12/2021
  Time: 16:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Richieste di servizio</title>
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



    <!-- Logo Nav START -->
    <nav class="navbar navbar-expand-xl">
        <div class="container-fluid px-3 px-xl-5">
            <!-- Logo START -->
            <a class="navbar-brand pt-0 pb-0 w-50" href="#">
                <img style="width: auto !important; height:60px !important;" src="../image/PS-LOGO-DEFINITIVO-2.png" alt="logo">
            </a>
            <!-- Logo END -->

            <!-- Responsive navbar toggler -->
            <button class="navbar-toggler ms-auto" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
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
                        <a class="nav-link active text-black" href="HomePage.jsp" id="demoMenu" aria-haspopup="true" aria-expanded="false">Home</a>
                    </li>

                    <!-- Nav Servizi -->
                    <li class="nav-item dropdown">

                        <a class="nav-link text-black" href="#" id="pagesMenu" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Servizi</a>
                        <ul class="dropdown-menu" aria-labelledby="pagesMenu">

                            <li><a class="dropdown-item text-black" href="RichiediServizioPage.jsp">Richiedi Servizio</a>
                            </li>
                            <li><a class="dropdown-item text-black" href="../ListaRichieste">Elenco Richieste</a></li>
                            <li><a class="dropdown-item text-black" href="../LezioniServlet">Elenco Lezioni</a></li>

                        </ul>

                    </li>
                    <!-- Nav About -->
                    <li class="nav-item">
                        <a class="nav-link text-black" href="#" id="demoMenu" aria-haspopup="true" aria-expanded="false">About</a>
                    </li>
                    <!-- Nav Nome Cognome -->
                    <li class="nav-item">
                        <a class="nav-link text-black" href="#" id="demoMenu" aria-haspopup="true" aria-expanded="false">Aldo Baglio
                        </a>
                    </li>

                </ul>
                <!-- Nav Main menu END -->

            </div>
            <!-- Main navbar END -->

            <!-- Profile START -->
            <div class="dropdown ms-1 ms-lg-0">
                <a class="avatar avatar-sm p-0 text-black" href="#" id="profileDropdown" role="button" data-bs-auto-close="outside" data-bs-display="static" data-bs-toggle="dropdown" aria-expanded="false">

                    <div class="avatar-img rounded-circle bg-info"><span class="text-white position-absolute top-50 start-50 translate-middle fw-bold">AB</span>
                    </div>

                </a>
                <ul class="dropdown-menu dropdown-animation dropdown-menu-end shadow pt-3" aria-labelledby="profileDropdown">
                    <!-- Profile info -->
                    <li class="px-3">
                        <div class="d-flex align-items-center">
                            <!-- Avatar -->
                            <div class="avatar me-3">

                                <div class="avatar-img rounded-circle bg-info"><span class="text-white position-absolute top-50 start-50 translate-middle fw-bold">AB</span>
                                </div>

                            </div>
                            <div>
                                <a class="h6 text-black" href="#">Aldo Baglio
                                </a>
                                <p class="small m-0 text-black">abaglio9@studenti.unisa.it
                                </p>
                            </div>
                        </div>
                        <hr>
                    </li>
                    <!-- Links -->
                    <li><a class="dropdown-item text-black" href="ProfilePage.jsp"><i class="bi fa-fw me-2"></i>Account
                        Settings</a></li>
                    <li><a class="dropdown-item bg-danger-soft-hover text-black" href="../logout"><i class="bi fa-fw me-2"></i>Logout</a></li>
                    <li>
                        <hr class="dropdown-divider">
                    </li>
                </ul>
            </div>
            <!-- Profile START -->

        </div>
    </nav>
    <!-- Logo Nav END -->
</header>
<div class="bg-info rounded-3 p-4 p-sm-8" style="margin-top: 8em;margin-bottom: 9em;">
    <!-- Title -->
    <h2 class="mb-3 text-center text-light ">Richiedi uno dei seguenti servizi</h2>
    <div class="container-fluid d-flex align-items-center justify-content-center">
        <div class="row">
            <div class="col-sm-6">
                <div id="card-tutorato" class="card text-center" style="background: linear-gradient(rgb(15, 169, 231), rgb(6, 106, 147)); ">
                    <div class="card-body" style="
    height: 20em;
    width: 28em;
">
                        <h3 class="card-title text-light">Tutorato Didattico</h3>
                        <p class="card-text text-light">Un tutor verrà assegnato per svolgere l'attività di tutorato</p>
                        <button type="button" class="btn btn-light  text-success" data-bs-toggle="modal" data-bs-target="#richiestaTutoratoDidattico" style="
    margin-top: 9em;
    width: 8em;
"> Richiedi
                        </button>
                    </div>
                </div>
            </div>
            <div class="col-sm-6">
                <div id="card-supporto" class="card text-center" style="background: linear-gradient(rgb(15, 169, 231), rgb(6, 106, 147));">
                    <div class="card-body" style="
    height: 20em;
    width: 28em;
">
                        <h4 class="card-title text-light">Supporto Esame</h4>
                        <p class="card-text text-light">Un tutor verrà assegnato per dare supporto per l'esame </p>
                        <button type="button" class="btn btn-light  text-success" data-bs-toggle="modal" data-bs-target="#richiestaSupportoEsame" style="
    margin-top: 9.2em;
    width: 8em;
"> Richiedi
                        </button>
                    </div>
                </div>
                <div class="modal fade" id="richiestaSupportoEsame" tabindex="-1" aria-labelledby="richiestaSupportoEsame" aria-hidden="true">
                    <div class="modal-dialog modal-xl">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="richiestaSupportoEsame">Richiesta Supporto Esame</h5>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                                <form action="../inserisciSupporto" method="get">
                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="mb-3">
                                                <label for="message-text" class="col-form-label">Insegnamento:</label>
                                                <input type="text" name="insegnamento" class="form-control" id="recipient-name">
                                            </div>
                                            <div class="mb-3">
                                                <label for="message-text" class="col-form-label">Modalità di
                                                    Esame:</label>
                                                <select name="modalita_esame" style=" width:19.6em" class="form-control">
                                                    <option value="">Seleziona Modalità</option>
                                                    <option value="Scritto"> Scritto</option>
                                                    <option value="Orale"> Orale</option>
                                                    <option value="Scritto e orale"> Scritto e orale</option>
                                                </select>
                                            </div>
                                            <div class="mb-3">
                                                <label for="message-text" class="col-form-label">Tipo di
                                                    Assistenza:</label>
                                                <select name="tipo_di_assistenza" style=" width:19.6em" class="form-control">
                                                    <option value="">Seleziona Assistenza</option>
                                                    <option value="Nessuno"> Nessuna Assistenza</option>
                                                    <option value="Riduzione tempi di attesa per sostenere la prova">
                                                        Riduzione tempi di attesa per sostenere la prova
                                                    </option>
                                                    <option value="Tutor lettore"> Tutor lettore</option>
                                                    <option value="Tutor scrittore">Tutor scrittore</option>
                                                    <option value="OSA">OSA</option>
                                                    <option value="Interprete L.I.S">Interprete L.I.S</option>
                                                </select>
                                            </div>
                                            <div class="mb-3">
                                                <label for="message-text" class="col-form-label">Eventuali
                                                    Ausili:</label>
                                                <select name="eventuali_ausili" style=" width:19.6em" class="form-control">
                                                    <option value="">Seleziona Ausili</option>
                                                    <option value="Nessuno"> Nessun Ausilio</option>
                                                    <option value="Tempo Aggiuntivo"> Tempo Aggiuntivo</option>
                                                    <option value="Tavola Dedicata Regolabile"> Tavola Dedicata
                                                        Regolabile
                                                    </option>
                                                    <option value="Utilizzo di Mappe Concettuali">Utilizzo di Mappe
                                                        Concettuali
                                                    </option>
                                                    <option value="Utilizzo di Calcolatrice">Utilizzo di Calcolatrice
                                                    </option>
                                                    <option value="Utilizzo di Calcolatrice Scientifica">Utilizzo di
                                                        Calcolatrice Scientifica
                                                    </option>
                                                    <option value="Utilizzo di Calcolatrice Scientifica non Programmabile">
                                                        Utilizzo di Calcolatrice Scientifica non Programmabile
                                                    </option>
                                                    <option value="Utilizzo di PC">Utilizzo di PC</option>
                                                    <option value="Utilizzo di sintesi vocale">Utilizzo di sintesi
                                                        vocale
                                                    </option>
                                                    <option value="Utilizzo di carrozzina">Utilizzo di carrozzina
                                                    </option>
                                                    <option value="Utilizzo di cuffie">Utilizzo di cuffie</option>
                                                </select>
                                            </div>
                                            <div class="mb-3">
                                                <label for="message-text" class="col-form-label">Ore Richieste:</label>
                                                <input type="number" name="ore_richieste" class="form-control" id="message-text">
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="mb-3">
                                                <label for="message-text" class="col-form-label">Docente:</label>
                                                <input type="text" name="docente" class="form-control" id="message-text">
                                            </div>
                                            <div class="mb-3">
                                                <label for="message-text" class="col-form-label">Dipartimento:</label>
                                                <select name="dipartimento" style=" width:19.6em" class="form-control">
                                                    <option value=""> Seleziona Dipartimento</option>
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
                                                    <option value="Scienze Aziendali-Managment &amp; Innovation Systems/DISA-MIS">
                                                        Scienze Aziendali-Managment &amp; Innovation Systems/DISA-MIS
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
                                            </div>
                                            <div class="mb-3">
                                                <label for="message-text" class="col-form-label">Data:</label>
                                                <input type="date" name="data" class="form-control" id="message-text">
                                            </div>
                                            <div class="mb-3">
                                                <label for="message-text" class="col-form-label">Ora:</label>
                                                <input type="time" name="ora" class="form-control" id="message-text">
                                            </div>
                                            <div class="mb-3">
                                                <label for="message-text" class="col-form-label">Luogo:</label>
                                                <input type="text" name="luogo" class="form-control" id="message-text">
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
                <div class="modal fade" id="richiestaTutoratoDidattico" tabindex="-1" aria-labelledby="richiestaTutoratoDidattico" aria-hidden="true">
                    <div class="modal-dialog modal-xl">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="richiestaTutoratoDidattico">Richiesta Tutorato Didattico</h5>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                                <form action="../inserisciTutorato" method="get">
                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="mb-3">
                                                <label for="message-text" class="col-form-label">Insegnamento:</label>
                                                <input type="text" name="insegnamento" class="form-control" id="recipient-name">
                                            </div>

                                            <div class="mb-3">
                                                <label for="message-text" class="col-form-label">Ore Richieste:</label>
                                                <input type="number" name="ore_richieste" class="form-control" id="message-text">
                                            </div>
                                            <div class="mb-3">
                                                <label for="message-text" class="col-form-label">Dipartimento:</label>
                                                <select name="dipartimento" style=" width:19.6em" class="form-control">
                                                    <option value=""> Seleziona Dipartimento</option>
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
                                                    <option value="Scienze Aziendali-Managment &amp; Innovation Systems/DISA-MIS">
                                                        Scienze Aziendali-Managment &amp; Innovation Systems/DISA-MIS
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
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="mb-3">
                                                <label for="message-text" class="col-form-label">Docente:</label>
                                                <input type="text" name="docente" class="form-control" id="message-text">
                                            </div>

                                            <div class="mb-3">
                                                <label for="message-text" class="col-form-label">Date disponibili:</label>
                                                <input type="text" name="date_disponibili" class="form-control" id="message-text">
                                            </div>
                                            <div class="mb-3">
                                                <label for="message-text" class="col-form-label">Ore disponibili:</label>
                                                <input type="text" name="ore_disponibili" class="form-control" id="message-text">
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
            </div>
        </div>
    </div>
</div>
<footer>
    <div class="container">
        <div class="py-1">
            <div class="container px-0">
                <div class="d-md-flex justify-content-between align-items-center py-3 text-center text-center text-md-left">
                    <div class="text-primary-hover">
                        <a href="#" class="text-body">Copyrights©2021 EasyAid All rights reserved.</a>
                    </div>
                    <div class="mt-3 mt-md-0">
                        <ul class="list-inline-item">
                            <li class="list-inline-item">
                                <a class="nav-link pe-0" href="#">
                                    Privacy policy
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
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
