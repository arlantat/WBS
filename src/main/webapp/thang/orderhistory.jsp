<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Lịch sử mua</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <style>

    </style>
</head>
<body>
<div class="container mt-5">
    <h1>Order History</h1>
    <div class="row mt-4">
        <div class="col-md-12">
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">Order ID</th>
                    <th scope="col">Timestamp</th>
                    <th scope="col">Total</th>
                    <th scope="col">Status</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <th scope="row">1</th>
                    <td>2024-01-01 10:00 AM</td>
                    <td>$50.00</td>
                    <td>Đã thanh toán</td>
                </tr>
                <tr>
                    <th scope="row">2</th>
                    <td>2024-01-02 11:30 AM</td>
                    <td>$80.00</td>
                    <td>Chưa thanh toán</td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>
<p class="msg">${msg}</p>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</body>
</html>