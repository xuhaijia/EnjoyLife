package com.lanou.xuhaijia.enjoylife.news.headline;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
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
import com.lanou.xuhaijia.enjoylife.tools.CommonAdapter;
import com.lanou.xuhaijia.enjoylife.tools.CommonViewHolder;

import java.util.ArrayList;

/**
 * Created by 国冰冰 on 16/9/13.
 */
public class HeadlinesFragment extends BaseFragment {
    private int mySize;
    private MySwipeRefreshLayout mySwipeRefreshLayout;
    private ProgressDialog progressDialog;
    private ListView mListView;
    String url;
    private ImageView imageView;
    private CommonAdapter<HeanLineBean.T1348647909107Bean> commonAdapter;
    private View headView;

    @Override
    protected int setLayout() {
        return R.layout.fragment_news_headlines;
    }

    @Override
    protected void initView() {
        mListView = bindView(R.id.fragment_news_heanline_lv);
        mySwipeRefreshLayout = bindView(R.id.fragment_news_refrshlayout);
        progressDialog = new ProgressDialog(getContext());
        progressDialog.setCancelable(true);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.show();
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_news_progress, null);
        imageView = (ImageView) view.findViewById(R.id.news_progress_img);
        AnimationDrawable animationDrawable = (AnimationDrawable) imageView.getBackground();
        animationDrawable.start();
        progressDialog.setContentView(view);
        myHeadView();
        initReli();
        Load();
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
                mListView.removeHeaderView(headView);
                mySize++;
                mNetTool.getData(UrlValues.NEWS_HEADLINE2 + (mySize * 20) + UrlValues.NEWS_HEADLINE_FRONT, HeanLineBean.class, new NetTool.NetInterface<HeanLineBean>() {
                    @Override
                    public void onSuccess(final HeanLineBean heanLineBean) {
                        final ArrayList<HeanLineBean.T1348647909107Bean> arrayList = new ArrayList<HeanLineBean.T1348647909107Bean>();
                        for (int i = 0; i < heanLineBean.getT1348647909107().size(); i++) {
                            arrayList.add(heanLineBean.getT1348647909107().get(i));
                        }
                        commonAdapter = new CommonAdapter<HeanLineBean.T1348647909107Bean>(arrayList, mContext, R.layout.item_news_headline) {
                            @Override
                            public void setData(final HeanLineBean.T1348647909107Bean t1348647909107Bean
                                    , CommonViewHolder viewHolder, int position) {
                                viewHolder.setText(R.id.item_news_headline_tv, t1348647909107Bean.getTitle());
                                viewHolder.setImage(R.id.item_news_headline_img, t1348647909107Bean.getImgsrc(), getContext());
                                viewHolder.setText(R.id.item_news_headline_source, t1348647909107Bean.getSource());
                                viewHolder.setText(R.id.item_news_headline_replycont, t1348647909107Bean.getReplyCount() + "人跟帖");
                            }
                        };
                        mListView.setAdapter(commonAdapter);
                        //item 点击事件
                        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                if ("photoset".equals(heanLineBean.getT1348647909107().get(i).getSkipType())) {
                                    //图片
                                    String head = UrlValues.NEWS_FRONT;
                                    String Pos = i + "";
                                    String a = heanLineBean.getT1348647909107().get(i).getSkipID();
                                    String setid = a.substring(9, a.length());
                                    String cannilt = a.substring(4, 8);
                                    String photoUrl = head + Pos + UrlValues.NEWS_between + setid + UrlValues.NEWS_BEHIND + cannilt;

                                    url = photoUrl;
                                } else {
                                    //如果是文字 的话
                                    url = heanLineBean.getT1348647909107().get(i).getUrl_3w();

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

    //取消 progressdoaloging
    private void dismissDialog() {
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
    }

    //头饰图
    private void myHeadView() {
        mNetTool.getData(UrlValues.NEWS_HEADLINE, HeanLineBean.class, new NetTool.NetInterface<HeanLineBean>() {
            @Override
            public void onSuccess(HeanLineBean heanLineBean) {
                headView = LayoutInflater.from(getContext()).inflate(R.layout.news_headview, null);
                ImageView mImageView = (ImageView) headView.findViewById(R.id.news_headview_img);
                TextView mTextView = (TextView) headView.findViewById(R.id.news_headview_tv);
                if (heanLineBean != null) {
                    mTextView.setText(heanLineBean.getT1348647909107().get(0).getTitle());
                    Glide.with(getContext()).load(heanLineBean.getT1348647909107().get(0).getImgsrc()).into(mImageView);
                    mListView.addHeaderView(headView);
                }
            }

            @Override
            public void onError(String errorMsg) {

            }
        });

    }

    @Override
    protected void initData() {

        mNetTool.getData(UrlValues.NEWS_HEADLINE, HeanLineBean.class, new NetTool.NetInterface<HeanLineBean>() {
            @Override
            public void onSuccess(final HeanLineBean heanLineBean) {
                dismissDialog();
                mySwipeRefreshLayout.setRefreshing(false);
                final ArrayList<HeanLineBean.T1348647909107Bean> arrayList = new ArrayList<HeanLineBean.T1348647909107Bean>();
                for (int i = 1; i < heanLineBean.getT1348647909107().size(); i++) {
                    arrayList.add(heanLineBean.getT1348647909107().get(i));
                }
                commonAdapter = new CommonAdapter<HeanLineBean.T1348647909107Bean>(arrayList, mContext, R.layout.item_news_headline) {
                    @Override
                    public void setData(final HeanLineBean.T1348647909107Bean t1348647909107Bean
                            , CommonViewHolder viewHolder, int position) {
                        viewHolder.setText(R.id.item_news_headline_tv, t1348647909107Bean.getTitle());
                        viewHolder.setImage(R.id.item_news_headline_img, t1348647909107Bean.getImgsrc(), getContext());
                        viewHolder.setText(R.id.item_news_headline_source, t1348647909107Bean.getSource());
                        viewHolder.setText(R.id.item_news_headline_replycont, t1348647909107Bean.getReplyCount() + "人跟帖");
                    }
                };
                mListView.setAdapter(commonAdapter);


                //item 点击事件
                mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        if (i != 0) {

                            if ("photoset".equals(heanLineBean.getT1348647909107().get(i).getSkipType())) {

                                //图片
                                String head = UrlValues.NEWS_FRONT;
                                String Pos = i + "";
                                String a = heanLineBean.getT1348647909107().get(i).getSkipID();
                                String setid = a.substring(9, a.length());
                                String cannilt = a.substring(4, 8);
                                String photoUrl = head + Pos + UrlValues.NEWS_between + setid + UrlValues.NEWS_BEHIND + cannilt;

                                url = photoUrl;
                            } else {
                                //如果是文字 的话
                                url = heanLineBean.getT1348647909107().get(i).getUrl_3w();

                            }

                        } else if (i == 0) {

                            //头饰图
                            String head = UrlValues.NEWS_FRONT;
                            String Pos = i + "";
                            String a = heanLineBean.getT1348647909107().get(i).getSkipID();
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
            }

            @Override
            public void onError(String errorMsg) {

            }
        });

    }


}