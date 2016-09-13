package com.lanou.xuhaijia.enjoylife.picture.fragment;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.lanou.xuhaijia.enjoylife.R;
import com.lanou.xuhaijia.enjoylife.base.BaseFragment;
import com.lanou.xuhaijia.enjoylife.base.NetTool;
import com.lanou.xuhaijia.enjoylife.picture.bean.PictureBean;
import com.lanou.xuhaijia.enjoylife.picture.bean.UrlBean;
import com.lanou.xuhaijia.enjoylife.tools.CommonAdapter;
import com.lanou.xuhaijia.enjoylife.tools.CommonViewHolder;
import com.redbooth.SlidingDeck;
import com.wirelesspienetwork.overview.misc.Utilities;
import com.wirelesspienetwork.overview.model.OverviewAdapter;
import com.wirelesspienetwork.overview.model.ViewHolder;
import com.wirelesspienetwork.overview.views.Overview;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by 徐海佳 on 16/9/13.
 */
public class PictureFragment extends BaseFragment implements View.OnClickListener {

    Overview overview;
    boolean mVisible;

    @Override
    protected int setLayout() {
        return R.layout.fragment_picture;
    }

    @Override
    protected void initView() {
        overview = bindView(R.id.fragment_picture_over_views);

//        slidingDeck = bindView(R.id.fragment_picture_sliding_deck);

    }

    @Override
    protected void initData() {
        overview.setOnClickListener(this);
        overview.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE |
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_SCREEN_OFF);
        filter.addAction(SearchManager.INTENT_GLOBAL_SEARCH_ACTIVITY_CHANGED);

        try {
            Utilities.setShadowProperty("ambientRatio", String.valueOf(1.5f));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


//        mNetTool.getData(UrlBean.PICTURE_ALL_URL, PictureBean.class, new NetTool.NetInterface<PictureBean>() {
//            @Override
//            public void onSuccess(PictureBean pictureBean) {
//                Log.d("PictureFragment", "pictureBean:" + pictureBean);
//                final ArrayList<PictureBean.DataBean.ArticlesBean> arrayList = new ArrayList<>();
//                for (int i = 0; i < pictureBean.getData().getArticles().size(); i++) {
//                    arrayList.add(pictureBean.getData().getArticles().get(i));
//                }
//                slidingDeck.setAdapter(new CommonAdapter<PictureBean.DataBean.ArticlesBean>(arrayList, getContext(), R.layout.fragment_picture_item) {
//                    @Override
//                    public void setData(PictureBean.DataBean.ArticlesBean articlesBean, CommonViewHolder viewHolder) {
//                        Log.d("PictureFragment", "articlesBean:" + articlesBean);
//                        viewHolder.setText(R.id.fragment_picture_item_sign,articlesBean.getAuthor().getSign());
//                        viewHolder.setText(R.id.fragment_picture_item_title_sub,articlesBean.getSub_title());
//                        viewHolder.setText(R.id.fragment_picture_item_title,articlesBean.getTitle());
//                        viewHolder.setImage(R.id.fragment_picture_item_image,articlesBean.getImage_url(),getContext());
//                        viewHolder.setImage(R.id.fragment_picture_item_avatar, articlesBean.getAuthor().getAvatar_url(), getContext());
//                    }
//
//                });
//            }
//
//            @Override
//            public void onError(String errorMsg) {
//            }
//        }); }


    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
        mVisible = true;

        ArrayList<Integer> models = new ArrayList<>();
        for(int i = 0; i < 10; ++i)
        {
            Random random = new Random();
            random.setSeed(i);
            models.add(0xffffffff);
        }

        final OverviewAdapter stack = new OverviewAdapter<ViewHolder<View, Integer>, Integer>(models)
        {
            @Override
            public ViewHolder onCreateViewHolder(Context context, ViewGroup parent) {
                View v = View.inflate(context, R.layout.fragment_picture_item, null);
                return new ViewHolder<View, Integer>(v);
            }

            @Override
            public void onBindViewHolder(ViewHolder<View, Integer> viewHolder) {
                viewHolder.itemView.setBackgroundColor(viewHolder.model);
            }
        };

        overview.setTaskStack(stack);
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

}
