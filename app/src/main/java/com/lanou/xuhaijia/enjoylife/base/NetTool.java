package com.lanou.xuhaijia.enjoylife.base;


import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by 徐海佳 on 16/9/12.
 */
public class NetTool {
    private Handler mHandler;
    private Object t;

    public NetTool() {
        mHandler = new Handler(Looper.getMainLooper());
    }

    public <T> void getData(String url, final Class<T> clazz, final NetInterface<T> netInterface) {
        Request request = new Request.Builder()
                .url(url)
                .build();
        OkHttpUtils.getInstance().getClient().newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                netInterface.onError(e.getMessage());
                Log.d("NetTool", "请求失败");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final Gson gson =  new Gson();
                //
                String data = response.body().string();
                if (data.startsWith("{\"")) {
                    t = gson.fromJson(data, clazz);
                } else {
                    int start = data.indexOf("{\"");
                    int end = data.indexOf(");");
                    t = gson.fromJson(data.substring(start , end) , clazz);
                }
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        netInterface.onSuccess((T) t);
                    }
                });
            }
        });
    }


    // 网络请求的接口,有成功方法, 有失败方法
    public interface NetInterface<T> {
        void onSuccess(T t);

        void onError(String errorMsg);
    }

}
