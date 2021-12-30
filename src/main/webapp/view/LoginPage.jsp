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

</head>
<body>

<link type="text/css" rel="stylesheet" href="../css/login.css">
<title>Login</title>
<form action="../login" method="get" >

    <div id="immagine">
        <img src="../image/PS-LOGO-DEFINITIVO.png" id="img">
        <div id="corpo">
            <h1>Login</h1><br>
            <div id="email">
            <input type="email" name="Email" placeholder="exemple@studenti.unisa.it"><br>
            </div>
            <div id="password">
            <input type="password" name="Password" placeholder="Password"><br><br>
            </div>
            <div id="accedi">
                <input type="submit" value="ACCEDI"><br>
            </div>
        </div>
        <div id="immagine2">
            <img src="../image/PS-LOGO-DEFINITIVO-2.png" id="img2">
        </div>

    </div>

</form>

</body>
</html>
