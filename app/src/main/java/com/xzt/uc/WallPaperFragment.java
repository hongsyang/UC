package com.xzt.uc;



import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/**
 * Created by T on 2017/12/17.
 */

public class WallPaperFragment extends Fragment {

    private View view;
    private Typeface typeface1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // return super.onCreateView(inflater, container, savedInstanceState);
        view = inflater.inflate(R.layout.tab01,container, false);
        return view;

    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //更换字体
        //MainActivity.titleNameDress.setTypeface(MainActivity.typeface);


        ImageButton pinkWallPaper =view.findViewById(R.id.pinkWallPaperT);
        ImageButton blueWallPaper=view.findViewById(R.id.blueWallPaperT);
        ImageButton blackWallPaper=view.findViewById(R.id.blackWallPaperT);
        ImageButton angleWallPaper=view.findViewById(R.id.angle_babyWallPaperT);
        final int PersonalDecorateLDrawable=SkinActivity.pref.getInt("personalDecorateLDrawable",R.drawable.whitebackground);
        final int TopLDrawable=SkinActivity.pref.getInt("topLDrawable",R.drawable.blue_two);
        final int ButtonBackDressDrawable=SkinActivity.pref.getInt("buttonBackDressDrawable",R.drawable.blue_triangle_three);
        final int TitleNameDressDrawable=SkinActivity.pref.getInt("titleNameDressDrawable",R.drawable.blue_two);
        final int BtnEditDressDrawable=SkinActivity.pref.getInt("btnEditDressDrawable",R.drawable.coat);
        SkinActivity.personalDecorateL.setBackgroundResource(PersonalDecorateLDrawable);
        SkinActivity.topL.setBackgroundResource(TopLDrawable);
        SkinActivity.buttonBackDress.setBackgroundResource(ButtonBackDressDrawable);
        SkinActivity.titleNameDress.setBackgroundResource(TitleNameDressDrawable);
        SkinActivity.btnEditDress.setBackgroundResource(BtnEditDressDrawable);

        pinkWallPaper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //MainActivity.buttonBackDress.getBackground().setAlpha(50);
                //MainActivity.btnEditDress.getBackground().setAlpha(50);
                //MainActivity.titleNameDress.getBackground().setAlpha(50);


                //MainActivity.personalDecorateL.setBackgroundResource(PersonalDecorateLDrawable);
                SkinActivity.editor.putInt("topLDrawable",R.drawable.pink);
                SkinActivity.editor.putInt("buttonBackDressDrawable",R.drawable.pink_triangle);
                SkinActivity.editor.putInt("titleNameDressDrawable",R.drawable.pink);
                SkinActivity.editor.putInt("btnEditDressDrawable",R.drawable.pink_coat);
                SkinActivity.editor.putInt("personalDecorateLDrawable",R.drawable.whitebackground);
                SkinActivity.editor.apply();

                SkinActivity.topL.setBackgroundResource(R.drawable.pink);
                SkinActivity.buttonBackDress.setBackgroundResource(R.drawable.pink_triangle);
                SkinActivity.titleNameDress.setBackgroundResource(R.drawable.pink);
                SkinActivity.btnEditDress.setBackgroundResource(R.drawable.pink_coat);
                SkinActivity.personalDecorateL.setBackgroundResource(R.drawable.whitebackground);
                Toast.makeText(getContext(),"装扮成功",Toast.LENGTH_LONG).show();
                //typeface1=Typeface.createFromAsset(MainActivity.mgr,"fonts/sweat_heart.ttf");
                //MainActivity.titleNameDress.setTypeface(typeface1);
                //MainActivity.typeface=Typeface.createFromAsset(MainActivity.mgr,"fonts/sweat_heart.ttf");






            }
        });
        blueWallPaper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //MainActivity.buttonBackDress.getBackground().setAlpha(50);
                //MainActivity.btnEditDress.getBackground().setAlpha(50);
                //MainActivity.titleNameDress.getBackground().setAlpha(50);

                //MainActivity.personalDecorateL.setBackgroundResource(PersonalDecorateLDrawable);

                SkinActivity.editor.putInt("topLDrawable",R.drawable.blue_two);
                SkinActivity.editor.putInt("buttonBackDressDrawable",R.drawable.blue_triangle_three);
                SkinActivity.editor.putInt("titleNameDressDrawable",R.drawable.blue_two);
                SkinActivity.editor.putInt("btnEditDressDrawable",R.drawable.blue_coa);
                SkinActivity.editor.putInt("personalDecorateLDrawable",R.drawable.whitebackground);
                SkinActivity.editor.apply();

                SkinActivity.topL.setBackgroundResource(R.drawable.blue_two);
                SkinActivity.buttonBackDress.setBackgroundResource(R.drawable.blue_triangle_three);
                SkinActivity.titleNameDress.setBackgroundResource(R.drawable.blue_two);
                SkinActivity.btnEditDress.setBackgroundResource(R.drawable.blue_coa);
                SkinActivity.personalDecorateL.setBackgroundResource(R.drawable.whitebackground);
                Toast.makeText(getContext(),"装扮成功",Toast.LENGTH_LONG).show();
                //MainActivity.titleNameDress.setTypeface(MainActivity.typeface);


            }
        });
        blackWallPaper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //MainActivity.buttonBackDress.getBackground().setAlpha(50);
                //MainActivity.btnEditDress.getBackground().setAlpha(50);
                //MainActivity.titleNameDress.getBackground().setAlpha(50);

                //MainActivity.personalDecorateL.setBackgroundResource(PersonalDecorateLDrawable);


                SkinActivity.editor.putInt("topLDrawable",R.drawable.black);
                SkinActivity.editor.putInt("buttonBackDressDrawable",R.drawable.black_triangle);
                SkinActivity.editor.putInt("titleNameDressDrawable",R.drawable.black);
                SkinActivity.editor.putInt("btnEditDressDrawable",R.drawable.black_coat);
                SkinActivity.editor.putInt("personalDecorateLDrawable",R.drawable.whitebackground);
                SkinActivity.editor.apply();

                SkinActivity.topL.setBackgroundResource(R.drawable.black);
                SkinActivity.buttonBackDress.setBackgroundResource(R.drawable.black_triangle);
                SkinActivity.titleNameDress.setBackgroundResource(R.drawable.black);
                SkinActivity.btnEditDress.setBackgroundResource(R.drawable.black_coat);
                SkinActivity.personalDecorateL.setBackgroundResource(R.drawable.whitebackground);
                Toast.makeText(getContext(),"装扮成功",Toast.LENGTH_LONG).show();
                //MainActivity.titleNameDress.setTypeface(MainActivity.typeface);


            }
        });
        angleWallPaper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //MainActivity.buttonBackDress.getBackground().setAlpha(50);
                //MainActivity.btnEditDress.getBackground().setAlpha(50);
                //MainActivity.titleNameDress.getBackground( ).setAlpha(50);


                SkinActivity.editor.putInt("personalDecorateLDrawable",R.drawable.anglebaby);
                SkinActivity.editor.apply();


                SkinActivity.personalDecorateL.setBackgroundResource(R.drawable.anglebaby);
                Toast.makeText(getContext(),"装扮成功",Toast.LENGTH_LONG).show();
                //MainActivity.titleNameDress.setTypeface(MainActivity.typeface);


            }
        });

    }

}
