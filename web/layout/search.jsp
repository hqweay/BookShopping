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
        <form method = "post" action = "search">
         <div class="search-bar">
           <select style = ""  id="usertype" name="method" class="selectpicker show-tick form-control" >
                                        <option value="byAuthor">根据作者</option>
                                        <option value="byBookName">更具书名</option>
                                        
           </select>
          <input type="text" name = "searchParam"/>
          <input type = "submit" id = "submit" >
        </div>
        </form>
        <div class="my-cart">
            <a href = "javascript:void(0)" onclick = "checkSession()"> 我的购物车</a>
        </div>
      </div>
    </body>

  </html>
