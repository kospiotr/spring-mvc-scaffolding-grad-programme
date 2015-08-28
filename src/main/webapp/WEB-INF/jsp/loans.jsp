<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title></title>
    <style>
        table {
            border-collapse: collapse;
        }

        table, th, td {
            border: 1px solid black;
        }

        .message {
            color: red;
        }
    </style>
</head>
<body>

<jsp:include page="menu.jsp"/>

<table>
    <tr>
        <th>ID</th>
        <th>Purpose</th>
        <th>Requester</th>
        <th>Amount</th>
        <th colspan="2">Actions</th>
    </tr>
    <c:forEach items="${loans}" var="loan">
        <tr>
            <td>${loan.id}</td>
            <td>${loan.purpose}</td>
            <td>${loan.requester}</td>
            <td>${loan.amount}</td>
            <td>
                <form action="loan-edit.html" method="get">
                    <input type="hidden" name="id" value="${loan.id}"/>
                    <button>Edit</button>
                </form>
            </td>
            <td>
                <form action="loan-delete.html" method="post">
                    <input type="hidden" name="id" value="${loan.id}"/>
                    <button>Delete</button>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
