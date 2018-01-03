package com.xzt.uc;

import android.Manifest;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class Download extends AppCompatActivity implements View.OnClickListener {

    private Intent intent = null;

    private DownloadService.DownloadBinder downloadBinder;

    private Intent i;

    private Button pause;

    private Button delete;

    private Button start;

    private TextView name;

    private static TextView progress;

    private String url;

    private static ProgressBar progressBar;

    private static final String TAG = "Download";

    private ServiceConnection connection = new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            downloadBinder = (DownloadService.DownloadBinder) iBinder;
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
        }
    };

    private ImageButton back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.download_layout);
        i = getIntent();
        url = i.getStringExtra("url");
        name = (TextView) findViewById(R.id.url);
        name.setText(url);
        back = (ImageButton) findViewById(R.id.backimg);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        start = (Button) findViewById(R.id.button_start);
        pause = (Button) findViewById(R.id.button_pause);
        delete = (Button) findViewById(R.id.button_delete);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progress = (TextView) findViewById(R.id.progress);
        start.setOnClickListener(this);
        pause.setOnClickListener(this);
        delete.setOnClickListener(this);
        intent = new Intent(this, DownloadService.class);
        startService(intent);
        bindService(intent, connection, BIND_AUTO_CREATE);
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[] {Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        }
    }

    @Override
    public void onClick(View view) {
        if (downloadBinder == null) {
            return;
        }

        switch (view.getId()) {
            case R.id.button_start:
                downloadBinder.startDownload(url);
                break;
            case R.id.button_pause:
                downloadBinder.pauseDownload();
                break;
            case R.id.button_delete:
                downloadBinder.cancelDownload();
                progressBar.setProgress(0);
                progress.setText(0 + "%");
                break;
            default:
                break;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 1:
                if (grantResults.length > 0 && grantResults[0] != PackageManager.
                        PERMISSION_GRANTED) {
                    Toast.makeText(this, "拒绝权限将无法使用程序", Toast.LENGTH_SHORT)
                            .show();
                    finish();
                }
                break;
            default:
        }
    }

    public static ProgressBar getProgressBar() {
        return progressBar;
    }

    public static TextView getTextView() {
        return progress;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(connection);
    }
}
