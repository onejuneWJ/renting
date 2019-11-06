$(document).ready(function () {
    $("input[name='phone']").blur(function () {
        checkPhone($(this));
    });
    $("input[name='username']").blur(function () {
        checkUsername($(this));
    });
    $("input[name='password']").blur(function () {
        checkPassword($(this));
    });
    $("input[name='confirmpassword']").blur(function () {
        checkConfirmPassword($(this));
    });
    //提交表单
    $("#btn_phonenum").click(function () {
        var phone = $("input[name='phone']");
        var username = $("input[name='username']");
        var password = $("input[name='password']");
        var confirmPassword = $("input[name='confirmpassword']");

        if (!checkPhone(phone)) {
            phone.focus();
            return false;
        }
        if (!checkUsername(username)) {
            username.focus();
            return false;
        }
        if (!checkPassword(password)) {
            password.focus();
            return false;
        }
        if (!checkConfirmPassword(confirmPassword)) {
            confirmPassword.focus();
            return false;
        }

        var formData = new FormData();
        formData.append('phone', phone.val());
        formData.append('username', username.val());
        formData.append('password', password.val());
        for (var i of formData.entries()) {
            console.log(i[0] + ":" + i[1]);
        }
        var data = {};
        formData.forEach((value, key) => {
            data[key] = value
        });
        $.ajax({
            url: "http://localhost:8080/renting/user/register",
            type: "POST",
            data: JSON.stringify(data),
            contentType: "application/json",
            success: function (data) {
                if (data === "success") {
                    location.href = "user_login.html";
                } else {
                    alert(data);
                }
            },
            error: function () {
                alert("请求错误");
            }
        });


    });

});

function checkPhone(p) {
    var mobile = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1})|(17[0-9]{1}))+\d{8})$/;
    var phone = p.val();
    if (phone.match(mobile)) {
        p.siblings('.msg').css({display: 'none'});
        var flag = true;
        //判断手机号是否已经注册
        /* $.get('localhost:8080/renting/user/cp/' + phone, function (data) {
             //如果已存在
             if (data.msg.exist) {
                 p.siblings('.msg').children('span').text('此手机号码已经被注册');
                 p.siblings('.msg').css({display: 'block'});
                 flag = false;
             }
         });*/
        return flag;
    } else {
        p.siblings('.msg').children('span').text('请输入正确的手机号码');
        p.siblings('.msg').css({display: 'block'});
        return false;
    }
}

function checkUsername(u) {
    var _username = /^[a-zA-Z0-9_-]{4,16}$/;
    var username = u.val();
    if (username.match(_username)) {
        u.siblings('.msg').css({display: 'none'});
        //判断用户名是否已经存在
        var flag = true;
        /*$.get('localhost:8080/renting/user/cu/' + username, function (data) {
            if (data.msg.exist) {
                u.siblings('.msg').children('span').text('用户名已存在');
                u.siblings('.msg').css({display: 'block'});
                flag = false;
            }
        });*/
        return flag;
    } else {
        u.siblings('.msg').children('span').text('用户名长度4~16位，可包含大小写字母数字_-');
        u.siblings('.msg').css({display: 'block'});
        return false;
    }
}

function checkPassword(p) {
    var pass = /^[a-zA-Z]\w{5,17}$/;
    var password = p.val();
    if (password.match(pass)) {
        p.siblings('.msg').css({display: 'none'});
        return true;
    } else {
        p.siblings('.msg').children('span').text('密码必须以字母开头，长度在6~18之间，只能包含字母、数字和下划线');
        p.siblings('.msg').css({display: 'block'});
        return false;
    }
}

function checkConfirmPassword(p) {

    var password = $("input[name='password']").val();
    var confirmPassword = p.val();
    if (confirmPassword == "") {
        p.siblings('.msg').css({display: 'block'});
        return false
    } else if (password != confirmPassword) {
        p.siblings('.msg').children('span').text('两次密码输入不一致');
        p.siblings('.msg').css({display: 'block'});
        return false
    } else {
        p.siblings('.msg').css({display: 'none'});
        return true;
    }
}