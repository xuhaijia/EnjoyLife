package com.lanou.xuhaijia.enjoylife.travel.attractions;/*
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

import android.util.Log;
import android.view.ViewDebug;
import android.widget.ListView;
import android.widget.RatingBar;

import com.bumptech.glide.Glide;
import com.lanou.xuhaijia.enjoylife.R;
import com.lanou.xuhaijia.enjoylife.base.BaseActivity;
import com.lanou.xuhaijia.enjoylife.base.NetTool;
import com.lanou.xuhaijia.enjoylife.base.UrlValues;
import com.lanou.xuhaijia.enjoylife.tools.CommonAdapter;
import com.lanou.xuhaijia.enjoylife.tools.CommonViewHolder;

public class AttractionsAty extends BaseActivity {
    private ListView lvAttractionAty;

    @Override
    protected int setLayout() {
        return R.layout.activity_attraction;
    }

    @Override
    protected void initView() {


        RatingBar ratingBar = bindView(R.id.item_travel_attentions_listview_ratingbar);

//        ratingBar.setRating(0.8f);
        lvAttractionAty = bindView(R.id.activity_attraction_listview);


    }

    @Override
    protected void initData() {




        mNetTool.getData(UrlValues.TRAVEL_ATTRACTIONS, AttractionAtyBean.class, new NetTool.NetInterface<AttractionAtyBean>() {
            @Override
            public void onSuccess(AttractionAtyBean attractionAtyBean) {

                lvAttractionAty.setAdapter(new CommonAdapter<AttractionAtyBean.ListBean>(attractionAtyBean.getList(), AttractionsAty.this, R.layout.item_travel_attractions_listview) {
                    @Override
                    public void setData(AttractionAtyBean.ListBean listBean
                            , CommonViewHolder viewHolder, int position) {
                        viewHolder.setText(R.id.item_travel_attentions_listview_textview_ch, listBean.getName_cn());

                        viewHolder.setText(R.id.item_travel_attentions_listview_textview_english, listBean.getName());


                        String name = listBean.getReview().getAuthor();
                        String content = listBean.getReview().getComment();

                        String nameAndContent = name + ":" + content;

                        //评论的文章作者
                        viewHolder.setText(R.id.item_travel_attentions_listview_textview_name, nameAndContent);



                        RatingBar r = (RatingBar) viewHolder.getConvertView().findViewById(R.id.item_travel_attentions_listview_ratingbar);


                        float f = Float.parseFloat(listBean.getScore());
                        Log.d("AttractionsAty", "f:" + f);

                        r.setRating(f/2);

                        String point = listBean.getScore();
                        String comment = listBean.getReviewCount();
                        String pointAndComment = point + "分" + "/" + comment + "点评";
                        viewHolder.setText(R.id.item_travel_attentions_listview_textview_point, pointAndComment);
                        viewHolder.setImage(R.id.item_travel_attentions_listview_imager, listBean.getCover(), AttractionsAty.this);

                    }
                });


            }

            @Override
            public void onError(String errorMsg) {

            }
        });

    }
}
