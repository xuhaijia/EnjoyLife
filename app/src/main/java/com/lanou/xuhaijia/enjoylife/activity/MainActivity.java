package com.lanou.xuhaijia.enjoylife.activity;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.lanou.xuhaijia.enjoylife.R;
import com.lanou.xuhaijia.enjoylife.base.BaseActivity;
import com.lanou.xuhaijia.enjoylife.music.MusicFragment;
import com.lanou.xuhaijia.enjoylife.music.playnotify.PlayService;
import com.lanou.xuhaijia.enjoylife.myself.MyselfFragment;
import com.lanou.xuhaijia.enjoylife.news.NewsFragment;
import com.lanou.xuhaijia.enjoylife.picture.picture.PictureFragment;
import com.lanou.xuhaijia.enjoylife.travel.TravelFragment;
import com.lanou.xuhaijia.enjoylife.welfare.WelfareFragment;

public class MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener {


    public TextView lineTv;

    @Override
    protected int setLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        lineTv = bindView(R.id.activity_main_line);
        RadioGroup radioGroup = bindView(R.id.activity_main_rg);
        radioGroup.setOnCheckedChangeListener(this);
        radioGroup.check(R.id.activity_main_music_rb);
    }

    @Override
    protected void initData() {
        Intent play = new Intent(MainActivity.this , PlayService.class);
        startService(play);
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        switch (i) {
            case R.id.activity_main_music_rb:
                fragmentTransaction.replace(R.id.activity_main_fl , new MusicFragment());
                break;
            case R.id.activity_main_travel_rb:
                fragmentTransaction.replace(R.id.activity_main_fl  , new TravelFragment());
                break;
            case R.id.activity_main_news_rb:
                fragmentTransaction.replace(R.id.activity_main_fl  , new NewsFragment());
                break;
            case R.id.activity_main_picture_rb:
                fragmentTransaction.replace(R.id.activity_main_fl  , new PictureFragment());
                break;
            case R.id.activity_main_welfare_rb:
                fragmentTransaction.replace(R.id.activity_main_fl  , new WelfareFragment());
                break;
            case R.id.activity_main_myself_rb:
                fragmentTransaction.replace(R.id.activity_main_fl  , new MyselfFragment());
                break;
            default:
                break;
        }
        fragmentTransaction.commit();
    }
}
