<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 1/3/2024
  Time: 10:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post">
    <label>
        <input type="text" name="name" value="${edit.name}">
    </label>
    <label>
        <select class="form-control" name="idAcc">
            <c:forEach items="${ds}" var="acc">
                <option value="${acc.id}">${acc.name}</option>
            </c:forEach>
        </select>
    </label>
    <button>Edit</button>
</form>
</body>
</html>
