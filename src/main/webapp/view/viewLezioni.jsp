<%@ page import="java.util.Collection" %>
<%@ page import="model.bean.LezioneBean" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.dao.LezioneDAO" %>
<%@ page import="model.bean.TutorBean" %>
<%@ page import="model.bean.TutoratoDidatticoBean" %><%--
  Created by IntelliJ IDEA.
  User: Serena
  Date: 28/12/2021
  Time: 17:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         import="model.dao.LezioneDAO" import="model.bean.TutoratoDidatticoBean" import="java.util.Collection" import="model.bean.LezioneBean"%>
<%@ page import="java.text.SimpleDateFormat" %>
<html>
<head>
    <title>Elenco lezioni</title>
</head>
<body>
<div id="corpo">
    <h1>Lezioni programmate</h1> <br><br>
    <div id="lezione">
        <%
            TutoratoDidatticoBean bean = (TutoratoDidatticoBean) session.getAttribute("tutorato");
            Collection<LezioneBean> lezioni = new ArrayList<>();
            lezioni = LezioneDAO.doRetrieveLezione(bean.getId());
                        for (LezioneBean x : lezioni){
            String data = new SimpleDateFormat("dd-MM-yyyy").format(x.getData());

        %>
        <fieldset>
            <label><p><%=x.getOraInizio()%></p></label>
            <label><p><%=x.getOraFine()%></p></label>
            <label><p><%=data%></p></label>
            <label><p><%=x.getTutor()%></p></label>
        </fieldset>
        <br>
        <% } %>
    </div>
</div>
</body>
</html>