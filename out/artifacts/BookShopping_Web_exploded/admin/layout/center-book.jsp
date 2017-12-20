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

    img {
        width: 155px;
    }

</style>


<div class="container">
    <div class="navi">
        <ul class="nav nav-tabs">
            <li role="presentation" class="active"><a href="所有图书" class="book-type">所有图书</a></li>
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
                        <img src="../${b.url}" alt="显示不出来" id="${b.id}" class="${e.key} 所有图书"/>
                    </div>

                </div>

            </c:forEach>
        </c:forEach>
        <img src="../image-web/add.png" alt="显示不出来" id="add-book-img"/>

    </div>
    <form class="container" action="bookSet" method="post" style="display: none;" id="add-book-form">
        <div class="input-group">
            <span class="input-group-addon" >书名</span>
            <input type="text" class="form-control" placeholder="请录入书名" id="name">
        </div>
        <div class="input-group">
            <span class="input-group-addon" >作者</span>
            <input type="text" class="form-control" placeholder="请录入作者" id="author">
        </div>
        <div class="input-group">
            <span class="input-group-addon" >类别</span>
            <input type="text" class="form-control" placeholder="请录入类别" id="type">
        </div>
        <div class="input-group">
            <span class="input-group-addon" >描述</span>
            <input type="text" class="form-control" placeholder="请录入描述" id="describe">
        </div>
        <div class="input-group">
            <span class="input-group-addon" >价格</span>
            <input type="text" class="form-control" placeholder="请录入价格" id="price">
        </div>
        <div class="input-group">
            <span class="input-group-addon" >折扣</span>
            <input type="text" class="form-control" placeholder="请录入折扣" id="discount">
        </div>
        <div class="input-group">
            <span class="input-group-addon" >数量</span>
            <input type="text" class="form-control" placeholder="请录入数量" id="quantity">
        </div>
        <div class="input-group">
            <span class="input-group-addon" >封面</span>
            <input type="text" class="form-control" placeholder="请录入封面 这里是不是上传封面好些哦" id="img">
        </div>


        <div class="submit">
            <button type="button" class="btn btn-default" onclick="addBook()">确定录入书籍信息</button>
        </div>
    </form>
    <form action="" class="container" id="set-book-form" style="display: none">
        <div class="input-group">
            <span class="input-group-addon" >书名</span>
            <input type="text" class="form-control" placeholder="" id="name-set">
        </div>
        <div class="input-group">
            <span class="input-group-addon" >作者</span>
            <input type="text" class="form-control" placeholder="" id="author-set">
        </div>
        <div class="input-group">
            <span class="input-group-addon" >类别</span>
            <input type="text" class="form-control" placeholder="" id="type-set">
        </div>
        <div class="input-group">
            <span class="input-group-addon" >描述</span>
            <input type="text" class="form-control" placeholder="" id="describe-set">
        </div>
        <div class="input-group">
            <span class="input-group-addon" >价格</span>
            <input type="text" class="form-control" placeholder="" id="price-set">
        </div>
        <div class="input-group">
            <span class="input-group-addon" >折扣</span>
            <input type="text" class="form-control" placeholder="" id="discount-set">
        </div>
        <div class="input-group">
            <span class="input-group-addon" >数量</span>
            <input type="text" class="form-control" placeholder="" id="quantity-set">
        </div>
        <div class="input-group">
            <span class="input-group-addon" >封面</span>
            <input type="text" class="form-control" placeholder="" id="img-set">
        </div>


        <div class="submit">
            <button type="button" class="btn btn-default" id="button-set">确认更改</button>
        </div>
    </form>
</div>

