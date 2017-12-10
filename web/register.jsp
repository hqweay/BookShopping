<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="ch">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link rel="stylesheet" href="css/regis-login.css">

</head>

<body>
<!--include header.jsp -->
<%@include file="layout/header.jsp"%>
<div class="header">
    <span id="imageHeader">
      ddd
    </span>
</div>
<form action="register" id="register" method="post">
    <div class="id-pass">
        <input type="text" name="userName" id="userName" placeholder="在这输入你的用户名"/>
    </div>
    <div class="id-pass">
        <input type="password" name="phoneNum" id="phoneNum" placeholder="输入你的手机号">
    </div>
    <div class="id-pass">
        <input type="password" name="password" id="password" placeholder="输入你的密码">
    </div>
    <div class="id-pass">
        <input type="submit" value="注册" id="submit">
    </div>
</form>
<%@include file="layout/footer.jsp"%>
</body>

</html>
