package com.xzt.uc;

/**
 * Created by dell on 2017/12/20.
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