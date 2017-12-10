<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style type="text/css">
    .container div{
        display: inline-block;
    }
</style>
<div class="container">
    <c:forEach items = "${books}" var = "e">
        <div class="input-group">
            <img src="../${e.url}"  />
        </div>
    </c:forEach>
</div>
