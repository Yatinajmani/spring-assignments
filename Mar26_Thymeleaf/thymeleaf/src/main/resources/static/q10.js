$(function () {
    $("#loader").hide();
    $("#register").submit(function (e) {
        e.preventDefault();
        $("#loader").show();
        $("#register").hide();
        setTimeout(function () {
            $.ajax({
                url: "/register",
                method: "POST",
                data: $("#register").serialize()
            }).done(function (data) {
                $("#loader").hide();
                if (data) {
                    $("#data").html(data).css("color", "green");
                }
            }).fail(function (error) {
                $("#register").show();
                $("#loader").hide();
                $("#data").html(error).css("color", "red");
            })
        }, 3000);
    });
});
