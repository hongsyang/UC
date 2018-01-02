package com.xzt.uc;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import org.litepal.LitePal;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private Button sign_in;

    private Button favorite;

    private Button history;

    private Button download;

    private Button sign_up;

    private ImageButton back;

    private Intent intent;

    public static final int SUCCESSFUL = 1;

    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        //loginHeader =  (LoginHeader)getSupportFragmentManager().findFragmentById(R.id.login_header);
        //loginHeader = new LoginHeader();
        //replaceFragment(loginHeader);
        sign_in = findViewById(R.id.sign_in);
        favorite = findViewById(R.id.user_favorite);
        history = findViewById(R.id.user_history);
        download = findViewById(R.id.user_download);
        sign_up = findViewById(R.id.sign_up);
        back = findViewById(R.id.back);
        sign_in.setOnClickListener(this);
        favorite.setOnClickListener(this);
        history.setOnClickListener(this);
        download.setOnClickListener(this);
        sign_up.setOnClickListener(this);
        back.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.sign_in:

                intent = new Intent(this, SignIn.class);
                startActivityForResult(intent, 1);
                break;
            case R.id.user_favorite:
                //intent = new Intent(this, SignIn.class);
                //startActivity(intent);

                //若未登录，则选择登录或者进入收藏界面，显示所有收藏，若登录，则进入收藏界面，在数据库中查找该用户的收藏，并显示
                break;
            case R.id.user_history:
                //intent = new Intent(this, SignIn.class);
                //startActivity(intent);

                //若未登录，则选择登录或者进入历史界面，显示所有历史，若登录，则进入历史界面，在数据库中查找该用户的历史，并显示
                break;
            case R.id.user_download:
                //intent = new Intent(this, SignIn.class);
                //startActivity(intent);

                //若未登录，则选择登录或者进入下载界面，显示所有下载，若登录，则进入下载界面，在数据库中查找该用户的下载，并显示
                break;
            case R.id.sign_up:
                intent = new Intent(this, SignUp.class);
                startActivity(intent);
                break;
            case R.id.back:
                finish();
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
                    if (status == SUCCESSFUL) {
                        Toast.makeText(this, "登陆成功", Toast.LENGTH_SHORT).show();
                    }
                }
        }
    }

   /* private void replaceFragment(Fragment fragment) {

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();Log.d(TAG, "aaaa");
        transaction.replace(R.id.header, fragment);
        transaction.commit();
    }*/
}
