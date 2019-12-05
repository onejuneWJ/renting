package cn.edu.tf.test;

import cn.edu.tf.dao.CityDao;
import cn.edu.tf.dao.LocationDao;
import cn.edu.tf.dao.ProvinceDao;
import cn.edu.tf.pojo.City;
import cn.edu.tf.pojo.Location;
import cn.edu.tf.pojo.Province;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

import java.io.*;

/**
 * @author : 王俊
 * @date : 2019/10/9 14:21
 **/
@Controller
public class Test {

    @org.junit.Test
    public void test() {
        String filePath = "C:/Users/onejune/Desktop/img/city_code.json";
        String txtStr = reader(filePath);
        if (txtStr != null) {
            System.out.println(txtStr);
            process(txtStr);
        } else {
            System.out.println("Read the content is empty!");
        }
        System.out.println("--- end ---");
    }

    public String reader(String filePath) {
        try {
            File file = new File(filePath);
            if (file.isFile() && file.exists()) {
                InputStreamReader read = new InputStreamReader(new FileInputStream(file), "UTF-8");
                BufferedReader bufferedReader = new BufferedReader(read);
                StringBuilder txt = new StringBuilder();
                String str;
                while ((str = bufferedReader.readLine()) != null) {
                    txt.append(str);
                }
                return txt.toString();
            }
        } catch (UnsupportedEncodingException | FileNotFoundException e) {
            System.out.println("Cannot find the file specified!");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Error reading file content!");
            e.printStackTrace();
        }
        return null;
    }

    public void process(String txtStr) {
        String xml = "applicationContext.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xml);
        ProvinceDao provinceDao = applicationContext.getBean(ProvinceDao.class);
        CityDao cityDao = applicationContext.getBean(CityDao.class);
        LocationDao locationDao = applicationContext.getBean(LocationDao.class);

        JSONArray jsonArray = new JSONArray(txtStr);
        for (int i = 0; i < jsonArray.length(); i++) {
            //省信息
            JSONObject provinceData = jsonArray.getJSONObject(i);
            String provinceName = provinceData.getString("name");
            int provinceId = provinceData.getInt("code");
            Province province = new Province();
            province.setName(provinceName);
            province.setId(provinceId);
            System.out.println(province.toString());
            provinceDao.insert(province);
            //获取市
            JSONArray cities = provinceData.getJSONArray("city");
            for (int j = 0; j < cities.length(); j++) {
                JSONObject cityData = cities.getJSONObject(j);
                String cityName = cityData.getString("name");
                int cityId = cityData.getInt("code");
                City city = new City();
                city.setId(cityId);
                city.setName(cityName);
                city.setProvinceId(provinceId);
                System.out.println(city.toString());
                cityDao.insert(city);
                //获取县
                JSONArray areas = cityData.getJSONArray("area");
                for (int k = 0; k < areas.length(); k++) {
                    JSONObject areaData = areas.getJSONObject(k);
                    String areaName = areaData.getString("name");
                    int areaId = areaData.getInt("code");
                    Location location = new Location();
                    location.setCityId(cityId);
                    location.setId(areaId);
                    location.setName(areaName);
                    System.out.println(location.toString());
                    locationDao.insert(location);
                }
            }
        }

    }

}
