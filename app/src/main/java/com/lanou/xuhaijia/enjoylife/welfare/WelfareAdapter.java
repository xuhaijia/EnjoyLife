package com.lanou.xuhaijia.enjoylife.welfare;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v4.app.ActivityOptionsCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.lanou.xuhaijia.enjoylife.R;
import com.lanou.xuhaijia.enjoylife.base.NetTool;

/**
 * Created by 徐海佳 on 16/9/22.
 */
public class WelfareAdapter extends BaseAdapter {
    Context mContext;
    WelfareBean welfareBean;
    NetTool mNetTool = new NetTool();
    public WelfareAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setWelfareBean(WelfareBean welfareBean) {
        this.welfareBean = welfareBean;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        if (welfareBean.getResults() == null) {
            return 0;
        }
        return welfareBean.getResults().size();

    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        final ViewHolder viewHolder;
        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.item_welfare, null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        Glide.with(mContext).load(welfareBean.getResults().get(i).getUrl()).into(viewHolder.iv);
        AlphaAnimation animation = new AlphaAnimation(0f, 1.0f);
        animation.setDuration(2000);
        animation.setRepeatCount(0);
        animation.setFillBefore(true);
        viewHolder.iv.setAnimation(animation);
        viewHolder.iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext , WelfareActivity.class);
                intent.putExtra("url" , welfareBean.getResults().get(i).getUrl());
                ActivityOptionsCompat options = ActivityOptionsCompat
                        .makeSceneTransitionAnimation((Activity) mContext, viewHolder.iv, "image");
                mContext.startActivity(intent, options.toBundle());
            }
        });
        return view;
    }

    private class ViewHolder {
        ImageView iv;
        public ViewHolder(View view) {
            iv = (ImageView) view.findViewById(R.id.item_welfare_iv);

        }
    }
}
