package com.lanou.xuhaijia.enjoylife.picture.imagegetter;

import android.content.Context;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.widget.TextView;

import java.io.InputStream;

/**
 * Created by dllo on 16/8/23.
 */
public class HtmlTextView extends TextView {
    public HtmlTextView(Context context) {
        super(context);
    }

    public HtmlTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public HtmlTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    static private String convertStreamToString(InputStream is) {
        java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");

        return s.hasNext() ? s.next() : "";
    }

    public void setHtmlFromString(String html, boolean useLocalDrawables){
        Html.ImageGetter imageGetter;
        if (useLocalDrawables) {
            imageGetter = new LocalImageGetter(getContext());
        } else {
            imageGetter = new UrlImageGetter(this,getContext());
        }

        setText(Html.fromHtml(html, imageGetter, new HtmlTagHandler()));
        setMovementMethod(LinkMovementMethod.getInstance());
    }


}
