package com.xzt.uc;

//该活动对应：关于UC->用户协议

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class UserProtocolActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_protocol);
        TextView first = (TextView) findViewById(R.id.view1);
        TextView second = (TextView) findViewById(R.id.view2);
        TextView third = (TextView) findViewById(R.id.view3);
        first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserProtocolActivity.this,FirstActivity.class);
                startActivity(intent);
            }
        });

        second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserProtocolActivity.this,SecondActivity.class);
                startActivity(intent);
            }
        });

        third.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserProtocolActivity.this,ThirdActivity.class);
                startActivity(intent);
            }
        });
    }
}
