package com.lanou.xuhaijia.enjoylife.picture.details;

import android.os.Handler;
import android.os.Message;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.text.style.ImageSpan;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.TextView;


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
public class ImagegetterShow extends LinkMovementMethod {

    private static LinkMovementMethod sInstance;
    private Handler handler = null;
    private Class spanClass = null;

    public static MovementMethod getInstance(Handler _handler, Class _spanClass) {
        if (sInstance == null) {
            sInstance = new ImagegetterShow();
            ((ImagegetterShow) sInstance).spanClass = _spanClass;
            ((ImagegetterShow) sInstance).handler = _handler;

        }
        return sInstance;
    }

    int x1;
    int x2;
    int y1;
    int y2;

    public boolean onTouchEvent(TextView widget, Spannable buffer, MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            x1 = (int) event.getX();
            y1 = (int) event.getY();
        }

        if (event.getAction() == MotionEvent.ACTION_UP){
            x2 = (int) event.getX();
            y2 = (int) event.getY();
            if (Math.abs(x1 - x2) < 10 && Math.abs(y1 - y2) < 10){
                x2 -= widget.getTotalPaddingLeft();
                y2 -= widget.getTotalPaddingTop();
                x2 += widget.getScrollX();
                y2 += widget.getScrollY();
                Layout layout = widget.getLayout();
                int line = layout.getLineForVertical(y2);
                int off = layout.getOffsetForHorizontal(line,x2);

                Object[] spans = buffer.getSpans(off,off,spanClass);
                if (spans.length != 0){
                    Selection.setSelection(buffer,buffer.getSpanStart(spans[0]),
                            buffer.getSpanEnd(spans[0]));
                    MessageSpan span = new MessageSpan();
                    span.setObj(spans);
                    span.setView(widget);
                    Message message = handler.obtainMessage();
                    message.obj = span;
                    message.what = 200;
                    message.sendToTarget();
                    return true;

                }
            }
        }
        return super.onTouchEvent(widget,buffer,event);
    }

    public class MessageSpan{
        private Object obj;
        private TextView view;

        public Object getObj() {
            return obj;
        }

        public void setObj(Object obj) {
            this.obj = obj;
        }

        public TextView getView() {
            return view;
        }

        public void setView(TextView view) {
            this.view = view;
        }
    }


}
