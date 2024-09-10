<%--
  Created by IntelliJ IDEA.
  User: cuddl
  Date: 2024-09-10
  Time: 오전 10:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>LOGIN</title>
</head>
<body>
    <c:if test="${param.result == 'error'}">
        <h1>로그인 에러가 발생했습니다.</h1>
    </c:if>
    
    <form action="/web2/login" method="post">
        <input type="text" name="mid">
        <input type="password" name="mpwd">
        <button type="submit">LOG IN!</button>
    </form>
</body>
</html>
