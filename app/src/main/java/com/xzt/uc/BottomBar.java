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
import android.widget.Toast;

import static com.xzt.uc.SearchActivity.count;
import static com.xzt.uc.SearchActivity.cur;
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
                if((Activity)context == searchActivity)
                {
                    if(!webView.ca"不",Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(contnGoBack()){
                        Toast.makeText(context,ext,UCActivity.class);
                        context.startActivity(intent);
                       // SearchActivity.cur = SearchActivity.Link.head;
                    }else if(cur.getPre().getData().equals("home"))
                    {
                        Intent intent=new Intent(context,UCActivity.class);
                        context.startActivity(intent);
                        cur = cur.getPre();
                    }
                    else{
                        cur = cur.getPre();

                        webView.loadUrl((String)cur.getData());
                    }
                }
                else if((Activity)context == ucActivity){
                    Toast.makeText(context,"已不能再",Toast.LENGTH_SHORT).show();
                    if(((URL)cur.getPre().getData()).getAddress().equals(""))
                    {
                        Toast.makeText(context,"已不能再后退",Toast.LENGTH_SHORT).show();
                    } else
                    {
                        Toast.makeText(context,"已",Toast.LENGTH_SHORT).show();
                        ucActivity.finish();
                        cur = cur.getPre();
                        searchActivity.tag =0;
                       // webView.loadUrl((String)cur.getData());
                    }

                }

            }
        });


        btn_forward = (ImageButton) findViewById(R.id.btn_forward);
        if(cur.getNext() == null)
        {
            //Toast.makeText(context,"已不能再前进",Toast.LENGTH_SHORT).show();
            btn_forward.setEnabled(false);
        }
        btn_forward.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if((Activity)context == searchActivity)
                {
                   cur =cur.getNext();
                   if(cur.getData().equals("home"))
                   {
                       Intent intent=new Intent(context,UCActivity.class);
                       context.startActivity(intent);
                   }else
                   {
                       searchActivity.tag =0;
                       webView.loadUrl((String)cur.getData());
                   }
                }
                else{
                    cur =cur.getNext();
                    searchActivity.tag =0;
                    webView.loadUrl((String)cur.getData());
                }
            }
        });


        ImageButton btn_home = (ImageButton) findViewById(R.id.btn_home);
        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if((Activity)context == ucActivity)
                {
                    context.startActivity(new Intent(context,WebsiteNavigationActivity.class));
                    ((Activity) context).finish();
                }
                else if((Activity)context == websitenavigationActivity){
                    context.startActivity(new Intent(context,UCActivity.class));
                    ((Activity) context).finish();
                }else if((Activity)context == searchActivity)
                {
                    Node<URL> tem ;
                    tem = cur;
                    int position = 0;
                    while(tem.getPre() != null)
                    {
                        tem=tem.getPre();
                        position++;
                    }

                    searchActivity.Link.insert(new URL("home"),position);
                    cur = searchActivity.Link.getNode(position+1);

                    Intent intent=new Intent(context,UCActivity.class);
                    context.startActivity(intent);
                }

            }
        });

    }
}
