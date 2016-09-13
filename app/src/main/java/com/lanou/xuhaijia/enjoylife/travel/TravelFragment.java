package com.lanou.xuhaijia.enjoylife.travel;

import android.content.Intent;
import android.view.View;
import android.widget.RelativeLayout;

import com.lanou.xuhaijia.enjoylife.R;
import com.lanou.xuhaijia.enjoylife.base.BaseFragment;
import com.lanou.xuhaijia.enjoylife.travel.search.TravelSearchAty;


/**
 * Created by 徐海佳 on 16/9/13.
 */
public class TravelFragment extends BaseFragment implements View.OnClickListener {
    @Override
    protected int setLayout() {
        return R.layout.fragment_travel;
    }

    @Override
    protected void initView() {

        //搜索框
        RelativeLayout rlatSearch = bindView(R.id.travel_fragment_relative_search);


        //搜索框的点击事件
        rlatSearch.setOnClickListener(this);


    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.travel_fragment_relative_search:
                Intent intentSearch = new Intent(getActivity(), TravelSearchAty.class);

                startActivity(intentSearch);

                break;


        }
    }
}
