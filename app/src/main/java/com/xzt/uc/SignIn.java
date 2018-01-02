package com.xzt.uc;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import org.litepal.crud.DataSupport;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignIn extends AppCompatActivity implements View.OnClickListener{

    private EditText username;

    private EditText password;

    private Button sign_in;

    private ImageButton back;

    private static final String TAG = "SignIn";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in);
        sign_in = findViewById(R.id.sign_in);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        back = findViewById(R.id.back);
        sign_in.setOnClickListener(this);
        back.setOnClickListener(this);
        username.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Editable u = username.getText();
                Editable pwd = password.getText();
                String username_text = u.toString();
                String regEx = "[^a-zA-Z0-9_]";
                Pattern p = Pattern.compile(regEx);
                Matcher m = p.matcher(username_text);
                String str = m.replaceAll("").trim();
                if (!username_text.equals(str)) {
                    username.setText(str);
                    username.setSelection(str.length());
                }
                if (pwd == null || u.length() < 6 || pwd.length() < 6) {
                    sign_in.setEnabled(false);
                    sign_in.setBackgroundColor(Color.parseColor("#A3D0ED"));
                } else {
                    sign_in.setEnabled(true);
                    sign_in.setBackgroundColor(Color.parseColor("#51ABE4"));
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Editable u = username.getText();
                Editable pwd = password.getText();
                String password_text = pwd.toString();
                String regEx = "[^a-zA-Z0-9_]";
                Pattern p = Pattern.compile(regEx);
                Matcher m = p.matcher(password_text);
                String str = m.replaceAll("").trim();
                if (!password_text.equals(str)) {
                    password.setText(str);
                    password.setSelection(str.length());
                }
                if (u == null || u.length() < 6 || pwd.length() < 6) {
                    sign_in.setEnabled(false);
                    sign_in.setBackgroundColor(Color.parseColor("#A3D0ED"));
                } else {
                    sign_in.setEnabled(true);
                    sign_in.setBackgroundColor(Color.parseColor("#51ABE4"));
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.sign_in:
                String uid = username.getText().toString();
                String pwd = password.getText().toString();

                List<User> users = DataSupport.findAll(User.class);
                for (User user: users) {
                    if (user.getUid().equals(uid)) {
                        if (user.getPassword().equals(pwd)) {
                            Intent intent = new Intent();
                            intent.putExtra("status", LoginActivity.SUCCESSFUL);
                            setResult(RESULT_OK, intent);
                            finish();
                            /*
                            登录成功，设置头像和用户名，返回主界面的登陆状态
                             */
                            return;
                        } else {
                            Toast.makeText(this, "密码错误，请重新输入"
                                    , Toast.LENGTH_SHORT).show();
                            password.setText("");
                        }
                    }
                }
                Toast.makeText(this, "用户不存在", Toast.LENGTH_SHORT).show();
            break;
            case R.id.back:
                finish();
            default:
                break;
        }
    }
}
