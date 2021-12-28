<%@ page import="model.bean.UserBean" %><%--
  Created by IntelliJ IDEA.
  User: 130309
  Date: 28/12/2021
  Time: 21:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         import="model.bean.UserBean" import="model.dao.UserDAO"
%>
<%@ page import="java.util.Collection" %>
<html>
<head>
    <title>Utente</title>
</head>
<body>
<%
    UserBean bean = new UserBean();
    Collection<UserBean> utenti = UserDAO.doRetrieveAll();
    for(UserBean b : utenti){
    String email = b.getEmail();
    String ruolo = b.getRuolo();
    %>

<fieldset>
    <label><p><%=b.getNome()%></p></label>
    <label><p><%=b.getCognome()%></p></label>
    <label><p><%=email%></p></label>
    <label><p><a href="UserProfile&usrEmail=<%=email%>&ruolo="<%=ruolo%>">Seleziona</a></p></label>
</fieldset><br>

<% } %>
</body>
</html>
