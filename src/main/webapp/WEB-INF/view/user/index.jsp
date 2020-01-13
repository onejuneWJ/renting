<%--
  Created by IntelliJ IDEA.
  User: onejune
  Date: 2020/1/10
  Time: 17:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ch">

<head>
    <meta charset="UTF-8">
    <title>租房管理后台</title>
    <!-- 公共样式 开始 -->
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/images/favicon.ico"/>
    <link rel="bookmark" href="${pageContext.request.contextPath}/images/favicon.ico"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/base.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/iconfont.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/framework/jquery-1.11.3.min.js"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/layui/css/layui.css">
    <!--[if lt IE 9]>
    <script src="/framework/html5shiv.min.js"></script>
    <script src="/framework/respond.min.js"></script>
    <![endif]-->
    <script type="text/javascript" src="${pageContext.request.contextPath}/layui/layui.js"></script>
    <!-- 滚动条插件 -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/jquery.mCustomScrollbar.css">
    <script src="${pageContext.request.contextPath}/framework/jquery-ui-1.10.4.min.js"></script>
    <script src="${pageContext.request.contextPath}/framework/jquery.mousewheel.min.js"></script>
    <script src="${pageContext.request.contextPath}/framework/jquery.mCustomScrollbar.min.js"></script>
    <script src="${pageContext.request.contextPath}/framework/cframe.js"></script><!-- 仅供所有子页面使用 -->
    <!-- 公共样式 结束 -->

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/frameStyle.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/framework/frame.js"></script>

</head>

<body>
<script type="text/javascript">

</script>
<!-- 左侧菜单 - 开始 -->
<div class="frameMenu">
    <div class="logo">
        <img src="/upload/images/${sessionScope.CURRENT_USER.avatar}"/>
        <div class="logoText">
            <h1>个人中心</h1>
            <p>user self</p>
        </div>
    </div>
    <div class="menu">
        <ul>
            <li>
                <a id="initA" class="menuFA" href="javascript:void(0)"
                   onclick="menuCAClick('${pageContext.request.contextPath}/tgls/admin/house_list.html',this)">
                    <i class="iconfont icon-shouye left"></i>我的发布</a>
            </li>

            <li>
                <a class="menuFA" href="javascript:void(0)"
                   onclick="menuCAClick('${pageContext.request.contextPath}/tgls/admin/trade_list.html',this)">
                    <i class="iconfont icon-yijiedan left"></i>我的合同</a>
            </li>
            <li>
                <a class="menuFA" href="javascript:void(0)"
                   onclick="menuCAClick('${pageContext.request.contextPath}/tgls/admin/user_list.html',this)">
                    <i class="iconfont icon-yonghu1 left"></i>用户管理</a>
            </li>

        </ul>
    </div>
</div>
<!-- 左侧菜单 - 结束 -->

<div class="main">
    <!-- 头部栏 - 开始 -->
    <div class="frameTop">
        <img class="jt" src="${pageContext.request.contextPath}/images/top_jt.png"/>
        <div class="topMenu">
            <ul>
                <li><a href="javascript:void(0)" onclick="menuCAClick('${pageContext.request.contextPath}/user/info',this)"><i
                        class="iconfont icon-yonghu1"></i>个人信息</a></li>
                <li><a href="javascript:void(0)" onclick="menuCAClick('${pageContext.request.contextPath}/tgls/admin/modify_password.html',this)"><i
                        class="iconfont icon-xiugaimima"></i>修改密码</a></li>
                <li><a href="${pageContext.request.contextPath}/user/logout"><i class="iconfont icon-084tuichu"></i>注销</a></li>
            </ul>
        </div>
    </div>
    <!-- 头部栏 - 结束 -->

    <!-- 核心区域 - 开始 -->
    <div class="frameMain">
        <div class="con">
            <iframe id="mainIframe" src="${pageContext.request.contextPath}/tgls/admin/house_list.html" scrolling="yes"></iframe>
        </div>
    </div>
    <!-- 核心区域 - 结束 -->
</div>
</body>
</html>
