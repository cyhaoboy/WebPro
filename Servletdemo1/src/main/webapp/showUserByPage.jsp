<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2022/4/19
  Time: 21:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="./bootstrap/js/jquery.js" ></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="./bootstrap/js/bootstrap.min.js" ></script>

    <script>

        function selAllorCanel(){
            var bz=document.getElementById("selectAll");

            var input=document.getElementsByClassName("mycheckbox");
            for (i=0;i<input.length;i++){
                input[i].checked=bz.checked;
            }
        }
        function isDelete(id){

            <%--alert("${pageContext.request.contextPath}/DeleteUserServlet?id="+id)--%>
            if(confirm("确定要删除吗？")){
                location.href="${pageContext.request.contextPath}/DeleteUserServlet?id="+id;

            }
        }
    </script>
</head>
<body>


<!-- Button trigger modal -->


<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">添加记录</h4>
            </div>
            <form action="${pageContext.request.contextPath }/AddUserServlet" method="post" class="form-horizontal">
            <div class="modal-body">

                <div class="form-group">
                    <label for="email" class="col-sm-2 control-label">会员邮箱：</label>
                    <div class="col-sm-3">
                        <input type="text"  class="form-control" id="email" name="usermail" onclick="checkEmail()">
                        <span id="usermail_err" ></span>
                    </div>
                    <p>请输入有效的邮箱地址</p>
                </div>
                <div class="form-group">
                    <label for="username" class="col-sm-2 control-label">会员名：</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" id="username" name="username" onclick="checkUsername()">
                        <span id="username_err"></span>
                    </div>
                    <p>字母数字下划线1到10位, 不能是数字开头</p>
                </div>
                <div class="form-group">
                    <label for="password" class="col-sm-2 control-label">密码：</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" id="password" name="pwd" onclick="checkPassword()">
                        <span id="password_err"></span>
                    </div>
                    <p>密码请设置6-16位字符</p>
                </div>
                <div class="form-group">
                    <label for="repassword" class="col-sm-2 control-label">重复密码：</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" id="repassword" name="pwd2" onclick="checkConfirm()">
                        <span id="password2_err"></span>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">性别：</label>
                    <label class="radio-inline">
                        <input type="radio" name="sex" id="inlineRadio1" value="男"> 男
                    </label>
                    <label class="radio-inline">
                        <input type="radio" name="sex" id="inlineRadio2" value="女"> 女
                    </label>
                </div>
                <div class="form-group">
                    <label for="phone" class="col-sm-2 control-label">联系电话：</label>
                    <div class="col-sm-6">
                        <input type="text" class="form-control" id="phone" name="tel">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">个人介绍：</label>
                    <lable class="col-sm-6">
                        <textarea class="form-control" rows="3" name="intro"></textarea>
                    </lable>

                </div>

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="submit" class="btn btn-primary">保存</button>
            </div>
            </form>
        </div>
    </div>
</div>


<div class="table-responsive">
<c:if test="${empty requestScope.pageBean}">
    <script type="text/javascript">

        window.location.href="${pageContext.request.contextPath}/ShowUserByPageServlet";
    </script>

</c:if>
<c:if test="${not empty requestScope.pageBean}">
<form action="${pageContext.request.contextPath}/ShowUserByPageServlet?currentPage=${requestScope.pageBean.currentPage}&pageSize=3" method="post">
    <input type="text" name="username" id="test"><input type="submit" value="search">
<table class="table">
    <tr>
        <td>全选/取消选择<input type="checkbox"  name="selectAll" id="selectAll" onclick="selAllorCanel()"></td>
        <td>id</td>
    <td>姓名</td>
        <td>密码</td>
        <td><button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
            添加记录
        </button></td>
    </tr>
    <c:forEach items="${requestScope.pageBean.list}" var="user">
            <tr>
                <td><input type="checkbox"  name="sel" value="${user.id}" class="mycheckbox"></td>
                <td>${user.id}</td>
                <td>${user.username}</td>
                <td>${user.pwd}</td>
                <td><a href="${pageContext.request.contextPath}/ShowUserServlet?id=${user.id}">编辑</a>
<%--                    <a href="${pageContext.request.contextPath}/DeleteUserServlet?id=${user.id}">删除</a>--%>
                    <a href="javascript:isDelete(${user.id})">删除</a>
                </td>
            </tr>
    </c:forEach>`
</table>


共 ${requestScope.pageBean.totalCount}条  共${requestScope.pageBean.totalPage}页 当前为${requestScope.pageBean.currentPage}页  <input type="submit" value="删除">
    </form>
    <nav aria-label="...">
        <ul class="pagination">
            <c:if test="${requestScope.pageBean.currentPage==1}">
            <li class="disabled">
                <a href="${pageContext.request.contextPath}/ShowUserByPageServlet?currentPage=${requestScope.pageBean.currentPage-1}&pageSize=3" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a>

            </li>
            </c:if>
            <c:if test="${requestScope.pageBean.currentPage!=1}">
                <li>
                    <a href="${pageContext.request.contextPath}/ShowUserByPageServlet?currentPage=${requestScope.pageBean.currentPage-1}&pageSize=3" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a>

                </li>
            </c:if>
            <c:forEach begin="1" end="${requestScope.pageBean.totalPage}" var="i" step="1">
                <c:if test="${requestScope.pageBean.currentPage==i}">
                      <li class="active">
                        <a href="${pageContext.request.contextPath}/ShowUserByPageServlet?currentPage=${i}&pageSize=3">${i}</a>
                    </li>
            </c:if>
                <c:if test="${requestScope.pageBean.currentPage!=i}">
                    <li>
                        <a href="${pageContext.request.contextPath}/ShowUserByPageServlet?currentPage=${i}&pageSize=3">${i}</a>
                    </li>
                </c:if>
            </c:forEach>
            <c:if test="${requestScope.pageBean.currentPage==requestScope.pageBean.totalPage}">
                <li class="disabled">
                    <a href="${pageContext.request.contextPath}/ShowUserByPageServlet?currentPage=${requestScope.pageBean.currentPage+1}&pageSize=3" aria-label="Previous"><span aria-hidden="true">&raquo;</span></a>
                </li>
            </c:if>
            <c:if test="${requestScope.pageBean.currentPage!=requestScope.pageBean.totalPage}">
                <li>
                    <a href="${pageContext.request.contextPath}/ShowUserByPageServlet?currentPage=${requestScope.pageBean.currentPage+1}&pageSize=3" aria-label="Previous"><span aria-hidden="true">&raquo;</span></a>
                </li>
            </c:if>
        </ul>
    </nav>
</c:if>
</div>
<%--<a href="${pageContext.request.contextPath}/ShowUserByPageServlet?currentPage=1&pageSize=3">1</a>--%>
<%--<a href="${pageContext.request.contextPath}/ShowUserByPageServlet?currentPage=2&pageSize=3">2</a>--%>

</body>
</html>
