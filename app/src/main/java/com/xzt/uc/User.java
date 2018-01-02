package com.xzt.uc;

import org.litepal.crud.DataSupport;

/**
 * Created by asus on 2017/12/30.
 */

public class User extends DataSupport {

    private String uid;

    private String password;

    private String nickname;

    private int gender;

    private int number;

    private int imageId;

    public static final int male = 1;

    public static final int female = 2;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public static int getMale() {
        return male;
    }

    public static int getFemale() {
        return female;
    }
}
