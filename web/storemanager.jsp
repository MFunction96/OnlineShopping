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
    function addD() {
        let main1=document.getElementById("main1");
        let main2=document.getElementById("main2");
        let main3=document.getElementById("main3");
        if (main1.style.display==="none"){
            main1.style.display="block";
        }
        if(main2.style.display==="block"){
            main2.style.display="none";
        }
        if (main3.style.display==="block"){
            main3.style.display="none";
        }
    }
</script>
    <script type="text/javascript">
        function chaD() {
            let main1=document.getElementById("main1");
            let main2=document.getElementById("main2");
            let main3=document.getElementById("main3");
            if (main2.style.display==="none"){
                main2.style.display="block";
            }
            if(main1.style.display==="block"){
                main1.style.display="none";
            }
            if (main3.style.display==="block"){
                main3.style.display="none";
            }
        }
    </script>
    <script type="text/javascript">
        function delD() {
            let main1=document.getElementById("main1");
            let main2=document.getElementById("main2");
            let main3=document.getElementById("main3");
            if (main3.style.display==="none"){
                main3.style.display="block";
            }
            if(main1.style.display==="block"){
                main1.style.display="none";
            }
            if (main2.style.display==="block"){
                main2.style.display="none";
            }
        }
    </script>
</head>
<body>
<nav class="navbar navbar-dark fixed-top bg-dark flex-md-nowrap p-0 shadow">
    <a class="navbar-brand col-sm-3 col-md-2 mr-0" href="#" name="storename" id="storename">Company name</a>

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
                <h6 class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted">
                    <span> 菜品管理</span>
                </h6>
                <ul class="nav flex-column">
                    <li class="nav-item">
                        <a class="nav-link active" onclick="addD()">
                            添加菜品
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" onclick="chaD()">
                            修改菜品
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" onclick="delD()">
                            删除菜品
                        </a>
                    </li>
                </ul>
                <h6 class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted">
                    <span>订单管理</span>
                </h6>
                <ul class="nav flex-column mb-2">
                    <li class="nav-item">
                        <a class="nav-link active" >
                            查看订单
                        </a>
                    </li>
                </ul>
            </div>
        </nav>
        <div class="col-md-9 ml-sm-auto col-lg-10 px-4" id="main1"style="display: none">
            <div><jsp:include page="adddish.jsp"/></div>
        </div>
        <div class="col-md-9 ml-sm-auto col-lg-10 px-4" id="main2"style="display: none">
            <div><jsp:include page="login.jsp"/></div>
        </div>
        <div class="col-md-9 ml-sm-auto col-lg-10 px-4" id="main3" style="display: none">
            <div><jsp:include page="uregister.jsp"/></div>
        </div>
    </div>
</div>
<script type="text/javascript" src="dist/bundle.js"></script>
<script type="text/javascript" src="js/site.js"></script>
</body>
</body>
</html>
