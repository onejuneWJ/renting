package cn.edu.tf.controller;

import cn.edu.tf.constant.Constant;
import cn.edu.tf.dao.HouseDao;
import cn.edu.tf.dao.TowardsDao;
import cn.edu.tf.dto.HouseDTO;
import cn.edu.tf.pojo.City;
import cn.edu.tf.pojo.Location;
import cn.edu.tf.service.HouseService;
import cn.edu.tf.service.LocationService;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : 王俊
 * @date : 2019/9/17 10:39
 **/
@Controller
public class IndexController {

    private LocationService locationService;
    private TowardsDao towardsDao;
    private HouseService houseService;
    private HouseDao houseDao;

    public IndexController(LocationService locationService, TowardsDao towardsDao, HouseService houseService, HouseDao houseDao) {
        this.locationService = locationService;
        this.towardsDao = towardsDao;
        this.houseService = houseService;
        this.houseDao = houseDao;
    }


    /**
     * 跳转至主页，同时查询基础信息
     *
     * @return 主页
     */
    @GetMapping("/index.htm")
    public String index(HttpSession session, Model model, Integer page, Integer limit) {
        City city = (City)session.getAttribute("CITY");
        int cityId = city != null ? city.getId() : 110100;
        List<HouseDTO> houseList=houseService.selectByCity(cityId, page==null?0:page, limit==null?20:limit);
        model.addAttribute("houseList",houseList);
        model.addAttribute("count", houseDao.countByExample(null));
        model.addAttribute("page",page);
        model.addAttribute("limit",limit);
        return "index";
    }

    @GetMapping("/query-data")
    @ResponseBody
    public String queryData(HttpSession session) {
        JSONObject jsonObject = new JSONObject();
        City city = (City)session.getAttribute("CITY");
        int cityId = city != null ? city.getId() : 110100;
        List<Location> locationList = locationService.selectByCityId(cityId);
        jsonObject.put("locations", locationList);
        jsonObject.put("rentals", Constant.Rentals.values());
        jsonObject.put("houseTypes", Constant.HouseType.values());
        jsonObject.put("towards", towardsDao.selectByExample(null));

        return jsonObject.toString();
    }

    /**
     * 获取多个session中的值
     *
     * @param keys    key
     * @param session session
     * @return session值
     */
    @PostMapping("/s")
    @ResponseBody
    public Object getSession(@RequestBody String[] keys, HttpSession session) {
        Map<String, Object> map = new HashMap<>(16);
        for (String key : keys) {
            map.put(key, session.getAttribute(key));
        }
        return map;
    }

    @GetMapping("/postHouse")
    public String postHouse(){
        return "house_post";
    }
}
