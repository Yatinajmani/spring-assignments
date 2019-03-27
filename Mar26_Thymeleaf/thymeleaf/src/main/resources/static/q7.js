$(function () {
    $("#getTime").click(function () {
        $.ajax({
            url: "/getTime",
            method: "GET"
        }).done(function (data) {
            if (data) {
                $("#time").html(data).css("color","green");
            }
        }).fail(function (error) {
            $("#time").html(error).css("color","red");
        })
    });
});
