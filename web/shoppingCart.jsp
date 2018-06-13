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
    <div class="accordion" id="accordionExample">
        <c:forEach var="dish" items="${dishes}">
            <div class="card">
                <div class="card-header" id="h${dish.getDishorderBean().getStid()}">
                    <h5 class="mb-0">
                        <button class="btn btn-link" type="button" data-toggle="collapse" data-target="#${dish.getDishorderBean().getStid()}" aria-expanded="true" aria-controls="${dish.getDishorderBean().getStid()}">
                            ${dish.getDishorderBean().getStname()}
                        </button>
                    </h5>
                </div>

                <div id="${dish.getDishorderBean().getStid()}" class="collapse show" aria-labelledby="h${dish.getDishorderBean().getStid()}" data-parent="#accordionExample">
                    <div class="card-body">
                        Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt sapiente ea proident. Ad vegan excepteur butcher vice lomo. Leggings occaecat craft beer farm-to-table, raw denim aesthetic synth nesciunt you probably haven't heard of them accusamus labore sustainable VHS.
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
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