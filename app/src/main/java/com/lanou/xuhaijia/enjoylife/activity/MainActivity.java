package com.lanou.xuhaijia.enjoylife.activity;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.lanou.xuhaijia.enjoylife.R;
import com.lanou.xuhaijia.enjoylife.base.BaseActivity;
import com.lanou.xuhaijia.enjoylife.music.MusicFragment;
import com.lanou.xuhaijia.enjoylife.music.playnotify.PlayService;
import com.lanou.xuhaijia.enjoylife.myself.MyBmobUser;
import com.lanou.xuhaijia.enjoylife.myself.MyselfFragment;
import com.lanou.xuhaijia.enjoylife.news.NewsFragment;
import com.lanou.xuhaijia.enjoylife.picture.picture.PictureFragment;
import com.lanou.xuhaijia.enjoylife.travel.travlesfragment.TravelFragment;
import com.lanou.xuhaijia.enjoylife.welfare.WelfareFragment;

import cn.bmob.v3.BmobUser;

public class MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener {


    public TextView lineTv;
    private MyBmobUser myBmobUser;
    private BmobUser bmobUser;
    private boolean isSure;

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

    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        switch (i) {
            case R.id.activity_main_music_rb:
                fragmentTransaction.replace(R.id.activity_main_fl, new MusicFragment());
                break;
            case R.id.activity_main_travel_rb:
                fragmentTransaction.replace(R.id.activity_main_fl, new TravelFragment());
                break;
            case R.id.activity_main_news_rb:
                fragmentTransaction.replace(R.id.activity_main_fl, new NewsFragment());
                break;
            case R.id.activity_main_picture_rb:
                fragmentTransaction.replace(R.id.activity_main_fl, new PictureFragment());
                break;
            case R.id.activity_main_welfare_rb:
                myBmobUser = BmobUser.getCurrentUser(MyBmobUser.class);
                bmobUser = BmobUser.getCurrentUser();
                if (bmobUser != null) {
                    fragmentTransaction.replace(R.id.activity_main_fl, new WelfareFragment());

                } else {
                    Toast.makeText(this, "快去登录 享受EnjoyLife用户专有福利吧", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.activity_main_myself_rb:
                fragmentTransaction.replace(R.id.activity_main_fl, new MyselfFragment());
                break;
            default:
                break;
        }
        fragmentTransaction.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        isSure = false;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (isSure) {
                return super.onKeyDown(keyCode, event);
            } else {
                Toast.makeText(this, "再按一次拒绝享受生活", Toast.LENGTH_LONG).show();
                isSure = true;
                CountDownTimer countDownTimer = new CountDownTimer(7000, 1000) {
                    @Override
                    public void onTick(long l) {

                    }

                    @Override
                    public void onFinish() {
                        isSure = false;
                    }
                }.start();
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }
}
