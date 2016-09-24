package com.lanou.xuhaijia.enjoylife.picture.details;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.Interpolator;
import android.widget.ScrollView;
import android.widget.Scroller;

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
 * <p>
 * 　　　　　　　　　┃　　　┃
 * 　　　　　　　　　┃　　　┃　　+
 * 　　　　　　　　　┃　 　　┗━━━┓ + +
 * 　　　　　　　　　┃ 　　　　　　　┣┓
 * 　　　　　　　　　┃ 　　　　　　　┏┛
 * 　　　　　　　　　┗┓┓┏━┳┓┏┛ + + + +
 * 　　　　　　　　　　┃┫┫　┃┫┫
 * 　　　　　　　　　　┗┻┛　┗┻┛+ + + +
 * <p>
 * Created by 史静雯 date
 */
public class DetailsScrollView extends ScrollView {

    private int lastScrollY;
    private OnScrollListener onScrollListener;

    public DetailsScrollView(Context context) {
        super(context, null);
    }

    public DetailsScrollView(Context context, AttributeSet attrs) {
        super(context, attrs, 0);
    }
    public DetailsScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setOnScrollListener(OnScrollListener onScrollListener) {
        this.onScrollListener = onScrollListener;
    }



//    private Handler handler = new Handler() {
//
//            @Override
//            public void handleMessage(Message msg) {
//                super.handleMessage(msg);
//                int scrollY = DetailsScrollView.this.getScrollY();
//
//                if (lastScrollY != scrollY) {
//                    lastScrollY = scrollY;
//                    handler.sendMessageDelayed(handler.obtainMessage(), 5);
//                }
//                if (onScrollListener != null) {
//                    onScrollListener.onScroll(scrollY);
//                }
//            }
//    };
//    public boolean onTouchEvent(MotionEvent ev) {
//        if (onScrollListener != null) {
//            lastScrollY = DetailsScrollView.this.getScrollY();
//            onScrollListener.onScroll(lastScrollY);
//        }
//        switch (ev.getAction()) {
//            case MotionEvent.ACTION_UP:
//                handler.sendMessageDelayed(handler.obtainMessage(), 20);
//                break;
//        }
//        return onTouchEvent(ev);
//    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        int scrollY = t - oldt;
        onScrollListener.onScroll(scrollY);
    }

    public interface OnScrollListener {

        public void onScroll(int scrollY);
    }
}

// 强引用 垃圾回收期绝不会回收他 当内存不足时 则抛出OutOfMemoryError 写法 A a = new A();
// 软引用 内存空间足够时 就不会回收 如果不足 则回收掉 只要没回收 就可以正常使用 SoftReference的特点是一个实例保存
//      对一个Java对象的软引用 ,该软引用的存在不妨碍垃圾收集线程对该Java对象的回收
//      SoftReference<Bitmap> bitmapCache = new SoftReference<Bitmap> (bitmap)
//      常用在cache里面
// 弱引用 垃圾回收器 只要发现软引用的存在 不管内存空间足够与否 都会回收它的内存 与软引用方法一样 只不过是WeakReference
// 虚引用
// 堆内存 数组和对象本身在堆中分配 ,即使程序运行到使用new产生数组或者对象的语句所在的代码块之外,数组和对象本身占据
// 的不存不会被释放 数组和对象在没有引用变量指向他的时候 才会被回收掉内存
// 栈内存 当超过变量的作用域后,Java会自动释放掉为该变量分配的内存空间 该内存空间可以立即被另作他用