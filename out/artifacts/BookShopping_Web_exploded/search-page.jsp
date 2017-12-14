<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="ch">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>这里也动态显示搜索的书名</title>

  <style type="text/css">
  .clear-float:after, .clear-float:before {
    display: block;
    content: " ";
    clear: both;
  }
    .search-page {
      width: 1080px;
    }

    .search-page li {
      display: block;
    }
    .book{
      margin-top: 25px;
    }

    .search-page img {
      float: left;

      width: 150px;
    }

    .info {
      float: left;
      margin-left: 20px;
      width: 50%;

    }

    .name {
      font-size: 30px;
      margin-top: auto;
      margin-bottom: 0px;
    }

    .writer {
      margin-top: 0px;
    }

    .writer,
    .price {
      display: inline;
    }

    .price {
      font-size: 30px;
    }

    input {
      border-radius: 3px;
      border: none;
      background-color: #00a0daa8;
      height: 30px;
      width: 120px;
    }

    input:hover {
      background-color: #00a0da;
    }
  </style>
</head>

<body>
  <%@include file="layout/header.jsp"%>
  <div class="search-page">
    <ul>
      <li class="book clear-float">
        <img src="image/English3.jpg" alt="error">
        <div class="info">
          <p class="name">爱的供养</p>
          <p class="writer">
            <a href="#">波波老师</a> 著 |
          </p>
          定价 :
          <p class="price"> ¥74.10</p>
          <p class="description">
            幽默，是一种生活态度 献给绘本界的喜剧之王 此时，我很激动。形成的绘本领域也是。 就现在的童书市场领域来看，优秀
          </p>
          <p>
            <input type="button" value="加入购物车">
          </p>
        </div>
      </li>
      <li class="book">
        <img src="image/English3.jpg" alt="error">
        <div class="info">
          <p class="name">爱的供养</p>
          <p class="writer">
            <a href="#">波波老师</a> 著 |
          </p>
          定价 :
          <p class="price"> ¥74.10</p>
          <p class="description">
            幽默，是一种生活态度 献给绘本界的喜剧之王 此时，我很激动。形成的绘本领域也是。 就现在的童书市场领域来看，优秀
          </p>
          <p>
            <input type="button" value="加入购物车">
          </p>
        </div>
      </li>

    </ul>
  </div>
<div class="clear-float">
    <%@include file="layout/footer.jsp"%>
</div>

</body>

</html>
