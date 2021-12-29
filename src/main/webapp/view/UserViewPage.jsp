<%@ page import="model.bean.UserBean" %>
<%@ page import="model.bean.TutorBean" %>
<%@ page import="model.dao.UserDAO" %><%--
  Created by IntelliJ IDEA.
  User: Giovanni Toriello
  Date: 29/12/2021
  Time: 09:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Profilo Utente</title>
</head>
<body>
<%
    TutorBean bean = (TutorBean) session.getAttribute("usrProfile");
    String nome = null;
    String cognome = null;
    UserBean user = new UserBean();

%>
<fieldset>
    <label><p><%=bean.getEmailTutor()%></p></label>
    <label><p><%=bean.getDipartimento()%></p></label>
    <label><p><%=bean.getQualifica()%></p></label>
    <label><p><%=Integer.toString(bean.getOreDisponibili())%></p></label>
    <label><p><%=Integer.toString(bean.getOreSvolte())%></p></label>
</fieldset>
</body>
</html>
