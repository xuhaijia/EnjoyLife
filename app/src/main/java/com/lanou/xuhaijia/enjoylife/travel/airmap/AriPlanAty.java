package com.lanou.xuhaijia.enjoylife.travel.airmap;/*
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
 * Created by 常久青 on 16/9/21.
 */

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapView;
import com.lanou.xuhaijia.enjoylife.R;
import com.lanou.xuhaijia.enjoylife.base.BaseActivity;


public class AriPlanAty extends BaseActivity implements CompoundButton.OnCheckedChangeListener {
    public static final String TAG = "TAG_AriPlanAty";


    private BaiduMap baiduMap;
    private LocationClient locationClient;
    private MapView mapView;


    @Override
    protected int setLayout() {
        return R.layout.activity_air_plan_map;
    }

    @Override
    protected void initView() {


        CheckBox cbMap = bindView(R.id.activity_air_plan_map_checkbox);

        cbMap.setOnCheckedChangeListener(this);


        mapView = bindView(R.id.activity_air_plan_map_mapview);


        //开启图层
        baiduMap = mapView.getMap();
        baiduMap.setMyLocationEnabled(true);
        //设置地图类型 ,标准还是啥的
        //baiduMap.setMapType(BaiduMap.MAP_TYPE_SATELLITE);

        locationClient = new LocationClient(this);

        LocationClientOption option = new LocationClientOption();
        option.setOpenGps(true);
        option.setCoorType("bd09ll");
        option.setScanSpan(1000);
        locationClient.setLocOption(option);
        locationClient.start();


    }


    @Override
    protected void initData() {

    }

    @Override
    protected void onDestroy() {
        //在activity执行onDestroy时执行mMapView.onDestroy()，实现地图生命周期管理
        mapView.onDestroy();
        locationClient.stop();
        baiduMap.setMyLocationEnabled(false);
        mapView = null;
        super.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //在activity执行onResume时执行mMapView. onResume ()，实现地图生命周期管理
        mapView.onResume();

    }

    @Override
    protected void onPause() {
        super.onPause();
        //在activity执行onPause时执行mMapView. onPause ()，实现地图生命周期管理
        mapView.onPause();
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {


        if (b) {

            baiduMap.setMapType(BaiduMap.MAP_TYPE_NORMAL);

        } else {

            baiduMap.setMapType(BaiduMap.MAP_TYPE_SATELLITE);

        }

    }
}
