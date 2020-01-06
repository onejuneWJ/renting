package cn.edu.tf.test;

import cn.edu.tf.dao.HouseDao;
import cn.edu.tf.dao.HouseIncludeDao;
import cn.edu.tf.dto.HouseDTO;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author : 王俊
 * @date : 2019/10/10 9:29
 **/
public class Test2 {
    @Test
    public void selectZXS() {
        String xml = "applicationContext.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xml);
        HouseDao houseDao=applicationContext.getBean(HouseDao.class);
        HouseIncludeDao houseIncludeDao=applicationContext.getBean(HouseIncludeDao.class);
        List<HouseDTO> houseList=houseDao.selectByCity(440300);
        System.out.println(houseList);

        System.out.println(houseList);
    }
}
