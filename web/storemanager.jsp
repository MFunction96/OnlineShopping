<%--
  Created by IntelliJ IDEA.
  User: hlys0
  Date: 2018/6/7
  Time: 8:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>商家管理</title>
    <script type="text/javascript">
        var adddiv="<div><jsp:include page='login.jsp'/></div>";
        function adddish() {
            document.getElementById("main").innerHTML="";

        }
    </script>
</head>
<body>
<div class="row">
    <nav class="col-md-2 d-none d-md-block bg-light sidebar">
        <div class="sidebar-sticky">
            <h6 class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted">
                <span> 菜品管理</span>
            </h6>
            <ul class="nav flex-column">
                <li class="nav-item">
                    <a class="nav-link active" onclick="adddish()">
                        添加菜品
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active">
                        修改菜品
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active">
                        删除菜品
                    </a>
                </li>
            </ul>
            <h6 class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted">
                <span>订单管理</span>
            </h6>
            <ul class="nav flex-column mb-2">
                <li class="nav-item">
                    <a class="nav-link" >
                        查看订单
                    </a>
                </li>
            </ul>
        </div>

    </nav>
    <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4" id="main1">
        <div><jsp:include page="uregister.jsp"/></div>
    </main>
</div>
</body>
</html>
