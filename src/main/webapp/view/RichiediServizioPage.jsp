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
<%@ include file="../fragment/navbar.jsp" %>
</header>
<div class="bg-info rounded-3 p-4 p-sm-5">
    <!-- Title -->
    <h2 class="mb-3 text-center text-light ">Richiedi uno dei seguenti servizi</h2>
    <div class="container-fluid d-flex align-items-center justify-content-center">
        <div class="row">
            <div class="col-sm-6">
                <div  id="card-tutorato" class="card text-center" style="background: linear-gradient(rgb(15, 169, 231), rgb(6, 106, 147)); ">
                    <div class="card-body">
                        <h3 class="card-title text-light">Tutorato Didattico</h3>
                        <p class="card-text text-light">Un tutor verrà assegnato per svolgere l'attività di tutorato</p>
                        <a href="#" class="btn btn-light text-success">Richiedi</a>
                    </div>
                </div>
            </div>
            <div class="col-sm-6" >
                <div id="card-supporto" class="card text-center"  style="background: linear-gradient(rgb(15, 169, 231), rgb(6, 106, 147));" >
                    <div class="card-body" >
                        <h4 class="card-title text-light">Supporto Esame</h4>
                        <p class="card-text text-light">Un tutor verrà assegnato per dare supporto per l'esame e offrire aiuto per la prova d'esame</p>
                        <a href="#" class="btn btn-light  text-success">Richiedi</a>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>
<footer>  <%@include file="../fragment/footer.html"%></footer>
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
