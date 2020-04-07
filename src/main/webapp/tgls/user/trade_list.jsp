<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,Chrome=1">
    <!-- Google Chrome Frame也可以让IE用上Chrome的引擎: -->
    <meta name="renderer" content="webkit">
    <!-- 网站简介 -->
    <meta name="keywords" content="搜索关键字，以半角英文逗号隔开"/>
    <title>穷在闹市出品</title>

    <!-- 公共样式 开始 -->
    <link rel="stylesheet" type="text/css" href="../../css/base.css">
    <link rel="stylesheet" type="text/css" href="../../css/iconfont.css">
    <script type="text/javascript" src="../../framework/jquery-1.11.3.min.js"></script>
    <link rel="stylesheet" type="text/css" href="../../layui/css/layui.css">
    <script type="text/javascript" src="../../layui/layui.js"></script>
    <!-- 滚动条插件 -->
    <link rel="stylesheet" type="text/css" href="../../css/jquery.mCustomScrollbar.css">
    <script src="../../framework/jquery-ui-1.10.4.min.js"></script>
    <script src="../../framework/jquery.mousewheel.min.js"></script>
    <script src="../../framework/jquery.mCustomScrollbar.min.js"></script>
    <script src="../../framework/cframe.js"></script><!-- 仅供所有子页面使用 -->
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
            <li class="layui-this">交易列表</li>
        </ul>
        <div class="layui-tab-content">
            <!--列表tab开始-->
            <div class="layui-tab-item layui-show">
                <div class="console">

                </div>
                <table class="layui-table" id="deal_table" lay-filter="test"></table>
            </div>
            <!--列表tab结束-->
        </div>
    </div>


</div>

<script type="text/html" id="barTpl">
    {{#  if(d.status === '进行中'){ }}
    <a class="layui-btn layui-btn-xs layui-btn-normal" lay-event="complete">完成交易</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="cancel">取消交易</a>
    {{#  } }}

</script>
<script>
    layui.use('element', function () {

    });

    layui.use('table', function () {
        var table = layui.table;
        var laypager = layui.layPage;
        //第一个实例
        table.render({
            elem: '#deal_table'
            , height: 450
            , url: 'http://localhost:8080/renting/user/myDeal' //数据接口
            , page: true
            , cols: [[ //表头
                {field: 'id', title: 'ID', width: 80, sort: true, fixed: 'left'}
                , {field: 'renterName', title: '租户', width: 120}
                , {field: 'leaserName', title: '出租人', width: 120}
                , {field: 'houseInfo', title: '租房信息', width: 280}
                , {field: 'createTime', title: '创建时间', width: 180}
                , {field: 'status', title: '状态', width: 100}
                , {field: 'completeTime', title: '完成时间', width: 180}
                , {fixed: 'right', title: '操作', width: 200, align: 'center', templet: '#barTpl'}
            ]]
            , text: {
                none: "暂无数据"
            }
        });

        table.on('tool(test)', function (obj) { //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
            var data = obj.data; //获得当前行数据
            console.log(data);
            var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
            var tr = obj.tr; //获得当前行 tr 的DOM对象
            var id = data.id;
            switch (layEvent) {
                case 'complete':
                    var userId = '${sessionScope.CURRENT_USER.id}';
                    if (userId !== data.leaserId.toString()) {
                        layer.msg("只有房源发布者才能进行此操作");
                        return;
                    }
                    $.ajax({
                        url: "http://localhost:8080/renting/deal/complete/" + id,
                        type: "put",
                        success: function (data) {
                            if (data.msg == "success") {
                                layer.msg("操作成功");
                                table.reload('house_table',{});
                            } else {
                                layer.msg("删除失败");
                            }
                        }
                    });
                    break;
                case 'cancel':
                    $.ajax({
                        url: "http://localhost:8080/renting/deal/cancel/" + id,
                        type: "put",
                        success: function (data) {
                            if (data.msg == "success") {
                                layer.msg("操作成功");
                                table.reload('house_table',{});
                            } else {
                                layer.msg("删除失败");
                            }
                        }
                    });
                    break;
            }

        });
    });
</script>
</body>

</html>