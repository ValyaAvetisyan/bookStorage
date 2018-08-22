<%@ page import="model.Post" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Category" %>
<%@ page import="model.User" %><%--
  Created by IntelliJ IDEA.
  User: Karen-nout-W
  Date: 1/23/2018
  Time: 8:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<% List<Post> posts = (List<Post>) request.getAttribute("posts"); %>
<% List<Category> categories = (List<Category>) request.getAttribute("categories"); %>
<% User user = (User) session.getAttribute("user"); %>

<div style="width: 1000px">
    <div style="width: 70%; float: left">
        <%
            for (Post post : posts) {
                if (post.getPicUrl() != null && !post.getPicUrl().equals("")) {
        %>
        <img src="/getResource?fileName=<%=post.getPicUrl()%>" width="200">
        <%}%>
        <div><%=post.getTitle()%>
        </div>
        <div><%=post.getText()%>
        </div>
        <br>
        <br>
        <%}%>
    </div>
    <div style="width: 30%; float: left">
        <div>
            <% if (user == null) {%>
            <a href="/login-view">Login</a>
            <%} else {%>
            <a href="/logout">Logout</a>
            <%}%>
        </div>
        <ul>
            <%
                for (Category category : categories) {%>
            <li><%=category.getName()%>
            </li>
            <%}%>
        </ul>
    </div>

</div>


</body>
</html>
