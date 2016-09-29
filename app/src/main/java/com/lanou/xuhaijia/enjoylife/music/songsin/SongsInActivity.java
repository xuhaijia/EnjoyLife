package com.lanou.xuhaijia.enjoylife.music.songsin;

import android.app.ActivityManager;
import android.content.Context;
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
import com.lanou.xuhaijia.enjoylife.music.playnotify.PlayService;
import com.lanou.xuhaijia.enjoylife.tools.CommonAdapter;
import com.lanou.xuhaijia.enjoylife.tools.CommonViewHolder;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

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
    private int posForService;
    private HotSingleBean beanForService;
    private boolean isRestart = false;
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
        EventBus.getDefault().register(this);
    }

    @Override
    protected void initData() {
        mNetTool.getData(UrlValues.MUSIC_SONGS_IN_START + id + UrlValues.MUSIC_SONGS_IN_END, HotSingleBean.class,
                new NetTool.NetInterface<HotSingleBean>() {
                    @Override
                    public void onSuccess(final HotSingleBean hotSingleBean) {
                        beanForService = hotSingleBean;
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
                                        if (isServiceWork(SongsInActivity.this, "com.lanou.xuhaijia.enjoylife.music.playnotify.PlayService")) {

                                        } else {
                                            posForService = position;
                                            isRestart = true;
                                            Intent play = new Intent(SongsInActivity.this, PlayService.class);
                                            startService(play);
                                        }
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

    @Subscribe
    public void startService(Boolean b) {
        if (beanForService != null && isRestart) {
            EventBus.getDefault().post(posForService);
            EventBus.getDefault().post(beanForService.getSongs());
        }
    }

    protected void onPause() {
        super.onPause();
        overridePendingTransition(R.anim.page_in,
                R.anim.page_out);
        isRestart = false;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    public boolean isServiceWork(Context mContext, String serviceName) {
        boolean isWork = false;
        ActivityManager myAM = (ActivityManager) mContext
                .getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningServiceInfo> myList = myAM.getRunningServices(40);
        if (myList.size() <= 0) {
            return false;
        }
        for (int i = 0; i < myList.size(); i++) {
            String mName = myList.get(i).service.getClassName().toString();
            if (mName.equals(serviceName)) {
                isWork = true;
                break;
            }
        }
        return isWork;
    }
}
