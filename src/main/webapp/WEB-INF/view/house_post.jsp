<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>房源发布-万家</title>
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/images/favicon.ico"/>
    <link rel="bookmark" href="${pageContext.request.contextPath}/images/favicon.ico"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/layui/css/layui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/post_house.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/index.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/layui/layui.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/post_house.js"></script>
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
<div class="minheightout w">
    <div class="c"></div>
    <div id="formWrap">
        <div class="post-middle clearfix">
            <div class="post-middle-left">
                <form name="postForm" id="postForm">
                    <div class="block_wrap block_content">
                        <div class="block_title"><h2>基础信息</h2></div>
                        <div class="block_content">
                            <div class="rows_wrap clearfix custom_name">
                                <div class="rows_content">
                                    <div class="tip"></div>
                                    <input id="plotId" type="hidden" name="plotId">
                                    <div class="input_text_wrap" name="plotName" style="position: relative;">
                                        <input type="autoCompleteXiaoqu" tabindex="1" id="xiaoqu" autocomplete="off"
                                               disableautocomplete="true" maxlength="50" placeholder="请选择小区"
                                               style="width: 522px;">
                                        <div id="autoComplete-div" class="tooltip" style=" z-index:9998;display:none;width:538px">
                                            <ul class="autoComplete-ul">

                                            </ul>
                                        </div>
                                    </div>
                                </div>
                                <div class="rows_title">
                                    <span><span class="rows_title_star">*</span>小区名称</span>
                                </div>
                            </div>
                            <div class="rows_wrap clearfix custom_name">
                                <div class="rows_content">
                                    <div class="tip"></div>
                                    <div class="input_text_wrap clearfix" name="huxingShi" style="position: relative;">
                                        <input type="text" tabindex="3" id="huxingshi" maxlength="1"
                                               style="width: 88px;">
                                        <span>室</span>
                                    </div>
                                    <div class="input_text_wrap clearfix" name="huxingTing" style="position: relative;">
                                        <input type="text" tabindex="4" id="huxingting" maxlength="1"
                                               style="width: 88px;">
                                        <span>厅</span>
                                    </div>
                                    <div class="input_text_wrap clearfix" name="huxingWei" style="position: relative;">
                                        <input type="text" tabindex="5" id="huxingwei" maxlength="1"
                                               style="width: 88px;"><span>卫</span></div>
                                    <div class="input_text_wrap clearfix" name="area" style="position: relative;"><span>共</span>
                                        <input
                                                type="text" tabindex="6" id="area" maxlength="8"
                                                style="width: 74px;"><span>㎡</span></div>
                                </div>
                                <div class="rows_title">
                                    <span>
                                        <span class="rows_title_star">*</span>房屋户型
                                    </span>
                                </div>
                            </div>
                            <div class="rows_wrap clearfix custom_name">
                                <div class="rows_content">
                                    <div class="tip"></div>
                                    <div class="input_text_wrap clearfix" name="currentFloor"
                                         style="position: relative;">
                                        <span>第</span>
                                        <input type="text" tabindex="7" id="Floor" maxlength="2" style="width: 74px;">
                                        <span>层</span>
                                    </div>
                                    <div class="input_text_wrap clearfix" name="totalFloor"
                                         style="position: relative;">
                                        <span>共</span>
                                        <input type="text" tabindex="8" id="zonglouceng" maxlength="2"
                                               style="width: 74px;">
                                        <span>层</span>
                                    </div>

                                </div>
                                <div class="rows_title">
                                    <span><span class="rows_title_star">*</span>楼层信息</span>
                                </div>
                            </div>
                            <div class="rows_wrap clearfix custom_name">
                                <div class="rows_content">
                                    <div class="tip"></div>
                                    <div class="selectordef" name="towardsId" style="z-index: 1489; width: 120px;"
                                         tabindex="11" nameid="1021">
                                        <div class="title">
                                            <span class="seled">东</span>
                                            <div class="arrow"></div>
                                        </div>
                                        <div class="optiondef" style="width: 117px; display: none;">
                                            <ul id="towards" style="width:117px;">
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                                <div class="rows_title"><span><span class="rows_title_star">*</span>房屋朝向</span></div>
                            </div>

                        </div>
                    </div>
                    <div class="block_wrap block_content">
                        <div class="block_title"><h2>租金信息</h2></div>
                        <div class="block_content">
                            <div class="rows_wrap clearfix custom_name">
                                <div class="rows_content">
                                    <div class="tip"></div>
                                    <div class="input_text_wrap clearfix" name="rental" style="position: relative;">
                                        <input type="inputText" tabindex="13" id="rental"
                                               style="width: 68px;"><span>元/月</span>
                                    </div>
                                    <div class="selectordef" name="paymentId" style="z-index: 1486; width: 120px;"
                                         tabindex="14" nameid="1594">
                                        <div class="title"><span class="seled">请选择付款方式</span>
                                            <div class="arrow"></div>
                                        </div>
                                        <div class="optiondef" style="width: 117px; display: none;">
                                            <ul id="payment" style="width:117px;">
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                                <div class="rows_title"><span><span class="rows_title_star">*</span>月租金</span></div>
                            </div>
                            <div class="rows_wrap clearfix custom_name_choose">
                                <div class="rows_content">
                                    <div class="tip"></div>
                                    <div class="checkbox_wrap clearfix" name="rentalInclude" nameid="12339">

                                    </div>
                                </div>
                                <div class="rows_title"><span>租金包含</span></div>
                            </div>
                        </div>
                    </div>
                    <div class="block_wrap block_content">
                        <div class="block_title"><h2>详细介绍</h2></div>
                        <div class="block_content">
                            <div class="rows_wrap clearfix custom_name">
                                <div class="rows_content">
                                    <div class="tip"></div>

                                </div>
                            </div>

                            <div class="rows_wrap clearfix custom_name_choose">
                                <div class="rows_content">
                                    <div class="tip"></div>
                                    <div class="checkbox_wrap clearfix" name="houseInclude" nameid="1022">

                                        <div class="select_all"><span>全选</span></div>
                                    </div>
                                </div>
                                <div class="rows_title"><span>房屋配置</span></div>
                            </div>

                            <div class="rows_wrap clearfix custom_name_choose">
                                <div class="rows_content">
                                    <div class="tip"></div>
                                    <div class="checkbox_wrap clearfix" name="require" nameid="12136">

                                    </div>
                                </div>
                                <div class="rows_title"><span>出租要求</span></div>
                            </div>
                            <div class="rows_wrap clearfix custom_name">
                                <div class="rows_content">
                                    <div class="tip"></div>
                                    <div class="textarea_wrap" name="description" style="position: relative;">
                                        <textarea
                                                tabindex="24" id="Content"
                                                placeholder="可以介绍一下房源亮点，交通、周边环境，可以入住的时间和对租客的要求等，详细的描述会大大增加快速出租的机会！请不要在描述中包含：1.任意形式的联系方式及变型词；2.与房源或相关配套描述无关的内容；3.违反国家法律法规的内容等"></textarea>
                                        <div class="text-tips">
                                            <span class="textarea-size-tips">0</span>/300
                                        </div>
                                    </div>
                                </div>
                                <div class="rows_title"><span>房源描述</span></div>
                            </div>
                        </div>
                    </div>
                    <div class="block_wrap block_content">
                        <div class="block_title"><h2>房源图片</h2></div>
                        <div class="block_content">
                            <div class="rows_wrap clearfix custom_name">
                                <div class="rows_content">
                                    <div class="tip"></div>
                                    <div class="imgbar_wrap" id="flashflashContent">
                                        <div class="info">
                                            请上传清晰、实拍的室内图片，请不要在图片上添加文字、数字、网址等内容，请勿上传名片、二维码、自拍照、风景照等与房源无关的图片，最多上传<span>12</span>张，每张最大<span>10M</span>
                                        </div>
                                        <div class="img_list_wrap">
                                            <ul class="clearfix img_list">

                                            </ul>
                                            <div class="add_img_small"><span class="add_icon"></span>添加</div>
                                        </div>
                                        <div class="upload_wrap">
                                            <div class="upload">
                                                <div class="localUpload_wrap">
                                                    <div class="localUpload-container">
                                                        <div class="localUpload">
                                                            <div class="imgUpload" id="imgUpload">
                                                                <div class="html5">
                                                                    <input name="img" id="img" type="file"
                                                                           multiple="multiple">
                                                                </div>
                                                            </div>
                                                            <div class="maxlength_cover"></div>
                                                            <div class="maxlength_cover"></div>
                                                        </div>
                                                        <div class="local-img-info">
                                                            <span class="local-img-add"></span>上传图片
                                                        </div>
                                                    </div>
                                                    <div class="localTxt"><h4 class="upload-title-sm">本地上传</h4>
                                                        <p class="upload-info-sm">图片拖拽到这里或点击上传</p></div>
                                                </div>
                                            </div>
                                        </div>
                                        <script type="text/javascript">
                                            layui.use(['layer', 'upload'], function () {
                                                var upload = layui.upload;
                                                var layer = layui.layer;
                                                var loading;
                                                upload.render({
                                                    elem: '#img',
                                                    url: '${pageContext.request.contextPath}/house/upload',
                                                    multiple: true,
                                                    before: function (obj) {
                                                        loading = layer.load(2);
                                                        //预读本地文件示例，不支持ie8
                                                        obj.preview(function (index, file, result) {

                                                        });
                                                    },
                                                    done: function (res) {
                                                        //上传完毕
                                                        layer.close(loading);
                                                        var li = document.createElement('li');
                                                        $(".add_img_small").addClass('show');
                                                        $(".upload_wrap").css({display: 'none'});
                                                        li.setAttribute('class', 'img_box');
                                                        li.setAttribute('data-index', res.data.id);
                                                        li.setAttribute('draggable', 'true');
                                                        li.innerHTML = '<img src="/upload/images/' + res.data.imgName + '">' +
                                                            '<div class="img_cover"></div>' +
                                                            '<div class="delete" onclick="deleteImg(this)"></div>';
                                                        $(".img_list").append(li);
                                                    },
                                                    error: function (index, upload) {
                                                        //当上传失败时，你可以生成一个“重新上传”的按钮，点击该按钮时，执行 upload() 方法即可实现重新上传
                                                        layer.close(loading);
                                                    }
                                                });
                                            })
                                        </script>
                                    </div>
                                </div>
                                <div class="rows_title"><span><span class="rows_title_star">*</span>上传图片</span></div>
                            </div>
                        </div>
                    </div>

                    <div class="block_wrap" style="margin-top: 100px;margin-bottom: 100px">
                        <div class="block_content">
                            <div class="rows_wrap clearfix">
                                <div class="rows_content1">
                                    <div class="tip"></div>
                                    <div class="submit_wrap"><span>发布</span></div>
                                </div>
                                <div class="rows_title"><span></span></div>
                            </div>
                        </div>
                    </div>
                </form>
            </div>

        </div>
    </div>
</div>

</body>
</html>