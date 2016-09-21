package com.lanou.xuhaijia.enjoylife.news.headline;

import android.content.Intent;
import android.os.Bundle;
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
import com.lanou.xuhaijia.enjoylife.tools.CommonAdapter;
import com.lanou.xuhaijia.enjoylife.tools.CommonViewHolder;

import java.util.ArrayList;

/**
 * Created by 国冰冰 on 16/9/13.
 */
public class HeadlinesFragment extends BaseFragment {
    private ListView mListView;

    @Override
    protected int setLayout() {
        return R.layout.fragment_headlines;
    }

    @Override
    protected void initView() {
        mListView = bindView(R.id.fragment_news_heanline_lv);


    }

    @Override
    protected void initData() {

        mNetTool.getData(UrlValues.NEWS_HEADLINE, HeanLineBean.class, new NetTool.NetInterface<HeanLineBean>() {
            @Override
            public void onSuccess(final HeanLineBean heanLineBean) {
                View view = LayoutInflater.from(getContext()).inflate(R.layout.news_headview, null);
                ImageView mImageView = (ImageView) view.findViewById(R.id.news_headview_img);
                TextView mTextView = (TextView) view.findViewById(R.id.news_headview_tv);
                mTextView.setText(heanLineBean.getT1348647909107().get(0).getTitle());
                Glide.with(getContext()).load(heanLineBean.getT1348647909107().get(0).getImgsrc()).into(mImageView);
                mListView.addHeaderView(view);
                ArrayList<HeanLineBean.T1348647909107Bean> arrayList = new ArrayList<HeanLineBean.T1348647909107Bean>();
                for (int i = 1; i < heanLineBean.getT1348647909107().size() ; i++) {
                    arrayList.add(heanLineBean.getT1348647909107().get(i));
                }
                mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        if (i != 0) {
                            String url = heanLineBean.getT1348647909107().get(i).getUrl_3w();
                            Intent intent = new Intent(getContext(), HeadLinesContentActivity.class);
                            intent.putExtra("headline", url);
                            startActivity(intent);
                        }else {

                        }


                    }
                });

                mListView.setAdapter(new CommonAdapter<HeanLineBean.T1348647909107Bean>(arrayList, mContext, R.layout.item_news_headline) {
                    @Override
                    public void setData(final HeanLineBean.T1348647909107Bean t1348647909107Bean
                            , CommonViewHolder viewHolder, int position) {
                        viewHolder.setText(R.id.item_news_headline_tv, t1348647909107Bean.getTitle());
                        viewHolder.setImage(R.id.item_news_headline_img, t1348647909107Bean.getImgsrc(), getContext());
                        viewHolder.setText(R.id.item_news_headline_source, t1348647909107Bean.getSource());
                        viewHolder.setText(R.id.item_news_headline_replycont, t1348647909107Bean.getReplyCount() + "人跟帖");
                        if (t1348647909107Bean.getSkipType() == "pa") {

                        }
//                        switch (t1348647909107Bean.getSkipType()){
//                            case "pa":
//
//                                break;

                        //}
                    }
                });
            }

            @Override
            public void onError(String errorMsg) {

            }
        });

    }

}
