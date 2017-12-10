<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2017/12/3
  Time: 16:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<form class="container" action="Login"  method="post">
    <div class="input-group">
        <span class="input-group-addon">用户名</span>
        <input type="text" class="form-control" name="name" placeholder="输入管理员账号">
    </div>
    <div class="input-group">
        <span class="input-group-addon">手机号</span>
        <input type="text" class="form-control" name="password" placeholder="输入管理员密码">
    </div>

    <div class="submit">
        <button type="submit" class="btn btn-default" id="submit">登录</button>
        <span id="error" color = "red">${errorMsg}</span>
    </div>
</form>
