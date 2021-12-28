<%@ page import="java.util.Collection" %>
<%@ page import="model.bean.TutoratoDidatticoBean" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.dao.TutoratoDidatticoDAO" %>
<%@ page import="model.bean.TutorBean" %>
<%@ page import="model.dao.SupportoEsameDAO" %>
<%@ page import="model.bean.SupportoEsameBean" %><%--
  Created by IntelliJ IDEA.
  User: Martina Giugliano
  Date: 28/12/2021
  Time: 22:24
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
    <table>
        <%  TutorBean bean = (TutorBean) session.getAttribute("tutor");
            Collection<TutoratoDidatticoBean> richiesteTutorato = new ArrayList<>();
            TutoratoDidatticoDAO tutoratoDao = new TutoratoDidatticoDAO();
            richiesteTutorato = tutoratoDao.doRetrieveAllRichiesteTutoratoDidatticoCompletate();
            Collection<SupportoEsameBean> richesteSupporto = new ArrayList<>();
            SupportoEsameDAO esameDAO = new SupportoEsameDAO();
            richesteSupporto = esameDAO.doRetrieveAllRichiesteSupportoEsameCompletate();
            for(TutoratoDidatticoBean b : richiesteTutorato){
                if(b.getStatus()==0){
                    for (SupportoEsameBean s : richesteSupporto){
                        if(s.getStatus()==0){

        %>
        <tr><td>Tutorato Didattico</td><tr><td><%=b.getDateDisponibili()%></td><td><%=b.getOreDisponibili()%></td><td><%=Integer.toString(b.getOreRichieste())%>
        <td><%=s.getDipartimento()%></td>
    </tr>


        <tr><td>Supporto Esame</td> <tr><td><%=s.getData()%></td><td><%=s.getOra()%></td><td><%=s.getOreRichieste()%></td><td><%=s.getDocente()%></td>
        <td><%=s.getModalitaEsame()%></td><td><%=s.getEventualiAusili()%></td><td><%=s.getTipoAssistenza()%></td><td><%=s.getInsegnamento()%></td>
        <td><%=s.getLuogo()%></td><td><%=s.getDipartimento()%></td>
    </tr>

    </table>
    <%}}}}%>
</div>

</body>
</html>