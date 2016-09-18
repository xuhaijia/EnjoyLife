package com.lanou.xuhaijia.enjoylife.music.hotmusician;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lanou.xuhaijia.enjoylife.R;
import com.lanou.xuhaijia.enjoylife.base.BaseActivity;
import com.lanou.xuhaijia.enjoylife.base.NetTool;
import com.lanou.xuhaijia.enjoylife.base.UrlValues;

/**
 * Created by 徐海佳 on 16/9/17.
 */
public class HotMusicianActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener {

    private TextView titleTv;
    private TextView nameTv;
    private TextView styleTv;
    private TextView memberTv;
    private TextView careTv;
    private ImageView iconIv;

    @Override
    protected int setLayout() {
        return R.layout.activity_hotmusician;
    }

    @Override
    protected void initView() {
        overridePendingTransition(R.anim.push_left_in,
                R.anim.push_left_out);
        titleTv = bindView(R.id.activity_hotmusician_title);
        nameTv = bindView(R.id.activity_hotmusician_name);
        styleTv = bindView(R.id.activity_hotmusician_type);
        memberTv = bindView(R.id.activity_hotmusician_member);
        careTv = bindView(R.id.activity_hotmusician_care);
        iconIv = bindView(R.id.activity_hotmusician_icon);
        RadioGroup radioGroup = bindView(R.id.activity_hotmusician_rg);
        radioGroup.setOnCheckedChangeListener(this);
        radioGroup.check(R.id.activity_hotmusician_songs);
    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        mNetTool.getData(UrlValues.MUSIC_CARE_ACTIVITY_START + id + UrlValues.MUSIC_CARE_ACTIVITY_END
                , HotMusicianActivityBean.class, new NetTool.NetInterface<HotMusicianActivityBean>() {
                    @Override
                    public void onSuccess(HotMusicianActivityBean hotMusicianActivityBean) {
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
        switch (i) {
            case R.id.activity_hotmusician_songs:
                fragmentTransaction.replace(R.id.activity_hotmusician_fl , new SongsFragment());
                break;
            case R.id.activity_hotmusician_activity:
                fragmentTransaction.replace(R.id.activity_hotmusician_fl , new SongsFragment());
                break;
            case R.id.activity_hotmusician_photo:
                fragmentTransaction.replace(R.id.activity_hotmusician_fl , new SongsFragment());
                break;
            case R.id.activity_hotmusician_trends:
                fragmentTransaction.replace(R.id.activity_hotmusician_fl , new SongsFragment());
                break;
            case R.id.activity_hotmusician_message:
                fragmentTransaction.replace(R.id.activity_hotmusician_fl , new SongsFragment());
                break;
            default:
                break;

        }
        fragmentTransaction.commit();
    }

    @Override
    protected void onPause() {
        super.onPause();
        overridePendingTransition(R.anim.page_in,
                R.anim.page_out);

    }
}
