<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New student</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/add_student" method="post">
<table>
    <th>NAME</th>
    <th>SEX</th>
    <th>GROUP</th>
    <tr>
        <td>
            <input name="student_name" type="text" value="">
        </td>
        <td>
            <input name="student_sex" type="text" value="">
        </td>
        <td>
            <input name="student_group" type="text" value="">
        </td>
    </tr>
    <tr>
        <td>
            <button type="submit">Add</button>
        </td>
    </tr>
</table>
</form>
</body>
</html>
