package cn.edu.tf.utils;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

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
}
