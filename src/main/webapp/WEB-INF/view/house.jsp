<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>房源详情</title>
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/images/favicon.ico"/>
    <link rel="bookmark" href="${pageContext.request.contextPath}/images/favicon.ico"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css">
    <link rel="stylesheet" rev="stylesheet" href="${pageContext.request.contextPath}/css/house.css" type="text/css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/layui/layui.js"></script>

</head>
<body>

<div class="topbar ">
    <div class="header-center clearfix">
        <ul class="nav-site clearfix">
            <li class="first">
                <a href="${pageContext.request.contextPath}/index.htm">首页</a>
            </li>
        </ul>
        <div id="userbox" class="user">
            <div class="userlogin userblock">
                <i class="icon icon-people"></i>

                <c:if test="${sessionScope.CURRENT_USER!= null}">
                    <a class="link"
                       href="${pageContext.request.contextPath}/user/self"
                       rel="nofollow" title="个人中心">${sessionScope.CURRENT_USER.username}</a>
                    <a id="logoutLink" style="display: none" class="link"
                       href="${pageContext.request.contextPath}/user/logout">退出登录</a>
                </c:if>
                <!--未登录-->
                <c:if test="${sessionScope.CURRENT_USER == null}">
                    <a id="loginLink" class="link" href="${pageContext.request.contextPath}/user_login.html"
                       rel="nofollow">登录</a>
                    <a id="registerLink" class="link" href="${pageContext.request.contextPath}/register.html"
                       rel="nofollow">注册</a>
                </c:if>
            </div>

        </div>
    </div>
</div>
<div class="wrapper">

    <h3 class="house-title">
        <div class="strongbox" style="font-weight: normal;">${house.description}</div>
    </h3>
    <div class="title-basic-info clearfix">


        <span class="light info-tag"><em><b
                class="strongbox" style="font-weight: normal;"><fmt:formatNumber groupingUsed="false"
                                                                                 value="${house.rental } "
                                                                                 maxFractionDigits="0"/></b></em>元/月</span>
        <span class="info-tag">
            <em><b class="strongbox" style="font-weight: normal;">${house.huxingShi}</b></em>室<em><b
                class="strongbox" style="font-weight: normal;">${house.huxingTing}</b></em>厅
        </span>
        <span class="info-tag no-line"><em><b class="strongbox"
                                              style="font-weight: normal;">${house.area}</b></em>平方米</span>
        <ul class="title-label cf">
            <li class="title-label-item rent">${house.towards}</li>
        </ul>
    </div>
    <div class="mainbox cf">
        <div class="lbox">

            <div class="switch_warpper">
                <div class="switch_with_map">

                    <div class="layui-carousel" id="house_imgs">
                        <div carousel-item="">
                            <c:forEach items="${house.imgList}" var="img">
                                <div>
                                    <img src="/upload/images/${img.imgName}" width="100%" height="450px">
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                    <!-- 条目中可以是任意内容，如：<img src=""> -->
                    <script>
                        layui.use('carousel', function () {
                            var carousel = layui.carousel;
                            //建造实例
                            carousel.render({
                                elem: '#house_imgs',
                                height: "450",
                                width: '100%', //设置容器宽度
                                arrow: 'hover', //始终显示箭头
                                indicator: "inside",
                            });
                        });
                    </script>
                </div>
                <div class="switch_tab_wrap" id="switch_tab_wrap">
                    <a class="switch_tag switch_tag_now" href="javascript:;" data-track="pc_fydy_switch_snt">
                        <i class="switch-icon iconfont switch-room-icon">房</i>
                        <em class="title"></em> </a>
                    <a class="switch_tag switch_tag_now" href="javascript:;" data-track="pc_fydy_switch_snt">
                        <i class="switch-icon iconfont switch-room-icon">屋</i>
                        <em class="title"></em> </a>
                    <a class="switch_tag switch_tag_now" href="javascript:;" data-track="pc_fydy_switch_snt">
                        <i class="switch-icon iconfont switch-room-icon">图</i>
                        <em class="title"></em> </a>
                    <a class="switch_tag switch_tag_now" href="javascript:;" data-track="pc_fydy_switch_snt">
                        <i class="switch-icon iconfont switch-room-icon">片</i>
                        <em class="title"></em> </a>
                </div>
            </div>

            <!--房屋信息-->
            <div class="mod-title bottomed">
                <h3 id="houseInfo" class="title nav-scroll">房屋信息</h3>
                <div class="right-info">发布时间：<b class="strongbox" style="font-weight: normal;">
                    <fmt:formatDate value="${house.postTime }" type="date" pattern="yyyy年MM月dd日"/>
                </b>
                </div>
            </div>
            <ul class="house-info-zufang cf">
                <li class="full-line cf">
                    <span class="price"><em><b class="strongbox" style="font-weight: normal;">
                        <fmt:formatNumber groupingUsed="false" value="${house.rental } " maxFractionDigits="0"/>
                    </b></em>元/月</span>
                    <span class="type">${house.payment}</span>

                </li>
                <li class="house-info-item l-width">
                    <span class="type">户型：</span>
                    <span class="info"><b class="strongbox" style="font-weight: normal;">${house.huxingShi}</b>室<b
                            class="strongbox" style="font-weight: normal;">${house.huxingTing}</b>厅<b
                            class="strongbox" style="font-weight: normal;">${house.huxingWei}</b>卫</span>
                </li>
                <li class="house-info-item">
                    <span class="type">面积：</span>
                    <span class="info"><b class="strongbox" style="font-weight: normal;">${house.area}平方米</b></span>
                </li>
                <li class="house-info-item">
                    <span class="type">朝向：</span>
                    <span class="info">朝${house.towards}</span>
                </li>
                <li class="house-info-item l-width">
                    <span class="type">楼层：</span>
                    <span class="info">${house.currentFloor}层(共${house.totalFloor}层)</span>
                </li>
                <li class="house-info-item">
                    <span class="type">装修：</span>
                    <span class="info">精装修</span>
                </li>
                <li class="house-info-item">
                    <span class="type">类型：</span>
                    <span class="info">普通住宅</span>
                </li>
                <li class="house-info-item l-width">
                    <span class="type">小区：</span>
                    <a href="#" class="link">${house.plotName}</a>
                </li>
                <li class="house-info-item">
                    <span class="type">要求：</span>
                    <c:forEach var="re" items="${house.requiresList}">
                        <span class="info">${re.name}</span>
                    </c:forEach>
                </li>
            </ul>

            <!--房屋配套-->
            <div class="mod-title bottomed">
                <h3 class="title">房屋配套</h3>
            </div>
            <ul class="house-info-peitao cf" data-trace="{'pc_zfdy_fypt_show':1}">
                <!-- 带有此功能则加has -->
                <li class="peitao-item has">
                    <i class="iconfont"></i>
                    <div class="peitao-info">床</div>
                </li>
                <li class="peitao-item has">
                    <i class="iconfont"></i>
                    <div class="peitao-info">洗衣机</div>
                </li>
                <li class="peitao-item has">
                    <i class="iconfont"></i>
                    <div class="peitao-info">空调</div>
                </li>
                <li class="peitao-item has">
                    <i class="iconfont"></i>
                    <div class="peitao-info">阳台</div>
                </li>
                <li class="peitao-item has">
                    <i class="iconfont"></i>
                    <div class="peitao-info">冰箱</div>
                </li>

                <li class="peitao-item has">
                    <i class="iconfont"></i>
                    <div class="peitao-info">卫生间</div>
                </li>
                <li class="peitao-item has">
                    <i class="iconfont"></i>
                    <div class="peitao-info">可做饭</div>
                </li>
                <li class="peitao-item has">
                    <i class="iconfont"></i>
                    <div class="peitao-info">电视</div>
                </li>
                <li class="peitao-item has">
                    <i class="iconfont"></i>
                    <div class="peitao-info">热水器</div>
                </li>
                <li class="peitao-item has">
                    <i class="iconfont"></i>
                    <div class="peitao-info">衣柜</div>
                </li>
                <li class="peitao-item has">
                    <i class="iconfont"></i>
                    <div class="peitao-info">暖气</div>
                </li>
                <li class="peitao-item has">
                    <i class="iconfont"></i>
                    <div class="peitao-info">宽带</div>
                </li>
                <li class="peitao-item has">
                    <i class="iconfont"></i>
                    <div class="peitao-info">沙发</div>
                </li>
            </ul>

            <div class="houseInfo-tags clearfix" id="proLinks">
            </div>

        </div>
        <div class="rbox">

            <div class="broker-card">
                <div class="broker-border">
                    <img class="broker-photo-main" data-tracker="pc_detail_maincontact_photo_click"
                         src="/upload/images/${house.avatar}"
                         title="王俊">

                    <h2 class="broker-name" title="王俊">王俊</h2>

                    <div class="broker-level">
                        <div class="broker-level clearfix">
                            <span class="stars-title">联系电话：</span>
                            <div class="stars-wrap-bk" style="width:90px">
                                ${house.contactPhone}
                            </div>
                        </div>
                    </div>
                    <div class="broker-level">
                        <div class="broker-level clearfix">
                            <span class="stars-title">邮箱：</span>
                            <div class="stars-wrap-bk" style="width:90px">
                                ${house.email}
                            </div>
                        </div>
                    </div>
                    <div class="broker-level">
                        <div class="broker-level clearfix">
                            <span class="stars-title">性别：</span>
                            <div class="stars-wrap-bk" style="width:90px">
                                男
                            </div>
                        </div>
                    </div>
                    <div class="allscreen-wrap" id="allScreen">
                        <i class="iconfont close" id="allScreenClose"></i>
                        <img src="" alt="" class="allscreen-image" id="allscreenImg">
                    </div>


                    <div class="jjr-mobile">
                        我要看房
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    $(document).ready(function () {
        $(".jjr-mobile").click(function () {
            var houseId = '${house.id}';
            console.log(houseId);
            layui.use('layer', function () {
                var layer = layui.layer;
                $.ajax({
                    url: "${pageContext.request.contextPath}/visit",
                    data: {"houseId": houseId},
                    contentType: "application/x-www-form-urlencoded",
                    type: "post",
                    success: function (res) {
                        if (res.msg === 'success') {
                            layer.msg("发起看房请求成功，等待房东的回复吧，您也可以直接联系房东噢",{
                                icon: 1,
                                time: 10000,
                                btn:['知道了']
                            });
                        }else {
                            layer.msg(res.msg,{
                                icon: 0,
                                time: 10000,
                                btn: ['知道了']
                            });
                        }

                    },
                    error: function () {
                        layer.msg("请求错误！",{
                            icon: 2
                        });
                    }
                });
            });
        });
    });
</script>

</body>
</html>