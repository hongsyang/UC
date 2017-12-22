package com.xzt.uc;

/**
 * Created by 谢作通 on 2017/12/12.
 */

public class WebsiteButton
{
    private String name;
    private int imageId;

    public WebsiteButton(String name, int imageId)
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
