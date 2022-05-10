<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2022/3/29
  Time: 22:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>

    <link rel="stylesheet" href="./bootstrap/css/bootstrap.min.css">

    <script src="https://fastly.jsdelivr.net/npm/html5shiv@3.7.3/dist/html5shiv.min.js"></script>
    <script src="https://fastly.jsdelivr.net/npm/respond.js@1.4.2/dest/respond.min.js"></script>

    <style>
        body{background: #1E90FF}
        .con {
            width: 300px;
            margin: 100px auto;
        }

    </style>
</head>

<body>

<%--<%--%>
<%--    Cookie[] cookies = request.getCookies();--%>
<%--    String username = null;--%>
<%--    String pwd = null;--%>
<%--    int flag = 0;//加入一个标准为flag，当flag=0，表示cookie不存在或我们要找的cookie不存在，flag=1表示存在我们要找的cookie(username,pwd)--%>
<%--    if (cookies != null) {--%>

<%--        if (cookies.length >= 2) {--%>

<%--            for (Cookie cookie : cookies) {--%>
<%--                String cookname = cookie.getName();--%>
<%--                if (cookname.equals("username")) {--%>
<%--                    username = cookie.getValue();--%>
<%--                }--%>
<%--                if (cookname.equals("pwd")) {--%>
<%--                    pwd = cookie.getValue();--%>
<%--                }--%>
<%--            }--%>
<%--            if (username != null && pwd != null) {--%>
<%--                flag = 1;--%>
<%--//                response.sendRedirect("shouye.jsp");--%>
<%--                response.sendRedirect("index.jsp?username="+username);--%>
<%--            }--%>
<%--//            else {--%>
<%--//                flag = 0;--%>
<%--//            }--%>
<%--        }--%>
<%--    }--%>
<%--    if (flag == 0) {--%>
<%--%>--%>

<div class="con">
    <form class="form-signin" action="${pageContext.request.contextPath }/MyLoginServlet" method="post">
        <h2 class="form-signin-heading">登录</h2>
        <label for="name" class="sr-only"></label>
        <input  id="name" class="form-control" name="username" placeholder="用户" required autofocus>
        <label for="demo" class="sr-only"></label>
        <input type="password" id="demo" class="form-control" name="pwd" placeholder="密码" required>
        <input type="text" class="input input-big" name="code" placeholder="填写右侧的验证码" />
        <img src="CodeServlet" alt="" width="100" height="32" class="passcode" style="height:43px;cursor:pointer;" onclick="this.src=this.src+'?'"><br>
        <input type="checkbox" name="remeber" id="remember"  value="1">十天免登录
        <button class="btn btn-lg btn-primary btn-block" type="submit" onclick="myFunction()" id="damo">登录</button>
    </form>
</div>

</body>
</html>
<%--<%--%>
<%--    }--%>
<%--%>--%>
