package cn.edu.tf.service;

import cn.edu.tf.dto.HouseDTO;
import cn.edu.tf.dto.PageRequest;
import cn.edu.tf.pojo.House;
import com.github.pagehelper.Page;

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

    Page<HouseDTO> selectByCity(int cityId, PageRequest pageRequest);
}
