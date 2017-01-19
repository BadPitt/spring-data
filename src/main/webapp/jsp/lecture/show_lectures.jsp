<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All lectures</title>
</head>
<body>
<table>
    <th>ID</th>
    <th>NAME</th>
    <th>LENGTH</th>
    <c:forEach var="lecture" items="${lectures}">
        <form action="${pageContext.request.contextPath}/lecture" method="get">
            <tr>
                <td>${lecture.getId()}</td>
                <td>${lecture.getName()}</td>
                <td>${lecture.getLength()}</td>
                <td>
                    <button type="submit" name="button" value="edit_lecture_page">Edit</button>
                    <input type="hidden" name="id" value="${lecture.getId()}">
                </td>
                <td>
                    <button type="submit" name="button" value="delete_lecture">Delete</button>
                    <input type="hidden" name="id" value="${lecture.getId()}">
                </td>
            </tr>
        </form>
    </c:forEach>
    <form action="${pageContext.request.contextPath}/lecture" method="get">
        <tr>
            <td>
                <button name="button" type="submit" value="new_lecture">Add new lecture</button>
            </td>
        </tr>
    </form>
</table>
</body>
</html>
