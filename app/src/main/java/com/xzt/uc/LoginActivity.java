package com.xzt.uc;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private Button favorite;

    private Button history;

    private Button download;

    private Button sign_up;

    private ImageButton back;

    private Intent intent;

    private LoginHeader loginHeader = null;

    public static User user = null;

    public static final int SUCCESSFUL = 1;

    public static final int EXIT = 2;

    private static final String TAG = "LoginActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        loginHeader = new LoginHeader();
        replaceFragment(loginHeader);
        favorite = findViewById(R.id.user_favorite);
        history = findViewById(R.id.user_history);
        download = findViewById(R.id.user_download);
        sign_up = findViewById(R.id.sign_up);
        favorite.setOnClickListener(this);
        history.setOnClickListener(this);
        download.setOnClickListener(this);
        sign_up.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.user_favorite:
                intent = new Intent(this, FavoriteAndHistoryActivity.class);
                startActivity(intent);
                break;
            case R.id.user_history:
                intent = new Intent(this, FavoriteAndHistoryActivity.class);
                startActivity(intent);
                break;
            case R.id.user_download:
                intent = new Intent(this, Download.class);
                startActivity(intent);
                break;
            case R.id.sign_up:
                intent = new Intent(this, SignUp.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    int status = data.getIntExtra("status", 0);
                    user = (User) data.getSerializableExtra("user");
                    if (status == LoginActivity.SUCCESSFUL) {
                        Toast.makeText(this, "登陆成功", Toast.LENGTH_SHORT).show();
                        replaceFragment(new UserHeader());
                    }
                }
            case 2:
                if (resultCode == RESULT_OK) {
                    int status = data.getIntExtra("status", 0);
                    if (status == LoginActivity.EXIT) {
                        Toast.makeText(this, "已退出", Toast.LENGTH_SHORT).show();
                        replaceFragment(new LoginHeader());
                    }
                }
        }
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.header, fragment);
        transaction.commit();
    }
}
