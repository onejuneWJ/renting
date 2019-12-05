package cn.edu.tf.controller;

import cn.edu.tf.dao.PlotDao;
import cn.edu.tf.dto.ResponseData;
import cn.edu.tf.pojo.Plot;
import cn.edu.tf.pojo.PlotExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author : 王俊
 * @date : 2019/11/15 14:03
 **/
@Controller
@RequestMapping("/plot")
public class PlotController {

    @Autowired
    private PlotDao plotDao;

    @GetMapping("/autocomplete")
    @ResponseBody
    public ResponseData<List<Plot>> list(String plotName) {
        if(StringUtils.isEmpty(plotName)){
            return null;
        }
        PlotExample plotExample = new PlotExample();
        plotExample.createCriteria().andPlotNameLike("%" + plotName + "%");
        return ResponseData.ok(plotDao.selectByExample(plotExample));
    }

}
