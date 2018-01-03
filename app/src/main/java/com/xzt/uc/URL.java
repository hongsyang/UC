package com.xzt.uc;

/**
 * Created by 谢作通 on 2018/1/3.
 */

public class URL
{
    private String address;
    private boolean isBack;
    private boolean isForward;

    public URL(String url)
    {
        this.address = url;
        this.isBack = false;
        this.isForward = false;
    }

    public void setBack(boolean value)
    {
        this.isBack = value;
    }

    public void setForward(boolean value)
    {
        this.isForward = value;
    }

    public boolean isBack() {
        return isBack;
    }

    public boolean isForward() {
        return isForward;
    }

    public String getAddress() {
        return address;
    }
}