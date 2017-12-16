$(".book-type").hover(function () {
    $(this).parent().siblings().children("a").css("background", "white");
    $(this).css("background-color", "#c4c3cb");
});


    $(".book-type").click(function () {

        var className = $(this).attr('href');


        //$(".book > ." + className).hide();
        if($(".info > ." + className).length == 0){
            $(".info > *").hide();
        }else{

            //$(".info > ." + className).siblings().hide();
            $(".info > *").hide();
            $(".info > ." + className).show();
        }

       // $(this).parent().siblings().children("a").css("background", "white");
        //$(this).css("background-color", "red");


        return false;
    });

