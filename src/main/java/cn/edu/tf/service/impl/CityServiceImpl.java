package cn.edu.tf.service.impl;

import cn.edu.tf.dao.CityDao;
import cn.edu.tf.pojo.City;
import cn.edu.tf.pojo.CityExample;
import cn.edu.tf.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * @author : 王俊
 * @date : 2019/11/4 19:05
 **/
@Service
public class CityServiceImpl implements CityService {
    @Autowired
    private CityDao cityDao;

    @Override
    public List<City> list(City city) {
        CityExample cityExample=new CityExample();
        CityExample.Criteria criteria = cityExample.createCriteria();
        if(!Objects.isNull(city.getProvinceId())){
            criteria.andProvinceIdEqualTo(city.getProvinceId());
        }else {
            return null;
        }
        return cityDao.selectByExample(cityExample);
    }
}
