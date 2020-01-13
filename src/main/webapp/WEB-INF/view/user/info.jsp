<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<form>


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
                                <a href="JavaScript:" onclick="modifyAvatar()" class="operate-btn">修改</a>
                            </li>
                            <li class="username">
                                <span class="key">用户名</span>
                                <span class="value">${sessionScope.CURRENT_USER.username}</span>
                            </li>
                            <li class="nickname">
                                <span class="key">昵称</span>
                                <span class="value">${sessionScope.CURRENT_USER.nickname}</span>
                                <div class="layui-input-inline" style="display: none">
                                    <input class="layui-input" name="nickname" type="text">
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
                                <button type="button" class="operate-btn update-btn">绑定</button>
                                <div class="layui-btn-group btn-group" style="display: none;margin-left: 225px">
                                    <a type="button" class="layui-btn save">保存</a>
                                    <a type="button" class="layui-btn cancel">取消</a>
                                </div>
                            </li>
                            <li class="phone">
                                <span class="key">手机</span>
                                <span class="value">${sessionScope.CURRENT_USER.phone}</span>
                                <div class="layui-input-inline" style="display: none">
                                    <input class="layui-input" lay-verify="phone" name="phone" type="text">
                                </div>
                                <button type="button" class="operate-btn update-btn">修改</button>
                                <div class="layui-btn-group btn-group" style="display: none;margin-left: 225px">
                                    <a type="button" class="layui-btn save">保存</a>
                                    <a type="button" class="layui-btn cancel">取消</a>
                                </div>
                            </li>
                        </ul>
                    </div>

            </div>
</form>      </div>
    </div>

</div>
<script>

    function modifyAvatar() {
        var element = layui.element;
        element.tabDelete('user_tab', 'avatar_tab');
        element.tabAdd('user_tab', {
            title: '修改头像',
            content: '<iframe id="add_frame" width="100%" height="513px" src="${pageContext.request.contextPath}/tgls/user/modifyAvatar.html" scrolling="yes"></iframe>', //支持传入html
            id: 'avatar_tab'
        });
        element.tabChange('user_tab', 'avatar_tab');
    }
</script>
<script>
    layui.use('element', function () {

    });
</script>
<script>
    $(document).ready(function () {
        $(".update-btn").click(function () {
            $(this).css({display: "none"});
            $(this).siblings(".value").css({display: "none"});
            $(this).siblings(".btn-group").css({display: "inline-block"});
            $(this).siblings(".layui-input-inline").css({display: "inline-block"}).addClass("value");

        });
        $(".save").click(function () {

        });
        $(".cancel").click(function () {
            $(this).parent(".btn-group").css({display: "none"});
            $(this).parent(".btn-group").siblings(".value").css({display: "inline-block"});
            $(this).parent(".btn-group").siblings(".layui-input-inline").css({display: "none"});
            $(".update-btn").css({display: "block"});
        });
    });
</script>
</body>
</html>