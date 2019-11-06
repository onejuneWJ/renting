package cn.edu.tf.service.impl;

import cn.edu.tf.dao.LocationDao;
import cn.edu.tf.pojo.Location;
import cn.edu.tf.pojo.LocationExample;
import cn.edu.tf.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : 王俊
 * @date : 2019/11/4 19:06
 **/
@Service
public class LocationServiceImpl implements LocationService {
    @Autowired
    LocationDao locationDao;
    @Override
    public List<Location> selectByCityId(Integer id) {
        LocationExample locationExample=new LocationExample();
        locationExample.createCriteria().andCityIdEqualTo(id);
        return locationDao.selectByExample(locationExample);
    }
}
