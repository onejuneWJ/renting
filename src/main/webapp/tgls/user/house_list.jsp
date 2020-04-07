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
    <meta name="author" content="万家"/>
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
            <li class="layui-this">房源列表</li>
        </ul>
        <div class="layui-tab-content">
            <!--列表tab开始-->
            <div class="layui-tab-item layui-show">
                <table class="layui-table" id="house_table" lay-filter="house_table"></table>
            </div>
            <!--列表tab结束-->

        </div>
    </div>


</div>

<script type="text/html" id="barDemo">
    {{#  if(d.houseStatus === '已出租'){ }}
    <a class="layui-btn layui-btn-xs layui-btn-disabled ">删除</a>
    {{# }else{ }}
    <a class="layui-btn layui-btn-danger layui-btn-xs " lay-event="del">删除</a>
    {{# } }}
</script>
<script>
    layui.use('element', function () {

    });
    layui.use('table', function () {
        var table = layui.table;
        var laypager = layui.layPage;
        var layer = layui.layer;
        //第一个实例
        table.render({
            elem: '#house_table'
            , height: 440
            , url: 'http://localhost:8080/renting/user/myPost' //数据接口
            , page: true
            , cols: [[ //表头
                {field: 'id', title: 'ID', width: 80, sort: true, fixed: 'left'}
                , {field: 'plotName', title: '小区名称', width: 160}
                , {field: 'plotAddress', title: '地址', width: 200}
                , {field: 'huxingShi', title: '室', width: 80}
                , {field: 'huxingTing', title: '厅', width: 80}
                , {field: 'huxingWei', title: '卫', width: 80}
                , {field: 'area', title: '面积', width: 100, templet: '<div>{{d.area}}平方米</div>'}
                , {field: 'currentFloor', title: '楼层', width: 70}
                , {field: 'rental', title: '租金', width: 100, templet: '<div>{{d.rental}}元/月</div>'}
                , {field: 'postTime', title: '发布时间', width: 140}
                , {field: 'houseStatus', title: '状态', width: 100}
                , {field: 'renterName', title: '租户', width: 100}
                , {fixed: 'right', title: '操作', width: 100, align: 'center', toolbar: '#barDemo'}
            ]]
            , text: {
                none: "暂无数据"
            }

        });

        table.on('tool(house_table)', function (obj) { //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
            var data = obj.data; //获得当前行数据
            console.log(data);
            var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
            var tr = obj.tr; //获得当前行 tr 的DOM对象
            var id = data.id;
            switch (layEvent) {
                case 'del':
                    if (data.houseStatus === "已出租") {
                        layer.msg("无法删除已出租房源");
                    } else {
                        layer.confirm('确定删除？', function (index) {

                            //向服务端发送删除指令
                            $.ajax({
                                url: "http://localhost:8080/renting/house/" + id,
                                type: "delete",
                                success: function (data) {
                                    if (data.msg === "success") {
                                        obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
                                        layer.close(index);
                                    } else {
                                        layer.msg("删除失败");
                                    }
                                }, error: function () {
                                    layer.msg("请求失败");
                                }
                            })
                        });
                    }
                    break;
            }

        });
    });
</script>
</body>

</html>