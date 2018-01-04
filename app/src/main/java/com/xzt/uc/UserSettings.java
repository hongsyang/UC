package com.xzt.uc;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class UserSettings extends AppCompatActivity implements View.OnClickListener {

    private Button exit;

    private ImageButton back;

    private RelativeLayout changeNickname;

    private TextView nickname;

    private RelativeLayout changeSex;

    private TextView sex;

    private RelativeLayout changePhoneNumber;

    private TextView phone_number;

    private AlertDialog ad;

    String[] gender = new String[]{"男", "女"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_settings);
        back = findViewById(R.id.settings_back);
        exit = findViewById(R.id.exit);
        sex = findViewById(R.id.sex);
        phone_number = findViewById(R.id.phone_number);
        changeSex = findViewById(R.id.change_sex);
        changePhoneNumber = findViewById(R.id.change_phone_number);
        changeNickname = findViewById(R.id.change_nickname);
        nickname = findViewById(R.id.nickname);
        exit.setOnClickListener(this);
        back.setOnClickListener(this);
        changeSex.setOnClickListener(this);
        changePhoneNumber.setOnClickListener(this);
        changeNickname.setOnClickListener(this);
        sex.setText(gender[LoginActivity.user.getGender()]);
        phone_number.setText(LoginActivity.user.getNumber());
        nickname.setText(LoginActivity.user.getNickname());
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.change_nickname:
                final EditText inputName = new EditText(this);
                inputName.setFocusable(true);
                ad = new AlertDialog.Builder(this)
                        .setTitle("输入昵称")
                        .setCancelable(false)
                        .setView(inputName)
                        .setPositiveButton("OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,int id) {
                                        String input = inputName.getText().toString();
                                        nickname.setText(input);
                                        LoginActivity.user.setNickname(input);
                                        LoginActivity.user.save();
                                    }
                                })
                        .setNegativeButton("Cancel",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,int id) {
                                        dialog.cancel();
                                    }
                                }).create();
                ad.show();
                break;
            case R.id.change_sex:
                RadioOnClick radioOnClick = new RadioOnClick(LoginActivity.user.getGender());
                ad = new AlertDialog.Builder(this).setTitle("选择性别")
                        .setSingleChoiceItems(gender,
                                radioOnClick.getIndex(), radioOnClick).create();
                ad.show();
                break;
            case R.id.change_phone_number:
                final EditText inputServer = new EditText(this);
                inputServer.setFocusable(true);
                inputServer.setInputType(InputType.TYPE_CLASS_PHONE);
                ad = new AlertDialog.Builder(this)
                        .setTitle("输入号码")
                        .setCancelable(false)
                        .setView(inputServer)
                        .setPositiveButton("OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,int id) {
                                        String input = inputServer.getText().toString();
                                        phone_number.setText(input);
                                        LoginActivity.user.setNumber(input);
                                        LoginActivity.user.save();
                                    }
                                })
                        .setNegativeButton("Cancel",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,int id) {
                                        dialog.cancel();
                                    }
                                }).create();
                ad.show();
                break;
            case R.id.exit:
                Intent intent = new Intent();
                intent.putExtra("status", LoginActivity.EXIT);
                setResult(RESULT_OK, intent);
                finish();
                break;
            case R.id.settings_back:
                finish();
                break;
        }
    }

    class RadioOnClick implements DialogInterface.OnClickListener{
        private int index;

        public RadioOnClick(int index){
            this.index = index;
        }
        public void setIndex(int index){
            this.index=index;
        }
        public int getIndex(){
            return index;
        }

        public void onClick(DialogInterface dialog, int whichButton){
            setIndex(whichButton);
            sex.setText(gender[index]);
            LoginActivity.user.setGender(index);
            LoginActivity.user.save();
            dialog.dismiss();
        }
    }
}
