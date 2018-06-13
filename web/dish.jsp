<%--
  Created by IntelliJ IDEA.
  User: hlys0
  Date: 2018/6/7
  Time: 14:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>OnlineShopping</title>
    <base target="_self">
    <--!打开main.html页面然后点击链接可以正常弹出模式窗口，但是在模式窗口中点击SUBMIT按钮却无法提交表单>
    <script type="text/javascript">
        window.onload=function () {
            let obj = window.isArguments();
            if(obj!=null){
                document.getElementById("diImage").innerHTML=obj.dimage;
                document.getElementById("dishname").innerText=obj.dname;
                document.getElementById("diprice").innerText=obj.price;
                document.getElementById("didesc").innerText=obj.desc;
            }
        }
    </script>
</head>
<body>
<form name="dishmodel" id="dishmodel" method="post" action="StoreControl?method=add">
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
        <input type="text" name="dishname" class="form-control" id="dishname" placeholder="请输入菜品名" required>
        <label for="diprice">
            <span style="vertical-align: inherit;">
                <span style="vertical-align: inherit;">价格</span>
            </span>
        </label>
        <input class="form-control" name="diprice" id="diprice" type="text" placeholder="请输入价格" required >
        <label for="didesc">
            <span style="vertical-align: inherit;">
                <span style="vertical-align: inherit;">描述</span>
            </span>
        </label>
        <input class="form-control" name="didesc" id="didesc" type="text" placeholder="请输入描述"  >

    </div>
</form>
<script type="text/javascript" src="dist/bundle.js"></script>
<script type="text/javascript" src="js/site.js"></script>
</body>
</html>
