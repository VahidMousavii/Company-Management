<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MAIN PAGE</title>
</head>
<body>
<form action="/person/save.do">
    <td>name</td>
    <input type="text" name="personName"/>
    <td>phone</td>
    <input type="text" name="phone"/>
    <input type="checkbox" name="active" checked/>
    <input type="submit"/>
</form>

<table border="0" style="width: 100%">

    <tr>
        <td>NAME</td>
        <td>ACTIVE STATUS</td>
        <td>DELETE</td>
        <td>UPDATE</td>
        <td>CHANGE STATUS</td>

    </tr>

    <c:forEach items="${requestScope.personController.personList}" var="person">
        <tr>
            <td>${person.personName}</td>
            <td>${person.active}</td>
            <td><a href="/person/delete.do?personID=${person.personID}">delete</a></td>
            <td><a href="/person/update.do?personID=${person.personID}">update</a></td>
            <c:if test="${person.active != true}">
                <td><a href="/person/active.do?personID=${person.personID}">active</a></td>
            </c:if>
            <c:if test="${person.active == true}">
                <td><a href="/person/deactivate.do?personID=${person.personID}">deactivate</a></td>
            </c:if>
        </tr>
    </c:forEach>
</table>
</body>
</html>
