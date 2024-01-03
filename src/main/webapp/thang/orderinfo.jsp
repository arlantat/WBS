<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Thông tin hóa đơn</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <style>

    </style>
</head>
<body>
<div class="container mt-5">
    <h1>Thông tin hóa đơn</h1>
    <div class="row mt-4">
        <div class="col-md-12">
            <h2>Shop Name</h2>
            <p>Timestamp: January 1, 2024 - 10:00 AM</p>
            <p>Status: Đã thanh toán</p>

            <table class="table">
                <thead>
                <tr>
                    <th scope="col">Item Name</th>
                    <th scope="col">Quantity</th>
                    <th scope="col">Price</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>Product A</td>
                    <td>2</td>
                    <td>$25.00</td>
                </tr>
                <tr>
                    <td>Product B</td>
                    <td>1</td>
                    <td>$30.00</td>
                </tr>
                </tbody>
            </table>

            <p>Total Price: $80.00</p>
        </div>
    </div>
</div>
<p class="msg">${msg}</p>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</body>
</html>