package com.lanou.xuhaijia.enjoylife.music.photoin;

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.lanou.xuhaijia.enjoylife.R;
import com.lanou.xuhaijia.enjoylife.base.BaseActivity;
import com.lanou.xuhaijia.enjoylife.base.NetTool;
import com.lanou.xuhaijia.enjoylife.base.UrlValues;
import com.lanou.xuhaijia.enjoylife.tools.CommonViewHolder;
import com.lanou.xuhaijia.enjoylife.tools.RecycleViewAdapter;

/**
 * Created by 徐海佳 on 16/9/19.
 */
public class PhotoInActivity extends BaseActivity {

    private RecyclerView photoInRv;
    private String url;
    private TextView tv;

    @Override
    protected int setLayout() {
        return R.layout.activity_photoin;
    }

    @Override
    protected void initView() {
        overridePendingTransition(R.anim.push_left_in,
                R.anim.push_left_out);
        Intent intent = getIntent();
        url = UrlValues.MUSIC_PHOTO_IN_START + intent.getStringExtra("id") + UrlValues.MUSIC_PHOTO_IN_END;
        photoInRv = bindView(R.id.activity_photoin_rv);
        tv = bindView(R.id.activity_photoin_tv);
        tv.setVisibility(View.INVISIBLE);
    }

    @Override
    protected void initData() {
        GridLayoutManager manager = new GridLayoutManager(this, 3);
        photoInRv.setLayoutManager(manager);
        mNetTool.getData(url, PhotoInBean.class, new NetTool.NetInterface<PhotoInBean>() {
            @Override
            public void onSuccess(PhotoInBean photoInBean) {
                if (photoInBean.getPhotos().size() == 0) {
                    tv.setVisibility(View.VISIBLE);
                } else {
                    photoInRv.setAdapter(new RecycleViewAdapter<PhotoInBean.PhotosBean>(photoInBean.getPhotos()
                            , PhotoInActivity.this, R.layout.item_photo_in) {
                        @Override
                        public void setData(PhotoInBean.PhotosBean photosBean, CommonViewHolder viewHolder) {
                            viewHolder.setImage(R.id.item_photoin_iv, photosBean.getUrl(), PhotoInActivity.this);
                        }
                    });
                }
            }

            @Override
            public void onError(String errorMsg) {

            }
        });
    }
}
