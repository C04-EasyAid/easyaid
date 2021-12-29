<%--
  Created by IntelliJ IDEA.
  User: Giovanni Toriello
  Date: 28/12/2021
  Time: 15:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link type="text/css" rel="stylesheet" href="../css/login.css">
    <title>Login</title>
    <form action="../login" method="get" >

        <img src="../image/PS-LOGO-DEFINITIVO.png" id="img">

        <div id="corpo">
        <h1>Login</h1><br>
        <input type="email" id="Email" name="Email" placeholder="exemple@studenti.unisa.it"><br>
        <input type="password" id="Password" name="Password"><br><br>
            <div id="accedi">
        <input type="submit" value="Accedi"><br>
            </div>
        <h3>Non ricordi la password?</h3> <input type="submit" value="Recuperala">
        </div>

    </form>
</head>
<body>

</body>
</html>
