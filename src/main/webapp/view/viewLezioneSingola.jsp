<%@ page import="model.bean.LezioneBean" %>
<%@ page import="java.util.Collection" %>
<%@ page import="model.bean.CommentoBean" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: Mariagiovanna
  Date: 29/12/2021
  Time: 12:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Singola lezione</title>
</head>
<body>
<%
    LezioneBean lezione = (LezioneBean) session.getAttribute("lezione");
    Collection<CommentoBean> commenti = (Collection<CommentoBean>) session.getAttribute("listaCommenti");
    String data = new SimpleDateFormat("dd-MM-yyyy").format(lezione.getData());
%>
<fieldset>
    <label><p><%=data%</p></label>
            <label><p><%=lezione.getOraInizio()%></p></label>
    <label><p><%=lezione.getOraFine()%></p></label>
    <label><p><%=lezione.getTutor()%></p></label>
</fieldset>
<fieldset>
    <%
        String mittente = null;
        for(CommentoBean bean : commenti){
            if(bean.getStudente()!=null){
                mittente = bean.getStudente();
            }
            else{
                mittente = bean.getTutor();
            }
    %>
    <label>
        <p><%=mittente%></p>
        <p><%=bean.getTesto()%></p>
        <p><%=bean.getOra()%></p>
        <p><%=bean.getData()%></p>
    </label>

    <%}%>
    <input type="text" name="Commento" id="Commento">
</fieldset>
</body>
</html>
