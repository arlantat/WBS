<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/1/2024
  Time: 10:57 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">

</head>
<body>
<!-- /*
* Bootstrap 5
* Template Name: Furni
* Template Author: Untree.co
* Template URI: https://untree.co/
* License: https://creativecommons.org/licenses/by/3.0/
*/ -->
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="author" content="Untree.co">
    <link rel="shortcut icon" href="favicon.png">

    <meta name="description" content="" />
    <meta name="keywords" content="bootstrap, bootstrap4" />

    <!-- Bootstrap CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
    <link href="css/tiny-slider.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    <title>Furni Free Bootstrap 5 Template for Furniture and Interior Design Websites by Untree.co </title>
</head>

<body>

<!-- Start Header/Navigation -->
<nav class="custom-navbar navbar navbar navbar-expand-md navbar-dark bg-dark" arial-label="Furni navigation bar">

    <div class="container">
        <a class="navbar-brand" href="home.jsp">
            Ecommerce<span>.</span></a>

        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarsFurni" aria-controls="navbarsFurni" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarsFurni">
            <ul class="custom-navbar-nav navbar-nav ms-auto mb-2 mb-md-0">
                <li class="nav-item active">
                    <a class="nav-link" href="home.jsp">Home</a>
                </li>
                <li><a class="nav-link" href="shop.jsp">Shop</a></li>
                <a href="/authenticate?action=logout">Đăng xuất</a>
            </ul>
            <ul class="custom-navbar-cta navbar-nav mb-2 mb-md-0 ms-5">
                <li><a class="nav-link" href="quocanh/login.jsp"><img src="images/user.svg"></a></li>
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
                    <h1><span class="d-block">Overview of e-commerce</span></h1>
                    <p><a href="shop.jsp" class="btn btn-secondary me-2">Shop Now</a><a href="shop.jsp" class="btn btn-white-outline">Explore</a></p>
                </div>
            </div>
            <div class="col-lg-7" style="background: #3B5D50 ">
                <div class="hero-img-wrap">
                </div>
            </div>
        </div>
    </div>
</div>
<!-- End Hero Section -->

<!-- Start Product Section -->
<div class="product-section">
    <div class="container">
        <div class="row">

            <!-- Start Column 1 -->
            <div class="col-md-12 col-lg-3 mb-5 mb-lg-0">
                <h2 class="mb-4 section-title">E-commerce stores</h2>
                <p><a href="shop.jsp" class="btn">Explore</a></p>
            </div>
            <!-- End Column 1 -->

            <!-- Start Column 2 -->
            <div class="col-12 col-md-4 col-lg-3 mb-5 mb-md-0">
                <a class="product-item" href="shop.jsp">
                    <img src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAOEAAADhCAMAAAAJbSJIAAABI1BMVEX////uTTD8//////39/v/xSy/uTi74///tTjD18/DnQh38//z//f7//v37/v/sQiDpsqTsQxzsuK/qTzLoppn///nvSivsTy3vTDPvPhjvRSf6//npTzT++//st6/w49nsPQzuyLzu2tDhbVfqzsb5+fD0STPtPgnvTCbiRSnoRCXq0cjjdFzokoLmn5H0QhjhVjziPhLy6+Lji3Pjo47eTiXbYUvmvbHfVTbflInhqJPbYkTuOh/gfmnmqZzccF/lxrLqv7zejnz15NTif2TzSxzx7N/03t3fgnPiz8HlYUrbaUXlUj7itJ7onIrleWPkpaHhfG/gYj3elHrdaFjx9+jdXkvdRRPqtZ/seF3mh2nwy8nhKAD06eremoHXWi/1NgDL27GsAAAUP0lEQVR4nO1dC3vaOraVJcsylmWjUMsvKG9iyINXE2gDSU9Ok/YwbTozfZyZO6e98/9/xZVIH+kjQJM2anpZ35evxDFUiy1trS1tbQOwxhprrLHGGmusscYaa6yxxhprrLHGGmusscYaa6zx/wwuQiaCNFCgCHnU9JDuNn1fUACp+hdCAF1IJE9GdLfpu8KlBAaDxsbh7p38Ri3nSpIu092o7wtWHfb68cRPfM65s3+vpsz6S0D2SvkzuLcXt4TxASLh+6MmcekvwNI1YdDcbXcxjoyLaPHueEQo1N2+6yN1SXXMk4JdsPBFhmErSuL66S/A0KP3K5koYhElhYsMcSgZi85DYOpu4XXAPJPk6vF8/FmRZVuJ7ziOP8mEbYmiuowrDyB0dbfz6iABzB341txmRXEy2ZseblSr+XtH7TgJC/a818b3wS2eF5nXPJiErdCwLIN3hn/IOVEBgNzoJZ+IcD4e4/u3mGFKtxPDLlqGJeLhAEKEEGUmpBBB0jjonHseHD/T3c6rQYqzErkfR5G0VKE7bnz2Zxemu7FViGyMjXiL0FvobzzqwodxaFlRscXrb77oiWmJNDpZUdnRKuaCVEcbrweGSK59IqfBKON1mn7hL92SCbbamWHbhpEMyS30p9Qlw5MCjnCB13Me+2Jmhx5wyeOOwJKi4NVb6G0YqTnKkRSEc3rZPSkYVbBtyK7cSyEt3TJ9A+HRfKYXlQa5LExyPbqThJHAxe4Ilm6Zt2GkXJlP9WIKg8tuMqXk2TuJokKLv06la7rJBl4fcOdEBRPYH1xqQuAhj4ziEBthtNmAX47VnxjSGs1OJCIcxm8BXRjLm7NMTRjJFNyyXgp+i42CFYnOqfflTHERcNSVMYcl2rnLbf0zwgRT38BWIRlKD7Kw98FcW876liV9za2K96HXCYsiEnEDEHdhyxnc4Yqhfwxv0eqinOBrsRxdkWgvVWMUNOJ5/DhOb1EvhSbM+6rZ2fOl/hGRwZ/GudO9Rb6UUjhM5uHt4VI1hgiYKWlgx7dJuZkBrM9b3a0utYuJyPzbiHj+Jpr2jUAuhQx9DiYvk/FcslXezMfWF7dcuFeG/Lv+fEY8A5fda9KSJj8rZzr4tRYRmOsogpGT+8o38CnFgMCN+ZhNnnz1sxiT3xjTNZF4ae5V7it4k/t9zlDsnX71759hpBgK63nzshuohy7Vtj8Wg/1Ox/kK/vTb2dyGWfurf7+Iju/Mvw3bFu1LbuHHFGpSdDtcSs+v4JOV3yVY5d5KQ5fe2U4My7gBTEa69qmmmY2Xt+/68B8CTXrnif/ZhtIPQlzVZcP7vFVY3r7rg2/pGoe7PLJvhGFNV9xxh0c34mn6b5AmhvnYvimGmjzNRte4iV5q8ZyuGX8U38g4tBymK/yvxjcyDq2Q6qK49Y0Mv6bUVoAoEFdT/F+LV9M0NrYiaQkj82OVL8SzxIgMtcKGV1F9lpgBpIlhebIaQ1wM7TDxw6Pjw3z+cPe4/tTpJkkY2YVV3m+JfaAr76bsr+ZobKsb9+7V0nnannpjcDoa9ni3ha2VbLgNdK0Wn67IEPv7jZS4LmSMyqidUgYhbDaOO75YhWH2CBBNs0WuEoXL2hcJu9UfQZhCl5quSxFzS/Q8nQ2e3uuciEJr2deUPAG6NA1zlvtSq8j338ASLKHUpJRQSNMUmK6yCSSwuds5WSrekx1tDGl7uaOw4/0mhNSUDp9A0Dw9bQbKgHMjMpeB8kws6wf+GaS6GBbF0vhQzHKmCV3Thc3qcNaZ+H57PL2z1QRSiFHZaYmUDcsY7kJdWZq0t9iGOCxg57G0nmcS8qzIk/MMU5xMnL0nf0jLep4Jt/GSnm7xPHR17S3O8GIvgQv+A1IiZmAO/jb5mH0Z2gbmm09HqVuC+ckyjWPxEWR6GLpgv7WwbQWcPG1KO5nw1Vhg+4NLwfOQJOzO/iC5jmUvcTUWrwKkaY8fbi/29FHIH0DIpAfdT4T9Ub/IN9mRwFHWHdYzvMyXWnED6MpigI/EwrbZYVwG0gvCZ5NLaIjFH3COuCalgiaG53tolwKLXqoGUNBLrrMmF2tbpmHw2F/YNDt7Pr+xXLGuEynHZVMbw12+uG18Z77rOapEq/TGSxkOdOVLIXi4WHrb/vme4IhHV14bDw3hN7WNQ5DnC5eirGRnHiw1Nq++Nm4ZuBN4mmYLBjYWKy4rOR+Huc41PI2N20zfOJQDbHHjevNsEzJMlkZZl39IMgbaUm3gfzYX2yaMa27qIjJQycBXW3mMQtwD2nKJYGMxQ1GYvICIeiZ62M+swpX8KQ7VQpQuhqBWWSi59qKw84ZAkxJYdfwrutMoq+tj6JYXM8S2yKbEpa4Mksp1fiUb2pGUDfp66YAvNQzfIIFJSwimo3FFYAsXvnE3B2dPdPFbjaHoN4jLaMn1CB3tV3xLLF8XuAgb+zsaGeacpQyjUFIsBYgg14SgfFaMefYtDAsiO9OX0gdznaUMLWmEexRKiQeRRyGhtXvjbxmRBeHc0cgwKK7SVlw5OpX0XI+6rkr6Rg8f9XkWRtYqezShoTOlj6LeSgzxyeTeQH4haqlUZesReHo2jrOVdI5lxBv6GEK4GkPDtpPOsAaJd34uxkSMNB8UuW0bS61oYz7SyXC2itfAoYz2LR4fPHs1P3IAKTQZBM23sViFYb+qjyEA9W/xi2LSPt5Kial2ZuYrvLUDX1jR4v2nKKts6ePHwPNv8vxh4leevpW9lZ2fMiFkpx8WWosZirimjyFSpyq+AbgoY30/Hu+ewvl4ZCnJ86zwFQXwMQyJ1HqdPoZwuGSh5lNYli0pYtvvPJmf2PMgg8/icLENw3igjyEF97+J4XtgnFR2GTEh8wL498pCbxOFSU4fQwR246swVH2wOysDFLiQpEeLx3LYaepk+OBqDOU8aIV8C5KAybhq8VgWBa2noP91JYaG2sOwsFODSKpxMl24ci7GGhkiOJpcieG7tvdyDDJqVjnGlyo4jHsaz7QhWL2aDd8hPgOmGZBme0G+OBYzjeehIPrPtRhG7ZSpw3t1f8E+sKhrZdioXIdhyBuQlgic8gVhf7KtkSFDtWsxVDv06nOGvHDpnIiToT6CUpc+vl4v7b5j6C/IB0heaGRIweB6DDdVYGSC7URcvirJz35WhudWWRwhVx6rmQA+xeGlNrRjjcs0AJHmQj2CLdFrZxhj68vdtUhYFu5B5AXmqYMvz8K04rv6CMr5sOksYpiJ17TWy2Qf/NKTWFFkVEaQUEZ+W7jqqnOZBiAz7SxiaDtlSJpPKrhV+KIX2lHCp6RkMkD/IewFnkbnMg1AbtpeFNzFecgCE1bHcfZFapGFeT01KWNs4OPCIoYNjePQpPDpAlci/g1TqnxlejiW0rNoW5YlR58Mg6OW4JXj1EQImGRn4ViONrd0zvgUzhYx3E7PM+5KsPnsoD9JBJaDT0b6Vsbj1zJ2UlmjtDZZuI8RVTQu06jN55eLpgN+MJinL1MZ6YLy4VHbiSuOP4k7s7MaQVRZ0EyfRgsj4KiicZlGpYhuL2JoJ87cTXiA0hQR+qpcHeXz1doghaREXWlBk7zkizfbospAYzUJBME0WdhAHE9PCQEMmhDR0ifvZSb1aO7l0sW6OKdzxmfgib9kvzNr7w5kdw5M99NTIalaFS73lq9k9QOdDBHYWcawFfL2jpwWU/rpyR6TgNxbvjg/VQF3dNapRQieLWNo4zDz+/v5cgA+tWHtuD2JVsgTbxONDKlL7ixxFO/b6Tu9J4dbg2YTIZq+qo12ek6y3IDqG3qqlyE8XI2hbKngPPbb0bg3Lvgx59kK+07z72ams7oSY3BjVYaWYYVRZIkWNuzQkrK0uFpGZlLXWRXbRGC0KsPIwNhWNC0hsEq1CZcmeJ8zfKSVIb3mcuIKUClH+hhCBBvfl+GXIYY/1FkDDDFUu9Lm0zdgcqarJoaCjF4HvnWtLPWl8A+B3hpgnjoM86PY2ZltVGq6a/HtdosrzdxXAY5sUYSaK0bCWuUHVo6IEv8B0XWO+x0YHPo/rEaNHWVjGYNorjYIc2M5ha+U3/Zt7IR61oDWJYx3YKTcMVbUJ98CXCiEorK8Zt+Phykp/jPO5irasj7mN118ffF36x2WMSxYk26vpjGH/QOgaZLmxuvYl1AVIfx3uPj64u/8AvwF4M7sWQDNn6VqKw3eVDcW4e7dj68+vs4vQLX8Mz2hxTQhIfA7aw/zZyqcTJHLTAlVyZFKvH89r1v52XWmSj1e+NtFqIdfvH+dsp+pvLcrI0VKz2mo398zUlCvzx/b8en193+7iPf3zN/zM3XSNdZYQxOox0yPMuQqNwMgDTwUsEDbed0fABdRpPLuIUPMoykDiKkaST+LBvkOIMyDabm6cbcxSEGpRGHg5aRg+YUYutB90It5N644T49r6ngaKf918pfGfN7vCUQgJY/HXOAEZ77AvH9Ulh22XMH9X4QhZK47aIcZbz96MXzZ7mZ2t/5rMQQBodsnET97JZUVaTa2483ar8VQasZyHHUPgRx+6vhLWh3RX4shcsmhn13IMIdqdVgyNPoaz0Z8T1AXniWtf38i/n8thlK4HG62xvTTa3OGv0ovRbBRiTYPL177tRgCYMLXGXbOmMr8oTLAJwwphna/CVmzXG7Oe/I8oqWpS2BuUM5RAF0TeibL1coDQEGuXBsE0mm9i3QZ9SDMld801SozKnmBB6RMglR9GnWVAr7ZfUQT1BxbbPbulYlsCAqQJxtb3jQ6p/nXTt/vHFUpOc+DkVpntN3mlf54dwC9EjJh9a/4gIzqTmXTH58NoFuaeywIX93pOf1+Z7qlFmFdyIKApPl9P4779Wrque7iZw59f8CtPS583jl4MAAecU3FsFLI9v0sbOEwix815zVHXTJ4WQkFjozE+fNu6nkUVCvZbDtOEoEtqRlG6fmSE9kqnmQJlhrJGaYeC8yAkPKM8yy0oyw+apIlT1X6/gjgYNjhwhB8Mq0h1SUlw0gYlmTS8ZOQ9+bZWrDcyXDS3zP8DhabZ8x0QTW2jcxOnPG400nE5uG8kjVsbBbwpFPcc5Kks50CqeTJ73tZ5DjFQh9H8tNo6YYjM/XfDXbHcZIlCX/S9NzULHOjIPo7v9PcH9ux5Q8hM83mWMrWaS1gg38VedYfUaQqSGM7HpYDlMu3M3uyBWmJDtqZaOcHhG4951H/PqRuSg+E6OzKS7VhbCT/gDdtQwXZkbbu9/wE870yRHMbOiNCKCTpcdLq12AA3k7EZARUcUjS3BeiOFA1soU1GUHoQkIGvUw8DWRUeXySFE8JLHkpedHFnbJL4WFF/Lklb0ME5PuiouX5CKZsB0gb+zzCe2+I8qXScBCZJvPIWPAzkub2RHIGpT1MxuDAEfzvc4bJkEgnK50JKTvhZgOkaV/EDXL+JHZyhLu7spPODP8OUWVcAYE7SfJEx7OfqQnlD0l3Y8yH1C3HIa8RwDxPRsd5pzWDZEuyyZluIEnL2WDH4NuKoXS5HpBdWHZFOBWTMyinV2zsHJ/tnJ3Jn3/byT8hLPeFNTzeOds5fvHi+H8sy2reMEOELqziP+kaTg4p5f1BtTU43kvBKM7qH7NFtjgeAyhtOPtY+XjEk+cAPosLopO8gyiETgr+0zci6XXeXTIKk5t+atnF/46cOrjyGD7+hGEfFyDMx9nzj5l3tYlVYIph/WP16tFEHb87jAtJcvJ+T8rpSuXw22ZBzkbd99e6lfIN25BdKF5cSjtGZQt+YsOtfiIZjng2+/gMy2oieqqX4rFULO9w2PGnENzlYpy/8wEPHhJVZcu+d3j4/tLfR+hmn8sGmxcYkgFv9cvgU4Y8KVCzFmOn/CH7eZol0/nzBrq1910A7mfxoapfb7WaQG1vqD0O6V9cMPiz5TyeO5/zy+Qmn0xGA+/3v+4RKjUnZDQ1yYvYKDbB5zYsBh6ZZdk2oYyZkJFGLOIqVAxbB2lAIQpc8iy2Ko+Bcr3+kEj1KUUuRbmcKh793Jfj1TMD5rqBl3tDgpuc8c30IEtmDVd+udJn0Lc8jHelL/2cIWVkFBt8WCKESX/ZjsIZMyVDy5pMc3IaIGTDMfwn0iFLl4T7x4wQeSt43DtSh7y3KlHn6NX8Nnhan9GbnPEhHBQznPH/fVut1apvx5NCd9x0yee+tEgYQdMuTsb3th6Ppj7OKmUp0ardqIWT9tvq1t06FyfFU1OtvR51o6R3b6tc25j27W6euAQc84Tv7f5Rro2GnYy/uMnYglLz9FElsVvJhPtScGLe/l1K6i8YItk96Ta3cCJvS8Kk30BU2dAIpcTuOL6PhVRDAJkeYTl5n3C470wSnGz+RpFJ6dCXb3XkJZEp/XrDWQuwuh3HPGtlIuH95wOlwR7/l1c+RMCNzWRPilBaCh5wniSZqsCjpB2TDLOXI0ddy5J4OoDnHsRDu/2TTGCp2flB7Tzyovn2JBFWlvHJ+OGS5wp/fwTQHGwc7497vednj1OTAhcOXu/vf2BYO9jflu4WQQ8MDqe94uvjRkpIgBTD8CVoPpvODuq7NULI+RNWSAnmDqez8ax+/49U9VGJEmk+e3Qwflp/K9/r3fBsISPbQCpGFrgMEAQRBYErLRZ8aIUKgJFKQfVMSiRRdUqNMdeb27CuBANSE4HavZrPjaUUeeo+c57UeV7dmiJVV0oOUqCK9qDSZW35MVAVLRmTDl4V7Pao1J7ATd2PCRTSxoxJXaBSD5QElcKUUeAF5wxlsGHCFAYlF5lkbkPZzZnU7HLoqknjPJfNhTSglAaQMdW9vcvacnNYZaC4c4a6nt90EzhniNYMbzHMX55hqmL8uo54/aYgJeh/uy91noP50UCwfP9F/lfKaPgcnqoMpa9A9xprrLHGGmusscYaa6yxxhprrLHGGmusscYaa6yxxho/Dv8H4eAEAmYk9IwAAAAASUVORK5CYII=" class="img-fluid product-thumbnail" style="width: 750px;height: 435px;">
                    <h3 class="product-title">Shoppe</h3>
<%--                    <strong class="product-price">$50.00</strong>--%>

                    <span class="icon-cross">
								<img src="images/cross.svg" class="img-fluid">
							</span>
                </a>
            </div>
            <!-- End Column 2 -->

            <!-- Start Column 3 -->
            <div class="col-12 col-md-4 col-lg-3 mb-5 mb-md-0">
                <a class="product-item" href="shop.jsp">
                    <img src="https://classic.vn/wp-content/uploads/2022/04/logo-lazada.png" class="img-fluid product-thumbnail">
                    <h3 class="product-title">Lazada</h3>
<%--                    <strong class="product-price">$78.00</strong>--%>

                    <span class="icon-cross">
								<img src="images/cross.svg" class="img-fluid">
							</span>
                </a>
            </div>
            <!-- End Column 3 -->

            <!-- Start Column 4 -->
            <div class="col-12 col-md-4 col-lg-3 mb-5 mb-md-0">
                <a class="product-item" href="shop.jsp">
                    <img src="data:image/png;base64,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" class="img-fluid product-thumbnail">
                    <h3 class="product-title">Sendo</h3>
<%--                    <strong class="product-price">$43.00</strong>--%>

                    <span class="icon-cross">
								<img src="images/cross.svg" class="img-fluid">
							</span>
                </a>
            </div>
            <!-- End Column 4 -->

        </div>
    </div>
</div>
<!-- End Product Section -->

<!-- Start Why Choose Us Section -->


<!-- End Testimonial Slider -->

<!-- Start Blog Section -->
<!-- End Blog Section -->
<!-- Start Footer Section -->
<!-- End Footer Section -->


<script src="js/bootstrap.bundle.min.js"></script>
<script src="js/tiny-slider.js"></script>
<script src="js/custom.js"></script>
</body>

</html>

</body>
</html>
