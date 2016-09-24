package com.lanou.xuhaijia.enjoylife.music.photoin;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lanou.xuhaijia.enjoylife.R;

import java.util.List;

/**
 * Created by 徐海佳 on 16/9/23.
 */
public class BigPicAdapter extends PagerAdapter{
    Context mContext;
    List<PhotoInBean.PhotosBean> photos;

    public BigPicAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setPhotos(List<PhotoInBean.PhotosBean> photos) {
        this.photos = photos;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return photos != null ? photos.size() : 0;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_bigpic , null);
        ImageView iv = (ImageView) view.findViewById(R.id.item_bigpic_iv);
        TextView desc = (TextView) view.findViewById(R.id.item_bigpic_desc);
        TextView data = (TextView) view.findViewById(R.id.item_bigpic_data);
        Glide.with(mContext).load(photos.get(position).getUrl()).into(iv);
        desc.setText(photos.get(position).getDesc());
        data.setText(photos.get(position).getUploader_name() + " " + photos.get(position).getUpload_time());
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
