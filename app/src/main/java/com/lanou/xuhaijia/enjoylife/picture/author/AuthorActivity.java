package com.lanou.xuhaijia.enjoylife.picture.author;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lanou.xuhaijia.enjoylife.R;
import com.lanou.xuhaijia.enjoylife.base.BaseActivity;
import com.lanou.xuhaijia.enjoylife.base.MyApp;
import com.lanou.xuhaijia.enjoylife.base.NetTool;
import com.lanou.xuhaijia.enjoylife.base.UrlValues;
import com.lanou.xuhaijia.enjoylife.picture.details.DetailsBean;
import com.lanou.xuhaijia.enjoylife.tools.CommonViewHolder;
import com.lanou.xuhaijia.enjoylife.tools.RecycleViewAdapter;

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
public class AuthorActivity extends BaseActivity implements View.OnClickListener {


    private CarouselView carouselView;
    private GridViewAdapter gridViewAdapter;
    private ImageView photoIv;
    private TextView nameTv;
    private TextView lableTv;
    private TextView descriptionTv;
    private Button expandBtn;
    private Button recoverBtn;
    private RecyclerView mRecyclerView;


    @Override
    protected int setLayout() {
        return R.layout.activity_author;
    }

    @Override
    protected void initView() {
        carouselView = bindView(R.id.activity_author_carousel_view);
        carouselView.setContext(getApplicationContext());
        photoIv = bindView(R.id.activity_author_photo);
        nameTv = bindView(R.id.activity_author_name);
        lableTv = bindView(R.id.activity_author_label);
        descriptionTv = bindView(R.id.activity_author_description);
        expandBtn = bindView(R.id.activity_author_expand);
        recoverBtn = bindView(R.id.activity_author_recover);
        recoverBtn.setVisibility(View.GONE);
        mRecyclerView = bindView(R.id.activity_author_recycler_view);

        expandBtn.setOnClickListener(this);
        recoverBtn.setOnClickListener(this);


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
                Glide.with(MyApp.getContext()).load(authorBean.getData().getAvatar_url()).into(photoIv);
                nameTv.setText(authorBean.getData().getName());
                lableTv.setText(authorBean.getData().getLabel());
                descriptionTv.setText(authorBean.getData().getDescription());
            }

            @Override
            public void onError(String errorMsg) {

            }
        });
        String urlTwo = UrlValues.PIVTURE_DETAILS_STAER_URL + urlAdd + UrlValues.PIVTURE_DETAILS_END_URL;
        mNetTool.getData(urlTwo, DetailsBean.class, new NetTool.NetInterface<DetailsBean>() {
            @Override
            public void onSuccess(DetailsBean detailsBean) {
                GridLayoutManager layoutManager = new GridLayoutManager(MyApp.getContext(), 2);
                mRecyclerView.setLayoutManager(layoutManager);

                mRecyclerView.setAdapter(new RecycleViewAdapter<DetailsBean.DataBean.ReferProductsBean>(detailsBean.getData().getRefer_products(),
                        AuthorActivity.this, R.layout.details_receyler_item) {
                    @Override
                    public void setData(DetailsBean.DataBean.ReferProductsBean referProductsBean, CommonViewHolder viewHolder) {
                        viewHolder.setImage(R.id.details_receyler_iv, referProductsBean.getCover_images().get(0), AuthorActivity.this);
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
        switch (view.getId()){
            case R.id.activity_author_expand:
                descriptionTv.setMaxLines(100);
                recoverBtn.setVisibility(View.VISIBLE);
                expandBtn.setVisibility(View.GONE);
                break;
            case R.id.activity_author_recover:
                descriptionTv.setMaxLines(3);
                expandBtn.setVisibility(View.VISIBLE);
                recoverBtn.setVisibility(View.GONE);
                break;
        }
    }
}
