package com.lanou.xuhaijia.enjoylife.news.delicecyfood;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lanou.xuhaijia.enjoylife.R;
import com.lanou.xuhaijia.enjoylife.base.NetTool;
import com.lanou.xuhaijia.enjoylife.base.UrlValues;

import java.util.ArrayList;

/**
 * Created by 国冰冰 on 16/9/30.
 */
public class DeclicacyFoodAdapter extends PagerAdapter {
    private View view;
    DelicacyFoodBean delicacyFoodBeen;
    Context context;
    private String url;
    private NetTool netTool;
    private ImageView imageView;
    private ImageView smallPic;
    private TextView descr;
    private TextView title;
    private TextView textView;

    public DeclicacyFoodAdapter(Context context) {
        this.context = context;
    }

    public DeclicacyFoodAdapter(DelicacyFoodBean delicacyFoodBeen, Context context) {
        this.delicacyFoodBeen = delicacyFoodBeen;
        this.context = context;

    }

    public void setDelicacyFoodBeen(DelicacyFoodBean delicacyFoodBeen) {
        this.delicacyFoodBeen = delicacyFoodBeen;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return delicacyFoodBeen == null ? 0 : 15;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {

        view = LayoutInflater.from(context).inflate(R.layout.item_declicacyfood, container, false);
        imageView = (ImageView) view.findViewById(R.id.item_declicacy_pic);
        smallPic = (ImageView) view.findViewById(R.id.item_small_pic);
        descr = (TextView) view.findViewById(R.id.item_tiele_content);
        textView = (TextView) view.findViewById(R.id.item_delicious_text);

                Glide.with(context).load(delicacyFoodBeen.getObj().getSan_can().get(position).getTitlepic()).into(imageView);
                Glide.with(context).load(delicacyFoodBeen.getObj().getSan_can().get(position).getTj_img()).into(smallPic);
                textView.setText(delicacyFoodBeen.getObj().getSan_can().get(position).getTitle());
                descr.setText(delicacyFoodBeen.getObj().getSan_can().get(position).getDescr());

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        View v = container.getChildAt(position);
        container.removeView(v);
    }
}
