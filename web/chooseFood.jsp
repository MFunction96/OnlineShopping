<%--
  Created by IntelliJ IDEA.
  User: hlys0
  Date: 2018/5/23
  Time: 10:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>OnlineShopping</title>
</head>
<body>
<main role="main" class="container">
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
                            <a class="nav-link" href="register">注册</a>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li class="nav-item">
                            <a class="nav-link" href="login?code=2">${user.getAcName()}</a>
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
<div class="album py-5 bg-light">
    <div >
        <div class="row">
            <c:choose>
                <c:when test="${dishes.isEmpty()}">
                    <div class="alert alert-danger" role="alert">
                        当前商家没有吃的
                    </div>
                </c:when>
                <c:otherwise>
                    <c:forEach var="dish" items="${dishes}">
                        <div class="col-md-4">
                            <div class="card mb-4 box-shadow">
                                <form name="senditem" method="post" action="chooseFood">
                                    <img class="card-img-top" data-src="${dish.getDiImage()}" alt="Thumbnail [100%x225]" style="height: 225px; width: 100%; display: block;" src="${dish.getDiImage()}" data-holder-rendered="true">
                                    <div class="card-body">
                                        <p class="card-text">名称：${dish.getDiName()}</p>
                                        <p class="card-text">价格：${dish.getDiPrice()}</p>
                                        <p class="card-text">描述：${dish.getDiDesc()}</p>
                                        <input type="hidden" name="diid" id="diid" value="${dish.getDiId()}" >
                                        <input type="hidden" name="diname" id="diname" value="${dish.getDiName()}" >
                                        <input type="hidden" name="diimage" id="diimage" value="${dish.getDiImage()}" >
                                        <input type="hidden" name="diprice" id="diprice" value="${dish.getDiPrice()}" >
                                        <input type="hidden" name="sid" id="sid" value="${store.getStId()}" >
                                        <input type="hidden" name="sname" id="sname" value="${store.getStName()}" >
                                        <input type="hidden" name="actype" id="actype" value="addcart" >
                                        <div class="d-flex justify-content-between align-items-center">
                                            <div class="btn-group">
                                                <input type=submit class="btn btn-sm btn-outline-secondary" value="加入购物车" ></input>
                                            </div>
                                        </div>
                                    </div>
                                </form>

                            </div>
                        </div>
                    </c:forEach>
                </c:otherwise>
            </c:choose>

        </div>
    </div>
</div>

</main>
<form method="get"action="shoppingCart.jsp">
    <button>去结算</button>
</form>
<script type="text/javascript" src="dist/bundle.js"></script>
<script type="text/javascript" src="js/site.js"></script>
</body>
</html>
