<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/user_info.css" type="text/css">


    <!-- 公共样式 开始 -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/base.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/iconfont.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/framework/jquery-1.11.3.min.js"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/layui/css/layui.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/layui/layui.js"></script>
    <!-- 滚动条插件 -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/jquery.mCustomScrollbar.css">
    <script src="${pageContext.request.contextPath}/framework/jquery-ui-1.10.4.min.js"></script>
    <script src="${pageContext.request.contextPath}/framework/jquery.mousewheel.min.js"></script>
    <script src="${pageContext.request.contextPath}/framework/jquery.mCustomScrollbar.min.js"></script>
    <script src="${pageContext.request.contextPath}/framework/cframe.js"></script><!-- 仅供所有子页面使用 -->
</head>
<body>
<div>

    <div class="layui-tab layui-tab-card" lay-filter="user_tab" id="user_tab" lay-allowClose="true">
        <ul class="layui-tab-title">
            <li class="layui-this">个人信息</li>
        </ul>
        <div class="layui-tab-content">
            <div class="layui-tab-item layui-show">
                <div class="profile">
                    <div class="profile-title">
                        <i class="iconfont"></i>
                        <span>基本账号资料</span>
                    </div>
                    <ul class="profile-list">
                        <li class="photo">
                            <span class="key">头像</span>
                            <img src="/upload/images/${sessionScope.CURRENT_USER.avatar}"/>
                            <button type="button" id="avatarBtn" class="operate-btn">修改</button>
                        </li>
                        <li class="username">
                            <span class="key">用户名</span>
                            <span class="value">${sessionScope.CURRENT_USER.username}</span>
                        </li>
                        <li class="nickname">
                            <span class="key">昵称</span>
                            <span class="value">${sessionScope.CURRENT_USER.nickname}</span>
                            <div class="layui-input-inline" style="display: none">
                                <input id="nickname" class="layui-input" name="nickname" type="text">
                            </div>
                            <button type="button" class="operate-btn update-btn">修改</button>
                            <div class="layui-btn-group btn-group" style="display: none;margin-left: 225px">
                                <a type="button" class="layui-btn save">保存</a>
                                <a type="button" class="layui-btn cancel">取消</a>
                            </div>
                        </li>
                        <li class="email">
                            <span class="key">邮箱</span>
                            <span class="value">${sessionScope.CURRENT_USER.email}</span>
                            <div class="layui-input-inline" style="display: none">
                                <input class="layui-input" lay-verify="email" name="email" type="text">
                            </div>
                            <c:if test="${sessionScope.CURRENT_USER.email==null}">
                                <button type="button" class="operate-btn" id="updateEmailBtn">绑定</button>
                            </c:if>
                            <c:if test="${sessionScope.CURRENT_USER.email!=null}">
                                <button type="button" class="operate-btn" id="updateEmailBtn">修改</button>
                            </c:if>
                        </li>
                        <li class="phone">
                            <span class="key">手机</span>
                            <span class="value">${sessionScope.CURRENT_USER.phone}</span>
                            <div class="layui-input-inline" style="display: none">
                                <input class="layui-input" lay-verify="phone" name="phone" type="text">
                            </div>
                            <button type="button" class="operate-btn" id="updatePhoneBtn">修改</button>

                        </li>
                    </ul>
                </div>

            </div>
        </div>
    </div>

</div>
<script>
    layui.use('element', function () {
        var $ = layui.jquery;
        var element = layui.element;
        $("#updateEmailBtn").on('click', function () {
            element.tabAdd('user_tab', {
                title: "绑定邮箱",
                content: "<div class=\"cBody\" style=\"width: 700px\">\n" +
                    "    <div class=\"layui-card\">\n" +
                    "        <div class=\"layui-card-body\">\n" +
                    "            <div class=\"layui-form-item\">\n" +
                    "                <div class=\"layui-inline\">\n" +
                    "                    <label class=\"layui-form-label\">当前邮箱</label>\n" +
                    "                    <div class=\"layui-input-inline\">\n" +
                    "                        <p>${sessionScope.CURRENT_USER.email}</p>\n" +
                    "                    </div>\n" +
                    "                </div>\n" +
                    "            </div>\n" +
                    "            <div class=\"layui-form-item\">\n" +
                    "                <div class=\"layui-inline\">\n" +
                    "                    <label class=\"layui-form-label\">新邮箱</label>\n" +
                    "                    <div class=\"layui-input-inline\">\n" +
                    "                        <input id='email' type=\"email\" name=\"email\" lay-verify=\"email\" placeholder=\"请输入新邮箱\"\n" +
                    "                               autocomplete=\"off\" class=\"layui-input\">\n" +
                    "                    </div>\n" +
                    "                </div>\n" +
                    "            </div>\n" +
                    "            <div class=\"layui-form-item\">\n" +
                    "                <div class=\"layui-inline\">\n" +
                    "                    <label class=\"layui-form-label\">验证码</label>\n" +
                    "                    <div class=\"layui-input-inline\">\n" +
                    "                        <input id='emailCode' type=\"text\" name=\"verifyCode\" lay-verify=\"verifyCode\" placeholder=\"请输入验证码\"\n" +
                    "                               autocomplete=\"off\" class=\"layui-input\">\n" +
                    "                    </div>\n" +
                    "                    <button onclick=\"getVerifyCode('E')\" class=\"layui-btn\">获取验证码</button>\n" +
                    "                </div>\n" +
                    "            </div>\n" +
                    "            <div class=\"layui-form-item\">\n" +
                    "                <div class=\"layui-input-block\">\n" +
                    "                    <button onclick='changeEmail()' class=\"layui-btn\" lay-filter=\"demo1\">确定</button>\n" +
                    "                    <button class=\"layui-btn layui-btn-primary\">取消</button>\n" +
                    "                </div>\n" +
                    "            </div>\n" +
                    "        </div>\n" +
                    "    </div>\n" +
                    "</div>",
                id: "change_email_tab"
            });
            element.tabChange("user_tab", "change_email_tab");
        });

        $("#updatePhoneBtn").on('click', function () {
            element.tabAdd('user_tab', {
                title: "绑定手机",
                content: "<div class=\"cBody\" style=\"width: 700px\">\n" +
                    "    <div class=\"layui-card\">\n" +
                    "        <div class=\"layui-card-body\">\n" +
                    "            <div class=\"layui-form-item\">\n" +
                    "                <div class=\"layui-inline\">\n" +
                    "                    <label class=\"layui-form-label\">当前手机号码</label>\n" +
                    "                    <div class=\"layui-input-inline\">\n" +
                    "                        <p>${sessionScope.CURRENT_USER.phone}</p>\n" +
                    "                    </div>\n" +
                    "                </div>\n" +
                    "            </div>\n" +
                    "            <div class=\"layui-form-item\">\n" +
                    "                <div class=\"layui-inline\">\n" +
                    "                    <label class=\"layui-form-label\">新手机</label>\n" +
                    "                    <div class=\"layui-input-inline\">\n" +
                    "                        <input id='phone' type=\"text\" name=\"phone\" lay-verify=\"phone\" placeholder=\"请输入新手机号码\"\n" +
                    "                               autocomplete=\"off\" class=\"layui-input\">\n" +
                    "                    </div>\n" +
                    "                </div>\n" +
                    "            </div>\n" +
                    "            <div class=\"layui-form-item\">\n" +
                    "                <div class=\"layui-inline\">\n" +
                    "                    <label class=\"layui-form-label\">验证码</label>\n" +
                    "                    <div class=\"layui-input-inline\">\n" +
                    "                        <input id='phoneCode' type=\"text\" name=\"verifyCode\" lay-verify=\"verifyCode\" placeholder=\"请输入验证码\"\n" +
                    "                               autocomplete=\"off\" class=\"layui-input\">\n" +
                    "                    </div>\n" +
                    "                    <button onclick=\"getVerifyCode('P')\" class=\"layui-btn\">获取验证码</button>\n" +
                    "                </div>\n" +
                    "            </div>\n" +
                    "            <div class=\"layui-form-item\">\n" +
                    "                <div class=\"layui-input-block\">\n" +
                    "                    <button onclick='changePhone()' class=\"layui-btn\" lay-filter=\"demo1\">确定</button>\n" +
                    "                    <button class=\"layui-btn layui-btn-primary\">取消</button>\n" +
                    "                </div>\n" +
                    "            </div>\n" +
                    "        </div>\n" +
                    "    </div>\n" +
                    "</div>",
                id: "change_email_tab"
            });
            element.tabChange("user_tab", "change_email_tab");
        });
    });

    layui.use(['layer', 'upload'], function () {
        var upload = layui.upload;
        var layer = layui.layer;
        var uploadInst = upload.render({
            elem: '#avatarBtn',
            url: '${pageContext.request.contextPath}/user/uploadAvatar',
            done: function (res) {
                if (res.msg === 'success') {
                    window.location.reload();
                }
            },
            error: function () {

            }
        });
    });

</script>
<script>

    var layer = layui.layer;
    $(document).ready(function () {
        $(".update-btn").click(function () {
            $(this).css({display: "none"});
            $(this).siblings(".value").css({display: "none"});
            $(this).siblings(".btn-group").css({display: "inline-block"});
            $(this).siblings(".layui-input-inline").css({display: "inline-block"}).addClass("value");

        });
        $(".save").click(function () {
            var nickname = $("#nickname").val();
            $.ajax({
                url: "http://localhost:8080/renting/user/changeNickname?nickname="+nickname,
                type: "get",
                success: function (res) {
                    if (res.msg === 'success') {
                        layer.msg("修改成功");
                        setTimeout(() => window.location.reload(), 1000);
                    }
                }
            })
        });
        $(".cancel").click(function () {
            $(this).parent(".btn-group").css({display: "none"});
            $(this).parent(".btn-group").siblings(".value").css({display: "inline-block"});
            $(this).parent(".btn-group").siblings(".layui-input-inline").css({display: "none"});
            $(".update-btn").css({display: "block"});
        });
    });
    var verifyCode = '';

    function getVerifyCode(type) {
        var num;
        if ('E' === type) {
            num = $("#email").val();
            if (!checkEmail(num)) {
                layer.msg("邮箱格式不正确");
                return;
            }
        } else if ('P' === type) {
            num = $("#phone").val();
            if (!checkPhone(num)) {
                layer.msg("手机号码格式不正确");
                return;
            }
        }
        $.ajax({
            url: "http://localhost:8080/renting/user/sendCode?number=" + num + "&type=" + type,
            type: "get",
            success: function (res) {
                if (res.msg === 'success') {
                    layer.msg("获取验证码成功");
                    verifyCode = res.data;
                } else {
                    layer.msg(res.msg);
                }
            }
        });
    }

    function checkEmail(email) {
        var reg = /^([a-zA-Z]|[0-9])(\w|_|.)+@[a-zA-Z0-9]+\.([a-zA-Z]{2,4})$/;
        return email.match(reg);
    }

    function checkPhone(phone) {
        var reg = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1})|(17[0-9]{1}))+\d{8})$/;
        return phone.match(reg);
    }

    function changeEmail() {
        var layer = layui.layer;
        var email = $("#email").val();
        var code = $("#emailCode").val();
        if (code === verifyCode) {
            $.ajax({
                url: "http://localhost:8080/renting/user/changeEmail?email=" + email,
                type: "get",
                success: function (res) {
                    if (res.msg === 'success') {
                        layer.msg("修改成功");
                        window.location.reload();
                    } else {
                        layer.msg(res.msg)
                    }
                }
            })
        } else {
            layer.msg("验证码不正确");
        }
    }

    function changePhone() {
        var layer = layui.layer;
        var phone = $("#phone").val();
        var code = $("#phoneCode").val();
        if (code === verifyCode) {
            $.ajax({
                url: "http://localhost:8080/renting/user/changePhone?phone=" + phone,
                type: "get",
                success: function (res) {
                    if (res.msg === 'success') {
                        layer.msg("修改成功");
                        window.location.reload();
                    } else {
                        layer.msg(res.msg)
                    }
                }
            })
        } else {
            layer.msg("验证码不正确");
        }
    }
</script>
</body>
</html>