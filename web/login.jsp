<%--
  Created by IntelliJ IDEA.
  User: hlys0
  Date: 2018/5/31
  Time: 7:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en" class="translated-ltr">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>OnlineShopping</title>
</head>
<body class="text-center">
<form class=" form-signin">
    <img  class="mb-4"src="/images/background01.jpg"alt width="72",height="72">
    <h1 class="h3 mb-3 font-weight-normal">
        <span style="vertical-align: inherit;">
            <span style="vertical-align: inherit">请登录</span>
        </span>
    </h1>
    <label for="inputUsername" class="sr-only">
        <span style="vertical-align: inherit" >
            <span style="vertical-align: inherit">用户名</span>
        </span>
    </label>
    <input  id="inputUsername" class="form-control"placeholder="请输入用户名" required autofocus>
    <label for="inputPassword" class="sr-only">
        <span style="vertical-align: inherit;">
            <span style="vertical-align: inherit">密码</span>
        </span>
    </label>
    <input type="password" id="inputPassword"class="form-control" placeholder="请输入密码"required>
    <div class="checkbox mb-3">
        <label>
            <input type="checkbox" value="rememner-me">
            <span style="vertical-align: inherit;">
                <span style="vertical-align: inherit">记住密码</span>
            </span>
        </label>
    </div>
    <button class="btn btn-lg btn-primary btn-block" type="submit">
        <span style="vertical-align: inherit;">
                <span style="vertical-align: inherit">登录</span>
            </span>
    </button>
    <div class="container body-content">
        <hr/>
        <footer class="text-center">
            <p>Power by ASP.NET Core 2.0</p>
            <p>Copyright &copy; 2016 - 2018 MFBlog</p>
            <p>All Right Reserved</p>
            <p id="ServerTime"></p>
        </footer>
    </div>
</form>

<script type="text/javascript" src="dist/bundle.js"></script>
<script type="text/javascript" src="js/site.js"></script>
<script>queryTime()</script>
</body>
</html>
