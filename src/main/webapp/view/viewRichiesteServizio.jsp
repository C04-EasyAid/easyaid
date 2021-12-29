<%@ page import="java.util.Collection" %>
<%@ page import="model.bean.TutoratoDidatticoBean" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.dao.TutoratoDidatticoDAO" %>
<%@ page import="model.bean.TutorBean" %>
<%@ page import="model.dao.SupportoEsameDAO" %>
<%@ page import="model.bean.SupportoEsameBean" %><%--
<%--
  Created by IntelliJ IDEA.
  User: Martina Giugliano
  Date: 29/12/2021
  Time: 15:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ListaRichieste</title>
</head>
<body>
<div id="corpo">
    <h1>Elenco Richieste</h1>
    <table style="border-collapse: collapse; background-color: aqua;border: 1px solid black">
        <%  TutorBean bean = (TutorBean) session.getAttribute("tutor");
            Collection<TutoratoDidatticoBean> richiesteTutorato = new ArrayList<>();
            richiesteTutorato = (Collection<TutoratoDidatticoBean>) session.getAttribute("richiesteTutoratoNonAccettate");
            Collection<SupportoEsameBean> richesteSupporto = new ArrayList<>();
            richesteSupporto = (Collection<SupportoEsameBean>) session.getAttribute("richiesteEsamiNonAccettate");
            for(TutoratoDidatticoBean b : richiesteTutorato){

        %>

        <tr><td>Tutorato Didattico</td>
        <tr><td><%=b.getDateDisponibili()%></td></tr>
        <tr><td><%=b.getOreDisponibili()%></td></tr>
        <tr><td><%=Integer.toString(b.getOreRichieste())%></td></tr>
        <tr><td><%=b.getStudenteEmail()%></td></tr><br><br>
        <%}%>
        <%  for(SupportoEsameBean s : richesteSupporto){%>
        <tr><td>Supporto Esame</td></tr>
        <tr><td><%=s.getData()%></td></tr>
        <tr><td><%=s.getOra()%></td></tr>
        <tr><td><%=s.getOreRichieste()%></td></tr>
        <tr><td><%=s.getDocente()%></td></tr>
        <tr><td><%=s.getModalitaEsame()%></td></tr>
        <tr><td><%=s.getEventualiAusili()%></td></tr>
        <tr><td><%=s.getTipoAssistenza()%></td></tr>
        <tr><td><%=s.getInsegnamento()%></td></tr>
        <tr> <td><%=s.getLuogo()%></td></tr>
        <tr><td><%=s.getDipartimento()%></td></tr>

    </table>
    <%}%>
</div>

</body>
</html>