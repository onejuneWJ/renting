$(document).ready(function () {
    getTowards();
    getPayment();
    getHouseInclude();
    getRentalInclude();
    getRequire();


    function getTowards() {
        $.ajax({
            url: "http://localhost:8080/renting/house/towards",
            type: "GET",
            success: function (data) {
                var towards = data.data;
                if (towards != null) {
                    var h = "";
                    for (i = 0; i < towards.length; i++) {
                        if (i === 0) {
                            h += "<li val=\"" + towards[i].id + "\" class=\"s\">" + towards[i].name + "</li>";
                        } else {
                            h += "<li val=\"" + towards[i].id + "\" >" + towards[i].name + "</li>";
                        }
                    }
                    $("#towards").html(h);
                }
            }
        });
    }

    function getPayment() {
        $.ajax({
            url: "http://localhost:8080/renting/house/payment",
            type: "GET",
            success: function (data) {
                var payment = data.data;
                if (payment != null) {
                    var h = "<li val=\"\" class=\"s\">请选择付款方式</li>";
                    for (i = 0; i < payment.length; i++) {
                        h += "<li val=\"" + payment[i].id + "\" >" + payment[i].name + "</li>";
                    }
                    $("#payment").html(h);
                }
            }
        });
    }

    function getRentalInclude() {
        $.ajax({
            url: "http://localhost:8080/renting/house/rentalInclude",
            type: "GET",
            success: function (data) {
                var d = data.data;
                if (d != null) {
                    var h = "";
                    for (var i = 0; i < d.length; i++) {
                        h += "<div tabindex=\"15\" class=\"checkbox\" data-value=\"" + d[i].id +
                            "\" style=\"width: 100px;\">" +
                            "<i></i><label>" + d[i].name +
                            "</label></div>";
                    }
                    h += "<div class=\"select_all\"><span>全选</span></div>";
                    $("div[name='rentalInclude']").html(h);
                }
            }
        });
    }

    function getHouseInclude() {
        $.ajax({
            url: "http://localhost:8080/renting/house/houseInclude",
            type: "GET",
            success: function (data) {
                var d = data.data;
                if (d != null) {
                    var h = "";
                    for (var i = 0; i < d.length; i++) {
                        h += "<div tabindex=\"20\" class=\"checkbox\" data-value=\"" + d[i].id +
                            "\" style=\"width: 100px;\">" +
                            "<i></i><label>" + d[i].name +
                            "</label></div>";
                    }
                    h += "<div class=\"select_all\"><span>全选</span></div>";
                    $("div[name='houseInclude']").html(h);
                }
            }
        });
    }

    function getRequire() {
        $.ajax({
            url: "http://localhost:8080/renting/house/require",
            type: "GET",
            success: function (data) {
                var d = data.data;
                if (d != null) {
                    var h = "";
                    for (var i = 0; i < d.length; i++) {
                        h += "<div tabindex=\"20\" class=\"checkbox\" data-value=\"" + d[i].id +
                            "\" style=\"width: 100px;\">" +
                            "<i></i><label>" + d[i].name +
                            "</label></div>";
                    }
                    h += "<div class=\"select_all\"><span>全选</span></div>";
                    $("div[name='require']").html(h);
                }
            }
        });
    }
});
$(document).ready(function () {
    //输入框获取焦点
    $(".rows_wrap").find("input").focus(function (_this) {
        $(this).parent().addClass('focus')
    });
    //输入框失去焦点
    $(".rows_wrap").find("input").blur(function () {
        checkInput($(this));
    });

    //校验电话号码输入框
    $("div[name='Phone']").find("input").blur(function () {
        checkPhone($(this));
    });
    //下拉列表
    $("div.selectordef").hover(function () {
        $(this).children("div.optiondef").css({'display': 'block'});
        $(this).find('div.arrow').addClass('show');
        $(this).addClass('focus');
        $(this).find("li").hover(function () {
            $(this).addClass('sel');
        }, function () {
            $(this).removeClass('sel');
        });
        $(this).find("li").click(function () {
            var text = $(this).text();
            $(this).parents('div.optiondef').siblings('div.title').children('span.seled').html(text);
            //
            $(this).addClass('s');
            $(this).siblings().removeClass('s');
            $(this).parents('div.optiondef').css({'display': 'none'});
            $(this).parents('div.optiondef').find('div.arrow').removeClass('show');
        });

    }, function () {
        $(this).removeClass('focus');
        $(this).children("div.optiondef").css({'display': 'none'});
        $(this).find('div.arrow').removeClass('show');
    });


    //radio
    $("div.radio").hover(function () {
        $(this).addClass('hover')
    }, function () {
        $(this).removeClass('hover')
    });
    $("div.radio").click(function () {
        if ($(this).attr('class').match('focus') == null) {
            $(this).addClass('focus');
            $(this).siblings('div.radio').removeClass('focus');
        } else {
            $(this).removeClass('focus');
        }
    });

    //checkbox
    $("div.checkbox_wrap").delegate("div.checkbox", "mouseover", function () {
        $(this).addClass('hover');
    });
    $("div.checkbox_wrap").delegate("div.checkbox", "mouseleave", function () {
        $(this).removeClass('hover')
    });
    $("div.checkbox_wrap").delegate("div.checkbox", "click", function () {
        if ($(this).attr('class').match('focus') == null) {
            $(this).addClass('focus');
        } else {
            $(this).removeClass('focus');
        }
    });
    //全选
    $("div.checkbox_wrap").delegate("div.select_all", "click", function () {
        var str = $(this).children('span').text();
        if (str == "全选") {
            $(this).siblings().addClass('focus');
            $(this).children('span').html("取消");
        } else {
            $(this).siblings().removeClass('focus');
            $(this).children('span').html("全选");
        }
    });

    $("ul.autoComplete-ul").delegate("li", "mouseover", function () {
        $(this).addClass('over');
    });
    $("ul.autoComplete-ul").delegate("li", "mouseleave", function () {
        $(this).removeClass('over');
    });
    $("ul.autoComplete-ul").delegate("li", "click", function () {
        var plotId=$(this).attr("plotId");
        var plotName=$(this).attr("plotName");
        $("#xiaoqu").val(plotName);
        $("#plotId").val(plotId);
        $("#autoComplete-div").css({display: "none"});
    });

    //自动补全小区
    document.getElementById("xiaoqu").oninput = (e) => {
        var plotName = -e.target.value;
        $.ajax({
            url: "http://localhost:8080/renting/plot/autocomplete?plotName=" + plotName,
            type: "GET",
            success: function (res) {
                if (res) {
                    var plots = res.data;
                    if (plots.length > 0) {
                        var html = "";
                        for (var i = 0; i < plots.length; i++) {
                            html += "<li plotId='" + plots[i].id +"' plotName='" + plots[i].plotName + "' class=''>"
                                + plots[i].plotName +
                                "<cite>" + plots[i].address + "</cite>" + "</li>";
                        }
                        $(".autoComplete-ul").html(html);
                        $("#autoComplete-div").css({display: "block"});
                    } else {
                        $("#autoComplete-div").css({display: "none"});
                    }
                } else {
                    $("#autoComplete-div").css({display: "none"});
                }
            }
        });
    }
    //表单提交
    $("div.submit_wrap").children().click(function () {
        //校验标识符
        var flag = true;
        //校验输入框是否为空
        $(".input_text_wrap").each(function () {
            flag = checkInput($(this).children("input"));
            if (!flag) {
                $(this).children("input").focus();
                return false;
            }
        });
        if (flag && checkPhone($("div[name='phone']").children('input'))) {
            var form = $("#postForm");
            var data = {};
            var formData = new FormData(form[0]);
            form.find('.input_text_wrap').each(function () {
                var key = $(this).attr("name");
                data[key] = $(this).children('input').val();
            });
            form.find('.textarea_wrap').each(function () {
                var key = $(this).attr("name");
                data[key] = $(this).children('textarea').val();

            });
            form.find('.checkbox_wrap').each(function () {
                var key = $(this).attr("name");
                var arr = [];
                $(this).children(".checkbox.focus").each(function () {
                    var value = $(this).attr('data-value');
                    arr.push(value)
                });
                data[key] = arr
            });
            form.find('.radio_wrap').each(function () {
                var key = $(this).attr("name");
                data[key] = $(this).children('.radio.focus').attr('data-value');

            });
            form.find('.selectordef').each(function () {
                var key = $(this).attr("name");
                data[key] = $(this).find('li.s').attr('val');
            });
            data["plotId"]=$("#plotId").val();
            $.ajax({
                url: "http://localhost:8080/renting/house",
                type: "POST",
                data: JSON.stringify(data),
                contentType: false,
                processData: false,
                success: function (data) {
                    if (data === "success") {
                        location.href = "user_login.html";
                    } else {
                        alert(data);
                    }
                },
                error: function () {
                    alert("请求错误");
                }
            });
        }

    });
    //点击添加图片
    $(".add_img_small").click(function () {
        $(".upload_wrap").css({display: 'block'});
    });

});

//删除图片
function deleteImg(d) {

    var li = d.parentElement;
    var imgList = $('.img_list')[0];
    imgList.removeChild(li);
    if (imgList.children.length <= 0) {
        $(".add_img_small").removeClass('show');
        $(".upload_wrap").css({display: 'block'});
    }

}

function checkInput(s) {
    if (s.val() === "" || s.val().trim() === '') {
        s.parent().removeClass('focus');
        s.parent().addClass('error');
        var title = s.parents('div.rows_wrap').children('div.rows_title').children().text();
        s.parent().siblings('.tip').html('<i></i>' + title + '不完整');
        s.parent().siblings('.tip').removeClass('validate_success');
        s.parent().siblings('.tip').addClass('validate_error');
        s.parent().siblings('.tip').css({'left': '0px'});
        return false;
    } else {
        var flag = true;
        s.parent().siblings().each(function () {
            if ($(this).children('input').val() === "" || s.val().trim() === '') {
                $(this).removeClass('focus');
                $(this).addClass('error');
                var title = s.parents('div.rows_wrap').children('div.rows_title').children().text();
                $(this).siblings('.tip').html('<i></i>' + title + '不完整');
                $(this).siblings('.tip').removeClass('validate_success');
                $(this).siblings('.tip').addClass('validate_error');
                $(this).siblings('.tip').css({'left': '0px'});
                flag = false;
            }
        });
        if (!flag) {
            return false;
        }
        s.parent().removeClass('focus');
        s.parent().removeClass('error');
        s.parent().siblings('.tip').html('<i></i>');
        s.parent().siblings('.tip').removeClass('validate_error');
        s.parent().siblings('.tip').addClass('validate_success');
        s.parent().siblings('.tip').css({'left': '552px'});
        return true;
    }
}

function checkPhone(s) {
    var mobile = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1})|(17[0-9]{1}))+\d{8})$/;
    if (s.val().match(mobile)) {
        return true;
    } else {
        s.parent().removeClass('focus');
        s.parent().addClass('error');
        s.parent().siblings('.tip').html('<i></i>' + '请输入正确的电话号码');
        s.parent().siblings('.tip').removeClass('validate_success');
        s.parent().siblings('.tip').addClass('validate_error');
        s.parent().siblings('.tip').css({'left': '0px'});
        return false;
    }
}
