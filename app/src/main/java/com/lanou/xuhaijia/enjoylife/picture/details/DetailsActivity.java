package com.lanou.xuhaijia.enjoylife.picture.details;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.method.LinkMovementMethod;
import android.text.style.ImageSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.lanou.xuhaijia.enjoylife.R;
import com.lanou.xuhaijia.enjoylife.base.BaseActivity;
import com.lanou.xuhaijia.enjoylife.base.MyApp;
import com.lanou.xuhaijia.enjoylife.base.NetTool;
import com.lanou.xuhaijia.enjoylife.base.UrlValues;
import com.lanou.xuhaijia.enjoylife.picture.imagegetter.HtmlTextView;
import com.lanou.xuhaijia.enjoylife.tools.CommonAdapter;
import com.lanou.xuhaijia.enjoylife.tools.CommonViewHolder;
import com.lanou.xuhaijia.enjoylife.tools.RecycleViewAdapter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

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
public class DetailsActivity extends BaseActivity implements View.OnClickListener {

    private ImageView returnBtn;
    private ImageView ellipseIv;
    private ImageView imageUrlIv;
    private ImageView nameUrlCiv;
    private ImageView avatarCiv;
    private ImageView nameUrlTwoCiv;
    private TextView number;
    private TextView lookTv;
    private TextView descriptionTv;
    private TextView nameTwoTv;
    private TextView label;
    private TextView usernameTv;
    private TextView signTv;
    private TextView nameTv;
    private TextView cityTv;
    private TextView titleTv;
    private TextView titleSubTv;
    private Button concernBtn;
    private Button applyBtn;
    private Button enjoyBtn;
    private Button lookBtn;
    private RecyclerView recyclerView;
    private HtmlTextView contentHv;
    private RecyclerView recyclerViewTwo;
    private Button extpandBtn;
    private Button recoverBtn;
    private SimpleDateFormat mFormat;
    private ImageView photoCiv;
    private TextView numberTwoTv;
    private TextView likeTv;
    private EditText say;
    private ImageView more;


    @Override
    protected int setLayout() {
        return R.layout.activity_detalis;
    }

    @Override
    protected void initView() {
        returnBtn = bindView(R.id.activity_details_return);
        ellipseIv = bindView(R.id.activity_details_ellipse);
        imageUrlIv = bindView(R.id.activity_details_image_url);

        more = bindView(R.id.activity_details_more);
        photoCiv = bindView(R.id.activity_details_photo);
        nameUrlCiv = bindView(R.id.activity_details_name_url);
        avatarCiv = bindView(R.id.activity_details_avatar_url);
        nameUrlTwoCiv = bindView(R.id.activity_details_avatar_url_two);

        number = bindView(R.id.activity_details_number);
        lookTv = bindView(R.id.activity_details_look);
        descriptionTv = bindView(R.id.activity_details_description);
        nameTwoTv = bindView(R.id.activity_details_name_two);
        label = bindView(R.id.activity_details_label);
        usernameTv = bindView(R.id.activity_details_username);
        signTv = bindView(R.id.activity_details_sign);
        nameTv = bindView(R.id.activity_details_name);
        cityTv = bindView(R.id.activity_details_city);
        titleTv = bindView(R.id.activity_details_title);
        titleSubTv = bindView(R.id.activity_details_sub_title);
        numberTwoTv = bindView(R.id.activity_details_number_two);
        likeTv = bindView(R.id.activity_details_like);

        say = bindView(R.id.activity_details_say);


        extpandBtn = bindView(R.id.activity_details_btn_expand);
        recoverBtn = bindView(R.id.activity_details_btn_recover);
        recoverBtn.setVisibility(View.GONE);
        concernBtn = bindView(R.id.activity_details_concern);
        applyBtn = bindView(R.id.activity_details_btn_apply);
        enjoyBtn = bindView(R.id.activity_details_btn_enjoy);
        lookBtn = bindView(R.id.activity_details_btn_look);

        recyclerViewTwo = bindView(R.id.activity_details_recycler_view_two);
        recyclerView = bindView(R.id.activity_details_recycler_view);

        contentHv = bindView(R.id.activity_details_image_getter);

    }

    @Override
    protected void initData() {
        returnBtn.setOnClickListener(this);
        extpandBtn.setOnClickListener(this);
        recoverBtn.setOnClickListener(this);
        contentHv.setOnClickListener(this);
        Intent intent = getIntent();
        String urlAdd = intent.getStringExtra("ID");

        String url = UrlValues.PIVTURE_DETAILS_STAER_URL + urlAdd + UrlValues.PIVTURE_DETAILS_END_URL;
        Log.d("DetailsActivity", url);
        mNetTool.getData(url, DetailsBean.class, new NetTool.NetInterface<DetailsBean>() {
                    @Override
                    public void onSuccess(DetailsBean detailsBean) {
                        nameTv.setText(detailsBean.getData().getDesigners().get(0).getName());
                        cityTv.setText(detailsBean.getData().getDesigners().get(0).getCity());
                        titleTv.setText(detailsBean.getData().getTitle());
                        titleSubTv.setText(detailsBean.getData().getSub_title());
                        usernameTv.setText(detailsBean.getData().getAuthor().getUsername());
                        signTv.setText(detailsBean.getData().getAuthor().getSign());
                        nameTwoTv.setText(detailsBean.getData().getDesigners().get(0).getName());
                        label.setText(detailsBean.getData().getDesigners().get(0).getLabel());
                        descriptionTv.setText(detailsBean.getData().getDesigners().get(0).getDescription());
                        number.setText("(" + detailsBean.getData().getComment_num() + ")");
//                        numberTwoTv.setText(detailsBean.getData().getComment_num());
//                        likeTv.setText(detailsBean.getData().getLike_user_num());

                        String html = detailsBean.getData().getContent();
                        html.trim();
                        contentHv.setHtmlFromString(html, false);
                        contentHv.setMovementMethod(ImagegetterShow.getInstance(handler,ImageSpan.class));
                        Glide.with(MyApp.getContext()).load(detailsBean.getData().getDesigners().get(0).getAvatar_url()).into(nameUrlTwoCiv);
                        Glide.with(MyApp.getContext()).load(detailsBean.getData().getDesigners().get(0).getAvatar_url()).into(nameUrlCiv);
                        Glide.with(MyApp.getContext()).load(detailsBean.getData().getAuthor().getAvatar_url()).into(avatarCiv);
                        Glide.with(MyApp.getContext()).load(detailsBean.getData().getImage_url()).into(imageUrlIv);


                        GridLayoutManager manager = new GridLayoutManager(MyApp.getContext(), 1);
                        recyclerViewTwo.setLayoutManager(manager);
                        recyclerViewTwo.setAdapter(new RecycleViewAdapter<DetailsBean.DataBean.CommentsBean>(detailsBean.getData().getComments(), DetailsActivity.this, R.layout.detalis_list_item) {

                            @Override
                            public void setData(DetailsBean.DataBean.CommentsBean commentsBean, CommonViewHolder viewHolder) {

                                mFormat = new SimpleDateFormat("MM-DD");

                                //获取系统时间
                                Long now = System.currentTimeMillis();
                                long time = now - Long.valueOf(commentsBean.getCreated_at());
                                if (time < 1000 * 60 * 60 ){
                                    String m = String.valueOf((int) time / 1000 / 60 );
                                    viewHolder.setText(R.id.details_list_item_create,m + "分钟之前");
                                } else if (time > 1000 * 60 * 60 && time < 1000 * 60 * 60 * 24){
                                    String h = String.valueOf((int) time / 1000 / 60 / 60);
                                    viewHolder.setText(R.id.details_list_item_create,h + "小时之前");
                                } else if (time > 1000 * 60 * 60 * 24 ){
                                    String d = String.valueOf((int) time / 1000 / 60 / 60 / 24);
                                    viewHolder.setText(R.id.details_list_item_create,d + "天前");
                                } else {
                                    String data = mFormat.format(Long.valueOf(time));
                                    viewHolder.setText(R.id.details_list_item_create,data);
                                }
                                viewHolder.setImage(R.id.details_list_item_avatar_url, commentsBean.getAuthor().getAvatar_url(), DetailsActivity.this);
                                viewHolder.setText(R.id.details_list_item_username, commentsBean.getAuthor().getUsername());
                                viewHolder.setText(R.id.details_list_item_content, commentsBean.getContent());
                                if (commentsBean.getParent_comment() != null) {
                                    if (commentsBean.getParent_comment().getContent().length() != 0) {
                                        viewHolder.setText(R.id.details_list_item_reply, commentsBean.getParent_comment().getContent());
                                    }
                                }
                            }
                        });
                        GridLayoutManager layoutManager = new GridLayoutManager(MyApp.getContext(), 2);
                        recyclerView.setLayoutManager(layoutManager);

                        recyclerView.setAdapter(new RecycleViewAdapter<DetailsBean.DataBean.ReferProductsBean>(detailsBean.getData().getRefer_products(), DetailsActivity.this, R.layout.details_receyler_item) {
                            @Override
                            public void setData(DetailsBean.DataBean.ReferProductsBean referProductsBean, CommonViewHolder viewHolder) {
                                viewHolder.setImage(R.id.details_receyler_iv, referProductsBean.getCover_images().get(0), DetailsActivity.this);
                            }

                        });
                    }

                    @Override
                    public void onError(String errorMsg) {
                        Toast.makeText(DetailsActivity.this, "网络请求失败" + errorMsg.toString(), Toast.LENGTH_SHORT).show();
                    }
                });

    }

    Handler handler = new Handler(){
        public void handlerMessage(Message msg){
            int what = msg.what;
            if (what == 200){
                ImagegetterShow.MessageSpan ms = (ImagegetterShow.MessageSpan) msg.obj;
                Object[] spans = (Object[]) ms.getObj();
                for (Object span : spans){
                    if (span instanceof ImageSpan){
                        Log.d("ImagegetterShow", "点击了图片");
                    }
                }
            }
        }
    };



    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.activity_details_return:
                finish();
                break;
            case R.id.activity_details_btn_expand:
                descriptionTv.setMaxLines(100);
                recoverBtn.setVisibility(View.VISIBLE);
                extpandBtn.setVisibility(View.GONE);
                break;
            case R.id.activity_details_btn_recover:
                descriptionTv.setMaxLines(3);
                extpandBtn.setVisibility(View.VISIBLE);
                recoverBtn.setVisibility(View.GONE);

                break;
            case R.id.activity_details_image_getter:

                break;
        }
    }

    
}
//ArrayList是一个数组的形式存储的 而LinkedList是以链表的形式存储的
//查找数据时ArrayList的效率比较高 LinkedList则添加和删除的效率比较高
//队列 fifo 线性 存储元素
//树 根部 指向不同的结构若干下线 例如传销
// 二叉树 可以指所有的节点 节点最多只有两个 二叉树 在排序的时候用的最多  中间数作为节点 左小右大
//平衡二叉树 查找效率最高

