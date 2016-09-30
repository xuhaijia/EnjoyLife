package com.lanou.xuhaijia.enjoylife.travel.hotel;/*
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
 * Created by 常久青 on 16/9/22.
 */


import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.lanou.xuhaijia.enjoylife.R;
import com.lanou.xuhaijia.enjoylife.base.BaseActivity;
import com.lanou.xuhaijia.enjoylife.base.NetTool;
import com.lanou.xuhaijia.enjoylife.base.UrlValues;
import com.lanou.xuhaijia.enjoylife.travel.hotel.hotellsit.HotelListAty;
import com.lanou.xuhaijia.enjoylife.travel.travelhoteltools.CardAdapter;
import com.lanou.xuhaijia.enjoylife.travel.travelhoteltools.SwipeFlingAdapterView;

import java.util.ArrayList;
import java.util.List;

public class HotelAty extends BaseActivity implements View.OnClickListener {

    private SwipeFlingAdapterView hoteSwipe;
    private CardAdapter cardAdapter;
    List<HotelAtyBean.ListBean> list;
    private String idHotel;


    @Override
    protected int setLayout() {
        return R.layout.activity_travel_hotel;
    }

    @Override
    protected void initView() {

        hoteSwipe = bindView(R.id.activity_travel_hotel_swipe);
        cardAdapter = new CardAdapter(HotelAty.this);


        ImageView ivLeft = bindView(R.id.left);
        ImageView ivRiget = bindView(R.id.right);
        ivLeft.setOnClickListener(this);
        ivRiget.setOnClickListener(this);


    }

    @Override
    protected void initData() {
        final Intent intent = getIntent();
        idHotel = intent.getStringExtra("hotel");
        String urlHotel = UrlValues.TRAVEL_HOTEL_HEAD + idHotel + UrlValues.TRAVEL_ATTRACTIONS_FOOD;

        mNetTool.getData(urlHotel, HotelAtyBean.class, new NetTool.NetInterface<HotelAtyBean>() {


            @Override
            public void onSuccess(final HotelAtyBean hotelAtyBean) {

                hoteSwipe.setAdapter(cardAdapter);
                cardAdapter.setHotelAtyBean(hotelAtyBean);
                list = new ArrayList<HotelAtyBean.ListBean>();


                hoteSwipe.setFlingListener(new SwipeFlingAdapterView.onFlingListener() {
                    @Override
                    public void removeFirstObjectInAdapter() {
                        HotelAtyBean.ListBean listBean = hotelAtyBean.getList().get(0);
                        list.add(listBean);
                        hotelAtyBean.getList().remove(0);
                        cardAdapter.notifyDataSetChanged();


                    }

                    @Override
                    public void onLeftCardExit(Object dataObject) {

                        Toast.makeText(HotelAty.this, "不喜欢", Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onRightCardExit(Object dataObject) {

                        Toast.makeText(HotelAty.this, "喜欢", Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onAdapterAboutToEmpty(int itemsInAdapter) {

                        // String urlLoadHotel = UrlValues.TRAVEL_HOTEL_LOAD_HEAD + i + UrlValues.TRAVEL_HOTEL_LOAD_CENTER + idHotel + UrlValues.TRAVEL_ATTRACTIONS_FOOD;


                        hotelAtyBean.getList().addAll(list);
                        list.clear();


                    }

                    @Override
                    public void onScroll(float scrollProgressPercent) {

                        View view = hoteSwipe.getSelectedView();
                        view.findViewById(R.id.item_swipe_right_indicator).setAlpha(scrollProgressPercent < 0 ? -scrollProgressPercent : 0);
                        view.findViewById(R.id.item_swipe_left_indicator).setAlpha(scrollProgressPercent > 0 ? scrollProgressPercent : 0);

                    }
                });


                hoteSwipe.setOnItemClickListener(new SwipeFlingAdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClicked(int itemPosition, Object dataObject) {




                        Intent intentList = new Intent(HotelAty.this,HotelListAty.class);

                        intentList.putExtra("urlId",hotelAtyBean.getList().get(itemPosition).getId());

                        startActivity(intentList);




                    }
                });



            }

            @Override
            public void onError(String errorMsg) {

            }
        });


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.left:
                left();
                break;


            case R.id.right:
                right();

                break;


        }
    }


    public void right() {
        hoteSwipe.getTopCardListener().selectRight();
    }

    public void left() {
        hoteSwipe.getTopCardListener().selectLeft();
    }
}
