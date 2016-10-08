package com.lanou.xuhaijia.enjoylife.travel.travelhoteltools;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lanou.xuhaijia.enjoylife.R;
import com.lanou.xuhaijia.enjoylife.travel.hotel.HotelAtyBean;

/**
 * Created by Shall on 2015-06-23.
 */
public class CardAdapter extends BaseAdapter {
    private Context mContext;
    private HotelAtyBean hotelAtyBean;

    public CardAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setHotelAtyBean(HotelAtyBean hotelAtyBean) {
        this.hotelAtyBean = hotelAtyBean;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return hotelAtyBean == null ? 0 : hotelAtyBean.getList().size();
    }

    @Override
    public Object getItem(int position) {
        return hotelAtyBean.getList().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(mContext);


            convertView = inflater.inflate(R.layout.item, parent, false);
            holder = new ViewHolder();
            holder.mCardImageView = (ImageView) convertView.findViewById(R.id.helloText);
            holder.mCardName = (TextView) convertView.findViewById(R.id.card_name);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        Glide.with(mContext)
                .load(hotelAtyBean.getList().get(position).getCover())
                .into(holder.mCardImageView);
        holder.mCardName.setText(hotelAtyBean.getList().get(position).getName_cn());

        return convertView;
    }

    class ViewHolder {

        TextView mCardName;


        ImageView mCardImageView;
    }
}
