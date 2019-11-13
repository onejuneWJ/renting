package cn.edu.tf.controller;

import cn.edu.tf.dao.CityDao;
import cn.edu.tf.dao.ProvinceDao;
import cn.edu.tf.dto.ResponseData;
import cn.edu.tf.pojo.City;
import cn.edu.tf.pojo.TestData;
import cn.edu.tf.service.TestDataService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: 王俊
 * @Date: 2019/8/19 15:22
 **/
@RestController
@RequestMapping("/test")

public class TestController {


    private TestDataService testDataService;

    private ProvinceDao provinceDao;

    private CityDao cityDao;

    public TestController(TestDataService testDataService, ProvinceDao provinceDao, CityDao cityDao) {
        this.testDataService = testDataService;
        this.provinceDao = provinceDao;
        this.cityDao = cityDao;
    }
    @RequestMapping("/list")
    public ResponseData<List<TestData>> testList(Integer page, Integer limit){
        return ResponseData.pageOk(testDataService.pageList(page,limit));
    }
    @RequestMapping("/cities")
    public ResponseData<List<City>> cities(){
        return ResponseData.ok(cityDao.selectByExample(null),"success");
    }
    @DeleteMapping("/{id}")
    public ResponseData delete(@PathVariable int id) {
        ResponseData<TestData> responseData = new ResponseData<>();
        responseData.setMsg(testDataService.delete(id));
        return responseData;
    }

}
