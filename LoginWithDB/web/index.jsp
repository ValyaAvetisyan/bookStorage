<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Welcome</title>
</head>
<body>
<% if(request.getAttribute("errMessage") != null){
%>
<span style="color:red"><%=request.getAttribute("errMessage")%></span>
<%}%>
<form action="/login" method="post">
  name:<input type="text" name="name"><br>
  password:<input type="password" name="password"><br>
  <input type="submit">
  <a href="register.jsp">Create new account</a>
</form>
</body>
</html>
