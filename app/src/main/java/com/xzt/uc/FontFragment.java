package com.xzt.uc;



import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by T on 2017/12/17.
 */

public class FontFragment extends Fragment {
    private View view;
    private LinearLayout fontLinear1;
    private LinearLayout fontLinear2;
    private LinearLayout fontLinear3;
    private LinearLayout fontLinear4;
    private TextView fontGou1;
    private TextView fontGou2;
    private TextView fontGou3;
    private TextView fontGou4;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // return super.onCreateView(inflater, container, savedInstanceState);
        view=inflater.inflate(R.layout.tab03,container,false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //刚开始写错了linearLayout布局类型，没报错，但出错一堆，谨记
        fontLinear1=(LinearLayout) view.findViewById(R.id.fontLinear1);
        fontLinear2=(LinearLayout)view.findViewById(R.id.fontLinear2);
        fontLinear3=(LinearLayout)view.findViewById(R.id.fontLinear3);
        fontLinear4=(LinearLayout)view.findViewById(R.id.fontLinear4);
        fontGou1=(TextView)view.findViewById(R.id.font_gou1);
        fontGou2=(TextView)view.findViewById(R.id.font_gou2);
        fontGou3=(TextView)view.findViewById(R.id.font_gou3);
        fontGou4=(TextView)view.findViewById(R.id.font_gou4);

        //MainActivity.typeface= Typeface.createFromAsset(MainActivity.mgr,"fonts/song.ttf");
        //typeface1=Typeface.createFromAsset(mgr,"fonts/sweat_heart.ttf");
        //typeface2=Typeface.createFromAsset(mgr,"fonts/xiao_wei.ttf");
        //typeface3=Typeface.createFromAsset(mgr,"fonts/qi.ttf");
        final int FontGou1=SkinActivity.pref.getInt("fontGou1",R.drawable.zi_dui);
        final int FontGou2=SkinActivity.pref.getInt("fontGou2",R.drawable.whitebackground);
        final int FontGou3=SkinActivity.pref.getInt("fontGou3",R.drawable.whitebackground);
        final int FontGou4=SkinActivity.pref.getInt("fontGou4",R.drawable.whitebackground);
        final String TypeF=SkinActivity.pref.getString("typeF","fonts/song.ttf");


        fontGou1.setBackgroundResource(FontGou1);
        fontGou2.setBackgroundResource(FontGou2);
        fontGou3.setBackgroundResource(FontGou3);
        fontGou4.setBackgroundResource(FontGou4);


        fontLinear1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SkinActivity.editor.putInt("fontGou1",R.drawable.zi_dui);
                SkinActivity.editor.putInt("fontGou2",R.drawable.whitebackground);
                SkinActivity.editor.putInt("fontGou3",R.drawable.whitebackground);
                SkinActivity.editor.putInt("fontGou3",R.drawable.whitebackground);
                SkinActivity.editor.putString("typeF","fonts/song.ttf");
                SkinActivity.editor.apply();

                fontGou1.setBackgroundResource(R.drawable.zi_dui);
                fontGou2.setBackgroundResource(R.drawable.whitebackground);
                fontGou3.setBackgroundResource(R.drawable.whitebackground);
                fontGou4.setBackgroundResource(R.drawable.whitebackground);

                SkinActivity.titleNameDress.setTypeface(SkinActivity.typeface4);
                SkinActivity.textWallPaper.setTypeface(SkinActivity.typeface4);
                SkinActivity.textWebPage.setTypeface(SkinActivity.typeface4);
                SkinActivity.textFont.setTypeface(SkinActivity.typeface4);
                SkinActivity.phonePictureT.setTypeface(SkinActivity.typeface4);
                SkinActivity.editWallPaperT.setTypeface(SkinActivity.typeface4);

            }
        });
        fontLinear2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SkinActivity.editor.putInt("fontGou2",R.drawable.zi_dui);
                SkinActivity.editor.putInt("fontGou1",R.drawable.whitebackground);
                SkinActivity.editor.putInt("fontGou3",R.drawable.whitebackground);
                SkinActivity.editor.putInt("fontGou4",R.drawable.whitebackground);
                SkinActivity.editor.putString("typeF","fonts/sweat_heart.ttf");
                SkinActivity.editor.apply();
                fontGou2.setBackgroundResource(R.drawable.zi_dui);
                fontGou1.setBackgroundResource(R.drawable.whitebackground);
                fontGou3.setBackgroundResource(R.drawable.whitebackground);
                fontGou4.setBackgroundResource(R.drawable.whitebackground);

                SkinActivity.titleNameDress.setTypeface(SkinActivity.typeface1);
                SkinActivity.textWallPaper.setTypeface(SkinActivity.typeface1);
                SkinActivity.textWebPage.setTypeface(SkinActivity.typeface1);
                SkinActivity.textFont.setTypeface(SkinActivity.typeface1);
                SkinActivity.phonePictureT.setTypeface(SkinActivity.typeface1);
                SkinActivity.editWallPaperT.setTypeface(SkinActivity.typeface1);

            }
        });
        fontLinear3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SkinActivity.editor.putInt("fontGou3",R.drawable.zi_dui);
                SkinActivity.editor.putInt("fontGou1",R.drawable.whitebackground);
                SkinActivity.editor.putInt("fontGou2",R.drawable.whitebackground);
                SkinActivity.editor.putInt("fontGou4",R.drawable.whitebackground);
                SkinActivity.editor.putString("typeF","fonts/xiao_wei.ttf");
                SkinActivity.editor.apply();
                fontGou3.setBackgroundResource(R.drawable.zi_dui);
                fontGou1.setBackgroundResource(R.drawable.whitebackground);
                fontGou2.setBackgroundResource(R.drawable.whitebackground);
                fontGou4.setBackgroundResource(R.drawable.whitebackground);
                SkinActivity.titleNameDress.setTypeface(SkinActivity.typeface2);
                SkinActivity.textWallPaper.setTypeface(SkinActivity.typeface2);
                SkinActivity.textWebPage.setTypeface(SkinActivity.typeface2);
                SkinActivity.textFont.setTypeface(SkinActivity.typeface2);
                SkinActivity.phonePictureT.setTypeface(SkinActivity.typeface2);
                SkinActivity.editWallPaperT.setTypeface(SkinActivity.typeface2);
            }
        });
        fontLinear4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //fontGou4.setVisibility(View.VISIBLE);不适合这样用
                SkinActivity.editor.putInt("fontGou4",R.drawable.zi_dui);
                SkinActivity.editor.putInt("fontGou2",R.drawable.whitebackground);
                SkinActivity.editor.putInt("fontGou3",R.drawable.whitebackground);
                SkinActivity.editor.putInt("fontGou1",R.drawable.whitebackground);
                SkinActivity.editor.putString("typeF","fonts/qi.ttf");
                SkinActivity.editor.apply();
                fontGou4.setBackgroundResource(R.drawable.zi_dui);
                fontGou2.setBackgroundResource(R.drawable.whitebackground);
                fontGou3.setBackgroundResource(R.drawable.whitebackground);
                fontGou1.setBackgroundResource(R.drawable.whitebackground);
                SkinActivity.titleNameDress.setTypeface(SkinActivity.typeface3);
                SkinActivity.textWallPaper.setTypeface(SkinActivity.typeface3);
                SkinActivity.textWebPage.setTypeface(SkinActivity.typeface3);
                SkinActivity.textFont.setTypeface(SkinActivity.typeface3);
                SkinActivity.phonePictureT.setTypeface(SkinActivity.typeface3);
                SkinActivity.editWallPaperT.setTypeface(SkinActivity.typeface3);
            }
        });


    }
}
