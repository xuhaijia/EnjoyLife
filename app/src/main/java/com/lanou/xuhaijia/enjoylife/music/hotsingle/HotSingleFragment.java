package com.lanou.xuhaijia.enjoylife.music.hotsingle;

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
import com.lanou.xuhaijia.enjoylife.tools.CommonAdapter;
import com.lanou.xuhaijia.enjoylife.tools.CommonViewHolder;
import com.lanou.xuhaijia.enjoylife.tools.LoadingLineView;
import com.lanou.xuhaijia.enjoylife.tools.MyListView;

import org.greenrobot.eventbus.EventBus;

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

    @Override
    protected int setLayout() {
        return R.layout.fragment_hotsingle;
    }

    @Override
    protected void initView() {
        hotSingleLv = bindView(R.id.fragment_hotsingle_lv);
    }

    @Override
    protected void initData() {
        initLoginingDlg();

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
                hotSingleLv.setAdapter(new CommonAdapter<HotSingleBean.SongsBean>(hotSingleBean.getSongs()
                        , mContext, R.layout.item_hotsingle) {
                    @Override
                    public void setData(final HotSingleBean.SongsBean songsBean, CommonViewHolder viewHolder , final int position) {
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
//                                showPlay(hotSingleBean.getSongs(), position);
//                                showPopUp(getActivity().findViewById(R.id.activity_main_line));
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

    private void showPopUp(View v) {
        LinearLayout layout = new LinearLayout(getContext());
        layout.setBackgroundColor(Color.GRAY);
        TextView tv = new TextView(getContext());
        tv.setLayoutParams(new WindowManager.LayoutParams(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT));
        tv.setText("I'm a pop -----------------------------!");
        tv.setTextColor(Color.WHITE);
        layout.addView(tv);

        PopupWindow popupWindow = new PopupWindow(layout, 120, 120);
        popupWindow.setFocusable(true);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.setAnimationStyle(R.style.PlayDialogAnimation);

        int[] location = new int[2];
        v.getLocationOnScreen(location);

        popupWindow.showAtLocation(v, Gravity.NO_GRAVITY, location[0], location[1] - popupWindow.getHeight());
    }
    public void showPlay(final List<HotSingleBean.SongsBean> songs, final int position) {
        if (window != null && window.isShowing()) {
            window.dismiss();
        }
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_play, null);
        window = new PopupWindow(view,
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.WRAP_CONTENT);
        ImageView iconIv = (ImageView) view.findViewById(R.id.item_play_icon);
        TextView songsNameTv = (TextView) view.findViewById(R.id.item_play_songs_name);
        final TextView timeTv = (TextView) view.findViewById(R.id.item_play_songs_time);
        ImageView playOrStopIv = (ImageView) view.findViewById(R.id.item_play_playorstop);
        ImageView nextIv = (ImageView) view.findViewById(R.id.item_play_next);
        Glide.with(getContext()).load(songs.get(position).getPicture()).into(iconIv);
        songsNameTv.setText(songs.get(position).getName());
        final String time = songs.get(position).getLength();
        final long timeL = stringToLong(time);
        CountDownTimer countDownTimer = new CountDownTimer(timeL , 1000) {
            int a = position;
            @Override
            public void onTick(long l) {
                int minute = (int) (l / 1000 / 60);
                String min = String.valueOf(minute);
                int second = (int) (l / 1000 % 60);
                if (second >= 10) {
                    sec = String.valueOf(second);
                } else {
                    sec = "0" + String.valueOf(second);
                }
                String remainderTime = min + ":" + sec;
                timeTv.setText(remainderTime);
            }

            @Override
            public void onFinish() {
                if (a + 1 < songs.size() ) {
                    playEvent.setName(songs.get(a + 1).getName());
                    playEvent.setUrlPlay(songs.get(a + 1).getSrc());
                    EventBus.getDefault().post(playEvent);
                    showPlay(songs , a + 1);
                }  else {
                    playEvent.setName(songs.get(0).getName());
                    playEvent.setUrlPlay(songs.get(0).getSrc());
                    EventBus.getDefault().post(playEvent);
                    showPlay(songs , 0);
                }
            }
        }.start();


        // 设置popWindow弹出窗体可点击，这句话必须添加，并且是true
        window.setFocusable(true);
        // 实例化一个ColorDrawable颜色为半透明
        ColorDrawable dw = new ColorDrawable(0xb0000000);
        window.setBackgroundDrawable(dw);

        // 设置popWindow的显示和消失动画
        window.setAnimationStyle(R.style.PlayDialogAnimation);
        // 在底部显示
        window.showAtLocation(getView(),
                Gravity.BOTTOM, 0, 150);

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
        long minute = Long.parseLong(time.substring(0 , 1));
        long a = minute * 60 * 1000;
        long second = Long.parseLong(time.substring(2 , time.length()));
        long b = second * 1000;
        return a + b;
    }
}
