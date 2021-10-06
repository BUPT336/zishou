package com.marfei.site.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;

import java.io.IOException;
import java.util.Iterator;

/**
 * @author Litch1
 * @date 2021/5/18 3:03 上午
 */
public class MusicUtil {
    private String host = "http://127.0.0.1:3000";
    private static String cookie;
    public static final String USER_ID = "508732813";
    private static final String REAL_IP = "39.105.29.134";
    private OkHttpClient okHttpClient = new OkHttpClient();
    public void loginMusicCloud(String cellphone,String password){
        RequestBody requestBody = new FormBody.Builder()
                .add("realIp",REAL_IP)
                .add("phone",cellphone)
                .add("password",password).build();
        Request request = new Request.Builder().url(host + "/login/cellphone").post(requestBody).build();
        try {
            Response response = okHttpClient.newCall(request).execute();
            ObjectMapper mapper = new ObjectMapper();
            JsonNode jsonNode = mapper.readTree(response.body().string()).path("cookie");
            cookie = jsonNode.asText();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    //http://localhost:3000/user/record?uid=508732813&type=1
    public String getUserMusicListJson(String uid,String type) throws IOException{
        RequestBody requestBody = new FormBody.Builder()
                .add("realIp",REAL_IP)
                .add("uid",uid)
                .add("type",type).build();
        Request request = new Request.Builder()
                .url(host + "/user/record")
                .post(requestBody)
                // 接口不需要认证
                //.addHeader("Cookie",cookie)
                .build();
            Response response = okHttpClient.newCall(request).execute();
            return response.body().string();
    }




}
