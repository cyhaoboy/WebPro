<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2022/4/21
  Time: 15:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<form class="form-horizontal" action="${pageContext.request.contextPath}/SaveServlet" method="post">
    <div class="form-group">
<%--        <label for="inputEmail" class="col-sm-2 control-label">用户名id</label>--%>
        <div class="col-sm-10">
            <input type="hidden" class="form-control" id="inputEmail"  name="id" placeholder="Id" value="${user.id}">
        </div>
    </div> <div class="form-group">
        <label for="inputEmail3" class="col-sm-2 control-label">用户名</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="inputEmail3"  name="username" placeholder="Username" value="${user.username}">
        </div>
    </div>
    <div class="form-group">
        <label for="inputPassword3" class="col-sm-2 control-label">密码</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" name="pwd" id="inputPassword3" placeholder="Password" value="${user.pwd}">
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <div class="checkbox">
                <label>
                    <input type="checkbox"> Remember me
                </label>
            </div>
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-default" value="保存">保存</button>
            <button type="submit" class="btn btn-default">取消</button>
        </div>
    </div>
</form>


</body>
</html>
