package com.lanou.xuhaijia.enjoylife.travel.food.foodlist;/*
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

public class FoodListAty extends BaseActivity {
 //   public static final String TAG = "TAG_FoodListAty";
    private ImageView ivHeadPic;
    private TextView tvFoodCN;
    private TextView tvFoodEnglis;
    private TextView tvContext;
    private TextView tvLocation;
    private TextView tvTraffic;
    private TextView tvEntrance;
    private TextView tvPHone;

    @Override
    protected int setLayout() {
        return R.layout.activity_travel_food_list;
    }

    @Override
    protected void initView() {

        //大图
        ivHeadPic = bindView(R.id.activity_travel_food_list_imager);
        //食物中文
        tvFoodCN = bindView(R.id.activity_travel_food_list_text_title);
        //食物英文
        tvFoodEnglis = bindView(R.id.activity_travel_food_list_text_title_english);
        //简介
        tvContext = bindView(R.id.activity_travel_food_list_text_intro);
        //地址
        tvLocation = bindView(R.id.activity_travel_food_list_text_location);
        //交通
        tvTraffic = bindView(R.id.activity_travel_food_list_text_traffic);
        //门票
        tvEntrance = bindView(R.id.activity_travel_food_list_text_entrance);
        //电话
        tvPHone = bindView(R.id.activity_travel_food_list_text_phone);

    }

    @Override
    protected void initData() {

        Intent intent = getIntent();

        String urlId = intent.getStringExtra("urlId");

        String urlFoodList = UrlValues.TRAVEL_RESTAURAANT_HEAD + urlId;

        mNetTool.getData(urlFoodList, FoodListAtyBean.class, new NetTool.NetInterface<FoodListAtyBean>() {
            @Override
            public void onSuccess(FoodListAtyBean foodListAtyBean) {


                Glide.with(FoodListAty.this).load(foodListAtyBean.getItem().getCover()).into(ivHeadPic);

                tvFoodCN.setText(foodListAtyBean.getItem().getName_cn());
                tvFoodEnglis.setText(foodListAtyBean.getItem().getName());
                tvContext.setText(foodListAtyBean.getItem().getInfo_cn());
                tvLocation.setText(foodListAtyBean.getItem().getTraffic());
                tvEntrance.setText(foodListAtyBean.getItem().getPriceinfo());
                tvPHone.setText(foodListAtyBean.getItem().getContact());


            }

            @Override
            public void onError(String errorMsg) {

            }
        });


    }
}
