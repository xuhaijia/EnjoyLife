package com.lanou.xuhaijia.enjoylife.news.sport;

import android.widget.ListView;

import com.lanou.xuhaijia.enjoylife.R;
import com.lanou.xuhaijia.enjoylife.base.BaseFragment;
import com.lanou.xuhaijia.enjoylife.base.NetTool;
import com.lanou.xuhaijia.enjoylife.base.UrlValues;
import com.lanou.xuhaijia.enjoylife.news.headline.HeanLineBean;
import com.lanou.xuhaijia.enjoylife.tools.CommonAdapter;
import com.lanou.xuhaijia.enjoylife.tools.CommonViewHolder;

import java.util.ArrayList;

/**
 * Created by 国冰冰 on 16/9/13.
 */
public class SportsFragment extends BaseFragment {
    private ListView mListView;
    @Override
    protected int setLayout() {
        return R.layout.fragment_sports;
    }

    @Override
    protected void initView() {
       mListView = bindView(R.id.fragment_news_sport_lv);

    }

    @Override
    protected void initData() {
        mNetTool.getData(UrlValues.NEWS_PE, SportsBean.class, new NetTool.NetInterface<SportsBean>() {
            @Override
            public void onSuccess(final SportsBean sportsBean) {

                ArrayList<SportsBean.T1348649079062Bean> beanArrayList = new ArrayList<SportsBean.T1348649079062Bean>();
                for (int i = 0; i < sportsBean.getT1348649079062().size(); i++) {
                    beanArrayList.add(sportsBean.getT1348649079062().get(i));
                }
                mListView.setAdapter(new CommonAdapter<SportsBean.T1348649079062Bean>(beanArrayList,getContext(),R.layout.item_news_sport) {
                    @Override
                    public void setData(SportsBean.T1348649079062Bean t1348649079062Bean, CommonViewHolder viewHolder) {
                        viewHolder.setText(R.id.item_news_sport_tv,t1348649079062Bean.getTitle());
                        viewHolder.setImage(R.id.item_news_sport_img,t1348649079062Bean.getImgsrc(),getContext());
                        viewHolder.setText(R.id.item_news_sport_source,t1348649079062Bean.getSource());
                        viewHolder.setText(R.id.item_news_sport_replycont,t1348649079062Bean.getReplyCount() +"人跟帖");
                    }
                });
            }

            @Override
            public void onError(String errorMsg) {

            }
        });
    }
}
