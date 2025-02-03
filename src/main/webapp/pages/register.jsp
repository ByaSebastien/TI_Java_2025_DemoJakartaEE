<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <%@include file="/import/import.jsp" %>
    <title>Book Index</title>
</head>
<%@include file="/layout/header.jsp" %>
<main>
    <form action="${pageContext.request.contextPath}/register" method="post">
        <div>
            <label for="username">Username : </label>
            <input type="text" id="username" name="username">
        </div>
        <div>
            <label for="password">Password : </label>
            <input type="password" id="password" name="password">
        </div>
        <button type="submit">Login</button>
    </form>
</main>
<%@include file="/layout/footer.jsp" %>
</body>
</html>