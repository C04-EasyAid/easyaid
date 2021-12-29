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

</head>
<body>
<form action="../register" method="get">
    <fieldset>
        <input type="hidden" name="ruolo" value=<%=inserimento%> />
        Nome:<input type="text" name="nome" id="nome"><br>
        Cognome:<input type="text" name="cognome" id="cognome"><br>
        E-mail:<input type="email" name="email" id="email"><br>
        Password:<input type="text" name="password" id="password"><br>
    </fieldset>
    <%
        if(inserimento.equals("Studente")){
        %>

    <fieldset>
    Tipo di Disabilità:<input type="text" name="tipoDisabilita" id="tipoDisabilita"><br>
        Specifiche Disturbo:<input type="text" name="specificheDisturbo" id="specificheDisturbo"><br>
        Percentuale Disabilità:<input type="text" name="percentualeDisabilita" id="percentualeDisabilita"><br>
       Ore Disponibili:<input type="text" name="oreDisponibiliStudente" id="oreDisponibiliStudente">
    </fieldset>
    <%}%>
    <%
        if(inserimento.equals("Tutor")){
    %>

    <fieldset>
       Dipartimento:<input type="text" name="dipartimentoTutor" id="dipartimentoTutor"><br>
        Qualifica:<input type="text" name="qualifica" id="qualifica"><br>
        Ore Disponibili:<input type="text" name="oreDisponibiliTutor" id="oreDisponibiliTutor">
        Ore Svolte:<input type="text" name="oreSvolte" id="oreSvolte"><br>
    </fieldset>
    <%}%>
    <%
        if(inserimento.equals("ProfessoreReferente")){
    %>

    <fieldset>
        Dipartimento:<input type="text" name="dipartimentoProf" id="dipartimentoProf"><br>
    </fieldset>
    <%}%>
    <input type="submit" name="register" value="Inserisci">
</form>
</body>
</html>
