package cn.edu.tf.service;

import cn.edu.tf.dto.HouseDTO;
import cn.edu.tf.pojo.House;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author : 王俊
 * @date : 2019/10/10 14:29
 **/
public interface HouseService {
    /**添加房源
     * @param house 房源信息
     */
    String add(House house);

    List<HouseDTO> selectByCondition(int index, HttpSession session);
    
    List<HouseDTO> selectByCity(int cityId, Integer page, Integer limit);
}
