<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UPDATE PERSON</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
<form action="http://localhost:8081/person/saveUpdate.do">
    <tr>
    <input type="hidden" name="personID" value="${requestScope.personController.person2.personID}" />
        <td>name</td>
        <input type="text" name="personName" value="${requestScope.personController.person2.personName}" />
    <td> phone</td>
        <input type="text" name="phone" value="${requestScope.personController.person2.phone}"/>
    <label for="activity">activity</label>
    <input type="hidden" name="status" id="activity" value="activity">
    <input type="checkbox" name="active" <c:if test="${requestScope.personController.person2.active==true}">checked</c:if>>
    <input type="submit" />
    </tr>
</form>

</body>
</html>
