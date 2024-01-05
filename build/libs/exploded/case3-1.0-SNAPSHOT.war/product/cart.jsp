<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
    <link href="../css/tiny-slider.css" rel="stylesheet">
    <link href="../css/style.css" rel="stylesheet">
    <title>Giỏ hàng</title>
    <style>
        .table {
            --bs-table-bg: transparent;
        }
    </style>
</head>
<body>
<nav class="custom-navbar navbar navbar navbar-expand-md navbar-dark bg-dark" arial-label="Furni navigation bar">

    <div class="container">
        <a class="navbar-brand" href="index.html">WBS</a>

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
<!-- End Header/Navigation -->

<!-- Start Hero Section -->
<div class="hero">
    <div class="container">
        <div class="row justify-content-between">
            <div class="col-lg-5">
                <div class="intro-excerpt">
                    <h1>${nameShop}</h1>
                    <h2 class="sub-hero">Giỏ hàng</h2>
                </div>
            </div>
            <div class="col-lg-7">

            </div>
        </div>
    </div>
</div>
<!-- End Hero Section -->



<div class="untree_co-section product-section before-footer-section">
    <div class="container">
        <div class="row mb-5">
            <form class="col-md-12 text-center" action="/orders" method="post">
                <input type="hidden" name="action" value="completeOrder">
                <div class="site-blocks-table">
                    <table class="table">
                        <thead>
                        <tr>
                            <th class="product-name">Product</th>
                            <th class="product-price">Price</th>
                            <th class="product-quantity">Quantity</th>
                            <th class="product-total">Total</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:set var="totalPrice" value="0" />
                        <c:forEach items="${cart}" var="cartItem" varStatus="loop">
                            <c:set var="itemPrice" value="${cartItem.price * cartItem.quantity}" />
                            <tr>
                                <td class="product-name">
                                    <h2 class="h5 text-black">${cartItem.name}</h2>
                                </td>
                                <td>$${cartItem.price}</td>
                                <td>${cartItem.quantity}</td>
                                <td>$${itemPrice}</td>
                            </tr>
                            <c:set var="totalPrice" value="${totalPrice + itemPrice}" />
                            <input type="hidden" name="id${loop.index + 1}" value="${cartItem.id}">
                            <input type="hidden" name="name${loop.index + 1}" value="${cartItem.name}">
                            <input type="hidden" name="price${loop.index + 1}" value="${cartItem.price}">
                            <input type="hidden" name="quantity${loop.index + 1}" value="${cartItem.quantity}">
                        </c:forEach>
                        <input type="hidden" name="totalPrice" value="${totalPrice}">
                        <input type="hidden" name="idShop" value="${idShop}">
                        <input type="hidden" name="idAccount" value="${idAccount}">
                        <tr>
                            <td class="product-name">
                                <h2 class="h5 text-black">Tổng giá trị</h2>
                            </td>
                            <td></td>
                            <td></td>
                            <td class="h5 text-black">$${totalPrice}</td>
                        </tr>
                        </tbody>
                    </table>
                </div>

                <button type="submit" class="btn btn-primary">Thanh toán</button>
            </form>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</body>
</html>
