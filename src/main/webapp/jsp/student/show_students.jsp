<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All students</title>
</head>
<body>
<table>
    <th>ID</th>
    <th>NAME</th>
    <th>SEX</th>
    <th>GROUP</th>
    <th>VERSION</th>
    <c:forEach var="student" items="${students}">

            <tr>
                <td>${student.getId()}</td>
                <td>${student.getName()}</td>
                <td>${student.getSex()}</td>
                <td>${student.getGroup()}</td>
                <td>${student.getVersion()}</td>
                <form action="${pageContext.request.contextPath}/edit_student_page" method="post">
                <td>
                    <button type="submit">Edit</button>
                    <input type="hidden" name="student_id" value="${student.getId()}">
                    <input type="hidden" name="student_version" value="${student.getVersion()}">
                </td>
        </form>
                <form action="${pageContext.request.contextPath}/delete_student" method="post">
                <td>
                    <button type="submit">Delete</button>
                    <input type="hidden" name="student_id" value="${student.getId()}">
                    <input type="hidden" name="student_version" value="${student.getVersion()}">
                </td>
        </form>
            </tr>
    </c:forEach>
    <form action="${pageContext.request.contextPath}/new_student" method="get">
        <tr>
            <td>
                <button name="button" type="submit" value="new_student">Add new student</button>
            </td>
        </tr>
    </form>
</table>
</body>
</html>
