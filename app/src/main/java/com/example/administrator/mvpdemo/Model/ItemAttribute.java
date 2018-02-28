package com.example.administrator.mvpdemo.Model;

import retrofit2.http.PUT;

/**
 * Created by xiaofeizhang on 2018/2/27.
 */

public class ItemAttribute {
    public int ItemType;

    public enum  VideoItemType
    {
        FIRSTBLOCK,
        BANNER,
        TVBLOCK,
        BLOCK,
        ROUNDBLOCK,
        NOTEXTBLOCK,
        TEXTBLOCK
    }
}


