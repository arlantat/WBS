<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 1/3/2024
  Time: 9:23 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach items="${ds}" var="orderzz">
    <h1>${orderzz.idAcc.name},${orderzz.idOrderDetail.totalService},${orderzz.idShop.name},${orderzzr.timestamp},${orderzz.status}</h1>
</c:forEach>
</body>
</html>
