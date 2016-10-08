package com.lanou.xuhaijia.enjoylife.myself.mugglereply;

import android.content.Intent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.lanou.xuhaijia.enjoylife.R;
import com.lanou.xuhaijia.enjoylife.base.BaseActivity;

/**
 * Created by 徐海佳 on 16/10/8.
 */
public class WebViewAty extends BaseActivity {

    private WebView webView;
    private String url;

    @Override
    protected int setLayout() {

        return R.layout.activity_webview;
    }

    @Override
    protected void initView() {
        Intent intent = getIntent();
        url = intent.getStringExtra("url");
        webView = bindView(R.id.activity_webview);
    }

    @Override
    protected void initData() {
        webView.setWebViewClient(new WebViewClient());
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        WebChromeClient webChromeClient = new WebChromeClient() {
            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
//                titleTv.setText(title);
            }

            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);

            }
        };
        webView.setWebChromeClient(webChromeClient);
        webView.loadUrl(url);
    }
}
