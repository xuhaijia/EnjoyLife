package com.lanou.xuhaijia.enjoylife.music.typesearch;

import android.support.v4.app.Fragment;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.lanou.xuhaijia.enjoylife.R;
import com.lanou.xuhaijia.enjoylife.base.BaseFragment;

/**
 * Created by 徐海佳 on 16/9/13.
 */
public class TypeSearchFragment extends BaseFragment {

    private ListView lv;

    @Override
    protected int setLayout() {
        return R.layout.fragment_typesearch;
    }

    @Override
    protected void initView() {
        lv = bindView(R.id.fragment_typesearch_lv);
        TextView genreTv = bindView(R.id.fragment_typesearch_genre);
        ImageView searchIv = bindView(R.id.fragment_typesearch_search);
        TextView titleTv = bindView(R.id.fragment_typesearch_title);

    }

    @Override
    protected void initData() {

    }
}
