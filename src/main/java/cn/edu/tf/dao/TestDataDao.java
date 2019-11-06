package cn.edu.tf.dao;

import cn.edu.tf.pojo.TestData;
import cn.edu.tf.pojo.TestDataExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TestDataDao {
    long countByExample(TestDataExample example);

    int deleteByExample(TestDataExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TestData record);

    int insertSelective(TestData record);

    List<TestData> selectByExampleWithBLOBs(TestDataExample example);

    List<TestData> selectByExample(TestDataExample example);

    TestData selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TestData record, @Param("example") TestDataExample example);

    int updateByExampleWithBLOBs(@Param("record") TestData record, @Param("example") TestDataExample example);

    int updateByExample(@Param("record") TestData record, @Param("example") TestDataExample example);

    int updateByPrimaryKeySelective(TestData record);

    int updateByPrimaryKeyWithBLOBs(TestData record);

    int updateByPrimaryKey(TestData record);
}