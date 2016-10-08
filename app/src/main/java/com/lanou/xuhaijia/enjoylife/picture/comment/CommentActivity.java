package com.lanou.xuhaijia.enjoylife.picture.comment;
import android.content.Intent;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.lanou.xuhaijia.enjoylife.R;
import com.lanou.xuhaijia.enjoylife.base.BaseActivity;
import com.lanou.xuhaijia.enjoylife.base.NetTool;
import com.lanou.xuhaijia.enjoylife.base.UrlValues;
import com.lanou.xuhaijia.enjoylife.picture.details.DetailsBean;
import com.lanou.xuhaijia.enjoylife.tools.CommonAdapter;
import com.lanou.xuhaijia.enjoylife.tools.CommonViewHolder;

import java.text.SimpleDateFormat;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * 　　　　　　　　┏┓　　　┏┓+ +
 * 　　　　　　　┏┛┻━━━┛┻┓ + +
 * 　　　　　　　┃　　　　　　　┃
 * 　　　　　　　┃　　　━　　　┃ ++ + + +
 * 　　　　　　 ████━████ ┃+
 * 　　　　　　　┃　　　　　　　┃ +
 * 　　　　　　　┃　　　┻　　　┃
 * 　　　　　　　┃　　　　　　　┃ + +
 * 　　　　　　　┗━┓　　　┏━┛
 * 　　　　　　　　　┃　　　┃
 * 　　　　　　　　　┃　　　┃ + + + +
 * 　　　　　　　　　┃　　　┃　　　　Code is far away from bug with the animal protecting
 * 　　　　　　　　　┃　　　┃ + 　　　　神兽保佑代码无BUG,
 * <p/>
 * 　　　　　　　　　┃　　　┃
 * 　　　　　　　　　┃　　　┃　　+
 * 　　　　　　　　　┃　 　　┗━━━┓ + +
 * 　　　　　　　　　┃ 　　　　　　　┣┓
 * 　　　　　　　　　┃ 　　　　　　　┏┛
 * 　　　　　　　　　┗┓┓┏━┳┓┏┛ + + + +
 * 　　　　　　　　　　┃┫┫　┃┫┫
 * 　　　　　　　　　　┗┻┛　┗┻┛+ + + +
 * <p/>
 * Created by 史静雯 date
 */
public class CommentActivity extends BaseActivity {

    private ListView listView;
    private CircleImageView photoIv;
    private TextView timeTv;
    private TextView commentTv;
    private TextView userNameTv;
    private SimpleDateFormat mFormat;

    @Override
    protected int setLayout() {
        return R.layout.activity_comment;
    }

    @Override
    protected void initView() {
        listView = bindView(R.id.activity_comment_list);


    }

    @Override
    protected void initData() {

        Intent intent = getIntent();
        String urlAdd = intent.getStringExtra("ID");

        mNetTool.getData(UrlValues.COMMENT_START_URL + urlAdd + UrlValues.COMMENT_END_UEL,
                CommentBean.class, new NetTool.NetInterface<CommentBean>() {

                    @Override
                    public void onSuccess(final CommentBean commentBean) {

                        listView.setAdapter(new CommonAdapter<CommentBean.DataBean.CommentsBean>(commentBean.getData().getComments(),CommentActivity.this,R.layout.comment_item_list) {
                            @Override
                            public void setData(CommentBean.DataBean.CommentsBean commentsBean, CommonViewHolder viewHolder, int position) {
                                if (commentBean != null) {
                                    viewHolder.setText(R.id.comment_list_item_username, commentsBean.getAuthor().getUsername());
                                    viewHolder.setText(R.id.comment_list_item_content, commentsBean.getContent());
                                    mFormat = new SimpleDateFormat("MM-dd");
                                    //获取系统时间
                                    Long now = System.currentTimeMillis();
                                    long time = now - Long.valueOf(commentsBean.getCreated_at());
                                    if (time < 1000 * 60 * 60) {
                                        String m = String.valueOf((int) time / 1000 / 60);
                                        viewHolder.setText(R.id.comment_list_item_create, m + "分钟之前");
                                    } else if (time > 1000 * 60 * 60 && time < 1000 * 60 * 60 * 24) {
                                        String h = String.valueOf((int) time / 1000 / 60 / 60);
                                        viewHolder.setText(R.id.comment_list_item_create, h + "小时之前");
                                    } else if (time > 1000 * 60 * 60 * 24 && time < 1000 * 60 * 60 * 24 * 3) {
                                        String d = String.valueOf((int) time / 1000 / 60 / 60 / 24);
                                        viewHolder.setText(R.id.comment_list_item_create, d + "天前");
                                    } else {
                                        String data = mFormat.format(Long.valueOf(commentsBean.getCreated_at()));
                                        viewHolder.setText(R.id.comment_list_item_create, data);
                                    }
                                    viewHolder.setImage(R.id.comment_list_item_avatar_url, commentsBean.getAuthor().getAvatar_url(), CommentActivity.this);
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