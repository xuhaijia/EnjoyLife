package com.lanou.xuhaijia.enjoylife.news.recreation;

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
public class RecreationFragment extends BaseFragment {
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
            public void onSuccess(RecreationBean recreationBean) {
                ArrayList<RecreationBean.T1348648517839Bean> arrayList = new ArrayList<RecreationBean.T1348648517839Bean>();
                for (int i = 0; i < recreationBean.getT1348648517839().size(); i++) {

                    arrayList.add(recreationBean.getT1348648517839().get(i));
                    mListView.setAdapter(new CommonAdapter<RecreationBean.T1348648517839Bean>(arrayList,mContext,R.layout.item_news_sport) {
                        @Override
                        public void setData(RecreationBean.T1348648517839Bean t1348648517839Bean, CommonViewHolder viewHolder) {
                            viewHolder.setText(R.id.item_news_sport_tv,t1348648517839Bean.getTitle());
                            viewHolder.setText(R.id.item_news_sport_source,t1348648517839Bean.getSource());
                            viewHolder.setText(R.id.item_news_sport_replycont,t1348648517839Bean.getReplyCount() + "人跟帖");
                            viewHolder.setImage(R.id.item_news_sport_img,t1348648517839Bean.getImgsrc(),getContext());
                        }
                    });
                }
            }

            @Override
            public void onError(String errorMsg) {

            }
        });
    }
}
