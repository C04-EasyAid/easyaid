<%@ page import="model.bean.UserBean" %>
<%@ page import="model.bean.TutorBean" %>
<%@ page import="model.bean.StudenteBean" %>
<%@ page import="model.bean.ProfessoreReferenteBean" %>
<%--
  Created by IntelliJ IDEA.
  User: Giovanni Toriello
  Date: 29/12/2021
  Time: 09:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="author" content="Webestica.com">
    <meta name="description" content="Eduport- LMS, Education and Course Theme">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3mipmap34MD+dH/1fQ784/j6cY/iQUITOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

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



    <!-- Logo Nav START -->
    <nav class="navbar navbar-expand-xl">
        <div class="container-fluid px-3 px-xl-5">
            <!-- Logo START -->
            <a class="navbar-brand pt-0 pb-0 w-50" href="#">
                <img style="width: auto !important;height: 80px !important;" src="../image/PS-LOGO-DEFINITIVO-2.png" alt="logo">
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

                        <a class="nav-link text-black" href="#" id="pagesMenu" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Management</a>
                        <ul class="dropdown-menu" aria-labelledby="pagesMenu">
                            <li><a class="dropdown-item text-black" href="../ViewListaUsers">Elenco Utenti</a></li>
                        </ul>

                    </li>
                    <!-- Nav About -->
                    <li class="nav-item">
                        <a class="nav-link text-black" href="#" id="demoMenu" aria-haspopup="true" aria-expanded="false">About</a>
                    </li>
                    <!-- Nav Nome Cognome -->
                    <li class="nav-item">
                        <a class="nav-link text-black" href="#" id="demoMenu" aria-haspopup="true" aria-expanded="false">Giuseppe Falchi
                        </a>
                    </li>

                </ul>
                <!-- Nav Main menu END -->

            </div>
            <!-- Main navbar END -->

            <!-- Profile START -->
            <div class="dropdown ms-1 ms-lg-0">
                <a class="avatar avatar-sm p-0 text-black" href="#" id="profileDropdown" role="button" data-bs-auto-close="outside" data-bs-display="static" data-bs-toggle="dropdown" aria-expanded="false">

                    <div class="avatar-img rounded-circle bg-blue"><span class="text-white position-absolute top-50 start-50 translate-middle fw-bold">GF</span>
                    </div>

                </a>
                <ul class="dropdown-menu dropdown-animation dropdown-menu-end shadow pt-3" aria-labelledby="profileDropdown">
                    <!-- Profile info -->
                    <li class="px-3">
                        <div class="d-flex align-items-center">
                            <!-- Avatar -->
                            <div class="avatar me-3">

                                <div class="avatar-img rounded-circle bg-blue"><span class="text-white position-absolute top-50 start-50 translate-middle fw-bold">GF</span>
                                </div>

                            </div>
                            <div>
                                <a class="h6 text-black" href="#">Giuseppe Falchi
                                </a>
                                <p class="small m-0 text-black">gfalchi67@unisa.it
                                </p>
                            </div>
                        </div>
                        <hr>
                    </li>
                    <!-- Links -->
                    <li><a class="dropdown-item text-black" href="ProfiloPage.jsp"><i class="bi fa-fw me-2"></i>Account
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
<main>
    <section class="pt-0" style="
    margin-bottom: 9em;
">



        <!-- Main banner background image -->
        <div class="container-fluid px-0">
            <div class="bg-bg-info h-100px h-md-200px rounded-0" style="background:#59cfcd no-repeat center center; background-size:cover;">
            </div>
            <div class="container mt-n4">
                <div class="row">
                    <!-- Profile banner START -->
                    <div class="col-12">
                        <div class="card bg-transparent card-body p-0">
                            <div class="row d-flex justify-content-between">
                                <!-- Avatar -->
                                <div class="col-auto mt-4 mt-md-0">
                                    <div class="avatar avatar-xxl mt-n3">




                                        <div class="avatar-img rounded-circle bg-blue"><span class="text-white position-absolute top-50 start-50 translate-middle fw-bold fs-1">GF</span></div>
                                        <span class="badge bg-success text-white rounded-pill position-absolute top-50 start-100 translate-middle mt-4 mt-md-5 ms-n3 px-md-3" style="background:#59cfcd !important;">Admin</span>
                                    </div>
                                </div>
                                <!-- Profile info -->
                                <div class="col d-md-flex justify-content-between align-items-center mt-4">
                                    <div>
                                        <h1 class="my-1 fs-4">Giuseppe Falchi</h1>
                                        <ul class="list-inline mb-0">
                                            <li class="list-inline-item h6 fw-light me-3 mb-1 mb-sm-0">gfalchi67@unisa.it</li>

                                        </ul>
                                    </div>
                                    <!-- Button -->
                                    <div class="d-flex align-items-center mt-2 mt-md-0">

                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- Profile banner END -->

                        <!-- Advanced filter responsive toggler START -->
                        <!-- Divider -->
                        <hr class="d-xl-none">
                        <div class="col-12 col-xl-3 d-flex justify-content-between align-items-center">


                        </div>
                        <!-- Advanced filter responsive toggler END -->
                    </div>
                </div>
            </div>

            <div class="container">

                <!-- Title -->

                <div class="row g-4">
                    <div class="col-3" style="
    margin-top: 5.3em;
">





                        <!-- Responsive offcanvas body START -->
                        <nav class="navbar navbar-light navbar-expand-xl mx-0">
                            <div class="offcanvas offcanvas-end" tabindex="-1" id="offcanvasNavbar" aria-labelledby="offcanvasNavbarLabel">
                                <!-- Offcanvas body -->
                                <div class="offcanvas-body p-3 p-xl-0">
                                    <div class="bg-dark border rounded-3 pb-0 p-3 w-100">
                                        <!-- Dashboard menu -->
                                        <div class="list-group list-group-dark list-group-borderless">
                                            <a class="list-group-item" href="ListaUtentiPage.jsp"><i class="bi bi-ui-checks-grid fa-fw me-2"></i>Dashboard</a>
                                            <a class="list-group-item" href="RegistraUtentePage.jsp?inserimento=Studente"><i class="bi bi-person-fill fa-fw me-2"></i>Inserimento Studente</a>
                                            <a class="list-group-item" href="RegistraUtentePage.jsp?inserimento=Tutor"><i class="bi bi-mortarboard-fill fa-fw me-2"></i>Inserimento Tutor</a>
                                            <a class="list-group-item" href="RegistraUtentePage.jsp?inserimento=Professore Referente"><i class="bi bi-pencil-fill fa-fw me-2"></i>Inserimento Professore</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </nav>



                    </div>
                    <div class="col-xxl-7">
                        <div class="row">
                            <div class="col-12 mb-3">
                                <h1 class="h3 mb-2 mb-sm-0">Profilo Utente</h1>
                            </div>
                        </div>
                        <div class="card bg-transparent border rounded-3 h-100">

                            <!-- Card header -->
                            <div class="card-header bg-light border-bottom">
                                <h5 class="card-header-title mb-0">Informazioni</h5>
                            </div>

                            <!-- Card body START -->
                            <div class="card-body">
                                <!-- Profile picture -->
                                <div class="avatar avatar-md flex-shrink-0">

                                    <div class="avatar-img rounded-circle bg-info"><span class="text-white position-absolute top-50 start-50 translate-middle fw-bold">AB</span>
                                    </div>

                                </div>

                                <!-- Information START -->
                                <div class="row">

                                    <!-- Information item -->
                                    <div class="col-md-6">
                                        <ul class="list-group list-group-borderless">
                                            <li class="list-group-item">
                                                <span>Nome:</span>
                                                <span class="h6 mb-0">Aldo Baglio</span>
                                            </li>

                                            <li class="list-group-item">
                                                <span>Email:</span>
                                                <span class="h6 mb-0">abaglio9@studenti.unisa.it</span>
                                            </li>

                                            <li class="list-group-item">
                                                <span>Tipo di Utente:</span>
                                                <span class="h6 mb-0">Studente</span>
                                            </li>
                                        </ul>
                                    </div>


                                    <div class="col-md-6">
                                        <ul class="list-group list-group-borderless">
                                            <li class="list-group-item">
                                                <span>Tipo di Disabilità:</span>
                                                <span class="h6 mb-0">DSA</span>
                                            </li>

                                            <li class="list-group-item">
                                                <span>Specifiche Disturbo:</span>
                                                <span class="h6 mb-0">dislessia</span>
                                            </li>

                                            <li class="list-group-item">
                                                <span>Ore Disponibili:</span>
                                                <span class="h6 mb-0">22</span>
                                            </li>
                                            <li class="list-group-item">
                                                <span>Percentuale disabilità:</span>
                                                <span class="h6 mb-0">15</span>
                                            </li>
                                        </ul>
                                    </div>

                                </div>
                            </div>
                        </div></div></div></div></div></section>
</main>
<div class="back-top"><i class="bi bi-arrow-up-short position-absolute top-50 start-50 translate-middle"></i></div>
<footer>
    <%@include file="../fragment/footer.html"%>
</footer>
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
