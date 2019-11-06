package cn.edu.tf.dao;

import cn.edu.tf.pojo.Plot;
import cn.edu.tf.pojo.PlotExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PlotDao {
    long countByExample(PlotExample example);

    int deleteByExample(PlotExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Plot record);

    int insertSelective(Plot record);

    List<Plot> selectByExample(PlotExample example);

    Plot selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Plot record, @Param("example") PlotExample example);

    int updateByExample(@Param("record") Plot record, @Param("example") PlotExample example);

    int updateByPrimaryKeySelective(Plot record);

    int updateByPrimaryKey(Plot record);
}