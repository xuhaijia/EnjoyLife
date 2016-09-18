package com.lanou.xuhaijia.enjoylife.music.hotsingle;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
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

import com.lanou.xuhaijia.enjoylife.R;
import com.lanou.xuhaijia.enjoylife.activity.MainActivity;
import com.lanou.xuhaijia.enjoylife.base.BaseFragment;
import com.lanou.xuhaijia.enjoylife.base.NetTool;
import com.lanou.xuhaijia.enjoylife.base.UrlValues;
import com.lanou.xuhaijia.enjoylife.music.hotmusician.HotMusicianActivity;
import com.lanou.xuhaijia.enjoylife.music.playnotify.PlayEvent;
import com.lanou.xuhaijia.enjoylife.tools.CommonAdapter;
import com.lanou.xuhaijia.enjoylife.tools.CommonViewHolder;
import com.lanou.xuhaijia.enjoylife.tools.LoadingLineView;
import com.lanou.xuhaijia.enjoylife.tools.MyListView;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;

/**
 * Created by 徐海佳 on 16/9/13.
 */
public class HotSingleFragment extends BaseFragment {

    private MyListView hotSingleLv;
    private Dialog mLoginingDlg;
    private ImageView play;
    private PlayEvent playEvent;

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
        showLoginingDlg();
        mNetTool.getData(UrlValues.MUSIC_HOT_SINGLE, HotSingleBean.class, new NetTool.NetInterface<HotSingleBean>() {
            @Override
            public void onSuccess(final HotSingleBean hotSingleBean) {
                closeLoginingDlg();
                hotSingleLv.setAdapter(new CommonAdapter<HotSingleBean.SongsBean>(hotSingleBean.getSongs(), mContext, R.layout.item_hotsingle) {
                    @Override
                    public void setData(final HotSingleBean.SongsBean songsBean, CommonViewHolder viewHolder) {
                        viewHolder.setText(R.id.item_hotsingle_songname, songsBean.getName());
                        viewHolder.setText(R.id.item_hotsingle_name, songsBean.getArtist());
                        viewHolder.setImage(R.id.item_hotsingle_icon, songsBean.getPicture(), mContext);
                        if (songsBean.getRank() < 10) {
                            viewHolder.setText(R.id.item_hotsingle_rank, "0" + songsBean.getRank());
                        } else {
                            viewHolder.setText(R.id.item_hotsingle_rank, "" + songsBean.getRank());
                        }
                        play = (ImageView) viewHolder.getConvertView().findViewById(R.id.item_hotsingle_play);
                        playEvent = new PlayEvent();
                        play.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
//                                showPlay();
//                                showPopUp(getActivity().findViewById(R.id.activity_main_line));
                                playEvent.setName(songsBean.getName());
                                playEvent.setUrlPlay(songsBean.getSrc());
                                EventBus.getDefault().post(playEvent);

                            }
                        });

                    }
                });
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

    public void showPlay() {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_play, null);
        // 下面是两种方法得到宽度和高度 getWindow().getDecorView().getWidth()
        PopupWindow window = new PopupWindow(view,
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.WRAP_CONTENT);
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
        RotateAnimation rotateAnimation = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF,
                0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotateAnimation.setDuration(4000);
        rotateAnimation.setRepeatCount(-1);
        rotateAnimation.setRepeatMode(Animation.RESTART);
        loadingLineView.startAnimation(rotateAnimation);
        mLoginingDlg.setContentView(loadingLineView);

    }

    private void showLoginingDlg() {
        if (mLoginingDlg != null)
            mLoginingDlg.show();
    }


    private void closeLoginingDlg() {
        if (mLoginingDlg != null && mLoginingDlg.isShowing())
            mLoginingDlg.dismiss();
    }


}
