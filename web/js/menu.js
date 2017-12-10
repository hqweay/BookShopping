


$(".first-li > ul").hide();
$(".first-li > a").click(function () {
    $(this).addClass("current")
        .next().show()
        .parent().siblings().children("a").removeClass("current")
        .next().hide();
    return false;
});
