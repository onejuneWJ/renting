package cn.edu.tf.dao;

import cn.edu.tf.pojo.RentalInclude;
import cn.edu.tf.pojo.RentalIncludeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RentalIncludeDao {
    long countByExample(RentalIncludeExample example);

    int deleteByExample(RentalIncludeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RentalInclude record);

    int insertSelective(RentalInclude record);

    List<RentalInclude> selectByExample(RentalIncludeExample example);

    RentalInclude selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RentalInclude record, @Param("example") RentalIncludeExample example);

    int updateByExample(@Param("record") RentalInclude record, @Param("example") RentalIncludeExample example);

    int updateByPrimaryKeySelective(RentalInclude record);

    int updateByPrimaryKey(RentalInclude record);
}