package com.lanou.xuhaijia.enjoylife.myself.mugglereply;

import android.graphics.Bitmap;

/**
 * Created by 徐海佳 on 16/9/30.
 */
public class ReplyBean {
    String content;
    int type;
    Bitmap bitmap;
    String url;

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
