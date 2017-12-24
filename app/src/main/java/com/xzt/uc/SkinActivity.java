package com.xzt.uc;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class SkinActivity extends FragmentActivity implements View.OnClickListener {

    public static SkinActivity skinActivity = null;
    private TextView textWallPaper;
    private TextView textWebPage;
    private TextView textFont;
    private ImageButton buttonBackDress;
    private TextView phonePictureT;
    private TextView editWallPaperT;

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
        skinActivity = this;

        mViewPager= (ViewPager) findViewById(R.id.id_view_pager);
        textWallPaper=(TextView) findViewById(R.id.text_wallpaper);
        textWebPage=(TextView) findViewById(R.id.text_webPage);
        textFont=(TextView)findViewById(R.id.text_font);
        phonePictureT=(TextView)findViewById(R.id.phonePicture);
        editWallPaperT=(TextView) findViewById(R.id.editWallPaper);
        buttonBackDress=(ImageButton) findViewById(R.id.btnBackBDress);
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
