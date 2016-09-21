package com.lanou.xuhaijia.enjoylife.news.headline;

import android.content.Intent;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.lanou.xuhaijia.enjoylife.R;
import com.lanou.xuhaijia.enjoylife.base.BaseActivity;

/**
 * Created by 国冰冰 on 16/9/18.
 */
public class HeadLinesContentActivity extends BaseActivity {
    private  WebView webView;
    private String url;

    @Override
    protected int setLayout() {
        return R.layout.activity_news_headlinecontent;
    }

    @Override
    protected void initView() {
        webView = bindView(R.id.activity_news_headlinecontent_web);

    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        url = intent.getStringExtra("headline");
        webView.getSettings().setJavaScriptEnabled(true);
        if ("".equals(intent.getStringExtra("headline"))){
            Toast.makeText(this, "网址好像有问题 稍后重试吧", Toast.LENGTH_SHORT).show();
        }
        webView.loadUrl(url);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                // TODO Auto-generated method stub
                //返回值是true的时候控制去WebView打开，为false调用系统浏览器或第三方浏览器
                view.loadUrl(url);
                return true;
            }
        });


    }

}
