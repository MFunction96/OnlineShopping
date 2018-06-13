<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: hlys0
  Date: 2018/6/7
  Time: 10:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>OnlineShopping</title>

</head>
<body>
<div class="container">
    <h2>菜品管理</h2>
    <!--按钮触发模态框-->
    <button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#addDish">添加菜品</button>
    <!--模态框-->
    <div class="modal  fade" id="addDish" tabindex="-1" role="dialog" aria-labelledby="addDishLabel"
         aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title" id="addDishLabel">添加菜品信息</h4>
                </div>
                <form name="addDishInfo" id="addDishInfo" method="post" action="storemanager?method=add">
                <div class="modal-body">
                        <div class="mb-3">
                            <label for="diImage">
                                     <span style="vertical-align: inherit;">
                                         <span style="vertical-align: inherit;">菜品图片</span>
                                     </span>
                            </label>
                            <input class="form-control" type="file" name="diImage" id="diImage">
                            <label for="dishname">
                                    <span style="vertical-align: inherit;">
                                         <span style="vertical-align: inherit;">菜名</span>
                                    </span>
                            </label>
                            <input type="text" name="dishname" class="form-control" id="dishname"
                                   placeholder="请输入菜品名" required>
                            <label for="diprice">
                                 <span style="vertical-align: inherit;">
                                        <span style="vertical-align: inherit;">价格</span>
                                  </span>
                            </label>
                            <input class="form-control" name="diprice" id="diprice" type="text" placeholder="请输入价格"
                                   required>
                            <label for="didesc">
                                     <span style="vertical-align: inherit;">
                                          <span style="vertical-align: inherit;">描述</span>
                                     </span>
                            </label>
                            <input class="form-control" name="didesc" id="didesc" type="text" placeholder="请输入描述">
                        </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="submit" class="btn btn-primary">提交</button>
                </div>
                </form>
            </div>
        </div>
    </div>
</div>
<main role="main" class="container">

    <div class="album py-5 bg-light">
        <div class="container">
            <div class="row">
                <c:forEach var="dish" items="${dishes}">
                    <div class="col-md-4">
                        <div class="card mb-4 box-shadow">
                            <form name="sendid" method="post" action="chooseFood">
                                <img class="card-img-top"
                                     data-src="holder.js/100px225?theme=thumb&amp;bg=55595c&amp;fg=eceeef&amp;text=Thumbnail"
                                     alt="Thumbnail [100%x225]" style="height: 225px; width: 100%; display: block;"
                                     src="data:image/svg+xml;charset=UTF-8,%3Csvg%20width%3D%22208%22%20height%3D%22225%22%20xmlns%3D%22http%3A%2F%2Fwww.w3.org%2F2000%2Fsvg%22%20viewBox%3D%220%200%20208%20225%22%20preserveAspectRatio%3D%22none%22%3E%3Cdefs%3E%3Cstyle%20type%3D%22text%2Fcss%22%3E%23holder_163be1c92ec%20text%20%7B%20fill%3A%23eceeef%3Bfont-weight%3Abold%3Bfont-family%3AArial%2C%20Helvetica%2C%20Open%20Sans%2C%20sans-serif%2C%20monospace%3Bfont-size%3A11pt%20%7D%20%3C%2Fstyle%3E%3C%2Fdefs%3E%3Cg%20id%3D%22holder_163be1c92ec%22%3E%3Crect%20width%3D%22208%22%20height%3D%22225%22%20fill%3D%22%2355595c%22%3E%3C%2Frect%3E%3Cg%3E%3Ctext%20x%3D%2266.9296875%22%20y%3D%22117.3%22%3EThumbnail%3C%2Ftext%3E%3C%2Fg%3E%3C%2Fg%3E%3C%2Fsvg%3E"
                                     data-holder-rendered="true">
                                <div class="card-body">
                                    <p class="card-text">名称：${dish.getDiName()}</p>
                                    <p class="card-text">价格：${dish.getDiPrice()}</p>
                                    <p class="card-text">描述：${dish.getDiDesc()}</p>
                                    <input type="hidden" name="diid" id="diid" value="${dish.getDiId()}">
                                    <div class="d-flex justify-content-between align-items-center">
                                        <div class="btn-group">
                                            <input type=submit class="btn btn-sm btn-outline-secondary"
                                                   value="View"></input>
                                            <button type="button" class="btn btn-sm btn-outline-secondary "
                                                    onclick="window.location.href='/chooseFood?stid=${store.getStId()}'">
                                                Edit
                                            </button>
                                        </div>
                                        <small class="text-muted">9 mins</small>
                                    </div>
                                </div>
                            </form>

                        </div>
                    </div>
                </c:forEach>

            </div>
        </div>
    </div>

</main>
<script type="text/javascript" src="dist/bundle.js"></script>
<script type="text/javascript" src="js/site.js"></script>
<script>queryTime()</script>
</body>
</html>