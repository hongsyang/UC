package com.xzt.uc;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import static com.xzt.uc.MenuActivity.is_full_screen;


public class AdvanceSetActivity extends AppCompatActivity {

    public static AdvanceSetActivity advanceSetActivity = null;
    private TitleLayout titleLayoutAdvance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences full_screen_get = getSharedPreferences("full_screen", MODE_PRIVATE);
        is_full_screen = full_screen_get.getBoolean("full_screen", false);
        if(is_full_screen)
        {
            //取消标题
            requestWindowFeature(Window.FEATURE_NO_TITLE);
            //取消状态栏
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }

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
