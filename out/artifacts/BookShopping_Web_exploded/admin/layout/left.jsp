<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2017/12/3
  Time: 16:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="menu">
    <ul  class="nav nav-pills nav-stacked">
        <li class = "first-li" class="active">
            <a href="#">管理员信息</a>
            <ul class="nav nav-pills nav-stacked">
                <li><a href="/test/manager">更新</a></li>

            </ul>
        </li>
        <li class = "first-li"><a href="#">用户管理</a>
            <ul class="nav nav-pills nav-stacked">
                <li><a href="/test/user">用户添加</a></li>
                <li><a href="#">用户删除</a></li>
                <li><a href="#">用户修改</a></li>
            </ul>
        </li>
        <li class = "first-li"><a href="#">书籍信息</a>
            <ul class="nav nav-pills nav-stacked">
                <li><a href="/test/book-type">书籍种类</a></li>
                <li><a href="/test/book">书籍管理</a></li>
            </ul>
        </li>
        <li class = "first-li"><a href="#">网站图片管理</a>
            <ul class="nav nav-pills nav-stacked">
                <li><a href="/test/img-book">首页布局</a></li>
                <li><a href="/test/img-book-type">书籍种类封面</a></li>
                <li><a href="/test/img-book">书籍封面</a></li>
            </ul>
        </li>
    </ul>
</div>

