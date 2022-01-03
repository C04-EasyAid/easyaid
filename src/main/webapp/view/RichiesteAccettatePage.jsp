<%@ page import="java.util.Collection" %>
<%@ page import="model.bean.TutoratoDidatticoBean" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.dao.TutoratoDidatticoDAO" %>
<%@ page import="model.bean.TutorBean" %>
<%@ page import="model.dao.SupportoEsameDAO" %>
<%@ page import="model.bean.SupportoEsameBean" %><%--
<%--
  Created by IntelliJ IDEA.
  User: Martina Giugliano
  Date: 29/12/2021
  Time: 12:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ListaRichiesteAccettate</title>
    <title>Inserimento Utente</title>
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
</head>
<body>
<header>
    <%@ include file="../fragment/navbar.jsp" %>
</header>
<table style="border-collapse: collapse; background-color: aqua;border: 1px solid black">
    <% TutorBean bean = (TutorBean) session.getAttribute("tutor");
        Collection<TutoratoDidatticoBean> richiesteTutorato = new ArrayList<>();
        TutoratoDidatticoDAO tutoratoDao = new TutoratoDidatticoDAO();
        richiesteTutorato = tutoratoDao.doRetrieveAllByTutor("lorenzorossi1@studenti.unisa.it");
        Collection<SupportoEsameBean> richesteSupporto = new ArrayList<>();
        SupportoEsameDAO esameDAO = new SupportoEsameDAO();
        richesteSupporto = esameDAO.doRetrieveAllByTutor("lorenzorossi1@studenti.unisa.it");

    %>
    <section class="pt-0">
        <div class="container">
            <div class="row">
                <!-- Counter boxes START -->
                <div class="card bg-transparent stretch-card border rounded-3 ">
                    <!-- Card header START -->
                    <div class="card-header bg-transparent border-bottom">
                        <h3 class="mb-0">Elenco Richieste</h3>
                        <div class="card-body">
                            <div class="table-responsive border-0">
                                <table class="table table-dark-gray align-middle p-4 mb-0 table-hover">
                                    <!-- Table head -->
                                    <thead style="background-color: #17a2b8 !important;">
                                    <tr>
                                        <th scope="col" class="border-0 rounded-start" style="">Tutorato
                                            Didattico
                                        </th>
                                        <th scope="col" class="border-0">Date Disponibili</th>
                                        <th scope="col" class="border-0">Ore Disponibili</th>
                                        <th scope="col" class="border-0">Ore Richieste</th>
                                        <th scope="col" class="border-0 ">Studente</th>
                                        <th scope="col" class="border-0 rounded-end"></th>
                                    </tr>
                                    </thead>
                                    ->
                                    <tbody>
                                    <%
                                        for (TutoratoDidatticoBean b : richiesteTutorato) {%>
                                    <tr>
                                        <td>
                                            <div class="d-flex align-items-center">
                                                <div class="mb-0 ms-2">
                                                    <h6><a href="#">Tutorato Didattico</a></h6>
                                                </div>
                                            </div>
                                        </td>

                                        <!-- Table data -->
                                        <td><%=b.getDateDisponibili()%>
                                        </td>
                                        <td><%=b.getOreDisponibili()%>
                                        </td>
                                        <td><%=Integer.toString(b.getOreRichieste())%>
                                        </td>
                                        <td><%=b.getStudenteEmail()%>
                                        </td>
                                        <td><a class="btn btn-outline-info"
                                               href="../SingolaRichiestaServlet?idTutorato=<%=b.getId()%>"
                                               role="button">Visualizza</a></td>

                                    </tr>
                                    <% } %>

                                    </tbody>
                                    <!-- Table body END -->
                                </table>
                                <div class="table-responsive border-0">
                                    <table class="table table-dark-gray align-middle p-4 mb-0 table-hover">
                                        <!-- Table head -->
                                        <thead style="background-color: #17a2b8 !important;">
                                        <tr>
                                            <th scope="col" class="border-0 rounded-start">Supporto Esame
                                            </th>
                                            <th scope="col" class="border-0">Data</th>
                                            <th scope="col" class="border-0">Ora</th>
                                            <th scope="col" class="border-0">Ore Richieste</th>
                                            <th scope="col" class="border-0">Studente</th>
                                            <th scope="col" class="border-0 rounded-end"></th>
                                        </tr>
                                        </thead>

                                        <!-- Table body START -->
                                        <tbody>
                                        <!-- Table item -->
                                        <%
                                            for (SupportoEsameBean b : richesteSupporto) {%>

                                        <tr>
                                            <!-- Table data -->
                                            <td>
                                                <div class="d-flex align-items-center">
                                                    <div class="mb-0 ms-2">
                                                        <!-- Title -->
                                                        <h6><a href="#">Supporto Esame</a></h6>

                                                    </div>
                                                </div>
                                            </td>

                                            <!-- Table data -->
                                            <td><%=b.getData()%>
                                            </td>
                                            <td><%=b.getOra()%>
                                            </td>
                                            <td><%=Integer.toString(b.getOreRichieste())%>
                                            </td>
                                            <td><%=b.getStudenteEmail()%>
                                            </td>
                                            <td><a class="btn btn-outline-info"
                                                   href="../SingolaRichiestaServlet?idSupporto=<%=b.getId()%>"
                                                   role="button">Visualizza</a></td>

                                        </tr>
                                        <% } %>

                                        </tbody>
                                        <!-- Table body END -->
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        </div>
        </div>
    </section>
</table>
<footer>
    <%@ include file="../fragment/footer.html" %>
</footer>
</body>
</html>
