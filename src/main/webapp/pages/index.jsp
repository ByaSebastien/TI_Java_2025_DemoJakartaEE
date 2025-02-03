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
    <c:if test="${currentUser == null}">
        <a href="/register">register</a>
        <a href="/login">login</a>
    </c:if>
    <c:if test="${currentUser != null && currentUser.role.equals('admin')}">
        <a href="/admin/book/create">Creer</a>
    </c:if>
    <c:if test="${currentUser != null}">
        <form action="${pageContext.request.contextPath}/logout" method="post">
            <button type="submit">Logout</button>
        </form>
    </c:if>
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
                    <c:if test="${currentUser != null && currentUser.role.equals('admin')}">
                        <button>
                            <a href="/admin/book/update?isbn=${book.isbn}">Update</a>
                        </button>
                        <form action="${pageContext.request.contextPath}/admin/book/delete" method="post">
                            <input type="text" hidden="hidden" name="isbn" value="${book.isbn}">
                            <button type="submit">Delete</button>
                        </form>
                    </c:if>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</main>
<%@include file="/layout/footer.jsp" %>
</body>
</html>