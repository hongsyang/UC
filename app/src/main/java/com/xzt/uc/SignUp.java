package com.xzt.uc;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import org.litepal.crud.DataSupport;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignUp extends AppCompatActivity implements View.OnClickListener {

    private EditText username;

    private EditText password;

    private EditText conform_password;

    private Button sign_up;

    private CheckBox checkBox;

    private ImageButton back;

    private static final String TAG = "SignUp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);
        sign_up = findViewById(R.id.sign_up);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        conform_password = findViewById(R.id.conform_password);
        checkBox = findViewById(R.id.checkBox);
        back = findViewById(R.id.back);
        sign_up.setOnClickListener(this);
        back.setOnClickListener(this);
        username.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Editable u = username.getText();
                Editable pwd = password.getText();
                Editable c = conform_password.getText();
                String username_text = u.toString();
                String regEx = "[^a-zA-Z0-9_]";
                Pattern p = Pattern.compile(regEx);
                Matcher m = p.matcher(username_text);
                String str = m.replaceAll("").trim();
                if (!username_text.equals(str)) {
                    username.setText(str);
                    username.setSelection(str.length());
                }
                if (pwd == null || c == null || u.length() < 6
                        || pwd.length() < 6 || c.length() < 6 || !checkBox.isChecked()) {
                    sign_up.setEnabled(false);
                    sign_up.setBackgroundColor(Color.parseColor("#A3D0ED"));
                } else {
                    sign_up.setEnabled(true);
                    sign_up.setBackgroundColor(Color.parseColor("#51ABE4"));
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
                Editable c = conform_password.getText();
                String password_text = pwd.toString();
                String regEx = "[^a-zA-Z0-9_]";
                Pattern p = Pattern.compile(regEx);
                Matcher m = p.matcher(password_text);
                String str = m.replaceAll("").trim();
                if (!password_text.equals(str)) {
                    password.setText(str);
                    password.setSelection(str.length());
                }
                if (u == null || c == null || u.length() < 6
                        || pwd.length() < 6 || c.length() < 6 || !checkBox.isChecked()) {
                    sign_up.setEnabled(false);
                    sign_up.setBackgroundColor(Color.parseColor("#A3D0ED"));
                } else {
                    sign_up.setEnabled(true);
                    sign_up.setBackgroundColor(Color.parseColor("#51ABE4"));
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        conform_password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Editable u = username.getText();
                Editable pwd = password.getText();
                Editable c = conform_password.getText();
                String conform_password_text = c.toString();
                String regEx = "[^a-zA-Z0-9_]";
                Pattern p = Pattern.compile(regEx);
                Matcher m = p.matcher(conform_password_text);
                String str = m.replaceAll("").trim();
                if (!conform_password_text.equals(str)) {
                    conform_password.setText(str);
                    conform_password.setSelection(str.length());
                }
                if (u == null || pwd == null || u.length() < 6
                        || pwd.length() < 6 || c.length() < 6 || !checkBox.isChecked()) {
                    sign_up.setEnabled(false);
                    sign_up.setBackgroundColor(Color.parseColor("#A3D0ED"));
                } else {
                    sign_up.setEnabled(true);
                    sign_up.setBackgroundColor(Color.parseColor("#51ABE4"));
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Editable u = username.getText();
                Editable pwd = password.getText();
                Editable c = conform_password.getText();
                if (u == null || pwd == null || c == null || u.length() < 6
                        || pwd.length() < 6 || c.length() < 6 || !checkBox.isChecked()) {
                    sign_up.setEnabled(false);
                    sign_up.setBackgroundColor(Color.parseColor("#A3D0ED"));
                } else {
                    sign_up.setEnabled(true);
                    sign_up.setBackgroundColor(Color.parseColor("#51ABE4"));
                }
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.sign_up:
                String id = username.getText().toString();
                String pwd = password.getText().toString();
                String c = conform_password.getText().toString();

                List<User> users = DataSupport.findAll(User.class);
                for (User user: users) {
                    if (user.getUid().equals(id)) {
                        if (user.getPassword().equals(pwd)) {
                            Toast.makeText(this, "用户名已存在",
                                    Toast.LENGTH_SHORT).show();
                            return;
                        }
                    }
                }
                if (pwd.equals(c)) {
                    User user = new User();
                    user.setUid(id);
                    user.setPassword(pwd);
                    user.save();
                    Log.d(TAG, user.getUid());
                    Log.d(TAG, user.getPassword());
                    Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
                    /*
                    进入登录界面
                    */
                } else {
                    Toast.makeText(this, "两次输入密码不相同", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.back:
                finish();
            default:
                break;
        }
    }
}
