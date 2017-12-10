<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2017/12/3
  Time: 17:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

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
