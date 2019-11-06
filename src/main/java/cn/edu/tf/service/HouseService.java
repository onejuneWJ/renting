package cn.edu.tf.service;

import cn.edu.tf.pojo.House;

/**
 * @author : 王俊
 * @date : 2019/10/10 14:29
 **/
public interface HouseService {
    /**添加房源
     * @param house 房源信息
     */
    String add(House house);
}
