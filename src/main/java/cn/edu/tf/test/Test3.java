package cn.edu.tf.test;

import cn.edu.tf.dao.CityDao;
import cn.edu.tf.dao.ContactInformationDao;
import cn.edu.tf.dao.HouseDao;
import cn.edu.tf.dao.ProvinceDao;
import cn.edu.tf.pojo.*;
import org.json.JSONObject;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @author : 王俊
 * @date : 2020/1/9 9:26
 **/
public class Test3 {
    @Test
    public void test() {
        String provinceName = "四川省";
        if (provinceName.contains("省")) {
            System.out.println(provinceName.substring(0, provinceName.lastIndexOf("省")));
        }
    }

    @Test
    public void insertHouse() {
        String xml = "applicationContext.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xml);
        HouseDao houseDao = applicationContext.getBean(HouseDao.class);
        ContactInformationDao contactInformationDao = applicationContext.getBean(ContactInformationDao.class);
        for (int i = 0; i < 1000; i++) {
            House house = new House();
            house.setUserId(1L);
            house.setPlotId((long)new Random().nextInt(10) + 1);
            house.setHuxingShi(new Random().nextInt(5) + 1);
            house.setHuxingTing(new Random().nextInt(2) + 1);
            house.setHuxingWei(new Random().nextInt(2) + 1);
            house.setArea(house.getHuxingShi() * 25 + house.getHuxingTing() * 30);
            house.setTotalFloor(new Random().nextInt(20) + 6);
            house.setCurrentFloor(new Random().nextInt(house.getTotalFloor()) + 1);
            house.setRental((double)(500 * house.getHuxingShi()) + Math.random() * 3000);
            house.setRentalInclude("[1, 2]");
            house.setHouseInclude("[1, 2, 6]");
            house.setRequire("[1, 5]");
            house.setPaymentId(new Random().nextInt(4) + 1);
            house.setTowardsId(new Random().nextInt(10) + 1);
            house.setDescription(house.getHuxingShi() + "室好房等你来");

            ContactInformation contactInformation = new ContactInformation();
            contactInformation.setName("王俊");
            contactInformation.setPhone("18227010296");
            contactInformation.setGender(1);
            contactInformation.setReceiveTimeStart("10:00");
            contactInformation.setReceiveTimeEnd("22:00");
            contactInformationDao.insertSelective(contactInformation);
            house.setContactInformationId(contactInformation.getId());

            house.setImgBoxId(4L);
            house.setPostTime(new Date());
            houseDao.insertSelective(house);
        }

    }

    @Test
    public void getCity() {
        String xml = "applicationContext.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xml);
        ProvinceDao provinceDao = applicationContext.getBean(ProvinceDao.class);
        CityDao cityDao = applicationContext.getBean(CityDao.class);
        List<Province> provinceList = provinceDao.selectByExample(null);
        JSONObject jsonObject = new JSONObject();
        provinceList.forEach(province -> {
            CityExample cityExample = new CityExample();
            cityExample.createCriteria().andProvinceIdEqualTo(province.getId());
            List<City> cityList = cityDao.selectByExample(cityExample);
            JSONObject provinceObject = new JSONObject();
            cityList.forEach(city -> {
                String ci;
                if(city.getName().contains("市")){
                    ci=city.getName().substring(0,city.getName().lastIndexOf("市"));
                }else {
                    ci=city.getName();
                }
                String citySub="xx|"+city.getId();

                provinceObject.put(ci, citySub);

            });
            String pro;
            if (province.getName().contains("省")) {
                pro = province.getName().substring(0, province.getName().lastIndexOf("省"));
            } else {
                pro = province.getName();
            }
            jsonObject.put(pro, provinceObject);
        });
        System.out.println(jsonObject.toString());
    }
}
