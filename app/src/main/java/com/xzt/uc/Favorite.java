package com.xzt.uc;


import org.litepal.crud.DataSupport;

/**
 * Created by 阿雷 on 2017/12/8.
 */

public class Favorite extends DataSupport{
    private String Url;
    private String title;
    private int imageId;
    private int id;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUrl(String url) {
        Url = url;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getUrl(){
        return Url;
    }
    public String getTitle(){
        return title;
    }
    public int getImageId(){
        return imageId;
    }
}
