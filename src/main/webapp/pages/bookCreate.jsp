<%--
  Created by IntelliJ IDEA.
  User: byase
  Date: 30-01-25
  Time: 11:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/book/create" method="post">
    <div>
        <label for="title">Titre : </label>
        <input id="title" type="text" name="title">
    </div>
    <div>
        <label for="author">Auteur : </label>
        <input id="author" type="text" name="author">
    </div>
    <button type="submit">Ajouter</button>
</form>
</body>
</html>
