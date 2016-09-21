package com.lanou.xuhaijia.enjoylife.tools;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 * Created by 徐海佳 on 16/9/13.
 * 一个通用的ViewHolder, 试用于所有的Adapter
 */
public class CommonViewHolder extends RecyclerView.ViewHolder{
    // SparseArray 可以看成是一个Key值是int类型的HashMap
    // 它是Android 特有的, 它的效率要比HashMap高
    private SparseArray<View> views;
    private View convertView; // 行布局

    // 返回行布局
    public View getConvertView() {
        return convertView;
    }

    public static CommonViewHolder getHolder (View convertView , LayoutInflater inflater ,
                                              int id , ViewGroup parent) {
        CommonViewHolder viewHolder;
        if (convertView == null) {
            View view = inflater.inflate(id , parent ,false);
            viewHolder = new CommonViewHolder(view);
        } else {
            viewHolder = (CommonViewHolder) convertView.getTag();
        }
        return viewHolder;
    }

    public static CommonViewHolder getHolder(LayoutInflater inflater, int id, ViewGroup parent) {
        View view = inflater.inflate(id, parent, false);
        CommonViewHolder viewHolder = new CommonViewHolder(view);
        return viewHolder;
    }

    public CommonViewHolder(View convertView) {
        super(convertView);
        views = new SparseArray<>();
        this.convertView = convertView;
        this.convertView.setTag(this);

    }

    /**
     * 通过id来获得行布局里指定的View的方法
     * @param id  View的id
     * @return 该id所对应的view
     */
    public <T extends View> T  getView(int id) {
        View view = views.get(id);
        if (view == null) {
            //  TODO 将要做的工作 标注出来
            //执行findViewById 找到这个组件, 然后放到views里面;
            view = convertView.findViewById(id);
            views.put(id , view);
        }
        return (T) view;
    }

    // 设置文字
    public void setText (int id ,String text) {
        TextView textView = getView(id);
        textView.setText(text);
    }

    public void setImage(int id , String url , Context context) {
        Glide.with(context).load(url).into((ImageView) getView(id));
    }

}
