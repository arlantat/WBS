<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2/1/2024
  Time: 3:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Register</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <style>
        body{
            display: flex;
            height: 100vh;
            justify-content: center;
            align-items: center;
            padding: 10px;
            background-repeat: no-repeat;
            background-size: cover;
            background-image: url("https://vudigital.co/wp-content/uploads/2020/11/hoat-dong-thuong-mai-dien-tu-e-commerce-va-tam-anh-huong-cua-chung-trong-chien-luoc-thuong-hieu2.jpg");
        }
        h2{
            text-align: center;
            font-size: 25px;
            font-weight: 500;
            position: relative;
        }
        label{
            display: block;
            font-weight: 500;
            margin-bottom: 5px;
        }



        .content {
            max-width: 700px;
            width: 30%;
            background: #ffff;
            padding: 25px 30px;
            border-radius: 5px;
        }
        .form-group {
            margin-bottom: 20px;
        }
        .btn-primary {
            height: 10%;
            width: 100%;
            outline: none;
            color: #ffff;
            background: linear-gradient(135deg,#71b7e6,#9b59b6);
            border-radius: 20px;
            font-size: 18px;
            font-weight: 500;
            letter-spacing: 2px;
        }
        .form-control{

            height: 45px;
            width: 100%;
            outline: none;
            border-radius: 5px;
            border: 1px solid #cccc;
            padding-left: 15px;
            font-size: 16px;
            border-bottom-width: 5px;
            transition: all 1s ease;
        }

        .register-link {
            display: block;
            margin-top: 20px;
            text-align: center;
        }
        a{
            font-size: 30px;
            color: #9b59b6;

        }
    </style>
    </style>
</head>
<body>
<div class="content">
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


</body>
</html>
