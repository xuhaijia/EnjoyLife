package com.lanou.xuhaijia.enjoylife.news.recreation;

import android.content.Intent;
import android.util.Log;
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
public class RecreationFragment extends BaseFragment {
    private String url;
    private ListView mListView;

    @Override
    protected int setLayout() {
        return R.layout.fragment_recraction;
    }

    @Override
    protected void initView() {
        mListView = bindView(R.id.fragment_news_recraction_lv);
    }

    @Override
    protected void initData() {
        mNetTool.getData(UrlValues.NEWS_RECREATION, RecreationBean.class, new NetTool.NetInterface<RecreationBean>() {
            @Override
            public void onSuccess(final RecreationBean recreationBean) {
                View view = LayoutInflater.from(getContext()).inflate(R.layout.news_headview, null);
                TextView mTextView = (TextView) view.findViewById(R.id.news_headview_tv);
                ImageView mImageView = (ImageView) view.findViewById(R.id.news_headview_img);
                mTextView.setText(recreationBean.getT1348648517839().get(0).getTitle());
                Glide.with(getContext()).load(recreationBean.getT1348648517839().get(0).getImgsrc()).into(mImageView);
                mListView.addHeaderView(view);
                ArrayList<RecreationBean.T1348648517839Bean> arrayList = new ArrayList<RecreationBean.T1348648517839Bean>();
                for (int i = 1; i < recreationBean.getT1348648517839().size(); i++) {
                    arrayList.add(recreationBean.getT1348648517839().get(i));
                }
                mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        if (i != 0) {

                            if ("photoset".equals(recreationBean.getT1348648517839().get(i).getSkipType())) {

                                Log.e("HeadlinesFragment", "图片  1");
                                String head = UrlValues.NEWS_FRONT;
                                String Pos = i + "";
                                Log.d("HeadlinesFragment", recreationBean.getT1348648517839().get(i).getSkipID() + "拼接");
                                String a = recreationBean.getT1348648517839().get(i).getSkipID();
                                String setid = a.substring(9,a.length());
                                String cannilt = a.substring(4,8);
                                String photoUrl = head + Pos + UrlValues.NEWS_between + setid + UrlValues.NEWS_BEHIND + cannilt;

                                url = photoUrl;
                            } else {
                                Log.d("HeadlinesFragment", "文字" + "2");
                                Log.d("HeadlinesFragment",recreationBean.getT1348648517839().get(i).getUrl() + "网址");
                                url = recreationBean.getT1348648517839().get(i).getUrl_3w();

                            }

                        }else if (i == 0){

                            String head = UrlValues.NEWS_FRONT;
                            String Pos = i + "";
                            String a = recreationBean.getT1348648517839().get(i).getSkipID();
                            String setid = a.substring(9,a.length());
                            String cannilt = a.substring(4,8);
                            String photoUrl = head + Pos + UrlValues.NEWS_between + setid + UrlValues.NEWS_BEHIND + cannilt;
                            url = photoUrl;
                        }
                        Intent intent = new Intent(getContext(), HeadLinesContentActivity.class);
                        intent.putExtra("headline", url);
                        startActivity(intent);

                    }
                });
                    mListView.setAdapter(new CommonAdapter<RecreationBean.T1348648517839Bean>(arrayList, mContext, R.layout.item_news_sport) {
                        @Override
                        public void setData(RecreationBean.T1348648517839Bean t1348648517839Bean, CommonViewHolder viewHolder) {
                            viewHolder.setText(R.id.item_news_sport_tv, t1348648517839Bean.getTitle());
                            viewHolder.setText(R.id.item_news_sport_source, t1348648517839Bean.getSource());
                            viewHolder.setText(R.id.item_news_sport_replycont, t1348648517839Bean.getReplyCount() + "人跟帖");
                            viewHolder.setImage(R.id.item_news_sport_img, t1348648517839Bean.getImgsrc(), getContext());
                        }
                    });

            }

            @Override
            public void onError(String errorMsg) {

            }
        });
    }
}
