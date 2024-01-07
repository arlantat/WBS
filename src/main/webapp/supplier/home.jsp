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
        h5 {
            position: relative;
            font-size: 14px;
            color: #FFF;
            top: 9px;
        }

        .delete_btn {
            height: 20px;
            width: 40px;
        }

        .search-container {
            display: flex;
            align-items: center;
        }
    </style>
</head>
<body>
<nav class="custom-navbar navbar navbar navbar-expand-md navbar-dark bg-dark" arial-label="Furni navigation bar">

    <div class="container">
        <a class="navbar-brand" href="/suppliers?idShop=${idShop}">WBS</a>

        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarsFurni"
                aria-controls="navbarsFurni" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarsFurni">
            <ul class="custom-navbar-nav navbar-nav ms-auto mb-2 mb-md-0">
                <li class="nav-item active">
                    <a class="nav-link" href="/suppliers?idShop=${idShop}">Home</a>
                </li>
                <li><a class="nav-link" href="/shops?action=editFormShop&idShop=${idShop}">Edit shop</a></li>
                <li><a class="nav-link" href="/products?action=showCreateForm&idShop=${idShop}">Add product</a></li>
                </li>
            </ul>

            <ul class="custom-navbar-cta navbar-nav mb-2 mb-md-0 ms-5">
                <li><a class="nav-link" href="/accounts?act=profilePage&idAccount=${idAccount}"><img
                        src="images/user.svg"></a></li>
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
        <form action="/products" method="get" class="search-container mb-5">
            <input type="hidden" name="act" value="showList">
            <input type="hidden" name="opt" value="filter">
            <input type="hidden" name="supplier" value="true">
            <input type="hidden" name="idShop" value="${idShop}">
            <input type="hidden" name="idAccount" value="${idAccount}">
            <input type="text" id="productSearch" class="form-control" name="product" placeholder="Tìm theo tên sản phẩm">
            <button type="submit" class="btn btn-primary mb-2">Search</button>
        </form>
    </div>
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
                            <a href="/products?action=editForm&id=${product.id}&idShop=${idShop}">
                                <h5>EDIT</h5>
                            </a>
                        </span>
                        <form action="/products" method="post">
                            <input type="hidden" name="action" value="delete">
                            <input type="hidden" name="idShop" value="${idShop}">
                            <input type="hidden" name="id" value="${product.id}">
                            <div class="delete_btn">
                                <button type="submit">
                                    Delete
                                </button>
                            </div>

                        </form>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
        crossorigin="anonymous"></script>
</body>
</html>
