package com.lanou.xuhaijia.enjoylife.news;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.design.widget.TabLayout;

import com.lanou.xuhaijia.enjoylife.R;
import com.lanou.xuhaijia.enjoylife.base.BaseFragment;
import com.lanou.xuhaijia.enjoylife.news.delicecyfood.DelicacyFoodFragment;
import com.lanou.xuhaijia.enjoylife.news.headline.HeadlinesFragment;
import com.lanou.xuhaijia.enjoylife.news.sport.SportsFragment;
import com.lanou.xuhaijia.enjoylife.news.recreation.RecreationFragment;

import java.util.ArrayList;

/**
 * Created by 徐海佳 on 16/9/13.
 */
public class NewsFragment extends BaseFragment {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private NewsMainAdapter newsMainAdapter;

    @Override
    protected int setLayout() {
        return R.layout.fragment_news;
    }

    @Override
    protected void initView() {
       tabLayout = bindView(R.id.fragment_news_tablelayout);
        viewPager = bindView(R.id.fragment_news_viewpager);
        newsMainAdapter = new NewsMainAdapter(getChildFragmentManager());
        ArrayList<Fragment> fragmentArrayList = new ArrayList<>();
        fragmentArrayList.add(new HeadlinesFragment());//头条
        fragmentArrayList.add(new SportsFragment());//体育
        fragmentArrayList.add(new RecreationFragment());//娱乐
        fragmentArrayList.add(new DelicacyFoodFragment());
        newsMainAdapter.setFreagments(fragmentArrayList);
        viewPager.setAdapter(newsMainAdapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setSelectedTabIndicatorColor(Color.RED);
        tabLayout.setTabTextColors(Color.GRAY,Color.RED);




    }

    @Override
    protected void initData() {

    }
}
