package com.xzt.uc;


import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

public class SkinActivity extends FragmentActivity implements View.OnClickListener {


    public static SkinActivity skinActivity = null;

    //更改皮肤的控件
    static ImageButton buttonBackDress;
    static TextView titleNameDress;//ziTi
    static TextView  btnEditDress;
    static LinearLayout topL;
    static LinearLayout personalDecorateL;
    //数据存储
    static SharedPreferences pref;
    static SharedPreferences.Editor editor;

    static AssetManager mgr;
    static Typeface typeface;
    static Typeface typeface1;
    static Typeface typeface2;
    static Typeface typeface3;
    static Typeface typeface4;

    static TextView textWallPaper;//ziTi
    static TextView textWebPage;//ziTi
    static TextView textFont;//ziTi

    static TextView phonePictureT;//ziTi
    static TextView editWallPaperT;//ziTi


    private Fragment mTab01;
    private Fragment mTab02;
    private Fragment mTab03;

    private ViewPager mViewPager;
    private FragmentPagerAdapter mAdapter;
    private List<Fragment> mFragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.skin_layout);
        //pref= PreferenceManager.getDefaultSharedPreferences(this);
        editor=getSharedPreferences("data",MODE_PRIVATE).edit();
        pref=getSharedPreferences("data",MODE_MULTI_PROCESS);
        skinActivity = this;




        //需要更改皮肤的控件
        buttonBackDress=(ImageButton) findViewById(R.id.btnBackBDress);
        titleNameDress=(TextView) findViewById(R.id.title_nameDress);
        topL=(LinearLayout)findViewById(R.id.topL);
        btnEditDress=(TextView) findViewById(R.id.btnEditDress);
        personalDecorateL=(LinearLayout) findViewById(R.id.personalDecorateLinearLayout);





        mViewPager=findViewById(R.id.id_view_pager);
        textWallPaper=(TextView) findViewById(R.id.text_wallpaper);
        textWebPage=(TextView) findViewById(R.id.text_webPage);
        textFont=(TextView)findViewById(R.id.text_font);
        phonePictureT=(TextView)findViewById(R.id.phonePicture);
        editWallPaperT=(TextView) findViewById(R.id.editWallPaper);

        //字体设置
        mgr=getAssets();
        typeface4=Typeface.createFromAsset(mgr,"fonts/song.ttf");
        typeface1=Typeface.createFromAsset(mgr,"fonts/sweat_heart.ttf");
        typeface2=Typeface.createFromAsset(mgr,"fonts/xiao_wei.ttf");
        typeface3=Typeface.createFromAsset(mgr,"fonts/qi.ttf");
        final String TypeF=SkinActivity.pref.getString("typeF","fonts/song.ttf");
        SkinActivity.typeface=Typeface.createFromAsset(SkinActivity.mgr,TypeF);
        SkinActivity.titleNameDress.setTypeface(SkinActivity.typeface);
        SkinActivity.textWallPaper.setTypeface(SkinActivity.typeface);
        SkinActivity.textWebPage.setTypeface(SkinActivity.typeface);
        SkinActivity.textFont.setTypeface(SkinActivity.typeface);
        SkinActivity.phonePictureT.setTypeface(SkinActivity.typeface);
        SkinActivity.editWallPaperT.setTypeface(SkinActivity.typeface);


        buttonBackDress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }
        });
        initView();
        initEvent();
        setSelect(0);
    }
    private void initView(){
        mFragments=new ArrayList<Fragment>();
        Fragment mTab01=new WallPaperFragment();
        Fragment mTab02=new WebPageFragment();
        Fragment mTab03=new FontFragment();
        mFragments.add(mTab01);
        mFragments.add(mTab02);
        mFragments.add(mTab03);
        mAdapter=new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int arg0) {
                return mFragments.get(arg0);
            }

            @Override
            public int getCount() {
                return mFragments.size();
            }
        };
        mViewPager.setAdapter(mAdapter);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                resetTextColor();
                int currentItem=mViewPager.getCurrentItem();
                switch (currentItem){
                    case 0:

                        //if (mTab01==null){
                        // mTab01=new WallPaperFragment();
                        //transaction.add(R.id.id_content,mTab01);
                        // }
                        // else {
                        //transaction.show(mTab01);
                        //}
                        phonePictureT.setVisibility(View.VISIBLE);
                        editWallPaperT.setVisibility(View.VISIBLE);
                        textWallPaper.setTextColor(0xffffffff);
                        break;
                    case 1:

                        phonePictureT.setVisibility(View.INVISIBLE);
                        editWallPaperT.setVisibility(View.INVISIBLE);
                        textWebPage.setTextColor(0xffffffff);
                        break;
                    case 2:

                        phonePictureT.setVisibility(View.INVISIBLE);
                        editWallPaperT.setVisibility(View.INVISIBLE);
                        textFont.setTextColor(0xffffffff);
                        break;
                    default:
                        break;
                }


            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    private void initEvent(){
        textWallPaper.setOnClickListener(this);
        textWebPage.setOnClickListener(this);
        textFont.setOnClickListener(this);
    }
    private void  setSelect(int i){
        //FragmentManager fm =getSupportFragmentManager();
        //FragmentTransaction transaction=fm.beginTransaction();
        //hideFragment(transaction);
        //改变字体颜色
        //设置内容区域
        resetTextColor();
        switch (i){
            case 0:

                //if (mTab01==null){
                // mTab01=new WallPaperFragment();
                //transaction.add(R.id.id_content,mTab01);
                // }
                // else {
                //transaction.show(mTab01);
                //}
                phonePictureT.setVisibility(View.VISIBLE);
                editWallPaperT.setVisibility(View.VISIBLE);
                textWallPaper.setTextColor(0xffffffff);
                break;
            case 1:

                phonePictureT.setVisibility(View.INVISIBLE);
                editWallPaperT.setVisibility(View.INVISIBLE);
                textWebPage.setTextColor(0xffffffff);
                break;
            case 2:

                phonePictureT.setVisibility(View.INVISIBLE);
                editWallPaperT.setVisibility(View.INVISIBLE);
                textFont.setTextColor(0xffffffff);
                break;
            default:
                break;
        }
        mViewPager.setCurrentItem(i);
        //transaction.commit();
    }
    private void hideFragment(FragmentTransaction transaction){
        if (mTab01!=null){
            transaction.hide(mTab01);
        }
        if (mTab02!=null){
            transaction.hide(mTab02);
        }
        if (mTab03!=null){
            transaction.hide(mTab03);
        }
    }
    public void onClick(View view){

        switch(view.getId()){
            case R.id.text_wallpaper:
                setSelect(0);
                break;
            case R.id.text_webPage:
                setSelect(1);
                break;
            case R.id.text_font:
                setSelect(2);
                break;
            default:
                break;
        }
    }
    private void resetTextColor(){
        textWallPaper.setTextColor(0x80ffffff);
        textWebPage.setTextColor(0x80ffffff);
        textFont.setTextColor(0x80ffffff);
    }
}
