package com.lanou.xuhaijia.enjoylife.picture.details;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.style.ImageSpan;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.lanou.xuhaijia.enjoylife.R;
import com.lanou.xuhaijia.enjoylife.base.BaseActivity;
import com.lanou.xuhaijia.enjoylife.base.MyApp;
import com.lanou.xuhaijia.enjoylife.base.NetTool;
import com.lanou.xuhaijia.enjoylife.base.UrlValues;
import com.lanou.xuhaijia.enjoylife.picture.imagegetter.HtmlTextView;
import com.lanou.xuhaijia.enjoylife.tools.CommonViewHolder;
import com.lanou.xuhaijia.enjoylife.tools.RecycleViewAdapter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

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
    private LayoutInflater inflater;
    private ViewPager pager;
    private RecyclerView recyclerViewPop;
    private RecyclerPopAdapter recyclerPopAdapter;
    private DetailsScrollView scrollView;
    private int searchLayoutTop;
    private RelativeLayout reLayout;


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

        scrollView = bindView(R.id.details_scroll_view);
        reLayout = bindView(R.id.details_relative_scroll);

    }
    int b = -1;
    int a = 1;
    @Override
    protected void initData() {
        EventBus.getDefault().register(this);
        returnBtn.setOnClickListener(this);
        extpandBtn.setOnClickListener(this);
        recoverBtn.setOnClickListener(this);
        contentHv.setOnClickListener(this);

        scrollView.setOnScrollListener(new DetailsScrollView.OnScrollListener() {
            @Override
            public void onScroll(int scrollY) {
                if (scrollY > 50 && b < 0) {
                    Log.d("DetailsActivity", "次数");
                    b = 1;
                    a = 1;
                    TranslateAnimation ta = new TranslateAnimation(
                            0 , 0 , 0 , -200);
                    ta.setFillAfter(true);
                    ta.setDuration(1000);
                    ta.setRepeatCount(0);
                    reLayout.setAnimation(ta);
                    reLayout.setVisibility(View.GONE);
                } else if (scrollY < -50 && a > 0){
                    b = -1;
                    a = -1;
                    TranslateAnimation ta = new TranslateAnimation(
                            0, 0 , -200 , 0);
                    ta.setFillAfter(true);
                    ta.setDuration(1000);
                    ta.setRepeatCount(0);
                    reLayout.setAnimation(ta);
                    reLayout.setVisibility(View.VISIBLE);
                }
            }
        });

        Intent intent = getIntent();
        String urlAdd = intent.getStringExtra("ID");
        String url = UrlValues.PIVTURE_DETAILS_STAER_URL + urlAdd + UrlValues.PIVTURE_DETAILS_END_URL;





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

    int position;
    ArrayList<String> strings;
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
                int what = msg.what;
                if (what == 200){
                     position = 1;
                    ImagegetterShow.MessageSpan ms = (ImagegetterShow.MessageSpan) msg.obj;
                    Object[] spans = (Object[]) ms.getObj();
                    for (Object span : spans){
                        if (span instanceof ImageSpan){
                            for (int i = 0; i <strings.size(); i++) {
                                if (((ImageSpan)span).getSource().equals(strings.get(i))){
                                    position = i;
                                }
                            }
                        }
                    }
                    setPopupWindow(strings,position);

                }
            }
    };

//    public void onWindowFocusChanged(boolean hasFocus){
//        super.onWindowFocusChanged(hasFocus);
//        if (hasFocus){
//            searchLayoutTop = reLayout.getBottom();
//        }
//    }





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
                setPopupWindow(strings,position);
                Log.d("DetailsActivity", "hahah");
                break;
        }
    }

    public void setPopupWindow(final ArrayList<String> strings , final int position){
        Log.d("DetailsActivity", "position:" + position);
//        inflater = (LayoutInflater) getSystemService(DetailsActivity.LAYOUT_INFLATER_SERVICE);
        View view = LayoutInflater.from(DetailsActivity.this).inflate(R.layout.activity_detalis_popup,null);
        PopupWindow popupWindow = new PopupWindow(view, WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        popupWindow.setContentView(view);
        pager = (ViewPager) view.findViewById(R.id.details_popup);
        recyclerViewPop = (RecyclerView) view.findViewById(R.id.details_recycler);


        recyclerPopAdapter = new RecyclerPopAdapter(MyApp.getContext());
        LinearLayoutManager manager = new LinearLayoutManager(MyApp.getContext());
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerViewPop.setLayoutManager(manager);
        recyclerViewPop.setAdapter(recyclerPopAdapter);
        recyclerPopAdapter.setIndex(strings.size());

        pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                recyclerPopAdapter.setCount(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        view.setBackgroundColor(Color.WHITE);
        view.setFocusable(true);
        ColorDrawable drawable = new ColorDrawable(0xff000000);
        view.setBackgroundDrawable(drawable);
        PopupWindowAdapter adapter = new PopupWindowAdapter(getApplicationContext());
        adapter.setStrings(strings);
        pager.setAdapter(adapter);
        pager.setCurrentItem(position,false);
        View rootView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.activity_detalis,null);
        popupWindow.showAtLocation(rootView, Gravity.BOTTOM,0,0);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void getString(ImageStrings imageStrings){
          strings = imageStrings.getStrings();
        Log.d("DetailsActivity", "strings:" + strings);
        Log.d("DetailsActivity", "str1111111111111ings.size():" + strings.size());
    }

    @Override
    protected void onDestroy() {
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }
}

//ArrayList是一个数组的形式存储的 而LinkedList是以链表的形式存储的
//查找数据时ArrayList的效率比较高 LinkedList则添加和删除的效率比较高
//队列 fifo 线性 存储元素
//树 根部 指向不同的结构若干下线 例如传销
// 二叉树 可以指所有的节点 节点最多只有两个 二叉树 在排序的时候用的最多  中间数作为节点 左小右大
//平衡二叉树 查找效率最高

