package com.xzt.uc;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import static com.xzt.uc.SearchActivity.count;
import static com.xzt.uc.SearchActivity.searchActivity;
import static com.xzt.uc.SearchActivity.webView;
import static com.xzt.uc.UCActivity.ucActivity;
import static com.xzt.uc.WebsiteNavigationActivity.websitenavigationActivity;

/**
 * Created by 谢作通 on 2017/12/13.
 */

public class BottomBar extends LinearLayout
{

    public static ImageButton btn_backward;
    public static ImageButton btn_forward;
    public static ImageButton btn_home;


    public BottomBar(final Context context, AttributeSet attrs)
    //Context需要设为final（不能改变，不能继承），startActivity()是Context里的方法
    {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.bottom_bar_layout, this);

        ImageButton btn_slide_bottom_in_out = (ImageButton) findViewById(R.id.btn_slide_bottom_in_out);
        btn_slide_bottom_in_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context,MenuActivity.class));
            }
        });


        btn_backward = (ImageButton) findViewById(R.id.btn_backward);
        btn_backward.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Log.d("1","bbb");
                Intent intent = new Intent();
                intent.putExtra("data_return","back");
                ucActivity.setResult(ucActivity.RESULT_OK,intent);
                ucActivity.finish();

            }
        });


        btn_forward = (ImageButton) findViewById(R.id.btn_forward);
        btn_forward.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d("1","fff");
                Intent intent = new Intent();
                intent.putExtra("data_return","forward");
                ucActivity.setResult(ucActivity.RESULT_OK,intent);
                ucActivity.finish();
            }
        });


        ImageButton btn_home = (ImageButton) findViewById(R.id.btn_home);
        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if((Activity)context == ucActivity)
                    context.startActivity(new Intent(context,WebsiteNavigationActivity.class));
                else if((Activity)context == websitenavigationActivity)
                    context.startActivity(new Intent(context,UCActivity.class));

            }
        });


    }
}
