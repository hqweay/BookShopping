$(".book-type").hover(function () {
    $(this).parent().siblings().children("a").css("background", "white");
    $(this).css("background-color", "#c4c3cb");
});


    $(".book-type").click(function () {
        var className = $(this).attr('href');
        if($(".info > ." + className).length == 0){
            $(".info > *").hide();
        }else{

            //$(".info > ." + className).siblings().hide();
            $(".info > *").hide();
            $(".info > ." + className).show();
        }
        $("#add-book-img").show();
        $("#add-book-form").hide();
        $("#set-book-form").hide();
        return false;
    });
//img的点击事件需要用bind绑定
$("#add-book-img").bind("click", function () {
    $(".info > *").hide();
    $("#add-book-img").hide();
    $("#add-book-form").show();
});

$(".books > .book > .info > img").bind("click", function () {
    $(".info > *").hide();
    $("#add-book-img").hide();
    $("#set-book-form").show();
    //获得点击书（图片）的的id（唯一）
    var $id = this.id;
    //使用ajax获得该id的书的各种信息
    $.ajax({
        url:"/book/get",
        type:"post",
        data:{"id":$id},
        success:function(result){


            $("#name-set").attr("value", result.name);
            $("#author-set").attr("value", result.author);
            $("#type-set").attr("value", result.type);
            $("#describe-set").attr("value", result.describe);
            $("#price-set").attr("value", result.price);
            $("#quantity-set").attr("value", result.quantity);
            $("#img-set").attr("value", result.img);
            $("#discount-set").attr("value", result.discount);
        }
    });
})

$("#button-set").click(function () {
    var name = document.getElementById("name-set").value;
    var author = document.getElementById("author-set").value;
    var type = document.getElementById("type-set").value;
    var price = document.getElementById("price-set").value;
    var discount = document.getElementById("discount-set").value;
    var describe = document.getElementById("describe-set").value;
    var img = document.getElementById("img-set").value;
    var quantity = document.getElementById("quantity-set").value;
    $.ajax({
        url:"/book/set",
        type:"post",
        data:{"name":name, "author":author, "type":type, "price":price, "discount":discount, "describe":describe
            , "img":img, "quantity":quantity},
        success:function(result){
            if(result.errorMsg){
                alert(result.errorMsg);
                return;
            }else{
                alert(result.successMsg);
                window.location.href = "/test/book";
            }
        }
    });
});