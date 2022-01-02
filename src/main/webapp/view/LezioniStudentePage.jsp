
<%--
  Created by IntelliJ IDEA.
  User: Serena
  Date: 28/12/2021
  Time: 17:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="model.bean.UserBean" %>
<%@ page import="model.bean.TutoratoDidatticoBean" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.bean.LezioneBean" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Collection" %>
<%@ page import="model.dao.LezioneDAO" %>
<html>
<head>
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
<%@ include file="../fragment/UserSection.jsp" %>
<%
    Collection<LezioneBean> lezioni = (Collection<LezioneBean>) session.getAttribute("listaLezioni");
%>

<div class="container">
    <div class="row">
        <div class="col-xl-9">
            <!-- Counter boxes START -->
            <div class="row mb-4">
                <!-- Counter item -->
                <div class="card bg-transparent stretch-card border rounded-3 ">
                    <!-- Card header START -->
                    <div class="card-header bg-transparent border-bottom">
                        <h3 class="mb-0">Lista Delle Lezioni</h3>
                    </div>
                    <div class="card-body">
                        <div class="table-responsive border-0"><table class="table table-dark-gray align-middle p-4 mb-0 table-hover">
                            <thead style="background-color: #17a2b8 !important;">
                            <tr class="text-center">
                                <th scope="col" class="border-0 rounded-start" style="">Tutor</th>
                                <th scope="col" class="border-0">Data</th>
                                <th scope="col" class="border-0">Orario</th>
                                <th scope="col" class="border-0">Insegnamento</th>
                                <th scope="col" class="border-0 rounded-end"></th>
                            </tr>
                            </thead>
                            <!-- Table body START -->
                            <tbody>
                            <%
                                for (LezioneBean lezione : lezioni) {
                                    String ora = ""+lezione.getOraInizio()+"-"+lezione.getOraFine();
                            %>
                            <tr>
                                <td>
                                    <div class="d-flex align-items-center">
                                        <!-- Image -->
                                        <div class="w-100px">
                                            <img src="../assets/images/courses/4by3/08.jpg" class="rounded" alt="">
                                        </div>
                                        <div class="mb-0 ms-2">
                                            <h6><p class="card-description"><br><code>&lt;<%=lezione.getTutor()%>&gt;</code>
                                            </p></h6>
                                        </div>
                                    </div>
                                </td>
                                <td><%=lezione.getData()%></td>
                                <td><%=ora%>
                                </td>
                                <td><%=lezione.getInsegnamento()%>
                                </td>
                                <td><a class="btn btn-outline-info" href="../SingolaLezione?lezione=<%=lezione.getId()%>" role="button">Visualizza</a> </td>
                            </tr>
                            <%}%>
                            </tbody>
                            <!-- Table body END -->
                        </table>
                        </div>
                        <!-- Course list table END -->

                        <!-- Pagination START -->

                        <!-- Pagination END -->
                    </div>
                    <!-- Card body START -->
                </div>
                <!-- Main content END -->
            </div>
        </div>
    </div>
</div>
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

