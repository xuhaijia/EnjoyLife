package com.lanou.xuhaijia.enjoylife.news;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.design.widget.TabLayout;

import com.lanou.xuhaijia.enjoylife.R;
import com.lanou.xuhaijia.enjoylife.base.BaseFragment;
import com.lanou.xuhaijia.enjoylife.news.NewsAdapter.NewsMainAdapter;
import com.lanou.xuhaijia.enjoylife.news.fragment.BeautyArticleFragment;
import com.lanou.xuhaijia.enjoylife.news.fragment.HardlinesFragment;
import com.lanou.xuhaijia.enjoylife.news.fragment.SportsFragment;
import com.lanou.xuhaijia.enjoylife.news.fragment.recreationFragment;

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
        fragmentArrayList.add(new HardlinesFragment());//头条
        fragmentArrayList.add(new SportsFragment());//体育
        fragmentArrayList.add(new recreationFragment());//娱乐
        fragmentArrayList.add(new BeautyArticleFragment());
        newsMainAdapter.setFreagments(fragmentArrayList);
        viewPager.setAdapter(newsMainAdapter);
        tabLayout.setupWithViewPager(viewPager);




    }

    @Override
    protected void initData() {

    }
}
