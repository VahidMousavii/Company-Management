<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: amirs
  Date: 5/29/2020
  Time: 8:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/person/save.do">
    <input type="text" name="name"/>
    <input type="submit"/>
</form>

<table border="0" style="width: 100%">

    <tr>
        <td>ID</td>
        <td>NAME</td>
    </tr>
    <c:forEach items="${requestScope.personController.personList}" var="person">
        <tr>
                <td>${person.personId}</td>
                <td>${person.name}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
