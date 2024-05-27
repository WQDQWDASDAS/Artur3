package com.example.artur3;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class WebActivity extends AppCompatActivity {

    WebView webView;

    @SuppressLint("SetJavaScriptEnabled")
    //@SuppressLint("SetJavaScriptEnabled") - це анотація означає щоб не показував попередження про використання методу setJavaScriptEnabled(true) у WebView
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        webView = findViewById(R.id.webView);
        WebSettings webSettings = webView.getSettings();
        //getSettings() - це отримання налаштувань для webView
        webSettings.setJavaScriptEnabled(true);
        webView.loadUrl("https://meteo.ua/ua/34/kiev");
        webView.setWebViewClient(new WebViewClient());
        //Це важливо для того, щоб ваш додаток міг взаємодіяти з вмістом сторінок в WebView так, як ви хочете. Наприклад, ви можете перехоплювати кліки по посиланнях і відкривати їх у тому ж WebView, а не у зовнішньому браузері.
    }
}