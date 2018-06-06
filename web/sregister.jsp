<%--
  Created by IntelliJ IDEA.
  User: hlys0
  Date: 2018/6/3
  Time: 16:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>注册-商家</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
</head>
<body class="bg-light">
<div class="container">
    <div class="py-5 text-center">
        <h2>
            <span style="vertical-align: inherit">
                <span style="vertical-align: inherit">注册商家</span>
            </span>
        </h2>
    </div>
    <div class="row">
        <div class="col-md-12 order-md-1 ">
            <form name="adds" id="adds" method="post" action="sregister" enctype="multipart/form-data">
                <div class="mb-3">
                    <label for="storelogo">
                        <span style="vertical-align: inherit;">
                            <span style="vertical-align: inherit;">店铺标志</span>
                        </span>
                    </label>
                    <div class="col-sm-4">
                        <input id="storelogo" name="storelogo"  type="file">
                        <p >支持jpg、png格式，大小不超过5M</p>
                    </div>
                    <label for="storename">
                        <span style="vertical-align: inherit;">
                            <span style="vertical-align: inherit;">店名</span>
                        </span></label>
                    <div class="input-group">
                        <input type="text" name="storename" class="form-control" id="storename" placeholder="请输入用户名"
                               required="">
                    </div>
                    <div class="mb-3">

                        <label for="phone">
                        <span style="vertical-align: inherit;">
                            <span style="vertical-align: inherit;">手机号</span>
                        </span>
                        </label>
                        <input type="text" name="phone" class="form-control" id="phone" placeholder="请输入你的手机号"
                               required="">
                        <div class="invalid-feedback">请输入你的手机号码</div>

                        <label for="sdesc">
                        <span style="vertical-align: inherit;">
                            <span style="vertical-align: inherit;">简介</span>
                        </span>
                        </label>
                        <textarea name="sdesc" class="form-control" id="sdesc" rows="4" cols="30" required></textarea>
                    </div>
                    <hr class="mb-4">
                    <p>
                        <input type="submit" name="submit">
                    </p>
                </div>
            </form>
        </div>
    </div>
</div>

<script type="text/javascript" src="./dist/bundle.js"></script>
<script type="text/javascript" src="./js/site.js"></script>
<script type="text/javascript" src="js/svalidation.js"></script>
</body>
</html>
