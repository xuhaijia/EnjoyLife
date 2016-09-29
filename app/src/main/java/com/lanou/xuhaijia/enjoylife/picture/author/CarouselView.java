package com.lanou.xuhaijia.enjoylife.picture.author;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;

import com.lanou.xuhaijia.enjoylife.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenyang on 16/9/21.
 *
 * 轮播图封装类 , 解析viewpager图片用的Glide
 * compile 'com.github.bumptech.glide:glide:3.5.2'
 * 在onstart 和 ondestroy 分别调用startCarouselView,destroyCarouselView
 * 得到PicUrls , 然后start
 */
public class CarouselView extends LinearLayout {

    private Context context;
    private ViewPager viewPager;
    private LinearLayout dotLayout;
    private List<View> dotList;   //指示点
    // 点的集合 (需要传入的1)
    private int[] points = {R.mipmap.xiaobaidian,R.mipmap.xiaohuidian};
    // 轮播图 图片集合
    private List<String> picUrls ;
    private GridView gridView;
    private GridViewAdapter gridViewAdapter;
    private int viewPagerSize;

    public void setPicUrls(List<String> picUrls){
        this.picUrls = picUrls;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);

            List<Integer> finalyList = new ArrayList<>();
            for (int i = 0; i < picUrls.size(); i++) {

                if (i == viewPager.getCurrentItem() % picUrls.size()) {
                    finalyList.add(points[1]);
                } else {
                    finalyList.add(points[0]);
                }
            }

            gridViewAdapter.setList(finalyList);

            Message m = new Message();
            m.what = 1;
            handler.sendMessageDelayed(m, 4000);
            return false;
        }
    });

    public void startCarouselView() {
        Message message = handler.obtainMessage();
        message.what = 1;
        handler.sendMessageDelayed(message, 4000);
    }

    public void destroyCarouselView() {
        handler.removeMessages(1);
    }

    public CarouselView(Context context) {
        this(context, null);
    }

    public CarouselView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init();
    }

    private void init() {
        LayoutInflater.from(context).inflate(R.layout.carousel_layout, this, true);
        initView();
        initData();
    }

    private void initData() {
        dotList = new ArrayList<>();
    }

    private void initView() {
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        dotLayout = (LinearLayout) findViewById(R.id.dot_layout);
        gridView = (GridView) findViewById(R.id.gv_vampire);
        // 轮播图表示点视图
        gridViewAdapter = new GridViewAdapter(context);
    }

    public void start(final List<String> picUrls) {
        this.picUrls = picUrls;
        if (this.picUrls == null || this.picUrls.size() < 1) {
            return;
        }

        View view = null;
        final List<Integer> integers = new ArrayList<>();
        //根据轮播图要显示的数量来创建指示点的个数
        for (int i = 0; i < this.picUrls.size(); i++) {
            view = new View(context);

            if (i == 0) {
                integers.add(points[1]);
            } else {
                integers.add(points[0]);
            }

            dotList.add(view);  //加入到list集合中
            dotLayout.addView(view);  //加入父布局
        }
        gridView.setNumColumns(this.picUrls.size());
        gridView.setAdapter(gridViewAdapter);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {


                List<Integer> finalyList = new ArrayList<>();
                for (int i = 0; i < integers.size(); i++) {

                    viewPagerSize = viewPager.getCurrentItem() % integers.size();
                    if (i == viewPagerSize) {
                        finalyList.add(points[1]);
                    } else {
                        finalyList.add(points[0]);
                    }
                }

                gridViewAdapter.setList(finalyList);
                switch (state) {
                    case ViewPager.SCROLL_STATE_DRAGGING ://当手按上去的时候 , remove掉handler
                        handler.removeCallbacksAndMessages(null);
                        break;
                    case ViewPager.SCROLL_STATE_IDLE://当手按上去的时候 , remove掉handler,在开始轮播
                        handler.removeCallbacksAndMessages(null);
                        startCarouselView();
                        break;
                    case ViewPager.SCROLL_STATE_SETTLING:
                        break;
                    default:
                        break;
                }
            }
        });

        gridViewAdapter.setList(integers);

//        viewPager.setPageMargin(100);//两个页面之间的间距
        viewPager.setAdapter(new MyPagerAdapter());
        viewPager.setCurrentItem(3000, false);
        viewPager.setPageTransformer(true , new DepthPageTransformer());

    }

    class MyPagerAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return Integer.MAX_VALUE;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;

        }

        @Override
        public Object instantiateItem(ViewGroup container, final int position) {

            final String pic = picUrls.get(position % picUrls.size());
            ImageView imageView = new ImageView(context);

            Glide.with(context)
                    .load(pic)
                    .into(imageView);

            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            container.addView(imageView);

            imageView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
//                    clickCallback.onClick(0, position);
                }
            });
            return imageView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }

    ClickCallback clickCallback;

    interface ClickCallback {
        void onClick(int id, int position);
    }

    public void setClickCallback(ClickCallback clickCallback) {
        this.clickCallback = clickCallback;
    }


}
