package cn.edu.tf.dao;

import cn.edu.tf.dto.HouseDTO;
import cn.edu.tf.pojo.House;
import cn.edu.tf.pojo.HouseExample;
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

    List<HouseDTO> selectByCity(Integer cityId);
}