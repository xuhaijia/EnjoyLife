package com.lanou.xuhaijia.enjoylife.news.recreation;

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
public class RecreationFragment extends BaseFragment {
    private MySwipeRefreshLayout mySwipeRefreshLayout;
    private int mySize;
    private String url;
    private ListView mListView;
    private CommonAdapter<RecreationBean.T1348648517839Bean> commonAdapter;
    private View view;

    @Override
    protected int setLayout() {
        return R.layout.fragment_news_recraction;
    }

    @Override
    protected void initView() {
        mListView = bindView(R.id.fragment_news_recraction_lv);
        mySwipeRefreshLayout = bindView(R.id.fragment_news_recraction_seiprelayout);
        Load();
        initReli();
    }

    //下来刷新
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
                mNetTool.getData(UrlValues.NEWS_RECREATION2 + (mySize * 20) + UrlValues.NEWS_HEADLINE_FRONT, RecreationBean.class, new NetTool.NetInterface<RecreationBean>() {
                    @Override
                    public void onSuccess(final RecreationBean recreationBean) {

                        final ArrayList<RecreationBean.T1348648517839Bean> arrayList = new ArrayList<RecreationBean.T1348648517839Bean>();
                        for (int i = 0; i < recreationBean.getT1348648517839().size(); i++) {
                            arrayList.add(recreationBean.getT1348648517839().get(i));
                        }
                        commonAdapter = new CommonAdapter<RecreationBean.T1348648517839Bean>(arrayList, mContext, R.layout.item_news_headline) {
                            @Override
                            public void setData(final RecreationBean.T1348648517839Bean t1348648517839Bean
                                    , CommonViewHolder viewHolder, int position) {
                                viewHolder.setText(R.id.item_news_headline_tv, t1348648517839Bean.getTitle());
                                viewHolder.setImage(R.id.item_news_headline_img, t1348648517839Bean.getImgsrc(), getContext());
                                viewHolder.setText(R.id.item_news_headline_source, t1348648517839Bean.getSource());
                                viewHolder.setText(R.id.item_news_headline_replycont, t1348648517839Bean.getReplyCount() + "人跟帖");
                            }
                        };
                        Toast.makeText(mContext, "加载成功", Toast.LENGTH_SHORT).show();
                        //item 点击事件
                        mListView.setAdapter(commonAdapter);
                        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                                if ("photoset".equals(recreationBean.getT1348648517839().get(i).getSkipType())) {
                                    //图片
                                    String head = UrlValues.NEWS_FRONT;
                                    String Pos = i + "";
                                    String a = recreationBean.getT1348648517839().get(i).getSkipID();
                                    String setid = a.substring(9, a.length());
                                    String cannilt = a.substring(4, 8);
                                    String photoUrl = head + Pos + UrlValues.NEWS_between + setid + UrlValues.NEWS_BEHIND + cannilt;
                                    url = photoUrl;
                                } else {
                                    //如果是文字 的话
                                    url = recreationBean.getT1348648517839().get(i).getUrl_3w();
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
        mNetTool.getData(UrlValues.NEWS_RECREATION, RecreationBean.class, new NetTool.NetInterface<RecreationBean>() {
            @Override
            public void onSuccess(final RecreationBean recreationBean) {
                if (recreationBean != null) {
                    ArrayList<RecreationBean.T1348648517839Bean> arrayList = new ArrayList<RecreationBean.T1348648517839Bean>();
                    for (int i = 0; i < recreationBean.getT1348648517839().size(); i++) {
                        arrayList.add(recreationBean.getT1348648517839().get(i));
                    }
                    mySwipeRefreshLayout.setRefreshing(false);
                    mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                            if (i != 0) {

                                if ("photoset".equals(recreationBean.getT1348648517839().get(i).getSkipType())) {
                                    String head = UrlValues.NEWS_FRONT;
                                    String Pos = i + "";
                                    String a = recreationBean.getT1348648517839().get(i).getSkipID();
                                    String setid = a.substring(9, a.length());
                                    String cannilt = a.substring(4, 8);
                                    String photoUrl = head + Pos + UrlValues.NEWS_between + setid + UrlValues.NEWS_BEHIND + cannilt;

                                    url = photoUrl;
                                } else {
                                    url = recreationBean.getT1348648517839().get(i).getUrl_3w();

                                }

                            } else if (i == 0) {
                                if (recreationBean.getT1348648517839().get(0).getSkipID() != null && recreationBean.getT1348648517839().get(0).getSkipID().length() > 9) {
                                    String head = UrlValues.NEWS_FRONT;
                                    String Pos = i + "";
                                    String a = recreationBean.getT1348648517839().get(0).getSkipID();
                                    String setid = a.substring(9, a.length());
                                    String cannilt = a.substring(4, 8);
                                    String photoUrl = head + Pos + UrlValues.NEWS_between + setid + UrlValues.NEWS_BEHIND + cannilt;
                                    url = photoUrl;

                                } else {
                                    url = recreationBean.getT1348648517839().get(0).getUrl_3w();
                                }
                            }
                            Intent intent = new Intent(getContext(), HeadLinesContentActivity.class);
                            intent.putExtra("headline", url);
                            startActivity(intent);

                        }
                    });

                    mListView.setAdapter(new CommonAdapter<RecreationBean.T1348648517839Bean>(arrayList, mContext, R.layout.item_news_sport) {
                        @Override
                        public void setData(RecreationBean.T1348648517839Bean t1348648517839Bean
                                , CommonViewHolder viewHolder, int position) {
                            viewHolder.setText(R.id.item_news_sport_tv, t1348648517839Bean.getTitle());
                            viewHolder.setText(R.id.item_news_sport_source, t1348648517839Bean.getSource());
                            viewHolder.setText(R.id.item_news_sport_replycont, t1348648517839Bean.getReplyCount() + "人跟帖");
                            viewHolder.setImage(R.id.item_news_sport_img, t1348648517839Bean.getImgsrc(), getContext());
                        }
                    });

                    commonAdapter = new CommonAdapter<RecreationBean.T1348648517839Bean>(arrayList, mContext, R.layout.item_news_sport) {
                        @Override
                        public void setData(RecreationBean.T1348648517839Bean t1348648517839Bean
                                , CommonViewHolder viewHolder, int position) {
                            viewHolder.setText(R.id.item_news_sport_tv, t1348648517839Bean.getTitle());
                            viewHolder.setText(R.id.item_news_sport_source, t1348648517839Bean.getSource());
                            viewHolder.setText(R.id.item_news_sport_replycont, t1348648517839Bean.getReplyCount() + "人跟帖");
                            viewHolder.setImage(R.id.item_news_sport_img, t1348648517839Bean.getImgsrc(), getContext());
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



}
