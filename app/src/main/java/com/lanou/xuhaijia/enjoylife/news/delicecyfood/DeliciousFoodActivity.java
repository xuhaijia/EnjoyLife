package com.lanou.xuhaijia.enjoylife.news.delicecyfood;

import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lanou.xuhaijia.enjoylife.base.NetTool;
import com.lanou.xuhaijia.enjoylife.base.UrlValues;
import com.lanou.xuhaijia.enjoylife.news.delicecyfood.PullPushLayout.OnTouchEventMoveListenre;
import com.lanou.xuhaijia.enjoylife.R;
import com.lanou.xuhaijia.enjoylife.base.BaseActivity;

/**
 * Created by 国冰冰 on 16/10/8.
 */
public class DeliciousFoodActivity extends BaseActivity implements View.OnClickListener {
    private ViewPager viewPager;
    //    private View btnBack;
//    private TextView title;
//    private View lineNavBar;
//    private PullPushLayout mLayout;
//    private Drawable bgBackDrawable;
//    private View btnShare;		//标题分享
//    private Drawable bgShareDrawable;
//    private Drawable bgNavBarDrawable;
//    private Drawable bglineNavBarDrawable;
//    private View navBar;
//    private int alphaMax = 180;
//    private View view;
    private ImageView back;
    private DeclicacyFoodAdapter declicacyFoodAdapter;


    @Override
    protected int setLayout() {
        return R.layout.activity_news_viewpager_layout;
    }

    @Override
    protected void initView() {
        viewPager = bindView(R.id.fragment_news_delicecyfood_viewpager);
        back = bindView(R.id.iv_back);
        back.setOnClickListener(this);
        declicacyFoodAdapter = new DeclicacyFoodAdapter(DeliciousFoodActivity.this);
        viewPager.setAdapter(declicacyFoodAdapter);

        new NetTool().getData(UrlValues.NEWS_DELICACY_FOOD, DelicacyFoodBean.class, new NetTool.NetInterface<DelicacyFoodBean>() {
            @Override
            public void onSuccess(DelicacyFoodBean delicacyFoodBean) {
                declicacyFoodAdapter.setDelicacyFoodBeen(delicacyFoodBean);
            }

            @Override
            public void onError(String errorMsg) {

            }
        });

    }

    @Override
    protected void initData() {
    }

    @Override
    public void onClick(View view) {
        finish();
    }
}
