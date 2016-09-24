package com.lanou.xuhaijia.enjoylife.tools;

import android.os.Handler;
import android.os.Message;

import xuhaijia.lanou3g.autohome.base.BaseFragment;
import xuhaijia.lanou3g.autohome.recommend.newest.NewestFragment;

public class MyListener implements PullToRefreshLayout.OnRefreshListener {
    NewestFragment newestFragment;
    BaseFragment baseFragment;

    public MyListener(BaseFragment baseFragment) {
        this.baseFragment = baseFragment;
    }

    public void setNewestFragment(NewestFragment newestFragment) {
        this.newestFragment = newestFragment;
    }

    @Override
    public void onRefresh(final PullToRefreshLayout pullToRefreshLayout) {
        // 下拉刷新操作
        new Handler() {
            @Override
            public void handleMessage(Message msg) {
                // 千万别忘了告诉控件刷新完毕了哦！
                pullToRefreshLayout.refreshFinish(PullToRefreshLayout.SUCCEED);
            }
        }.sendEmptyMessageDelayed(0, 1000);
        baseFragment.refresh();
    }

    @Override
    public void onLoadMore(final PullToRefreshLayout pullToRefreshLayout) {
        // 加载操作
        new Handler() {
            @Override
            public void handleMessage(Message msg) {
                // 千万别忘了告诉控件加载完毕了哦！
                pullToRefreshLayout.loadmoreFinish(PullToRefreshLayout.SUCCEED);
            }
        }.sendEmptyMessageDelayed(0, 1000);
        baseFragment.load();
    }


}
