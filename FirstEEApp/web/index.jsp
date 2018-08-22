
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My First JAVA EE APP</title>
</head>
<body>

<%if (request.getAttribute("message") != null) { %>
<%=request.getAttribute("message")%>
<%}%>

<form action="/register" method="post">
    name: <input type="text" name="name"><br>
    surname: <input type="text" name="surname"><br>
    email: <input type="text" name="email"><br>
    password: <input type="password" name="password"><br>
    <input type="submit">
</form>


</body>
</html>


