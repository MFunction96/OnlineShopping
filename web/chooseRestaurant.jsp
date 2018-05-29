<%--
  Created by IntelliJ IDEA.
  User: hlys0
  Date: 2018/5/23
  Time: 10:02
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

<form>
    <div onclick="getDIV()" ><a href="#">获得question下的所有div</a>v</div>
    <div id="ceshi" onclick="createQuestion('question_danxuan')" ><a href="#">动态添加div</a></div>
    <div>
        <div id="sur" class="survey">
            <div>
                <div id="question" class="surveycontent"></div>
            </div>
        </div>
    </div>
</form>
<script type="text/javascript"  src="js/list.js"></script>
<script type="text/javascript" src="dist/bundle.js"></script>
<script type="text/javascript" src="js/site.js"></script>
<script>queryTime()</script>
</body>
</html>
