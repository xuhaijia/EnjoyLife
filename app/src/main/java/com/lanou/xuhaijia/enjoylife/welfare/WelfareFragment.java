package com.lanou.xuhaijia.enjoylife.welfare;


import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.lanou.xuhaijia.enjoylife.R;
import com.lanou.xuhaijia.enjoylife.base.BaseFragment;
import com.lanou.xuhaijia.enjoylife.base.NetTool;
import com.lanou.xuhaijia.enjoylife.base.UrlValues;
import com.lanou.xuhaijia.enjoylife.tools.MyListener;
import com.lanou.xuhaijia.enjoylife.tools.PullToRefreshLayout;


/**
 * Created by 徐海佳 on 16/9/13.
 */
public class WelfareFragment extends BaseFragment  {


    private ListView pLv;
    private PullToRefreshLayout pullToRefreshLayout;
    private int count = 20;
    private WelfareAdapter welfareAdapter;


    @Override
    protected int setLayout() {
        return R.layout.fragment_welfare;
    }

    @Override
    protected void initView() {
        pullToRefreshLayout = bindView(R.id.item_welfare_ptrl);
        MyListener myListener = new MyListener(this);
        pullToRefreshLayout.setOnRefreshListener(myListener);
        pLv = bindView(R.id.fragment_welfare_plv);

    }

    @Override
    protected void initData() {
        welfareAdapter = new WelfareAdapter(getContext());
        getData(count);
    }


    private void getData(int count) {
        mNetTool.getData(UrlValues.WELFARE_START_URL + count + UrlValues.WELFARE_END_URL,
                WelfareBean.class, new NetTool.NetInterface<WelfareBean>() {
                    @Override
                    public void onSuccess(final WelfareBean welfareBean) {
                        welfareAdapter.setWelfareBean(welfareBean);
                        pLv.setAdapter(welfareAdapter);
                        pLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                            }
                        });
                    }

                    @Override
                    public void onError(String errorMsg) {

                    }
                });
    }


    public void refresh() {
        getData(count);
    }

    int i = 1;
    public void loadMore() {
        int a = count;
        i++;
        mNetTool.getData(UrlValues.WELFARE_START_URL + a * i + UrlValues.WELFARE_END_URL, WelfareBean.class, new NetTool.NetInterface<WelfareBean>() {
            @Override
            public void onSuccess(WelfareBean welfareBean) {
                welfareAdapter.setWelfareBean(welfareBean);
            }

            @Override
            public void onError(String errorMsg) {

            }
        });
    }
}
