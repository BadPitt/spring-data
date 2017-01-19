<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New lecture</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/lecture" method="get">
<table>
    <th>NAME</th>
    <th>LENGTH</th>
    <tr>
        <td>
            <input name="lecture_name" type="text" value="">
        </td>
        <td>
            <input name="lecture_length" type="text" value="">
        </td>
    </tr>
    <tr>
        <td>
            <button type="submit" name="button" value="add_lecture">Add</button>
        </td>
    </tr>
</table>
</form>
</body>
</html>
