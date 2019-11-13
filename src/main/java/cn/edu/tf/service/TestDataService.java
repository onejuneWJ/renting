package cn.edu.tf.service;

import cn.edu.tf.pojo.TestData;
import com.github.pagehelper.PageInfo;

/**
 * @Author: 王俊
 * @Date: 2019/8/19 15:56
 **/
public interface TestDataService {
    PageInfo<TestData> pageList(Integer page, Integer size);

    Long count();

    String delete(int id);
}
