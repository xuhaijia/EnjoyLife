package com.lanou.xuhaijia.enjoylife.base;

import okhttp3.OkHttpClient;

/**
 * Created by 徐海佳 on 16/9/12.
 */
public class OkHttpUtils {
    private static OkHttpUtils ourInstance;
    private OkHttpClient client;

    // 构造方法私有化
    private OkHttpUtils() {
        //初始化 OkHttpClient
        client = new OkHttpClient();
    }

    public OkHttpClient getClient() {
        return client;
    }

    // 单例
    public static OkHttpUtils getInstance() {
        if (ourInstance == null) {
            synchronized (OkHttpUtils.class) {
                if (ourInstance == null) {
                    ourInstance = new OkHttpUtils();
                }
            }
        }
        return ourInstance;
    }


}