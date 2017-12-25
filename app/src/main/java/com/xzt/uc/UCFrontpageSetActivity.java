package com.xzt.uc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class UCFrontpageSetActivity extends AppCompatActivity {

    public static UCFrontpageSetActivity ucFrontpageSetActivity = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ucfrontpage_set_layout);
        ucFrontpageSetActivity = this;
    }
}
