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

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.lanou.xuhaijia.enjoylife.R;
import com.lanou.xuhaijia.enjoylife.base.BaseActivity;
import com.lanou.xuhaijia.enjoylife.base.NetTool;
import com.lanou.xuhaijia.enjoylife.base.UrlValues;
import com.lanou.xuhaijia.enjoylife.tools.CommonAdapter;
import com.lanou.xuhaijia.enjoylife.tools.CommonViewHolder;
import com.lanou.xuhaijia.enjoylife.travel.attractions.listattraction.AttractionListAty;

public class AttractionsAty extends BaseActivity implements View.OnClickListener {
    private ListView lvAttractionAty;
    private String urlAttract;


    @Override
    protected int setLayout() {
        return R.layout.activity_attraction;
    }

    @Override
    protected void initView() {


        RatingBar ratingBar = bindView(R.id.item_travel_attentions_listview_ratingbar);

//        ratingBar.setRating(0.8f);
        lvAttractionAty = bindView(R.id.activity_attraction_listview);


        ImageView ivOut = bindView(R.id.activity_attractions_iv_back);
        ivOut.setOnClickListener(this);

    }

    @Override
    protected void initData() {
        Intent intents = getIntent();

        final String id = intents.getStringExtra("urlId");
        //  Log.d("AttractionsAty", id);

        if (id == null) {
            urlAttract = UrlValues.TRAVEL_ATTRACTIONS_INITALIZE;
        } else {
            urlAttract = UrlValues.TRAVEL_ATTRACTIONS_HEAD + id + UrlValues.TRAVEL_ATTRACTIONS_FOOD;

            Log.d("AttractionsAty111111111", urlAttract);

        }
        mNetTool.getData(urlAttract, AttractionAtyBean.class, new NetTool.NetInterface<AttractionAtyBean>() {
            @Override
            public void onSuccess(final AttractionAtyBean attractionAtyBean) {

                lvAttractionAty.setAdapter(new CommonAdapter<AttractionAtyBean.ListBean>(attractionAtyBean.getList(), AttractionsAty.this, R.layout.item_travel_attractions_listview) {


                    @Override
                    public void setData(AttractionAtyBean.ListBean listBean
                            , CommonViewHolder viewHolder, int position) {
                        viewHolder.setText(R.id.item_travel_attentions_listview_textview_ch, listBean.getName_cn());

                        viewHolder.setText(R.id.item_travel_attentions_listview_textview_english, listBean.getName());
                        RelativeLayout rlForName = (RelativeLayout) viewHolder.getConvertView().findViewById(R.id.item_travel_attentions_listview_textview_rl);
                        if (listBean.getReview() != null) {
                            String name = listBean.getReview().getAuthor();
                            String content = listBean.getReview().getComment();
                            String nameAndContent = name + ":" + content;


                            //评论的文章作者
                            rlForName.setVisibility(View.VISIBLE);
                            viewHolder.setText(R.id.item_travel_attentions_listview_textview_name, nameAndContent);
                        } else {
                            rlForName.setVisibility(View.GONE);
                        }


                        RatingBar r = (RatingBar) viewHolder.getConvertView().findViewById(R.id.item_travel_attentions_listview_ratingbar);


                        float f = Float.parseFloat(listBean.getScore());
                        Log.d("AttractionsAty", "f:" + f);

                        r.setRating(f / 2);

                        String point = listBean.getScore();
                        String comment = listBean.getReviewCount();
                        String pointAndComment = point + "分" + "/" + comment + "点评";
                        viewHolder.setText(R.id.item_travel_attentions_listview_textview_point, pointAndComment);
                        viewHolder.setImage(R.id.item_travel_attentions_listview_imager, listBean.getCover(), AttractionsAty.this);

                    }
                });


                lvAttractionAty.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        String idUrl = attractionAtyBean.getList().get(i).getId();

                        Log.d("AttractionsAty", idUrl);

                        if (idUrl != null) {
                            Intent intentList = new Intent(AttractionsAty.this, AttractionListAty.class);
                            intentList.putExtra("urlId", idUrl);

                            startActivity(intentList);
                        } else {

                            Toast.makeText(AttractionsAty.this, "小编偷懒了,请稍后再试", Toast.LENGTH_SHORT).show();

                        }


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

            case R.id.activity_attractions_iv_back:

                finish();

                break;


        }
    }
}
