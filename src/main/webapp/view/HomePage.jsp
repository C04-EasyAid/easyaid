<%--
  Created by IntelliJ IDEA.
  User: Giovanni Toriello
  Date: 28/12/2021
  Time: 15:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
    <link type="text/css" rel="stylesheet" href="../css/bootstrap.css">
</head>
<body>
<header>
    <%@ include file="../fragment/navbar.jsp" %>
</header>
<a href="RegistraUtentePage.jsp?inserimento=Studente">Inserisci Studente</a>
<a href="RegistraUtentePage.jsp?inserimento=Tutor">Inserisci Tutor</a>
<a href="RegistraUtentePage.jsp?inserimento=ProfessoreReferente">Inserisci Professore Referente</a>
</body>
</html>
