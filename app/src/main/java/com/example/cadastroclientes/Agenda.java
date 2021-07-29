package com.example.cadastroclientes;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Agenda extends AppCompatActivity {
    WebView wVAgenda;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agenda);

        wVAgenda = findViewById(R.id.wVAgenda);

        wVAgenda.getSettings().setJavaScriptEnabled(true);
        String urlSite = "https://www.franquiabv.com.br";
        wVAgenda.loadUrl(urlSite);

        wVAgenda.setWebViewClient( new WebViewClient(){

                                       @Override
                                       public void onPageStarted(WebView view, String url, Bitmap favicon) {
                                           super.onPageStarted(view, url, favicon);
                                       }

                                       @Override
                                       public void onPageFinished(WebView view, String url) {
                                           super.onPageFinished(view, url);
                                       }

                                       @Override
                                       public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                                           super.onReceivedError(view, request, error);
                                       }
                                   }
        );

    }

}