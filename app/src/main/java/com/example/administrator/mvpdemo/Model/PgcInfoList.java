package com.example.administrator.mvpdemo.Model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiaofeizhang on 2018/2/26.
 */

public class PgcInfoList {

    private static PgcInfoList mPgcInfoList;  //静态变量

    public Map<Object, Object> getmPgcInfos() {
        return mPgcInfos;
    }

    private Map<Object, Object> mPgcInfos = new HashMap<Object,Object>();//使用HashMap作为缓存容器

    private PgcInfoList (){
        mPgcInfos = new HashMap<Object,Object>();//使用HashMap作为缓存容器
    }  //私有构造函数

    public static PgcInfoList getInstance() {
        if (mPgcInfoList == null) {  //第一层校验
            synchronized (PgcInfoList.class) {
                if (mPgcInfoList == null) {  //第二层校验
                    mPgcInfoList = new PgcInfoList();
                }
            }
        }
        return mPgcInfoList;
    }
}
