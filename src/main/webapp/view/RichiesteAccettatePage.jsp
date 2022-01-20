<%@ page import="java.util.Collection" %>
<%@ page import="model.bean.TutoratoDidatticoBean" %>
<%@ page import="model.bean.SupportoEsameBean" %><%--
<%--
  Created by IntelliJ IDEA.
  User: Martina Giugliano
  Date: 29/12/2021
  Time: 12:40
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
<header>
    <%@ include file="../fragment/navbar.jsp" %>
</header>
<body>
<%@ include file="../fragment/UserSection.jsp" %>
<%Collection<TutoratoDidatticoBean> richiesteTutorato = ( Collection<TutoratoDidatticoBean>) session.getAttribute("richiesteTutoratoAccettate");
    Collection<SupportoEsameBean> richesteSupporto = ( Collection<SupportoEsameBean>) session.getAttribute("richiesteEsamiAccettate");
%>
<section class="pb-0 py-sm-5">
    <div class="container">
        <!-- Title and select START -->
        <div class="row g-3 align-items-center mb-4">
            <!-- Content -->
            <div class="col-md-4">
                <h4 class="mb-0">Elenco Richieste Accettate</h4>
            </div>
        </div>
        <!-- Title and select END -->
        <div class="row">
            <!-- Main content START -->
            <div class="col-xl-9 col-xxl-8">

                <!-- Course list START -->
                <div class="row g-4">
                    <%for(TutoratoDidatticoBean tutorato : richiesteTutorato){%>
                    <div class="col-12">
                        <div class="card shadow overflow-hidden p-2">
                            <div class="row g-0">
                                <div class="col-md-5 overflow-hidden">
                                    <img src="../assets/images/courses/4by3/06.jpg" class="rounded-2" alt="Card image">
                                    <!-- Ribbon -->
                                    <div class="card-img-overlay">

                                    </div>
                                </div>
                                <div class="col-md-7">
                                    <div class="card-body">
                                        <!-- Badge and rating -->
                                        <div class="d-flex justify-content-between align-items-center mb-2">
                                            <!-- Badge -->
                                            <%if(tutorato.getStatus()==1){%>
                                            <a href="#" class="badge bg-danger text-white mb-2 mb-sm-0">In corso</a><%}%>
                                            <%if(tutorato.getStatus()!=1){%>
                                            <a href="#" class="badge bg-success text-white mb-2 mb-sm-0">Completato</a><%}%>
                                            <div>

                                                <a href="#" class="text-danger"></a>
                                            </div>
                                        </div>

                                        <!-- Title -->
                                        <h5 class="card-title"><a href="#">Tutorato Didattico</a></h5>
                                        <p class="text-truncate-2 d-none d-lg-block"><div class="mb-0 ms-2">
                                        <h6><p class="card-description"><br><code>&lt;<%=tutorato.getStudenteEmail()%>&gt;</code>
                                        </p></h6>
                                    </div>

                                        <!-- Info -->
                                        <ul class="list-inline">
                                            <li class="list-inline-item h6 fw-light mb-1 mb-sm-0"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-clock" viewBox="0 0 16 16">
                                                <path d="M8 3.5a.5.5 0 0 0-1 0V9a.5.5 0 0 0 .252.434l3.5 2a.5.5 0 0 0 .496-.868L8 8.71V3.5z"></path>
                                                <path d="M8 16A8 8 0 1 0 8 0a8 8 0 0 0 0 16zm7-8A7 7 0 1 1 1 8a7 7 0 0 1 14 0z"></path>
                                            </svg><%=tutorato.getOreDisponibili().toUpperCase(java.util.Locale.ROOT)%></li>
                                            <li class="list-inline-item h6 fw-light mb-1 mb-sm-0">
                                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-book" viewBox="0 0 16 16"><path d="M1 2.828c.885-.37 2.154-.769 3.388-.893 1.33-.134 2.458.063 3.112.752v9.746c-.935-.53-2.12-.603-3.213-.493-1.18.12-2.37.461-3.287.811V2.828zm7.5-.141c.654-.689 1.782-.886 3.112-.752 1.234.124 2.503.523 3.388.893v9.923c-.918-.35-2.107-.692-3.287-.81-1.094-.111-2.278-.039-3.213.492V2.687zM8 1.783C7.015.936 5.587.81 4.287.94c-1.514.153-3.042.672-3.994 1.105A.5.5 0 0 0 0 2.5v11a.5.5 0 0 0 .707.455c.882-.4 2.303-.881 3.68-1.02 1.409-.142 2.59.087 3.223.877a.5.5 0 0 0 .78 0c.633-.79 1.814-1.019 3.222-.877 1.378.139 2.8.62 3.681 1.02A.5.5 0 0 0 16 13.5v-11a.5.5 0 0 0-.293-.455c-.952-.433-2.48-.952-3.994-1.105C10.413.809 8.985.936 8 1.783z"></path>
                                                </svg><%=tutorato.getDipartimento().toUpperCase(java.util.Locale.ROOT)%></li>
                                            <li class="list-inline-item h6 fw-light"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-journal-bookmark" viewBox="0 0 16 16">
                                                <path fill-rule="evenodd" d="M6 8V1h1v6.117L8.743 6.07a.5.5 0 0 1 .514 0L11 7.117V1h1v7a.5.5 0 0 1-.757.429L9 7.083 6.757 8.43A.5.5 0 0 1 6 8z"></path>
                                                <path d="M3 0h10a2 2 0 0 1 2 2v12a2 2 0 0 1-2 2H3a2 2 0 0 1-2-2v-1h1v1a1 1 0 0 0 1 1h10a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1H3a1 1 0 0 0-1 1v1H1V2a2 2 0 0 1 2-2z"></path>
                                                <path d="M1 5v-.5a.5.5 0 0 1 1 0V5h.5a.5.5 0 0 1 0 1h-2a.5.5 0 0 1 0-1H1zm0 3v-.5a.5.5 0 0 1 1 0V8h.5a.5.5 0 0 1 0 1h-2a.5.5 0 0 1 0-1H1zm0 3v-.5a.5.5 0 0 1 1 0v.5h.5a.5.5 0 0 1 0 1h-2a.5.5 0 0 1 0-1H1z"></path>
                                            </svg><%=tutorato.getInsegnamento().toUpperCase(java.util.Locale.ROOT)%></li>
                                        </ul>
                                        <div class="d-sm-flex justify-content-sm-between align-items-center">
                                            <div class="mt-3 mt-sm-0">
                                                <a href="../SingolaRichiestaServlet?idTutorato=<%=tutorato.getId()%>" class="btn btn-outline-info">Seleziona</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- Card list END -->
                    <%}%>
                    <!-- Card list START -->
                    <%for(SupportoEsameBean supporto : richesteSupporto){%>
                    <div class="col-12">
                        <div class="card shadow overflow-hidden p-2">
                            <div class="row g-0">
                                <div class="col-md-5 overflow-hidden">
                                    <img src="../assets/images/courses/4by3/06.jpg" class="rounded-2" alt="Card image">
                                    <!-- Ribbon -->
                                    <div class="card-img-overlay">

                                    </div>
                                </div>
                                <div class="col-md-7">
                                    <div class="card-body">
                                        <!-- Badge and rating -->
                                        <div class="d-flex justify-content-between align-items-center mb-2">
                                            <!-- Badge -->
                                            <%if(supporto.getStatus()==1){%>
                                            <a href="#" class="badge bg-danger text-white mb-2 mb-sm-0">In corso</a><%}%>
                                            <%if(supporto.getStatus()!=1){%>
                                            <a href="#" class="badge bg-success text-white mb-2 mb-sm-0">Completato</a><%}%>
                                            <div>

                                                <a href="#" class="text-danger"></a>
                                            </div>
                                        </div>

                                        <!-- Title -->
                                        <h5 class="card-title"><a href="#">Supporto Esame</a></h5>
                                        <p class="text-truncate-2 d-none d-lg-block"><div class="mb-0 ms-2">
                                        <h6><p class="card-description"><br><code>&lt;<%=supporto.getStudenteEmail()%>&gt;</code>
                                        </p></h6>
                                    </div>

                                        <!-- Info -->
                                        <ul class="list-inline">
                                            <li class="list-inline-item h6 fw-light mb-1 mb-sm-0"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-clock" viewBox="0 0 16 16">
                                                <path d="M8 3.5a.5.5 0 0 0-1 0V9a.5.5 0 0 0 .252.434l3.5 2a.5.5 0 0 0 .496-.868L8 8.71V3.5z"></path>
                                                <path d="M8 16A8 8 0 1 0 8 0a8 8 0 0 0 0 16zm7-8A7 7 0 1 1 1 8a7 7 0 0 1 14 0z"></path>
                                            </svg><%=supporto.getOra().toUpperCase(java.util.Locale.ROOT)%></li>
                                            <li class="list-inline-item h6 fw-light mb-1 mb-sm-0">
                                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-book" viewBox="0 0 16 16"><path d="M1 2.828c.885-.37 2.154-.769 3.388-.893 1.33-.134 2.458.063 3.112.752v9.746c-.935-.53-2.12-.603-3.213-.493-1.18.12-2.37.461-3.287.811V2.828zm7.5-.141c.654-.689 1.782-.886 3.112-.752 1.234.124 2.503.523 3.388.893v9.923c-.918-.35-2.107-.692-3.287-.81-1.094-.111-2.278-.039-3.213.492V2.687zM8 1.783C7.015.936 5.587.81 4.287.94c-1.514.153-3.042.672-3.994 1.105A.5.5 0 0 0 0 2.5v11a.5.5 0 0 0 .707.455c.882-.4 2.303-.881 3.68-1.02 1.409-.142 2.59.087 3.223.877a.5.5 0 0 0 .78 0c.633-.79 1.814-1.019 3.222-.877 1.378.139 2.8.62 3.681 1.02A.5.5 0 0 0 16 13.5v-11a.5.5 0 0 0-.293-.455c-.952-.433-2.48-.952-3.994-1.105C10.413.809 8.985.936 8 1.783z"></path>
                                                </svg><%=supporto.getDipartimento().toUpperCase(java.util.Locale.ROOT)%></li>
                                            <li class="list-inline-item h6 fw-light"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-journal-bookmark" viewBox="0 0 16 16">
                                                <path fill-rule="evenodd" d="M6 8V1h1v6.117L8.743 6.07a.5.5 0 0 1 .514 0L11 7.117V1h1v7a.5.5 0 0 1-.757.429L9 7.083 6.757 8.43A.5.5 0 0 1 6 8z"></path>
                                                <path d="M3 0h10a2 2 0 0 1 2 2v12a2 2 0 0 1-2 2H3a2 2 0 0 1-2-2v-1h1v1a1 1 0 0 0 1 1h10a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1H3a1 1 0 0 0-1 1v1H1V2a2 2 0 0 1 2-2z"></path>
                                                <path d="M1 5v-.5a.5.5 0 0 1 1 0V5h.5a.5.5 0 0 1 0 1h-2a.5.5 0 0 1 0-1H1zm0 3v-.5a.5.5 0 0 1 1 0V8h.5a.5.5 0 0 1 0 1h-2a.5.5 0 0 1 0-1H1zm0 3v-.5a.5.5 0 0 1 1 0v.5h.5a.5.5 0 0 1 0 1h-2a.5.5 0 0 1 0-1H1z"></path>
                                            </svg><%=supporto.getInsegnamento().toUpperCase(java.util.Locale.ROOT)%></li>
                                            <li class="list-inline-item h6 fw-light mb-1 mb-sm-0"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-gear-wide-connected" viewBox="0 0 16 16">
                                                <path d="M7.068.727c.243-.97 1.62-.97 1.864 0l.071.286a.96.96 0 0 0 1.622.434l.205-.211c.695-.719 1.888-.03 1.613.931l-.08.284a.96.96 0 0 0 1.187 1.187l.283-.081c.96-.275 1.65.918.931 1.613l-.211.205a.96.96 0 0 0 .434 1.622l.286.071c.97.243.97 1.62 0 1.864l-.286.071a.96.96 0 0 0-.434 1.622l.211.205c.719.695.03 1.888-.931 1.613l-.284-.08a.96.96 0 0 0-1.187 1.187l.081.283c.275.96-.918 1.65-1.613.931l-.205-.211a.96.96 0 0 0-1.622.434l-.071.286c-.243.97-1.62.97-1.864 0l-.071-.286a.96.96 0 0 0-1.622-.434l-.205.211c-.695.719-1.888.03-1.613-.931l.08-.284a.96.96 0 0 0-1.186-1.187l-.284.081c-.96.275-1.65-.918-.931-1.613l.211-.205a.96.96 0 0 0-.434-1.622l-.286-.071c-.97-.243-.97-1.62 0-1.864l.286-.071a.96.96 0 0 0 .434-1.622l-.211-.205c-.719-.695-.03-1.888.931-1.613l.284.08a.96.96 0 0 0 1.187-1.186l-.081-.284c-.275-.96.918-1.65 1.613-.931l.205.211a.96.96 0 0 0 1.622-.434l.071-.286zM12.973 8.5H8.25l-2.834 3.779A4.998 4.998 0 0 0 12.973 8.5zm0-1a4.998 4.998 0 0 0-7.557-3.779l2.834 3.78h4.723zM5.048 3.967c-.03.021-.058.043-.087.065l.087-.065zm-.431.355A4.984 4.984 0 0 0 3.002 8c0 1.455.622 2.765 1.615 3.678L7.375 8 4.617 4.322zm.344 7.646.087.065-.087-.065z"></path>
                                            </svg><%=supporto.getModalitaEsame().toUpperCase(java.util.Locale.ROOT)%></li>
                                        </ul>
                                        <div class="d-sm-flex justify-content-sm-between align-items-center">
                                            <div class="mt-3 mt-sm-0">
                                                <a href="../SingolaRichiestaServlet?idSupporto=<%=supporto.getId()%>" class="btn btn-outline-info">Seleziona</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- Card list END -->
                    <%}%>

                </div>
                <!-- Card list END -->

                <!-- Card list START -->
                <div class="col-12">

                </div>
                <!-- Card list END -->

                <!-- Card list START -->

                <!-- Card list END -->
            </div>
            <!-- Course list END -->

            <!-- Pagination START -->

            <!-- Pagination END -->
        </div>
        <!-- Main content END -->

        <!-- Right sidebar START -->

        <!-- Right sidebar END -->

    </div>
</section>

<footer>
    <%@ include file="../fragment/footer.html" %>
</footer>
</body>
</html>
