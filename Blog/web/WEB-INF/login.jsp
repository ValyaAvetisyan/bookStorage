<%--
  Created by IntelliJ IDEA.
  User: Karen-nout-W
  Date: 1/23/2018
  Time: 8:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
Login:
<form action="/loginServlet" method="post">
    email: <input type="text" name="email"><br>
    password: <input type="text" name="password"><br>
    <input type="submit" value="LOGIN">
</form>
<br>
<br>
<br>
Register:
<form action="/registerServlet" method="post">
    name: <input type="text" name="name"><br>
    surname: <input type="text" name="surname"><br>
    email: <input type="text" name="email"><br>
    password: <input type="text" name="password"><br>
    <input type="submit" value="REGISTER">
</form>
</body>
</html>
