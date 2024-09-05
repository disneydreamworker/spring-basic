<%--
  Created by IntelliJ IDEA.
  User: cuddl
  Date: 2024-09-05
  Time: 오전 10:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Todo List</title>
</head>
<body>
<h1>Todo List Page</h1>
<%--WAS의 영역임--%>
    ${dtoList}

<br>
<br>
<h3>${dtoList[0].tno} --- ${dtoList[0].title} --- ${dtoList[0].dueDate}</h3>
<h3>${"여기는 WAS의 영역.서블릿 아니구 JSP야"}</h3>
<ul>
    <c:forEach var="dto" items="${dtolist}">
        <li>${dto}</li>
    </c:forEach>
</ul>

</body>
</html>
