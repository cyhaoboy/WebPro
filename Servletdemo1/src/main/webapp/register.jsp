<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2022/5/10
  Time: 13:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>注册页</title>

    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <script src="js/jquery-3.3.1.min.js" type="text/javascript" charset="utf-8"></script>

    <script>
        $(function () {
            $("#username").blur(function () {
                var username=$(this).val();

                $.get("VerifyUserServlet",{username:username},function (data) {
                    var span =$("#username_err");
                    if(data.user){
                        $("#test").addClass("has-error").removeClass("has-success");
                        span.css("color","red");
                        span.html(data.msg);
                    }else {
                        $("#test").addClass("has-success").removeClass("has-error");
                        span.css("color","green");
                        span.html(data.msg);
                    }
                });
            });

        });

    </script>
    <style>

        #carousel-example-generic {
            height: 400px;
        }

        #carousel-example-generic .carousel-inner > .item > img {
            display: block;
            width: 100%;
            height: 400px;
        }


    </style>
</head>
<body>
<header>
    <div class="container" style="height:80px ">
        <div class="row">
            <div class="col-sm-4 col-xs-4"><img src="images/logo.png" alt=""></div>
            <div class="col-sm-4 col-lg-offset-4 col-xs-4 col-md-offset-4 col-sm-offset-4 col-xs-offset-4">
                <img src="images/cart.gif" alt="">
                <a href="" style="border-right: 2px solid white">购物车</a>|
                <a href="" style="border-right: 2px solid white">帮助中心</a>|
                <a href="" style="border-right: 2px solid white">我的账户</a>|
                <a href="">新用户注册 </a>
            </div>
        </div>
    </div>
    <!--   -->
    <div style="background-color: #419641;height: 3px;margin-top: 20px;"></div>
    <div class="row" style="background-color: black;height: 50px;">
        <div class="menu">
            <ul class="nav navbar-nav" style="margin-left: 300px">
                <li><a href="#" style="color: white">文学</a></li>
                <li><a href="#" style="color: white">生活</a></li>
                <li><a href="#" style="color: white">计算机</a></li>
                <li><a href="#" style="color: white">外语</a></li>
                <li><a href="#" style="color: white">经管</a></li>
                <li><a href="#" style="color: white">励志</a></li>
                <li><a href="#" style="color: white">社科</a></li>
                <li><a href="#" style="color: white">学术</a></li>
                <li><a href="#" style="color: white">少儿</a></li>
                <li><a href="#" style="color: white">艺术</a></li>
                <li><a href="#" style="color: white">原版</a></li>
                <li><a href="#" style="color: white">科技</a></li>
                <li><a href="#" style="color: white">考试</a></li>
                <li><a href="#" style="color: white">生活百科</a></li>
                <li><a href="#" style="color: yellow">全部商品目录</a></li>
            </ul>
        </div>
    </div>



    <div class="row" style="background-color: orange;margin-bottom: 20px;">
        <div class="col-md-6 col-md-offset-5">
            <form class="navbar-form navbar-right">
                <div class="form-group">
                    <label for="exampleInputEmail2" style="color: white">Search</label>
                    <input style="height: 24px;width: 150px;" type="email" class="form-control" id="exampleInputEmail2"
                           placeholder="请输入书名">
                </div>
                <!--                <button type="submit" class="btn btn-default" style="background-color: #419641;color: white">搜索</button>-->
                <img src="images/serchbutton.gif" alt="">
            </form>
        </div>
    </div>


</header>

<div class="row">
    <div class="col-md-8 col-md-offset-2" style="background-color: #fcf8e3;margin-bottom: 20px;">
        <p style="font-size: 20px;margin-top: 20px;"><b>新会员注册</b></p>
        <div class="col-md-10 col-md-offset-1">
            <form class="form-horizontal" action="RegisterServlet" method="post" >
                <div class="form-group">
                    <label for="email" class="col-sm-2 control-label">会员邮箱：</label>
                    <div class="col-sm-3">
                        <input type="email"  class="form-control" id="email" name="usermail" >
                        <span id="usermail_err" ></span>
                    </div>
                    <p>请输入有效的邮箱地址</p>
                </div>
                <div class="form-group">
                    <label for="username" class="col-sm-2 control-label">会员名：</label>
                    <div class="col-sm-3" id="test">
                        <input type="text" class="form-control " id="username" name="username" >
                        <span id="username_err"></span>
                    </div>
                    <p>字母数字下划线1到10位, 不能是数字开头</p>
                </div>
                <div class="form-group">
                    <label for="password" class="col-sm-2 control-label">密码：</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" id="password" name="pwd" >
                        <span id="password_err"></span>
                    </div>
                    <p>密码请设置6-16位字符</p>
                </div>
                <div class="form-group">
                    <label for="repassword" class="col-sm-2 control-label">重复密码：</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" id="repassword" name="pwd2" >
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
                <div class="col-sm-10">
                    <hr style="border:1px dotted gray"/>
                </div>

                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <input  type="image" value="注册" src="images/signup.gif" >
                        <!--                        <a href="../../../../src/main/webapp/login.html"><img  alt=""></a>-->
                    </div>
                </div>
            </form>
        </div>

    </div>
</div>

<%--<!--<script>-->--%>
<%--<!--    var usermailInput;-->--%>
<%--<!--    var usernameInput;-->--%>
<%--<!--    var passwordInput;-->--%>
<%--<!--    var password2Input;-->--%>

<%--<!--    var usermail_err;-->--%>
<%--<!--    var username_err;-->--%>
<%--<!--    var password_err;-->--%>
<%--<!--    var password2_err;-->--%>

<%--<!--    window.onload = function() {-->--%>
<%--<!--        usermailInput = document.getElementById("email");-->--%>
<%--<!--        usernameInput = document.getElementById("username");-->--%>
<%--<!--        passwordInput = document.getElementById("password");-->--%>
<%--<!--        password2Input = document.getElementById("repassword");-->--%>

<%--<!--        usermail_err = document.getElementById("usermail_err");-->--%>
<%--<!--        username_err = document.getElementById("username_err");-->--%>
<%--<!--        password_err = document.getElementById("password_err");-->--%>
<%--<!--        password2_err = document.getElementById("password2_err");-->--%>
<%--<!--    };-->--%>

<%--<!--    function checkForm() {-->--%>
<%--<!--        var bEmail = checkEmail();-->--%>
<%--<!--        var bUsername = checkUsername();-->--%>
<%--<!--        var bPassword = checkPassword();-->--%>
<%--<!--        var bConfirm = checkConfirm();-->--%>
<%--<!--        return bUsername && bPassword && bConfirm && bEmail ;-->--%>
<%--<!--    }-->--%>

<%--<!--    function checkEmail() {-->--%>
<%--<!--        var regex = /^[\w-]+@([\w-]+\.)+[a-zA-Z]{2,4}$/;-->--%>
<%--<!--        var value =usermailInput.value;-->--%>
<%--<!--        var msg = "";-->--%>
<%--<!--        if (!value)-->--%>
<%--<!--            msg = "邮箱必须填写";-->--%>
<%--<!--        else if (!regex.test(value))-->--%>
<%--<!--            msg = "邮箱格式不合法";-->--%>
<%--<!--        usermail_err.innerHTML = msg;-->--%>
<%--<!--        document.getElementById("usermail_err").style.color="red"-->--%>
<%--<!--        return msg == "";-->--%>
<%--<!--    }-->--%>

<%--<!--    function checkUsername() {-->--%>
<%--<!--        var regex = /^[a-zA-Z_]\w{0,9}$/;-->--%>
<%--<!--        var value = usernameInput.value;-->--%>
<%--<!--        var msg = "";-->--%>
<%--<!--        if (!value)-->--%>
<%--<!--            msg = "用户名必须填写";-->--%>
<%--<!--        else if (!regex.test(value))-->--%>
<%--<!--            msg = "用户名不合法";-->--%>
<%--<!--        username_err.innerHTML = msg;-->--%>
<%--<!--        document.getElementById("username_err").style.color="red"-->--%>
<%--<!--        return msg == "";-->--%>
<%--<!--    }-->--%>

<%--<!--    function checkPassword() {-->--%>
<%--<!--        var regex = /^.{6,16}$/;-->--%>
<%--<!--        var value = passwordInput.value;-->--%>
<%--<!--        var msg = "";-->--%>
<%--<!--        if (!value)-->--%>
<%--<!--            msg = "密码必须填写";-->--%>
<%--<!--        else if (!regex.test(value))-->--%>
<%--<!--            msg = "密码不合法";-->--%>
<%--<!--        password_err.innerHTML = msg;-->--%>
<%--<!--        document.getElementById("password_err").style.color="red"-->--%>
<%--<!--        return msg == "";-->--%>
<%--<!--    }-->--%>

<%--<!--    function checkConfirm() {-->--%>
<%--<!--        var passwordValue = passwordInput.value;-->--%>
<%--<!--        var confirmValue = password2Input.value;-->--%>
<%--<!--        var msg = "";-->--%>

<%--<!--        if(!confirmValue){-->--%>
<%--<!--            msg = "确认密码必须填写";-->--%>
<%--<!--        }-->--%>
<%--<!--        else	if (passwordValue != confirmValue){-->--%>
<%--<!--            msg = "密码必须保持一致";-->--%>
<%--<!--        }-->--%>
<%--<!--        password2_err.innerHTML = msg;-->--%>
<%--<!--       document.getElementById("password2_err").style.color="red"-->--%>
<%--<!--        return msg == "";-->--%>
<%--<!--    }-->--%>


<%--<!--</script>-->--%>

<footer style="margin-top: 15px">
    <div style="background-color: #c0c0c0;height: 65px;">
        <div class="row">
            <div class="col-md-3 col-lg-offset-1 col-xs-3 col-sm-3 col-md-offset-1 col-xs-offset-1 col-sm-offset-1 "><img src="images/logo.png" style="height: 55px"></div>
            <div class="col-md-6 col-xs-6 col-sm-6">
                <p style="font-weight: bold">CONTACTUS</p>
                <strong style="color: #9d9d9d">COPYRIGHT 2015◎BookStore All Rights RESERVED.</strong>
            </div>
        </div>

    </div>
</footer>


</body>
</html>
