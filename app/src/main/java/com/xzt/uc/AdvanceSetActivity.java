package com.xzt.uc;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;



public class AdvanceSetActivity extends AppCompatActivity {

    public static AdvanceSetActivity advanceSetActivity = null;
    private TitleLayout titleLayoutAdvance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.advance_set_layout);
        advanceSetActivity = this;

        ActionBar actionBar=getSupportActionBar();
        if(actionBar!=null){
            actionBar.hide();
        }

        titleLayoutAdvance=(TitleLayout)findViewById(R.id.title_layout_advance);
        titleLayoutAdvance.setTitle("高级设置");
    }
}
