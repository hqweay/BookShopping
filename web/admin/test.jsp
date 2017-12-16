<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style type="text/css">

    .container .book div{
        display: inline-block;
    }
    .book{
        margin-top: 25px;
    }
</style>

<div class="container">
    <div class="navi">
        <ul class="nav nav-pills">
            <li role="presentation" class="active"><a href="#">分类一</a></li>
            <li role="presentation"><a href="#">分类二</a></li>
            <li role="presentation"><a href="#">分类三</a></li>
        </ul>
    </div>
    <!--   <div class="book">
        <c:forEach items = "${books}" var = "e">
            <div class="input-group">
                <img src="../${e.url}"  />
            </div>
        </c:forEach>
    </div>
-->
    <div class="book">
        <c:forEach items = "${books}" var = "e">
            <div class="input-group">
                    ${e.bookClass.id}
            </div>
        </c:forEach>
    </div>

</div>
