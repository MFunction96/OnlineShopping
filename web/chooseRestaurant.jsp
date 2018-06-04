
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



    <section class="jumbotron text-center">
        <div class="container">
            <h1 class="jumbotron-heading">OnlineShopping</h1>
            <p class="lead text-muted">下面是搜索栏（摆设）+搜索键（摆设）view+edit button跳转食品界面</p>
            <form >
                <div class="row">
                    <div class="col-md-10">
                        <input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search">
                    </div>
                    <div class="col-md-1">
                        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
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
                                <img class="card-img-top" data-src="holder.js/100px225?theme=thumb&amp;bg=55595c&amp;fg=eceeef&amp;text=Thumbnail" alt="Thumbnail [100%x225]" style="height: 225px; width: 100%; display: block;" src="data:image/svg+xml;charset=UTF-8,%3Csvg%20width%3D%22208%22%20height%3D%22225%22%20xmlns%3D%22http%3A%2F%2Fwww.w3.org%2F2000%2Fsvg%22%20viewBox%3D%220%200%20208%20225%22%20preserveAspectRatio%3D%22none%22%3E%3Cdefs%3E%3Cstyle%20type%3D%22text%2Fcss%22%3E%23holder_163be1c92ec%20text%20%7B%20fill%3A%23eceeef%3Bfont-weight%3Abold%3Bfont-family%3AArial%2C%20Helvetica%2C%20Open%20Sans%2C%20sans-serif%2C%20monospace%3Bfont-size%3A11pt%20%7D%20%3C%2Fstyle%3E%3C%2Fdefs%3E%3Cg%20id%3D%22holder_163be1c92ec%22%3E%3Crect%20width%3D%22208%22%20height%3D%22225%22%20fill%3D%22%2355595c%22%3E%3C%2Frect%3E%3Cg%3E%3Ctext%20x%3D%2266.9296875%22%20y%3D%22117.3%22%3EThumbnail%3C%2Ftext%3E%3C%2Fg%3E%3C%2Fg%3E%3C%2Fsvg%3E" data-holder-rendered="true">
                                <div class="card-body">
                                    <p class="card-text">${store.getStName()}</p>
                                    <input type="hidden" name="stid" id="stid" value="${store.getStId()}">
                                    <input type="hidden" name="stname" id="stname" value="${store.getStName()}">
                                    <input type="hidden" name="stimg" id="stimg" value="${store.getStImage()}">
                                    <input type="hidden" name="stdesc" id="stdesc" value="${store.getStDesc()}">
                                    <div class="d-flex justify-content-between align-items-center">
                                        <div class="btn-group">
                                            <input type=submit class="btn btn-sm btn-outline-secondary" value="看菜" ></input>
                                            <button type="button" class="btn btn-sm btn-outline-secondary "onclick="window.location.href='/chooseFood?stid=${store.getStId()}'">suini</button>
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
