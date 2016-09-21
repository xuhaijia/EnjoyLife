package com.lanou.xuhaijia.enjoylife.news.sport;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lanou.xuhaijia.enjoylife.R;
import com.lanou.xuhaijia.enjoylife.base.BaseFragment;
import com.lanou.xuhaijia.enjoylife.base.NetTool;
import com.lanou.xuhaijia.enjoylife.base.UrlValues;
import com.lanou.xuhaijia.enjoylife.news.headline.HeadLinesContentActivity;
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
                View view = LayoutInflater.from(getContext()).inflate(R.layout.news_headview, null);
                TextView mTextView = (TextView) view.findViewById(R.id.news_headview_tv);
                ImageView mImageView = (ImageView) view.findViewById(R.id.news_headview_img);
                Glide.with(getContext()).load(sportsBean.getT1348649079062().get(0).getImgsrc()).into(mImageView);
                mTextView.setText(sportsBean.getT1348649079062().get(0).getTitle());
                mListView.addHeaderView(view);
                ArrayList<SportsBean.T1348649079062Bean> beanArrayList = new ArrayList<SportsBean.T1348649079062Bean>();
                for (int i = 1; i < sportsBean.getT1348649079062().size(); i++) {
                    beanArrayList.add(sportsBean.getT1348649079062().get(i));
                }
                mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        if (i != 0) {
                            String url = sportsBean.getT1348649079062().get(i).getUrl_3w();
                            Intent intent = new Intent(getContext(), HeadLinesContentActivity.class);
                            intent.putExtra("headline", url);
                            startActivity(intent);
                        }
                    }
                });
                mListView.setAdapter(new CommonAdapter<SportsBean.T1348649079062Bean>(beanArrayList, getContext(), R.layout.item_news_sport) {
                    @Override
                    public void setData(SportsBean.T1348649079062Bean t1348649079062Bean, CommonViewHolder viewHolder
                            , int position) {
                        viewHolder.setText(R.id.item_news_sport_tv, t1348649079062Bean.getTitle());
                        viewHolder.setImage(R.id.item_news_sport_img, t1348649079062Bean.getImgsrc(), getContext());
                        viewHolder.setText(R.id.item_news_sport_source, t1348649079062Bean.getSource());
                        viewHolder.setText(R.id.item_news_sport_replycont, t1348649079062Bean.getReplyCount() + "人跟帖");
                    }
                });
            }

            @Override
            public void onError(String errorMsg) {

            }
        });
    }
}
