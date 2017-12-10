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
<form action="login" id="register" method="post">
    <div class="id-pass">
        <input type="text" name="userName" id="userName" placeholder="在这输入你的用户名" value = "${userName}"/>
    </div>
    <div class="id-pass">
        <input type="password" name="password" id="password" placeholder="输入你的密码" value = "${password}"><br/>
        <span color = "red">${errorMsg}</span>
    </div>

    <div class="id-pass">
        <input type="submit" value="登陆" id="submit">
    </div>
</form>

<%@include file="layout/footer.jsp"%>
</body>

</html>
