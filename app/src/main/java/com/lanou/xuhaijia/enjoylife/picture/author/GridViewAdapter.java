package com.lanou.xuhaijia.enjoylife.picture.author;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.lanou.xuhaijia.enjoylife.R;

import java.util.List;

/**
 * Created by chenyang on 16/9/21.
 * GridView , 用来显示轮播图的点
 */
public class GridViewAdapter extends BaseAdapter {
    private Context context;
    private List<Integer> list;
    private MyViewHolder myViewHolder;

    public GridViewAdapter(Context context) {
        this.context = context;
    }


    @Override
    public int getCount() {
        int count =list != null ? list.size() : 0;
        return count;
    }

    public void setList(List<Integer> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public Object getItem(int position) {
        if (myViewHolder !=null){
            return myViewHolder.imageView;
        }
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.carousel_point,parent,false);
            myViewHolder = new MyViewHolder(convertView);
            convertView.setTag(myViewHolder);
        } else {
            myViewHolder = (MyViewHolder) convertView.getTag();
        }

        myViewHolder.imageView.setImageResource(list.get(position));


        return convertView;
    }

    private class MyViewHolder {
        private ImageView imageView;

        public MyViewHolder(View view) {
            imageView = (ImageView) view.findViewById(R.id.iv_vampire);
        }
    }
}
