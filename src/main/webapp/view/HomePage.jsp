<%--
  Created by IntelliJ IDEA.
  User: Giovanni Toriello
  Date: 28/12/2021
  Time: 15:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>EasyAid</title>
    <!-- Meta Tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="author" content="Webestica.com">
    <meta name="description" content="Eduport- LMS, Education and Course Theme">


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

<main>
    <section class="position-relative overflow-hidden pt-5 pt-lg-8 bg-info h-75" style="margin-top: 3em;">
        <div class="container">
            <div class="row align-items-center g-5">
                <div class="col-lg-5 col-xl-6 position-relative z-index-1 text-center text-lg-start mb-5 mb-sm-0">
                    <h1 class="mb-0 display-6 text-light">
                        EasyAid UniSa
                    </h1>
                    <p class="my-4 lead text-light">
                        Piattaforma online di supporto per studenti con disabilità e DSA
                    </p>
                    <div class="d-sm-flex align-items-center justify-content-center justify-content-lg-start">
                        <a href="#" class="btn btn-lg btn-blue me-2 mb-4 mb-sm-0">
                            About
                        </a>
                    </div>
                </div>
                <div class="col-lg-7 col-xl-6 text-center position-relative">
                    <div class="position-relative">
                        <img src="../image/home-ill.svg" alt="">
                    </div>
                </div>
            </div>
        </div>
    </section>
</main>
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
</body>
</html>
