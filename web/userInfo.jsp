<%--
  Created by IntelliJ IDEA.
  User: hlys0
  Date: 2018/6/6
  Time: 17:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" class="translated-ltr">
<head>
    <meta charset="UTF-8">
    <title>个人信息管理</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
</head>
<body>
<style>
    body
    {
        background: url('images/background2.jpg');
        background-size: cover;
    }
</style>
<nav class="navbar navbar-dark fixed-top bg-dark flex-md-nowrap p-0 shadow">
    <a class="navbar-brand col-sm-3 col-md-2 mr-0" href="#">久日</a>
    <input class="form-control form-control-dark w-100" type="text" placeholder="Search" aria-label="Search">
    <ul class="navbar-nav px-3">
        <li class="nav-item text-nowrap">
            <a class="nav-link" href="#">Sign out</a>
        </li>
    </ul>
</nav>
<div class="container-fluid">
    <div class="row">
        <nav class="col-md-2 d-none d-md-block bg-light sidebar">
            <div class="sidebar-sticky">
                <ul class="nav flex-column">
                    <li class="nav-item">
                        <a class="nav-link active" href="#">
                            个人信息
                        </a>
                    </li>
                </ul>
            </div>
        </nav>
        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4"><div class="chartjs-size-monitor" style="position: absolute; left: 0px; top: 0px; right: 0px; bottom: 0px; overflow: hidden; pointer-events: none; visibility: hidden; z-index: -1;"><div class="chartjs-size-monitor-expand" style="position:absolute;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1;"><div style="position:absolute;width:1000000px;height:1000000px;left:0;top:0"></div></div><div class="chartjs-size-monitor-shrink" style="position:absolute;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1;"><div style="position:absolute;width:200%;height:200%;left:0; top:0"></div></div></div>
            <div class="jumbotron">
                <div class="col-sm-8 mx-auto">
                    <h1>个人信息</h1>
                    <p>
                    <div class="row">
                        <div class="col-sm-3 bg-white">用户名：</div>
                        <div class="col-sm-6 bg-light">久日</div>
                        <div class="col-sm-2 bg-white ">性别：</div>
                        <div class="col-sm-1bg-light">男</div>
                        <div class="col-sm-4 bg-white ">生日：</div>
                        <div class="col-sm-8 bg-light">19981028</div>
                        <div class="col-sm-4 bg-white ">手机：</div>
                        <div class="col-sm-8 bg-light">159****1702</div>
                        <div class="col-sm-4 bg-white ">地址：</div>
                        <div class="col-sm-8 bg-light">中国地质大学（北京）19号楼</div>
                    </div>
                    </p>
                    <input type="submit" name="submit" class="btn btn-lg btn-primary" value="修改信息">
                </div>
            </div>
        </main>
    </div>
</div>
<script type="text/javascript" src="./dist/bundle.js"></script>
<script type="text/javascript" src="./js/site.js"></script>
<script type="text/javascript" src="js/uvalidation.js"></script>
</body>
</html>
