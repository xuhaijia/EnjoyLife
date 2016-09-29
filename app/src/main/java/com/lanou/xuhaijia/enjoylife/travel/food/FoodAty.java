package com.lanou.xuhaijia.enjoylife.travel.food;/*
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
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.lanou.xuhaijia.enjoylife.R;
import com.lanou.xuhaijia.enjoylife.base.BaseActivity;
import com.lanou.xuhaijia.enjoylife.base.NetTool;
import com.lanou.xuhaijia.enjoylife.base.UrlValues;
import com.lanou.xuhaijia.enjoylife.tools.CommonAdapter;
import com.lanou.xuhaijia.enjoylife.tools.CommonViewHolder;
import com.lanou.xuhaijia.enjoylife.travel.attractions.AttractionAtyBean;
import com.lanou.xuhaijia.enjoylife.travel.food.foodlist.FoodListAty;

public class FoodAty extends BaseActivity {

    private ListView lvFood;
    private String urlFood;

    @Override
    protected int setLayout() {
        return R.layout.activity_travel_food;
    }

    @Override
    protected void initView() {
        lvFood = bindView(R.id.activity_travel_food_listview);


    }

    @Override
    protected void initData() {

        Intent intent = getIntent();
        String urlId = intent.getStringExtra("foodId");

        if (urlId == null) {

            urlFood = UrlValues.TRAVEL_FOOD_INITALIZE;

        } else {

            urlFood = UrlValues.TRAVEL_FOOD_HEAD + urlId + UrlValues.TRAVEL_ATTRACTIONS_FOOD;
            Log.d("FoodAty", urlFood);


        }

        mNetTool.getData(urlFood, AttractionAtyBean.class, new NetTool.NetInterface<AttractionAtyBean>() {
            @Override
            public void onSuccess(final AttractionAtyBean attractionAtyBean) {
                lvFood.setAdapter(new CommonAdapter<AttractionAtyBean.ListBean>(attractionAtyBean.getList(), FoodAty.this, R.layout.item_travel_attractions_listview) {
                    @Override
                    public void setData(AttractionAtyBean.ListBean listBean, CommonViewHolder viewHolder, int position) {
                        //中文名字
                        TextView tvNameCn = (TextView) viewHolder.getConvertView().findViewById(R.id.item_travel_attentions_listview_textview_ch);

                        RelativeLayout relat = (RelativeLayout) viewHolder.getConvertView().findViewById(R.id.item_travel_attentions_listview_textview_rl);

                        viewHolder.setText(R.id.item_travel_attentions_listview_textview_english, listBean.getName());
                        RatingBar ratingBar = (RatingBar) viewHolder.getConvertView().findViewById(R.id.item_travel_attentions_listview_ratingbar);
                        float f = Float.parseFloat(listBean.getScore());
                        ratingBar.setRating(f / 2);

                        String point = listBean.getScore();
                        String comment = listBean.getReviewCount();
                        String pointAndComment = point + "分" + "/" + comment + "点评";
                        viewHolder.setText(R.id.item_travel_attentions_listview_textview_point, pointAndComment);
                        viewHolder.setImage(R.id.item_travel_attentions_listview_imager, listBean.getCover(), FoodAty.this);

                        if (listBean.getReview() != null) {
                            //中文名
                            tvNameCn.setText(listBean.getName_cn());
                            tvNameCn.setVisibility(View.VISIBLE);

                            String name = listBean.getReview().getAuthor();
                            String content = listBean.getReview().getComment();

                            String nameConten = name + ":" + content;

                            viewHolder.setText(R.id.item_travel_attentions_listview_textview_name, nameConten);
                            relat.setVisibility(View.VISIBLE);


                        } else {


                            tvNameCn.setVisibility(View.INVISIBLE);
                            relat.setVisibility(View.GONE);

                        }


                    }
                });


                lvFood.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {




                        Intent intentItem = new Intent(FoodAty.this, FoodListAty.class);
                        intentItem.putExtra("urlId", attractionAtyBean.getList().get(i).getId());

                        startActivity(intentItem);


                    }
                });

            }

            @Override
            public void onError(String errorMsg) {

            }
        });


    }



}
