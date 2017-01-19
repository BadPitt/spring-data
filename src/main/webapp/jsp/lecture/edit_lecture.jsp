<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit lecture</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/lecture" method="get">
    <table>
        <th>NAME</th>
        <th>LENGTH</th>
        <tr>
            <td>
                <input name="lecture_name" type="text" value="${lecture.getName()}">
            </td>
            <td>
                <input name="lecture_length" type="text" value="${lecture.getLength()}">
            </td>
        </tr>
        <tr>
            <td>
                <button type="submit" name="button" value="edit_lecture">Save changes</button>
            </td>
        </tr>
    </table>
    <input name="lecture_id" type="hidden" value="${lecture.getId()}">
</form>
</body>
</html>
