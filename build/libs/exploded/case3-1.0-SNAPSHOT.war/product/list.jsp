<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
    <link href="../css/tiny-slider.css" rel="stylesheet">
    <link href="../css/style.css" rel="stylesheet">
    <title>Sản phẩm</title>
    <style>
        .search-container {
            display: flex;
            align-items: center;
        }

        .form-control {
            flex: 1;
            margin-right: 5px; /* Adjust this value to create space between input and button */
        }

        .btn-primary {
            flex-shrink: 0;
        }
    </style>
</head>
<body>
<nav class="custom-navbar navbar navbar navbar-expand-md navbar-dark bg-dark" arial-label="Furni navigation bar">

    <div class="container">
        <a class="navbar-brand" href="/shops?username=${username}&idAccount=${idAccount}">WBS</a>

        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarsFurni"
                aria-controls="navbarsFurni" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarsFurni">
            <ul class="custom-navbar-nav navbar-nav ms-auto mb-2 mb-md-0">
                <li class="nav-item ">
                    <a class="nav-link" href="/shops">HOME</a>
                </li>
            </ul>

            <ul class="custom-navbar-cta navbar-nav mb-2 mb-md-0 ms-5">
                <li><a class="nav-link" href="/accounts?act=profilePage&idAccount=${idAccount}"><img src="images/user.svg"></a></li>
                <li><a class="nav-link" href="cart.html"><img src="images/cart.svg"></a></li>
                <li><a class="nav-link" href="auth/login.jsp">Logout</a></li>
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
                    <h2 class="sub-hero">Danh sách sản phẩm</h2>
                    <p class="msg mt-5 fs-5">${msg}</p>
                </div>
            </div>
            <div class="col-lg-7">

            </div>
        </div>
    </div>
</div>
<!-- End Hero Section -->


<div class="untree_co-section product-section before-footer-section">
    <div class="container mb-4">
        <form action="/products" method="get" class="search-container">
            <input type="hidden" name="act" value="showList">
            <input type="hidden" name="opt" value="filter">
            <input type="hidden" name="nameShop" value="${nameShop}">
            <input type="hidden" name="idShop" value="${idShop}">
            <input type="hidden" name="idAccount" value="${idAccount}">
            <input type="text" id="productSearch" class="form-control" name="product" placeholder="Tìm theo tên sản phẩm">
            <button type="submit" class="btn btn-primary mb-2">Search</button>
        </form>
    </div>
    <form action="/products" method="post" class="text-center">
        <input type="hidden" name="action" value="pay">
        <div class="container">
            <div class="row">
                <!-- Start Column 1 -->
                <c:forEach items="${products}" var="product" varStatus="loop">
                    <div class="col-12 col-md-4 col-lg-3 mb-5">
                        <div class="product-item">
                            <img src="${product.imageurl}" class="img-fluid product-thumbnail" style="max-width: 200px; max-height: 150px;">
                            <h3 class="product-title">${product.name}</h3>
                            <strong class="product-price">$${product.price}</strong>
                            <p class="product-desc">${product.description}</p>
                            <span class="icon-cross">
                                <img src="images/cross.svg" class="img-fluid">
                            </span>
                            <input type="hidden" name="id${loop.index + 1}" value="${product.id}">
                            <input type="hidden" name="name${loop.index + 1}" value="${product.name}">
                            <input type="hidden" name="price${loop.index + 1}" value="${product.price}">
                            <input type="number" class="form-control" name="quantity${loop.index + 1}" value="0" min="0"
                                   max="10">
                        </div>
                    </div>
                </c:forEach>
                <!-- End Column 1 -->
                <input type="hidden" name="nameShop" value="${nameShop}">
                <input type="hidden" name="idShop" value="${idShop}">
                <input type="hidden" name="idAccount" value="${idAccount}">
            </div>
        </div>
        <button type="submit" class="btn btn-primary">Thanh toán</button>
    </form>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
        crossorigin="anonymous"></script>
</body>
</html>
