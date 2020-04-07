package cn.edu.tf.controller;

import cn.edu.tf.dao.CityDao;
import cn.edu.tf.dao.LocationDao;
import cn.edu.tf.dto.ResponseData;
import cn.edu.tf.pojo.Location;
import cn.edu.tf.pojo.LocationExample;
import cn.edu.tf.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author : 王俊
 * @date : 2019/9/29 14:28
 **/
@RestController
@RequestMapping("/location")
public class LocationController {
    @Autowired
    LocationService locationService;

//    /**
//     * 获取当前城市区域信息
//     *
//     * @return
//     */
//    @GetMapping("/location")
//    public ResponseData<List<Location>> getLocation(HttpSession session) {
//        ResponseData<List<Location>> responseData = new ResponseData<>();
//        LocationExample locationExample = new LocationExample();
//        locationExample.createCriteria().andCityIdEqualTo(1);
//        List<Location> locationList=locationDao.selectByExample(locationExample);
//
//        responseData.setData(locationList);
//        return responseData;
//    }

    @GetMapping
    public ResponseData<List<Location>> list(Location location){
        return ResponseData.ok(locationService.list(location));
    }
}
