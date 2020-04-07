package cn.edu.tf.dao;

import cn.edu.tf.pojo.Deal;
import cn.edu.tf.pojo.DealExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface DealDao {
    long countByExample(DealExample example);

    int deleteByExample(DealExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Deal record);

    int insertSelective(Deal record);

    List<Deal> selectByExample(DealExample example);

    Deal selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Deal record, @Param("example") DealExample example);

    int updateByExample(@Param("record") Deal record, @Param("example") DealExample example);

    int updateByPrimaryKeySelective(Deal record);

    int updateByPrimaryKey(Deal record);

    List<Deal> list(Deal deal);

    List<Deal> myDeal(Long userId);
}