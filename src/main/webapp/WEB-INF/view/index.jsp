<%--
  Created by IntelliJ IDEA.
  User: onejune
  Date: 2019/11/4
  Time: 10:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <!--高德定位-->
    <script type="text/javascript"
            src="https://webapi.amap.com/maps?v=1.4.15&key=779df40e3dc27215fd27a80bb9766217&plugin=AMap.CitySearch"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            //获取用户所在城市信息
            function showCityInfo() {
                //实例化城市查询类
                var citysearch = new AMap.CitySearch();
                //自动获取用户IP，返回当前城市
                citysearch.getLocalCity(function (status, result) {
                    if (status === 'complete' && result.info === 'OK') {
                        if (result && result.city && result.bounds) {
                            var cityinfo = result.city;
                            var provinceInfo = result.province;
                            $("#city_name")[0].innerText = cityinfo;
                            $.ajax({
                                url: "http://localhost:8080/renting/city",
                                type: "post",
                                data: {cityName: cityinfo, provinceName: provinceInfo}
                            });
                        }
                    } else {

                    }
                });
            }

            showCityInfo();
        });
    </script>

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
                       href=""
                       rel="nofollow" title="用户名">${sessionScope.CURRENT_USER.username}</a>
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
<div class="header header-center clearfix">
    <a class="logo" href="#" title="万家租房网">万家</a>

    <div class="cityselect">
        <div id="switch_apf_id_5" class="city-view">
            <span id="city_name">选择城市</span><i class="iconfont triangle-down"></i>
        </div>
    </div>
    <form class="search-form" id="search-form" action="https://cd.zu.anjuke.com" method="GET">

        <input type="text" name="kw" class="searchbar-rent" id="search-rent" placeholder="请输入小区名称、地址…"
               autocomplete="off" maxlength="100" value="" style="color: rgb(153, 153, 153);">
        <input type="submit" id="search-button" class="searchbar-button" hidefocus="true" value="搜索">
        <i id="search-close" class="icon icon-close" data-tracker="delete-kw" style="display:none"></i>

        <div class="auto-wrap"></div>
    </form>
</div>
<div class="nav header-center clearfix">
    <ul>
        <li>
            <a href="" class="current">区域找房</a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/house_post.html" target="_blank">我要出租</a>
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
                <a href="https://cd.zu.anjuke.com/fangyuan/wuhou/" class="curTab">房源列表</a>
            </div>
            <!--排序-->
            <div class="zu-sort">
                <span class="tit">为您找到<em>武侯</em>附近租房</span>
                <div class="sort-cond">
                    <span>排序 ：</span>
                    <a href="https://cd.zu.anjuke.com/fangyuan/wuhou/" class="light">默认</a>
                    <a href="https://cd.zu.anjuke.com/fangyuan/wuhou/px7/ " class="">租金
                        <i class="icon icon-arrup"></i>
                    </a>
                    <a href="https://cd.zu.anjuke.com/fangyuan/wuhou/px3/ " class="">最新
                        <i class="icon icon-arrdown"></i>
                    </a>
                    <!--icon-arrup-org icon-arrdown-org为高亮箭头-->
                </div>
            </div>
            <!--房源列表豆腐块-->
            <!--区域板块租房房源列表页-->
            <div class="zu-itemmod"
                 link="https://cd.zu.anjuke.com/fangyuan/1408687362?isauction=2&amp;shangquan_id=12607&amp;legoFeeUrl=https%3A%2F%2Flegoclick.58.com%2Fjump%3Ftarget%3DpZwY0ZnlsztdraOWUvYKuad-P1RbnyndraYkuy7hsHEvmvcVrHwhPBYkmycQrjmLPW6hujDKnHTknjNOnjn1TEDQnjbLnWE3Pj01nHEYn1ckTHmznjTKPWcknTDQsjDkTHDkrikQPHmQTHDdPWm1rjELnjbzPHNKnE7AEzdEEzdKib_VOlXxOCB4sXXVhShTBXyc-SB6Jrh6VEDQTHDKTiYQTEDQnHm1rHbOPWTvnHT1PWcQPWn1THmKTHDKPvcOnhw-mH0VP1KBPzYYmvPbsH91nvEVmW0vuWIbn1ndnW9YTHDQPWnOrHbvnjmznHm3PW03PjTKnHDvn1bOrHmkPWDdn1bdn1c3nTDKTEDKTiYKTE7CIZwk01CfsvPbsMGdsh78pMRouiOWUvYfuh78uL-dmy3fILRCULNf5vuzUvYqNvR60hPCEh7zTNn3rHNQwW7jsNPaPH9VPHEzPaYYnHPasRPmnj9znHD3n10YPEDQnHc8n1D8nHm8rHmKnTDkTEDQsjDzTgVqTHDknjnvTHDknjDvPWNKnAnOm1mLnWTVuHbvraYYrjwBsyDQPAEVn1FWmWnvnHmLmWKWTEDYTEDKnkDQnjb_nHNvnikQnWmkPk7Wn1TvPH-buH6huHwhryDO"
                 _soj="Filter_1&amp;hfilter=filterlist">
                <a data-company="" class="img" _soj="Filter_1&amp;hfilter=filterlist" data-sign="true"
                   href="https://cd.zu.anjuke.com/fangyuan/1408687362?isauction=2&amp;shangquan_id=12607&amp;legoFeeUrl=https%3A%2F%2Flegoclick.58.com%2Fjump%3Ftarget%3DpZwY0ZnlsztdraOWUvYKuad-P1RbnyndraYkuy7hsHEvmvcVrHwhPBYkmycQrjmLPW6hujDKnHTknjNOnjn1TEDQnjbLnWE3Pj01nHEYn1ckTHmznjTKPWcknTDQsjDkTHDkrikQPHmQTHDdPWm1rjELnjbzPHNKnE7AEzdEEzdKib_VOlXxOCB4sXXVhShTBXyc-SB6Jrh6VEDQTHDKTiYQTEDQnHm1rHbOPWTvnHT1PWcQPWn1THmKTHDKPvcOnhw-mH0VP1KBPzYYmvPbsH91nvEVmW0vuWIbn1ndnW9YTHDQPWnOrHbvnjmznHm3PW03PjTKnHDvn1bOrHmkPWDdn1bdn1c3nTDKTEDKTiYKTE7CIZwk01CfsvPbsMGdsh78pMRouiOWUvYfuh78uL-dmy3fILRCULNf5vuzUvYqNvR60hPCEh7zTNn3rHNQwW7jsNPaPH9VPHEzPaYYnHPasRPmnj9znHD3n10YPEDQnHc8n1D8nHm8rHmKnTDkTEDQsjDzTgVqTHDknjnvTHDknjDvPWNKnAnOm1mLnWTVuHbvraYYrjwBsyDQPAEVn1FWmWnvnHmLmWKWTEDYTEDKnkDQnjb_nHNvnikQnWmkPk7Wn1TvPH-buH6huHwhryDO"
                   target="_blank" hidefocus="true">
                    <img class="thumbnail"
                         lazy_src="https://pic1.ajkimg.com/display/58ajk/b2ae1e08a107a3adad7ed710814734e7/240x180c.jpg"
                         src="https://pic1.ajkimg.com/display/58ajk/b2ae1e08a107a3adad7ed710814734e7/240x180c.jpg"
                         width="180" height="135" data-loaded="true">
                    <span class="many-icons iconfont"></span>
                </a>
                <div class="zu-info">
                    <h3>
                        <a target="_blank" _soj="Filter_1&amp;hfilter=filterlist"
                           href="https://cd.zu.anjuke.com/fangyuan/1408687362?isauction=2&amp;shangquan_id=12607&amp;legoFeeUrl=https%3A%2F%2Flegoclick.58.com%2Fjump%3Ftarget%3DpZwY0ZnlsztdraOWUvYKuad-P1RbnyndraYkuy7hsHEvmvcVrHwhPBYkmycQrjmLPW6hujDKnHTknjNOnjn1TEDQnjbLnWE3Pj01nHEYn1ckTHmznjTKPWcknTDQsjDkTHDkrikQPHmQTHDdPWm1rjELnjbzPHNKnE7AEzdEEzdKib_VOlXxOCB4sXXVhShTBXyc-SB6Jrh6VEDQTHDKTiYQTEDQnHm1rHbOPWTvnHT1PWcQPWn1THmKTHDKPvcOnhw-mH0VP1KBPzYYmvPbsH91nvEVmW0vuWIbn1ndnW9YTHDQPWnOrHbvnjmznHm3PW03PjTKnHDvn1bOrHmkPWDdn1bdn1c3nTDKTEDKTiYKTE7CIZwk01CfsvPbsMGdsh78pMRouiOWUvYfuh78uL-dmy3fILRCULNf5vuzUvYqNvR60hPCEh7zTNn3rHNQwW7jsNPaPH9VPHEzPaYYnHPasRPmnj9znHD3n10YPEDQnHc8n1D8nHm8rHmKnTDkTEDQsjDzTgVqTHDknjnvTHDknjDvPWNKnAnOm1mLnWTVuHbvraYYrjwBsyDQPAEVn1FWmWnvnHmLmWKWTEDYTEDKnkDQnjb_nHNvnikQnWmkPk7Wn1TvPH-buH6huHwhryDO"><b
                                class="strongbox">魏玛国际，精装套三全女生还剩两个房间，三瓦窑地铁，泛悦国际，</b>
                        </a>

                    </h3>
                    <p class="details-item tag">
                        <b class="strongbox" style="font-weight: normal;">龥</b>室<b class="strongbox"
                                                                                   style="font-weight: normal;">龤</b>厅<span>|</span><b
                            class="strongbox" style="font-weight: normal;">麣鑶</b>平米<span>|</span>高层(共32层) <i
                            class="iconfont jjr-icon"></i>邓泽明 </p>
                    <address class="details-item">
                        <a target="_blank" href="https://chengdu.anjuke.com/community/view/369380">魏玛国际</a>&nbsp;&nbsp;
                        武侯-高攀路 高攀东路33号
                    </address>
                    <p class="details-item bot-tag">
                        <span class="cls-1">合租</span>
                        <span class="cls-2">朝南</span>
                        <span class="cls-3">有电梯</span>
                        <span class="cls-4">7号线</span>
                    </p>
                </div>
                <div class="zu-side">
                    <p><strong><b class="strongbox">齤餼閏</b></strong> 元/月</p>
                </div>
            </div>
            <div class="zu-itemmod"
                 link="https://cd.zu.anjuke.com/fangyuan/1362785791?isauction=2&amp;shangquan_id=11911&amp;legoFeeUrl=https%3A%2F%2Flegoclick.58.com%2Fjump%3Ftarget%3DszqWuaOlIiO6UhGdpvN8mvqVsvu6UhIOIy78s1D1PWcLrjNLrHDKuad-P1RbnyndraYkuy7hsHEvmvcVrHwhPBYkmycQrjmLPW6hujDKPH9OnjTLrTDKnHTQnW0dn1mvP1mQnHmYrTDLP1TkTH0LnjTKnikQnTDQnjb_nHNvnEDQPHmvn19YP1TOnWNdTHcKwbnVNDnVENGssXXMMSpcfzLMoufG9cM-BFxCCpWGCUNKnEDQTEDVnEDKnHDvn1bOP191rH01nHckrjDOn9DvTEDQTyRWrH76PhmvsHu6mhmVPANkPzdBnj-hsyDYm17hnWuhnAm3nTDQnHm1rHbLrjnOrjnvnjmOrj93THDQPWnOrH03n1bLrjDdn1b3PjTKTEDKTEDVTEDKpZwY0ZnlszqWuaOlIiO6UhGdpvN8mvqVsvu6UhIOIy78sLIdpAqds1qh0hqV5RP-mgFWpDF6097jrjbdnNmQEzdjEWN3sHNYnWEVPjD1EBdHyjT3nWDQrjnLPjNKnHDzsWnQsWDvsWbvTHTKnTDKnikQn97exEDQnjT1P9DQnjTQPWmdTyw6Pju-mycOsyPWmvmVPjw6PBdBuyDdsHF6P1c3PhwBnvm1rEDKPTDKTHnKnHTOsjDdPWD_nHDOnHDKnynLuWNzrHNzrjnzn1NdPE"
                 _soj="Filter_2&amp;hfilter=filterlist">
                <a data-company="" class="img" _soj="Filter_2&amp;hfilter=filterlist" data-sign="true"
                   href="https://cd.zu.anjuke.com/fangyuan/1362785791?isauction=2&amp;shangquan_id=11911&amp;legoFeeUrl=https%3A%2F%2Flegoclick.58.com%2Fjump%3Ftarget%3DszqWuaOlIiO6UhGdpvN8mvqVsvu6UhIOIy78s1D1PWcLrjNLrHDKuad-P1RbnyndraYkuy7hsHEvmvcVrHwhPBYkmycQrjmLPW6hujDKPH9OnjTLrTDKnHTQnW0dn1mvP1mQnHmYrTDLP1TkTH0LnjTKnikQnTDQnjb_nHNvnEDQPHmvn19YP1TOnWNdTHcKwbnVNDnVENGssXXMMSpcfzLMoufG9cM-BFxCCpWGCUNKnEDQTEDVnEDKnHDvn1bOP191rH01nHckrjDOn9DvTEDQTyRWrH76PhmvsHu6mhmVPANkPzdBnj-hsyDYm17hnWuhnAm3nTDQnHm1rHbLrjnOrjnvnjmOrj93THDQPWnOrH03n1bLrjDdn1b3PjTKTEDKTEDVTEDKpZwY0ZnlszqWuaOlIiO6UhGdpvN8mvqVsvu6UhIOIy78sLIdpAqds1qh0hqV5RP-mgFWpDF6097jrjbdnNmQEzdjEWN3sHNYnWEVPjD1EBdHyjT3nWDQrjnLPjNKnHDzsWnQsWDvsWbvTHTKnTDKnikQn97exEDQnjT1P9DQnjTQPWmdTyw6Pju-mycOsyPWmvmVPjw6PBdBuyDdsHF6P1c3PhwBnvm1rEDKPTDKTHnKnHTOsjDdPWD_nHDOnHDKnynLuWNzrHNzrjnzn1NdPE"
                   target="_blank" hidefocus="true">
                    <img class="thumbnail"
                         lazy_src="https://pic1.ajkimg.com/display/58ajk/83709cf70176c8913496be81d34b3196/240x180c.jpg"
                         src="https://pic1.ajkimg.com/display/58ajk/83709cf70176c8913496be81d34b3196/240x180c.jpg"
                         width="180" height="135" data-loaded="true">
                    <span class="many-icons iconfont"></span>
                </a>
                <div class="zu-info">
                    <h3>
                        <a target="_blank" _soj="Filter_2&amp;hfilter=filterlist"
                           href="https://cd.zu.anjuke.com/fangyuan/1362785791?isauction=2&amp;shangquan_id=11911&amp;legoFeeUrl=https%3A%2F%2Flegoclick.58.com%2Fjump%3Ftarget%3DszqWuaOlIiO6UhGdpvN8mvqVsvu6UhIOIy78s1D1PWcLrjNLrHDKuad-P1RbnyndraYkuy7hsHEvmvcVrHwhPBYkmycQrjmLPW6hujDKPH9OnjTLrTDKnHTQnW0dn1mvP1mQnHmYrTDLP1TkTH0LnjTKnikQnTDQnjb_nHNvnEDQPHmvn19YP1TOnWNdTHcKwbnVNDnVENGssXXMMSpcfzLMoufG9cM-BFxCCpWGCUNKnEDQTEDVnEDKnHDvn1bOP191rH01nHckrjDOn9DvTEDQTyRWrH76PhmvsHu6mhmVPANkPzdBnj-hsyDYm17hnWuhnAm3nTDQnHm1rHbLrjnOrjnvnjmOrj93THDQPWnOrH03n1bLrjDdn1b3PjTKTEDKTEDVTEDKpZwY0ZnlszqWuaOlIiO6UhGdpvN8mvqVsvu6UhIOIy78sLIdpAqds1qh0hqV5RP-mgFWpDF6097jrjbdnNmQEzdjEWN3sHNYnWEVPjD1EBdHyjT3nWDQrjnLPjNKnHDzsWnQsWDvsWbvTHTKnTDKnikQn97exEDQnjT1P9DQnjTQPWmdTyw6Pju-mycOsyPWmvmVPjw6PBdBuyDdsHF6P1c3PhwBnvm1rEDKPTDKTHnKnHTOsjDdPWD_nHDOnHDKnynLuWNzrHNzrjnzn1NdPE"><b
                                class="strongbox">西部智谷商圈附近 主次卧甩租 不乱收费用 包网包物业带空调哦</b>
                        </a>

                    </h3>
                    <p class="details-item tag">
                        <b class="strongbox" style="font-weight: normal;">龥</b>室<b class="strongbox"
                                                                                   style="font-weight: normal;">麣</b>厅<span>|</span><b
                            class="strongbox" style="font-weight: normal;">麣餼</b>平米<span>|</span>中层(共22层) <i
                            class="iconfont jjr-icon"></i>王郡怡 </p>
                    <address class="details-item">
                        <a target="_blank" href="https://chengdu.anjuke.com/community/view/369386">嘉楠美地</a>&nbsp;&nbsp;
                        武侯-机投镇 武青北路5号
                    </address>
                    <p class="details-item bot-tag">
                        <span class="cls-1">合租</span>
                        <span class="cls-2">朝南</span>
                        <span class="cls-3">有电梯</span>
                    </p>
                </div>

                <div class="zu-side">
                    <p><strong><b class="strongbox">餼龥閏</b></strong> 元/月</p>
                </div>
            </div>
            <div class="zu-itemmod"
                 link="https://cd.zu.anjuke.com/fangyuan/1362790242?isauction=2&amp;shangquan_id=8256&amp;legoFeeUrl=https%3A%2F%2Flegoclick.58.com%2Fjump%3Ftarget%3DszqWuaOlIiO6UhGdpvN8mvqVsvu6UhIOIy78s1D1PWcLrHTzPjcKuad-P1RbnyndraYkuy7hsHEvmvcVrHwhPBYkmycQrjmLPW6hujDKPH9OnjTLrTDKnHTQnW0drjbLPHcdrjmzPED3PWTkTH9vnjTKnikQnTDQnjb_nHNvnEDQPHmvn19YP1TOnWNdTHnKwbnVNDnVENGssXXMMSpcfzLMoufG9cM-BFxCCpWGCUNKnEDQTEDVnEDKnHDvn1bOP1bvPWT1njTOnjcYnTDvTEDQTHnkuA7bnWTYsHF-uHDVPAm3nzdBuHT1sHckrHcQuH9zmWIWn9DQnHm1rHbLrHmvnHELPHnkP1N1THDQPWnOrH0OPWmkrjTYnWD3rj9KTEDKTEDVTEDKpZwY0ZnlszqWuaOlIiO6UhGdpvN8mvqVsvu6UhIOIy78sLIdpAqds1qh0hqV5RP-mgFWpDF6097jrjbdnNmQEzdjEWN3sHNYnWEVPjD1EBdHyjT3nWDQrjnLPjNKnHDzsWnQsWDvsWbvTHTKnTDKnikQn97exEDQnjT1P9DQnjTQPWmdTHNzPWn3njczsHDvn1nVPANLPiY3njEOsyDOn1IhPWbvuAw-P9DKPTDKTHnKnHTOsjDdPWD_rjcdP9DLuWKhnvFWnWFbnhEdmHTY"
                 _soj="Filter_3&amp;hfilter=filterlist">
                <a data-company="" class="img" _soj="Filter_3&amp;hfilter=filterlist" data-sign="true"
                   href="https://cd.zu.anjuke.com/fangyuan/1362790242?isauction=2&amp;shangquan_id=8256&amp;legoFeeUrl=https%3A%2F%2Flegoclick.58.com%2Fjump%3Ftarget%3DszqWuaOlIiO6UhGdpvN8mvqVsvu6UhIOIy78s1D1PWcLrHTzPjcKuad-P1RbnyndraYkuy7hsHEvmvcVrHwhPBYkmycQrjmLPW6hujDKPH9OnjTLrTDKnHTQnW0drjbLPHcdrjmzPED3PWTkTH9vnjTKnikQnTDQnjb_nHNvnEDQPHmvn19YP1TOnWNdTHnKwbnVNDnVENGssXXMMSpcfzLMoufG9cM-BFxCCpWGCUNKnEDQTEDVnEDKnHDvn1bOP1bvPWT1njTOnjcYnTDvTEDQTHnkuA7bnWTYsHF-uHDVPAm3nzdBuHT1sHckrHcQuH9zmWIWn9DQnHm1rHbLrHmvnHELPHnkP1N1THDQPWnOrH0OPWmkrjTYnWD3rj9KTEDKTEDVTEDKpZwY0ZnlszqWuaOlIiO6UhGdpvN8mvqVsvu6UhIOIy78sLIdpAqds1qh0hqV5RP-mgFWpDF6097jrjbdnNmQEzdjEWN3sHNYnWEVPjD1EBdHyjT3nWDQrjnLPjNKnHDzsWnQsWDvsWbvTHTKnTDKnikQn97exEDQnjT1P9DQnjTQPWmdTHNzPWn3njczsHDvn1nVPANLPiY3njEOsyDOn1IhPWbvuAw-P9DKPTDKTHnKnHTOsjDdPWD_rjcdP9DLuWKhnvFWnWFbnhEdmHTY"
                   target="_blank" hidefocus="true">
                    <img class="thumbnail"
                         lazy_src="https://pic1.ajkimg.com/display/58ajk/ea3d9e7ad3e9861e578a57bdf1d01aac/240x180c.jpg"
                         src="https://pic1.ajkimg.com/display/58ajk/ea3d9e7ad3e9861e578a57bdf1d01aac/240x180c.jpg"
                         width="180" height="135" data-loaded="true">
                    <span class="many-icons iconfont"></span>
                </a>
                <div class="zu-info">
                    <h3>
                        <a target="_blank" _soj="Filter_3&amp;hfilter=filterlist"
                           href="https://cd.zu.anjuke.com/fangyuan/1362790242?isauction=2&amp;shangquan_id=8256&amp;legoFeeUrl=https%3A%2F%2Flegoclick.58.com%2Fjump%3Ftarget%3DszqWuaOlIiO6UhGdpvN8mvqVsvu6UhIOIy78s1D1PWcLrHTzPjcKuad-P1RbnyndraYkuy7hsHEvmvcVrHwhPBYkmycQrjmLPW6hujDKPH9OnjTLrTDKnHTQnW0drjbLPHcdrjmzPED3PWTkTH9vnjTKnikQnTDQnjb_nHNvnEDQPHmvn19YP1TOnWNdTHnKwbnVNDnVENGssXXMMSpcfzLMoufG9cM-BFxCCpWGCUNKnEDQTEDVnEDKnHDvn1bOP1bvPWT1njTOnjcYnTDvTEDQTHnkuA7bnWTYsHF-uHDVPAm3nzdBuHT1sHckrHcQuH9zmWIWn9DQnHm1rHbLrHmvnHELPHnkP1N1THDQPWnOrH0OPWmkrjTYnWD3rj9KTEDKTEDVTEDKpZwY0ZnlszqWuaOlIiO6UhGdpvN8mvqVsvu6UhIOIy78sLIdpAqds1qh0hqV5RP-mgFWpDF6097jrjbdnNmQEzdjEWN3sHNYnWEVPjD1EBdHyjT3nWDQrjnLPjNKnHDzsWnQsWDvsWbvTHTKnTDKnikQn97exEDQnjT1P9DQnjTQPWmdTHNzPWn3njczsHDvn1nVPANLPiY3njEOsyDOn1IhPWbvuAw-P9DKPTDKTHnKnHTOsjDdPWD_rjcdP9DLuWKhnvFWnWFbnhEdmHTY"><b
                                class="strongbox">丽景华庭一期地铁龙爪堰 无中介 随时看房 带阳台 包物业网费</b>
                        </a>

                    </h3>
                    <p class="details-item tag">
                        <b class="strongbox" style="font-weight: normal;">龥</b>室<b class="strongbox"
                                                                                   style="font-weight: normal;">麣</b>厅<span>|</span><b
                            class="strongbox" style="font-weight: normal;">麣餼</b>平米<span>|</span>中层(共18层) <i
                            class="iconfont jjr-icon"></i>王郡怡 </p>
                    <address class="details-item">
                        <a target="_blank" href="https://chengdu.anjuke.com/community/view/141765">丽景华庭1期</a>&nbsp;&nbsp;
                        武侯-外双楠 龙腾中路3号
                    </address>
                    <p class="details-item bot-tag">
                        <span class="cls-1">合租</span>
                        <span class="cls-2">朝南</span>
                        <span class="cls-3">有电梯</span>
                        <span class="cls-4">7号线</span>
                    </p>
                </div>

                <div class="zu-side">
                    <p><strong><b class="strongbox">餼龥閏</b></strong> 元/月</p>
                </div>
            </div>
            <div class="zu-itemmod"
                 link="https://cd.zu.anjuke.com/fangyuan/1399906655?isauction=2&amp;shangquan_id=4508&amp;legoFeeUrl=https%3A%2F%2Flegoclick.58.com%2Fjump%3Ftarget%3DpZwY0ZnlsztdraOWUvYKuad-P1RbnyndraYkuy7hsHEvmvcVrHwhPBYkmycQrjmLPW6hujDKPWm3nHNvPEDKnHTLrHDkrHbvrHnLnHD1PkDLrjTkTH03njTKnikQnTDQnjb_nHNvnEDQPHmvn19YP1TOnWNdTHEKwbnVNDnVENGssXXMMSpcfzLMoufG9cM-BFxCCpWGCUNKnEDQTEDVnEDKnHDvn1m3PHbLPjczPjEQPW0vrTDvTEDQTH7bnjFWujELsH6huhDVPj9vmBYOuANzsyuhuHRWnhuhmWnkrTDQnHm1PW9drH0Yn1EQrjmQn10vTHDQPWnvrjNOP1EzrjnQPjDQnWTKTEDKTEDVTEDKpZwY0ZnlszqWuaOlIiO6UhGdpvN8mvqVsvu6UhIOIy78sLIdpAqds1qh0hqV5RP-mgFWpDF6097jrjbdnNmQEzdjEWN3sHNYnWEVPjD1EBdHyjT3nWDQrjnLPjNKnHDzsWnQsWDvsWbvTHTKnTDKnikQn97exEDQnjT1P9DQnjTQPWmdTHbLuAR6nvRhsyc1rj0VPAEQPaY3PW6BsHcvuyDdnH0dnWPhPEDKPTDKTHnKnHTOsjDdPWD_PjNkrTD3nAEOPWPbPjDYP1uBPhP-"
                 _soj="Filter_4&amp;hfilter=filterlist">
                <a data-company="" class="img" _soj="Filter_4&amp;hfilter=filterlist" data-sign="true"
                   href="https://cd.zu.anjuke.com/fangyuan/1399906655?isauction=2&amp;shangquan_id=4508&amp;legoFeeUrl=https%3A%2F%2Flegoclick.58.com%2Fjump%3Ftarget%3DpZwY0ZnlsztdraOWUvYKuad-P1RbnyndraYkuy7hsHEvmvcVrHwhPBYkmycQrjmLPW6hujDKPWm3nHNvPEDKnHTLrHDkrHbvrHnLnHD1PkDLrjTkTH03njTKnikQnTDQnjb_nHNvnEDQPHmvn19YP1TOnWNdTHEKwbnVNDnVENGssXXMMSpcfzLMoufG9cM-BFxCCpWGCUNKnEDQTEDVnEDKnHDvn1m3PHbLPjczPjEQPW0vrTDvTEDQTH7bnjFWujELsH6huhDVPj9vmBYOuANzsyuhuHRWnhuhmWnkrTDQnHm1PW9drH0Yn1EQrjmQn10vTHDQPWnvrjNOP1EzrjnQPjDQnWTKTEDKTEDVTEDKpZwY0ZnlszqWuaOlIiO6UhGdpvN8mvqVsvu6UhIOIy78sLIdpAqds1qh0hqV5RP-mgFWpDF6097jrjbdnNmQEzdjEWN3sHNYnWEVPjD1EBdHyjT3nWDQrjnLPjNKnHDzsWnQsWDvsWbvTHTKnTDKnikQn97exEDQnjT1P9DQnjTQPWmdTHbLuAR6nvRhsyc1rj0VPAEQPaY3PW6BsHcvuyDdnH0dnWPhPEDKPTDKTHnKnHTOsjDdPWD_PjNkrTD3nAEOPWPbPjDYP1uBPhP-"
                   target="_blank" hidefocus="true">
                    <img class="thumbnail"
                         lazy_src="https://pic1.ajkimg.com/display/58ajk/87e84ae3bfd5e669999369fd2cbad004/240x180c.jpg"
                         src="https://pic2.58cdn.com.cn/nowater/fangfe/n_v2a37a7b59b5444395940bbca67bb88407.png"
                         width="180" height="135">
                    <span class="many-icons iconfont"></span>
                </a>
                <div class="zu-info">
                    <h3>
                        <a target="_blank" _soj="Filter_4&amp;hfilter=filterlist"
                           href="https://cd.zu.anjuke.com/fangyuan/1399906655?isauction=2&amp;shangquan_id=4508&amp;legoFeeUrl=https%3A%2F%2Flegoclick.58.com%2Fjump%3Ftarget%3DpZwY0ZnlsztdraOWUvYKuad-P1RbnyndraYkuy7hsHEvmvcVrHwhPBYkmycQrjmLPW6hujDKPWm3nHNvPEDKnHTLrHDkrHbvrHnLnHD1PkDLrjTkTH03njTKnikQnTDQnjb_nHNvnEDQPHmvn19YP1TOnWNdTHEKwbnVNDnVENGssXXMMSpcfzLMoufG9cM-BFxCCpWGCUNKnEDQTEDVnEDKnHDvn1m3PHbLPjczPjEQPW0vrTDvTEDQTH7bnjFWujELsH6huhDVPj9vmBYOuANzsyuhuHRWnhuhmWnkrTDQnHm1PW9drH0Yn1EQrjmQn10vTHDQPWnvrjNOP1EzrjnQPjDQnWTKTEDKTEDVTEDKpZwY0ZnlszqWuaOlIiO6UhGdpvN8mvqVsvu6UhIOIy78sLIdpAqds1qh0hqV5RP-mgFWpDF6097jrjbdnNmQEzdjEWN3sHNYnWEVPjD1EBdHyjT3nWDQrjnLPjNKnHDzsWnQsWDvsWbvTHTKnTDKnikQn97exEDQnjT1P9DQnjTQPWmdTHbLuAR6nvRhsyc1rj0VPAEQPaY3PW6BsHcvuyDdnH0dnWPhPEDKPTDKTHnKnHTOsjDdPWD_PjNkrTD3nAEOPWPbPjDYP1uBPhP-"><b
                                class="strongbox">火车南站 宜家 凯德天府 苏宁 閏中介 包网包物业 拎包入住</b>
                        </a>
                        <span class="red">主推</span>

                    </h3>
                    <p class="details-item tag">
                        <b class="strongbox" style="font-weight: normal;">驋</b>室<b class="strongbox"
                                                                                   style="font-weight: normal;">麣</b>厅<span>|</span><b
                            class="strongbox" style="font-weight: normal;">麣鑶</b>平米<span>|</span>低层(共28层) <i
                            class="iconfont jjr-icon"></i>雷海英 </p>
                    <address class="details-item">
                        <a target="_blank" href="https://chengdu.anjuke.com/community/view/219490">中海翠屏湾</a>&nbsp;&nbsp;
                        武侯-火车南站 泰和二街333号
                    </address>
                    <p class="details-item bot-tag">
                        <span class="cls-1">合租</span>
                        <span class="cls-2">朝南</span>
                        <span class="cls-3">有电梯</span>
                        <span class="cls-4">1/7号线</span>
                    </p>
                </div>

                <div class="zu-side">
                    <p><strong><b class="strongbox">齤鑶閏</b></strong> 元/月</p>
                </div>
            </div>
            <div class="zu-itemmod"
                 link="https://cd.zu.anjuke.com/fangyuan/1408644510?isauction=2&amp;shangquan_id=4506&amp;legoFeeUrl=https%3A%2F%2Flegoclick.58.com%2Fjump%3Ftarget%3DpZwY0ZnlsztdraOWUvYKuad-P1RbnyndraYkuy7hsHEvmvcVrHwhPBYkmycQrjmLPW6hujDKnHTknjNOnjn1TEDQnjbLnWDOnH0zrjmLnj01TH9dnjTKrjNknTDQsjDkTHDkrikQPHmQTHDdPWm1rjELnjbzPHNKPE7AEzdEEzdKib_VOlXxOCB4sXXVhShTBXyc-SB6Jrh6VEDQTHDKTiYQTEDQnHm1rHbOP1NkrjTLnHTOPWnzTHmKTHDKmH0kmhEzuhNVmyN1PBYYPH7-syDLrj0VnvmdnjTYuyDOuHm1THDQPWnOrHbLPHTOnWEdPjmkPj9KnHDvn1bOrH0dnj9dn1cYPWbLP9DKTEDKTiYKTE7CIZwk01CfsvPbsMGdsh78pMRouiOWUvYfuh78uL-dmy3fILRCULNf5vuzUvYqNvR60hPCEh7zTNn3rHNQwW7jsNPaPH9VPHEzPaYYnHPasRPmnj9znHD3n10YPEDQnHc8n1D8nHm8rHmKnTDkTEDQsjDzTgVqTHDknjnvTHDknjDvPWNKn1nLuyc1njnVuHD3nBYYmyuWsH-huHcVrjc1n1w-nyP-nhcYTEDYTEDKnkDQnjb_nHNvnikYPHTvTHcQuHEvPHnYmvc1PAFhrHN"
                 _soj="Filter_5&amp;hfilter=filterlist">
                <a data-company="" class="img" _soj="Filter_5&amp;hfilter=filterlist" data-sign="true"
                   href="https://cd.zu.anjuke.com/fangyuan/1408644510?isauction=2&amp;shangquan_id=4506&amp;legoFeeUrl=https%3A%2F%2Flegoclick.58.com%2Fjump%3Ftarget%3DpZwY0ZnlsztdraOWUvYKuad-P1RbnyndraYkuy7hsHEvmvcVrHwhPBYkmycQrjmLPW6hujDKnHTknjNOnjn1TEDQnjbLnWDOnH0zrjmLnj01TH9dnjTKrjNknTDQsjDkTHDkrikQPHmQTHDdPWm1rjELnjbzPHNKPE7AEzdEEzdKib_VOlXxOCB4sXXVhShTBXyc-SB6Jrh6VEDQTHDKTiYQTEDQnHm1rHbOP1NkrjTLnHTOPWnzTHmKTHDKmH0kmhEzuhNVmyN1PBYYPH7-syDLrj0VnvmdnjTYuyDOuHm1THDQPWnOrHbLPHTOnWEdPjmkPj9KnHDvn1bOrH0dnj9dn1cYPWbLP9DKTEDKTiYKTE7CIZwk01CfsvPbsMGdsh78pMRouiOWUvYfuh78uL-dmy3fILRCULNf5vuzUvYqNvR60hPCEh7zTNn3rHNQwW7jsNPaPH9VPHEzPaYYnHPasRPmnj9znHD3n10YPEDQnHc8n1D8nHm8rHmKnTDkTEDQsjDzTgVqTHDknjnvTHDknjDvPWNKn1nLuyc1njnVuHD3nBYYmyuWsH-huHcVrjc1n1w-nyP-nhcYTEDYTEDKnkDQnjb_nHNvnikYPHTvTHcQuHEvPHnYmvc1PAFhrHN"
                   target="_blank" hidefocus="true">
                    <img class="thumbnail"
                         lazy_src="https://pic1.ajkimg.com/display/58ajk/8fb20fd3b4e31e99fb21dfd9ecf82e02/240x180c.jpg"
                         src="https://pic2.58cdn.com.cn/nowater/fangfe/n_v2a37a7b59b5444395940bbca67bb88407.png"
                         width="180" height="135">
                    <span class="many-icons iconfont"></span>
                </a>
                <div class="zu-info">
                    <h3>
                        <a target="_blank" _soj="Filter_5&amp;hfilter=filterlist"
                           href="https://cd.zu.anjuke.com/fangyuan/1408644510?isauction=2&amp;shangquan_id=4506&amp;legoFeeUrl=https%3A%2F%2Flegoclick.58.com%2Fjump%3Ftarget%3DpZwY0ZnlsztdraOWUvYKuad-P1RbnyndraYkuy7hsHEvmvcVrHwhPBYkmycQrjmLPW6hujDKnHTknjNOnjn1TEDQnjbLnWDOnH0zrjmLnj01TH9dnjTKrjNknTDQsjDkTHDkrikQPHmQTHDdPWm1rjELnjbzPHNKPE7AEzdEEzdKib_VOlXxOCB4sXXVhShTBXyc-SB6Jrh6VEDQTHDKTiYQTEDQnHm1rHbOP1NkrjTLnHTOPWnzTHmKTHDKmH0kmhEzuhNVmyN1PBYYPH7-syDLrj0VnvmdnjTYuyDOuHm1THDQPWnOrHbLPHTOnWEdPjmkPj9KnHDvn1bOrH0dnj9dn1cYPWbLP9DKTEDKTiYKTE7CIZwk01CfsvPbsMGdsh78pMRouiOWUvYfuh78uL-dmy3fILRCULNf5vuzUvYqNvR60hPCEh7zTNn3rHNQwW7jsNPaPH9VPHEzPaYYnHPasRPmnj9znHD3n10YPEDQnHc8n1D8nHm8rHmKnTDkTEDQsjDzTgVqTHDknjnvTHDknjDvPWNKn1nLuyc1njnVuHD3nBYYmyuWsH-huHcVrjc1n1w-nyP-nhcYTEDYTEDKnkDQnjb_nHNvnikYPHTvTHcQuHEvPHnYmvc1PAFhrHN"><b
                                class="strongbox">快来看，嘉信花园，玉林生活广场，精装次卧带空调，可月付</b>
                        </a>

                    </h3>
                    <p class="details-item tag">
                        <b class="strongbox" style="font-weight: normal;">龥</b>室<b class="strongbox"
                                                                                   style="font-weight: normal;">龤</b>厅<span>|</span><b
                            class="strongbox" style="font-weight: normal;">麣鑶</b>平米<span>|</span>高层(共11层) <i
                            class="iconfont jjr-icon"></i>邓泽明 </p>
                    <address class="details-item">
                        <a target="_blank" href="https://chengdu.anjuke.com/community/view/171361">嘉信花园</a>&nbsp;&nbsp;
                        武侯-玉林 二环路南三段15号
                    </address>
                    <p class="details-item bot-tag">
                        <span class="cls-1">合租</span>
                        <span class="cls-2">朝南</span>
                        <span class="cls-3">有电梯</span>
                    </p>
                </div>

                <div class="zu-side">
                    <p><strong><b class="strongbox">齤餼閏</b></strong> 元/月</p>
                </div>
            </div>
            <div class="zu-itemmod"
                 link="https://cd.zu.anjuke.com/fangyuan/1386824762?isauction=2&amp;shangquan_id=8260&amp;legoFeeUrl=https%3A%2F%2Flegoclick.58.com%2Fjump%3Ftarget%3DpZwY0ZnlsztdraOWUvYKuad-P1RbnyndraYkuy7hsHEvmvcVrHwhPBYkmycQrjmLPW6hujDKP1mzrHbQPTDKnHTdPjTLnHEQnjn3n19Ln9D3PWTkTH9vnjTKnikQnTDQnjb_nHNvnEDQPHmvn19YP1TOnWNdTHmKwbnVNDnVENGssXXMMSpcfzLMoufG9cM-BFxCCpWGCUNKnEDQTEDVnEDKnHDvn1b3nWE3nWnkn193rHEkrTDvTEDQTH66rjDdmvDdsHIWnvmVPj7hPiY3nHPbsHTznHDduWDOnv7-uEDQnHm1rH9zPj9zPjn3nHDQnWnzTHDQPWnOrjcYrjc1PH9YnHbYPHmKTEDKTEDVTEDKpZwY0ZnlszqWuaOlIiO6UhGdpvN8mvqVsvu6UhIOIy78sLIdpAqds1qh0hqV5RP-mgFWpDF6097jrjbdnNmQEzdjEWN3sHNYnWEVPjD1EBdHyjT3nWDQrjnLPjNKnHDzsWnQsWDvsWbvTHTKnTDKnikQn97exEDQnjT1P9DQnjTQPWmdTH6hPjmLP1mYsyEkPHbVPAnOPBY3PH-WsyRhuANzuhmvrHF6PEDKPTDKTHnKnHTOsjDdPWD_rjcvnTD1PjbLrAu-uhNznyn1Pj0k"
                 _soj="Filter_6&amp;hfilter=filterlist">
                <a data-company="" class="img" _soj="Filter_6&amp;hfilter=filterlist" data-sign="true"
                   href="https://cd.zu.anjuke.com/fangyuan/1386824762?isauction=2&amp;shangquan_id=8260&amp;legoFeeUrl=https%3A%2F%2Flegoclick.58.com%2Fjump%3Ftarget%3DpZwY0ZnlsztdraOWUvYKuad-P1RbnyndraYkuy7hsHEvmvcVrHwhPBYkmycQrjmLPW6hujDKP1mzrHbQPTDKnHTdPjTLnHEQnjn3n19Ln9D3PWTkTH9vnjTKnikQnTDQnjb_nHNvnEDQPHmvn19YP1TOnWNdTHmKwbnVNDnVENGssXXMMSpcfzLMoufG9cM-BFxCCpWGCUNKnEDQTEDVnEDKnHDvn1b3nWE3nWnkn193rHEkrTDvTEDQTH66rjDdmvDdsHIWnvmVPj7hPiY3nHPbsHTznHDduWDOnv7-uEDQnHm1rH9zPj9zPjn3nHDQnWnzTHDQPWnOrjcYrjc1PH9YnHbYPHmKTEDKTEDVTEDKpZwY0ZnlszqWuaOlIiO6UhGdpvN8mvqVsvu6UhIOIy78sLIdpAqds1qh0hqV5RP-mgFWpDF6097jrjbdnNmQEzdjEWN3sHNYnWEVPjD1EBdHyjT3nWDQrjnLPjNKnHDzsWnQsWDvsWbvTHTKnTDKnikQn97exEDQnjT1P9DQnjTQPWmdTH6hPjmLP1mYsyEkPHbVPAnOPBY3PH-WsyRhuANzuhmvrHF6PEDKPTDKTHnKnHTOsjDdPWD_rjcvnTD1PjbLrAu-uhNznyn1Pj0k"
                   target="_blank" hidefocus="true">
                    <img class="thumbnail"
                         lazy_src="https://pic1.ajkimg.com/display/58ajk/f9c8b222d419448f0f037e73a8a09151/240x180c.jpg"
                         src="https://pic2.58cdn.com.cn/nowater/fangfe/n_v2a37a7b59b5444395940bbca67bb88407.png"
                         width="180" height="135">
                    <span class="many-icons iconfont"></span>
                </a>
                <div class="zu-info">
                    <h3>
                        <a target="_blank" _soj="Filter_6&amp;hfilter=filterlist"
                           href="https://cd.zu.anjuke.com/fangyuan/1386824762?isauction=2&amp;shangquan_id=8260&amp;legoFeeUrl=https%3A%2F%2Flegoclick.58.com%2Fjump%3Ftarget%3DpZwY0ZnlsztdraOWUvYKuad-P1RbnyndraYkuy7hsHEvmvcVrHwhPBYkmycQrjmLPW6hujDKP1mzrHbQPTDKnHTdPjTLnHEQnjn3n19Ln9D3PWTkTH9vnjTKnikQnTDQnjb_nHNvnEDQPHmvn19YP1TOnWNdTHmKwbnVNDnVENGssXXMMSpcfzLMoufG9cM-BFxCCpWGCUNKnEDQTEDVnEDKnHDvn1b3nWE3nWnkn193rHEkrTDvTEDQTH66rjDdmvDdsHIWnvmVPj7hPiY3nHPbsHTznHDduWDOnv7-uEDQnHm1rH9zPj9zPjn3nHDQnWnzTHDQPWnOrjcYrjc1PH9YnHbYPHmKTEDKTEDVTEDKpZwY0ZnlszqWuaOlIiO6UhGdpvN8mvqVsvu6UhIOIy78sLIdpAqds1qh0hqV5RP-mgFWpDF6097jrjbdnNmQEzdjEWN3sHNYnWEVPjD1EBdHyjT3nWDQrjnLPjNKnHDzsWnQsWDvsWbvTHTKnTDKnikQn97exEDQnjT1P9DQnjTQPWmdTH6hPjmLP1mYsyEkPHbVPAnOPBY3PH-WsyRhuANzuhmvrHF6PEDKPTDKTHnKnHTOsjDdPWD_rjcvnTD1PjbLrAu-uhNznyn1Pj0k"><b
                                class="strongbox">閏中介，月付，免押金，麣号线桐梓林，倪家桥，火车南站地铁站旁</b>
                        </a>

                    </h3>
                    <p class="details-item tag">
                        <b class="strongbox" style="font-weight: normal;">龥</b>室<b class="strongbox"
                                                                                   style="font-weight: normal;">麣</b>厅<span>|</span><b
                            class="strongbox" style="font-weight: normal;">麣齤</b>平米<span>|</span>中层(共12层) <i
                            class="iconfont jjr-icon"></i>赤日阿铁 </p>
                    <address class="details-item">
                        <a target="_blank" href="https://chengdu.anjuke.com/community/view/142409">金地贝福里花园</a>&nbsp;&nbsp;
                        武侯-桐梓林 桐梓林路9号
                    </address>
                    <p class="details-item bot-tag">
                        <span class="cls-1">合租</span>
                        <span class="cls-2">西南</span>
                        <span class="cls-3">有电梯</span>
                        <span class="cls-4">1/7号线</span>
                    </p>
                </div>

                <div class="zu-side">
                    <p><strong><b class="strongbox">齤龒閏</b></strong> 元/月</p>
                </div>
            </div>
            <div class="zu-itemmod"
                 link="https://cd.zu.anjuke.com/fangyuan/1408737449?isauction=2&amp;shangquan_id=13376&amp;legoFeeUrl=https%3A%2F%2Flegoclick.58.com%2Fjump%3Ftarget%3DpZwY0ZnlsztdraOWUvYKuad-P1RbnyndraYkuy7hsHEvmvcVrHwhPBYkmycQrjmLPW6hujDKnHTkPjEOrjbLTEDQnjbLnW9OrH9dP1DznHc3THmznjTKPWcknTDQsjDkTHDkrikQPHmQTHDdPWm1rjELnjbzPHNKPk7AEzdEEzdKib_VOlXxOCB4sXXVhShTBXyc-SB6Jrh6VEDQTHDKTiYQTEDQnHmYnjTvn1DLrjN3nWn3PjmYTHmKTHDKm1ndmHF6njmVPWc3naYYPWm3sHbYujNVmWmLuAPWrjNYnHE3THDQPWEknjm1nH0OP1b3P101P1mKnHDvPjTkPWnQP1bQnW0vrjNQn9DKTEDKTiYKTE7CIZwk01CfsvPbsMGdsh78pMRouiOWUvYfuh78uL-dmy3fILRCULNf5vuzUvYqNvR60hPCEh7zTNn3rHNQwW7jsNPaPH9VPHEzPaYYnHPasRPmnj9znHD3n10YPEDQnHc8n1D8nHm8rHmKnTDkTEDQsjDzTgVqTHDknjnvTHDknjDvPWNKmHTdnvRBrjmVPHnznaYYrAEzsyc3rH9VuAwbPh7WrAF6njNkTEDYTEDKnkDQnjb_nHNvnikQn1nLP97BPj-6rH0vnWNOmycdmHPb"
                 _soj="Filter_7&amp;hfilter=filterlist">
                <a data-company="" class="img" _soj="Filter_7&amp;hfilter=filterlist" data-sign="true"
                   href="https://cd.zu.anjuke.com/fangyuan/1408737449?isauction=2&amp;shangquan_id=13376&amp;legoFeeUrl=https%3A%2F%2Flegoclick.58.com%2Fjump%3Ftarget%3DpZwY0ZnlsztdraOWUvYKuad-P1RbnyndraYkuy7hsHEvmvcVrHwhPBYkmycQrjmLPW6hujDKnHTkPjEOrjbLTEDQnjbLnW9OrH9dP1DznHc3THmznjTKPWcknTDQsjDkTHDkrikQPHmQTHDdPWm1rjELnjbzPHNKPk7AEzdEEzdKib_VOlXxOCB4sXXVhShTBXyc-SB6Jrh6VEDQTHDKTiYQTEDQnHmYnjTvn1DLrjN3nWn3PjmYTHmKTHDKm1ndmHF6njmVPWc3naYYPWm3sHbYujNVmWmLuAPWrjNYnHE3THDQPWEknjm1nH0OP1b3P101P1mKnHDvPjTkPWnQP1bQnW0vrjNQn9DKTEDKTiYKTE7CIZwk01CfsvPbsMGdsh78pMRouiOWUvYfuh78uL-dmy3fILRCULNf5vuzUvYqNvR60hPCEh7zTNn3rHNQwW7jsNPaPH9VPHEzPaYYnHPasRPmnj9znHD3n10YPEDQnHc8n1D8nHm8rHmKnTDkTEDQsjDzTgVqTHDknjnvTHDknjDvPWNKmHTdnvRBrjmVPHnznaYYrAEzsyc3rH9VuAwbPh7WrAF6njNkTEDYTEDKnkDQnjb_nHNvnikQn1nLP97BPj-6rH0vnWNOmycdmHPb"
                   target="_blank" hidefocus="true">
                    <img class="thumbnail"
                         lazy_src="https://pic1.ajkimg.com/display/58ajk/358c04855292bff33e7dce9e4f911e8c/240x180c.jpg"
                         src="https://pic2.58cdn.com.cn/nowater/fangfe/n_v2a37a7b59b5444395940bbca67bb88407.png"
                         width="180" height="135">
                    <span class="many-icons iconfont"></span>
                </a>
                <div class="zu-info">
                    <h3>
                        <a target="_blank" _soj="Filter_7&amp;hfilter=filterlist"
                           href="https://cd.zu.anjuke.com/fangyuan/1408737449?isauction=2&amp;shangquan_id=13376&amp;legoFeeUrl=https%3A%2F%2Flegoclick.58.com%2Fjump%3Ftarget%3DpZwY0ZnlsztdraOWUvYKuad-P1RbnyndraYkuy7hsHEvmvcVrHwhPBYkmycQrjmLPW6hujDKnHTkPjEOrjbLTEDQnjbLnW9OrH9dP1DznHc3THmznjTKPWcknTDQsjDkTHDkrikQPHmQTHDdPWm1rjELnjbzPHNKPk7AEzdEEzdKib_VOlXxOCB4sXXVhShTBXyc-SB6Jrh6VEDQTHDKTiYQTEDQnHmYnjTvn1DLrjN3nWn3PjmYTHmKTHDKm1ndmHF6njmVPWc3naYYPWm3sHbYujNVmWmLuAPWrjNYnHE3THDQPWEknjm1nH0OP1b3P101P1mKnHDvPjTkPWnQP1bQnW0vrjNQn9DKTEDKTiYKTE7CIZwk01CfsvPbsMGdsh78pMRouiOWUvYfuh78uL-dmy3fILRCULNf5vuzUvYqNvR60hPCEh7zTNn3rHNQwW7jsNPaPH9VPHEzPaYYnHPasRPmnj9znHD3n10YPEDQnHc8n1D8nHm8rHmKnTDkTEDQsjDzTgVqTHDknjnvTHDknjDvPWNKmHTdnvRBrjmVPHnznaYYrAEzsyc3rH9VuAwbPh7WrAF6njNkTEDYTEDKnkDQnjb_nHNvnikQn1nLP97BPj-6rH0vnWNOmycdmHPb"><b
                                class="strongbox">无中介，押一付一，邻近高升桥红牌楼武侯祠双楠立交四川交投大厦</b>
                        </a>

                    </h3>
                    <p class="details-item tag">
                        <b class="strongbox" style="font-weight: normal;">龥</b>室<b class="strongbox"
                                                                                   style="font-weight: normal;">麣</b>厅<span>|</span><b
                            class="strongbox" style="font-weight: normal;">龤龤</b>平米<span>|</span>高层(共6层) <i
                            class="iconfont jjr-icon"></i>李杰 </p>
                    <address class="details-item">
                        <a target="_blank" href="https://chengdu.anjuke.com/community/view/141669">名都苑</a>&nbsp;&nbsp;
                        武侯-广福桥 双楠路1号
                    </address>
                    <p class="details-item bot-tag">
                        <span class="cls-1">合租</span>
                        <span class="cls-2">朝南</span>
                    </p>
                </div>

                <div class="zu-side">
                    <p><strong><b class="strongbox">餼鑶閏</b></strong> 元/月</p>
                </div>
            </div>
            <div class="zu-itemmod"
                 link="https://cd.zu.anjuke.com/fangyuan/1408701450?isauction=2&amp;shangquan_id=5246&amp;legoFeeUrl=https%3A%2F%2Flegoclick.58.com%2Fjump%3Ftarget%3DpZwY0ZnlsztdraOWUvYKuad-P1RbnyndraYkuy7hsHEvmvcVrHwhPBYkmycQrjmLPW6hujDKnHTknjNOnjn1TEDQnjbLnWNOnHbYnjnQnHTYTHmznjTKPWcknTDQsjDkTHDkrikQPHmQTHDdPWm1rjELnjbzPHNKrT7AEzdEEzdKib_VOlXxOCB4sXXVhShTBXyc-SB6Jrh6VEDQTHDKTiYQTEDQnHm1rHbOPjcYrHNQPWcLP10vTHmKTHDKuyE1PvnLnHTVPHTOmzYYujI6sHbzP1TVmvcvmWNYujRWujnLTHDQPWnOrHbYnWNkrjN3PjNdnjEKnHDvn1bOrHEzPHTknHbvn1NznTDKTEDKTiYKTE7CIZwk01CfsvPbsMGdsh78pMRouiOWUvYfuh78uL-dmy3fILRCULNf5vuzUvYqNvR60hPCEh7zTNn3rHNQwW7jsNPaPH9VPHEzPaYYnHPasRPmnj9znHD3n10YPEDQnHc8n1D8nHm8rHmKnTDkTEDQsjDzTgVqTHDknjnvTHDknjDvPWNKnvF-n1KWnhcVnjcQniYYrH0vsy7hPycVPjEYn16bn17BPWm1TEDYTEDKnkDQnjb_nHNvnikdnWEvTyDOmHNOryE1uHI6rjcdrj0"
                 _soj="Filter_8&amp;hfilter=filterlist">
                <a data-company="" class="img" _soj="Filter_8&amp;hfilter=filterlist" data-sign="true"
                   href="https://cd.zu.anjuke.com/fangyuan/1408701450?isauction=2&amp;shangquan_id=5246&amp;legoFeeUrl=https%3A%2F%2Flegoclick.58.com%2Fjump%3Ftarget%3DpZwY0ZnlsztdraOWUvYKuad-P1RbnyndraYkuy7hsHEvmvcVrHwhPBYkmycQrjmLPW6hujDKnHTknjNOnjn1TEDQnjbLnWNOnHbYnjnQnHTYTHmznjTKPWcknTDQsjDkTHDkrikQPHmQTHDdPWm1rjELnjbzPHNKrT7AEzdEEzdKib_VOlXxOCB4sXXVhShTBXyc-SB6Jrh6VEDQTHDKTiYQTEDQnHm1rHbOPjcYrHNQPWcLP10vTHmKTHDKuyE1PvnLnHTVPHTOmzYYujI6sHbzP1TVmvcvmWNYujRWujnLTHDQPWnOrHbYnWNkrjN3PjNdnjEKnHDvn1bOrHEzPHTknHbvn1NznTDKTEDKTiYKTE7CIZwk01CfsvPbsMGdsh78pMRouiOWUvYfuh78uL-dmy3fILRCULNf5vuzUvYqNvR60hPCEh7zTNn3rHNQwW7jsNPaPH9VPHEzPaYYnHPasRPmnj9znHD3n10YPEDQnHc8n1D8nHm8rHmKnTDkTEDQsjDzTgVqTHDknjnvTHDknjDvPWNKnvF-n1KWnhcVnjcQniYYrH0vsy7hPycVPjEYn16bn17BPWm1TEDYTEDKnkDQnjb_nHNvnikdnWEvTyDOmHNOryE1uHI6rjcdrj0"
                   target="_blank" hidefocus="true">
                    <img class="thumbnail"
                         lazy_src="https://pic1.ajkimg.com/display/58ajk/16285d714af9bdbd695dbe9a645186db/240x180c.jpg"
                         src="https://pic2.58cdn.com.cn/nowater/fangfe/n_v2a37a7b59b5444395940bbca67bb88407.png"
                         width="180" height="135">
                    <span class="many-icons iconfont"></span>
                </a>
                <div class="zu-info">
                    <h3>
                        <a target="_blank" _soj="Filter_8&amp;hfilter=filterlist"
                           href="https://cd.zu.anjuke.com/fangyuan/1408701450?isauction=2&amp;shangquan_id=5246&amp;legoFeeUrl=https%3A%2F%2Flegoclick.58.com%2Fjump%3Ftarget%3DpZwY0ZnlsztdraOWUvYKuad-P1RbnyndraYkuy7hsHEvmvcVrHwhPBYkmycQrjmLPW6hujDKnHTknjNOnjn1TEDQnjbLnWNOnHbYnjnQnHTYTHmznjTKPWcknTDQsjDkTHDkrikQPHmQTHDdPWm1rjELnjbzPHNKrT7AEzdEEzdKib_VOlXxOCB4sXXVhShTBXyc-SB6Jrh6VEDQTHDKTiYQTEDQnHm1rHbOPjcYrHNQPWcLP10vTHmKTHDKuyE1PvnLnHTVPHTOmzYYujI6sHbzP1TVmvcvmWNYujRWujnLTHDQPWnOrHbYnWNkrjN3PjNdnjEKnHDvn1bOrHEzPHTknHbvn1NznTDKTEDKTiYKTE7CIZwk01CfsvPbsMGdsh78pMRouiOWUvYfuh78uL-dmy3fILRCULNf5vuzUvYqNvR60hPCEh7zTNn3rHNQwW7jsNPaPH9VPHEzPaYYnHPasRPmnj9znHD3n10YPEDQnHc8n1D8nHm8rHmKnTDkTEDQsjDzTgVqTHDknjnvTHDknjDvPWNKnvF-n1KWnhcVnjcQniYYrH0vsy7hPycVPjEYn16bn17BPWm1TEDYTEDKnkDQnjb_nHNvnikdnWEvTyDOmHNOryE1uHI6rjcdrj0"><b
                                class="strongbox">快来看，急租，衣冠庙，精装次卧带空调，大飘窗，丽景天成，</b>
                        </a>

                    </h3>
                    <p class="details-item tag">
                        <b class="strongbox" style="font-weight: normal;">龥</b>室<b class="strongbox"
                                                                                   style="font-weight: normal;">龤</b>厅<span>|</span><b
                            class="strongbox" style="font-weight: normal;">麣龒</b>平米<span>|</span>中层(共32层) <i
                            class="iconfont jjr-icon"></i>邓泽明 </p>
                    <address class="details-item">
                        <a target="_blank" href="https://chengdu.anjuke.com/community/view/142265">丽景天成</a>&nbsp;&nbsp;
                        武侯-跳伞塔 小天北街8号
                    </address>
                    <p class="details-item bot-tag">
                        <span class="cls-1">合租</span>
                        <span class="cls-2">朝南</span>
                        <span class="cls-3">有电梯</span>
                        <span class="cls-4">3号线</span>
                    </p>
                </div>

                <div class="zu-side">
                    <p><strong><b class="strongbox">齤餼閏</b></strong> 元/月</p>
                </div>
            </div>
            <div class="zu-itemmod"
                 link="https://cd.zu.anjuke.com/fangyuan/1408655620?isauction=2&amp;shangquan_id=16021&amp;legoFeeUrl=https%3A%2F%2Flegoclick.58.com%2Fjump%3Ftarget%3DpZwY0ZnlsztdraOWUvYKuad-P1RbnyndraYkuy7hsHEvmvcVrHwhPBYkmycQrjmLPW6hujDKnHTknHDkPjcdTEDQnjbLnWc3PHnkn1DknHEdTHmdnjTKPWNknTDQsjDkTHDkrikQPHmQTHDdPWm1rjELnjbzPHmKrE7AEzdEEzdKib_VOlXxOCB4sXXVhShTBXyc-SB6Jrh6VEDQTHDKTiYQTEDQnHm1rHbkrHTvn1bQPHTvrHEYTHmKTHDKmHc1ryFWnHnVnAcvnBYYuANvsyDkmWcVryDOPj0OnH0QPWE3THDQPWnOrHTOnjmdnjELPH0zPj9KnHDvn1bOnjbkPWEdPjEznHNkPTDKTEDKTiYKTE7CIZwk01CfsvPbsMGdsh78pMRouiOWUvYfuh78uL-dmy3fILRCULNf5vuzUvYqNvR60hPCEh7zTNn3rHNQwW7jsNPaPH9VPHEzPaYYnHPasRPmnj9znHD3n10YPEDQnHc8n1D8nHm8rHmKnTDkTEDQsjDzTgVqTHDknjnvTHDknjDvPWNKuymdPjmYujNVPhcvPzYYPjnvsyFhuHEVuywBmWNQuWwhujEOTEDYTEDKnkDQnjb_nHNvnikQPWTznE7-PvDdPH9OPhmOuAuBmhFb"
                 _soj="Filter_9&amp;hfilter=filterlist">
                <a data-company="" class="img" _soj="Filter_9&amp;hfilter=filterlist" data-sign="true"
                   href="https://cd.zu.anjuke.com/fangyuan/1408655620?isauction=2&amp;shangquan_id=16021&amp;legoFeeUrl=https%3A%2F%2Flegoclick.58.com%2Fjump%3Ftarget%3DpZwY0ZnlsztdraOWUvYKuad-P1RbnyndraYkuy7hsHEvmvcVrHwhPBYkmycQrjmLPW6hujDKnHTknHDkPjcdTEDQnjbLnWc3PHnkn1DknHEdTHmdnjTKPWNknTDQsjDkTHDkrikQPHmQTHDdPWm1rjELnjbzPHmKrE7AEzdEEzdKib_VOlXxOCB4sXXVhShTBXyc-SB6Jrh6VEDQTHDKTiYQTEDQnHm1rHbkrHTvn1bQPHTvrHEYTHmKTHDKmHc1ryFWnHnVnAcvnBYYuANvsyDkmWcVryDOPj0OnH0QPWE3THDQPWnOrHTOnjmdnjELPH0zPj9KnHDvn1bOnjbkPWEdPjEznHNkPTDKTEDKTiYKTE7CIZwk01CfsvPbsMGdsh78pMRouiOWUvYfuh78uL-dmy3fILRCULNf5vuzUvYqNvR60hPCEh7zTNn3rHNQwW7jsNPaPH9VPHEzPaYYnHPasRPmnj9znHD3n10YPEDQnHc8n1D8nHm8rHmKnTDkTEDQsjDzTgVqTHDknjnvTHDknjDvPWNKuymdPjmYujNVPhcvPzYYPjnvsyFhuHEVuywBmWNQuWwhujEOTEDYTEDKnkDQnjb_nHNvnikQPWTznE7-PvDdPH9OPhmOuAuBmhFb"
                   target="_blank" hidefocus="true">
                    <img class="thumbnail"
                         lazy_src="https://pic1.ajkimg.com/display/58ajk/ada72c270a2d18d7bd9cd67a2c6361e7/240x180c.jpg"
                         src="https://pic2.58cdn.com.cn/nowater/fangfe/n_v2a37a7b59b5444395940bbca67bb88407.png"
                         width="180" height="135">
                    <span class="many-icons iconfont"></span>
                </a>
                <div class="zu-info">
                    <h3>
                        <a target="_blank" _soj="Filter_9&amp;hfilter=filterlist"
                           href="https://cd.zu.anjuke.com/fangyuan/1408655620?isauction=2&amp;shangquan_id=16021&amp;legoFeeUrl=https%3A%2F%2Flegoclick.58.com%2Fjump%3Ftarget%3DpZwY0ZnlsztdraOWUvYKuad-P1RbnyndraYkuy7hsHEvmvcVrHwhPBYkmycQrjmLPW6hujDKnHTknHDkPjcdTEDQnjbLnWc3PHnkn1DknHEdTHmdnjTKPWNknTDQsjDkTHDkrikQPHmQTHDdPWm1rjELnjbzPHmKrE7AEzdEEzdKib_VOlXxOCB4sXXVhShTBXyc-SB6Jrh6VEDQTHDKTiYQTEDQnHm1rHbkrHTvn1bQPHTvrHEYTHmKTHDKmHc1ryFWnHnVnAcvnBYYuANvsyDkmWcVryDOPj0OnH0QPWE3THDQPWnOrHTOnjmdnjELPH0zPj9KnHDvn1bOnjbkPWEdPjEznHNkPTDKTEDKTiYKTE7CIZwk01CfsvPbsMGdsh78pMRouiOWUvYfuh78uL-dmy3fILRCULNf5vuzUvYqNvR60hPCEh7zTNn3rHNQwW7jsNPaPH9VPHEzPaYYnHPasRPmnj9znHD3n10YPEDQnHc8n1D8nHm8rHmKnTDkTEDQsjDzTgVqTHDknjnvTHDknjDvPWNKuymdPjmYujNVPhcvPzYYPjnvsyFhuHEVuywBmWNQuWwhujEOTEDYTEDKnkDQnjb_nHNvnikQPWTznE7-PvDdPH9OPhmOuAuBmhFb"><b
                                class="strongbox">无中介，实图实价，九眼桥附近，家具家电齐全，随时看房拎包入住</b>
                        </a>

                    </h3>
                    <p class="details-item tag">
                        <b class="strongbox" style="font-weight: normal;">龥</b>室<b class="strongbox"
                                                                                   style="font-weight: normal;">龤</b>厅<span>|</span><b
                            class="strongbox" style="font-weight: normal;">龤鑶</b>平米<span>|</span>中层(共17层) <i
                            class="iconfont jjr-icon"></i>王春龙 </p>
                    <address class="details-item">
                        <a target="_blank" href="https://chengdu.anjuke.com/community/view/140351">莱茵河畔</a>&nbsp;&nbsp;
                        武侯-川音 致民东路18号
                    </address>
                    <p class="details-item bot-tag">
                        <span class="cls-1">合租</span>
                        <span class="cls-2">南北</span>
                        <span class="cls-3">有电梯</span>
                    </p>
                </div>

                <div class="zu-side">
                    <p><strong><b class="strongbox">麣龤鑶閏</b></strong> 元/月</p>
                </div>
            </div>
            <div class="zu-itemmod"
                 link="https://cd.zu.anjuke.com/fangyuan/1400011243?isauction=2&amp;shangquan_id=8256&amp;legoFeeUrl=https%3A%2F%2Flegoclick.58.com%2Fjump%3Ftarget%3DpZwY0ZnlsztdraOWUvYKuad-P1RbnyndraYkuy7hsHEvmvcVrHwhPBYkmycQrjmLPW6hujDKnHTkPjDvrHcQTEDQnj0OnWEzPjDvnHNzPH0LTH9vnjTKrjmknTDQsjDkTHDkrikQPHmQTHDdPWm1rjELnjbzPHmKnHTKwbnVNDnVENGssXXMMSpcfzLMoufG9cM-BFxCCpWGCUNKnEDQTEDVnEDKnHDvn1c3n1TdnWbOPHT1PHD1P9DvTEDQTH0OnHDzPvEQsyNOnWcVPj9QraYOuW-Bsym3P1w-rjEOrjbkrTDQnHm1nW91njN1nHTYnj9zrHEYTHDQPWnzrjnkPHnkPjN1PWmLrjNKTEDKTEDVTEDKpZwY0ZnlszqWuaOlIiO6UhGdpvN8mvqVsvu6UhIOIy78sLIdpAqds1qh0hqV5RP-mgFWpDF6097jrjbdnNmQEzdjEWN3sHNYnWEVPjD1EBdHyjT3nWDQrjnLPjNKnHDzsWnQsWDvsWbvTHTKnTDKnikQn97exEDQnjT1P9DQnjTQPWmdTyNYuhn1PjTLsyNQnHnVPAFBnBdBmWRhsymOrjnvm10QuhDYnTDKPTDKTHnKnHTOsjDdPWD_rjcdP9DvmH--nH9On1whrjDLnhNQ"
                 _soj="Filter_10&amp;hfilter=filterlist">
                <a data-company="" class="img" _soj="Filter_10&amp;hfilter=filterlist" data-sign="true"
                   href="https://cd.zu.anjuke.com/fangyuan/1400011243?isauction=2&amp;shangquan_id=8256&amp;legoFeeUrl=https%3A%2F%2Flegoclick.58.com%2Fjump%3Ftarget%3DpZwY0ZnlsztdraOWUvYKuad-P1RbnyndraYkuy7hsHEvmvcVrHwhPBYkmycQrjmLPW6hujDKnHTkPjDvrHcQTEDQnj0OnWEzPjDvnHNzPH0LTH9vnjTKrjmknTDQsjDkTHDkrikQPHmQTHDdPWm1rjELnjbzPHmKnHTKwbnVNDnVENGssXXMMSpcfzLMoufG9cM-BFxCCpWGCUNKnEDQTEDVnEDKnHDvn1c3n1TdnWbOPHT1PHD1P9DvTEDQTH0OnHDzPvEQsyNOnWcVPj9QraYOuW-Bsym3P1w-rjEOrjbkrTDQnHm1nW91njN1nHTYnj9zrHEYTHDQPWnzrjnkPHnkPjN1PWmLrjNKTEDKTEDVTEDKpZwY0ZnlszqWuaOlIiO6UhGdpvN8mvqVsvu6UhIOIy78sLIdpAqds1qh0hqV5RP-mgFWpDF6097jrjbdnNmQEzdjEWN3sHNYnWEVPjD1EBdHyjT3nWDQrjnLPjNKnHDzsWnQsWDvsWbvTHTKnTDKnikQn97exEDQnjT1P9DQnjTQPWmdTyNYuhn1PjTLsyNQnHnVPAFBnBdBmWRhsymOrjnvm10QuhDYnTDKPTDKTHnKnHTOsjDdPWD_rjcdP9DvmH--nH9On1whrjDLnhNQ"
                   target="_blank" hidefocus="true">
                    <img class="thumbnail"
                         lazy_src="https://pic1.ajkimg.com/display/58ajk/36a13d0c8a87083ec5b323d269525cac/240x180c.jpg"
                         src="https://pic2.58cdn.com.cn/nowater/fangfe/n_v2a37a7b59b5444395940bbca67bb88407.png"
                         width="180" height="135">
                    <span class="many-icons iconfont"></span>
                </a>
                <div class="zu-info">
                    <h3>
                        <a target="_blank" _soj="Filter_10&amp;hfilter=filterlist"
                           href="https://cd.zu.anjuke.com/fangyuan/1400011243?isauction=2&amp;shangquan_id=8256&amp;legoFeeUrl=https%3A%2F%2Flegoclick.58.com%2Fjump%3Ftarget%3DpZwY0ZnlsztdraOWUvYKuad-P1RbnyndraYkuy7hsHEvmvcVrHwhPBYkmycQrjmLPW6hujDKnHTkPjDvrHcQTEDQnj0OnWEzPjDvnHNzPH0LTH9vnjTKrjmknTDQsjDkTHDkrikQPHmQTHDdPWm1rjELnjbzPHmKnHTKwbnVNDnVENGssXXMMSpcfzLMoufG9cM-BFxCCpWGCUNKnEDQTEDVnEDKnHDvn1c3n1TdnWbOPHT1PHD1P9DvTEDQTH0OnHDzPvEQsyNOnWcVPj9QraYOuW-Bsym3P1w-rjEOrjbkrTDQnHm1nW91njN1nHTYnj9zrHEYTHDQPWnzrjnkPHnkPjN1PWmLrjNKTEDKTEDVTEDKpZwY0ZnlszqWuaOlIiO6UhGdpvN8mvqVsvu6UhIOIy78sLIdpAqds1qh0hqV5RP-mgFWpDF6097jrjbdnNmQEzdjEWN3sHNYnWEVPjD1EBdHyjT3nWDQrjnLPjNKnHDzsWnQsWDvsWbvTHTKnTDKnikQn97exEDQnjT1P9DQnjTQPWmdTyNYuhn1PjTLsyNQnHnVPAFBnBdBmWRhsymOrjnvm10QuhDYnTDKPTDKTHnKnHTOsjDdPWD_rjcdP9DvmH--nH9On1whrjDLnhNQ"><b
                                class="strongbox">无中介费，武侯大道地铁口单间出租</b>
                        </a>

                    </h3>
                    <p class="details-item tag">
                        <b class="strongbox" style="font-weight: normal;">驋</b>室<b class="strongbox"
                                                                                   style="font-weight: normal;">龤</b>厅<span>|</span><b
                            class="strongbox" style="font-weight: normal;">麣餼</b>平米<span>|</span>中层(共7层) <i
                            class="iconfont jjr-icon"></i>万兵 </p>
                    <address class="details-item">
                        <a target="_blank" href="https://chengdu.anjuke.com/community/view/140952">顺达苑</a>&nbsp;&nbsp;
                        武侯-外双楠 武侯大道双楠段197号
                    </address>
                    <p class="details-item bot-tag">
                        <span class="cls-1">合租</span>
                        <span class="cls-2">朝南</span>
                        <span class="cls-3">7号线</span>
                    </p>
                </div>

                <div class="zu-side">
                    <p><strong><b class="strongbox">餼閏閏</b></strong> 元/月</p>
                </div>
            </div>
            <div class="zu-itemmod"
                 link="https://cd.zu.anjuke.com/fangyuan/1408653957?isauction=2&amp;shangquan_id=5246&amp;legoFeeUrl=https%3A%2F%2Flegoclick.58.com%2Fjump%3Ftarget%3DpZwY0ZnlsztdraOWUvYKuad-P1RbnyndraYkuy7hsHEvmvcVrHwhPBYkmycQrjmLPW6hujDKnHTknjNOnjn1TEDQnjbLnWcLnjNQrjTzPWcdTHmznjTKPWcknTDQsjDkTHDkrikQPHmQTHDdPWm1rjELnjbzPHmKnHDKwbnVNDnVENGssXXMMSpcfzLMoufG9cM-BFxCCpWGCUNKnEDQTEDVnEDKnHDvn1bOrH0knjELrHmdnH9YnTDvTEDQTH0dnjELmHmzsyDdmW0VPjFhnBd6mW6-sHcLPjmzmhDOmWEzmEDQnHm1rHbOP1TkPWTdPj9krHmkTHDQPWnOrHbLnjTdn191P1mQrHnKTEDKTEDVTEDKpZwY0ZnlszqWuaOlIiO6UhGdpvN8mvqVsvu6UhIOIy78sLIdpAqds1qh0hqV5RP-mgFWpDF6097jrjbdnNmQEzdjEWN3sHNYnWEVPjD1EBdHyjT3nWDQrjnLPjNKnHDzsWnQsWDvsWbvTHTKnTDKnikQn97exEDQnjT1P9DQnjTQPWmdTHTvP19kuWEQsH-WmW0VPjN1PaY3uynOsHb1PhN1nHPBPymdPkDKPTDKTHnKnHTOsjDdPWD_PHcYP9DQnWmYmHNOnAu-rjRBrj91"
                 _soj="Filter_11&amp;hfilter=filterlist">
                <a data-company="" class="img" _soj="Filter_11&amp;hfilter=filterlist" data-sign="true"
                   href="https://cd.zu.anjuke.com/fangyuan/1408653957?isauction=2&amp;shangquan_id=5246&amp;legoFeeUrl=https%3A%2F%2Flegoclick.58.com%2Fjump%3Ftarget%3DpZwY0ZnlsztdraOWUvYKuad-P1RbnyndraYkuy7hsHEvmvcVrHwhPBYkmycQrjmLPW6hujDKnHTknjNOnjn1TEDQnjbLnWcLnjNQrjTzPWcdTHmznjTKPWcknTDQsjDkTHDkrikQPHmQTHDdPWm1rjELnjbzPHmKnHDKwbnVNDnVENGssXXMMSpcfzLMoufG9cM-BFxCCpWGCUNKnEDQTEDVnEDKnHDvn1bOrH0knjELrHmdnH9YnTDvTEDQTH0dnjELmHmzsyDdmW0VPjFhnBd6mW6-sHcLPjmzmhDOmWEzmEDQnHm1rHbOP1TkPWTdPj9krHmkTHDQPWnOrHbLnjTdn191P1mQrHnKTEDKTEDVTEDKpZwY0ZnlszqWuaOlIiO6UhGdpvN8mvqVsvu6UhIOIy78sLIdpAqds1qh0hqV5RP-mgFWpDF6097jrjbdnNmQEzdjEWN3sHNYnWEVPjD1EBdHyjT3nWDQrjnLPjNKnHDzsWnQsWDvsWbvTHTKnTDKnikQn97exEDQnjT1P9DQnjTQPWmdTHTvP19kuWEQsH-WmW0VPjN1PaY3uynOsHb1PhN1nHPBPymdPkDKPTDKTHnKnHTOsjDdPWD_PHcYP9DQnWmYmHNOnAu-rjRBrj91"
                   target="_blank" hidefocus="true">
                    <img class="thumbnail"
                         lazy_src="https://pic1.ajkimg.com/display/58ajk/a064f95f35c7ca41d41c0b027cdf7e1b/240x180c.jpg"
                         src="https://pic2.58cdn.com.cn/nowater/fangfe/n_v2a37a7b59b5444395940bbca67bb88407.png"
                         width="180" height="135">
                    <span class="many-icons iconfont"></span>
                </a>
                <div class="zu-info">
                    <h3>
                        <a target="_blank" _soj="Filter_11&amp;hfilter=filterlist"
                           href="https://cd.zu.anjuke.com/fangyuan/1408653957?isauction=2&amp;shangquan_id=5246&amp;legoFeeUrl=https%3A%2F%2Flegoclick.58.com%2Fjump%3Ftarget%3DpZwY0ZnlsztdraOWUvYKuad-P1RbnyndraYkuy7hsHEvmvcVrHwhPBYkmycQrjmLPW6hujDKnHTknjNOnjn1TEDQnjbLnWcLnjNQrjTzPWcdTHmznjTKPWcknTDQsjDkTHDkrikQPHmQTHDdPWm1rjELnjbzPHmKnHDKwbnVNDnVENGssXXMMSpcfzLMoufG9cM-BFxCCpWGCUNKnEDQTEDVnEDKnHDvn1bOrH0knjELrHmdnH9YnTDvTEDQTH0dnjELmHmzsyDdmW0VPjFhnBd6mW6-sHcLPjmzmhDOmWEzmEDQnHm1rHbOP1TkPWTdPj9krHmkTHDQPWnOrHbLnjTdn191P1mQrHnKTEDKTEDVTEDKpZwY0ZnlszqWuaOlIiO6UhGdpvN8mvqVsvu6UhIOIy78sLIdpAqds1qh0hqV5RP-mgFWpDF6097jrjbdnNmQEzdjEWN3sHNYnWEVPjD1EBdHyjT3nWDQrjnLPjNKnHDzsWnQsWDvsWbvTHTKnTDKnikQn97exEDQnjT1P9DQnjTQPWmdTHTvP19kuWEQsH-WmW0VPjN1PaY3uynOsHb1PhN1nHPBPymdPkDKPTDKTHnKnHTOsjDdPWD_PHcYP9DQnWmYmHNOnAu-rjRBrj91"><b
                                class="strongbox">川大的福音，青年家园，力宝大厦，川大望江校区，可月付</b>
                        </a>

                    </h3>
                    <p class="details-item tag">
                        <b class="strongbox" style="font-weight: normal;">龥</b>室<b class="strongbox"
                                                                                   style="font-weight: normal;">龤</b>厅<span>|</span><b
                            class="strongbox" style="font-weight: normal;">麣鑶</b>平米<span>|</span>中层(共11层) <i
                            class="iconfont jjr-icon"></i>邓泽明 </p>
                    <address class="details-item">
                        <a target="_blank" href="https://chengdu.anjuke.com/community/view/203154">青年家园</a>&nbsp;&nbsp;
                        武侯-跳伞塔 郭家桥正街6号
                    </address>
                    <p class="details-item bot-tag">
                        <span class="cls-1">合租</span>
                        <span class="cls-2">朝南</span>
                        <span class="cls-3">有电梯</span>
                    </p>
                </div>

                <div class="zu-side">
                    <p><strong><b class="strongbox">齤齤閏</b></strong> 元/月</p>
                </div>
            </div>
            <div class="zu-itemmod"
                 link="https://cd.zu.anjuke.com/fangyuan/1408735858?isauction=2&amp;shangquan_id=20057&amp;legoFeeUrl=https%3A%2F%2Flegoclick.58.com%2Fjump%3Ftarget%3DpZwY0ZnlsztdraOWUvYKuad-P1RbnyndraYkuy7hsHEvmvcVrHwhPBYkmycQrjmLPW6hujDKn1bOPHbzP9DKnHTOP1c3rj0QnH93rj9OP9D3PjTkTH9YnjTKnikQnTDQnjb_nHNvnEDQPHmvn19YP1TOnWNvTHDzTNujsRKjsN72izLMGO4hBstVOlvUlmaFOmBgl2AClpAdTHDKnEDKsHDKTHDQPWEknj0LnWbOn10LrHnknWEKP9DKnEDzn1nkmWDQniYOuHu-sHEOPyNVrH9zPaYQnvmOP166PvEOrjEKnHDvPjTkP101njTdrHEzn10YPTDQnHmYnjTLP1cOrH93nHcYPW0zTEDKTEDKsEDKTy6YIZK1rBtfmvE8XMN8myOJIyV-shPfUiqhmyOMXgR6UBqLIy6fIit4uMFfUHdHuy7zmv6amgcKE19OPH7AnNnVEYcdraYdPjcYsHEQnYcVNd9krjcQnH91P1EdTHDQnB31ni3QPB3OP9DkTHTKTHD_nHcKXLYKnHTkn1mKnHTknHmvPEDvuyc3uWb1PzdBrAnksHEznWmVrHDknaYkmHKhPyPbmynkrjEKTHEKTED1THDkrikQPHmQsjcknjNLTHD1rAuBuyEvn1-WnjmLnvE"
                 _soj="Filter_12&amp;hfilter=filterlist">
                <a data-company="" class="img" _soj="Filter_12&amp;hfilter=filterlist" data-sign="true"
                   href="https://cd.zu.anjuke.com/fangyuan/1408735858?isauction=2&amp;shangquan_id=20057&amp;legoFeeUrl=https%3A%2F%2Flegoclick.58.com%2Fjump%3Ftarget%3DpZwY0ZnlsztdraOWUvYKuad-P1RbnyndraYkuy7hsHEvmvcVrHwhPBYkmycQrjmLPW6hujDKn1bOPHbzP9DKnHTOP1c3rj0QnH93rj9OP9D3PjTkTH9YnjTKnikQnTDQnjb_nHNvnEDQPHmvn19YP1TOnWNvTHDzTNujsRKjsN72izLMGO4hBstVOlvUlmaFOmBgl2AClpAdTHDKnEDKsHDKTHDQPWEknj0LnWbOn10LrHnknWEKP9DKnEDzn1nkmWDQniYOuHu-sHEOPyNVrH9zPaYQnvmOP166PvEOrjEKnHDvPjTkP101njTdrHEzn10YPTDQnHmYnjTLP1cOrH93nHcYPW0zTEDKTEDKsEDKTy6YIZK1rBtfmvE8XMN8myOJIyV-shPfUiqhmyOMXgR6UBqLIy6fIit4uMFfUHdHuy7zmv6amgcKE19OPH7AnNnVEYcdraYdPjcYsHEQnYcVNd9krjcQnH91P1EdTHDQnB31ni3QPB3OP9DkTHTKTHD_nHcKXLYKnHTkn1mKnHTknHmvPEDvuyc3uWb1PzdBrAnksHEznWmVrHDknaYkmHKhPyPbmynkrjEKTHEKTED1THDkrikQPHmQsjcknjNLTHD1rAuBuyEvn1-WnjmLnvE"
                   target="_blank" hidefocus="true">
                    <img class="thumbnail"
                         lazy_src="https://pic1.ajkimg.com/display/58ajk/6de5ba81f43b4281783ce759f37853db/240x180c.jpg"
                         src="https://pic2.58cdn.com.cn/nowater/fangfe/n_v2a37a7b59b5444395940bbca67bb88407.png"
                         width="180" height="135">
                    <span class="many-icons iconfont"></span>
                </a>
                <div class="zu-info">
                    <h3>
                        <a target="_blank" _soj="Filter_12&amp;hfilter=filterlist"
                           href="https://cd.zu.anjuke.com/fangyuan/1408735858?isauction=2&amp;shangquan_id=20057&amp;legoFeeUrl=https%3A%2F%2Flegoclick.58.com%2Fjump%3Ftarget%3DpZwY0ZnlsztdraOWUvYKuad-P1RbnyndraYkuy7hsHEvmvcVrHwhPBYkmycQrjmLPW6hujDKn1bOPHbzP9DKnHTOP1c3rj0QnH93rj9OP9D3PjTkTH9YnjTKnikQnTDQnjb_nHNvnEDQPHmvn19YP1TOnWNvTHDzTNujsRKjsN72izLMGO4hBstVOlvUlmaFOmBgl2AClpAdTHDKnEDKsHDKTHDQPWEknj0LnWbOn10LrHnknWEKP9DKnEDzn1nkmWDQniYOuHu-sHEOPyNVrH9zPaYQnvmOP166PvEOrjEKnHDvPjTkP101njTdrHEzn10YPTDQnHmYnjTLP1cOrH93nHcYPW0zTEDKTEDKsEDKTy6YIZK1rBtfmvE8XMN8myOJIyV-shPfUiqhmyOMXgR6UBqLIy6fIit4uMFfUHdHuy7zmv6amgcKE19OPH7AnNnVEYcdraYdPjcYsHEQnYcVNd9krjcQnH91P1EdTHDQnB31ni3QPB3OP9DkTHTKTHD_nHcKXLYKnHTkn1mKnHTknHmvPEDvuyc3uWb1PzdBrAnksHEznWmVrHDknaYkmHKhPyPbmynkrjEKTHEKTED1THDkrikQPHmQsjcknjNLTHD1rAuBuyEvn1-WnjmLnvE"><b
                                class="strongbox">（带空调！带阳台！套三）西部智谷 优博国际 吾悦广场武侯万达</b>
                        </a>
                        <span class="red">主推</span>

                    </h3>
                    <p class="details-item tag">
                        <b class="strongbox" style="font-weight: normal;">龥</b>室<b class="strongbox"
                                                                                   style="font-weight: normal;">麣</b>厅<span>|</span><b
                            class="strongbox" style="font-weight: normal;">麣齤</b>平米<span>|</span>低层(共22层) <i
                            class="iconfont jjr-icon"></i>王玉丽 </p>
                    <address class="details-item">
                        <a target="_blank" href="https://chengdu.anjuke.com/community/view/412831">世豪嘉柏</a>&nbsp;&nbsp;
                        武侯-新双楠 武科东二路460号
                    </address>
                    <p class="details-item bot-tag">
                        <span class="cls-1">合租</span>
                        <span class="cls-2">朝南</span>
                        <span class="cls-3">有电梯</span>
                        <span class="cls-4">3/9号线</span>
                    </p>
                </div>

                <div class="zu-side">
                    <p><strong><b class="strongbox">齤龤鑶</b></strong> 元/月</p>
                </div>
            </div>
            <div class="zu-itemmod"
                 link="https://cd.zu.anjuke.com/fangyuan/1408617966?isauction=2&amp;shangquan_id=14610&amp;legoFeeUrl=https%3A%2F%2Flegoclick.58.com%2Fjump%3Ftarget%3DpZwY0ZnlsztdraOWUvYKuad-P1RbnyndraYkuy7hsHEvmvcVrHwhPBYkmycQrjmLPW6hujDKPW9Ln10vrEDKnHTOP1DOP1cdnHE3PHmOPkDdP1TkTHNLnjTKnikQnTDQnjb_nHNvnEDQPHmvn19YP1TOnWNvTHD1TNujsRKjsN72izLMGO4hBstVOlvUlmaFOmBgl2AClpAdTHDKnEDKsHDKTHDQPWnOrjcvnWbOP1cLPHEYn1cKP9DKnE7Bn103PHnYPaY3mHnLsHEzmvDVrjKhraYdPHc3rHTdnhR-ujnKnHDvn1b3nWm1njTLn1EQP10zrTDQnHm1rH9zPWnknjDYPWbLPj0zTEDKTEDKsEDKTy6YIZK1rBtfmvE8XMN8myOJIyV-shPfUiqhmyOMXgR6UBqLIy6fIit4uMFfUHdHuy7zmv6amgcKE19OPH7AnNnVEYcdraYdPjcYsHEQnYcVNd9krjcQnH91P1EdTHDQnB31ni3QPB3OP9DkTHTKTHD_nHcKXLYKnHTkn1mKnHTknHmvPEDkrHPBmhNQnBYzmym1sHwWPjcVryEkPzYdrycOPjK-mH0vuycKTHEKTED1THDkrikQPHmQsjDYPWDkTHbvn1cvujmdrHc1m1N1nvD"
                 _soj="Filter_13&amp;hfilter=filterlist">
                <a data-company="" class="img" _soj="Filter_13&amp;hfilter=filterlist" data-sign="true"
                   href="https://cd.zu.anjuke.com/fangyuan/1408617966?isauction=2&amp;shangquan_id=14610&amp;legoFeeUrl=https%3A%2F%2Flegoclick.58.com%2Fjump%3Ftarget%3DpZwY0ZnlsztdraOWUvYKuad-P1RbnyndraYkuy7hsHEvmvcVrHwhPBYkmycQrjmLPW6hujDKPW9Ln10vrEDKnHTOP1DOP1cdnHE3PHmOPkDdP1TkTHNLnjTKnikQnTDQnjb_nHNvnEDQPHmvn19YP1TOnWNvTHD1TNujsRKjsN72izLMGO4hBstVOlvUlmaFOmBgl2AClpAdTHDKnEDKsHDKTHDQPWnOrjcvnWbOP1cLPHEYn1cKP9DKnE7Bn103PHnYPaY3mHnLsHEzmvDVrjKhraYdPHc3rHTdnhR-ujnKnHDvn1b3nWm1njTLn1EQP10zrTDQnHm1rH9zPWnknjDYPWbLPj0zTEDKTEDKsEDKTy6YIZK1rBtfmvE8XMN8myOJIyV-shPfUiqhmyOMXgR6UBqLIy6fIit4uMFfUHdHuy7zmv6amgcKE19OPH7AnNnVEYcdraYdPjcYsHEQnYcVNd9krjcQnH91P1EdTHDQnB31ni3QPB3OP9DkTHTKTHD_nHcKXLYKnHTkn1mKnHTknHmvPEDkrHPBmhNQnBYzmym1sHwWPjcVryEkPzYdrycOPjK-mH0vuycKTHEKTED1THDkrikQPHmQsjDYPWDkTHbvn1cvujmdrHc1m1N1nvD"
                   target="_blank" hidefocus="true">
                    <img class="thumbnail"
                         lazy_src="https://pic1.ajkimg.com/display/58ajk/8389ccd47fb292ba2a517204c6d99444/240x180c.jpg"
                         src="https://pic2.58cdn.com.cn/nowater/fangfe/n_v2a37a7b59b5444395940bbca67bb88407.png"
                         width="180" height="135">
                    <span class="many-icons iconfont"></span>
                </a>
                <div class="zu-info">
                    <h3>
                        <a target="_blank" _soj="Filter_13&amp;hfilter=filterlist"
                           href="https://cd.zu.anjuke.com/fangyuan/1408617966?isauction=2&amp;shangquan_id=14610&amp;legoFeeUrl=https%3A%2F%2Flegoclick.58.com%2Fjump%3Ftarget%3DpZwY0ZnlsztdraOWUvYKuad-P1RbnyndraYkuy7hsHEvmvcVrHwhPBYkmycQrjmLPW6hujDKPW9Ln10vrEDKnHTOP1DOP1cdnHE3PHmOPkDdP1TkTHNLnjTKnikQnTDQnjb_nHNvnEDQPHmvn19YP1TOnWNvTHD1TNujsRKjsN72izLMGO4hBstVOlvUlmaFOmBgl2AClpAdTHDKnEDKsHDKTHDQPWnOrjcvnWbOP1cLPHEYn1cKP9DKnE7Bn103PHnYPaY3mHnLsHEzmvDVrjKhraYdPHc3rHTdnhR-ujnKnHDvn1b3nWm1njTLn1EQP10zrTDQnHm1rH9zPWnknjDYPWbLPj0zTEDKTEDKsEDKTy6YIZK1rBtfmvE8XMN8myOJIyV-shPfUiqhmyOMXgR6UBqLIy6fIit4uMFfUHdHuy7zmv6amgcKE19OPH7AnNnVEYcdraYdPjcYsHEQnYcVNd9krjcQnH91P1EdTHDQnB31ni3QPB3OP9DkTHTKTHD_nHcKXLYKnHTkn1mKnHTknHmvPEDkrHPBmhNQnBYzmym1sHwWPjcVryEkPzYdrycOPjK-mH0vuycKTHEKTED1THDkrikQPHmQsjDYPWDkTHbvn1cvujmdrHc1m1N1nvD"><b
                                class="strongbox">单间 地铁口 无中介 倪家桥 华西坝 桐梓林 赶紧电话</b>
                        </a>

                    </h3>
                    <p class="details-item tag">
                        <b class="strongbox" style="font-weight: normal;">龥</b>室<b class="strongbox"
                                                                                   style="font-weight: normal;">龤</b>厅<span>|</span><b
                            class="strongbox" style="font-weight: normal;">龤閏</b>平米<span>|</span>低层(共20层) <i
                            class="iconfont jjr-icon"></i>张万林 </p>
                    <address class="details-item">
                        <a target="_blank" href="https://chengdu.anjuke.com/community/view/141579">盘谷花园</a>&nbsp;&nbsp;
                        武侯-棕南 人民南路四段21号
                    </address>
                    <p class="details-item bot-tag">
                        <span class="cls-1">合租</span>
                        <span class="cls-2">朝南</span>
                        <span class="cls-3">有电梯</span>
                        <span class="cls-4">1号线</span>
                    </p>
                </div>

                <div class="zu-side">
                    <p><strong><b class="strongbox">鸺齤閏</b></strong> 元/月</p>
                </div>
            </div>
            <div class="zu-itemmod"
                 link="https://cd.zu.anjuke.com/fangyuan/1408627282?isauction=2&amp;shangquan_id=14609&amp;legoFeeUrl=https%3A%2F%2Flegoclick.58.com%2Fjump%3Ftarget%3DpZwY0ZnlsztdraOWUvYKuad-P1RbnyndraYkuy7hsHEvmvcVrHwhPBYkmycQrjmLPW6hujDKPH9kPWbdrEDKnHTOP1ckPHnQrHDQn10zrTDLnWTkTH0znjTKnikQnTDQnjb_nHNvnEDQPHmvn19YP1TOnWNvTHDYTNujsRKjsN72izLMGO4hBstVOlvUlmaFOmBgl2AClpAdTHDKnEDKsHDKTHDQPWEknjnLPHTdnHcQrjDzPj9KP9DKnE7Bry76myE1nBYknAEksHwWuWNVrjnvPzY3PHRWujR-uyc1nWmKnHDvPjTkn10dnjmzrHmQP1mvPEDQnHmYnjT1P1NkPHN3n1D3PHbzTEDKTEDKsEDKTy6YIZK1rBtfmvE8XMN8myOJIyV-shPfUiqhmyOMXgR6UBqLIy6fIit4uMFfUHdHuy7zmv6amgcKE19OPH7AnNnVEYcdraYdPjcYsHEQnYcVNd9krjcQnH91P1EdTHDQnB31ni3QPB3OP9DkTHTKTHD_nHcKXLYKnHTkn1mKnHTknHmvPEDOuHD3PyNvraYQuynzsHwhnWnVmynknBYzmvn3myDYnWu-uAmKTHEKTED1THDkrikQPHmQsjDYPWTOTHELPjN1nHnvuW-bnW6Wnym"
                 _soj="Filter_14&amp;hfilter=filterlist">
                <a data-company="" class="img" _soj="Filter_14&amp;hfilter=filterlist" data-sign="true"
                   href="https://cd.zu.anjuke.com/fangyuan/1408627282?isauction=2&amp;shangquan_id=14609&amp;legoFeeUrl=https%3A%2F%2Flegoclick.58.com%2Fjump%3Ftarget%3DpZwY0ZnlsztdraOWUvYKuad-P1RbnyndraYkuy7hsHEvmvcVrHwhPBYkmycQrjmLPW6hujDKPH9kPWbdrEDKnHTOP1ckPHnQrHDQn10zrTDLnWTkTH0znjTKnikQnTDQnjb_nHNvnEDQPHmvn19YP1TOnWNvTHDYTNujsRKjsN72izLMGO4hBstVOlvUlmaFOmBgl2AClpAdTHDKnEDKsHDKTHDQPWEknjnLPHTdnHcQrjDzPj9KP9DKnE7Bry76myE1nBYknAEksHwWuWNVrjnvPzY3PHRWujR-uyc1nWmKnHDvPjTkn10dnjmzrHmQP1mvPEDQnHmYnjT1P1NkPHN3n1D3PHbzTEDKTEDKsEDKTy6YIZK1rBtfmvE8XMN8myOJIyV-shPfUiqhmyOMXgR6UBqLIy6fIit4uMFfUHdHuy7zmv6amgcKE19OPH7AnNnVEYcdraYdPjcYsHEQnYcVNd9krjcQnH91P1EdTHDQnB31ni3QPB3OP9DkTHTKTHD_nHcKXLYKnHTkn1mKnHTknHmvPEDOuHD3PyNvraYQuynzsHwhnWnVmynknBYzmvn3myDYnWu-uAmKTHEKTED1THDkrikQPHmQsjDYPWTOTHELPjN1nHnvuW-bnW6Wnym"
                   target="_blank" hidefocus="true">
                    <img class="thumbnail"
                         lazy_src="https://pic1.ajkimg.com/display/58ajk/99276f6eae7315b2405133537a5258af/240x180c.jpg"
                         src="https://pic2.58cdn.com.cn/nowater/fangfe/n_v2a37a7b59b5444395940bbca67bb88407.png"
                         width="180" height="135">
                    <span class="many-icons iconfont"></span>
                </a>
                <div class="zu-info">
                    <h3>
                        <a target="_blank" _soj="Filter_14&amp;hfilter=filterlist"
                           href="https://cd.zu.anjuke.com/fangyuan/1408627282?isauction=2&amp;shangquan_id=14609&amp;legoFeeUrl=https%3A%2F%2Flegoclick.58.com%2Fjump%3Ftarget%3DpZwY0ZnlsztdraOWUvYKuad-P1RbnyndraYkuy7hsHEvmvcVrHwhPBYkmycQrjmLPW6hujDKPH9kPWbdrEDKnHTOP1ckPHnQrHDQn10zrTDLnWTkTH0znjTKnikQnTDQnjb_nHNvnEDQPHmvn19YP1TOnWNvTHDYTNujsRKjsN72izLMGO4hBstVOlvUlmaFOmBgl2AClpAdTHDKnEDKsHDKTHDQPWEknjnLPHTdnHcQrjDzPj9KP9DKnE7Bry76myE1nBYknAEksHwWuWNVrjnvPzY3PHRWujR-uyc1nWmKnHDvPjTkn10dnjmzrHmQP1mvPEDQnHmYnjT1P1NkPHN3n1D3PHbzTEDKTEDKsEDKTy6YIZK1rBtfmvE8XMN8myOJIyV-shPfUiqhmyOMXgR6UBqLIy6fIit4uMFfUHdHuy7zmv6amgcKE19OPH7AnNnVEYcdraYdPjcYsHEQnYcVNd9krjcQnH91P1EdTHDQnB31ni3QPB3OP9DkTHTKTHD_nHcKXLYKnHTkn1mKnHTknHmvPEDOuHD3PyNvraYQuynzsHwhnWnVmynknBYzmvn3myDYnWu-uAmKTHEKTED1THDkrikQPHmQsjDYPWTOTHELPjN1nHnvuW-bnW6Wnym"><b
                                class="strongbox">倪家桥地铁口 保利中心对面 主卧带卫 真实有效 随时看房</b>
                        </a>

                    </h3>
                    <p class="details-item tag">
                        <b class="strongbox" style="font-weight: normal;">龥</b>室<b class="strongbox"
                                                                                   style="font-weight: normal;">麣</b>厅<span>|</span><b
                            class="strongbox" style="font-weight: normal;">龤鑶</b>平米<span>|</span>中层(共24层) <i
                            class="iconfont jjr-icon"></i>岳梦 </p>
                    <address class="details-item">
                        <a target="_blank" href="https://chengdu.anjuke.com/community/view/857965">棕北国际</a>&nbsp;&nbsp;
                        武侯-棕北 锦绣路34号
                    </address>
                    <p class="details-item bot-tag">
                        <span class="cls-1">合租</span>
                        <span class="cls-2">朝南</span>
                        <span class="cls-3">有电梯</span>
                    </p>
                </div>

                <div class="zu-side">
                    <p><strong><b class="strongbox">麣驋閏閏</b></strong> 元/月</p>
                </div>
            </div>


        </div>

        <!--右侧广告栏-->
        <div class="adver-content">
            <div id="IFX_p3001" class="advBox" style="display:none;"></div>

            <div id="IFX_p950" class="advBox" style="">
                <div style="width:200px;height:200px;border:none;padding:0px;margin:0px;overflow:hidden;position: relative;">
                    <a target="_blank"
                       href="https://ifx.anjuke.com/cr?c=15&amp;u=http%3A%2F%2Fshanghai.anjuke.com%2Fask%2F%3Ffrom%3Dnavigation&amp;p=950&amp;as=2152766232"><img
                            style="width:200px;height:200px;border:none;"
                            src="https://pic6.ajkimg.com/mat/f1e81f2a177ffbfd3fd2cb4c8f5bd58f?imageMogr2/format/jpg/thumbnail/200x200"></a><span
                        style="position: absolute;right: 11px;bottom: 0;color: white;">广告</span></div>
            </div>


            <!--百度广告-->
            <!--<div class="advBox" id="baidu_adv"></div>-->
            <!-- 58联盟广告页 -->
            <div class="luna-58-wrap">
                <iframe class="luna-58ifm"
                        src="https://luna.58.com/show/ads?n=b-33276477696777-ps-f-anjukepc&amp;c=zufangpc&amp;qq-pf-to=pcqq.discussion"
                        width="240" height="240" scrolling="no" frameborder="0"></iframe>
            </div>
        </div>

        <!--翻页-->
        <div class="page-content" id="page-content"></div>
        <script>
            layui.use('laypage', function () {
                var layPage = layui.laypage;
                layPage.render({
                    elem: 'page-content' //注意，这里的 test1 是 ID，不用加 # 号
                    , count: 50 //数据总数，从服务端得到
                });
            })
        </script>
    </div>


</div>
</body>
<script type="text/javascript">
    $(document).ready(function () {
        // 获取显示区域列表、租金、等条件
        console.log("sss");
        $.ajax({
            url: "${pageContext.request.contextPath}/query-data",
            type: "GET",
            success: function (data) {
                var json = JSON.parse(data);

                //区域查询条件
                const locations = json.locations;
                console.log(locations);
                var locationHtml = "<a href='javascript:void(0)' title=\"区域租房\" class=\"selected-item\">区域</a>\n" +
                    "<div class=\"sub-items sub-level1\">\n" +
                    "<em class=\"arrow-wrap \"><em class=\"arrow\"></em></em>\n" +
                    "<a href='${pageContext.request.contextPath}/house/' ";
                if ('' === '${sessionScope.CURRENT_LOCATION}') {
                    locationHtml += "class='selected-item'";
                }
                locationHtml += "title='全部租房'>全部</a>";
                for (let i = 0; i < locations.length; i++) {
                    locationHtml += "<a href='${pageContext.request.contextPath}/house/${sessionScope.CITY.id}/" + locations[i].id + "/ '";
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
    })
</script>
</html>
