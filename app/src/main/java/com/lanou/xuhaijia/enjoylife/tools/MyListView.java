package com.lanou.xuhaijia.enjoylife.tools;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.ListView;

/**
 * Created by 徐海佳 on 16/9/14.
 */
public class MyListView extends ListView {

    private Context mContext;

    private int mMaxYOverscrllDistance;
    //回弹距离
    private int MAX_Y = 200;

    public MyListView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mContext = context;
        initBounceListView();
    }

    public MyListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        initBounceListView();
    }

    public MyListView(Context context) {
        super(context);
        this.mContext = context;
        initBounceListView();
    }

    private void initBounceListView() {
        DisplayMetrics metrics = mContext.getResources().getDisplayMetrics();
        float desity = metrics.density;
        //允许超出边界高度的最大距离
        mMaxYOverscrllDistance = (int) (desity * MAX_Y);
    }

    @SuppressLint("NewApi")
    @Override
    protected boolean overScrollBy(int deltaX, int deltaY, int scrollX,
                                   int scrollY, int scrollRangeX, int scrollRangeY,
                                   int maxOverScrollX, int maxOverScrollY, boolean isTouchEvent) {
        // 当listView滑动超出范围的时候，回调该方法，并提供参数做处理
        return super.overScrollBy(deltaX, deltaY, scrollX, scrollY, scrollRangeX,
                scrollRangeY, maxOverScrollX, mMaxYOverscrllDistance, isTouchEvent);
    }

}
