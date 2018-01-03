package com.xzt.uc;

//该活动对应：关于UC

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class AboutUCActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_uc);

       /* ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.hide();
        }*/

        TextView textView = (TextView) findViewById(R.id.user_protocol);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AboutUCActivity.this,UserProtocolActivity.class);
                startActivity(intent);
            }
        });
    }
}
