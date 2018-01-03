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
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import org.litepal.crud.DataSupport;

import static com.xzt.uc.MenuActivity.is_full_screen;


public class SettingsActivity extends AppCompatActivity {

    private Button button;
    private SeekBar lightSeek;
    private boolean flag = false;
    private int defalutValue = 75;

    public static SettingsActivity settingsActivity = null;
    private TitleLayout titleLayoutMain;
    private RelativeLayout rotateScreen;
    private String[] rotateScreenList=new String[]{"跟随系统","锁定横屏","锁定竖屏"};
    public static boolean start;//start_open_last_page开关是否开启
    public static boolean not_change_start;
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
        TextView clearLog=(TextView) findViewById(R.id.item14);
        clearLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataSupport.deleteAll(HistoryDatabase.class);
            }
        });
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
                SharedPreferences check_get = getSharedPreferences("isCheck", MODE_PRIVATE);
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
                    Log.d("SettingsActivity", "isCheck2=" + isCheck);
                }

                SharedPreferences.Editor check_save = getSharedPreferences("isCheck", MODE_PRIVATE).edit();
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

        RelativeLayout speed = (RelativeLayout) findViewById(R.id.item0);
        speed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SettingsActivity.this, SpeedActivity.class);
                startActivity(intent);
            }
        });//极速/省流对应的活动

        TextView ad = (TextView) findViewById(R.id.item2);
        ad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SettingsActivity.this, AdActivity.class);
                startActivity(intent);
            }
        });//广告过滤对应的活动

        CheckBox checkBox = (CheckBox) findViewById(R.id.item6_check);
        lightSeek = (SeekBar) findViewById(R.id.item6_seek);
        lightSeek.setOnSeekBarChangeListener(seekBarChange);


        TextView aboutUC = (TextView) findViewById(R.id.item16);
        aboutUC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SettingsActivity.this,AboutUCActivity.class);
                startActivity(intent);
            }
        });//关于UC对应的活动

    }

    //以下是关于亮度的一些方法
    public void System (View v) {
        if (flag) {
            flag = false;
            setScreenLight(defalutValue);
        } else {
            flag = true;

            boolean isAutoBrightness = SystemBrightManager.isAutoBrightness(this);
            if (isAutoBrightness) {  // 自动调整亮度
                SystemBrightManager.setBrightness(this, -1);
            } else {
                int brightValue = SystemBrightManager.getBrightness(this);
                SystemBrightManager.setBrightness(this, brightValue);
            }
        }
    }

    private SeekBar.OnSeekBarChangeListener seekBarChange = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            setScreenLight(progress);
        }
    };

    public void setScreenLight(int progress) {
        if (progress < 1) {
            progress = 1;
        } else if (progress > 255) {
            progress = 255;
        }
        final WindowManager.LayoutParams attrs = getWindow().getAttributes();
        attrs.screenBrightness = progress / 255f;
        getWindow().setAttributes(attrs);
        defalutValue = progress;
    }

}
