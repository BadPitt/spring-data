<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>StudentIS</title>
</head>
<body>

    <t1>Choose action</t1>
    <form action="${pageContext.request.contextPath}/student/show_students" method="get">
    <p>
        <button type="submit">Students</button>
    </p>
    </form>
    <form action="${pageContext.request.contextPath}/home" method="get">
    <p>
        <button type="submit" name="button" value="show_lectures">Lectures</button>
    </p>
    <p>
        <button type="submit" name="button" value="show_journal">Journal</button>
    </p>
</form>
</body>
</html>

