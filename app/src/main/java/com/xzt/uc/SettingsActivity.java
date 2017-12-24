package com.xzt.uc;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;



public class SettingsActivity extends AppCompatActivity {

    public static SettingsActivity settingsActivity = null;
    private TitleLayout titleLayoutMain;
    private RelativeLayout rotateScreen;
    private String[] rotateScreenList=new String[]{"跟随系统","锁定横屏","锁定竖屏"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
        TextView  webpageScanSet=(TextView) findViewById(R.id.item10);
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
        webpageScanSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SettingsActivity.this,WebpageScanSetActivity.class);
                startActivity(intent);
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
