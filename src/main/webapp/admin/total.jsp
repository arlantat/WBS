<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 1/5/2024
  Time: 9:11 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <style>
        body {
            background-color: #3b5d50;
            color: white;
        }

        .table {
            --bs-table-bg: #3b5d50;
            border-color: white;
            --bs-table-color-state: white
        }
    </style>
</head>
<body>
<h1>Shop Total</h1>
<table class="table">
    <thead>
    <tr>
        <th scope="col">Shop name</th>
        <th scope="col">Total</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${danhsach}" var="total">
        <tr>
            <th scope="row">${total.name}</th>
            <td>${total.total}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
        crossorigin="anonymous"></script>
</body>
</html>
