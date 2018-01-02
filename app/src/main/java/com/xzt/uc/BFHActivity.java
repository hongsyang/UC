package com.xzt.uc;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.xzt.uc.DS.Client;
import com.xzt.uc.DS.LinkedList;
import com.xzt.uc.DS.Node;


public class BFHActivity extends AppCompatActivity {
    public static Node cur = new Node<URL>();
    //网页双向链表
    public  static LinkedList<URL> Link;


    public static int tag = 1;


    //假设这个是显示网页的地方
    private WebView stage;

    //网址输入框
    private EditText editor;
    private ImageButton goButton;

    private Client client;

    public static URL obj = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bfh);
        //

        //初始化链表
        Link = new LinkedList();

        //获取三个按钮实例
        BottomBar.btn_backward = (ImageButton)findViewById(R.id.btn_backward);
        BottomBar.btn_forward = (ImageButton) findViewById(R.id.btn_forward);
        BottomBar.btn_home = (ImageButton) findViewById(R.id.btn_home);


        //获取输入框实例
        editor = (EditText) findViewById(R.id.url);

        //获取显示区域实例
        stage = (WebView) findViewById(R.id.show);

        WebSettings settings = stage.getSettings();
        settings.setJavaScriptEnabled(true);
        stage.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);

        client = new Client(editor);
        stage.setWebViewClient(client);

        Link.insert(new URL("home"),Link.getSize());
        cur = Link.getNode(Link.getSize());
        Intent intent = new Intent(BFHActivity.this,UCActivity.class);
        tag = 0;
        startActivityForResult(intent,1);
    }

    public void load(View view)
    {
        /*
            获取输入的网址内容
              如果为空，结束
         */
        String url = editor.getText().toString();
        if(url.trim().equals(""))
        {
            Toast.makeText(BFHActivity.this,"Not null!",Toast.LENGTH_SHORT).show();
            return;
        }

        Node<URL> tem ;
        tem = cur;
        int position = 0;
        while(tem.getPre() != null)
        {
            tem=tem.getPre();
            position++;
        }

        Link.insert(new URL(url),position);
        cur = Link.getNode(position+1);
        tag = 0;
        stage.loadUrl(url);
    }




    public void goBack(View view)
    {
        if(cur.getPre()==null)
        {
            Toast.makeText(BFHActivity.this,"End",Toast.LENGTH_SHORT).show();
        }else{
            Node<URL> tem1 ;
            tem1 = cur;
            int position = 0;
            while(tem1.getPre() != null)
            {
                tem1=tem1.getPre();
                position++;
            }
            String s1 = position+"";Log.d("bbb1",s1);

            cur = cur.getPre();

            Node<URL> tem ;
            tem = cur;
            int position1 = 0;
            while(tem.getPre() != null)
            {
                tem=tem.getPre();
                position1++;
            }
            String s = position1+"是"+((URL)cur.getData()).getAddress();Log.d("bb",s);
            String ss = Link.getSize()+"当前链表";Log.d("bbb",ss);
            if(((URL)cur.getData()).getAddress().equals("home"))
            {
                Intent intent = new Intent(BFHActivity.this,UCActivity.class);
                startActivityForResult(intent,1);
            }else {
                tag = 0;
                stage.loadUrl(((URL)cur.getData()).getAddress());
            }
        }
    }

    public void goForward(View view)
    {
        if(cur.getNext()==null)
        {
            Toast.makeText(BFHActivity.this,"End",Toast.LENGTH_SHORT).show();
        }else{
            Node<URL> tem1 ;
            tem1 = cur;
            int position = 0;
            while(tem1.getPre() != null)
            {
                tem1=tem1.getPre();
                position++;
            }
            String s1 = position+"";Log.d("fff1",s1);
            cur = cur.getNext();
            Node<URL> tem ;
            tem = cur;
            int position1 = 0;
            while(tem.getPre() != null)
            {
                tem=tem.getPre();
                position1++;
            }
            String s = position1+"是"+((URL)cur.getData()).getAddress();Log.d("ff",s);
            String ss = Link.getSize()+"当前链表";Log.d("fff",ss);
            if(((URL)cur.getData()).getAddress().equals("home"))
            {
                Intent intent = new Intent(BFHActivity.this,UCActivity.class);
                startActivityForResult(intent,1);
            }else{
                tag = 0;
                stage.loadUrl(((URL)cur.getData()).getAddress());
            }
        }
    }

    public void goHome(View view)
    {
        Node<URL> tem ;
        tem = cur;
        int position = 0;
        while(tem.getPre() != null)
        {
            tem=tem.getPre();
            position++;
        }

        Link.insert(new URL("home"),position);
        cur = Link.getNode(position+1);
        Intent intent = new Intent(BFHActivity.this,UCActivity.class);
        startActivityForResult(intent,1);
    }

    protected void onActivityResult(int requestCode,int resultCode,Intent data)
    {
        switch(requestCode)
        {   case 1:
            if(resultCode == RESULT_OK)
            {
                String returnData = data.getStringExtra("data_return");
                if(returnData.equals("back"))
                {
                    Log.d("22","BBB");
                    if(cur.getPre() == Link.head)
                    {
                        Log.d("222","BBBb");
                        tag = 0;
                        Toast.makeText(BFHActivity.this,"End",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(BFHActivity.this,UCActivity.class);
                        startActivityForResult(intent,1);
                    }else{
                        cur = cur.getPre();
                        tag =0;
                        stage.loadUrl(((URL)cur.getData()).getAddress());
                    }

                    break;
                }
                else if(returnData.equals("forward"))
                {
                    Log.d("22","FFF");
                    if(cur.getNext()==null)
                    {
                        Toast.makeText(BFHActivity.this,"End",Toast.LENGTH_SHORT).show();
                    }else {
                        cur = cur.getNext();
                        tag = 0;
                        stage.loadUrl(((URL)cur.getData()).getAddress());
                    }
                    break;
                }else {
                    Log.d("22","TTT");
                    tag = 1;
                    stage.loadUrl(returnData);
                    break;
                }
            }
            break;
            default:
        }
    }
}
