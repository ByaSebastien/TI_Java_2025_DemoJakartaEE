<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <%@include file="/import/import.jsp" %>
    <title>Book Index</title>
</head>
<%--<jsp:include page="/layout/header.jsp">--%>
<%--    <jsp:param name="title" value="Titre dynamique"/>--%>
<%--</jsp:include>--%>
<%@include file="/layout/header.jsp" %>
<main>
    <a href="/book/create">Creer</a>
    <table>
        <thead>
        <tr>
            <th>Titre</th>
            <th>Auteur</th>
            <th>Description</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="book" items="${books}">
            <tr>

                <td>${book.title}</td>
                <td>${book.author}</td>
                <td>
                    <c:if test="${book.description != null}">
                        ${book.description}
                    </c:if>
                    <c:if test="${book.description == null}">
                        Pas de description.
                    </c:if>
                </td>
                <td>
                    <button>
                        <a href="/book/details?isbn=${book.isbn}">Details</a>
                    </button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</main>
<%@include file="/layout/footer.jsp" %>
</body>
</html>