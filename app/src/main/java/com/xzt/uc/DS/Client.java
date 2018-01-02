package com.xzt.uc.DS;

import android.graphics.Bitmap;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.xzt.uc.BFHActivity;
import com.xzt.uc.URL;

/**
 * Created by dell on 2017/12/27.
 */

public class Client extends WebViewClient {

    private TextView t;

    public Client(TextView t)
    {
        this.t = t;
    }

    public boolean shouldOverrideUrlLoading(WebView view,String url)
    {
        view.loadUrl(url);
        return true;
    }

    public void onPageStarted(WebView view,String url,Bitmap favicon)
    {
        super.onPageStarted(view,url,favicon);
        Node<URL> tem ;
        tem = BFHActivity.cur;
        int position = 0;
        while(tem.getPre() != null)
        {
            tem=tem.getPre();
            position++;
        }
        String s = position+"后"+url;Log.d("ssss",s);
        if(BFHActivity.tag == 1)
        {
            BFHActivity.Link.insert(new URL(url),position);
            BFHActivity.cur = BFHActivity.Link.getNode(position+1);
        }
        BFHActivity.tag = 1;
        String ss = BFHActivity.Link.getSize()+"当前链表";Log.d("ssss",ss);
        t.setText(url);
    }

}
