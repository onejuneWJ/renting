package cn.edu.tf.dao;

import cn.edu.tf.pojo.Requires;
import cn.edu.tf.pojo.RequiresExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RequiresDao {
    long countByExample(RequiresExample example);

    int deleteByExample(RequiresExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Requires record);

    int insertSelective(Requires record);

    List<Requires> selectByExample(RequiresExample example);

    Requires selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Requires record, @Param("example") RequiresExample example);

    int updateByExample(@Param("record") Requires record, @Param("example") RequiresExample example);

    int updateByPrimaryKeySelective(Requires record);

    int updateByPrimaryKey(Requires record);
}