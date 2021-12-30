<%@ page import="model.bean.UserBean" %><%--
  Created by IntelliJ IDEA.
  User: Giovanni Toriello
  Date: 28/12/2021
  Time: 21:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         import="model.bean.UserBean" import="model.dao.UserDAO"
%>
<%@ page import="java.util.Collection" %>
<%
    UserBean bean = new UserBean();
    Collection<UserBean> utenti = (Collection<UserBean>) session.getAttribute("usrList");
    if (utenti == null) {
        response.sendRedirect("../ViewListaUsers");
        return;
    }
%>
<html>
<head>
    <title>Utente</title>
    <link type="text/css" rel="stylesheet" href="../css/bootstrap.css">
</head>
<body>
<h3>
    Lista
    <small class="text-muted">
        degli utenti
    </small>
</h3>

<div class="table-responsive  mt-1">
    <table class="table select-table">
        <thead>
        <tr>
            <th>Nome</th>
            <th>E-mail</th>
            <th>Ruolo</th>
            <th></th>
        </tr>
        </thead>
            <%
    for(UserBean b : utenti){
        if(!b.isPersonaleAmministrativo()){
            String nome = ""+b.getNome()+" "+b.getCognome();
            String ruolo = b.getRuolo();
            if(ruolo.equals("S")){
                ruolo = "Studente";
            }
            else if(ruolo.equals("T")){
                ruolo = "Tutor";
            }
            else if(ruolo.equals("P")){
                ruolo = "Professore Referente";
            }
    %>
        <tr>
            <td>
                <div class="d-flex ">
                    <% if (ruolo.equals("Professore Referente")){ %>
                    <img src="https://cdn-icons-png.flaticon.com/128/4645/4645208.png" data-src="https://cdn-icons-png.flaticon.com/128/4645/4645208.png" alt="Briefcase icon" title="Briefcase icon" width="44" height="44" class="lzy lazyload--done" srcset="https://cdn-icons-png.flaticon.com/128/4645/4645208.png 4x">
                    <%}
                    else if (ruolo.equals("Studente")){%>
                    <img src="https://cdn-icons.flaticon.com/png/128/4645/premium/4645290.png?token=exp=1640875737~hmac=67099a32079fc0f48f15fa13d338118a" data-src="https://cdn-icons.flaticon.com/png/128/4645/premium/4645290.png?token=exp=1640875737~hmac=67099a32079fc0f48f15fa13d338118a" alt="Books icon" title="Books icon" width="44" height="44" class="lzy lazyload--done" srcset="https://cdn-icons.flaticon.com/png/128/4645/premium/4645290.png?token=exp=1640875737~hmac=67099a32079fc0f48f15fa13d338118a 4x">
                    <%}
                    else if (ruolo.equals("Tutor")){%>
                    <img src="https://cdn-icons-png.flaticon.com/128/4645/4645232.png" data-src="https://cdn-icons-png.flaticon.com/128/4645/4645232.png" alt="Graduation hat icon" title="Graduation hat icon" width="44" height="44" class="lzy lazyload--done" srcset="https://cdn-icons-png.flaticon.com/128/4645/4645232.png 4x">
                    <%}%>
                    <div id="nome">
                        <h6><%=nome%>
                        </h6>
                    </div>
                </div>
            </td>
            <td>
                <h6><%=b.getEmail()%>
                </h6>
            </td>
            <td>
                <div class="badge badge-opacity-warning"><%=ruolo%>
                </div>
            </td>
            <td>
                <form action="../UserProfile?usrEmail=<%=b.getEmail()%>&ruolo=<%=b.getRuolo()%>" method="post">
                    <button type="submit" class="btn btn-success btn-rounded btn-fw">Visualizza</button>
                </form>
            </td>
        </tr>
            <% }} %>

</div>
</body>
</html>
