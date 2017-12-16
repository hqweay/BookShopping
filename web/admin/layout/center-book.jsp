<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style type="text/css">

    .container .books div {
        display: inline-block;
    }

    .book {
        margin-top: 25px;
    }

</style>


<div class="container">
    <div class="navi">
        <ul class="nav nav-tabs">
            <li role="presentation" class="active"><a href="所有图书" class="book-type" >所有图书</a></li>
            <c:forEach items="${booksMap}" var="e">
                <li role="presentation" class="active"><a href="${e.key}" class="book-type">${e.key}</a></li>
            </c:forEach>
        </ul>
    </div>
    <div class="books">
        <c:forEach items="${booksMap}" var="e">
            <c:forEach items="${booksMap[e.key]}" var="b">
                <div class="book">
                    <div class="info">
                        <img src="../${b.url}" alt="显示不出来" class="${e.key} 所有图书"/>
                    </div>
                    <div class="edit" style="display: none;">
                        <p>书名</p>
                        <p>作者</p>
                        <p>价格</p>
                        <p>折扣</p>
                        <p>类别</p>
                        <p>描述</p>
                        <p>数量</p>
                        <p>类别</p>  ----》怎么输入  输入名字 若无 增加该类别
                        <p>封面</p>   ----》这里写上传图片
                    </div>
                </div>

            </c:forEach>
        </c:forEach>
    </div>
</div>


