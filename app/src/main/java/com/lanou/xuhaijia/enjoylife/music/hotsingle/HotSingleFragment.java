package com.lanou.xuhaijia.enjoylife.music.hotsingle;

import android.app.ActivityManager;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lanou.xuhaijia.enjoylife.R;
import com.lanou.xuhaijia.enjoylife.base.BaseFragment;
import com.lanou.xuhaijia.enjoylife.base.NetTool;
import com.lanou.xuhaijia.enjoylife.base.UrlValues;
import com.lanou.xuhaijia.enjoylife.music.hotmusiciandetails.HotMusicianActivity;
import com.lanou.xuhaijia.enjoylife.music.playnotify.PlayEvent;
import com.lanou.xuhaijia.enjoylife.music.playnotify.PlayService;
import com.lanou.xuhaijia.enjoylife.tools.CommonAdapter;
import com.lanou.xuhaijia.enjoylife.tools.CommonViewHolder;
import com.lanou.xuhaijia.enjoylife.tools.LoadingLineView;
import com.lanou.xuhaijia.enjoylife.tools.MyListView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;

/**
 * Created by 徐海佳 on 16/9/13.
 */
public class HotSingleFragment extends BaseFragment {

    private MyListView hotSingleLv;
    private Dialog mLoginingDlg;
    private ImageView play;
    private PlayEvent playEvent;
    private String sec;
    private PopupWindow window;
    private boolean isShow = false;
    private HotSingleBean beanForService;
    private int posForService;
    private boolean isRestart = false;
    private ImageView playOrStopIv;
    private ImageView nextIv;
    private ImageView iconIv;
    private TextView songsNameTv;
    private String time;
    private long timeL;

    @Override
    protected int setLayout() {
        return R.layout.fragment_hotsingle;
    }

    @Override
    protected void initView() {
        hotSingleLv = bindView(R.id.fragment_hotsingle_lv);
        EventBus.getDefault().register(this);
    }

    @Override
    protected void initData() {
        initLoginingDlg();

    }

    @Subscribe
    public void startService(Boolean b) {
        if (beanForService != null && isRestart) {
            EventBus.getDefault().post(posForService);
            EventBus.getDefault().post(beanForService.getSongs());
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        if (!isShow) {
            showLoginingDlg();
        }
        mNetTool.getData(UrlValues.MUSIC_HOT_SINGLE, HotSingleBean.class, new NetTool.NetInterface<HotSingleBean>() {
            @Override
            public void onSuccess(final HotSingleBean hotSingleBean) {
                isShow = true;
                beanForService = hotSingleBean;
                hotSingleLv.setAdapter(new CommonAdapter<HotSingleBean.SongsBean>(hotSingleBean.getSongs()
                        , mContext, R.layout.item_hotsingle) {
                    @Override
                    public void setData(final HotSingleBean.SongsBean songsBean, CommonViewHolder viewHolder, final int position) {
                        viewHolder.setText(R.id.item_hotsingle_songname, songsBean.getName());
                        viewHolder.setText(R.id.item_hotsingle_name, songsBean.getArtist());
                        viewHolder.setImage(R.id.item_hotsingle_icon, songsBean.getPicture(), mContext);

                        if (songsBean.getRank() < 10) {
                            viewHolder.setText(R.id.item_hotsingle_rank, "0" + songsBean.getRank());
                        } else {
                            viewHolder.setText(R.id.item_hotsingle_rank, "" + songsBean.getRank());
                        }
                        play = (ImageView) viewHolder.getConvertView().findViewById(R.id.item_hotsingle_play);
                        play.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                if (isServiceWork(mContext, "com.lanou.xuhaijia.enjoylife.music.playnotify.PlayService")) {

                                } else {
                                    posForService = position;
                                    isRestart = true;
                                    Intent play = new Intent(mContext, PlayService.class);
                                    getActivity().startService(play);
                                }
                                EventBus.getDefault().post(position);
                                EventBus.getDefault().post(hotSingleBean.getSongs());
                            }
                        });

                    }
                });
                closeLoginingDlg();
                hotSingleLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Intent intent = new Intent(getContext(), HotMusicianActivity.class);
                        intent.putExtra("id", hotSingleBean.getSongs().get(i).getArtist_id());
                        startActivity(intent);

                    }
                });
            }

            @Override
            public void onError(String errorMsg) {

            }
        });
    }



    private void initLoginingDlg() {
        mLoginingDlg = new Dialog(mContext, R.style.loginingDlg);
        LoadingLineView loadingLineView = new LoadingLineView(mContext);
        mLoginingDlg.setContentView(loadingLineView);
        RotateAnimation rotateAnimation = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF,
                0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotateAnimation.setDuration(3000);
        rotateAnimation.setRepeatCount(-1);
        rotateAnimation.setRepeatMode(Animation.RESTART);
        loadingLineView.startAnimation(rotateAnimation);

    }

    private void showLoginingDlg() {
        if (mLoginingDlg != null)
            mLoginingDlg.show();
    }


    private void closeLoginingDlg() {
        if (mLoginingDlg != null && mLoginingDlg.isShowing())
            mLoginingDlg.dismiss();
    }

    private long stringToLong(String time) {
        long minute = Long.parseLong(time.substring(0, 1));
        long a = minute * 60 * 1000;
        long second = Long.parseLong(time.substring(2, time.length()));
        long b = second * 1000;
        return a + b;
    }

    /**
     * 判断某个服务是否正在运行的方法
     *
     * @param mContext
     * @param serviceName 是包名+服务的类名（例如：net.loonggg.testbackstage.TestService）
     * @return true代表正在运行，false代表服务没有正在运行
     */
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
