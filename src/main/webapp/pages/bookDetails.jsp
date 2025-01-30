<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Book details</title>
    <%@include file="/import/import.jsp"%>
</head>
<body>
<%@include file="/layout/header.jsp" %>
<main>
    <h1>ISBN : ${book.isbn}</h1>
    <h1>Titre : ${book.title}</h1>
    <h1>Auteur : ${book.author}</h1>
    <h1>Description : ${book.description}</h1>
</main>
<%@include file="/layout/footer.jsp" %>
</body>
</html>
