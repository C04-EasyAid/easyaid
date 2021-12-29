<%--
  Created by IntelliJ IDEA.
  User: Giovanni Toriello
  Date: 29/12/2021
  Time: 15:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String inserimento = (String) request.getParameter("inserimento");
%>
<html>
<head>
    <title>Inserimento Utente</title>
    <link type="text/css" rel="stylesheet" href="../css/inserimento.css">
    <link type="text/css" rel="stylesheet" href="../css/bootstrap.css">

</head>
<body>
<section class="vh-100 bg-image">
    <div class="mask d-flex align-items-center h-100 gradient-custom-3">
        <div class="container h-100">
            <div class="row d-flex justify-content-center align-items-center h-100">
                <div class="col-12 col-md-9 col-lg-7 col-xl-6 contenitore">
                    <div class="card" style="border-radius: 15px;">
                        <div class="card-body p-5">
                            <h2 class="text-uppercase text-center mb-5">Inserimento</h2>
<form action="../register" method="get">
    <fieldset>
        <input type="hidden" name="ruolo" value=<%=inserimento%> />

        <div class="form-outline mb-4 ">
            <label class="form-label" for="nome">Nome</label>
            <input type="text" id="nome" class="form-control form-control-lg bordo" />
        </div>

        <div class="form-outline mb-4">
            <label class="form-label" for="cognome">Cognome</label>
            <input type="text" id="cognome" class="form-control form-control-lg" />
        </div>

        <div class="form-outline mb-4">
            <label class="form-label" for="email">Email</label>
            <input type="email" id="email" class="form-control form-control-lg" />
        </div>

        <div class="form-outline mb-4">
            <label class="form-label" for="pw">Password</label>
            <input type="password" id="pw" class="form-control form-control-lg" />
        </div>

        <%
            if(inserimento.equals("Studente")){
        %>
        <div class="form-outline mb-4">
            <label class="form-label" for="tipoDisabilità">Tipo Disabilità</label>
            <input type="text" id="tipoDisabilità" class="form-control form-control-lg" />
        </div>

        <div class="form-outline mb-4">
            <label class="form-label" for="specificheDisturbo">Specifiche Disturbo</label>
            <input type="text" id="specificheDisturbo" class="form-control form-control-lg" />
        </div>

        <div class="form-outline mb-4">
            <label class="form-label" for="percentualeDisabilita">Percentuale Disabilità</label>
            <input type="text" id="percentualeDisabilita" class="form-control form-control-lg" />
        </div>

        <div class="form-outline mb-4">
            <label class="form-label" for="oreDisponibiliStudente">Ore Disponibili</label>
            <input type="text" id="oreDisponibiliStudente" class="form-control form-control-lg" />
        </div>

        <%}%>
        <%
            if(inserimento.equals("Tutor")){
        %>
        <div class="form-outline mb-4">
            <label class="form-label" for="dipartimentoTutor">Dipartimento</label>
            <input type="text" id="dipartimentoTutor" class="form-control form-control-lg" />
        </div>

        <div class="form-outline mb-4">
            <label class="form-label" for="qualifica">Qualifica</label>
            <input type="text" id="qualifica" class="form-control form-control-lg" />
        </div>

        <div class="form-outline mb-4">
            <label class="form-label" for="oreDisponibiliTutor">Ore Disponibili</label>
            <input type="text" id="oreDisponibiliTutor" class="form-control form-control-lg" />
        </div>

        <div class="form-outline mb-4">
            <label class="form-label" for="oreSvolte">Ore Svolte</label>
            <input type="text" id="oreSvolte" class="form-control form-control-lg" />
        </div>

        <%}%>
        <%
            if(inserimento.equals("ProfessoreReferente")){
        %>
        <div class="form-outline mb-4">
            <label class="form-label" for="dipartimentoProf">Dipartimento</label>
            <input type="text" id="dipartimentoProf" class="form-control form-control-lg" />
        </div>
        <%}%>
    </fieldset>

    <div class="d-flex justify-content-center">
        <button type="button" name="register" class="btn btn-success btn-block btn-lg gradient-custom-4 text-body">Inserisci</button>
    </div>

</form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
</body>
</html>
