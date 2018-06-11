<%--
  Created by IntelliJ IDEA.
  User: hlys0
  Date: 2018/5/23
  Time: 10:02
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
<nav class="navbar navbar-expand-lg flex-column fixed-top flex-md-row navbar-light bg-light">
    <div class="container">
        <div class="navbar-header">
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                    aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <a class="navbar-brand">MFBlog</a>
        </div>
        <div class="navbar-collapse collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item">
                    <a class="nav-link" href="chooseRestaurant?actiontype=show">查看商家</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="chooseFood">选择食物</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="shoppingCart">购物车</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="cashRegister">收银台</a>
                </li>
            </ul>
            <c:choose>
                <c:when test="${user==null}">
                    <form class="navbar-right">
                        <ul class="nav navbar-nav ">
                            <li class="nav-item">
                                <a class="nav-link" href="login?code=1">欢迎，请登录</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="register">注册</a>
                            </li>
                        </ul>
                    </form>
                </c:when>
                <c:otherwise>
                    <ul class="nav navbar-nav navbar-right">
                        <li class="nav-item navbar-right">
                            <a class="nav-link">欢迎 ${user.getAcName()}</a>
                        </li>
                        <li class="nav-item navbar-right">
                            <a class="nav-link" href="login?code=2">注销</a>
                        </li>
                    </ul>
                </c:otherwise>
            </c:choose>
        </div>

    </div>
</nav>
<div class="container body-content">
    <nav aria-label="Page navigation example">
        <ul class="pagination justify-content-center">
            <li class="page-item disabled">
                <a class="page-link" href="#" tabindex="-1">Previous</a>
            </li>
            <li class="page-item"><a class="page-link" href="chooseRestaurant?actiontype=pagelist&pageNo=${_pageModel.getPrePage()}">1</a></li>
            <li class="page-item"><a class="page-link" href="chooseRestaurant?actiontype=pagelist&pageNo=${_pageModel.getNextPage()}">2</a></li>
            <li class="page-item"><a class="page-link" href="#">3</a></li>
            <li class="page-item">
                <a class="page-link" href="#">Next</a>
            </li>
        </ul>
    </nav>
    <hr/>
    <footer class="text-center">
        <p>Power by ASP.NET Core 2.0</p>
        <p>Copyright &copy; 2016 - 2018 MFBlog</p>
        <p>All Right Reserved</p>
        <p id="ServerTime"></p>
    </footer>
</div>
<script type="text/javascript" src="dist/bundle.js"></script>
<script type="text/javascript" src="js/site.js"></script>
<script>queryTime()</script>
</body>
</html>