<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,Chrome=1">
    <!-- Google Chrome Frame也可以让IE用上Chrome的引擎: -->
    <meta name="renderer" content="webkit">
    <!--国产浏览器高速模式-->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 网站简介 -->
    <meta name="keywords" content="搜索关键字，以半角英文逗号隔开"/>
    <title>看房列表</title>

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
    <!-- 公共样式 结束 -->

    <style>
        .layui-table img {
            max-width: none;
        }
    </style>

</head>

<body>

<div>
    <div class="layui-tab layui-tab-card" lay-filter="house_tab" id="house_tab" lay-allowClose="true">
        <ul class="layui-tab-title">
            <li class="layui-this">看房请求</li>
        </ul>
        <div class="layui-tab-content">
            <!--列表tab开始-->
            <div class="layui-tab-item layui-show">
                <div class="console">

                </div>
                <table class="layui-table" id="house_table" lay-filter="test"></table>

            </div>
            <!--列表tab结束-->

        </div>
    </div>


</div>

<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs" lay-event="createDeal">创建交易</a>
    <a class="layui-btn layui-btn-xs layui-btn-danger" lay-event="del">删除</a>
</script>
<script>

</script>
<script>
    layui.use('element', function () {

    });

    layui.use('table', function () {
        var table = layui.table;
        var laypager = layui.layPage;
        var layer=layui.layer;
        //第一个实例
        table.render({
            elem: '#house_table',
            height: 450,
            url: 'http://localhost:8080/renting/visit?userId=${sessionScope.CURRENT_USER.id}', //数据接口,
            page: true,
            cols: [[ //表头
                {field: 'id', title: 'ID', width: 80, sort: true, fixed: 'left'},
                {field: 'requestName', title: '发起人', width: 120},
                {field: 'requestTime', title: '发起时间', width: 180},
                {field: 'houseInfo', title: '房源信息', width: 280},
                {fixed: 'right',title:"操作", width: 180, align: 'center', toolbar: '#barDemo'}
            ]],
            text: {
                none: "暂无数据"
            }

        });

        table.on('tool(test)', function (obj) { //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
            var data = obj.data; //获得当前行数据
            console.log(data);
            var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
            var tr = obj.tr; //获得当前行 tr 的DOM对象
            var id = data.id;
            const postData = {leaserId: data.leaserId, houseId: data.houseId, renterId: data.userId};
            switch (layEvent) {
                case 'createDeal':
                    $.ajax({
                        url: "http://localhost:8080/renting/deal",
                        type: "post",
                        contentType: 'application/json; charset=UTF-8',
                        data: JSON.stringify(postData),
                        success: function (data) {
                            if (data.msg == "success") {
                                layer.msg("创建成功");
                            } else {
                                layer.msg(data.msg);
                            }
                        },
                        error: function () {
                            layer.msg("系统错误");
                        }
                    });
                    break;
                case 'del':

                    layer.confirm('确定删除？', function (index) {

                        //向服务端发送删除指令
                        $.ajax({
                            url: "http://localhost:8080/renting/visit/" + id,
                            type: "delete",
                            success: function (data) {
                                if (data.msg == "success") {
                                    obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
                                    layer.close(index);
                                } else {
                                    layer.msg("删除失败");
                                }
                            }
                        })
                    });
                    break;
            }

        });
    });
</script>
</body>

</html>