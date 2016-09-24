package com.lanou.xuhaijia.enjoylife.tools;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.lanou.xuhaijia.enjoylife.base.NetTool;
import com.lanou.xuhaijia.enjoylife.picture.details.DetailsBean;
import com.lanou.xuhaijia.enjoylife.travel.attractions.AttractionAtyBean;
import com.lanou.xuhaijia.enjoylife.travel.food.FoodAty;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 徐海佳 on 16/9/13.
 */
public abstract class CommonAdapter<T> extends BaseAdapter{
    private List<T> beanList;
    private LayoutInflater mLayoutInflater;
    private int convertViewId;


    public CommonAdapter(List<T> beanList, Context context, int convertViewId) {
        this.beanList = beanList;
        this.convertViewId = convertViewId;
        mLayoutInflater =LayoutInflater.from(context);
    }




    @Override
    public int getCount() {
        return beanList  != null ?  beanList.size() : 0;
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
    public View getView(int i, View view, ViewGroup viewGroup) {
        CommonViewHolder commonViewHolder = CommonViewHolder.getHolder(
                view ,mLayoutInflater ,convertViewId ,viewGroup);
        setData(beanList.get(i), commonViewHolder, i);
        return commonViewHolder.getConvertView();
    }


    public abstract void setData(T t , CommonViewHolder viewHolder , int position);

}
