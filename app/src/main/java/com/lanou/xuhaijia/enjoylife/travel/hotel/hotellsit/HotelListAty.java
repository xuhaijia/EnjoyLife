package com.lanou.xuhaijia.enjoylife.travel.hotel.hotellsit;/*
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
 * Created by 常久青 on 16/9/26.
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

public class HotelListAty extends BaseActivity{
 //   public static final String TAG = "TAG_HotelListAty";

    private ImageView ivHeadPic;
    private TextView tvHotelCN;
    private TextView tvHotelEnglis;
    private TextView tvContext;
    private TextView tvLocation;
    private TextView tvStat;
    private TextView tvPHone;

    @Override
    protected int setLayout() {
        return R.layout.activity_travel_hotel_list;
    }

    @Override
    protected void initView() {

        //大图
        ivHeadPic = bindView(R.id.activity_travel_hotel_list_imager);
        //酒店中文
        tvHotelCN = bindView(R.id.activity_travel_hotel_list_text_title);
        //酒店英文
        tvHotelEnglis = bindView(R.id.activity_travel_hotel_list_text_title_english);
        //简介
        tvContext = bindView(R.id.activity_travel_hotel_list_text_intro);
        //地址
        tvLocation = bindView(R.id.activity_travel_hotel_list_text_location);
        //电话
        tvPHone = bindView(R.id.activity_travel_hotel_list_text_phone);

        //星星
        tvStat = bindView(R.id.activity_travel_hotel_list_text_stat);



    }

    @Override
    protected void initData() {

        Intent intentList = getIntent();

        String urlIds = intentList.getStringExtra("urlId");
        Log.d("HotelListAty", urlIds);


        String urlHotel = UrlValues.TRAVEL_HOTEL_LIST_HEAD + urlIds ;
        Log.d("QQQQQQQQQQQQQQ", urlHotel);


        mNetTool.getData(urlHotel, HotelListAtyBean.class, new NetTool.NetInterface<HotelListAtyBean>() {
            @Override
            public void onSuccess(HotelListAtyBean hotelListAtyBean) {

                Glide.with(HotelListAty.this).load(hotelListAtyBean.getItem().getCover()).into(ivHeadPic);

                tvHotelCN.setText(hotelListAtyBean.getItem().getName_cn());
                tvHotelEnglis.setText(hotelListAtyBean.getItem().getName());
                tvContext.setText(hotelListAtyBean.getItem().getInfo_cn());
                tvPHone.setText(hotelListAtyBean.getItem().getContact());
                tvStat.setText(hotelListAtyBean.getItem().getStar()+"星级酒店");





            }

            @Override
            public void onError(String errorMsg) {

            }
        });






    }
}
