<%@ page import="java.util.Collection" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.dao.LezioneDAO" %>
<%--
  Created by IntelliJ IDEA.
  User: Serena
  Date: 28/12/2021
  Time: 17:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         import="model.dao.LezioneDAO" import="model.bean.TutoratoDidatticoBean" import="java.util.Collection" import="model.bean.LezioneBean"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="model.bean.*" %>
<html>
<head>
    <title>Elenco lezioni</title>
    <link type="text/css" rel="stylesheet" href="../css/bootstrap.css">
    <link type="text/css" rel="stylesheet" href="../css/viewLezioniST.css">
</head>
<body>
<div id="corpo">
    <h1 class="testo">Lezioni programmate</h1> <br><br>
    <div id="lezione">
        <form method="get" action="../SingolaLezioneServlet">
            <%
                UserBean studente = (UserBean) session.getAttribute("studente");
                TutoratoDidatticoBean bean = (TutoratoDidatticoBean) session.getAttribute("tutorato");
                Collection<LezioneBean> lezioni = new ArrayList<>();
                lezioni = LezioneDAO.doRetrieveLezioneByStudente("marcoverdi4@studenti.unisa.it");
                for (LezioneBean x : lezioni){
                    String data = new SimpleDateFormat("dd-MM-yyyy").format(x.getData());

            %>
            <fieldset>
                <div class="table-responsive pt-3">
                    <table class="table table-bordered" >
                        <thead>
                        <tr>
                            <th>Ora inizio</th>
                            <th>Ora fine</th>
                            <th>Data</th>
                            <th>Insegnamento</th>
                            <th>Tutor</th>

                        </tr>
                        </thead>
                        <tbody>
                        <tr class="table-info">
                            <td><%=x.getOraInizio()%></td>
                            <td><%=x.getOraFine()%></td>
                            <td><%=data%></td>
                            <td><%=x.getInsegnamento()%></td>
                            <td><%=x.getTutor()%> <a href="../SingolaLezione?lezione=<%=x.getId()%>" class="btn btn-info btn-rounded btn-fw" style="background: #59cfcd" >Seleziona</a></td>

                        </tr>


                        </tbody>
                    </table>
                </div>
            </fieldset>
            <br>
            <% } %>

        </form>
    </div>
</div>
</body>
</html>
