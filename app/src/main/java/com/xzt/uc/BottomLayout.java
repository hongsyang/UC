package com.xzt.uc;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

/**
 * Created by T on 2017/12/17.
 */

public class BottomLayout extends LinearLayout {
    public BottomLayout(Context context){
        super(context,null);
    }
    public BottomLayout(final Context context, AttributeSet attrs){
        super(context,attrs);
        LayoutInflater.from(context).inflate(R.layout.bottom,this);


    }

}
