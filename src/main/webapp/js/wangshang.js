$(function () {
    $("#cls").click(function () {
        $("#name").val("");
        $("#segment").val("");
        $("#phone").val("");
    });
    $("#sbmit").click(function () {
        if (validation() === false) {
            return;
        }
        var entainment = $("input[name='entainment']:checked").val();
        $("#sbmit").attr("disabled", true);
        $.ajax({
            url: "/submit/submits.action",
            type: "post",
            dataType: "json",
            data: {
                name: $("#name").val(),
                segment: $("#segment").val(),
                entainment: entainment,
                phone: $("#phone").val()
            },
            success: function (result) {
                $("#name").val("");
                $("#segment").val("");
                $("#phone").val("");
                $("#content").empty();
                $("#content").append("<br><br><br><center style='font-family: 楷体;font-size: 28px'>" + result.data.retMsg + "</center>");
            }
        });
    })
});
function validation() {
    var flag = true;
    var name = $("#name").val();
    if (isBlank(name)) {
        flag = false;
        $("#nameSpan").css("color", "red");
        $("#nameSpan").text("*姓名不能为空");

    }
    var segment = $("#segment").val();
    if (isBlank(segment)) {
        flag = false;
        $("#segSpan").css("color", "red");
        $("#segSpan").text("*班级不能为空");
    }
    var phone = $("#phone").val();
    var reg = /^1\d{10}$/;
    if (!reg.test(phone)) {
        flag = false;
        $("#phoneSpan").css("color", "red");
        $("#phoneSpan").text("*手机号码格式不正确");
    }
    return flag;
}

function isBlank(elemnt) {
    if ((elemnt == "") || (elemnt == null)) {
        return true;
    }
    return false;
}