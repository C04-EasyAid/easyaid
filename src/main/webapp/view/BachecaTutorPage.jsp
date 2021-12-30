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
    <link type="text/css" rel="stylesheet" href="../css/bootstrap.css">
</head>
<body>
<div class="col-lg-12 stretch-card">
    <div class="card">
        <div class="card-body">
            <h4 class="card-title">Elenco Richieste</h4>
            <div class="table-responsive pt-3">
                <table class="table table-bordered">
                    <thead>
                    <tr>
                        <th>
                            ID
                        </th>
                        <th>
                            Data
                        </th>
                        <th>
                            Servizio
                        </th>
                        <th>
                            Dipartimento
                        </th>
                        <th>
                            Status
                        </th>
                    </tr>
                    </thead>
                    <tbody>
                    <% TutoratoDidatticoDAO daoT = new TutoratoDidatticoDAO();
                        SupportoEsameDAO daoS = new SupportoEsameDAO();
                        Collection<TutoratoDidatticoBean> richiesteTutorato = new ArrayList<>();
                        richiesteTutorato = daoT.doRetrieveRichiesteTutoratoDidatticoNonAccettate();
                        Collection<SupportoEsameBean> richesteSupporto = new ArrayList<>();
                        richesteSupporto = daoS.doRetrieveRichiesteSupportoEsameNonAccettate();
                        for (TutoratoDidatticoBean b : richiesteTutorato) {

                    %>
                    <tr class="table-info">
                        <td>
                            Tutorato Didattico
                        </td>
                        <td>
                            <%=b.getDateDisponibili()%>
                        </td>
                        <td>
                            <%=b.getOreDisponibili()%>
                        </td>
                        <td>
                            <%=Integer.toString(b.getOreRichieste())%>
                        </td>
                        <td>
                            <%=b.getStudenteEmail()%>
                        </td>
                        <td>
                            <a href="../SingolaRichiestaServlet?idTutorato=<%=b.getId()%>">Seleziona</a>
                        </td>
                    </tr>
                    <%}%>
                    <% for (SupportoEsameBean s : richesteSupporto) {%>
                    <tr>
                        <td>Supporto Esame</td>
                        <td><%=s.getData()%>
                        </td>
                        <td><%=s.getOra()%>
                        </td>
                        <td><%=s.getOreRichieste()%>
                        </td>
                        <td><%=s.getDocente()%>
                        </td>
                        <td><%=s.getModalitaEsame()%>
                        </td>
                        <td><%=s.getEventualiAusili()%>
                        </td>
                        <td><%=s.getTipoAssistenza()%>
                        </td>
                        <td><%=s.getInsegnamento()%>
                        </td>
                        <td><%=s.getLuogo()%>
                        </td>
                        <td><%=s.getDipartimento()%>
                        </td>
                        <td><a href="../SingolaRichiestaServlet?idSupporto=<%=s.getId()%>">Seleziona</a></td>
                    </tr>
                    </tbody>

                </table>
                <%}%>
            </div>
        </div>
    </div>
</div>

</body>
</html>