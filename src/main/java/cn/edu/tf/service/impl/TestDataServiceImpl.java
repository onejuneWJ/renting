package cn.edu.tf.service.impl;

import cn.edu.tf.dao.TestDataDao;
import cn.edu.tf.pojo.TestData;
import cn.edu.tf.pojo.TestDataExample;
import cn.edu.tf.service.TestDataService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 王俊
 * @Date: 2019/8/19 15:56
 **/
@Service
public class TestDataServiceImpl implements TestDataService {
    @Autowired
    private TestDataDao testDataDao;

    @Override
    public List<TestData> pageList(Integer page, Integer size) {
        if (page != null && size != null) {
            PageHelper.startPage(page, size);
        }
        List<TestData> list = testDataDao.selectByExample(new TestDataExample());
        return list;
    }

    @Override
    public Long count() {
        return testDataDao.countByExample(null);
    }

    @Override
    public String delete(int id) {
        if (testDataDao.deleteByPrimaryKey((long)id) > 0) {
            return "success";
        } else {
            return "failed";
        }
    }
}
