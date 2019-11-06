package cn.edu.tf.service.impl;

import cn.edu.tf.pojo.House;
import cn.edu.tf.service.HouseService;
import org.springframework.stereotype.Service;

/**
 * @author : 王俊
 * @date : 2019/10/10 14:30
 **/
@Service
public class HouseServiceImpl implements HouseService {
    @Override
    public String add(House house) {
        return "success";
    }
}
