package cn.edu.tf.dao;

import cn.edu.tf.pojo.House;
import cn.edu.tf.pojo.HouseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

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
}