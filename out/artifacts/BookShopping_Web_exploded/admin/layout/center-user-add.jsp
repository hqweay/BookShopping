<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">
      <div  id = "seach-navigater">
        <label>
            <input class="radio radio-inline" type="radio" name="optionsRadios" id="optionsRadios1" 
               value="byName" checked>根据用户名
        </label>
      
          <label>
             <input class="radio radio-inline" type="radio" name="optionsRadios" id="optionsRadios2" 
                value="byNum">
                                       根据电话 
          </label>
      </div >
     <input id = "search" type="text" class="form-control"  value = "111">
   <div id = "customer-table">
  <table class="table table-striped" id = "table">
   <br>
   <thead>
      <tr>
         <th>ID</th>
         <th>用户名</th>
         <th>电话</th>
         <th>地址</th>
      </tr>
   </thead>
   <tbody id = "tbody">
     <c:forEach items = "${customers}" var = "e">
          <tr >
         <td width = "7%"><span>${e.id}</span></td>
         <td width = "15%"><input type="text" class="form-control" value="${e.name}" ></td>
         <td><input type="text" class="form-control" value="${e.phoneNum}" ></td>
         <td><input type="text" class="form-control" value="${e.address}" ></td>
         <td>
            <button type="button" class="btn btn-default delete" >
                                       删除
            </button>
            <button type="button" class="btn btn-default modify" >
                                       修改
            </button>
         </td>
       </tr>
    </c:forEach>
   </tbody>
   </table> 
   <!-- 先自己简单实现一下   以后再系统学习 -->
    <button style = "float:right" type="button" class="btn btn-default" value = 1 id = "nextPage" onclick = "nextPage(this)">
                                       下一页
    </button>
    <button style = "float:right" type="button" class="btn btn-default" value = 1 id = "lastPage" onclick = "lastPage(this)">
                                       上一页
    </button >&nbsp;
     </div>
</div>
</body>
</html>