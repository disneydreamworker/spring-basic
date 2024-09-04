<%--
  Created by IntelliJ IDEA.
  User: cuddl
  Date: 2024-09-04
  Time: 오후 12:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>계산기 예제</title>
</head>
<body>
    <form action="/calc/makeResult" method="post">
        <input type="number" name="num1"/>
        <input type="number" name="num2"/>
        <button type="submit">SEND BUTTON</button>
    </form>
</body>
</html>
