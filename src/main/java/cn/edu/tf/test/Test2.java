package cn.edu.tf.test;

import cn.edu.tf.dao.ContactInformationDao;
import cn.edu.tf.pojo.ContactInformation;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author : 王俊
 * @date : 2019/10/10 9:29
 **/
public class Test2 {
    @Test
    public void selectZXS() {
        ContactInformation contactInformation = new ContactInformation();
        contactInformation.setName("王俊");
        contactInformation.setGender(1);
        contactInformation.setPhone("18227010296");
        contactInformation.setReceiveTimeStart("10:00");
        contactInformation.setReceiveTimeEnd("21:00");

        String xml = "applicationContext.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xml);
        ContactInformationDao contactInformationDao = applicationContext.getBean(ContactInformationDao.class);
        contactInformationDao.insert(contactInformation);
    }
}
