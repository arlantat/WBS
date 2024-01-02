<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Landing</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <style>
        /* Custom styles */
        body {
            background-color: #f8f9fa;
        }
        .container {
            margin-top: 50px;
        }
        .msg {
            font-style: italic;
            color: red;
        }
    </style>
</head>
<body>

<div class="container">
    <div id="login" class="mt-5">
        <h2>Login</h2>
        <form action="/authenticate" method="get">
            <div class="form-group">
                <label for="loginUsername">Username</label>
                <input type="text" class="form-control" id="loginUsername" name="loginUsername">
            </div>
            <div class="form-group">
                <label for="loginPassword">Password</label>
                <input type="password" class="form-control" id="loginPassword" name="loginPassword" >
            </div>
            <button type="submit" class="btn btn-primary">Login</button>
        </form>
    </div>

    <div id="register" class="mt-5">
        <h2>Register</h2>
        <form action="/authenticate" method="post">
            <div class="form-group">
                <label for="registerUsername">Username</label>
                <input type="text" class="form-control" id="registerUsername" name="registerUsername" required>
            </div>
            <div class="form-group">
                <label for="registerPassword">Password</label>
                <input type="password" class="form-control" id="registerPassword" name="registerPassword" required>
            </div>
            <button type="submit" class="btn btn-primary">Register</button>
        </form>
    </div>
</div>

<p class="msg">${msg}</p>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</body>
</html>