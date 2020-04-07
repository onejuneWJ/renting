$(document).ready(function () {
    //点击登录按钮
    $("input.login-submit").click(function () {
        if (checkLoginName() && checkPassword() && checkVerifyCode()) {
            var account = $("input[name='loginName']").val();
            var password = $("input[name='password']").val();
            //验证登录
            $.ajax({
                url: 'http://localhost:8080/renting/admin/login',
                type: 'POST',
                data: JSON.stringify({account: account, password: password}),
                contentType: "application/json",
                success: function (res) {
                    if (res.msg === "success") {
                        location.href = "http://localhost:8080/renting/admin/index"
                    } else {
                        console.log("sss");
                        $(".e_error").html(res.msg);
                    }
                }
            });
        }
    });
});

function checkLoginName() {
    if ($("input[name='loginName']").val() == "") {
        $(".e_username").html('请输入用户名');
        return false;
    } else {
        $(".e_username").html('');
        return true;
    }
}

function checkPassword() {
    if ($("input[name='password']").val() == "") {
        $(".e_password").html('请输入密码');
        return false;
    } else {
        $(".e_password").html('');
        return true;
    }
}

function checkVerifyCode() {
    var code = $("input[name='verifyCode']").val();
    var flag = false;
    if (code === "") {
        $(".e_verify").html('请输入图形验证码');
        flag = false;
    } else {
        $.ajax({
            async: false,
            url: "http://localhost:8080/renting/admin/checkVerifyCode?code=" + code,
            type: "get",
            success: function (res) {
                if (res.msg === "success") {
                    $(".e_verify").html('');
                    flag = true;
                } else {
                    $(".e_verify").html('验证码输入错误');
                    changeCode();
                    flag = false;
                }
            }
        });
    }
    return flag;
}