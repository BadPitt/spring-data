<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit student</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/edit_student" method="post">
    <table>
        <th>NAME</th>
        <th>SEX</th>
        <th>GROUP</th>
        <tr>
            <td>
                <input name="student_name" type="text" value="${student.getName()}">
            </td>
            <td>
                <input name="student_sex" type="text" value="${student.getSex()}">
            </td>
            <td>
                <input name="student_group" type="text" value="${student.getGroup()}">
            </td>
        </tr>
        <tr>
            <td>
                <button type="submit" name="button" value="edit_student">Save changes</button>
            </td>
        </tr>
    </table>
    <input name="student_id" type="hidden" value="${student.getId()}">
    <input name="student_version" type="hidden" value="${student.getVersion()}">
</form>
</body>
</html>
