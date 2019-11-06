package cn.edu.tf.dao;

import cn.edu.tf.pojo.Towards;
import cn.edu.tf.pojo.TowardsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TowardsDao {
    long countByExample(TowardsExample example);

    int deleteByExample(TowardsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Towards record);

    int insertSelective(Towards record);

    List<Towards> selectByExample(TowardsExample example);

    Towards selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Towards record, @Param("example") TowardsExample example);

    int updateByExample(@Param("record") Towards record, @Param("example") TowardsExample example);

    int updateByPrimaryKeySelective(Towards record);

    int updateByPrimaryKey(Towards record);
}