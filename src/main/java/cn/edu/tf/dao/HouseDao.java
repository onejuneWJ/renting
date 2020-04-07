package cn.edu.tf.dao;

import cn.edu.tf.constant.Constant;
import cn.edu.tf.dto.HouseDTO;
import cn.edu.tf.pojo.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HouseDao {
    long countByExample(HouseExample example);

    int deleteByExample(HouseExample example);

    int deleteByPrimaryKey(Long id);

    int insert(House record);

    int insertSelective(House record);

    List<House> selectByExample(HouseExample example);

    House selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") House record, @Param("example") HouseExample example);

    int updateByExample(@Param("record") House record, @Param("example") HouseExample example);

    int updateByPrimaryKeySelective(House record);

    int updateByPrimaryKey(House record);

    List<HouseDTO> selectByCity(int cityId);

    List<HouseDTO> selectByLocation(int locationId);

    List<HouseDTO> selectByCondition(@Param("city")City city,
                                     @Param("location")Location location,
                                     @Param("rentals")Constant.Rentals rentals,
                                     @Param("houseType")Constant.HouseType houseType,
                                     @Param("towards")Towards towards);

    HouseDTO selectById(Integer houseId);

    List<HouseDTO> myPost(@Param("userId") Long userId);

    List<HouseDTO> listForAdmin(@Param("house") House house);
}