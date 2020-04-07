package cn.edu.tf.controller;

import cn.edu.tf.constant.Constant;
import cn.edu.tf.dao.HouseDao;
import cn.edu.tf.dao.TowardsDao;
import cn.edu.tf.dto.HouseDTO;
import cn.edu.tf.dto.PageRequest;
import cn.edu.tf.pojo.City;
import cn.edu.tf.pojo.Location;
import cn.edu.tf.service.HouseService;
import cn.edu.tf.service.LocationService;
import com.github.pagehelper.Page;
import org.apache.commons.lang3.StringUtils;
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
    public String index(HttpSession session, Model model, PageRequest pageRequest,
                        String rentalSort, String timeSort, String sortFlag) {
        if (!StringUtils.isEmpty(rentalSort)) {
            PageRequest.Sort sort = new PageRequest.Sort();
            sort.setClause("rental");
            sort.setDirection(rentalSort);
            pageRequest.getSortList().add(sort);
            model.addAttribute("rentalSort", rentalSort);
        } else{
            model.addAttribute("rentalSort", null);
        }
        if (!StringUtils.isEmpty(timeSort)) {
            PageRequest.Sort sort = new PageRequest.Sort();
            sort.setClause("post_time");
            sort.setDirection(timeSort);
            pageRequest.getSortList().add(sort);
            model.addAttribute("timeSort", timeSort);
        } else {
            model.addAttribute("timeSort", null);
        }
        City city = (City)session.getAttribute("CITY");
        int cityId = city != null ? city.getId() : 110100;
        Page<HouseDTO> houseList = houseService.selectByCity(cityId, pageRequest);
        model.addAttribute("houseList", houseList);
        model.addAttribute("count", houseList.getTotal());
        model.addAttribute("page", pageRequest.getPage());
        model.addAttribute("limit", pageRequest.getLimit());
        model.addAttribute("sortFlag", sortFlag);
        return "index";
    }

    /**
     * 筛选条件信息
     * @param session
     * @return
     */
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
    public String postHouse() {
        return "house_post";
    }
}
