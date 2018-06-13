
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-cn">
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
    <section class="jumbotron text-center">
        <div class="container">
            <img src="images/logo.png" width="128" height="80">
            <p class="lead text-muted">      </p>
            <form id="searchform" method="get" action="chooseRestaurant">
                <div class="row">
                    <div class="col-md-10">
                        <input class="form-control mr-sm-2" type="text" name="search" id="search" placeholder="搜索商家" aria-label="search">
                        <input type="hidden" name="actiontype" id="actiontype" value="search">
                    </div>
                    <div class="col-md-1">
                        <input class="btn btn-outline-success my-2 my-sm-0" type="submit" value="搜索">
                    </div>
                </div>
            </form>
        </div>
    </section>
    <div class="album py-5 bg-light">
        <div class="container">
            <div class="row">
                <c:forEach var="store" items="${stores}">
                    <div class="col-md-4">
                        <div class="card mb-4 box-shadow">
                            <form name="sendid" method="post" action="chooseFood">
                                <img class="card-img-top" data-src="${store.getStImage()}" alt="Thumbnail [100%x225]" style="height: 225px; width: 100%; display: block;" src="${store.getStImage()}" data-holder-rendered="true">
                                <div class="card-body">
                                    <p class="card-text">名称：${store.getStName()}</p>
                                    <p class="card-text">联系方式：${store.getStPhone()}</p>
                                    <p class="card-text">描述：${store.getStDesc()}</p>
                                    <input type="hidden" name="stid" id="stid" value="${store.getStId()}">
                                    <input type="hidden" name="stname" id="stname" value="${store.getStName()}">
                                    <input type="hidden" name="stimg" id="stimg" value="${store.getStImage()}">
                                    <input type="hidden" name="stdesc" id="stdesc" value="${store.getStDesc()}">
                                    <input type="hidden" name="actype" id="actype" value="showfood">
                                    <div class="d-flex justify-content-between align-items-center">
                                        <div class="btn-group">
                                            <input type=submit class="btn btn-sm btn-outline-secondary" value="看菜" ></input>
                                        </div>
                                    </div>
                                </div>
                            </form>

                        </div>
                    </div>
                </c:forEach>

            </div>
        </div>
    </div>
    <table align="center">
        <tbody>
        <tr>
            <td  >
                <nav>
                    <ul class="pagination justify-content-center">
                        <li class="page-item disabled">
                            <a class="page-link" name="btnTopPage"  id="btnTopPage" href="chooseRestaurant?actiontype=pagelist&pageNo=1" title="首页">首页</a>
                        </li>
                        <li class="page-item"><a class="page-link"  name="btnPreviousPage"  id="btnPreviousPage" href="chooseRestaurant?actiontype=pagelist&pageNo=${pageModel.getPrePage()}" title="上页">上一页</a></li>
                        <li class="page-item"><a class="page-link" name="btnNextPage"  id="btnNextPage" href="chooseRestaurant?actiontype=pagelist&pageNo=${pageModel.getNextPage()}" title="下页">下一页</a></li>
                        <li class="page-item"><a class="page-link" name="btnBottomPage"  id="btnBottomPage" href="chooseRestaurant?actiontype=pagelist&pageNo=${pageModel.getLastPage()}" title="尾页">尾页</a></li>
                    </ul>
                </nav>
            </td>
            <td  height="2">
                <div align="left">
                    <span style="color: #000000; ">&nbsp;共&nbsp${param.totalpages}&nbsp页</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <span style="color: #000000; ">当前第</span>&nbsp
                    <span style="color: #000000; ">${param.pageNo}</span>&nbsp
                    <span style="color: #000000; ">页</span>
                </div>
            </td>
        </tr>
        </tbody>
    </table>

</main>
<script type="text/javascript" src="dist/bundle.js"></script>
<script type="text/javascript" src="js/site.js"></script>

</body>
</html>
