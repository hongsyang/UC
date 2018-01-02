package com.xzt.uc;


import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

import static com.xzt.uc.MenuActivity.is_full_screen;
import static com.xzt.uc.SettingsActivity.start;


public class UCActivity extends AppCompatActivity {

    public static UCActivity ucActivity = null;
    //需要将其实例化，在别的里面要引用
    private List<News> newsList = new ArrayList<>();

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

        setContentView(R.layout.uc_layout);
        ucActivity = this;
        //将其赋值为当前的活动
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        CollapsingToolbarLayout collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        setSupportActionBar(toolbar);

        ImageButton btn_search = (ImageButton) findViewById(R.id.btn_search);
        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UCActivity.this,SearchActivity.class));
                finish();
            }
        });



        ImageButton btn_website = (ImageButton) findViewById(R.id.btn_website);
        btn_website.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String website1 = new String("http://hao.uc.cn/?uc_biz_str=S:custom%7CC:web_default&uc_param_str=dnfrpfbivecpbtntla&source=zpdh");
                Intent intent=new Intent(UCActivity.this, SearchActivity.class);
                intent.putExtra("website",website1);
                startActivity(intent);
            }
        });


        ImageButton btn_sina = (ImageButton) findViewById(R.id.btn_sina);
        btn_sina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sina1 = new String("https://sina.cn/?wm=4007");
                Intent intent=new Intent(UCActivity.this, SearchActivity.class);
                intent.putExtra("sina",sina1);
                startActivity(intent);
            }
        });



        ImageButton btn_baidu = (ImageButton) findViewById(R.id.btn_baidu);
        btn_baidu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String baidu1 = new String("https://m.baidu.com/?from=2001a");
                Intent intent=new Intent(UCActivity.this, SearchActivity.class);
                intent.putExtra("baidu",baidu1);
                startActivity(intent);
            }
        });


        ImageButton btn_weibo = (ImageButton) findViewById(R.id.btn_weibo);
        btn_weibo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String weibo1 = new String("https://m.weibo.cn/p/102803?featurecode=H5tuiguang0623&need_head_cards=1&wm=90014_90005");
                Intent intent=new Intent(UCActivity.this, SearchActivity.class);
                intent.putExtra("weibo",weibo1);
                startActivity(intent);
            }
        });

        ImageButton btn_guazi = (ImageButton) findViewById(R.id.btn_guazi);
        btn_guazi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String guazi1 = new String("https://m.guazi.com/zz/?ca_s=dh_tgucmz&ca_n=ucmz&scode=10104007622");
                Intent intent=new Intent(UCActivity.this, SearchActivity.class);
                intent.putExtra("guazi",guazi1);
                startActivity(intent);
            }
        });

        ImageButton btn_58tongcheng = (ImageButton) findViewById(R.id.btn_58tongcheng);
        btn_58tongcheng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tongcheng1 = new String("http://m.58.com/zz/?utm_source=market&spm=b-31580022738699-me-f-805.uc_jp_0220 ");
                Intent intent=new Intent(UCActivity.this, SearchActivity.class);
                intent.putExtra("tongcheng",tongcheng1);
                startActivity(intent);
            }
        });

        ImageButton btn_taobao = (ImageButton) findViewById(R.id.btn_taobao);
        btn_taobao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String taobao1 = new String("https://m.taobao.com/#index");
                Intent intent=new Intent(UCActivity.this, SearchActivity.class);
                intent.putExtra("taobao",taobao1);
                startActivity(intent);
            }
        });

        ImageButton btn_ctrip = (ImageButton) findViewById(R.id.btn_ctrip);
        btn_ctrip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ctrip1 = new String("http://m.ctrip.com/html5/");
                Intent intent=new Intent(UCActivity.this, SearchActivity.class);
                intent.putExtra("ctrip",ctrip1);
                startActivity(intent);
            }
        });

        ImageButton btn_suning = (ImageButton) findViewById(R.id.btn_suning);
        btn_suning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String suning1 = new String("https://m.suning.com/?utm_source=yd-uc&utm_medium=iosgongge");
                Intent intent=new Intent(UCActivity.this, SearchActivity.class);
                intent.putExtra("suning",suning1);
                startActivity(intent);
            }
        });

        ImageButton btn_youku = (ImageButton) findViewById(R.id.btn_youku);
        btn_youku.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String youku1 = new String("http://www.youku.com/?tpa=dW5pb25faWQ9MTAzMjU1XzEwMDAwMl8wMV8wMg");
                Intent intent=new Intent(UCActivity.this, SearchActivity.class);
                intent.putExtra("youku",youku1);
                startActivity(intent);
            }
        });


        initNews();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        NewsAdapter adapter = new NewsAdapter(newsList);
        recyclerView.setAdapter(adapter);


        //启动上次未关闭的网页
        SharedPreferences start_get = getSharedPreferences("start", MODE_PRIVATE);
        start = start_get.getBoolean("start", false);
        Log.d("UCActivity", "start4=" + start);
        if(start)
        {
            if ((getIntent().getFlags() & Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT) != 0)
            {
                //结束你的activity
                finish();
                return;
            }
        }

    }


    private void initNews()
    {
        News news1 = new News("news1", R.drawable.news1_pic);
        newsList.add(news1);
        News news2 = new News("news2", R.drawable.news2_pic);
        newsList.add(news2);
        News news3 = new News("news3", R.drawable.news3_pic);
        newsList.add(news3);
        News news4 = new News("news4", R.drawable.news4_pic);
        newsList.add(news4);
        News news5 = new News("news5", R.drawable.news5_pic);
        newsList.add(news5);
        News news6 = new News("news6", R.drawable.news6_pic);
        newsList.add(news6);
        News news7 = new News("news7", R.drawable.news7_pic);
        newsList.add(news7);
        News news8 = new News("news8", R.drawable.news8_pic);
        newsList.add(news8);
        News news9 = new News("news9", R.drawable.news9_pic);
        newsList.add(news9);
        News news10 = new News("news10", R.drawable.news10_pic);
        newsList.add(news10);
    }


}
