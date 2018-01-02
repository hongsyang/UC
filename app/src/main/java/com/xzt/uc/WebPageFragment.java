package com.xzt.uc;



import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by T on 2017/12/17.
 */

public class WebPageFragment extends Fragment {
    private View view;
    private LinearLayout linearLayoutWebPage;


    private TextView textView1;
    private TextView textView2;
    private TextView textView3;
    private TextView textView4;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // return super.onCreateView(inflater, container, savedInstanceState);
        view = inflater.inflate(R.layout.tab02,container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        textView1=view.findViewById(R.id.white_background);
        textView2=view.findViewById(R.id.green_background);
        textView3=view.findViewById(R.id.pink_background);
        textView4=view.findViewById(R.id.blue_background);
        linearLayoutWebPage=view.findViewById(R.id.webPageLinear);
        final int LinearLayoutWebPageBackColor=SkinActivity.pref.getInt("linearLayoutWebPageBackColor",0x00ffffff);
        linearLayoutWebPage.setBackgroundColor(LinearLayoutWebPageBackColor);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linearLayoutWebPage.setBackgroundColor(0x00ffffff);//8位数字表示颜色，前两位默认为0表示透明，则不起作用
                SkinActivity.editor.putInt("linearLayoutWebPageBackColor",0x00ffffff);
                SkinActivity.editor.apply();
                Toast.makeText(getContext(),"网页背景色已切换",Toast.LENGTH_LONG).show();
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linearLayoutWebPage.setBackgroundColor(0x50009933);
                SkinActivity.editor.putInt("linearLayoutWebPageBackColor",0x50009933);
                SkinActivity.editor.apply();
                Toast.makeText(getContext(),"网页背景色已切换",Toast.LENGTH_LONG).show();
            }
        });
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linearLayoutWebPage.setBackgroundColor(0x50ff0066);
                SkinActivity.editor.putInt("linearLayoutWebPageBackColor",0x50ff0066);
                SkinActivity.editor.apply();
                Toast.makeText(getContext(),"网页背景色已切换",Toast.LENGTH_LONG).show();
            }
        });
        textView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linearLayoutWebPage.setBackgroundColor(0x500066cc);
                SkinActivity.editor.putInt("linearLayoutWebPageBackColor",0x500066cc);
                SkinActivity.editor.apply();
                Toast.makeText(getContext(),"网页背景色已切换",Toast.LENGTH_LONG).show();
            }
        });

    }
}

