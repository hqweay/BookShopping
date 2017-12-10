<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
  <!DOCTYPE html>
  <html lang="en">

 <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>首页</title>
    <link href="css/index.css" rel="stylesheet" type="text/css" />
    
 </head>

 <body>
    
      <!--  include header -->
    <%@ include file="layout/header.jsp" %>
      <!--  include search -->
      <%@ include file="layout/search.jsp" %>

        <div class="main-promote clear-float">
          <div class="book-type col-2">
           <c:forEach items="${bookList}" var = "e" >
                <div class="book-type-name"><a href = "#">${e.bookClass}</a></div>
           </c:forEach>  
          </div>
          <div class="col-6">
            <div class="slider">
              <img src="image-web/000.png" alt="主导航" />
            </div>
            <div class="sub-slider col-5">
              <img src="image-web/001.png" alt="次导航" />
            </div>
            <div class="sub-slider col-5">
              <img src="image-web/002.png" alt="次导航" />
            </div>
          </div>
          <div class="intro col-2">
             <a href = "#"><span class="anno" id = "Customer_name" >
                             欢迎,${Customer.name}
             </span>
             </a>
            <div class="intro">
              介绍一段话
            </div>
          </div>
        </div>
     <!-- show image  -->
        <div class="cat-promote clear-float">
          <div class="cat-book-type">
            <div class="cat-book-type-name">
                                分类名
            </div>
            <br>
              <div class="cat-book-type-book" id = "name">
                <c:forEach items="${bookList}" var = "e" >
                <div style = "width:1075px; height:230px; border:1px solid red;" >
                   <div style = "width:1075px; height:20px; border:1px solid red;">
                      <a href = "#" >${e.bookClass}</a>
                      <a href = "${e.id}.do" style = "float:right">>>更多</a>
                   </div>
                   <!-- map每个元素  key:e.bookClassParam(数据库中类型的英文参数)  value: List<book>对象   -->
                    <c:forEach items="${map[e.bookClassParam]}" var = "b" >
                      <div style ="float:left; padding-left:20px; padding-top:10px">
                      <a href = "#"><img src = "${b.url}"></a>
                      <span>作者 ：${b.author}</span><br>
                      <span>￥ ${b.price}</span>
                     </div>
                    </c:forEach>
                     
                </div><br/>
              </c:forEach>
            </div>
          </div>
        </div>


        <!--  include footer -->
        <%@ include file="layout/footer.jsp" %>
  </body>

<script type="text/javascript">
      if(String.trim(document.getElementById("Customer_name").innerHTML)=="欢迎,"){
    	  document.getElementById("Customer_name").innerHTML = "未登录，请登陆";
      }
</script>
  </html>
