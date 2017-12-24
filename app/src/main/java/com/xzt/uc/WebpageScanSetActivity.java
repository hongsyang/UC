package com.xzt.uc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class WebpageScanSetActivity extends AppCompatActivity {

    public static WebpageScanSetActivity webpageScanSetActivity = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webpage_scan_set_layout);
        webpageScanSetActivity = this;
    }
}
