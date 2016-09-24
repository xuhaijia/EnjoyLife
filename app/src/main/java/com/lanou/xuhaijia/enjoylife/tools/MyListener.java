package com.lanou.xuhaijia.enjoylife.tools;

import android.os.Handler;
import android.os.Message;

import com.lanou.xuhaijia.enjoylife.welfare.WelfareFragment;

public class MyListener implements PullToRefreshLayout.OnRefreshListener {

    WelfareFragment welfareFragment;

    public MyListener(WelfareFragment welfareFragment) {
        this.welfareFragment = welfareFragment;
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
        welfareFragment.refresh();
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
        welfareFragment.loadMore();

    }


}
