package cn.edu.tf.dao;

import cn.edu.tf.pojo.HouseInclude;
import cn.edu.tf.pojo.HouseIncludeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HouseIncludeDao {
    long countByExample(HouseIncludeExample example);

    int deleteByExample(HouseIncludeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(HouseInclude record);

    int insertSelective(HouseInclude record);

    List<HouseInclude> selectByExample(HouseIncludeExample example);

    HouseInclude selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") HouseInclude record, @Param("example") HouseIncludeExample example);

    int updateByExample(@Param("record") HouseInclude record, @Param("example") HouseIncludeExample example);

    int updateByPrimaryKeySelective(HouseInclude record);

    int updateByPrimaryKey(HouseInclude record);
}