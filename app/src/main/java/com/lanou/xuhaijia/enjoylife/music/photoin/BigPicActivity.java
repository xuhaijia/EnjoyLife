package com.lanou.xuhaijia.enjoylife.music.photoin;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.widget.TextView;

import com.lanou.xuhaijia.enjoylife.R;
import com.lanou.xuhaijia.enjoylife.base.BaseActivity;
import com.lanou.xuhaijia.enjoylife.base.NetTool;
import com.lanou.xuhaijia.enjoylife.base.UrlValues;
import com.lanou.xuhaijia.enjoylife.tools.ZoomOutPageTransformer;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;

/**
 * Created by 徐海佳 on 16/9/23.
 */
public class BigPicActivity extends BaseActivity{

    private String title ;
    private List<PhotoInBean.PhotosBean> photos;
    private int position;
    private TextView titleTv;
    private ViewPager viewPager;
    private String id;
    private BigPicAdapter bigPicAdapter;

    @Override
    protected int setLayout() {
        return R.layout.activity_bigpic;

    }

    @Override
    protected void initView() {
        Intent intent = getIntent();
        position = intent.getIntExtra("position" , 0);
        id = intent.getStringExtra("id");
        titleTv = bindView(R.id.activity_bigpic_title);
        viewPager = bindView(R.id.activity_bigpic_vp);
    }

    @Override
    protected void initData() {
        viewPager.setPageTransformer(true , new ZoomOutPageTransformer());
        bigPicAdapter = new BigPicAdapter(BigPicActivity.this);
        mNetTool.getData(UrlValues.MUSIC_BIGPHOTO_START + id + UrlValues.MUSIC_BIGPHOTO_END, PhotoInBean.class, new NetTool.NetInterface<PhotoInBean>() {
            @Override
            public void onSuccess(PhotoInBean photoInBean) {
                title = photoInBean.getArtist_name() + "   -   " + photoInBean.getAlbum_name();
                titleTv.setText(title);
                photos = photoInBean.getPhotos();
                bigPicAdapter.setPhotos(photos);
                viewPager.setAdapter(bigPicAdapter);
                viewPager.setCurrentItem(position , false);
            }

            @Override
            public void onError(String errorMsg) {

            }
        });

    }





    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
