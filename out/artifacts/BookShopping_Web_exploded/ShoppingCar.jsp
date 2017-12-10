<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
   <link rel = "stylesheet" type = "text/css" href = "css/css.css"/>
   <link rel = "stylesheet" type = "text/css" href = "css/car.css"/>
</head>
<body>
            <!--include header.jsp -->
    <%@include file = "layout/header.jsp" %>
    <div id = "main" align = "center" >
        <div id = "logo" >
          <img src = "image-web/car.jpg"/>
        </div>
        <span id = "span" >购物车</span>
         <!-- 消除浮动影响 -->
         <div id ="text"></div>
        <div id = "content" >
          	<table class="table">
						<tr class="table_header">
							<td>
								商品
							</td>
							
							<td>
								价格
							</td>
							<td>
								数量
							</td>
                            <td>
                                                                              收货地址  
                            </td>
                                
							<td>
								操作
							</td>
						</tr>
					     
			<c:forEach items="${Books}" var = "e" varStatus = "s">
            <tr class="row=${s.index%2+1}">
              <td>
                 ${e.name}
              </td>
              <td>
                ${e.price}
              </td>
              <td>
                ${e.quantity}
              </td>
              <td>
               
              </td>
              <td>
                <a href="#" 
                onclick="return confirm('是否确定删除${e.name}');">删除</a>
                &nbsp;<a href="#">修改</a>
              </td>
            </tr> 
            </c:forEach>  	
						
					</table>
        </div>
       
    </div>
    <!-- include footer.jsp -->
    <%@include file = "layout/footer.jsp" %>
</body>
</html>