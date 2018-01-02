package com.xzt.uc;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import java.util.ArrayList;
import java.util.List;

import static com.xzt.uc.MenuActivity.is_full_screen;


public class WebsiteNavigationActivity extends AppCompatActivity {


    public static WebsiteNavigationActivity websitenavigationActivity = null;
    //需要将其实例化，在别的里面要引用

    private List<WebsiteButton> websitebuttonList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences full_screen_get = getSharedPreferences("full_screen", MODE_PRIVATE);
        is_full_screen = full_screen_get.getBoolean("full_screen", false);
        if(is_full_screen)
        {
            //取消标题
            requestWindowFeature(Window.FEATURE_NO_TITLE);
            //取消状态栏
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }

        setContentView(R.layout.website_navigation_layout);
        websitenavigationActivity = this;
        //将其赋值为当前的活动
        initWebsiteButton();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycle_view);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        WebsiteButtonAdapter adapter = new WebsiteButtonAdapter(websitebuttonList);
        recyclerView.setAdapter(adapter);


    }

    private void initWebsiteButton()
    {
        WebsiteButton btn_website_navigation = new WebsiteButton("btn_website_navigation", R.drawable.btn_website_navigation);
        websitebuttonList.add(btn_website_navigation);
        WebsiteButton btn_xinlangweibo = new WebsiteButton("btn_xinlangweibo", R.drawable.btn_xinlangweibo);
        websitebuttonList.add(btn_xinlangweibo);
        WebsiteButton btn_information_center = new WebsiteButton("btn_information_center", R.drawable.btn_information_center);
        websitebuttonList.add(btn_information_center);
        WebsiteButton btn_aitaobao = new WebsiteButton("btn_aitaobao", R.drawable.btn_aitaobao);
        websitebuttonList.add(btn_aitaobao);
        WebsiteButton btn_tmall = new WebsiteButton("btn_tmall", R.drawable.btn_tmall);
        websitebuttonList.add(btn_tmall);
        WebsiteButton btn_qunar = new WebsiteButton("btn_qunar", R.drawable.btn_qunar);
        websitebuttonList.add(btn_qunar);
        WebsiteButton btn_a_collection_of_video = new WebsiteButton("btn_a_collection_of_video", R.drawable.btn_a_collection_of_video);
        websitebuttonList.add(btn_a_collection_of_video);
        WebsiteButton btn_a_collection_of_novel = new WebsiteButton("btn_a_collection_of_novel", R.drawable.btn_a_collection_of_novel);
        websitebuttonList.add(btn_a_collection_of_novel);
        WebsiteButton btn_comics2 = new WebsiteButton("btn_comics2", R.drawable.btn_comics2);
        websitebuttonList.add(btn_comics2);
        WebsiteButton btn_shenma_search = new WebsiteButton("btn_shenma_search", R.drawable.btn_shenma_search);
        websitebuttonList.add(btn_shenma_search);
        WebsiteButton btn_ticket_taobao = new WebsiteButton("btn_ticket_taobao", R.drawable.btn_ticket_taobao);
        websitebuttonList.add(btn_ticket_taobao);
        WebsiteButton btn_lifestyle = new WebsiteButton("btn_lifestyle", R.drawable.btn_lifestyle);
        websitebuttonList.add(btn_lifestyle);
        WebsiteButton btn_autohome = new WebsiteButton("btn_autohome", R.drawable.btn_autohome);
        websitebuttonList.add(btn_autohome);
        WebsiteButton btn_boutique = new WebsiteButton("btn_boutique", R.drawable.btn_boutique);
        websitebuttonList.add(btn_boutique);
        WebsiteButton btn_interesting_encyclopedia = new WebsiteButton("btn_interesting_encyclopedia", R.drawable.btn_interesting_encyclopedia);
        websitebuttonList.add(btn_interesting_encyclopedia);
        WebsiteButton btn_youku_video = new WebsiteButton("btn_youku_video", R.drawable.btn_youku_video);
        websitebuttonList.add(btn_youku_video);
        WebsiteButton btn_lottery = new WebsiteButton("btn_lottery", R.drawable.btn_lottery);
        websitebuttonList.add(btn_lottery);
        WebsiteButton btn_add = new WebsiteButton("btn_add", R.drawable.btn_add);
        websitebuttonList.add(btn_add);
    }
}
