package com.lanou.xuhaijia.enjoylife.music.photoin;

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.lanou.xuhaijia.enjoylife.R;
import com.lanou.xuhaijia.enjoylife.base.BaseActivity;
import com.lanou.xuhaijia.enjoylife.base.NetTool;
import com.lanou.xuhaijia.enjoylife.base.UrlValues;
import com.lanou.xuhaijia.enjoylife.tools.CommonViewHolder;
import com.lanou.xuhaijia.enjoylife.tools.RecycleViewAdapter;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by 徐海佳 on 16/9/19.
 */
public class PhotoInActivity extends BaseActivity {

    private RecyclerView photoInRv;
    private String url;
    private TextView tv;
    private TextView titleTv;
    private String id;

    @Override
    protected int setLayout() {
        return R.layout.activity_photoin;
    }

    @Override
    protected void initView() {
        overridePendingTransition(R.anim.push_left_in,
                R.anim.push_left_out);
        Intent intent = getIntent();
        id = intent.getStringExtra("id");
        url = UrlValues.MUSIC_PHOTO_IN_START + id + UrlValues.MUSIC_PHOTO_IN_END;
        photoInRv = bindView(R.id.activity_photoin_rv);
        tv = bindView(R.id.activity_photoin_tv);
        titleTv = bindView(R.id.activity_photoin_title);
        tv.setVisibility(View.INVISIBLE);
    }

    @Override
    protected void initData() {
        GridLayoutManager manager = new GridLayoutManager(this, 3);
        photoInRv.setLayoutManager(manager);
        mNetTool.getData(url, PhotoInBean.class, new NetTool.NetInterface<PhotoInBean>() {
            @Override
            public void onSuccess(final PhotoInBean photoInBean) {
                titleTv.setText(photoInBean.getArtist_name() + "   -   " + photoInBean.getAlbum_name());
                if (photoInBean.getPhotos().size() == 0) {
                    tv.setVisibility(View.VISIBLE);
                } else {
                    photoInRv.setAdapter(new RecycleViewAdapter<PhotoInBean.PhotosBean>(photoInBean.getPhotos()
                            , PhotoInActivity.this, R.layout.item_photo_in) {
                        @Override
                        public void setData(PhotoInBean.PhotosBean photosBean, final CommonViewHolder viewHolder) {
                            viewHolder.setImage(R.id.item_photoin_iv, photosBean.getUrl(), PhotoInActivity.this);
                            viewHolder.getConvertView().setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent intent = new Intent(PhotoInActivity.this , BigPicActivity.class);
                                    intent.putExtra("position" , viewHolder.getLayoutPosition());
                                    intent.putExtra("id" , id);
                                    startActivity(intent);

                                }
                            });
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
