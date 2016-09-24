package com.lanou.xuhaijia.enjoylife.travel.attractions.listattraction;/*
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
 * Created by 常久青 on 16/9/18.
 */

import android.content.Intent;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lanou.xuhaijia.enjoylife.R;
import com.lanou.xuhaijia.enjoylife.base.BaseActivity;
import com.lanou.xuhaijia.enjoylife.base.NetTool;
import com.lanou.xuhaijia.enjoylife.base.UrlValues;
import com.lanou.xuhaijia.enjoylife.travel.attractions.AttractionAtyBean;

public class AttractionListAty extends BaseActivity {


    private ImageView ivHead;
    private TextView tvNameCH;
    private TextView tvNameEnglish;
    private TextView tvContent;
    private TextView tvLocation;
    private TextView tvTraffic;
    private TextView tvTicket;
    private TextView tvPhone;
    private TextView tvOpen;
    private TextView tvTime;

    @Override
    protected int setLayout() {
        return R.layout.activity_travel_attraction_list;
    }

    @Override
    protected void initView() {

        //最大的图
        ivHead = bindView(R.id.activity_travel_attraction_list_imager);
        tvNameCH = bindView(R.id.activity_travel_attraction_list_text_title);
        tvNameEnglish = bindView(R.id.activity_travel_attraction_list_text_title_english);
        tvContent = bindView(R.id.activity_travel_attraction_list_text_intro);
        tvLocation = bindView(R.id.activity_travel_attraction_list_text_location);
        tvTraffic = bindView(R.id.activity_travel_attraction_list_text_traffic);
        tvTicket = bindView(R.id.activity_travel_attraction_list_text_entrance);
        tvPhone = bindView(R.id.activity_travel_attraction_list_text_phone);
        tvOpen = bindView(R.id.activity_travel_attraction_list_text_open);
        tvTime = bindView(R.id.activity_travel_attraction_list_text_play_time);

    }

    @Override
    protected void initData() {

        Intent intentList = getIntent();
        String id = intentList.getStringExtra("urlId");
        Log.d("AttractionListAty", id);

        String urlAttractItem = UrlValues.TRAVEL_ITEM_ATTRACTION + id;
        Log.d("AttractionListAty", urlAttractItem);

        mNetTool.getData(urlAttractItem, AttractionListAtyBean.class, new NetTool.NetInterface<AttractionListAtyBean>() {
            @Override
            public void onSuccess(AttractionListAtyBean attractionListAtyBean) {
                String tt = attractionListAtyBean.getItem().getName_cn();
                Log.d("AttractionListAty", tt);
                //  Glide.with(mContext).load(travelFragmentBean.getPlace().getCover()).into(ivBackGround)
                Glide.with(AttractionListAty.this).load(attractionListAtyBean.getItem().getCover()).into(ivHead);

                tvNameCH.setText(attractionListAtyBean.getItem().getName_cn());
                tvNameEnglish.setText(attractionListAtyBean.getItem().getName());
                tvContent.setText(attractionListAtyBean.getItem().getInfo_cn());
                tvLocation.setText(attractionListAtyBean.getItem().getAddress());
                tvTraffic.setText(attractionListAtyBean.getItem().getTraffic());
                tvTicket.setText(attractionListAtyBean.getItem().getPriceinfo());
                tvPhone.setText(attractionListAtyBean.getItem().getContact());
                tvOpen.setText(attractionListAtyBean.getItem().getOpening_time_cn());
                tvTime.setText(attractionListAtyBean.getItem().getDuration_cn());

            }

            @Override
            public void onError(String errorMsg) {

            }
        });

    }
}
