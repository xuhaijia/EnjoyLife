package com.lanou.xuhaijia.enjoylife.base;


import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

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

    public void getImage(String source, GetBitMap getBitMap) throws ExecutionException, InterruptedException {
        //// TODO: 16/9/18  一个asyncTask 获取图片
        MyAsyncTask myAsyncTask = new MyAsyncTask(getBitMap);
        myAsyncTask.execute(source);

    }



    public interface GetBitMap{
        void getBitMap(Bitmap bitmap);
    }


    private class MyAsyncTask extends AsyncTask<String,Integer,Bitmap> {
        GetBitMap getBitMap;
        public MyAsyncTask(GetBitMap getBitMap) {
            this.getBitMap = getBitMap;

        }
        @Override
        protected Bitmap doInBackground(String... params) {
            String source = params[0];
            int wStart = source.indexOf("_");
            int wEnd = source.indexOf("x");
            int hENd = source.indexOf(".jpeg");
            int w = Integer.parseInt(source.substring(wStart + 1 , wEnd));
            int h = Integer.parseInt(source.substring(wEnd+ 1,hENd));
            Bitmap bitmap = null;
            try {
                bitmap = Glide.with(MyApp.getContext()).load(source).asBitmap().centerCrop().into(w,h).get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

            return bitmap;
        }


        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            getBitMap.getBitMap(bitmap);
        }
    }



    // 网络请求的接口,有成功方法, 有失败方法
    public interface NetInterface<T> {
        void onSuccess(T t);

        void onError(String errorMsg);
    }

}
