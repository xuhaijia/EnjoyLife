package com.lanou.xuhaijia.enjoylife.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.lanou.xuhaijia.enjoylife.R;


/**
 * Created by 徐海佳 on 16/8/31.
 * Activity的基类
 */
public abstract class BaseActivity extends AppCompatActivity {
    protected NetTool mNetTool;//网络请求的工具类
    protected boolean skip = false;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mNetTool = new NetTool();
        if (setLayout() != 0) {
            setContentView(setLayout());//绑定布局
        } else {
            //没有绑定布局,弹出错误日志
            Log.e("BaseAty","Activity:"+this.getClass().getSimpleName()+" 没有绑定布局");
        }
        initView();//初始化组件,findViewById的操作
        initData();//初始化数据

    }

    protected abstract int setLayout();

    protected abstract void initView();

    protected abstract void initData();

    //简化findViewById
    protected <T extends View> T bindView(int id) {
        return (T) findViewById(id);
    }


    //在Activity销毁的时候,把未完成的网络请求取消了
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();

    }
}
