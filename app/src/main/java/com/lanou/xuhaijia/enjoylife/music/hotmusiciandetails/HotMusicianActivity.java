package com.lanou.xuhaijia.enjoylife.music.hotmusiciandetails;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lanou.xuhaijia.enjoylife.R;
import com.lanou.xuhaijia.enjoylife.base.BaseActivity;
import com.lanou.xuhaijia.enjoylife.base.NetTool;
import com.lanou.xuhaijia.enjoylife.base.UrlValues;
import com.lanou.xuhaijia.enjoylife.tools.DBTool;

import java.io.File;

/**
 * Created by 徐海佳 on 16/9/17.
 */
public class HotMusicianActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener, View.OnClickListener {

    private TextView titleTv;
    private TextView nameTv;
    private TextView styleTv;
    private TextView memberTv;
    private TextView careTv;
    private ImageView iconIv;
    private String id;
    private Intent intent;
    private ImageView collectionIV;
    private ImageView shareIv;
    private HotMusicianActivityBean bean;

    @Override
    protected int setLayout() {
        return R.layout.activity_hotmusician;
    }

    @Override
    protected void initView() {
        overridePendingTransition(R.anim.push_left_in,
                R.anim.push_left_out);
        intent = getIntent();
        id = intent.getStringExtra("id");
        titleTv = bindView(R.id.activity_hotmusician_title);
        nameTv = bindView(R.id.activity_hotmusician_name);
        styleTv = bindView(R.id.activity_hotmusician_type);
        memberTv = bindView(R.id.activity_hotmusician_member);
        careTv = bindView(R.id.activity_hotmusician_care);
        iconIv = bindView(R.id.activity_hotmusician_icon);
        collectionIV = bindView(R.id.activity_hotmusician_collection);
        shareIv = bindView(R.id.activity_hotmusician_share);
        collectionIV.setOnClickListener(this);
        shareIv.setOnClickListener(this);
        RadioGroup radioGroup = bindView(R.id.activity_hotmusician_rg);
        radioGroup.setOnCheckedChangeListener(this);
        radioGroup.check(R.id.activity_hotmusician_songs);
    }

    @Override
    protected void initData() {

        mNetTool.getData(UrlValues.MUSIC_CARE_ACTIVITY_START + id + UrlValues.MUSIC_CARE_ACTIVITY_END
                , HotMusicianActivityBean.class, new NetTool.NetInterface<HotMusicianActivityBean>() {
                    @Override
                    public void onSuccess(HotMusicianActivityBean hotMusicianActivityBean) {
                        bean = hotMusicianActivityBean;
                        titleTv.setText(hotMusicianActivityBean.getName());
                        nameTv.setText(hotMusicianActivityBean.getName());
                        styleTv.setText(hotMusicianActivityBean.getStyle());
                        memberTv.setText(hotMusicianActivityBean.getMember());
                        careTv.setText(hotMusicianActivityBean.getFollower() + "人关注");
                        Glide.with(HotMusicianActivity.this).load(hotMusicianActivityBean.getPicture()).into(iconIv);
                    }

                    @Override
                    public void onError(String errorMsg) {

                    }
                });

    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        LvFragment lvFragment = new LvFragment();
        Bundle bundle = new Bundle();
        bundle.putString("id", id);
        switch (i) {
            case R.id.activity_hotmusician_songs:
                bundle.putString("type", "songs");
                fragmentTransaction.replace(R.id.activity_hotmusician_fl, lvFragment);
                break;
            case R.id.activity_hotmusician_activity:
                bundle.putString("type", "activity");
                fragmentTransaction.replace(R.id.activity_hotmusician_fl, lvFragment);
                break;
            case R.id.activity_hotmusician_photo:
                bundle.putString("type", "photo");
                fragmentTransaction.replace(R.id.activity_hotmusician_fl, lvFragment);
                break;
            case R.id.activity_hotmusician_message:
                bundle.putString("type", "message");
                fragmentTransaction.replace(R.id.activity_hotmusician_fl, lvFragment);
                break;
            default:
                break;

        }
        lvFragment.setArguments(bundle);
        fragmentTransaction.commit();
    }

    @Override
    protected void onPause() {
        super.onPause();
        overridePendingTransition(R.anim.page_in,
                R.anim.page_out);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.activity_hotmusician_collection:
                break;
            case R.id.activity_hotmusician_share:
                shareMsg("选择分享", "Share", "分享" + bean.getName() + "这位歌手");
                break;
        }
    }

    public void shareMsg(String activityTitle, String msgTitle, String msgText
                         ) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT, msgTitle);
        intent.putExtra(Intent.EXTRA_TEXT, msgText);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(Intent.createChooser(intent, activityTitle));
    }
}
