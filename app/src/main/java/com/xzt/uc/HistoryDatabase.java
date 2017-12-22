package com.xzt.uc;


import org.litepal.crud.DataSupport;

/**
 * Created by dell on 2017/12/12.
 */

public class HistoryDatabase extends DataSupport{
    final static int hNum = 0;


    private int id;
    private String title;
    private String url;
    private String date;

    public int getId()
    {
        return id;
    }
    public void setId(int id)
    {
        this.id = id;
    }

    public String getTitle()
    {
        return title;
    }
    public void setTitle(String name)
    {
        this.title = name;
    }

    public String getUrl()
    {
        return url;
    }
    public void setUrl(String url)
    {
        this.url = url;
    }

    public String getDate()
    {
        return date;
    }
    public void setDate(String data)
    {
        this.date = data;
    }

}