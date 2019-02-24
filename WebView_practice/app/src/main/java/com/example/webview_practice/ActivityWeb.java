package com.example.webview_practice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class ActivityWeb extends AppCompatActivity {

     WebView wv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        wv1 = (WebView) findViewById(R.id.Wview1);

        String url = getIntent().getStringExtra("sitioWeb");

        wv1.setWebViewClient(new WebViewClient());
        wv1.loadUrl("http://" + url);

    }
}
