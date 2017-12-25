package com.xzt.uc;


import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import java.util.ArrayList;
import java.util.List;

public class FavoriteAndHistoryActivity extends AppCompatActivity {

    public static FavoriteAndHistoryActivity favoriteAndHistoryActivity = null;

    private TabLayout tab_title;
    private ViewPager vp_pager;
    private FragmentPagerAdapter fAdapter;
    private List<Fragment> list_fragment;                                //定义要装fragment的列表
    private List<String> list_title;
    private HistoryFragment history;
    private favoriteFragment favorite;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.favorite_and_history_layout);
        favoriteAndHistoryActivity = this;

        ActionBar actionBar=getSupportActionBar();
        if(actionBar!=null)
            actionBar.hide();
        tab_title = (TabLayout) findViewById(R.id.tab);
        vp_pager = (ViewPager)findViewById(R.id.viewpager);
        history = new HistoryFragment();
        favorite = new favoriteFragment();
        list_fragment = new ArrayList<>();
        ImageButton imageButton=(ImageButton) findViewById(R.id.backimg);
        list_fragment.add(favorite);
        list_fragment.add(history);
        list_title=new ArrayList<>();
        list_title.add("收藏");
        list_title.add("历史");
        tab_title.setTabMode(TabLayout.MODE_SCROLLABLE);
        tab_title.addTab(tab_title.newTab().setText(list_title.get(0)));
        tab_title.addTab(tab_title.newTab().setText(list_title.get(1)));
        fAdapter=new FavoriteAndHistoryAdapter(getSupportFragmentManager(),list_fragment,list_title);
        vp_pager.setAdapter(fAdapter);
        tab_title.setupWithViewPager(vp_pager);
        imageButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
