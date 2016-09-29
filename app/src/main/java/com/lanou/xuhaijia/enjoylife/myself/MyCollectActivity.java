package com.lanou.xuhaijia.enjoylife.myself;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import com.lanou.xuhaijia.enjoylife.R;
import com.lanou.xuhaijia.enjoylife.base.BaseActivity;

/**
 * Created by 国冰冰 on 16/9/22.
 */
public class MyCollectActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener {
    private RadioGroup radioGroup;
    private FrameLayout frameLayout;

    @Override
    protected int setLayout() {
        return R.layout.activity_myself_collect;
    }

    @Override
    protected void initView() {
        radioGroup = bindView(R.id.fragment_myself_collectss);
        frameLayout = bindView(R.id.fragment_myself_collectlist);
        radioGroup.setOnCheckedChangeListener(this);

    }

    @Override
    protected void initData() {

    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        switch (i) {
            case R.id.fragment_myself_classic_collect://经典
                fragmentTransaction.replace(R.id.fragment_myself_collectlist,new CollectClass());
                break;
            case R.id.fragment_myself_musician_collect://音乐
                fragmentTransaction.replace(R.id.fragment_myself_collectlist,new CollectMusican());
                break;
            case R.id.fragment_myself_content_collect://文章
                fragmentTransaction.replace(R.id.fragment_myself_collectlist,new CollectContent());
                break;
        }
        fragmentTransaction.commit();
    }




}
