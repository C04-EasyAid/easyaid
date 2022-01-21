<%--
  Created by IntelliJ IDEA.
  User: Riccardo
  Date: 27/12/2021
  Time: 16:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html lang="it">
<head>
    <title>EasyAid</title>
    <!-- Meta Tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="author" content="Webestica.com">
    <meta name="description" content="Eduport- LMS, Education and Course Theme">
    <link rel="shortcut icon" href="../image/favicon.ico">


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
    <%@include file="../fragment/navbar.jsp"%>
</header>
<div class="bg-info rounded-3 p-4 p-sm-5" style="margin-top: 10em;margin-bottom: 14em;">
    <!-- Title -->
    <h2 class="mb-3 text-center text-light ">Richiedi uno dei seguenti servizi</h2>
    <div class="container-fluid d-flex align-items-center justify-content-center">
        <div class="row">
            <%if (alert != null) {%>
            <!-- Toast Alert Message -->
            <div class="alert alert-info d-flex align-items-center" role="alert">
                <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="currentColor"
                     class="bi bi-arrow-up-circle-fill flex-shrink-0 me-2" viewBox="0 0 16 16">
                    <path d="M16 8A8 8 0 1 0 0 8a8 8 0 0 0 16 0zm-7.5 3.5a.5.5 0 0 1-1 0V5.707L5.354 7.854a.5.5 0 1 1-.708-.708l3-3a.5.5 0 0 1 .708 0l3 3a.5.5 0 0 1-.708.708L8.5 5.707V11.5z"></path>
                </svg>
                <div>
                    <%=alert%>
                </div>
            </div>
            <!-- End Toast Alert Message -->
            <% session.removeAttribute("alertMsg");
            }%>
            <div class="col-sm-6">
                <div id="card-tutorato" class="card text-center" style="background: linear-gradient(rgb(15, 169, 231), rgb(6, 106, 147)); ">
                    <div class="card-body" style="height: 20em;">
                        <h3 class="card-title text-light">Tutorato Didattico</h3>
                        <p class="card-text text-light">Un tutor verrà assegnato per svolgere l'attività di tutorato</p>
                        <button type="button" class="btn btn-light  text-success" data-bs-toggle="modal" data-bs-target="#richiestaTutoratoDidattico" style="margin-top: 7em;width: 8em;"> Richiedi
                        </button>
                    </div>
                </div>
            </div>
            <div class="col-sm-6">
                <div id="card-supporto" class="card text-center" style="background: linear-gradient(rgb(15, 169, 231), rgb(6, 106, 147));">
                    <div class="card-body" style="height: 20em;">
                        <h4 class="card-title text-light">Supporto Esame</h4>
                        <p class="card-text text-light">Un tutor verrà assegnato per dare supporto per l'esame</p>
                        <button type="button" class="btn btn-light  text-success" data-bs-toggle="modal" data-bs-target="#richiestaSupportoEsame" onclick="setData()" style="margin-top: 8.7em;width: 8em;"> Richiedi
                        </button>
                    </div>
                </div>
                <div class="modal fade" id="richiestaSupportoEsame" tabindex="-1" aria-labelledby="richiestaSupportoEsame" aria-hidden="true">
                    <div class="modal-dialog modal-xl">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="SupportoEsame">Richiesta Supporto Esame</h5>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                                <form action="../inserisciSupporto" method="post" onsubmit="return validazioneRichiestaSupporto();">
                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="mb-3">
                                                <label for="message-text" class="col-form-label">Insegnamento:
                                                <input type="text" name="insegnamento" class="form-control" id="insegnamentoS" required></label>
                                            </div>
                                            <div class="mb-3">
                                                <label for="message-text" class="col-form-label">Modalità di
                                                    Esame:
                                                <select name="modalita_esame" style=" width:19.6em" class="form-control">
                                                    <option value="">Seleziona Modalità</option>
                                                    <option value="Scritto"> Scritto</option>
                                                    <option value="Orale"> Orale</option>
                                                    <option value="Scritto e orale"> Scritto e orale</option>
                                                </select>
                                                </label>
                                            </div>
                                            <div class="mb-3">
                                                <label for="message-text" class="col-form-label">Tipo di
                                                    Assistenza:
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
                                                </label>
                                            </div>
                                            <div class="mb-3">
                                                <label for="message-text" class="col-form-label">Eventuali
                                                    Ausili:
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
                                                </label>
                                            </div>
                                            <div class="mb-3">
                                                <label for="message-text" class="col-form-label">Ore Richieste:
                                                <input type="number" name="ore_richieste" class="form-control" id="ore_richieste" required>
                                                </label>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="mb-3">
                                                <label for="message-text" class="col-form-label">Docente:
                                                <input type="text" name="docente" class="form-control" id="docente" required>
                                                </label>
                                            </div>
                                            <div class="mb-3">
                                                <label for="message-text" class="col-form-label">Dipartimento:
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
                                                </label>
                                            </div>
                                            <div class="mb-3">
                                                <label for="message-text" class="col-form-label">Data:
                                                <input type="date" name="data" class="form-control" id="data" value="2020-01-01" min="2020-01-01" required>
                                                </label>
                                            </div>
                                            <div class="mb-3">
                                                <label for="message-text" class="col-form-label">Ora:
                                                <input type="time" name="ora" class="form-control" id="ora" required>
                                                </label>
                                            </div>
                                            <div class="mb-3">
                                                <label for="message-text" class="col-form-label">Luogo:
                                                <input type="text" name="luogo" class="form-control" id="luogo" required>
                                                </label>
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
                                <h5 class="modal-title" id="TutoratoDidattico">Richiesta Tutorato Didattico</h5>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                                <form action="../inserisciTutorato" method="post" onsubmit="return validazioneRichiestaTutorato();">
                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="mb-3">
                                                <label for="message-text" class="col-form-label">Insegnamento:
                                                <input type="text" name="insegnamento" class="form-control" id="insegnamento" minlength="3" maxlength="26" required>
                                                </label>
                                            </div>

                                            <div class="mb-3">
                                                <label for="message-text" class="col-form-label">Ore Richieste:
                                                <input type="number" name="ore_richieste" class="form-control" id="ore_richieste_t" required>
                                                </label>
                                            </div>
                                            <div class="mb-3">
                                                <label for="message-text" class="col-form-label">Dipartimento:
                                                <select name="dipartimento" style=" width:19.6em" class="form-control">
                                                    <option value=null> Seleziona Dipartimento</option>
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
                                                </label>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="mb-3">
                                                <label for="message-text" class="col-form-label">Docente:
                                                <input type="text" name="docente" class="form-control" minlength="5" maxlength="20" id="docente_t" required>
                                                </label>
                                            </div>

                                            <div class="mb-3">
                                                <label for="message-text" class="col-form-label">Date disponibili:
                                                <input type="text" oninput="setLine()" name="date_disponibili" class="form-control" id="date_disponibili" required>
                                                </label>
                                            </div>
                                            <div class="mb-3">
                                                <label for="message-text" class="col-form-label">Ore disponibili:
                                                <input type="text" oninput="setLine()" name="ore_disponibili" class="form-control" id="ore_disponibili" required>
                                                </label>
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
    <%@include file="../fragment/footer.html"%>
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
