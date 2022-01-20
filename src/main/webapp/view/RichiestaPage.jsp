<%@ page import="model.bean.TutoratoDidatticoBean" %>
<%@ page import="model.bean.SupportoEsameBean" %><%--
  Created by IntelliJ IDEA.
  User: Martina Giugliano
  Date: 29/12/2021
  Time: 22:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
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
<body>
<header>
    <%@ include file="../fragment/navbar.jsp" %>
</header>
<%
    TutoratoDidatticoBean tutorato = (TutoratoDidatticoBean) session.getAttribute("tutorato");
    SupportoEsameBean supporto = (SupportoEsameBean) session.getAttribute("supporto");
    String commento = null;
    if(tutorato!=null){
        commento = tutorato.getCommento();
%>

<section class="bg-info py-0 py-sm-5">
    <div class="container">
        <div class="row py-5">
            <div class="col-lg-8">
                <!-- Badge -->
                <%if(user.isTutor() && tutorato.getStatus()==0){%>
                <h6 class="mb-3 font-base bg-warning text-white py-2 px-4 rounded-2 d-inline-block">Disponibile</h6>
                <%}else if(user.isTutor() || user.isProfessoreReferente() && tutorato.getStatus()==1){%>
                <h6 class="mb-3 font-base bg-dark text-white py-2 px-4 rounded-2 d-inline-block">Accettata</h6>
                <%}else if((user.isTutor() || user.isProfessoreReferente()) && tutorato.getStatus()==2){%>
                <h6 class="mb-3 font-base bg-primary text-white py-2 px-4 rounded-2 d-inline-block">Completata (in attesa di approvazione)</h6>
                <%}else if((user.isTutor() || user.isProfessoreReferente()) && tutorato.getStatus()==3){%>
                <h6 class="mb-3 font-base bg-success text-white py-2 px-4 rounded-2 d-inline-block">Approvata</h6>
                <%}else if(user.isStudente() && tutorato.getStatus()==0){%>
                <h6 class="mb-3 font-base bg-warning text-white py-2 px-4 rounded-2 d-inline-block">In attesa</h6>
                <%}else if(user.isStudente() && tutorato.getStatus()!=0){%>
                <h6 class="mb-3 font-base bg-success text-white py-2 px-4 rounded-2 d-inline-block">Completata</h6><%}%>
                <h1 class="text-light">Tutorato Didattico</h1>
                <div class="mb-0 ms-2">
                    <h6><p class="card-description text-light">Email Studente: <%=tutorato.getStudenteEmail()%></p></h6>
                </div>
                <!-- Content -->
                <ul class="list-inline mb-4">
                    <li class="list-inline-item h6 me-3 mb-1 mb-sm-0 text-light"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-calendar" viewBox="0 0 16 16">
                        <path d="M3.5 0a.5.5 0 0 1 .5.5V1h8V.5a.5.5 0 0 1 1 0V1h1a2 2 0 0 1 2 2v11a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V3a2 2 0 0 1 2-2h1V.5a.5.5 0 0 1 .5-.5zM1 4v10a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1V4H1z"></path>
                    </svg>
                         <%=tutorato.getOreDisponibili().toUpperCase(java.util.Locale.ROOT)%></li>
                    <li class="list-inline-item h6 me-3 mb-1 mb-sm-0 text-light"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-clock" viewBox="0 0 16 16">
                        <path d="M8 3.5a.5.5 0 0 0-1 0V9a.5.5 0 0 0 .252.434l3.5 2a.5.5 0 0 0 .496-.868L8 8.71V3.5z"></path>
                        <path d="M8 16A8 8 0 1 0 8 0a8 8 0 0 0 0 16zm7-8A7 7 0 1 1 1 8a7 7 0 0 1 14 0z"></path>
                    </svg> ORE RICHIESTE: <%=tutorato.getOreRichieste()%></li>
                    <li class="list-inline-item h6 me-3 mb-1 mb-sm-0 text-light"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-journal-bookmark" viewBox="0 0 16 16">
                        <path fill-rule="evenodd" d="M6 8V1h1v6.117L8.743 6.07a.5.5 0 0 1 .514 0L11 7.117V1h1v7a.5.5 0 0 1-.757.429L9 7.083 6.757 8.43A.5.5 0 0 1 6 8z"></path>
                        <path d="M3 0h10a2 2 0 0 1 2 2v12a2 2 0 0 1-2 2H3a2 2 0 0 1-2-2v-1h1v1a1 1 0 0 0 1 1h10a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1H3a1 1 0 0 0-1 1v1H1V2a2 2 0 0 1 2-2z"></path>
                        <path d="M1 5v-.5a.5.5 0 0 1 1 0V5h.5a.5.5 0 0 1 0 1h-2a.5.5 0 0 1 0-1H1zm0 3v-.5a.5.5 0 0 1 1 0V8h.5a.5.5 0 0 1 0 1h-2a.5.5 0 0 1 0-1H1zm0 3v-.5a.5.5 0 0 1 1 0v.5h.5a.5.5 0 0 1 0 1h-2a.5.5 0 0 1 0-1H1z"></path>
                    </svg> <%=tutorato.getInsegnamento().toUpperCase(java.util.Locale.ROOT)%></li>
                    <li class="list-inline-item h6 me-3 mb-1 mb-sm-0 text-light"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-book" viewBox="0 0 16 16">
                        <path d="M1 2.828c.885-.37 2.154-.769 3.388-.893 1.33-.134 2.458.063 3.112.752v9.746c-.935-.53-2.12-.603-3.213-.493-1.18.12-2.37.461-3.287.811V2.828zm7.5-.141c.654-.689 1.782-.886 3.112-.752 1.234.124 2.503.523 3.388.893v9.923c-.918-.35-2.107-.692-3.287-.81-1.094-.111-2.278-.039-3.213.492V2.687zM8 1.783C7.015.936 5.587.81 4.287.94c-1.514.153-3.042.672-3.994 1.105A.5.5 0 0 0 0 2.5v11a.5.5 0 0 0 .707.455c.882-.4 2.303-.881 3.68-1.02 1.409-.142 2.59.087 3.223.877a.5.5 0 0 0 .78 0c.633-.79 1.814-1.019 3.222-.877 1.378.139 2.8.62 3.681 1.02A.5.5 0 0 0 16 13.5v-11a.5.5 0 0 0-.293-.455c-.952-.433-2.48-.952-3.994-1.105C10.413.809 8.985.936 8 1.783z"></path>
                    </svg> <%=tutorato.getDipartimento().toUpperCase(java.util.Locale.ROOT)%></li>
                </ul>
                <%if(user.isTutor() && tutorato.getStatus()==0){%>
                <button type="button" class="btn btn-light" data-bs-toggle="modal" data-bs-target="#accettaRichiesta">Accetta</button><%}%>
                <%if(user.isProfessoreReferente() && tutorato.getStatus()==2){%>
                <button type="button" class="btn btn-light" data-bs-toggle="modal" data-bs-target="#approvaRichiesta">Approva</button><%}%>
            </div>
            <div class="col-lg-4 col-sm-1">
                <div class="position-relative">
                    <img src="../image/undraw_web_developer_re_h7ie.svg" alt="">
                </div>
            </div>
        </div>
    </div>
</section>
<%
}
else if(supporto!=null){
    commento = supporto.getCommento();

%>
<section class="bg-info py-0 py-sm-5">
    <div class="container">
        <div class="row py-5">
            <div class="col-lg-8">
                <!-- Badge -->
                <%if(user.isTutor() && supporto.getStatus()==0){%>
                <h6 class="mb-3 font-base bg-warning text-white py-2 px-4 rounded-2 d-inline-block">Disponibile</h6>
                <%}else if(user.isTutor() && supporto.getStatus()==1){%>
                <h6 class="mb-3 font-base bg-dark text-white py-2 px-4 rounded-2 d-inline-block">Accettata</h6>
                <%}else if((user.isTutor() || user.isProfessoreReferente()) && supporto.getStatus()==2){%>
                <h6 class="mb-3 font-base bg-primary text-white py-2 px-4 rounded-2 d-inline-block">Completata (in attesa di approvazione)</h6>
                <%}else if(user.isTutor() && supporto.getStatus()==3){%>
                <h6 class="mb-3 font-base bg-success text-white py-2 px-4 rounded-2 d-inline-block">Approvata</h6>
                <%}else if(user.isStudente() && supporto.getStatus()==0){%>
                <h6 class="mb-3 font-base bg-warning text-white py-2 px-4 rounded-2 d-inline-block">In attesa</h6>
                <%}else if(user.isStudente() && supporto.getStatus()!=0){%>
                <h6 class="mb-3 font-base bg-success text-white py-2 px-4 rounded-2 d-inline-block">Completata</h6><%}%>
                <h1 class="text-light">Supporto Esame</h1>
                <div class="mb-0 ms-2">
                    <h6><p class="card-description text-light">Email Studente: <%=supporto.getStudenteEmail()%></p></h6>
                </div>
                <!-- Content -->
                <ul class="list-inline mb-4"><li class="list-inline-item h6 me-3 mb-1 mb-sm-0 text-light"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-calendar" viewBox="0 0 16 16">
                    <path d="M3.5 0a.5.5 0 0 1 .5.5V1h8V.5a.5.5 0 0 1 1 0V1h1a2 2 0 0 1 2 2v11a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V3a2 2 0 0 1 2-2h1V.5a.5.5 0 0 1 .5-.5zM1 4v10a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1V4H1z"></path>
                </svg> Data Esame: <%=supporto.getData().toUpperCase(java.util.Locale.ROOT)%></li>
                    <li class="list-inline-item h6 me-3 mb-1 mb-sm-0 text-light"><li class="list-inline-item h6 me-3 mb-1 mb-sm-0 text-light"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-clock" viewBox="0 0 16 16">
                    <path d="M8 3.5a.5.5 0 0 0-1 0V9a.5.5 0 0 0 .252.434l3.5 2a.5.5 0 0 0 .496-.868L8 8.71V3.5z"></path>
                    <path d="M8 16A8 8 0 1 0 8 0a8 8 0 0 0 0 16zm7-8A7 7 0 1 1 1 8a7 7 0 0 1 14 0z"></path>
                </svg>  Ora: <%=supporto.getData()%></li>
                    <li class="list-inline-item h6 me-3 mb-1 mb-sm-0 text-light"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-journal-bookmark" viewBox="0 0 16 16">
                        <path fill-rule="evenodd" d="M6 8V1h1v6.117L8.743 6.07a.5.5 0 0 1 .514 0L11 7.117V1h1v7a.5.5 0 0 1-.757.429L9 7.083 6.757 8.43A.5.5 0 0 1 6 8z"></path>
                        <path d="M3 0h10a2 2 0 0 1 2 2v12a2 2 0 0 1-2 2H3a2 2 0 0 1-2-2v-1h1v1a1 1 0 0 0 1 1h10a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1H3a1 1 0 0 0-1 1v1H1V2a2 2 0 0 1 2-2z"></path>
                        <path d="M1 5v-.5a.5.5 0 0 1 1 0V5h.5a.5.5 0 0 1 0 1h-2a.5.5 0 0 1 0-1H1zm0 3v-.5a.5.5 0 0 1 1 0V8h.5a.5.5 0 0 1 0 1h-2a.5.5 0 0 1 0-1H1zm0 3v-.5a.5.5 0 0 1 1 0v.5h.5a.5.5 0 0 1 0 1h-2a.5.5 0 0 1 0-1H1z"></path>
                    </svg> <%=supporto.getInsegnamento().toUpperCase(java.util.Locale.ROOT)%></li>
                    <li class="list-inline-item h6 me-3 mb-1 mb-sm-0 text-light"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-journal-bookmark" viewBox="0 0 16 16">
                        <path fill-rule="evenodd" d="M6 8V1h1v6.117L8.743 6.07a.5.5 0 0 1 .514 0L11 7.117V1h1v7a.5.5 0 0 1-.757.429L9 7.083 6.757 8.43A.5.5 0 0 1 6 8z"></path>
                        <path d="M3 0h10a2 2 0 0 1 2 2v12a2 2 0 0 1-2 2H3a2 2 0 0 1-2-2v-1h1v1a1 1 0 0 0 1 1h10a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1H3a1 1 0 0 0-1 1v1H1V2a2 2 0 0 1 2-2z"></path>
                        <path d="M1 5v-.5a.5.5 0 0 1 1 0V5h.5a.5.5 0 0 1 0 1h-2a.5.5 0 0 1 0-1H1zm0 3v-.5a.5.5 0 0 1 1 0V8h.5a.5.5 0 0 1 0 1h-2a.5.5 0 0 1 0-1H1zm0 3v-.5a.5.5 0 0 1 1 0v.5h.5a.5.5 0 0 1 0 1h-2a.5.5 0 0 1 0-1H1z"></path>
                    </svg> <%=supporto.getDipartimento().toUpperCase(java.util.Locale.ROOT)%></li>
                    <li class="list-inline-item h6 me-3 mb-1 mb-sm-0 text-light"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pencil" viewBox="0 0 16 16">
                        <path d="M12.146.146a.5.5 0 0 1 .708 0l3 3a.5.5 0 0 1 0 .708l-10 10a.5.5 0 0 1-.168.11l-5 2a.5.5 0 0 1-.65-.65l2-5a.5.5 0 0 1 .11-.168l10-10zM11.207 2.5 13.5 4.793 14.793 3.5 12.5 1.207 11.207 2.5zm1.586 3L10.5 3.207 4 9.707V10h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.293l6.5-6.5zm-9.761 5.175-.106.106-1.528 3.821 3.821-1.528.106-.106A.5.5 0 0 1 5 12.5V12h-.5a.5.5 0 0 1-.5-.5V11h-.5a.5.5 0 0 1-.468-.325z"></path>
                    </svg> <%=supporto.getDocente().toUpperCase(java.util.Locale.ROOT)%></li>
                    <li class="list-inline-item h6 me-3 mb-1 mb-sm-0 text-light"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-gear-wide-connected" viewBox="0 0 16 16">
                        <path d="M7.068.727c.243-.97 1.62-.97 1.864 0l.071.286a.96.96 0 0 0 1.622.434l.205-.211c.695-.719 1.888-.03 1.613.931l-.08.284a.96.96 0 0 0 1.187 1.187l.283-.081c.96-.275 1.65.918.931 1.613l-.211.205a.96.96 0 0 0 .434 1.622l.286.071c.97.243.97 1.62 0 1.864l-.286.071a.96.96 0 0 0-.434 1.622l.211.205c.719.695.03 1.888-.931 1.613l-.284-.08a.96.96 0 0 0-1.187 1.187l.081.283c.275.96-.918 1.65-1.613.931l-.205-.211a.96.96 0 0 0-1.622.434l-.071.286c-.243.97-1.62.97-1.864 0l-.071-.286a.96.96 0 0 0-1.622-.434l-.205.211c-.695.719-1.888.03-1.613-.931l.08-.284a.96.96 0 0 0-1.186-1.187l-.284.081c-.96.275-1.65-.918-.931-1.613l.211-.205a.96.96 0 0 0-.434-1.622l-.286-.071c-.97-.243-.97-1.62 0-1.864l.286-.071a.96.96 0 0 0 .434-1.622l-.211-.205c-.719-.695-.03-1.888.931-1.613l.284.08a.96.96 0 0 0 1.187-1.186l-.081-.284c-.275-.96.918-1.65 1.613-.931l.205.211a.96.96 0 0 0 1.622-.434l.071-.286zM12.973 8.5H8.25l-2.834 3.779A4.998 4.998 0 0 0 12.973 8.5zm0-1a4.998 4.998 0 0 0-7.557-3.779l2.834 3.78h4.723zM5.048 3.967c-.03.021-.058.043-.087.065l.087-.065zm-.431.355A4.984 4.984 0 0 0 3.002 8c0 1.455.622 2.765 1.615 3.678L7.375 8 4.617 4.322zm.344 7.646.087.065-.087-.065z"></path>
                    </svg> <%=supporto.getModalitaEsame().toUpperCase(java.util.Locale.ROOT)%></li>
                    <li class="list-inline-item h6 me-3 mb-1 mb-sm-0 text-light"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-easel" viewBox="0 0 16 16">
                        <path d="M8 0a.5.5 0 0 1 .473.337L9.046 2H14a1 1 0 0 1 1 1v7a1 1 0 0 1-1 1h-1.85l1.323 3.837a.5.5 0 1 1-.946.326L11.092 11H8.5v3a.5.5 0 0 1-1 0v-3H4.908l-1.435 4.163a.5.5 0 1 1-.946-.326L3.85 11H2a1 1 0 0 1-1-1V3a1 1 0 0 1 1-1h4.954L7.527.337A.5.5 0 0 1 8 0zM2 3v7h12V3H2z"></path>
                    </svg><%=supporto.getTipoAssistenza().toUpperCase(java.util.Locale.ROOT)%></li>
                    <li class="list-inline-item h6 me-3 mb-1 mb-sm-0 text-light"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-plus-circle" viewBox="0 0 16 16">
                        <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"></path>
                        <path d="M8 4a.5.5 0 0 1 .5.5v3h3a.5.5 0 0 1 0 1h-3v3a.5.5 0 0 1-1 0v-3h-3a.5.5 0 0 1 0-1h3v-3A.5.5 0 0 1 8 4z"></path>
                    </svg> <%=supporto.getEventualiAusili().toUpperCase(java.util.Locale.ROOT)%></li>
                    <li class="list-inline-item h6 me-3 mb-1 mb-sm-0 text-light"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pin-map" viewBox="0 0 16 16">
                        <path fill-rule="evenodd" d="M3.1 11.2a.5.5 0 0 1 .4-.2H6a.5.5 0 0 1 0 1H3.75L1.5 15h13l-2.25-3H10a.5.5 0 0 1 0-1h2.5a.5.5 0 0 1 .4.2l3 4a.5.5 0 0 1-.4.8H.5a.5.5 0 0 1-.4-.8l3-4z"></path>
                        <path fill-rule="evenodd" d="M8 1a3 3 0 1 0 0 6 3 3 0 0 0 0-6zM4 4a4 4 0 1 1 4.5 3.969V13.5a.5.5 0 0 1-1 0V7.97A4 4 0 0 1 4 3.999z"></path>
                    </svg> Luogo: <%=supporto.getLuogo().toUpperCase(java.util.Locale.ROOT)%></li>
                </ul>
                <%if(user.isTutor() && supporto.getStatus()==0){%>
                <button type="button" class="btn btn-light" data-bs-toggle="modal" data-bs-target="#accettaRichiesta">Accetta</button><%}%>
                <%if(user.isProfessoreReferente() && supporto.getStatus()==2){%>
                <button type="button" class="btn btn-light" data-bs-toggle="modal" data-bs-target="#approvaRichiesta">Approva</button><%}%>
            </div>
            <div class="col-lg-4 col-sm-1">
                <div class="position-relative">
                    <img src="../image/undraw_exams_g-4-ow.svg" alt="">
                </div>
            </div>
        </div>
    </div>
</section>
<%}%>
<div class="modal fade" id="accettaRichiesta" tabindex="-1" aria-labelledby="accettaRichiesta" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Accetta Richiesta</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>

            <div class="modal-body">Vuoi accettare la richiesta?
                <form action="../AccettazioneRichiesta" method="get">
                    <div class="mb-3">
                        <label for="message-text" class="col-form-label">Commento:</label>
                        <textarea class="form-control" name="commento" id="message-text"></textarea>
                    </div>
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-outline-info">Conferma</button>
                </form>
            </div>
            <div class="modal-footer">
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="approvaRichiesta" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Approva Richiesta</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">Vuoi approvare la richiesta?</div>
            <div class="modal-footer">
                <form action="../ApprovazioneRichiesta" method="get">
                    <button type="submit" class="btn btn-outline-info">Approva</button>
                </form>
            </div>
        </div>
    </div>
</div>
<footer>
    <%@ include file="../fragment/footer.html" %>
</footer>
</body>
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
</html>
