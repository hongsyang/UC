package com.xzt.uc;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;

import static com.xzt.uc.MenuActivity.is_full_screen;


public class SettingsActivity extends AppCompatActivity {

    public static SettingsActivity settingsActivity = null;
    private TitleLayout titleLayoutMain;
    private RelativeLayout rotateScreen;
    private String[] rotateScreenList=new String[]{"跟随系统","锁定横屏","锁定竖屏"};
    public static boolean start;//start_open_last_page开关是否开启
    public static Switch start_open_last_page;

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

        setContentView(R.layout.settings_layout);
        settingsActivity = this;

        ActionBar actionBar=getSupportActionBar();
        if(actionBar!=null){
            actionBar.hide();
        }
        titleLayoutMain=(TitleLayout) findViewById(R.id.title_layout_main);
        titleLayoutMain.setTitle("更多设置");
        TextView skinSet=(TextView)findViewById(R.id.item4);
        rotateScreen=(RelativeLayout)findViewById(R.id.item5);
        TextView downloadSet=(TextView)findViewById(R.id.item9);
        start_open_last_page=(Switch) findViewById(R.id.start_open_last_page);
        TextView  UCfrontpageSet=(TextView) findViewById(R.id.item11);
        TextView  advanceSet=(TextView) findViewById(R.id.item12);
        final TextView  item5Text2=(TextView) findViewById(R.id.item5text2);
        skinSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SettingsActivity.this,SkinActivity.class);
                startActivity(intent);
            }
        });
        downloadSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SettingsActivity.this,DownloadSetActivity.class);
                startActivity(intent);
            }
        });


        SharedPreferences start_get = getSharedPreferences("start", MODE_PRIVATE);
        start = start_get.getBoolean("start", false);
        Log.d("SettingsActivity", "start3=" + start);
        if(start)
            start_open_last_page.setChecked(true);
        else
            start_open_last_page.setChecked(false);


        start_open_last_page.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isCheck)
            {
                SharedPreferences check_get = getSharedPreferences("check", MODE_PRIVATE);
                isCheck = check_get.getBoolean("isCheck", false);
                Log.d("SettingsActivity", "isCheck=" + isCheck);
                if(isCheck)
                {
                    start = false;
                    Log.d("SettingsActivity", "start1=" + start);
                }
                else
                {
                    start = true;
                    Log.d("SettingsActivity", "start2=" + start);
                }

                SharedPreferences.Editor check_save = getSharedPreferences("check", MODE_PRIVATE).edit();
                check_save.putBoolean("isCheck", isCheck);
                check_save.apply();
                SharedPreferences.Editor start_save = getSharedPreferences("start", MODE_PRIVATE).edit();
                start_save.putBoolean("start", start);
                start_save.apply();
            }
        });
        UCfrontpageSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SettingsActivity.this,UCFrontpageSetActivity.class);
                startActivity(intent);
            }
        });
        advanceSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SettingsActivity.this,AdvanceSetActivity.class);
                startActivity(intent);
            }
        });
        rotateScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(SettingsActivity.this).setItems(rotateScreenList, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        item5Text2.setText(rotateScreenList[which]);
                        if (which==0){
                            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
                        }
                        if(which==1){
                            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                        }
                        if(which==2){
                            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                        }
                        dialog.dismiss();
                    }
                }).show();
            }
        });
    }
}
