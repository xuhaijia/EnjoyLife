package com.lanou.xuhaijia.enjoylife.picture.imagegetter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.widget.TextView;

import com.lanou.xuhaijia.enjoylife.base.NetTool;

import java.util.concurrent.ExecutionException;


/**
 * Created by dllo on 16/8/23.
 */
public class UrlImageGetter implements Html.ImageGetter {
    Context c;
    TextView container;
    int width;
    private float scaleWidth;

    /**
     * @param t
     * @param c
     */
    public UrlImageGetter(TextView t, Context c) {
        this.c = c;
        this.container = t;
        width = c.getResources().getDisplayMetrics().widthPixels;
    }

    @Override
    public Drawable getDrawable(String source) {
        final UrlDrawable urlDrawable = new UrlDrawable();
        NetTool netTool = new NetTool();
        try {
            netTool.getImage(source, new NetTool.GetBitMap() {
                @Override
                public void getBitMap(Bitmap bitmap) {
                    if (bitmap != null){
                        scaleWidth = ((float) width) / bitmap.getWidth();
                    }

                    Matrix matrix = new Matrix();
                    matrix.postScale(scaleWidth, scaleWidth);
                    bitmap = Bitmap.createBitmap(bitmap, 0, 0,
                            bitmap.getWidth(), bitmap.getHeight(),
                            matrix, true);
                    urlDrawable.bitmap = bitmap;
                    urlDrawable.setBounds(0, 0, bitmap.getWidth(),
                            bitmap.getHeight());
                    container.invalidate();
                    container.setText(container.getText());
                }
            });
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return urlDrawable;
    }


    @SuppressWarnings("deprecation")
    public class UrlDrawable extends BitmapDrawable {
        protected Bitmap bitmap;

        @Override
        public void draw(Canvas canvas) {

            if (bitmap != null) {
                canvas.drawBitmap(bitmap, 0, 0, getPaint());
            }
        }
    }
}