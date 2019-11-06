package cn.edu.tf.dao;

import cn.edu.tf.pojo.ImgBox;
import cn.edu.tf.pojo.ImgBoxExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ImgBoxDao {
    long countByExample(ImgBoxExample example);

    int deleteByExample(ImgBoxExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ImgBox record);

    int insertSelective(ImgBox record);

    List<ImgBox> selectByExample(ImgBoxExample example);

    int updateByExampleSelective(@Param("record") ImgBox record, @Param("example") ImgBoxExample example);

    int updateByExample(@Param("record") ImgBox record, @Param("example") ImgBoxExample example);
}