<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>后台管理</title>

    <link rel="stylesheet" href="../bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="../css/admin/css.css">
</head>

<body>
<div class="page-header header clear-float">
    <div class="welcome col-8">

        <h1>老夫子后台管理</h1>
    </div>
    <div class="manager">
        <h1>管理员</h1>
    </div>
</div>
<div class="page">
    <div class="menu">
        <ul  class="nav nav-pills nav-stacked">
            <li class = "first-li" class="active"><a href="#">管理员信息</a></li>
            <li class = "first-li"><a href="#">用户管理</a>
                <ul class="nav nav-pills nav-stacked">
                    <li><a href="#">用户添加</a></li>
                    <li><a href="#">用户删除</a></li>
                    <li><a href="#">用户修改</a></li>
                </ul>
            </li>
            <li class = "first-li"><a href="#">书籍信息</a>
                <ul class="nav nav-pills nav-stacked">
                    <li><a href="#">书籍种类</a></li>
                    <li><a href="#">书籍</a></li>
                </ul>
            </li>
        </ul>
    </div>

    <form class="container" action="/admin/managerSet"  method="post">
        <div class="input-group">
            <span class="input-group-addon">用户名</span>
            <input type="text" name="name" class="form-control" placeholder="输入您想更改的用户名">
            <span class="input-group-btn">
        <button class="btn btn-default" type="submit">更新</button>
      </span>
        </div>

        <div class="input-group">
            <span class="input-group-addon">密码</span>
            <input type="text" name="password" class="form-control" placeholder="输入您想更改的密码">
            <span class="input-group-btn">
        <button class="btn btn-default" type="submit">更新</button>
      </span>
        </div>
        <div class="submit">
            <button type="submit" class="btn btn-default">全部更新</button>
        </div>
        <span color="red">
            ${errorMsg}
        </span>
    </form>

</div>


<div class="d">
    <c:forEach items="${customers}" var = "e" >
        <a href = "${e.id}.jsp" style = "float:right">${e.name}</a>
    </c:forEach>
</div>
<script src="../js/jquery-3.2.1.js"></script>
<script src="../bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script src="../js/menu.js"></script>
</body>

</html>
