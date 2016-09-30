package com.lanou.xuhaijia.enjoylife.news.sport;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.lanou.xuhaijia.enjoylife.R;
import com.lanou.xuhaijia.enjoylife.base.BaseFragment;
import com.lanou.xuhaijia.enjoylife.base.NetTool;
import com.lanou.xuhaijia.enjoylife.base.UrlValues;
import com.lanou.xuhaijia.enjoylife.news.MySwipeRefreshLayout;
import com.lanou.xuhaijia.enjoylife.news.headline.HeadLinesContentActivity;
import com.lanou.xuhaijia.enjoylife.tools.CommonAdapter;
import com.lanou.xuhaijia.enjoylife.tools.CommonViewHolder;

import java.util.ArrayList;

/**
 * Created by 国冰冰 on 16/9/13.
 */
public class SportsFragment extends BaseFragment {
    private View view;
    private int mySize;
    private MySwipeRefreshLayout mySwipeRefreshLayout;
    private ListView mListView;
    String url;
    private CommonAdapter<SportsBean.T1348649079062Bean> commonAdapter;
    private TextView mTextView;
    private ImageView mImageView;

    @Override
    protected int setLayout() {
        return R.layout.fragment_news_sports;
    }

    @Override
    protected void initView() {
        mListView = bindView(R.id.fragment_news_sport_lv);
        mySwipeRefreshLayout = bindView(R.id.fragment_sport_swipe);
        view = LayoutInflater.from(getContext()).inflate(R.layout.news_headview, null);
        mTextView = (TextView) view.findViewById(R.id.news_headview_tv);
        mImageView = (ImageView) view.findViewById(R.id.news_headview_img);
        showHeadView();
        initReli();
        Load();

    }
    private void initReli() {
        mySwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mListView.setAdapter(null);
                mySwipeRefreshLayout.setRefreshing(false);
                initData();
            }
        });
    }

    private void Load() {
        mySwipeRefreshLayout.setOnLoadListener(new MySwipeRefreshLayout.OnLoadListener() {
            @Override
            public void onLoad() {
                mySize++;
                mNetTool.getData(UrlValues.NEWS_PE2 + (mySize * 20) + UrlValues.NEWS_HEADLINE_FRONT, SportsBean.class, new NetTool.NetInterface<SportsBean>() {
                    @Override
                    public void onSuccess(final SportsBean sportsBean) {

                        mListView.removeHeaderView(view);
                        final ArrayList<SportsBean.T1348649079062Bean> arrayList = new ArrayList<SportsBean.T1348649079062Bean>();
                        for (int i = 0; i < sportsBean.getT1348649079062().size(); i++) {
                            arrayList.add(sportsBean.getT1348649079062().get(i));
                        }
                        commonAdapter = new CommonAdapter<SportsBean.T1348649079062Bean>(arrayList, getContext(), R.layout.item_news_sport) {
                            @Override
                            public void setData(SportsBean.T1348649079062Bean t1348649079062Bean, CommonViewHolder viewHolder
                                    , int position) {
                                viewHolder.setText(R.id.item_news_sport_tv, t1348649079062Bean.getTitle());
                                viewHolder.setImage(R.id.item_news_sport_img, t1348649079062Bean.getImgsrc(), getContext());
                                viewHolder.setText(R.id.item_news_sport_source, t1348649079062Bean.getSource());
                                viewHolder.setText(R.id.item_news_sport_replycont, t1348649079062Bean.getReplyCount() + "人跟帖");
                            }
                        };
                        mListView.setAdapter(commonAdapter);
                        //item 点击事件
                        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                                if ("photoset".equals(sportsBean.getT1348649079062().get(i).getSkipType())) {
                                    //图片
                                    String head = UrlValues.NEWS_FRONT;
                                    String Pos = i + "";
                                    String a = sportsBean.getT1348649079062().get(i).getSkipID();
                                    String setid = a.substring(9, a.length());
                                    String cannilt = a.substring(4, 8);
                                    String photoUrl = head + Pos + UrlValues.NEWS_between + setid + UrlValues.NEWS_BEHIND + cannilt;

                                    url = photoUrl;
                                } else {
                                    //如果是文字 的话
                                    url = sportsBean.getT1348649079062().get(i).getUrl_3w();

                                }

                                Intent intent = new Intent(getContext(), HeadLinesContentActivity.class);
                                intent.putExtra("headline", url);
                                startActivity(intent);

                            }
                        });
                        mySwipeRefreshLayout.setLoading(false);
                    }

                    @Override
                    public void onError(String errorMsg) {

                    }
                });

            }
        });
    }

    @Override
    protected void initData() {
        mNetTool.getData(UrlValues.NEWS_PE, SportsBean.class, new NetTool.NetInterface<SportsBean>() {
            @Override
            public void onSuccess(final SportsBean sportsBean) {
                if (sportsBean != null) {
                    ArrayList<SportsBean.T1348649079062Bean> beanArrayList = new ArrayList<SportsBean.T1348649079062Bean>();
                    for (int i = 1; i < sportsBean.getT1348649079062().size(); i++) {
                        beanArrayList.add(sportsBean.getT1348649079062().get(i));
                    }
                    mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                            if (i != 0) {
                                if ("photoset".equals(sportsBean.getT1348649079062().get(i).getSkipType())) {

                                    String head = UrlValues.NEWS_FRONT;
                                    String Pos = i + "";
                                    Log.d("HeadlinesFragment", sportsBean.getT1348649079062().get(i).getSkipID() + "拼接");
                                    String a = sportsBean.getT1348649079062().get(i).getSkipID();
                                    String setid = a.substring(9, a.length());
                                    String cannilt = a.substring(4, 8);
                                    String photoUrl = head + Pos + UrlValues.NEWS_between + setid + UrlValues.NEWS_BEHIND + cannilt;

                                    url = photoUrl;
                                } else {
                                    url = sportsBean.getT1348649079062().get(i).getUrl_3w();
                                }

                            } else if (i == 0) {
                                String head = UrlValues.NEWS_FRONT;
                                String Pos = i + "";
                                String a = sportsBean.getT1348649079062().get(i).getSkipID();
                                String setid = a.substring(9, a.length());
                                String cannilt = a.substring(4, 8);
                                String photoUrl = head + Pos + UrlValues.NEWS_between + setid + UrlValues.NEWS_BEHIND + cannilt;
                                url = photoUrl;
                            }
                            Intent intent = new Intent(getContext(), HeadLinesContentActivity.class);
                            intent.putExtra("headline", url);
                            startActivity(intent);


                        }
                    });
                    commonAdapter = new CommonAdapter<SportsBean.T1348649079062Bean>(beanArrayList, getContext(), R.layout.item_news_sport) {
                        @Override
                        public void setData(SportsBean.T1348649079062Bean t1348649079062Bean, CommonViewHolder viewHolder
                                , int position) {
                            viewHolder.setText(R.id.item_news_sport_tv, t1348649079062Bean.getTitle());
                            viewHolder.setImage(R.id.item_news_sport_img, t1348649079062Bean.getImgsrc(), getContext());
//                        Log.d("SportsFragment", t1348649079062Bean.getImgsrc());
                            viewHolder.setText(R.id.item_news_sport_source, t1348649079062Bean.getSource());
                            viewHolder.setText(R.id.item_news_sport_replycont, t1348649079062Bean.getReplyCount() + "人跟帖");
                        }
                    };
                    mListView.setAdapter(commonAdapter);
                }
            }
            @Override
            public void onError(String errorMsg) {

            }
        });

    }
    private void showHeadView() {
        mNetTool.getData(UrlValues.NEWS_PE, SportsBean.class, new NetTool.NetInterface<SportsBean>() {
            @Override
            public void onSuccess(SportsBean sportsBean) {
                if (sportsBean != null ) {
                    Glide.with(getContext()).load(sportsBean.getT1348649079062().get(0).getImgsrc()).into(mImageView);
                    mTextView.setText(sportsBean.getT1348649079062().get(0).getTitle());
                    mListView.addHeaderView(view);
                }
            }

            @Override
            public void onError(String errorMsg) {

            }
        });

    }
}
