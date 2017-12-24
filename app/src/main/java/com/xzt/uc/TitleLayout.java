package com.xzt.uc;



import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by T on 2017/12/11.
 */

public class TitleLayout extends LinearLayout {
    private TextView tv_title;
    public TitleLayout(Context context){
        super(context,null);
    }
    public TitleLayout(final Context context, AttributeSet attrs){
        super(context,attrs);
        LayoutInflater.from(context).inflate(R.layout.title_bar,this);
        Button btnBack=(Button)findViewById(R.id.btnBack);
        Button btnedit=(Button)findViewById(R.id.btnEdit);
        btnBack.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Activity)getContext()).finish();
            }
        });
        tv_title=(TextView)findViewById(R.id.title_name);
    }
    public void setTitle(String title){
        tv_title.setText(title);
    }

}
