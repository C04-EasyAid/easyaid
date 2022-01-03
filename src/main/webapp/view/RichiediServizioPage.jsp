<%--
  Created by IntelliJ IDEA.
  User: Riccardo
  Date: 27/12/2021
  Time: 16:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Richieste di servizio</title>
    <link type="text/css" rel="stylesheet" href="../css/bootstrap.css">
    <link type="text/css" rel="stylesheet" href="../css/richiediservizio.css">
</head>
<body>


<%@ include file="../fragment/navbar.jsp" %>

<div class="bg-info rounded-3 p-4 p-sm-5">
    <!-- Title -->
    <h2 class="mb-3 text-center text-light ">Richiedi uno dei seguenti servizi</h2>
    <div class="container-fluid d-flex align-items-center justify-content-center">
        <div class="row">
            <div class="col-sm-6">
                <div  id="card-tutorato" class="card text-center">
                    <div class="card-body">
                        <h3 class="card-title text-light">Tutorato Didattico</h3>
                        <p class="card-text text-light">Un tutor verrà assegnato per svolgere l'attività di tutorato</p>
                        <a href="#" class="btn btn-light text-success">Richiedi</a>
                    </div>
                </div>
            </div>
            <div class="col-sm-6" >
                <div id="card-supporto" class="card text-center" >
                    <div class="card-body">
                        <h4 class="card-title text-light">Supporto Esame</h4>
                        <p class="card-text text-light">Un tutor verrà assegnato per dare supporto per l'esame</p>
                        <a href="#" class="btn btn-light  text-success">Richiedi</a>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>
<footer>  <%@include file="../fragment/footer.html"%></footer>
</body>
</html>
