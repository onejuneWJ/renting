package cn.edu.tf.dao;

import cn.edu.tf.pojo.Img;
import cn.edu.tf.pojo.ImgExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ImgDao {
    long countByExample(ImgExample example);

    int deleteByExample(ImgExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Img record);

    int insertSelective(Img record);

    List<Img> selectByExample(ImgExample example);

    Img selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Img record, @Param("example") ImgExample example);

    int updateByExample(@Param("record") Img record, @Param("example") ImgExample example);

    int updateByPrimaryKeySelective(Img record);

    int updateByPrimaryKey(Img record);
}