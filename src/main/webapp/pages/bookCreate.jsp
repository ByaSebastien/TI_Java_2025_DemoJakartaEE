<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/book/create" method="post">
    <div>
        <label for="isbn">Isbn : </label>
        <input id="isbn" type="text" name="isbn">
    </div>
    <div>
        <label for="title">Titre : </label>
        <input id="title" type="text" name="title">
    </div>
    <div>
        <label for="author">Auteur : </label>
        <input id="author" type="text" name="author">
    </div>
    <div>
        <label for="description">Description : </label>
        <input id="description" type="text" name="description">
    </div>
    <button type="submit">Ajouter</button>
</form>
</body>
</html>
