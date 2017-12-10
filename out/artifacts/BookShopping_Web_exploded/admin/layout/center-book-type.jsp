<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form  class="container" action="customerSet"  method="post">
      <c:forEach items = "${bookTypes}" var = "e">
          <div class="input-group">
        <span class="input-group-addon">书类</span>
        <input type="text" class="form-control" value="${e.bookClass}" id = "${e.id}">
        <span class="input-group-btn">
        <button class="btn btn-default" type="button" onclick = "bookTypeModify(this)">修改</button>
        <button class="btn btn-default" type="button" onclick = "deleteBookType(this)">删除</button>
        </span>
      </div>
      </c:forEach>
      
      <div class="input-group">
        <span class="input-group-addon">书类</span>
        <input type="text" class="form-control" placeholder="输入您想增加的书类" id = "add">
        <span class="input-group-btn">
        <button class="btn btn-default" type="button" onclick="addBookType()">增加</button>
      </span>
      </div>
     

    </form>