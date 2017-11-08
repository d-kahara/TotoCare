package com.group.TotoCare.User_Interface;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import com.group.TotoCare.R;

public class week32Activity extends AppCompatActivity {
    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week32);
        webView = findViewById(R.id.webView_week32);
    }
}
