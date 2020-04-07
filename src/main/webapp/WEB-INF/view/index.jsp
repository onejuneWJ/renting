<%--
  Created by IntelliJ IDEA.
  User: onejune
  Date: 2019/11/4
  Time: 10:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ch">
<head>
    <meta charset="utf-8"/>
    <title>万家</title>
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/images/favicon.ico"/>
    <link rel="bookmark" href="${pageContext.request.contextPath}/images/favicon.ico"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/font-awesome.min.css">
    <link rel="stylesheet" rev="stylesheet" href="${pageContext.request.contextPath}/css/index.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/layui/layui.js"></script>
    <script src="${pageContext.request.contextPath}/js/index.js" type="text/javascript"></script>
</head>

<body>
<div class="topbar ">
    <div class="header-center clearfix">
        <ul class="nav-site clearfix">
        </ul>
        <div id="userbox" class="user">
            <div class="userlogin userblock">
                <i class="icon icon-people"></i>

                <c:if test="${sessionScope.CURRENT_USER!= null}">
                    <a class="link"
                       target="_blank"
                       href="${pageContext.request.contextPath}/user/self"
                       rel="nofollow" title="个人中心">${sessionScope.CURRENT_USER.username}</a>
                    <a id="logoutLink" class="link"
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
<div class="header header-center clearfix">
    <a class="logo" href="#" title="万家租房网">万家</a>

    <div class="cityselect">
        <div id="switch_apf_id_5" class="city-view">
            <c:if test="${sessionScope.CITY==null}">
                <a id="cityLink" class="link"
                   href="${pageContext.request.contextPath}/city_list.html"
                   rel="nofollow">选择城市</a>
            </c:if>

            <c:if test="${sessionScope.CITY!=null}">
                <span id="city_name">${sessionScope.CITY.name}</span>
                <a id="cityLink" class="link"
                   href="${pageContext.request.contextPath}/city_list.html"
                   rel="nofollow">切换城市</a>
            </c:if>
        </div>
        <script type="text/javascript">
            $(document).ready(function () {
                $("#city_name").hover(function () {
                    $("#city_list").css({display: "block"});
                }, function () {
                    $("#city_list").css({display: "none"});
                });
            });
        </script>
    </div>

</div>
<div class="nav header-center clearfix">
    <ul>
        <li>
            <a href="" class="current">区域找房</a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/postHouse" target="_blank">我要出租</a>
        </li>
    </ul>
</div>
<div class="w1180">

    <!--筛选信息-->

    <div class="div-border items-list">
        <!-- 区域 begin-->
        <div class="items">
            <span class="item-title">位置：</span>
            <span class="elems-l" id="location-query">
                //区域找房
            </span>
        </div>
        <!-- 区域 end-->

        <!-- 租金 begin-->
        <div class="items ">
            <span class="item-title">租金：</span>
            <span class="elems-l" id="rental-query">
                //租金范围
            </span>
        </div>

        <!--  房屋类型 begin-->
        <div class="items">
            <span class="item-title">房型：</span>
            <span class="elems-l" id="houseTypes-query">
                //房型
            </span>
        </div>

        <!-- 更多方式 begin -->
        <div class="search_bottom clearfix">
            <div id="condmenu">
                <ul class="condul clearfix">
                    <li class="condlist_tip"><span>朝向：</span></li>
                    <li class="condibox">
                        <a href="javascript:void(0);">
                            <span class="select_item">
                                <span class="txt" id="condhouse_orient_txt_id">
                                    ${sessionScope.CURRENT_TOWARDS.name==null?"全部":sessionScope.CURRENT_TOWARDS.name}
                                </span>
                                <span class="icon">&nbsp;</span>
                            </span>
                        </a>
                        <ul id="towards-query" style="display: none;">

                        </ul>
                    </li>
                </ul>
            </div>
            <script type="text/javascript">
                window.onload = function () {
                    $(".condibox").hover(function () {
                        $(this).children("ul").css({display: "block"});
                    }, function () {
                        $(this).children("ul").css({display: "none"});
                    })
                }
            </script>
        </div>
    </div>


    <!--主模块-->
    <div class="maincontent">
        <div class="list-content" id="list-content">
            <!--我们的开始，是很长的电影-->
            <!--标签-->
            <div class="zu-tab">
                <a href="" class="curTab">房源列表</a>
            </div>
            <!--排序-->
            <div class="zu-sort">
                <span class="tit">为您找到<em>${count==null?0:count}</em>条房源租房</span>
                <div class="sort-cond">
                    <span>排序 ：</span>
                    <a id="orderDefault" href="javascript:void(0)" class="${(sortFlag!="1"&&sortFlag!="2")?"light":""}">默认</a>
                    <a id="orderRental" href="javascript:void(0)" class="${sortFlag=="1"?"light":""}">租金
                        <c:if test="${sortFlag=='1'}">
                            <c:if test="${rentalSort=='ASC'}">
                                <i class="icon icon-arrup-org"></i>
                            </c:if>
                            <c:if test="${rentalSort=='DESC'}">
                                <i class="icon icon-arrdown-org"></i>
                            </c:if>
                        </c:if>
                        <c:if test="${sortFlag!='1'}">
                            <c:if test="${rentalSort==null||rentalSort=='ASC'}">
                                <i class="icon icon-arrup"></i>
                            </c:if>
                            <c:if test="${rentalSort=='DESC'}">
                                <i class="icon icon-arrdown"></i>
                            </c:if>
                        </c:if>
                    </a>
                    <a id="orderTime" href="javascript:void(0)" class="${sortFlag=="2"?"light":""}">最新
                        <c:if test="${sortFlag=='2'}">
                            <c:if test="${timeSort=='ASC'}">
                                <i class="icon icon-arrup-org"></i>
                            </c:if>
                            <c:if test="${timeSort=='DESC'}">
                                <i class="icon icon-arrdown-org"></i>
                            </c:if>
                        </c:if>
                        <c:if test="${sortFlag!='2'}">
                            <c:if test="${timeSort==null||timeSort=='ASC'}">
                                <i class="icon icon-arrup"></i>
                            </c:if>
                            <c:if test="${timeSort=='DESC'}">
                                <i class="icon icon-arrdown"></i>
                            </c:if>
                        </c:if>
                    </a>
                    <!--icon-arrup-org icon-arrdown-org为高亮箭头-->
                </div>
            </div>
            <!--房源列表豆腐块-->
            <!--区域板块租房房源列表页-->


            <c:forEach items="${houseList}" var="house">

                <div class="zu-itemmod" link="${pageContext.request.contextPath}/house/to/${house.id}">
                    <a data-company="" class="img" data-sign="true"
                       href="${pageContext.request.contextPath}/house/to/${house.id}"
                       target="_blank">
                        <img class="thumbnail"
                             src="/upload/images/${house.imgList.get(0).imgName}"
                             width="180" height="135">
                        <span class="many-icons iconfont"></span>
                    </a>
                    <div class="zu-info">
                        <h3>
                            <a target="_blank" href="${pageContext.request.contextPath}/house/to/${house.id}">
                                <b class="strongbox">${house.description}</b>
                            </a>
                        </h3>
                        <p class="details-item tag">
                            <b class="strongbox" style="font-weight: normal;">${house.huxingShi}</b>室<b
                                class="strongbox"
                                style="font-weight: normal;">${house.huxingTing}</b>厅<span>|</span><b
                                class="strongbox"
                                style="font-weight: normal;">${house.area}</b>平米<span>|</span>${house.currentFloor}层(共${house.totalFloor}层)
                            <i class="iconfont jjr-icon"></i>${house.contactName} </p>
                        <address class="details-item">
                            <a href="#">${house.plotName}</a>&nbsp;&nbsp;
                                ${house.address}
                        </address>
                        <p class="details-item bot-tag">
                            <span class="cls-2">${house.towards}</span>
                        </p>
                    </div>

                    <div class="zu-side">
                        <p><strong><b class="strongbox"><fmt:formatNumber groupingUsed="false" value="${house.rental } " maxFractionDigits="0"/></b></strong> 元/月</p>
                    </div>
                </div>
            </c:forEach>

        </div>

        <!--翻页-->
        <div class="page-content" id="page-content"></div>
        <script>
            layui.use('laypage', function () {
                var layPage = layui.laypage;
                layPage.render({
                    elem: 'page-content', //注意，这里的 test1 是 ID，不用加 # 号,
                    count: ${count==null?0:count}, //数据总数，从服务端得到
                    layout: ['count', 'prev', 'page', 'next', 'limit', 'skip'],
                    limit: ${limit==null?20:limit},
                    curr: ${page==null?1:page},
                    jump: function (obj, first) {
                        console.log(obj);
                        if (!first) {
                            var uri = document.documentURI;
                            if (uri.includes("?")) {
                                location.href = uri.substr(0, uri.lastIndexOf('?')) +
                                    "?page=" + obj.curr +
                                    "&limit=" + obj.limit +
                                    "&rentalSort=" + '${rentalSort}'
                                    + "&timeSort=" + '${timeSort}'
                                    + "&sortFlag=" + '${sortFlag}';
                            } else {
                                location.href = uri +
                                    "?page=" + obj.curr +
                                    "&limit=" + obj.limit +
                                    "&rentalSort=" + '${rentalSort}'
                                    + "&timeSort=" + '${timeSort}'
                                    + "&sortFlag=" + '${sortFlag}';
                            }
                        }
                    }
                });
            })
        </script>
    </div>


</div>
</body>
<script type="text/javascript">
    $(document).ready(function () {
        // 获取显示区域列表、租金、等条件
        $.ajax({
            url: "${pageContext.request.contextPath}/query-data",
            type: "GET",
            success: function (data) {
                var json = JSON.parse(data);

                //区域查询条件
                const locations = json.locations;
                var locationHtml = "<a href='javascript:void(0)' title=\"区域租房\" class=\"selected-item\">区域</a>\n" +
                    "<div class=\"sub-items sub-level1\">\n" +
                    "<em class=\"arrow-wrap \"><em class=\"arrow\"></em></em>\n" +
                    "<a href='${pageContext.request.contextPath}/house' ";
                if ('' === '${sessionScope.CURRENT_LOCATION}') {
                    locationHtml += "class='selected-item'";
                }
                locationHtml += "title='全部租房'>全部</a>";
                for (let i = 0; i < locations.length; i++) {
                    locationHtml += "<a href='${pageContext.request.contextPath}/house/${sessionScope.CITY.id}/" + locations[i].id + " '";
                    if (locations[i].id.toString() === '${sessionScope.CURRENT_LOCATION.id}') {
                        locationHtml += "class='selected-item'";
                    }
                    locationHtml += "title='" + locations[i].name + "'>" + locations[i].name + "</a>";
                }
                locationHtml += "</div>";
                $("#location-query").html(locationHtml);

                // 租金查询条件
                const rentals = json.rentals;
                var rentalsHtml = "<a href='${pageContext.request.contextPath}/house/zj-1'";
                if ('' === '${sessionScope.CURRENT_RENTAL}') {
                    rentalsHtml += "class='selected-item'";
                }
                rentalsHtml += " rel=\"nofollow\">全部</a>";
                for (let i = 0; i < rentals.length; i++) {
                    rentalsHtml += "<a href='${pageContext.request.contextPath}/house/zj" + i + "' ";
                    if (rentals[i].name === '${sessionScope.CURRENT_RENTAL.name}') {
                        rentalsHtml += "class='selected-item'";
                    }
                    rentalsHtml += ">" + rentals[i].name + "</a>";
                }
                $("#rental-query").html(rentalsHtml);

                //房型查询条件
                const houseTypes = json.houseTypes;
                var houseTypesHtml = "<a href='${pageContext.request.contextPath}/house/fx-1'";
                if ('' === '${sessionScope.CURRENT_HOUSE_TYPE}') {
                    houseTypesHtml += "class='selected-item'";
                }
                houseTypesHtml += " rel=\"nofollow\">全部</a>";
                for (let i = 0; i < houseTypes.length; i++) {
                    houseTypesHtml += "<a href='${pageContext.request.contextPath}/house/fx" + i + "' ";
                    if (houseTypes[i].name === '${sessionScope.CURRENT_HOUSE_TYPE.name}') {
                        houseTypesHtml += "class='selected-item'";
                    }
                    houseTypesHtml += ">" + houseTypes[i].name + "</a>";
                }
                $("#houseTypes-query").html(houseTypesHtml);

                //朝向搜索
                const towards = json.towards;
                var towardsHtml = "<li ";
                if ('' === '${sessionScope.CURRENT_TOWARDS}') {
                    towardsHtml += "class='selected'";
                }
                towardsHtml += "><a href='${pageContext.request.contextPath}/house/tw-1' rel=\"nofollow\">全部</a></li>";
                for (let i = 0; i < towards.length; i++) {
                    towardsHtml += "<li";
                    if (towards[i].name === '${sessionScope.CURRENT_TOWARDS.name}') {
                        towardsHtml += " class='selected'";
                    }
                    towardsHtml += "><a href='${pageContext.request.contextPath}/house/tw" + i + "' ";
                    towardsHtml += "rel='nofollow'>" + towards[i].name + "</a></li>";
                }
                $("#towards-query").html(towardsHtml);
            }
        });

        $("#orderDefault").click(function () {
            let uri = document.documentURI;
            if (uri.includes("?")) {
                location.href = uri.substr(0, uri.lastIndexOf('?'))
                    + "?page=1"
                    + "&limit=" + '${limit}'
                    + "&sortFlag=0";
            } else {
                location.href = '';
            }

        });
        $("#orderRental").click(function () {
            let uri = document.documentURI;
            if (uri.includes("?")) {
                location.href = uri.substr(0, uri.lastIndexOf('?'))
                    + "?t=t"
                    + "&page=1"
                    + "&limit=" + '${limit}'
                    + "&rentalSort=" + '${rentalSort==null?"ASC":rentalSort=="ASC"?"DESC":"ASC"}'
                    + "&timeSort=" + '${timeSort}'
                    + "&sortFlag=1";
            } else {
                location.href = uri
                    + "?t=t"
                    + "&page=1"
                    + "&limit=" + '${limit}'
                    + "&rentalSort=" + '${rentalSort==null?"ASC":rentalSort=="ASC"?"DESC":"ASC"}'
                    + "&timeSort=" + '${timeSort}'
                    + "&sortFlag=1";
            }
        });
        $("#orderTime").click(function () {
            let uri = document.documentURI;
            if (uri.includes("?")) {
                location.href = uri.substr(0, uri.lastIndexOf('?'))
                    + "?t=t"
                    + "&page=1"
                    + "&limit=" + '${limit}'
                    + "&rentalSort=" + '${rentalSort}'
                    + "&timeSort=" + '${timeSort==null?"ASC":timeSort=="ASC"?"DESC":"ASC"}'
                    + "&sortFlag=2";
            } else {
                location.href = uri
                    + "?t=t"
                    + "&page=1"
                    + "&limit=" + '${limit}'
                    + "&rentalSort=" + '${rentalSort}'
                    + "&timeSort=" + '${timeSort==null?"ASC":timeSort=="ASC"?"DESC":"ASC"}'
                    + "&sortFlag=2";
            }
        });

        $(".zu-itemmod").click(function () {

            window.location.href=$(this).attr("link");
        });
    })
</script>
</html>
