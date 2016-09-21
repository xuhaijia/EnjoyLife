package com.lanou.xuhaijia.enjoylife.music.songsin;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.lanou.xuhaijia.enjoylife.R;
import com.lanou.xuhaijia.enjoylife.base.BaseActivity;
import com.lanou.xuhaijia.enjoylife.base.NetTool;
import com.lanou.xuhaijia.enjoylife.base.UrlValues;
import com.lanou.xuhaijia.enjoylife.music.hotsingle.HotSingleBean;
import com.lanou.xuhaijia.enjoylife.music.playnotify.PlayEvent;
import com.lanou.xuhaijia.enjoylife.tools.CommonAdapter;
import com.lanou.xuhaijia.enjoylife.tools.CommonViewHolder;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

/**
 * Created by 徐海佳 on 16/9/19.
 */
public class SongsInActivity extends BaseActivity {

    private ListView lv;
    private TextView titleTv;
    private String id;
    private PlayEvent playEvent;
    private ImageView playIv;

    @Override
    protected int setLayout() {
        return R.layout.activity_songsin;
    }

    @Override
    protected void initView() {
        overridePendingTransition(R.anim.push_left_in,
                R.anim.push_left_out);
        Intent intent = getIntent();
        id = intent.getStringExtra("id");
        titleTv = bindView(R.id.activity_songsin_title);
        lv = bindView(R.id.activity_songsin_lv);
    }

    @Override
    protected void initData() {
        mNetTool.getData(UrlValues.MUSIC_SONGS_IN_START + id + UrlValues.MUSIC_SONGS_IN_END, HotSingleBean.class,
                new NetTool.NetInterface<HotSingleBean>() {
                    @Override
                    public void onSuccess(final HotSingleBean hotSingleBean) {
                        titleTv.setText(hotSingleBean.getArtist_name() + " - " + hotSingleBean.getPlaylist().getName());
                        lv.setAdapter(new CommonAdapter<HotSingleBean.SongsBean>(hotSingleBean.getSongs(),
                                SongsInActivity.this, R.layout.item_songsin) {
                            @Override
                            public void setData(final HotSingleBean.SongsBean songsBean,
                                                final CommonViewHolder viewHolder, final int position) {
                                viewHolder.setText(R.id.item_songsin_name, songsBean.getName());
                                viewHolder.setText(R.id.item_songsin_time, songsBean.getLength());
                                playIv = (ImageView)
                                        viewHolder.getConvertView().findViewById(R.id.item_songsin_play);
                                playIv.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {

                                        EventBus.getDefault().post(position);
                                        EventBus.getDefault().post(hotSingleBean.getSongs());
                                    }
                                });

                            }
                        });
                    }

                    @Override
                    public void onError(String errorMsg) {

                    }
                });



    }

    protected void onPause() {
        super.onPause();
        overridePendingTransition(R.anim.page_in,
                R.anim.page_out);

    }
}
