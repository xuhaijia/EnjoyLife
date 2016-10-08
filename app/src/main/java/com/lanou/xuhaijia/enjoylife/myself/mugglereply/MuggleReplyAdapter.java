package com.lanou.xuhaijia.enjoylife.myself.mugglereply;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.URLSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.lanou.xuhaijia.enjoylife.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by 徐海佳 on 16/9/30.
 */
public class MuggleReplyAdapter extends BaseAdapter {
    ArrayList<ReplyBean> arrayList;
    Context mContext;
    private static final int TYPE_Reply = 1;
    private static final int TYPE_Ask = 0;
    private int currentType;
    private View replyView;
    private View askView;


    public MuggleReplyAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setArrayList(ArrayList<ReplyBean> arrayList) {
        this.arrayList = arrayList;
        notifyDataSetChanged();
    }

    public void addArrayList(ReplyBean replyBean) {
        this.arrayList.add(replyBean);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return arrayList != null ? arrayList.size() : 0;
    }

    @Override
    public int getItemViewType(int position) {
        if (arrayList.get(position).getType() == 1) {
            return TYPE_Reply;
        } else {
            return TYPE_Ask;
        }
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
        currentType = getItemViewType(i);
        if (currentType == TYPE_Reply) {
            ReplyViewHolder replyViewHolder;
//            if (view == null) {
                replyView = LayoutInflater.from(mContext).inflate(R.layout.item_for_reply, null);
                replyViewHolder = new ReplyViewHolder(replyView);
                replyView.setTag(replyViewHolder);
                view = replyView;
//            } else {
//                replyViewHolder = (ReplyViewHolder) view.getTag();
//            }
            if (arrayList.get(i).getBitmap() == null) {
                replyViewHolder.icon.setImageResource(R.mipmap.life_is_beauty);
            } else {
                replyViewHolder.icon.setImageBitmap(arrayList.get(i).getBitmap());
            }
            CharSequence charSequence = Html.fromHtml(arrayList.get(i).getContent());
            replyViewHolder.content.setText(charSequence);
            replyViewHolder.content.setMovementMethod(LinkMovementMethod.getInstance());
            CharSequence text = replyViewHolder.content.getText();
            if(text instanceof Spannable){
                int end = text.length();
                Spannable sp = (Spannable)replyViewHolder.content.getText();
                URLSpan[] urls=sp.getSpans(0, end, URLSpan.class);
                SpannableStringBuilder style=new SpannableStringBuilder(text);
                style.clearSpans();//should clear old spans
                for(URLSpan url : urls){
                    MyURLSpan myURLSpan = new MyURLSpan(url.getURL());
                    style.setSpan(myURLSpan,sp.getSpanStart(url),sp.getSpanEnd(url),Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                }
                replyViewHolder.content.setText(style);
            }

        } else {
            AskViewHolder askViewHolder;
//            if (view == null) {
                askView = LayoutInflater.from(mContext).inflate(R.layout.item_for_ask, null);
                askViewHolder = new AskViewHolder(askView);
                askView.setTag(askViewHolder);
                view = askView;
//            } else {
//                askViewHolder = (AskViewHolder) view.getTag();
//            }
            if (arrayList.get(i).getBitmap() == null) {
                askViewHolder.iconIv.setImageResource(R.mipmap.ic_myself_userphoto);
            } else {
                askViewHolder.iconIv.setImageBitmap(arrayList.get(i).getBitmap());
            }
            askViewHolder.contentTv.setText(arrayList.get(i).getContent());

        }

        return view;
    }

    private class ReplyViewHolder {
        CircleImageView icon;
        TextView content;

        public ReplyViewHolder(View view) {
            icon = (CircleImageView) view.findViewById(R.id.item_for_reply_icon);
            content = (TextView) view.findViewById(R.id.item_for_reply_content);
        }
    }

    private class AskViewHolder {
        CircleImageView iconIv;
        TextView contentTv;

        public AskViewHolder(View view) {
            iconIv = (CircleImageView) view.findViewById(R.id.item_for_ask_icon);
            contentTv = (TextView) view.findViewById(R.id.item_for_ask_content);
        }
    }

    private class MyURLSpan extends ClickableSpan {

        private String mUrl;

        MyURLSpan(String url) {
            mUrl = url;
        }

        @Override
        public void onClick(View widget) {
            Intent intent = new Intent(mContext , WebViewAty.class);
            intent.putExtra("url" , mUrl);
            mContext.startActivity(intent);

        }
    }
}
