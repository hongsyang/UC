package com.xzt.uc;


/**
 * Created by 阿雷 on 2017/12/6.
 */

public class History {
    private boolean tag;
    private String Url;
    private String title;
    private int id;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setTag(boolean tag){
        this.tag=tag;
    }
    public String getUrl(){
        return Url;
    }
    public String getTitle(){
        return title;
    }
    public boolean gettag(){return tag;}
    public void setUrl(String url){this.Url=url;}
    public void setTitle(String title){this.title=title;}

}
