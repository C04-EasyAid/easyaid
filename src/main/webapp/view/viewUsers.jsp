<%@ page import="model.bean.UserBean" %><%--
  Created by IntelliJ IDEA.
  User: Giovanni Toriello
  Date: 28/12/2021
  Time: 21:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         import="model.bean.UserBean" import="model.dao.UserDAO"
%>
<%@ page import="java.util.Collection" %>
<%
    UserBean bean = new UserBean();
    Collection<UserBean> utenti = (Collection<UserBean>) session.getAttribute("usrList");
    if(utenti == null) {
        response.sendRedirect("../ViewListaUsers");
        return;
    }
    %>
<html>
<head>
    <title>Utente</title>
</head>
<body>
<h1>Lista degli utenti</h1>
<%
    for(UserBean b : utenti){
        if(!b.isPersonaleAmministrativo()){
    %>

<fieldset>
    <label><p><%=b.getNome()%></p></label>
    <label><p><%=b.getCognome()%></p></label>
    <label><p><%=b.getEmail()%></p></label>
    <label><p><a href="../UserProfile?usrEmail=<%=b.getEmail()%>&ruolo=<%=b.getRuolo()%>">Seleziona</a></p></label>
</fieldset><br>

<% }} %>
</body>
</html>
