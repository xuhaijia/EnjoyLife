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

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.lanou.xuhaijia.enjoylife.R;
import com.lanou.xuhaijia.enjoylife.base.BaseActivity;
import com.lanou.xuhaijia.enjoylife.base.NetTool;
import com.lanou.xuhaijia.enjoylife.base.UrlValues;
import com.lanou.xuhaijia.enjoylife.tools.CommonAdapter;
import com.lanou.xuhaijia.enjoylife.tools.CommonViewHolder;
import com.lanou.xuhaijia.enjoylife.travel.attractions.listattraction.AttractionListAty;
import com.lanou.xuhaijia.enjoylife.travel.food.foodlist.FoodListAty;
import com.lanou.xuhaijia.enjoylife.travel.hotel.HotelAty;
import com.lanou.xuhaijia.enjoylife.travel.hotel.hotellsit.HotelListAty;
import com.lanou.xuhaijia.enjoylife.travel.travlesfragment.TravelEventBus;

import org.greenrobot.eventbus.EventBus;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class TravelSearchAty extends BaseActivity implements View.OnClickListener {

    private EditText etSearch;
    private String urlSearch;
    private String search;
    private ListView lvSearch;

    @Override
    protected int setLayout() {
        return R.layout.activity_travel_search;


    }

    @Override
    protected void initView() {

        TextView tvCanel = bindView(R.id.activity_travel_search_textview_cancel);
        tvCanel.setOnClickListener(this);

        etSearch = bindView(R.id.activity_travel_search_editview_search);

        lvSearch = bindView(R.id.activity_travel_search_listview);


    }

    @Override
    protected void initData() {


        Observable.create(new EditTextObservable(etSearch)).debounce(500, TimeUnit.MILLISECONDS).flatMap(new Func1<String, Observable<RXSearch>>() {
            @Override
            public Observable<RXSearch> call(String s) {
                Log.d("TravelSearchAty", "1走到了");

                //这是被观察者 设置数据的
                RXSearch rxSearch = new RXSearch();
                rxSearch.setResult(s);


                return Observable.just(rxSearch);
            }
        })
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<RXSearch>() {
                    @Override
                    public void call(RXSearch rxSearch) {
                        Log.d("TravelSearchAty", "走到了2");
                        search = rxSearch.getResult();


                        //以上是RXJava获取  EditText 的内容
                        urlSearch = UrlValues.TRAVEL_SEARCH_HEAD + search + UrlValues.TRAVEL_SEARCH_FOOT;
                        Log.d("TravelSearchAty", urlSearch);
                        mNetTool.getData(urlSearch, TravelSearchAtyBean.class, new NetTool.NetInterface<TravelSearchAtyBean>() {
                            @Override
                            public void onSuccess(final TravelSearchAtyBean travelSearchAtyBean) {

                                lvSearch.setAdapter(new CommonAdapter<TravelSearchAtyBean.ListBean>(travelSearchAtyBean.getList(), TravelSearchAty.this, R.layout.item_activity_travel_search_listview) {
                                    @Override
                                    public void setData(TravelSearchAtyBean.ListBean listBean, CommonViewHolder viewHolder, int position) {

                                        viewHolder.setText(R.id.item_activity_travel_search_textview_city, listBean.getName_cn());


                                        viewHolder.setText(R.id.item_activity_travel_search_textview_country, "(" + listBean.getCityName() + ")");


                                    }
                                });

                                lvSearch.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                    @Override
                                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                                        String id = travelSearchAtyBean.getList().get(i).getRecordId();

                                        if (travelSearchAtyBean.getList().get(i).getModule().equals("city")) {


                                            TravelEventBus travelEventBus = new TravelEventBus();
                                            travelEventBus.setUrlId(id);

                                            EventBus.getDefault().post(travelEventBus);
                                            finish();


                                        }
                                        if (travelSearchAtyBean.getList().get(i).getModule().equals("attraction")) {
                                            Intent intent = new Intent(TravelSearchAty.this, AttractionListAty.class);
                                            intent.putExtra("urlId", id);
                                            startActivityForResult(intent, 102);

                                        }
                                        if (travelSearchAtyBean.getList().get(i).getModule().equals("hotel")) {


                                            Intent intentHotel = new Intent(TravelSearchAty.this, HotelListAty.class);
                                            intentHotel.putExtra("urlId", 102);
                                            startActivityForResult(intentHotel, 102);


                                        }
                                        if (travelSearchAtyBean.getList().get(i).getModule().equals("restaurant")) {
                                            Intent intentFood = new Intent(TravelSearchAty.this, FoodListAty.class);
                                            intentFood.putExtra("urlId", 102);
                                            startActivityForResult(intentFood, 102);


                                        }else {

                                            Toast.makeText(TravelSearchAty.this, "其他项目暂未搜索,敬请下个版本", Toast.LENGTH_SHORT).show();


                                        }


                                    }
                                });


                            }

                            @Override
                            public void onError(String errorMsg) {

                            }
                        });


                    }
                });


    }

    @Override
    public void onClick(View v) {


        switch (v.getId()) {

            case R.id.activity_travel_search_textview_cancel:

                finish();

                break;


        }

    }


    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        super.startActivityForResult(intent, requestCode);

        if (requestCode == 102) {


            finish();

        }

    }
}
