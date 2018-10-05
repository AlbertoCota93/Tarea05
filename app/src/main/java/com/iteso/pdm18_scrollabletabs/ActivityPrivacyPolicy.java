package com.iteso.pdm18_scrollabletabs;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;

public class ActivityPrivacyPolicy extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacy_policy);

        WebView webView = findViewById(R.id.activity_privacy);
        webView.loadUrl("file:///android_asset/PrivacyPolicy.html");

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.addJavascriptInterface(new WebAppInterface(this),"Android");

    }
    public class WebAppInterface{
        Context mContext;
        WebAppInterface(Context c){
            mContext = c;
        }
        @JavascriptInterface
            public void showToast(String toast){
            Toast.makeText(mContext,toast, Toast.LENGTH_LONG).show();
        }
    }
}
