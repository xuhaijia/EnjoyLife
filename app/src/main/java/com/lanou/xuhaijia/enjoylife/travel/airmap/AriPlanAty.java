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
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapPoi;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.model.LatLng;
import com.lanou.xuhaijia.enjoylife.R;
import com.lanou.xuhaijia.enjoylife.base.BaseActivity;

import org.greenrobot.eventbus.EventBus;


public class AriPlanAty extends BaseActivity implements CompoundButton.OnCheckedChangeListener, BaiduMap.OnMapClickListener, View.OnClickListener {


    private BaiduMap baiduMap;
    private LocationClient locationClient;
    private MapView mapView;

    private boolean isFirstLoc = true;

    @Override
    protected int setLayout() {
        return R.layout.activity_air_plan_map;
    }

    @Override
    protected void initView() {


        CheckBox cbMap = bindView(R.id.activity_air_plan_map_checkbox);

        cbMap.setOnCheckedChangeListener(this);


        Button btnMyLocation = bindView(R.id.activity_air_plan_map_btn_location);
        btnMyLocation.setOnClickListener(this);


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

        //设置百度地图点击事件
        baiduMap.setOnMapClickListener(this);


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


    //百度地图的监听事件
    @Override
    public void onMapClick(LatLng latLng) {


        double lat = latLng.latitude;
        double lon = latLng.longitude;


        Log.d("AriPlanAty", "lat:" + lat);
        Log.d("AriPlanAty", "lon:" + lon);


        AirPlanBus airPlanBus = new AirPlanBus();

        airPlanBus.setLan(lat);
        airPlanBus.setLon(lon);


        EventBus.getDefault().post(airPlanBus);

        finish();

    }

    @Override
    public boolean onMapPoiClick(MapPoi mapPoi) {
        return false;
    }


    @Override
    public void onClick(View view) {


        locationClient = new LocationClient(this);

        LocationClientOption option = new LocationClientOption();
        option.setOpenGps(true);
        option.setCoorType("bd09ll");
        option.setScanSpan(1000);
        locationClient.setLocOption(option);
        locationClient.start();


        MyLocationListenner myListener = new MyLocationListenner();
        locationClient.registerLocationListener(myListener);
    }

    private class MyLocationListenner implements BDLocationListener {
        @Override
        public void onReceiveLocation(BDLocation bdLocation) {

            if (bdLocation == null || mapView == null) {

                return;

            }

            if (isFirstLoc) {
                isFirstLoc = false;

                MyLocationData locationData = new MyLocationData.Builder()
                        .accuracy(bdLocation.getRadius())
                        .direction(100).latitude(bdLocation.getLatitude())
                        .longitude(bdLocation.getLongitude()).build();
                baiduMap.setMyLocationData(locationData);


                LatLng ll = new LatLng(bdLocation.getLatitude(), bdLocation.getLongitude());
                MapStatus.Builder builder = new MapStatus.Builder();
                builder.target(ll).zoom(18.0f);
                baiduMap.animateMapStatus(MapStatusUpdateFactory.newMapStatus(builder.build()));

                locationClient.stop();
                isFirstLoc = true;
            }


        }


    }
}
