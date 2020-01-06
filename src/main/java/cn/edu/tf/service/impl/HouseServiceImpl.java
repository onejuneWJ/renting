package cn.edu.tf.service.impl;

import cn.edu.tf.dao.HouseDao;
import cn.edu.tf.pojo.City;
import cn.edu.tf.pojo.House;
import cn.edu.tf.pojo.HouseExample;
import cn.edu.tf.pojo.TestDataExample;
import cn.edu.tf.service.HouseService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author : 王俊
 * @date : 2019/10/10 14:30
 **/
@Service
public class HouseServiceImpl implements HouseService {
    @Autowired
    private HouseDao houseDao;
    @Override
    public String add(House house) {
        return "success";
    }

    @Override
    public List<House> selectByCondition(int index, HttpSession session) {
        return null;
    }

    @Override
    public List<House> selectByCity(City city, Integer page, Integer limit) {
        PageHelper.startPage(page, limit, true);
        return houseDao.selectByCity(city.getId());
    }
}
