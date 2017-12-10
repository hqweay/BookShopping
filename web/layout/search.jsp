<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
  <html>
    <head>
      <link href="css/search.css" rel="stylesheet" type="text/css" />
      <script>
      	function checkSession(){
      		 
            <%if(session.getAttribute("Customer") == null){ %>
             	alert("请登录");
             	window.location.href="index";
             	
             <%}else{%>window.location.href="cart";<%}%>
             
             
             
      	}
      </script>
    </head>

    <body>
      <div class="search">
        <div class="logo">
          老夫子
        </div>
        <div class="search-bar">
          <input type="text"/>
          <button>搜索</button>
        </div>
        <div class="my-cart">
            <a href = "javascript:void(0)" onclick = "checkSession()"> 我的购物车</a>
        </div>
      </div>
    </body>

  </html>
