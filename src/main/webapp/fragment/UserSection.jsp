<%@ page import="model.bean.UserBean" %><%--
  Created by IntelliJ IDEA.
  User: Giovanni Toriello
  Date: 01/01/2022
  Time: 19:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String ruolo = user.getRuolo();
    if(ruolo.equals("S")){
        ruolo = "Studente";
    }
    else if(ruolo.equals("T")){
        ruolo = "Tutor";
    }
    else if(ruolo.equals("P")){
        ruolo = "Professore Referente";
    }
    else if(ruolo.equals("PA"))
    {
        ruolo = "Admin";
    }
%>
    <!-- Main banner background image -->
    <div class="container-fluid px-0">
        <div class="bg-bg-info h-100px h-md-200px rounded-0" style="background:#59cfcd no-repeat center center; background-size:cover;">
    </div>
    <div class="container mt-n4">
        <div class="row">
            <!-- Profile banner START -->
            <div class="col-12">
                <div class="card bg-transparent card-body p-0">
                    <div class="row d-flex justify-content-between">
                        <!-- Avatar -->
                        <div class="col-auto mt-4 mt-md-0">
                            <div class="avatar avatar-xxl mt-n3">
                                <%if(ruolo.equals("Studente")){%>
                                <div class="avatar-img rounded-circle bg-info"><span class="text-white position-absolute top-50 start-50 translate-middle fw-bold fs-1"><%=user.getNome().substring(0,1)+ user.getCognome().substring(0,1)%></span></div><%}%>
                                <%if(ruolo.equals("Tutor")){%>
                                <div class="avatar-img rounded-circle bg-success"><span class="text-white position-absolute top-50 start-50 translate-middle fw-bold fs-1"><%=user.getNome().substring(0,1)+ user.getCognome().substring(0,1)%></span></div><%}%>
                                <%if(ruolo.equals("Professore Referente")){%>
                                <div class="avatar-img rounded-circle bg-warning"><span class="text-white position-absolute top-50 start-50 translate-middle fw-bold fs-1"><%=user.getNome().substring(0,1)+ user.getCognome().substring(0,1)%></span></div><%}%>
                                <span class="badge bg-success text-white rounded-pill position-absolute top-50 start-100 translate-middle mt-4 mt-md-5 ms-n3 px-md-3" style="background:#59cfcd !important;"><%=ruolo%></span>
                            </div>
                        </div>
                        <!-- Profile info -->
                        <div class="col d-md-flex justify-content-between align-items-center mt-4">
                            <div>
                                <h1 class="my-1 fs-4"><%=user.getNome()+" "+ user.getCognome()%></h1>
                                <ul class="list-inline mb-0">
                                    <li class="list-inline-item h6 fw-light me-3 mb-1 mb-sm-0"><%=user.getEmail()%></li>

                                </ul>
                            </div>
                            <!-- Button -->
                            <div class="d-flex align-items-center mt-2 mt-md-0">

                            </div>
                        </div>
                    </div>
                </div>
                <!-- Profile banner END -->

                <!-- Advanced filter responsive toggler START -->
                <!-- Divider -->
                <hr class="d-xl-none">
                <div class="col-12 col-xl-3 d-flex justify-content-between align-items-center">


                </div>
                <!-- Advanced filter responsive toggler END -->
            </div>
        </div>
    </div>