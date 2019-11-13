package cn.edu.tf.service.impl;

import cn.edu.tf.dao.TestDataDao;
import cn.edu.tf.pojo.TestData;
import cn.edu.tf.pojo.TestDataExample;
import cn.edu.tf.service.TestDataService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: 王俊
 * @Date: 2019/8/19 15:56
 **/
@Service
public class TestDataServiceImpl implements TestDataService {
    @Autowired
    private TestDataDao testDataDao;

    @Override
    public PageInfo<TestData> pageList(Integer page, Integer size) {

        return PageHelper.startPage(page, size, true)
            .doSelectPageInfo(() -> testDataDao.selectByExample(new TestDataExample()));

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
