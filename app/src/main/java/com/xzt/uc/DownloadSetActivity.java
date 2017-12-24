package com.xzt.uc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class DownloadSetActivity extends AppCompatActivity {

    public static DownloadSetActivity downloadSetActivity = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.download_set_layout);
        downloadSetActivity = this;
    }
}
