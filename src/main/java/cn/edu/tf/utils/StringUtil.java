package cn.edu.tf.utils;

import java.sql.Timestamp;
import java.util.UUID;

/**
 * @author onejune
 */
public class StringUtil {
    public static void main(String[] args) {
        String[] s=stringToArray("[111,22,32,123]");
        for (String s1 : s) {
            System.out.println(s1);
        }
        System.out.println(arrayToString(s));
    }

    /**
     * 获取Int类型的UUID
     *
     * @return UUID
     */
    public static int getIntUUID() {
        int a = UUID.randomUUID().hashCode();
        return a > 0 ? a : -a;
    }

    /**
     * 获取当前时间
     * @return 当前时间
     */
    public static Timestamp getTime() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        timestamp.setNanos(0);
        return timestamp;
    }

    /**
     * 字符串以','分割，转换为字符串数组
     * 如："11,22,33,11"转化为[11,22,33,11]
     * @param str 需要转换的字符串
     * @return 转换后的数组
     */
    public static String[] stringToArray(String str){
        return str.substring(1,str.lastIndexOf(']')).split(",");
    }

    /**
     * 将数组转换为字符串
     * 如：[11,22,33]转换为"[11,22,33]"
     * @param arr 需要转换的数组
     * @return 转换后的字符串
     */
    public static String arrayToString(String [] arr){
        StringBuilder sb=new StringBuilder();
        sb.append('[');
        for (String s:arr) {
            sb.append(s).append(",");
        }
        sb.deleteCharAt(sb.length()-1);
        sb.append(']');
        return sb.toString();
    }
}
