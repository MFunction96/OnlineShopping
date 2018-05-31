<%--
  Created by IntelliJ IDEA.
  User: hlys0
  Date: 2018/5/30
  Time: 17:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en" class="translated-ltr">
<head>
    <meta charset="UTF-8">
    <title>注册</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<script type="text/javascript">
    function addUser() {
        alert("提交事件!");
        form.submit();
        window.location="login.jsp";
    }
</script>
</head>
<body class="bg-light">
<div class="container">
    <div class="py-5 text-center">
        <h2>
            <span style="vertical-align: inherit">
                <span style="vertical-align: inherit">注册账户</span>
            </span>
        </h2>

    </div>
    <div class="row">
        <div class="col-md-12 order-md-1 ">
            <form name="addu" id="addu" method="post">
                <div class="mb-3">
                    <label for="username">
                        <span style="vertical-align: inherit;">
                            <span style="vertical-align: inherit;">用户名</span>
                        </span></label>
                    <div class="input-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text">
                                <span style="vertical-align: inherit;">
                                    <span style="vertical-align: inherit;">@</span>
                                </span>
                            </span>
                        </div>
                        <input type="text" name="username" class="form-control" id="username" placeholder="请输入用户名"
                               required="">
                    </div>
                    <label for="password">
                            <span style="vertical-align: inherit;">
                                <span style="vertical-align: inherit;">密码</span>
                            </span>
                    </label>
                    <div class="input-group">
                        <input type="password" name="password" class="form-control" id="password" placeholder="请输入密码"
                               required="">

                    </div>
                    <label for="confirm_password">
                        <span style="vertical-align: inherit;">
                            <span style="vertical-align: inherit;">验证密码</span>
                        </span>
                    </label>
                    <div class="input-group">
                        <input type="password" name="confirm_password" class="form-control" id="confirm_password"
                               placeholder="请再次输入密码" required="">

                    </div>
                    <div class="mb-3">
                        <label for="birthday">
                        <span style="vertical-align: inherit;">
                            <span style="vertical-align: inherit;">生日</span>
                        </span>
                            <span class="text-muted">
                            <span style="vertical-align: inherit;">
                                <span style="vertical-align: inherit;">（可选）
                                </span>
                            </span>
                        </span>
                        </label>
                        <input type="text" class="form-control" name="birthday" id="birthday"
                               placeholder="格式如：1900-01-01或1900/01/01">
                        <label for="phone">
                        <span style="vertical-align: inherit;">
                            <span style="vertical-align: inherit;">手机号</span>
                        </span>
                        </label>
                        <input type="phone" name="phone" class="form-control" id="phone" placeholder="请输入你的手机号"
                               required="">
                        <div class="invalid-feedback">请输入你的手机号码</div>
                        <div class="row">
                            <div class="col-md-5 mb-3">
                                <label for="sex">
                            <span style="vertical-align: inherit;">
                                <span style="vertical-align: inherit;">您是</span>
                            </span>
                                </label>
                                <select class="custom-select d-block w-100" name="sex" id="sex">
                                    <option value="sex">性别</option>
                                    <option value="w">女士</option>
                                    <option value="m">先生</option>
                                </select>
                            </div>
                            <div class="col-md-5 mb-3">
                                <label for="role">
                            <span style="vertical-align: inherit;">
                                <span style="vertical-align: inherit;">您是</span>
                            </span>
                                </label>
                                <select class="custom-select d-block w-100" name="role" id="role">
                                    <option value="0">角色</option>
                                    <option value="1">订餐者</option>
                                    <option value="2">商家</option>
                                </select>
                            </div>
                        </div>
                        <label for="address">
                        <span style="vertical-align: inherit;">
                            <span style="vertical-align: inherit;">地址</span>
                        </span>
                        </label>
                        <input type="text" name="address" class="form-control" id="address" placeholder="例如XX区XX街XX楼XX号"
                               required="">
                        <div class="invalid-feedback">
                            Please enter your shipping address.
                        </div>
                    </div>
                    <hr class="mb-4">

                    <button class="btn btn-primary btn-lg btn-block" type="button" name="register" onclick="addUser()">
                    <span style="vertical-align: inherit;">
                        <span style="vertical-align: inherit;">注册</span>
                    </span>
                    </button>
                </div>

            </form>
        </div>
    </div>
</div>

<script type="text/javascript" src="./dist/bundle.js"></script>
<script type="text/javascript" src="./js/site.js"></script>
<script type="text/javascript" src="./js/formvaildation.js"></script>
</body>
</html>
