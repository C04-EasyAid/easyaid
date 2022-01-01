<%@ page import="model.bean.UserBean" %>
<%@ page import="model.bean.TutorBean" %>
<%@ page import="model.dao.UserDAO" %>
<%@ page import="model.bean.StudenteBean" %>
<%@ page import="model.bean.ProfessoreReferenteBean" %><%--
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
<header>
    <%@ include file="../fragment/navbar.jsp" %>
</header>
<%
    if(user.isTutor()) {
        TutorBean bean = (TutorBean) session.getAttribute("usrProfile");
%>
<fieldset>
    <label><p><%=user.getNome()%></p></label>
    <label><p><%=user.getCognome()%></p></label>
    <label><p><%=bean.getEmailTutor()%></p></label>
    <label><p><%=bean.getDipartimento()%></p></label>
    <label><p><%=bean.getQualifica()%></p></label>
    <label><p><%=Integer.toString(bean.getOreDisponibili())%></p></label>
    <label><p><%=Integer.toString(bean.getOreSvolte())%></p></label>
</fieldset>
    <%}else if(user.isStudente()) {
        StudenteBean bean = (StudenteBean) session.getAttribute("usrProfile");
        %>
<fieldset>
    <label><p><%=user.getNome()%></p></label>
    <label><p><%=user.getCognome()%></p></label>
    <label><p><%=bean.getEmail()%></p></label>
    <label><p><%=bean.getTipoDisabilita()%></p></label>
    <label><p><%=bean.getSpecificheDisturbo()%></p></label>
    <label><p><%=Integer.toString(bean.getPercentualeDisabilita())%></p></label>
    <label><p><%=Integer.toString(bean.getOreDisponibili())%></p></label>
</fieldset>
    <%}
    else if(user.isProfessoreReferente()) {
        ProfessoreReferenteBean bean = (ProfessoreReferenteBean) session.getAttribute("usrProfile");
        %>
<fieldset>
    <label><p><%=user.getNome()%></p></label>
    <label><p><%=user.getCognome()%></p></label>
    <label><p><%=bean.getEmail()%></p></label>
    <label><p><%=bean.getDipartimento()%></p></label>
</fieldset>
   <%}%>

</body>
</html>
