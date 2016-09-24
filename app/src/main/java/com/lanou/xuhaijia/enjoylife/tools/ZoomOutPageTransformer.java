package com.lanou.xuhaijia.enjoylife.tools;

import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;

/**
 * Created by 徐海佳 on 16/9/23.
 */
public class ZoomOutPageTransformer implements ViewPager.PageTransformer  {


    private static final float MIN_SCALE = 0.6f;
    private static final float MIN_ALPHA = 0.7f;

    private static float defaultScale = 0.8f;

    public void transformPage(View view, float position) {
        int pageWidth = view.getWidth();
        int pageHeight = view.getHeight();

        if (position < -1) { // [-Infinity,-1)
            // This page is way off-screen to the left.
            view.setAlpha(0);
            view.setScaleX(defaultScale);
            view.setScaleY(defaultScale);

        } else if (position <= 1) { // [-1,1]
            // Modify the default slide transition to shrink the page as well
            float scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position));
            float vertMargin = pageHeight * (1 - scaleFactor) / 2;
            float horzMargin = pageWidth * (1 - scaleFactor) / 2;
            if (position < 0) {
                view.setTranslationX(horzMargin - vertMargin / 2);
            } else {
                view.setTranslationX(-horzMargin + vertMargin / 2);
            }

            // Scale the page down (between MIN_SCALE and 1)
            view.setScaleX(scaleFactor);
            view.setScaleY(scaleFactor);

            // Fade the page relative to its size.
            view.setAlpha(MIN_ALPHA +
                    (scaleFactor - MIN_SCALE) /
                            (1 - MIN_SCALE) * (1 - MIN_ALPHA));

        } else { // (1,+Infinity]
            // This page is way off-screen to the right.
            view.setAlpha(0);
            view.setScaleX(defaultScale);
            view.setScaleY(defaultScale);
        }

        /**
         * 在 transformPage 方法中, 会传递两个参数,
         且 该View  对应 当前的 position

         从注释中可以看到,
         position 有一下几个区间:
         [-∞ , -1)  :
         表示左边 的View 且已经看不到了
         [-1 ,   0]  :
         表示左边的 View ,且可以看见
         ( 0 ,   1]  :
         表示右边的VIew , 且可以看见了
         ( 1 , -∞)  :
         表示右边的 View 且已经看不见了
         */
    }

}
