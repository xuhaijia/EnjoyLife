package com.lanou.xuhaijia.enjoylife.news.delicecyfood;


import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.bumptech.glide.Glide;
import com.lanou.xuhaijia.enjoylife.R;
import com.lanou.xuhaijia.enjoylife.base.BaseFragment;
import com.lanou.xuhaijia.enjoylife.base.NetTool;
import com.lanou.xuhaijia.enjoylife.base.UrlValues;
import com.lanou.xuhaijia.enjoylife.news.headline.HeadLinesContentActivity;
import com.lanou.xuhaijia.enjoylife.tools.CommonAdapter;
import com.lanou.xuhaijia.enjoylife.tools.CommonViewHolder;

import java.util.ArrayList;

/**
 * Created by 国冰冰 on 16/9/13.
 */
public class DelicacyFoodFragment extends BaseFragment {
    private ListView listView;
    private ImageView headViewPic;

    @Override
    protected int setLayout() {
        return R.layout.fragment_news_delicious;
    }

    @Override
    protected void initView() {
        listView = bindView(R.id.fragment_news_delicious_lv);
    }

    @Override
    protected void initData() {
        mNetTool.getData(UrlValues.NEWS_DELICACY_FOOD, DelicacyFoodBean.class, new NetTool.NetInterface<DelicacyFoodBean>() {
            @Override
            public void onSuccess(final DelicacyFoodBean delicacyFoodBean) {
                String picUrl = delicacyFoodBean.getObj().getSan_can().get(0).getTitlepic();
                View view = LayoutInflater.from(mContext).inflate(R.layout.fragment_news_delicious_viewpager, null);
                headViewPic = (ImageView) view.findViewById(R.id.fragment_news_headview_pic);
                Glide.with(mContext).load(picUrl).into(headViewPic);
                listView.addHeaderView(view);
                ArrayList<DelicacyFoodBean.ObjBean.ZtBean> ztBeen = new ArrayList<DelicacyFoodBean.ObjBean.ZtBean>();
                for (int i = 0; i < delicacyFoodBean.getObj().getZt().size(); i++) {
                    ztBeen.add(delicacyFoodBean.getObj().getZt().get(i));
                }
                listView.setAdapter(new CommonAdapter<DelicacyFoodBean.ObjBean.ZtBean>(ztBeen, mContext, R.layout.item_delicious) {
                    @Override
                    public void setData(DelicacyFoodBean.ObjBean.ZtBean ztBean, CommonViewHolder viewHolder, int position) {
                        viewHolder.setImage(R.id.item_delicious_pic, ztBean.getPhoto(), getContext());
                    }
                });
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                    private String url;

                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        if (i == 0){
                            Intent intent = new Intent(getContext(),DeliciousFoodActivity.class);
                            startActivity(intent);
                        }else {
                            url = delicacyFoodBean.getObj().getZt().get(i - listView.getHeaderViewsCount() ).getF_s_type();//头饰图个数
                            Intent intentWeb = new Intent(getContext(), HeadLinesContentActivity.class);
                            intentWeb.putExtra("headline",url);
                            startActivity(intentWeb);
                        }
                    }

                });
            }

            @Override
            public void onError(String errorMsg) {

            }
        });
    }
}