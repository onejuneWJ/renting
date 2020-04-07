package cn.edu.tf.dao;

import cn.edu.tf.pojo.Visit;
import cn.edu.tf.pojo.VisitExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VisitDao {
    long countByExample(VisitExample example);

    int deleteByExample(VisitExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Visit record);

    int insertSelective(Visit record);

    List<Visit> selectByExample(VisitExample example);

    Visit selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Visit record, @Param("example") VisitExample example);

    int updateByExample(@Param("record") Visit record, @Param("example") VisitExample example);

    int updateByPrimaryKeySelective(Visit record);

    int updateByPrimaryKey(Visit record);

    List<Visit> list(@Param(value="userId")Long userId);
}