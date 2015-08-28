<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<a href="/index.html">Welcome page</a> |
<a href="/loan-new.html">Create new Loan</a> |
<a href="/loan-list.html">List all loans</a>

<a href="/login.html">Login</a> |
<form action="/logout" method="post" style="display: initial;">
    <input type="submit" value="Log out"/>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>
<hr/>