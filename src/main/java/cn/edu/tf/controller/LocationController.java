package cn.edu.tf.controller;

import cn.edu.tf.dao.CityDao;
import cn.edu.tf.dao.LocationDao;
import cn.edu.tf.dto.ResponseData;
import cn.edu.tf.pojo.City;
import cn.edu.tf.pojo.CityExample;
import cn.edu.tf.pojo.Location;
import cn.edu.tf.pojo.LocationExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author : 王俊
 * @date : 2019/9/29 14:28
 **/
@Controller
public class LocationController {
    @Autowired
    private CityDao cityDao;
    @Autowired
    private LocationDao locationDao;

    /**
     * 设置城市信息到session中
     *
     * @param cityName 城市名称
     * @param session  session
     * @return 城市信息
     */
    @PostMapping("/city")
    @ResponseBody
    public City setCity(String cityName, HttpSession session) {
        City city = new City();
        city.setName(cityName);
        CityExample cityExample = new CityExample();
        cityExample.createCriteria().andNameLike(cityName);
        List<City> cityList = cityDao.selectByExample(cityExample);
        city = cityList.size() > 0 ? cityList.get(0) : city;
        session.setAttribute("CITY", city);
        return city;
    }

    /**
     * 获取当前城市区域信息
     *
     * @return
     */
    @GetMapping("/location")
    public ResponseData<List<Location>> getLocation(HttpSession session) {
        ResponseData<List<Location>> responseData = new ResponseData<>();
        LocationExample locationExample = new LocationExample();
        locationExample.createCriteria().andCityIdEqualTo(1);
        List<Location> locationList=locationDao.selectByExample(locationExample);

        responseData.setData(locationList);
        return responseData;
    }
}
