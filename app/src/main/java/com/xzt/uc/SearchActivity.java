package com.xzt.uc;


import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Toast;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import android.os.Handler;
import android.os.Message;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import static com.xzt.uc.BottomBar.btn_forward;
import static com.xzt.uc.MenuActivity.is_full_screen;
import static com.xzt.uc.SettingsActivity.start;


public class SearchActivity extends AppCompatActivity {

    public static SearchActivity searchActivity = null;
    private Intent downloadIntent = null;
    AutoCompleteTextView url;
    public static WebView webView;
    public int i=0;
    public static int count;
    public String string="null";
    public boolean isloadimg;
    public int time_count;
    public FloatingActionButton fla_btn;

    String[] booksArray = new String[]
            {
                    "http://maps.google.com",
                    "http://maps.baidu.com",
                    "http://qq.com",
                    "www.baidu.com",
                    "www.163.com"
            };

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

        setContentView(R.layout.search_layout);
        searchActivity = this;
        count=0;
        isloadimg=true;
        fla_btn=(FloatingActionButton) findViewById(R.id.fab_Button);
        Intent intent=getIntent();
        String str=intent.getStringExtra("str");
        final Activity activity = this;
        webView = (WebView)findViewById(R.id.show);



        String website1=intent.getStringExtra("website");
        webView.loadUrl(website1);

        String sina1=intent.getStringExtra("sina");
        webView.loadUrl(sina1);

        String baidu1=intent.getStringExtra("baidu");
        webView.loadUrl(baidu1);

        String weibo1=intent.getStringExtra("weibo");
        webView.loadUrl(weibo1);

        String guazi1=intent.getStringExtra("guazi");
        webView.loadUrl(guazi1);

        String tongcheng1=intent.getStringExtra("tongcheng");
        webView.loadUrl(tongcheng1);

        String taobao1=intent.getStringExtra("taobao");
        webView.loadUrl(taobao1);

        String ctrip1=intent.getStringExtra("ctrip");
        webView.loadUrl(ctrip1);

        String suning1=intent.getStringExtra("suning");
        webView.loadUrl(suning1);

        String youku1=intent.getStringExtra("youku");
        webView.loadUrl(youku1);




        String website_navigation1=intent.getStringExtra("website_navigation");
        webView.loadUrl(website_navigation1);

        String xinlangweibo1=intent.getStringExtra("xinlangweibo");
        webView.loadUrl(xinlangweibo1);

        String aitaobao1=intent.getStringExtra("aitaobao");
        webView.loadUrl(aitaobao1);

        String tmall1=intent.getStringExtra("tmall");
        webView.loadUrl(tmall1);

        String qunar1=intent.getStringExtra("qunar");
        webView.loadUrl(qunar1);

        String shenma_search1=intent.getStringExtra("shenma_search");
        webView.loadUrl(shenma_search1);

        String ticket_taobao1=intent.getStringExtra("ticket_taobao");
        webView.loadUrl(ticket_taobao1);

        String lifestyle1=intent.getStringExtra("lifestyle");
        webView.loadUrl(lifestyle1);

        String autohome1=intent.getStringExtra("autohome");
        webView.loadUrl(autohome1);

        String interesting_encyclopedia1=intent.getStringExtra("interesting_encyclopedia");
        webView.loadUrl(interesting_encyclopedia1);

        String youku_video1=intent.getStringExtra("youku_video");
        webView.loadUrl(youku_video1);

        String btn_lottery1=intent.getStringExtra("btn_lottery");
        webView.loadUrl(btn_lottery1);




        String news1=intent.getStringExtra("news1");
        webView.loadUrl(news1);

        String news2=intent.getStringExtra("news2");
        webView.loadUrl(news2);

        String news3=intent.getStringExtra("news3");
        webView.loadUrl(news3);

        String news4=intent.getStringExtra("news4");
        webView.loadUrl(news4);

        String news5=intent.getStringExtra("news5");
        webView.loadUrl(news5);

        String news6=intent.getStringExtra("news6");
        webView.loadUrl(news6);

        String news7=intent.getStringExtra("news7");
        webView.loadUrl(news7);

        String news8=intent.getStringExtra("news8");
        webView.loadUrl(news8);

        String news9=intent.getStringExtra("news9");
        webView.loadUrl(news9);

        String news10=intent.getStringExtra("news10");
        webView.loadUrl(news10);




        //启动上次未关闭的网页







        //设置浏览器支持javascript
        webView.loadUrl(str);
        webView.getSettings().setJavaScriptEnabled(true);
        WebSettings settings = webView.getSettings();
        settings.setDomStorageEnabled(true);//开启DOM
        //WebViewClient用来处理各种通知、请求等事件，WebView调用setWebViewClient()来指定一个WebViewClient对象。
        webView.setWebViewClient(new WebViewClient()
        {
            //控制新的连接在当前WebView中打开
            boolean flag=false;
            public boolean shouldOverridUrlLoading(WebView view, String strUrl)
            {

                if(strUrl==null)return false;
                ((InputMethodManager)getSystemService(INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),InputMethodManager.HIDE_NOT_ALWAYS);
                try{
                    if(strUrl.startsWith("http:")||strUrl.startsWith("https:")){
                        view.loadUrl(strUrl);
                        return true;
                    }
                    else{
                        Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse(strUrl));
                        startActivity(intent);
                        return true;
                    }
                }catch (Exception e){
                    return false;
                }

            }

            public void onPageStarted(WebView view, String strUrl, Bitmap favicon)
            {
                super.onPageStarted(view, strUrl, favicon);
                url.setText(strUrl);
                ((InputMethodManager)getSystemService(INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),InputMethodManager.HIDE_NOT_ALWAYS);
            }

            public void onPageFinished(WebView view, String strUrl)
            {
                if(webView.canGoForward())
                    btn_forward.setEnabled(true);
                else
                    btn_forward.setEnabled(false);
            }
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl)
            {
                Toast.makeText(activity, "Oh no! " + description, Toast.LENGTH_SHORT).show();
            }
        });
        webView.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
                Log.d("test1",title);
                if(!title.startsWith("https:")) {
                    if (!string.equals(title) ) {
                        HistoryDatabase historyDatabase = new HistoryDatabase();
                        historyDatabase.setTitle(title);
                        historyDatabase.setUrl(view.getUrl());
                        historyDatabase.save();
                        count += 1;
                        string=title;
                    }
                }
                Log.d("test",""+count);
            }
        });
        url = (AutoCompleteTextView)findViewById(R.id.url);
        ArrayAdapter<String> aa = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, booksArray);
        url.setAdapter(aa);
        url.setOnKeyListener(new View.OnKeyListener()
        {
            public boolean onKey(View v, int keyCode, KeyEvent ev)
            {
                if (keyCode == KeyEvent.KEYCODE_ENTER)
                {
                    String strUrl = url.getText().toString();

                    Pattern p = Pattern.compile("http://([\\w-]+\\.)+[\\w-]+(/[\\w-\\./?%=]*)?");
                    Matcher m = p.matcher(strUrl);
                    if (!m.find())
                    {
                        strUrl = "http://" + strUrl;
                    }

                    webView.loadUrl(strUrl);
                    ((InputMethodManager)getSystemService(INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),InputMethodManager.HIDE_NOT_ALWAYS);

                    return true;
                }

                return false;
            }
        });


        webView.setDownloadListener(new MyWebViewDownLoadListener());
        downloadIntent = new Intent(this, Download.class);

    }

    private class MyWebViewDownLoadListener implements android.webkit.DownloadListener {

        @Override
        public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimetype,
                                    long contentLength) {
            Log.i("tag", "url="+url);
            Log.i("tag", "userAgent="+userAgent);
            Log.i("tag", "contentDisposition="+contentDisposition);
            Log.i("tag", "mimetype="+mimetype);
            Log.i("tag", "contentLength="+contentLength);
            downloadIntent.putExtra("url", url);
            startActivity(downloadIntent);
        }
    }



    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        // Check if the key event was the Back button and if there's history
        if ((keyCode == KeyEvent.KEYCODE_BACK) )
        {
            // 返回键退回
            if(!webView.canGoBack())
            {
                Intent intent=new Intent(SearchActivity.this,UCActivity.class);
                searchActivity.startActivity(intent);
                finish();
            }
            webView.goBack();
            return true;
        }
        // If it wasn't the Back key or there's no web page history, bubble up
        // to the default
        // system behavior (probably exit the activity)
        return super.onKeyDown(keyCode, event);
    }


    final Handler handler=new Handler(){
        public void handleMessage(Message msg){
            switch (msg.what){
                case 1:
                    webView.reload();
                    count-=1;
                    Log.d("handle","1");
                    break;
                default:
                    break;
            }
        }
    };


    public void timerRefresh(){
        final AlertDialog.Builder dialog=new AlertDialog.Builder(SearchActivity.this);
        final View dialogView= LayoutInflater.from(SearchActivity.this).inflate(R.layout.dialog1,null);
        dialog.setTitle("定时刷新装置");
        dialog.setView(dialogView);
        dialog.setPositiveButton("开始刷新", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                EditText editText=(EditText)dialogView.findViewById(R.id.edit_text);
                time_count=Integer.parseInt(editText.getText().toString());
                Log.d("test.time",""+time_count);
                if(time_count<5||time_count>999){
                    Toast.makeText(SearchActivity.this,"输入的时间不合法请重新设置",Toast.LENGTH_SHORT).show();
                }
                else{
                    fla_btn.setEnabled(true);
                    Toast.makeText(SearchActivity.this,"点击时钟按钮可取消定时刷新",Toast.LENGTH_SHORT).show();
                    final Timer timer=new Timer();
                    TimerTask task=new TimerTask() {
                        @Override
                        public void run() {
                            Message message=new Message();
                            message.what=1;
                            handler.sendMessage(message);
                        }
                    };
                    timer.schedule(task,1000,time_count*1000);
                    fla_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            timer.cancel();
                            fla_btn.setEnabled(false);
                        }
                    });
                }
            }
        });
        dialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        dialog.show();
    }

}
