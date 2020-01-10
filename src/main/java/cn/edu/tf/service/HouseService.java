package cn.edu.tf.service;

import cn.edu.tf.dto.HouseDTO;
import cn.edu.tf.dto.PageRequest;
import cn.edu.tf.pojo.House;
import com.github.pagehelper.Page;

import javax.servlet.http.HttpSession;

/**
 * @author : 王俊
 * @date : 2019/10/10 14:29
 **/
public interface HouseService {
    /**添加房源
     * @param house 房源信息
     */
    String add(House house);

    Page<HouseDTO> selectByCondition(HttpSession session, PageRequest pageRequest);

    Page<HouseDTO> selectByCity(int cityId, PageRequest pageRequest);

    Page<HouseDTO> selectByLocation(int locationId, PageRequest pageRequest);


    HouseDTO selectById(Integer houseId);
}
