<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2022/4/16
  Time: 9:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" buffer="none" %>
<%@ page import="com.example.test.domain.User" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="2" o>
    <tr>
        <td>用户名</td>
        <td>密码</td>
    </tr>
    <c:forEach items="${requestScope.users}" var="person">
<%--       <c:if test="${!empty person.username}">--%>
        <tr>
            <td>${person.username}</td>
            <td>${person.pwd}</td>
        </tr>
<%--   </c:if>--%>
    </c:forEach>
</table>
</body>
</html>
