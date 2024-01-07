<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%--accounts?act=showList--%>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
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
<h1>Accounts</h1>
<div class="row">
    <div class="col-10">
        <table class="table">
            <thead>
            <tr>
                <th scope="col">ID</th>
                <th scope="col">Tên đăng nhập</th>
                <th scope="col">Mật khẩu</th>
            </tr>
            </thead>
            <tbody>
                <c:forEach items="${accs}" var="account">
                    <tr>
                        <th scope="row">${account.id}</th>
                        <td>${account.username}</td>
                        <td>${account.password}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
    <div class="col-2">
        <div class="position-fixed">
            <p>Tìm kiếm</p><hr>
            <div class="d-flex justify-content-center border border-secondary align-items-center mx-1 px-2 py-2">
                <form action="/accounts" method="get" class="mb-0">
                    <input type="hidden" name="act" value="showList">
                    <input type="hidden" name="opt" value="filter">
                    <input type="text" class="form-control mb-2" name="username" placeholder="Tìm theo username">
                    <button type="submit" class="btn btn-info">Tìm</button>
                </form>
            </div>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</body>
</html>
