package cn.edu.tf.service;

import cn.edu.tf.pojo.Location;

import java.util.List;

/**
 * @author : 王俊
 * @date : 2019/11/4 19:06
 **/
public interface LocationService {
    List<Location> selectByCityId(Integer id);
}
