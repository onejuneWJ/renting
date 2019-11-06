$(document).ready(function () {
    //点击登录按钮
    $("input.login-submit").click(function () {
        if (checkLoginName() && checkPassword() && checkVerifyCode()) {
            var formData = new FormData($("#form_")[0]);
            //验证登录
            /*$.ajax({
                url:'',
                type:'POST',
                data:formData,
                success:function (result) {

                }
            });*/
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
    if ($("input[name='verifyCode']").val() == "") {
        $(".e_verify").html('请输入图形验证码');
        return false;
    } else {
        $(".e_verify").html('');
        return true;
    }
}