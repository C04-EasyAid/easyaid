<%--
  Created by IntelliJ IDEA.
  User: Riccardo
  Date: 27/12/2021
  Time: 17:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
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
<main>
    <section class="pt-0">
        <div class="container">
            <div class="row">
                <div class="col-xl-9">
                    <div class="row mb-4" style="width:90em;">
                        <div class="card bg-transparent stretch-card border rounded-3 ">
                            <div class="card-header bg-transparent border-bottom">
                                <h3 class="mb-0">Lista Delle Richieste Effettuate</h3>
                            </div>
                            <div class="card-body">
                                <div class="table-responsive border-0">
                                    <table class="table table-dark-gray align-self-center p-4 mb-0 table-hover">
                                        <thead style="background-color: #17a2b8 !important;">
                                        <tr class="text-center">
                                            <th scope="col" class="border-0 rounded-start" style="">Tutorato Didattico</th>
                                            <th scope="col" class="border-0">Date Disponibili</th>
                                            <th scope="col" class="border-0">Ore Disponibili</th>
                                            <th scope="col" class="border-0">Ore Richieste</th>
                                            <th scope="col" class="border-0">Status</th>
                                            <th scope="col" class="border-0 rounded-end"></th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <%

                                        %>
                                        <tr>
                                            <td>
                                                <div class="d-flex align-items-center">
                                                    <div class="w-100px">
                                                        <img src="../assets/images/courses/4by3/08.jpg" class="rounded" alt="">
                                                    </div>
                                                    <div class="mb-0 ms-2">
                                                        <h6><p class="card-description"><br><code>&lt;lorenzorossi1@studenti.unisa.it&gt;</code></p></h6>
                                                    </div>
                                                </div>
                                            </td>
                                            <td>15/02/2022</td>
                                            <td>10</td>
                                            <td>12</td>
                                            <td><a href="#" class="badge bg-danger"><i class="fas fa-circle me-2 small fw-bold"></i>Non accettata</a></td>
                                            <td><a class="btn btn-outline-info" href="" role="button">Visualizza</a> </td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>

                            <div class="card-body p-4 mb-4">
                                <div class="table-responsive border-0">
                                    <table class="table table-dark-gray align-self-center p-4 mb-0 table-hover">
                                        <thead style="background-color: #17a2b8 !important;">
                                        <tr class="text-center">
                                            <th scope="col" class="border-0 rounded-start" style="">Supporto Esame</th>
                                            <th scope="col" class="border-0">Data</th>
                                            <th scope="col" class="border-0">Ora</th>
                                            <th scope="col" class="border-0">Docente</th>
                                            <th scope="col" class="border-0">Modalità Esame</th>
                                            <th scope="col" class="border-0">Insegnamento</th>
                                            <th scope="col" class="border-0">Status</th>
                                            <th scope="col" class="border-0 rounded-end"></th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <%

                                        %>
                                        <tr>
                                            <td>
                                                <div class="d-flex align-items-center">
                                                    <div class="w-100px">
                                                        <img src="../assets/images/courses/4by3/08.jpg" class="rounded" alt="">
                                                    </div>
                                                    <div class="mb-0 ms-2">
                                                        <h6><p class="card-description"><br><code>&lt;lorenzorossi1@studenti.unisa.it&gt;</code></p></h6>
                                                    </div>
                                                </div>
                                            </td>
                                            <td>17/02/2022</td>
                                            <td>12:00</td>
                                            <td>Filomena Ferrucci</td>
                                            <td>Scritto</td>
                                            <td>Ingegneria del Software</td>
                                            <td><a href="#" class="badge bg-success"><i class="fas fa-circle me-2 small fw-bold"></i>Accettata</a></td>
                                            <td><a class="btn btn-outline-info" href="" role="button">Visualizza</a> </td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>
            </div>
        </div>
        </section>
</main>

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
