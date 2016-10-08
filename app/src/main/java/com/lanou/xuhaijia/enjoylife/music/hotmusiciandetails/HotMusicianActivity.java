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
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.lanou.xuhaijia.enjoylife.R;
import com.lanou.xuhaijia.enjoylife.base.BaseActivity;
import com.lanou.xuhaijia.enjoylife.base.NetTool;
import com.lanou.xuhaijia.enjoylife.base.UrlValues;
import com.lanou.xuhaijia.enjoylife.myself.LoginActivity;
import com.lanou.xuhaijia.enjoylife.tools.DBTool;

import java.io.File;
import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.listener.UpdateListener;

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
    private BmobUser bmobUser;
    private Musician musician;

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


    }

    @Override
    protected void onResume() {
        super.onResume();
        bmobUser = BmobUser.getCurrentUser();
        musician = new Musician();
        if (bmobUser != null) {
            DBTool.getInstance().queryMusicianBy(musician.getClass(), bmobUser.getUsername(), id, new DBTool.QueryComplete<List<Musician>>() {
                @Override
                public void onCompleted(List<Musician> musicien) {
                    if (musicien.size() == 0) {
                        collectionIV.setImageResource(R.mipmap.care_white);
                    } else {
                        collectionIV.setImageResource(R.mipmap.care_red);
                        titleTv.setText(musicien.get(0).getName());
                        nameTv.setText(musicien.get(0).getName());
                        styleTv.setText(musicien.get(0).getStyle());
                        memberTv.setText(musicien.get(0).getMember());
                        careTv.setText(musicien.get(0).getCareCount() + "人关注");
                        Glide.with(HotMusicianActivity.this).load(musicien.get(0).getIcon()).into(iconIv);
                    }
                    getNetData();
                }

            });
        } else {
            getNetData();
        }
    }

    private void getNetData() {
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
                if (bmobUser != null) {
                    DBTool.getInstance().queryMusicianBy(musician.getClass(), bmobUser.getUsername(), id, new DBTool.QueryComplete<List<Musician>>() {
                        @Override
                        public void onCompleted(List<Musician> musicien) {
                           musician =   new Musician();
                            if (musicien.size() == 0) {
                                collectionIV.setImageResource(R.mipmap.care_red);
                                musician.setCareCount(bean.getFollower() + "");
                                musician.setIcon(bean.getPicture());
                                musician.setMember(bean.getMember());
                                musician.setStyle(bean.getStyle());
                                musician.setUserName(bmobUser.getUsername());
                                musician.setMusicianId(id);
                                musician.setName(bean.getName());
                                musician.setTime(System.currentTimeMillis());
                                DBTool.getInstance().insertData(musician);
                                musician.save(new SaveListener<String>() {
                                    @Override
                                    public void done(String s, BmobException e) {
                                        if (e == null) {
                                            Toast.makeText(HotMusicianActivity.this, "存入云端成功", Toast.LENGTH_SHORT).show();
                                        } else {
                                            Toast.makeText(HotMusicianActivity.this, "存入云端失败请检查网络", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });
                            } else {
                                collectionIV.setImageResource(R.mipmap.care_white);
                                DBTool.getInstance().deleteData(musicien.get(0));
                                BmobQuery<Musician> query = new BmobQuery<Musician>();
                                query.addWhereEqualTo("userName" , bmobUser.getUsername());
                                query.setLimit(50);
                                query.findObjects(new FindListener<Musician>() {
                                    @Override
                                    public void done(List<Musician> list, BmobException e) {
                                        if (e == null) {
                                            for (int i = 0; i < list.size() ; i++) {
                                                if (list.get(i).getMusicianId().equals(id)) {
                                                    Musician mMusician = new Musician();
                                                    mMusician.setObjectId(list.get(i).getObjectId());
                                                    mMusician.delete(new UpdateListener() {
                                                        @Override
                                                        public void done(BmobException e) {
                                                            if (e == null) {
                                                                Log.d("HotMusicianActivity", "删除云端成功");
                                                            }

                                                        }
                                                    });
                                                }
                                            }
                                        }
                                    }
                                });
                            }
                        }


                    });

                } else {
                    Intent intent = new Intent(HotMusicianActivity.this , LoginActivity.class);
                    startActivity(intent);
                }


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
