<%@ page import="model.bean.TutoratoDidatticoBean" %>
<%@ page import="model.bean.SupportoEsameBean" %><%--
  Created by IntelliJ IDEA.
  User: Martina Giugliano
  Date: 29/12/2021
  Time: 22:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Singola Richiesta</title>
</head>
<body>
<h1>Richiesta Selezionata</h1>
<%
    TutoratoDidatticoBean tutorato = (TutoratoDidatticoBean) session.getAttribute("tutorato");
    SupportoEsameBean supporto = (SupportoEsameBean) session.getAttribute("supporto");
    if(tutorato!=null){
%>
<fieldset>
    <label><p><%=tutorato.getStudenteEmail()%></p></label>
    <label><p><%=tutorato.getOreDisponibili()%></p></label>
    <label><p><%=tutorato.getInsegnamento()%></p></label>
    <label><p><%=tutorato.getDipartimento()%></p></label>
    <label><p><%=tutorato.getOreRichieste()%></p></label>
</fieldset>
<%
    }
    if(supporto==null){

%>
<fieldset>
    <label><p><%=supporto.getStudenteEmail()%></p></label>
    <label><p><%=supporto.getData()%></p></label>
    <label><p><%=supporto.getOra()%></p></label>
    <label><p><%=supporto.getOreRichieste()%></p></label>
    <label><p><%=supporto.getLuogo()%></p></label>
    <label><p><%=supporto.getInsegnamento()%></p></label>
    <label><p><%=supporto.getDocente()%></p></label>
    <label><p><%=supporto.getModalitaEsame()%></p></label>
    <label><p><%=supporto.getTipoAssistenza()%></p></label>
    <label><p><%=supporto.getEventualiAusili()%></p></label>
</fieldset>
<%
    }%>
</body>
</html>