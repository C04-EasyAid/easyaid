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
</head>
<body>
<header>
    <%@ include file="../fragment/navbar.jsp" %>
</header>
<a href="RegisterUtente.jsp?inserimento=Studente">Inserisci Studente</a>
<a href="RegisterUtente.jsp?inserimento=Tutor">Inserisci Tutor</a>
<a href="RegisterUtente.jsp?inserimento=ProfessoreReferente">Inserisci Professore Referente</a>
</body>
</html>
