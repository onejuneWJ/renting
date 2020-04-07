package cn.edu.tf.controller;

import cn.edu.tf.dao.CityDao;
import cn.edu.tf.dao.ProvinceDao;
import cn.edu.tf.dto.ResponseData;
import cn.edu.tf.pojo.City;
import cn.edu.tf.pojo.CityExample;
import cn.edu.tf.pojo.Province;
import cn.edu.tf.service.CityService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author : 王俊
 * @date : 2020/1/9 11:12
 **/
@Controller
@RequestMapping("/city")
public class CityController {
    @Autowired
    private CityDao cityDao;
    @Autowired
    private ProvinceDao provinceDao;
    @Autowired
    private CityService cityService;

    @GetMapping
    @ResponseBody
    public ResponseData<List<City>> list(City city){
        return ResponseData.ok(cityService.list(city));
    }


    /**
     * 设置城市信息到session中
     *
     * @param cityName 城市名称
     * @param session  session
     * @return 城市信息
     */
    @PostMapping
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

    @GetMapping("/all")
    @ResponseBody
    public List<City> cityList(){
        List<Province> provinceList=provinceDao.selectByExample(null);
        JSONObject jsonObject=new JSONObject();
        provinceList.forEach(province -> {
            CityExample cityExample=new CityExample();
            cityExample.createCriteria().andProvinceIdEqualTo(province.getId());
            List<City> cityList=cityDao.selectByExample(cityExample);
            JSONObject provinceObject=new JSONObject();


            String pro;
            if(province.getName().contains("省")){
                pro=province.getName().substring(0,province.getName().lastIndexOf("省"));
            }else {
                pro=province.getName();
            }
            jsonObject.put(pro,"");
        });
        return null;
    }
}
