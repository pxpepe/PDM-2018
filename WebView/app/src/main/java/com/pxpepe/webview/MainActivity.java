package com.pxpepe.webview;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WebView myWebView = (WebView) findViewById(R.id.webView);
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        String urlAbrir = "http://www.example.com";

        Intent httpIntent = getIntent();
        String action = httpIntent.getAction();
        if (action!=null && action.equals(Intent.ACTION_VIEW)) {

            Uri data = httpIntent.getData();
            if (data!=null) {
                urlAbrir=data.toString();
            }

        }

        myWebView.loadUrl(urlAbrir);

    }
}
