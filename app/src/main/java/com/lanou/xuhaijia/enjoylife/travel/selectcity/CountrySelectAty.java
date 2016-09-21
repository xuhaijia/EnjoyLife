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


import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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
import com.lanou.xuhaijia.enjoylife.tools.RecycleViewAdapter;

public class CountrySelectAty extends BaseActivity implements View.OnClickListener {
    private RecycleViewAdapter recycleViewAdapter;
    private ListView lvCity;
    private RecyclerView rvCity;

    @Override
    protected int setLayout() {
        return R.layout.activity_country_select;
    }

    @Override
    protected void initView() {

        ImageView ivBack = bindView(R.id.activity_city_select_title_imager_back);
        ivBack.setOnClickListener(this);

        lvCity = bindView(R.id.activity_city_select_listview);
        rvCity = bindView(R.id.activity_city_select_recycview);
        GridLayoutManager manager = new GridLayoutManager(CountrySelectAty.this, 2);
        rvCity.setLayoutManager(manager);


    }

    @Override
    protected void initData() {

        mNetTool.getData(UrlValues.TRAVEL_CITY_SELECT, CountrySelectAtyBean.class, new NetTool.NetInterface<CountrySelectAtyBean>() {



            @Override
            public void onSuccess(final CountrySelectAtyBean citySelectAtyBean) {

                lvCity.setAdapter(new CommonAdapter<CountrySelectAtyBean.ContinentsBean>(citySelectAtyBean.getContinents(), CountrySelectAty.this, R.layout.item_country_select_aty) {
                    @Override
                    public void setData(CountrySelectAtyBean.ContinentsBean continentsBean, CommonViewHolder viewHolder) {

                        viewHolder.setText(R.id.item_travel_city_select_aty_text, continentsBean.getName_cn());


                    }
                });

                rvCity.setAdapter(new RecycleViewAdapter<CountrySelectAtyBean.ContinentsBean.CountrysBean>(citySelectAtyBean.getContinents().get(0).getCountrys(), CountrySelectAty.this, R.layout.item_country_select_recycle_aty) {

                    @Override
                    public void setData(CountrySelectAtyBean.ContinentsBean.CountrysBean countrysBean, CommonViewHolder viewHolder) {
                        viewHolder.setText(R.id.item_city_select_recycle_aty_textview_cn, countrysBean.getName_cn());
                        viewHolder.setText(R.id.item_city_select_recycle_aty_textview_english, countrysBean.getName());
                        viewHolder.setImage(R.id.item_city_select_recycle_aty_imager, countrysBean.getCover(), CountrySelectAty.this);
                    }
                });

                lvCity.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, final View view, final int position, long id) {
                        int i = 0;
                        switch (position) {
                            case 0:
                                i = 0;
                                break;
                            case 1:
                                i = 1;
                                break;
                            case 2:
                                i = 2;
                                break;
                            case 3:

                                i = 3;
                                break;
                            case 4:

                                i = 4;
                                break;
                            case 5:
                                i = 5;
                                break;
                        }


                        RecycleViewAdapter<CountrySelectAtyBean.ContinentsBean.CountrysBean> adapter = new RecycleViewAdapter<CountrySelectAtyBean.ContinentsBean.CountrysBean>(citySelectAtyBean.getContinents().get(i).getCountrys(), CountrySelectAty.this, R.layout.item_country_select_recycle_aty) {
                            @Override
                            public void setData(final CountrySelectAtyBean.ContinentsBean.CountrysBean countrysBean, CommonViewHolder viewHolder) {
                                viewHolder.setText(R.id.item_city_select_recycle_aty_textview_cn, countrysBean.getName_cn());
                                viewHolder.setText(R.id.item_city_select_recycle_aty_textview_english, countrysBean.getName());
                                viewHolder.setImage(R.id.item_city_select_recycle_aty_imager, countrysBean.getCover(), CountrySelectAty.this);
                                //整体的item添加点击事件
                                viewHolder.itemView.setOnClickListener(new MyClickListener(viewHolder.getLayoutPosition()) {
                                    @Override
                                    public void onClick(View view) {
                                        Toast.makeText(CountrySelectAty.this, "pos:" + pos, Toast.LENGTH_SHORT).show();

                                        String id = countrysBean.getId();
                                        String country = countrysBean.getName_cn() ;
                                        Intent intentCity = new Intent(CountrySelectAty.this, CitySelectAty.class);

                                        intentCity.putExtra("id", id);
                                        intentCity.putExtra("country",country);

                                        startActivityForResult(intentCity, 101);


                                    }
                                });
                            }
                        };
                        rvCity.setAdapter(adapter);
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

    abstract class MyClickListener implements View.OnClickListener {
        protected int pos;

        public MyClickListener(int pos) {
            this.pos = pos;
        }

        public int getPos() {
            return pos;
        }
    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        super.startActivityForResult(intent, requestCode);

        if (requestCode == 101) {

            Log.d("CountrySelectAty", "我执行了");
            finish();


        }

    }
}
