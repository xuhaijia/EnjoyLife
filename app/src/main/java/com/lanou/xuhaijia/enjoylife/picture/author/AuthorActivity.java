package com.lanou.xuhaijia.enjoylife.picture.author;

import android.content.Intent;
import android.support.v4.view.ViewPager;

import com.lanou.xuhaijia.enjoylife.R;
import com.lanou.xuhaijia.enjoylife.base.BaseActivity;
import com.lanou.xuhaijia.enjoylife.base.MyApp;
import com.lanou.xuhaijia.enjoylife.base.NetTool;
import com.lanou.xuhaijia.enjoylife.base.UrlValues;

/**
 * 　　　　　　　　┏┓　　　┏┓+ +
 * 　　　　　　　┏┛┻━━━┛┻┓ + +
 * 　　　　　　　┃　　　　　　　┃
 * 　　　　　　　┃　　　━　　　┃ ++ + + +
 * 　　　　　　 ████━████ ┃+
 * 　　　　　　　┃　　　　　　　┃ +
 * 　　　　　　　┃　　　┻　　　┃
 * 　　　　　　　┃　　　　　　　┃ + +
 * 　　　　　　　┗━┓　　　┏━┛
 * 　　　　　　　　　┃　　　┃
 * 　　　　　　　　　┃　　　┃ + + + +
 * 　　　　　　　　　┃　　　┃　　　　Code is far away from bug with the animal protecting
 * 　　　　　　　　　┃　　　┃ + 　　　　神兽保佑代码无BUG,
 * <p>
 * 　　　　　　　　　┃　　　┃
 * 　　　　　　　　　┃　　　┃　　+
 * 　　　　　　　　　┃　 　　┗━━━┓ + +
 * 　　　　　　　　　┃ 　　　　　　　┣┓
 * 　　　　　　　　　┃ 　　　　　　　┏┛
 * 　　　　　　　　　┗┓┓┏━┳┓┏┛ + + + +
 * 　　　　　　　　　　┃┫┫　┃┫┫
 * 　　　　　　　　　　┗┻┛　┗┻┛+ + + +
 * <p>
 * Created by 史静雯 date
 */
public class AuthorActivity extends BaseActivity {


    private CarouselView carouselView;
    private GridViewAdapter gridViewAdapter;


    @Override
    protected int setLayout() {
        return R.layout.activity_author;
    }

    @Override
    protected void initView() {
        carouselView = bindView(R.id.activity_author_carousel_view);
        carouselView.setContext(getApplicationContext());

    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        String urlAdd = intent.getStringExtra("ID");
        String url = UrlValues.AUTHOR_WHEEL_STAER + urlAdd + UrlValues.AUTHOE_WHEEL_END;
        mNetTool.getData(url, AuthorBean.class, new NetTool.NetInterface<AuthorBean>() {
            @Override
            public void onSuccess(AuthorBean authorBean) {
                carouselView.setPicUrls(authorBean.getData().getIntroduce_images());
                carouselView.start(authorBean.getData().getIntroduce_images());
            }

            @Override
            public void onError(String errorMsg) {

            }
        });


    }
}
