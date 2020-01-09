(function () {

    /**
     * 下拉列表
     * @param id
     * @param data
     * @param tag
     */
    function makeSelector(id, data, tag) {
        var $selector = $("#" + id);
        var $result = $("#" + id + "-result");
        var $options = $("#" + id + "-box");
        var $arrow = $("#" + id + "-arrow");
        $selector.off("click");
        if (tag) {
            $result.html("城市")
        }
        $options.empty();
        $options.css("max-height", 15 * 30 + "px");
        for (key in data) {
            if (data.hasOwnProperty(key)) {
                $options.append($('<li class="selector-list" data-city="' + data[key] + '">' + key + "</li>"))
            }
        }
        $selector.on("click", function (event) {
            event.preventDefault();
            for (var i = 0; i < $(".selector-box").length; i++) {
                if ($(".selector-box")[i] != $options[0]) {
                    $(".selector-box").eq(i).hide()
                }
            }
            $options.toggle();
            $arrow.toggleClass("selector-arrow-up")
        });
        $selector.on("click", ".selector-list", function (event) {
            event.preventDefault();
            $result.html(event.target.innerHTML);
            if (tag == "city") {
                window.location.href = "http://localhost:8080/renting/house/" + event.target.dataset["city"].split("|")[1];
            } else {
                makeSelector("selector-city", cityList[event.target.innerHTML], "city")
            }
        });
        $("body").eq(0).on("click", function (event) {
            if (event.target.className.indexOf("selector") == -1) {
                $options.hide();
                $arrow.removeClass("selector-arrow-up")
            }
        })
    }

    /**
     * 字母排序城市信息
     */
    function makeCityList() {
        var $contentBox = $("#content-box");
        var list = ["A", "F", "G", "H", "J", "L", "N", "Q", "S", "X", "Y", "Z", " "];
        for (var i = 0; i < list.length; i++) {
            var $contentLetter = $('<div class="content-letter"><span class="content-letter-panel">' + list[i] + "</span></div>");
            $contentBox.append($contentLetter);
            for (var provinceName in provinceList) {
                if (provinceList[provinceName] == list[i]) {
                    var $contentProvince = $('<div class="content-province"><span class="content-province-triangle"></span><div class="content-province-title">' + provinceName + "</div></div>");
                    var $contentCities = $('<div class="content-cities"></div>');
                    var address = "";
                    for (var cityName in cityList[provinceName]) {
                        address = "http://localhost:8080/renting/house/" + cityList[provinceName][cityName].split("|")[1];
                        $contentCities.append($('<a href="' + address + '" class="content-city">' + cityName + "</a>"))
                    }
                    $contentProvince.append($contentCities);
                    $contentLetter.append($contentProvince)
                }
            }
        }

    }

    makeSelector("selector-province", provinceList);
    makeCityList();
    var $panels = $(".content-letter-panel");
    var $letters = $(".content-letter");
    var $provinceTitles = $(".content-province-title");
    var $provinceTriangle = $(".content-province-triangle");
    var $provinces = $(".content-province");
    $provinces.each(function (index, el) {
        $provinceTitles.eq(index).css("height", $(el).css("height"));
        $(el).on("mouseover", function (event) {
            $provinceTriangle.eq(index).addClass("content-province-triangle-hover");
            $(el).addClass("content-province-hover")
        });
        $(el).on("mouseout", function (event) {
            $provinceTriangle.eq(index).removeClass("content-province-triangle-hover");
            $(el).removeClass("content-province-hover")
        })
    });
    $letters.each(function (index, el) {
        $panels.eq(index).css({height: $(el).css("height"), "line-height": $(el).css("height")});
        $(el).on("mouseover", function (event) {
            $panels.eq(index).addClass("content-letter-panle-hover")
        });
        $(el).on("mouseout", function (event) {
            $panels.eq(index).removeClass("content-letter-panle-hover")
        })
    });
    $("#selector-search-input").on("keydown", function (event) {
        if (event.keyCode == 13) {
            $("#selector-search-btn").click()
        }
    });
    $("#selector-search-btn").on("click", function (event) {
        goCity(document.getElementById("selector-search-input").value, searchpath)
    });
})();
