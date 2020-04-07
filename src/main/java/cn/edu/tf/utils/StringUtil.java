package cn.edu.tf.utils;

import org.springframework.util.StringUtils;

import java.sql.Timestamp;
import java.util.Random;
import java.util.UUID;

/**
 * @author onejune
 */
public class StringUtil {
    public static void main(String[] args) {
        System.out.println(getCheckCode());
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
        if(StringUtils.isEmpty(str)){
            return new String[]{};
        }
        String s=str.replace(" ","");
        return s.substring(1,s.lastIndexOf(']')).split(",");
    }

    /**
     * 将数组转换为字符串
     * 如：[11,22,33]转换为"[11,22,33]"
     * @param arr 需要转换的数组
     * @return 转换后的字符串
     */
    public static String arrayToString(Object [] arr){
        StringBuilder sb=new StringBuilder();
        sb.append('[');
        for (Object s:arr) {
            sb.append(s).append(",");
        }
        sb.deleteCharAt(sb.length()-1);
        sb.append(']');
        return sb.toString();
    }
    public static String getCheckCode() {
        String base = "0123456789ABCDEFGabcdefg";
        int size = base.length();
        Random r = new Random();
        StringBuffer sb = new StringBuffer();
        for(int i=1;i<=4;i++){
            //产生0到size-1的随机值
            int index = r.nextInt(size);
            //在base字符串中获取下标为index的字符
            char c = base.charAt(index);
            //将c放入到StringBuffer中去
            sb.append(c);
        }
        return sb.toString();
    }
    public static String getNumberCode(){
        String base = "0123456789";
        int size = base.length();
        Random r = new Random();
        StringBuilder sb=new StringBuilder();
        for(int i=1;i<=4;i++){
            //产生0到size-1的随机值
            int index = r.nextInt(size);
            //在base字符串中获取下标为index的字符
            char c = base.charAt(index);
            //将c放入到StringBuffer中去
            sb.append(c);
        }
        return sb.toString();

    }
}
