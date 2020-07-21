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
            <form action="/person/delete.do">
                <td>${person.personId}</td>
                <td><input type="hidden" name="personId" value="${person.personId}"></td>
                <td>${person.name}</td>
                <td><input type="submit" name="delete"></td>
            </form>
        </tr>
    </c:forEach>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script type="text/javascript">
    function remove() {

    $.ajax({
    type: 'GET',
    url: 'http://localhost:8080/person/delete.do',
    data: {
    "name": document.getElementById("name").value,
    "family": document.getElementById("family").value,
    "phones": document.getElementById("phone").value

    },

    success: function (data) {
    alert(data);


    }
    });
    }
    }

    </script>
</table>
</body>
</html>
