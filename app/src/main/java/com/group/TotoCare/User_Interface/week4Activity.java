package com.group.TotoCare.User_Interface;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.group.TotoCare.R;

/**
 * Created by david on 11/7/17.
 */

public class week4Activity extends AppCompatActivity {
    WebView mWebview;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.week4);

        WebView webView = findViewById(R.id.webview);








        webView.setInitialScale(1);
        webView.setWebChromeClient(new WebChromeClient());
        webView.getSettings().setAllowFileAccess(true);
        webView.getSettings().setPluginState(WebSettings.PluginState.ON);
        webView.getSettings().setPluginState(WebSettings.PluginState.ON_DEMAND);
        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setUseWideViewPort(true);
        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        int height = displaymetrics.heightPixels;
        int width = displaymetrics.widthPixels;

        String VIDEO_URL = "https://human.biodigital.com/widget?be=2Ejj&background=255,255,255,51,64,77&dk=cdebb09e9dae744e152efa10c45212aa06fddd34";


        String data_html = "<!DOCTYPE html><html> <head> <meta charset=\"UTF-8\"><meta name=\"viewport\" content=\"target-densitydpi=high-dpi\" /> <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\"> <link rel=\"stylesheet\" media=\"screen and (-webkit-device-pixel-ratio:1.5)\" /></head> <body style=\"background:black;margin:0 0 0 0; padding:0 0 0 0;\"> <iframe style=\"background:black;\" width=' "+width+"' height='"+height+"' src=\""+VIDEO_URL+"\" frameborder=\"0\"></iframe> </body> </html> ";

        webView.loadDataWithBaseURL("https://human.biodigital.com/widget?be=2Ejj&background=255,255,255,51,64,77&dk=cdebb09e9dae744e152efa10c45212aa06fddd34", data_html, "text/html", "UTF-8", null);



    }
}
