package cn.edu.tf.utils;

import com.google.gson.JsonObject;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;

import java.io.IOException;

/**
 * @author : 王俊
 * @date : 2019/10/9 15:57
 **/
public class HttpUtils {
    public static Response sendRequest(String url) {
        Response response = null;
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
            .url(url)
            .build();
        try {
            response = client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }
    public static boolean sendCode(String code,String phone) {
        Response response=sendRequest("http://v.juhe.cn/sms/send?mobile="+phone+"&tpl_id=&tpl_value="+code+"&key=");
        if (response.body() != null) {
            try {
                String res=response.body().string();
                JSONObject jsonObject=new JSONObject(res);
                int errorCode=jsonObject.getInt("error_code");
                if(errorCode==0){
                    return true;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
