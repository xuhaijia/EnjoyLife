package com.lanou.xuhaijia.enjoylife.music.hotsingle;

import android.support.v4.app.Fragment;
import android.widget.ListView;

import com.lanou.xuhaijia.enjoylife.R;
import com.lanou.xuhaijia.enjoylife.base.BaseFragment;

/**
 * Created by 徐海佳 on 16/9/13.
 */
public class HotSingleFragment extends BaseFragment {

    private ListView hotSingleLv;

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

    }
}
