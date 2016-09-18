package com.lanou.xuhaijia.enjoylife.tools;
//                .-~~~~~~~~~-._       _.-~~~~~~~~~-.
//            __.'              ~.   .~              `.__
//          .'//                  \./                   \\`.
//        .'//            为什么坚持  想一想当初             \\`.
//      .'// .-~"""""""~~~~-._     |     _,-~~~~"""""""~-.  \\`.
//    .'//.-"                 `-.  |  .-'                 "-. \\`.
//  .'//______.============-..   \ | /   ..-============._______\\`.
//.'//____________________________\|/_____________________________\\`.
// 
//                             


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

/**
 * Created by 7 on 16/9/7.
 */
public class LoadingLineView extends View {

    int mWidth;
    int mHeight;
    private int halfWidth;
    private int halfHeight;
    private int redOriX;
    private int greenOriX;
    private int blueOriY;
    private int yellowOriY;

    public LoadingLineView(Context context) {
        super(context);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        if (widthMode == MeasureSpec.EXACTLY) {
            mWidth = widthSize;
        } else {
            mWidth = 200;
        }
        if (heightMode == MeasureSpec.EXACTLY) {
            mHeight = heightSize;
        } else {
            mHeight = 200;
        }

        halfWidth = mWidth / 2;
        halfHeight = mHeight / 2;
        redOriX = halfWidth - 100;
        greenOriX = halfWidth + 100;
        blueOriY = halfHeight - 100;
        yellowOriY = halfHeight + 100;
        setMeasuredDimension(mWidth, mHeight);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint mPaintRed = new Paint();
        mPaintRed.setColor(Color.RED);
        mPaintRed.setAntiAlias(true);
        mPaintRed.setStrokeWidth(8);
        Paint mPaintBlue = new Paint();
        mPaintBlue.setColor(Color.BLUE);
        mPaintBlue.setAntiAlias(true);
        mPaintBlue.setStrokeWidth(8);
        Paint mPaintYellow = new Paint();
        mPaintYellow.setColor(Color.YELLOW);
        mPaintYellow.setAntiAlias(true);
        mPaintYellow.setStrokeWidth(8);
        Paint mPaintGreen = new Paint();
        mPaintGreen.setColor(Color.GREEN);
        mPaintGreen.setAntiAlias(true);
        mPaintGreen.setStrokeWidth(8);
        canvas.drawLine(halfWidth - 100, halfHeight + 50,  redOriX  , halfHeight + 50,  mPaintRed);
        canvas.drawLine(halfWidth + 100 , halfHeight - 50 , greenOriX , halfHeight - 50 , mPaintGreen);
        canvas.drawLine(halfWidth - 50 , halfHeight - 100 , halfWidth - 50 , blueOriY , mPaintBlue);
        canvas.drawLine(halfWidth + 50 , halfHeight + 100 , halfWidth + 50 , yellowOriY , mPaintYellow);
        if (redOriX < halfWidth + 100) {
            redOriX++;
            greenOriX--;
            blueOriY++;
            yellowOriY--;
            postInvalidateDelayed(20);
        } else {
            redOriX = halfWidth - 100;
            greenOriX = halfWidth + 100;
            blueOriY = halfHeight - 100;
            yellowOriY = halfHeight + 100;
            postInvalidate();
        }

    }
}
