<%--
  Created by IntelliJ IDEA.
  User: cuddl
  Date: 2024-09-04
  Time: 오후 2:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>계산 처리 예제</title>
</head>
<body>
<h1>num1 : ${param.num1}</h1>
<h1>num2 : ${param.num2}</h1>
<h1>sum : ${Integer.parseInt(param.num1) + Integer.parseInt(param.num2)}</h1>

</body>
</html>
