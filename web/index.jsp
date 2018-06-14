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
<header>
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
                    <a class="nav-link" href="chooseRestaurant?actiontype=show">查看商家</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="chooseFood">选择食物</a>
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
</header>

<div class="container body-content">
    <main role="main">
        <div id="myCarousel" class="carousel slide" data-ride="carousel">
            <ol class="carousel-indicators">
                <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                <li data-target="#myCarousel" data-slide-to="1" class=""></li>
                <li data-target="#myCarousel" data-slide-to="2" class=""></li>
            </ol>
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <img class="first-slide" src="images/chihuo01.jpg" alt="First slide">
                    <div class="container">
                        <div class="carousel-caption text-left">
                            <h1>西式餐点</h1>
                            <p>肥嫩的肉质被烤得焦黄脆嫩,浓香的汁液包裹在周围,在灯光下泛出点点的油光,扑鼻的香味阵阵袭来......</p>
                            <p><a class="btn btn-lg btn-primary" href="#" role="button">尝尝</a></p>
                        </div>
                    </div>
                </div>
                <div class="carousel-item">
                    <img class="second-slide" src="images/chihuo02.jpg" alt="Second slide">
                    <div class="container">
                        <div class="carousel-caption">
                            <h1>西式餐点</h1>
                            <p>黄果树瀑布像
                                拔地而起
                                很会拉丝的披萨</p>
                            <p><a class="btn btn-lg btn-primary" href="#" role="button">尝尝</a></p>
                        </div>
                    </div>
                </div>
                <div class="carousel-item">
                    <img class="third-slide" src="images/chihuo03.jpg" alt="Third slide">
                    <div class="container">
                        <div class="carousel-caption text-right">
                            <h1>中式小吃</h1>
                            <p>大学门口的小吃街 是我最爱去的地方。
                                常常感到神奇，那么简单的一个个摊位，怎么能变出那么美味的食物呢？像神秘的宝盒！
                                那是城市的灵魂，那是人间的实感，更是生活的重量。</p>
                            <p><a class="btn btn-lg btn-primary" href="#" role="button">尝尝</a></p>
                        </div>
                    </div>
                </div>
            </div>
            <a class="carousel-control-prev" href="#myCarousel" role="button" data-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="carousel-control-next" href="#myCarousel" role="button" data-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>

    </main>
    <hr/>
    <footer class="text-center">
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
