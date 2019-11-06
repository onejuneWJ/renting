package cn.edu.tf.constant;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : 王俊
 * @date : 2019/9/29 9:42
 **/
public class Constant {
    public static String SUCCESS = "success";

    interface Rental {
        String QZ1 = "500元以下";
        String QZ2 = "500-800元";
        String QZ3 = "800-1000元";
        String QZ4 = "1000-1500元";
        String QZ5 = "1500-2000元";
        String QZ6 = "2000-3000元";
        String QZ7 = "3000-5000元";
        String QZ8 = "5000-8000元";
        String QZ9 = "8000元以上";
    }
    interface HouseType{
        String FX1="一室";
        String FX2="二室";
        String FX3="三室";
        String FX4="四室";
        String FX5="五室及以上";
    }
    public static List<String> RENTAL_KEY_LIST=new ArrayList<>();
    public static List<String> HOUSE_TYPE_KEY_LIST=new ArrayList<>();
    static {
        RENTAL_KEY_LIST.add(Rental.QZ1);
        RENTAL_KEY_LIST.add(Rental.QZ2);
        RENTAL_KEY_LIST.add(Rental.QZ3);
        RENTAL_KEY_LIST.add(Rental.QZ4);
        RENTAL_KEY_LIST.add(Rental.QZ5);
        RENTAL_KEY_LIST.add(Rental.QZ6);
        RENTAL_KEY_LIST.add(Rental.QZ7);
        RENTAL_KEY_LIST.add(Rental.QZ8);
        RENTAL_KEY_LIST.add(Rental.QZ9);
        HOUSE_TYPE_KEY_LIST.add(HouseType.FX1);
        HOUSE_TYPE_KEY_LIST.add(HouseType.FX2);
        HOUSE_TYPE_KEY_LIST.add(HouseType.FX3);
        HOUSE_TYPE_KEY_LIST.add(HouseType.FX4);
        HOUSE_TYPE_KEY_LIST.add(HouseType.FX5);
    }
}
