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
 * Created by 常久青 on 16/9/19.
 */

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.lanou.xuhaijia.enjoylife.R;
import com.lanou.xuhaijia.enjoylife.base.BaseActivity;
import com.lanou.xuhaijia.enjoylife.base.NetTool;
import com.lanou.xuhaijia.enjoylife.base.UrlValues;
import com.lanou.xuhaijia.enjoylife.tools.CommonViewHolder;
import com.lanou.xuhaijia.enjoylife.tools.RecycleViewAdapter;
import com.lanou.xuhaijia.enjoylife.travel.travlesfragment.TravelEventBus;

import org.greenrobot.eventbus.EventBus;

public class CitySelectAty extends BaseActivity {

    private RecyclerView recyclerViewCity;
    private TextView tvTilte;

    @Override
    protected int setLayout() {


        return R.layout.activity_city_select;
    }

    @Override
    protected void initView() {

        tvTilte = bindView(R.id.activity_city_select_title);
        recyclerViewCity = bindView(R.id.activity_city_select_reclerview);


    }


    @Override
    protected void initData() {

        Intent intent = getIntent();

        String id = intent.getStringExtra("id");
        String country = intent.getStringExtra("country");

        tvTilte.setText(country);

        Log.d("CitySelectAty", id);

        final String urlCity = UrlValues.TRAVEL_CITY_SELECT_HEAD + id + UrlValues.TRAVEL_CITY_FOOD;

        Log.d("CitySelectAty", urlCity);


        mNetTool.getData(urlCity, CitySelectAtyBean.class, new NetTool.NetInterface<CitySelectAtyBean>() {
            @Override
            public void onSuccess(CitySelectAtyBean citySelectAtyBean) {

                GridLayoutManager manager = new GridLayoutManager(CitySelectAty.this, 3);
                recyclerViewCity.setLayoutManager(manager);

                recyclerViewCity.setAdapter(new RecycleViewAdapter<CitySelectAtyBean.PlacesBean>(citySelectAtyBean.getPlaces(), CitySelectAty.this, R.layout.item_city_select_aty) {
                    @Override
                    public void setData(final CitySelectAtyBean.PlacesBean placesBean, CommonViewHolder viewHolder) {


                        viewHolder.setText(R.id.item_city_select_recycle_aty_tv_city, placesBean.getName_cn());
                        viewHolder.setImage(R.id.item_city_select_recycle_aty_iv, placesBean.getCover(), CitySelectAty.this);
                        viewHolder.setText(R.id.item_city_select_recycle_aty_tv_going, placesBean.getPoiCount() + " 去处");
                        viewHolder.setText(R.id.item_city_select_recycle_aty_tv_estimate, placesBean.getReviewCount() + "点评");


                        viewHolder.itemView.setOnClickListener(new MyClickListener(viewHolder.getLayoutPosition()) {

                            @Override
                            public void onClick(View view) {


                                String urlId = placesBean.getId();

                                TravelEventBus travelEventBus = new TravelEventBus();
                                travelEventBus.setUrlId(urlId);
                                EventBus.getDefault().post(travelEventBus);


                                finish();

                            }
                        });


                    }
                });


            }

            @Override
            public void onError(String errorMsg) {

            }
        });


    }

    abstract class MyClickListener implements View.OnClickListener {
        protected int pos;

        public MyClickListener(int pos) {
            this.pos = pos;
        }

        public int getPos() {
            return pos;
        }
    }


}
