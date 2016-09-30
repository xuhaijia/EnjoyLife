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
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lanou.xuhaijia.enjoylife.R;
import com.lanou.xuhaijia.enjoylife.base.BaseActivity;
import com.lanou.xuhaijia.enjoylife.base.NetTool;
import com.lanou.xuhaijia.enjoylife.base.UrlValues;
import com.lanou.xuhaijia.enjoylife.myself.LoginActivity;
import com.lanou.xuhaijia.enjoylife.tools.DBTool;
import com.lanou.xuhaijia.enjoylife.travel.attractions.AttractionAtyBean;
import com.lanou.xuhaijia.enjoylife.travel.attractions.AttractionsAty;
import com.lanou.xuhaijia.enjoylife.travel.collection.CollectionAttractBean;

import java.util.List;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobUser;

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
    private ImageView ivCollect;
    private BmobUser bmobUser;
    private String urlAttractItem;
    private String username;
    private CollectionAttractBean collectionAttractBean;

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


        ivCollect = bindView(R.id.activity_travel_attraction_collect_imager);


    }

    @Override
    protected void initData() {

        Intent intentList = getIntent();
        String id = intentList.getStringExtra("urlId");
        urlAttractItem = UrlValues.TRAVEL_ITEM_ATTRACTION + id;

        mNetTool.getData(urlAttractItem, AttractionListAtyBean.class, new NetTool.NetInterface<AttractionListAtyBean>() {
            @Override
            public void onSuccess(final AttractionListAtyBean attractionListAtyBean) {
                String tt = attractionListAtyBean.getItem().getName_cn();
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

                bmobUser = BmobUser.getCurrentUser();
                if (bmobUser != null) {
                    //获取用户名
                    username = bmobUser.getUsername();

                    //为星星记录颜色,当coll为0 表示为收藏反之
                    DBTool.getInstance().queryAttration(CollectionAttractBean.class, username, urlAttractItem, new DBTool.QueryComplete<List<CollectionAttractBean>>() {
                        @Override
                        public void onCompleted(List<CollectionAttractBean> coll) {

                            if (coll.size() == 0) {
                                ivCollect.setImageResource(R.mipmap.travel_collection_attraction_after);

                            } else {


                                ivCollect.setImageResource(R.mipmap.travel_collection_attraction_first);

                            }


                        }
                    });

                    ivCollect.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {


                            collectionAttractBean = new CollectionAttractBean();


                            DBTool.getInstance().queryAttration(CollectionAttractBean.class, username, urlAttractItem, new DBTool.QueryComplete<List<CollectionAttractBean>>() {

                                @Override
                                public void onCompleted(List<CollectionAttractBean> collection) {
                                    if (collection.size() == 0) {
                                        collectionAttractBean.setUrlAtt(urlAttractItem);
                                        collectionAttractBean.setNameCN(attractionListAtyBean.getItem().getName_cn());
                                        collectionAttractBean.setUrlPic(attractionListAtyBean.getItem().getCover());
                                        collectionAttractBean.setNameUser(username);
                                        DBTool.getInstance().insertData(collectionAttractBean);

                                        ivCollect.setImageResource(R.mipmap.travel_collection_attraction_first);

                                    } else {
                                        DBTool.getInstance().deleteData(collection.get(0));
                                        ivCollect.setImageResource(R.mipmap.travel_collection_attraction_after);


                                    }
                                }
                            });
                        }


                    });


                } else {
                    Intent intent = new Intent(AttractionListAty.this, LoginActivity.class);
                    startActivityForResult(intent, 11);

                }


            }

            @Override
            public void onError(String errorMsg) {

            }
        });

    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        super.startActivityForResult(intent, requestCode);
        if (requestCode == 11) {
            finish();

        }
    }
}

