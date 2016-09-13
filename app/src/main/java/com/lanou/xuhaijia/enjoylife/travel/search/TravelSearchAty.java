package com.lanou.xuhaijia.enjoylife.travel.search;/*
                   _ooOoo_
                  o8888888o
                  88" . "88
                  (| -_- |)
                  O\  =  /O
               ____/`---'\____
             .'  \\|     |//  `.
            /  \\|||  :  |||//  \
           /  _||||| -:- |||||-  \
           |   | \\\  -  /// |   |
           | \_|  ''\---/''  |   |
           \  .-\__  `-`  ___/-. /
         ___`. .'  /--.--\  `. . __
      ."" '<  `.___\_<|>_/___.'  >'"".
     | | :  ` - `.;`\ _ /`;.`/ - ` : | |
     \  \ `-.   \_ __\ /__ _/   .-` /  /
======`-.____`-.___\_____/___.-`____.-'======
                   `=---='
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
            佛祖保佑       永无BUG
/**
 * Created by 常久青 on 16/9/13.
 */

import android.view.View;
import android.widget.TextView;

import com.lanou.xuhaijia.enjoylife.R;
import com.lanou.xuhaijia.enjoylife.base.BaseActivity;

public class TravelSearchAty extends BaseActivity implements View.OnClickListener {
    public static final String TAG = "TAG_TravelSearchAty";

    @Override
    protected int setLayout() {
        return R.layout.activity_travel_search;


    }

    @Override
    protected void initView() {
        TextView tvCanel = bindView(R.id.activity_travel_search_textview_cancel);
        tvCanel.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {


        switch (v.getId()) {

            case R.id.activity_travel_search_textview_cancel:

                finish();

                break;


        }

    }
}
