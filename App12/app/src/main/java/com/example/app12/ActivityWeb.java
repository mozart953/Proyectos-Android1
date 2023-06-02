package com.example.app12;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class ActivityWeb extends AppCompatActivity {

    WebView wv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        wv1 = (WebView) findViewById(R.id.Wv1);

        String URL = getIntent().getStringExtra("web");
        wv1.setWebViewClient(new WebViewClient());
        wv1.loadUrl("http://"+URL);

    }

    public void Cerrar(View view){
        finish();
    }
}