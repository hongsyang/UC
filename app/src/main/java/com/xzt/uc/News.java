package com.xzt.uc;

/**
 * Created by 谢作通 on 2017/12/22.
 */

public class News
{
    private String name;
    private int imageId;

    public News(String name, int imageId)
    {
        this.name = name;
        this.imageId = imageId;
    }

    public String getName()
    {
        return name;
    }

    public int getImageId()
    {
        return imageId;
    }
}
