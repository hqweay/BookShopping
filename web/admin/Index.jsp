<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2017/12/3
  Time: 17:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>老夫子后台管理</title>
    <link rel="stylesheet" href="../bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="../css/admin/css.css">
</head>
<body>



<%@include file="layout/top.jsp"%>
<%@include file="layout/left.jsp"%>
<jsp:include page="${type}" />
<%@include file="layout/footer.jsp"%>


<script src="../js/jquery-3.2.1.js"></script>
<script src="../bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script src="../js/menu.js"></script>
<script src="../js/operation.js"></script>
<script src="../js/menu-admin-book.js"></script>
</body>
</html>
