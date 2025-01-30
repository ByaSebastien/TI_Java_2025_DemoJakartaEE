<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Book details</title>
</head>
<body>
<header>
    <h1>Happy Library</h1>
</header>
<main>
    <h1>ISBN : ${book.isbn}</h1>
    <h1>Titre : ${book.title}</h1>
    <h1>Auteur : ${book.author}</h1>
    <h1>Description : ${book.description}</h1>
</main>
<footer>
    <p>© Les bests java</p>
</footer>
</body>
</html>
