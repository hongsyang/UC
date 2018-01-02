package com.xzt.uc;


import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.view.View.OnClickListener;
import static com.xzt.uc.SearchActivity.webView;
import static com.xzt.uc.SearchActivity.searchActivity;
import static com.xzt.uc.UCActivity.ucActivity;
import static com.xzt.uc.AdvanceSetActivity.advanceSetActivity;
import static com.xzt.uc.DownloadSetActivity.downloadSetActivity;
import static com.xzt.uc.FavoriteAndHistoryActivity.favoriteAndHistoryActivity;
import static com.xzt.uc.SettingsActivity.settingsActivity;
import static com.xzt.uc.UCFrontpageSetActivity.ucFrontpageSetActivity;
import static com.xzt.uc.WebpageScanSetActivity.webpageScanSetActivity;
import static com.xzt.uc.WebsiteNavigationActivity.websitenavigationActivity;
import static com.xzt.uc.SkinActivity.skinActivity;








public class MenuActivity extends Activity {


    //Android的对话框有两种：PopupWindow和AlertDialog。
    //它们的不同点在于：
    //    1.AlertDialog不能指定显示位置，只能默认显示在屏幕最中间（当然也可以通过设置WindowManager参数来改变位置）。
    //    2.而PopupWindow是可以指定显示位置的，随便哪个位置都可以，更加灵活
    private ImageButton btn_login_in, btn_favourites_history, btn_full_screen, btn_my_novel, btn_my_comics, btn_download_management, btn_add_to_favorites, btn_refresh, btn_night_mode, btn_toolbox, btn_settings, btn_slide_downward, btn_share;
    //               立即登陆，        收藏/历史，         我的视频，    我的小说，    我的漫画，          下载管理，              添加网页，          刷新，      夜间模式，      工具箱，      设置，           下滑，          分享；
    private LinearLayout pop_layout;
    //PopupWindow的构造方法：
    // 1.public PopupWindow (Context context)
    // 2.public PopupWindow(View contentView)
    // 3.public PopupWindow(View contentView, int width, int height)
    // 4.public PopupWindow(View contentView, int width, int height, boolean focusable)
    public static MenuActivity menuActivity = null;
    public static boolean is_full_screen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_layout);
        menuActivity = this;

        btn_login_in = (ImageButton) this.findViewById(R.id.btn_login_in);
        btn_favourites_history = (ImageButton) this.findViewById(R.id.btn_favourites_history);
        btn_full_screen = (ImageButton) this.findViewById(R.id.btn_full_screen);
        btn_my_novel = (ImageButton) this.findViewById(R.id.btn_my_novel);
        btn_my_comics = (ImageButton) this.findViewById(R.id.btn_my_comics);
        btn_download_management = (ImageButton) this.findViewById(R.id.btn_download_management);
        btn_add_to_favorites = (ImageButton) this.findViewById(R.id.btn_add_to_favorites);
        btn_refresh = (ImageButton) this.findViewById(R.id.btn_refresh);
        btn_night_mode = (ImageButton) this.findViewById(R.id.btn_night_mode);
        btn_toolbox = (ImageButton) this.findViewById(R.id.btn_toolbox);
        btn_settings = (ImageButton) this.findViewById(R.id.btn_settings);
        btn_slide_downward = (ImageButton) this.findViewById(R.id.btn_slide_downward);
        btn_share = (ImageButton) this.findViewById(R.id.btn_share);

        pop_layout = (LinearLayout) findViewById(R.id.pop_layout);

        //添加选择窗口范围监听可以优先获取触点，即不再执行onTouchEvent()函数，点击其他地方时执行onTouchEvent()函数销毁Activity
        pop_layout.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btn_login_in.setOnClickListener(itemsOnClick);
        btn_favourites_history.setOnClickListener(itemsOnClick);
        btn_full_screen.setOnClickListener(itemsOnClick);
        btn_my_novel.setOnClickListener(itemsOnClick);
        btn_my_comics.setOnClickListener(itemsOnClick);
        btn_download_management.setOnClickListener(itemsOnClick);
        btn_add_to_favorites.setOnClickListener(itemsOnClick);
        btn_refresh.setOnClickListener(itemsOnClick);
        btn_night_mode.setOnClickListener(itemsOnClick);
        btn_toolbox.setOnClickListener(itemsOnClick);
        btn_settings.setOnClickListener(itemsOnClick);
        btn_slide_downward.setOnClickListener(itemsOnClick);
        btn_share.setOnClickListener(itemsOnClick);
    }

    private OnClickListener  itemsOnClick = new OnClickListener()
    {
        public void onClick(View v)
        {
            switch (v.getId())
            {
                case R.id.btn_login_in:
                    break;
                case R.id.btn_favourites_history:  //收藏/历史按钮
                    Intent intent=new Intent(MenuActivity.this,FavoriteAndHistoryActivity.class);
                    startActivity(intent);
                    break;
                case R.id.btn_full_screen:

                    SharedPreferences full_screen_get = getSharedPreferences("full_screen", MODE_PRIVATE);
                    is_full_screen = full_screen_get.getBoolean("full_screen", false);
                    if(!is_full_screen)
                    {
                        is_full_screen = true;
                        ucActivity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
                    }
                    else
                    {
                        is_full_screen = false;
                        ucActivity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
                    }

                    SharedPreferences.Editor full_screen_save = getSharedPreferences("full_screen", MODE_PRIVATE).edit();
                    full_screen_save.putBoolean("full_screen", is_full_screen);
                    full_screen_save.apply();


                    /*if(count%2 == 1)
                    {
                        //取消电池栏
                        searchActivity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
                        ucActivity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
                        advanceSetActivity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
                        downloadSetActivity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
                        favoriteAndHistoryActivity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
                        settingsActivity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
                        ucFrontpageSetActivity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
                        webpageScanSetActivity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
                        websitenavigationActivity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
                        skinActivity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
                    }
                    else
                    {
                        searchActivity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
                        ucActivity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
                        advanceSetActivity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
                        downloadSetActivity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
                        favoriteAndHistoryActivity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
                        settingsActivity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
                        ucFrontpageSetActivity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
                        webpageScanSetActivity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
                        websitenavigationActivity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
                        skinActivity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
                    }*/


                    break;
                case R.id.btn_my_novel:
                    break;
                case R.id.btn_my_comics:
                    break;
                case R.id.btn_download_management:
                    break;
                case R.id.btn_add_to_favorites:   //收藏网址按钮
                    Favorite favorite=new Favorite();
                    favorite.setTitle(webView.getTitle());
                    favorite.setUrl(webView.getUrl());
                    favorite.save();
                    break;
                case R.id.btn_refresh:
                    break;
                case R.id.btn_night_mode:
                    break;
                case R.id.btn_toolbox:
                    break;
                case R.id.btn_settings:
                    intent=new Intent(MenuActivity.this,SettingsActivity.class);
                    startActivity(intent);
                    break;
                case R.id.btn_slide_downward:
                    break;
                case R.id.btn_share:
                    break;
            }
            finish();
        }
    };

    //实现onTouchEvent触屏函数但点击屏幕时销毁本Actvity
    @Override
    public boolean onTouchEvent(MotionEvent motionEvent)
    {
        finish();
        return true;
        //如果onTouch返回值为true,表示这个Touch事件被onTouch方法处理完毕，不会把Touch事件再传递给Activity
    }
}
