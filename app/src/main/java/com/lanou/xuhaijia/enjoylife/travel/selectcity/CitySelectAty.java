package com.lanou.xuhaijia.enjoylife.travel.selectcity;/*
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
 * Created by 常久青 on 16/9/14.
 */


import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.lanou.xuhaijia.enjoylife.R;
import com.lanou.xuhaijia.enjoylife.base.BaseActivity;
import com.lanou.xuhaijia.enjoylife.base.NetTool;
import com.lanou.xuhaijia.enjoylife.base.UrlValues;
import com.lanou.xuhaijia.enjoylife.tools.CommonAdapter;
import com.lanou.xuhaijia.enjoylife.tools.CommonViewHolder;

public class CitySelectAty extends BaseActivity implements View.OnClickListener {
    public static final String TAG = "TAG_CitySelectAty";
    private ListView lvCity;

    @Override
    protected int setLayout() {
        return R.layout.activity_city_select;
    }

    @Override
    protected void initView() {

        ImageView ivBack = bindView(R.id.activity_city_select_title_imager_back);
        ivBack.setOnClickListener(this);

        lvCity = bindView(R.id.activity_city_select_listview);


    }

    @Override
    protected void initData() {

        mNetTool.getData(UrlValues.TRAVEL_CITY_SELECT, CitySelectAtyBean.class, new NetTool.NetInterface<CitySelectAtyBean>() {
            @Override
            public void onSuccess(CitySelectAtyBean citySelectAtyBean) {

                lvCity.setAdapter(new CommonAdapter<CitySelectAtyBean.ContinentsBean>(citySelectAtyBean.getContinents(), CitySelectAty.this, R.layout.item_city_select_aty) {
                    @Override
                    public void setData(CitySelectAtyBean.ContinentsBean continentsBean,
                                        CommonViewHolder viewHolder, int position) {

                        viewHolder.setText(R.id.item_travel_city_select_aty_text, continentsBean.getName_cn());


                    }
                });

                lvCity.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Toast.makeText(CitySelectAty.this, "position:" + position, Toast.LENGTH_SHORT).show();


                    }
                });


            }

            @Override
            public void onError(String errorMsg) {

            }
        });


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.activity_city_select_title_imager_back:

                finish();

                break;


        }
    }
}
