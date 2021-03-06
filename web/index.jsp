<%--
  Created by IntelliJ IDEA.
  User: MFunction
  Date: 05/10/2018
  Time: 08:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>OnlineShopping</title>
</head>
<body>
<nav class="navbar navbar-expand-lg flex-column fixed-top flex-md-row navbar-light bg-light" >
    <div class="container">
        <div class="navbar-header">
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                    aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <img src="images/logo.png" width="60" height="30">
        </div>
        <div class="navbar-collapse collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item">
                    <a class="nav-link" href="chooseRestaurant?actiontype=show">首页</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="cashRegister">收银台</a>
                </li>

            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li class="nav-item">
                    <img src="images/icon/people.png" height="25" width="25">
                </li>
                <c:choose>
                    <c:when test="${user==null}">
                        <li class="nav-item">
                            <a class="nav-link" href="login?code=1" >登录</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="uregister">注册</a>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li class="nav-item">
                            <a class="nav-link" href="userInfo">${user.getAcName()}</a>
                        </li>
                    </c:otherwise>
                </c:choose>
                <li class="nav-item">
                    <img src="images/icon/cart.png" height="25" width="25">
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="shoppingCart">购物车</a>
                </li>
            </ul>
        </div>

    </div>
</nav>
<div class="container body-content">
    @RenderBody()
    <hr/>
    <footer class="text-center">
        <p>Copyright &copy; 2016 - 2018 MFBlog</p>
        <p>All Right Reserved</p>
        <p id="ServerTime"></p>
    </footer>
</div>
<script type="text/javascript" src="dist/bundle.js"></script>
<script type="text/javascript" src="js/site.js"></script>
</body>
</html>
