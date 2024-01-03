<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 1/3/2024
  Time: 1:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach items="${ds}" var="accs">
  <h1>${accs.username},${accs.password}</h1>
</c:forEach>
</body>
</html>
