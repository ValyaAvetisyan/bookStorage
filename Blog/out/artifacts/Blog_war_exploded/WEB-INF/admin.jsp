<%@ page import="model.Category" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Karen-nout-W
  Date: 1/23/2018
  Time: 8:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin</title>
</head>
<body>
<% List<Category> categories = (List<Category>) request.getAttribute("categories"); %>

<a href="/logout">Logout</a>
<br>
Add Category:
<form action="/addCategoryServlet" method="post">
    Name: <input type="text" name="name"> <br>
    <input type="submit" value="OK">
</form>

<br>
<br>
<br>

Add Post:
<form action="/addPostServlet" method="post" enctype="multipart/form-data">

    title: <input type="text" name="title"><br>
    text: <textarea name="text"></textarea><br>
    category:
    <select name="categoryId">
        <% for (Category category : categories) {%>
        <option value="<%=category.getId()%>"><%=category.getName()%>
        </option>
        <%}%>
    </select><br>
    <input type="file" name="picture"><br>
    <input type="submit" name="OK">

</form>

</body>
</html>
