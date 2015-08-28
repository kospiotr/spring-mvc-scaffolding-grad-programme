<%--
  Created by IntelliJ IDEA.
  User: kospiotr
  Date: 26.08.15
  Time: 20:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title></title>
    <style>
        .message {
            color: red;
        }
    </style>
</head>
<body>

<jsp:include page="menu.jsp"/>

<c:if test="${not empty msg}">
    <div class="message">Message: ${msg}</div>
</c:if>


<form:form commandName="loan" method="post" action="loan-new.html">

    <form:errors path="*" element="div" cssClass="message"/>
    <table>
        <tr>
            <td>Id:</td>
            <td><form:input path="id" readonly="true"/></td>
            <td><form:errors path="id"/></td>
        </tr>
        <tr>
            <td>Purpose:</td>
            <td><form:input path="purpose"/></td>
            <td><form:errors path="purpose"/></td>
        </tr>
        <tr>
            <td>Requester:</td>
            <td><form:input path="requester"/></td>
            <td><form:errors path="requester"/></td>
        </tr>
        <tr>
            <td>Amount:</td>
            <td><form:input path="amount"/></td>
            <td><form:errors path="amount"/></td>
        </tr>
    </table>
    <input type="submit" value="Request"/>
</form:form>

</body>
</html>
