<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
    <link href="../css/tiny-slider.css" rel="stylesheet">
    <link href="../css/style.css" rel="stylesheet">
    <title>Lịch sử</title>
    <style>
        .table {
            --bs-table-bg: transparent;
        }
    </style>
</head>
<body>
<nav class="custom-navbar navbar navbar navbar-expand-md navbar-dark bg-dark" arial-label="Furni navigation bar">

    <div class="container">
        <a class="navbar-brand" href="/shops?username=${username}&idAccount=${idAccount}">WBS</a>

        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarsFurni" aria-controls="navbarsFurni" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>


        <div class="collapse navbar-collapse" id="navbarsFurni">
            <ul class="custom-navbar-nav navbar-nav ms-auto mb-2 mb-md-0">

            </ul>

            <ul class="custom-navbar-cta navbar-nav mb-2 mb-md-0 ms-5">
                <li><a class="nav-link" href="/accounts?act=profilePage&idAccount=${idAccount}"><img src="images/user.svg"></a></li>
                <li><a class="nav-link" href="cart.html"><img src="images/cart.svg"></a></li>
            </ul>
        </div>
    </div>

</nav>

<div class="hero">
    <div class="container">
        <div class="row justify-content-between">
            <div class="col-lg-5">
                <div class="intro-excerpt">
                    <h1>${username}</h1>
                    <h2 class="sub-hero">Lịch sử chơi đồ</h2>
                </div>
            </div>
            <div class="col-lg-7">

            </div>
        </div>
    </div>
</div>

<div class="untree_co-section product-section before-footer-section">
    <div class="container">
        <div class="row mb-5">
            <div class="site-blocks-table">
                <table class="table">
                    <thead>
                    <tr>
                        <th>ID Hóa Đơn</th>
                        <th>Cửa hàng</th>
                        <th>Thời gian</th>
                        <th>Tổng Giá</th>
                        <th>Trạng thái</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${pastOrders}" var="pastOrder">
                        <tr>
                            <td><h2 class="h5 text-black">${pastOrder.id}</h2></td>
                            <td>${pastOrder.nameShop}</td>
                            <td>${pastOrder.timestamp}</td>
                            <td>$${pastOrder.totalService}</td>
                            <td>
                                <c:choose>
                                    <c:when test="${pastOrder.status == 1}">
                                        Đã hoàn tất
                                    </c:when>
                                    <c:when test="${pastOrder.status == -1}">
                                        Đã hủy
                                    </c:when>
                                    <c:otherwise>
                                        Chưa hoàn tất
                                        <form action="/orders" method="post">
                                            <input type="hidden" name="action" value="cancelOrder"/>
                                            <input type="hidden" name="idOrder" value="${pastOrder.id}"/>
                                            <input type="hidden" name="idAccount" value="${idAccount}"/>
                                            <button type="submit">Hủy Đơn</button>
                                        </form>
                                    </c:otherwise>
                                </c:choose>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>

<p class="msg">${msg}</p>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</body>
</html>