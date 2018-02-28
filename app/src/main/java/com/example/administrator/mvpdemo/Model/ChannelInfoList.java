package com.example.administrator.mvpdemo.Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xiaofeizhang on 2018/2/26.
 */

public class ChannelInfoList {

    public static String[] keyList ={"28","29","30","31","32","34"};
    public static String[] catList ={"125104","126119","127100","128020","129123","131113"};

    public Map<String,String> ch_map;

    private static ChannelInfoList mChannelInfoList;  //静态变量

    public List<ChannelInfo> getmChannelInfos() {
        return mChannelInfos;
    }

    private List<ChannelInfo> mChannelInfos;

    private ChannelInfoList (){
        mChannelInfos = new ArrayList<>();

        ch_map = new HashMap<>();

        ch_map.put("28","0");
        ch_map.put("29","1");
        ch_map.put("30","2");
        ch_map.put("31","3");
        ch_map.put("32","4");
        ch_map.put("34","5");


    }  //私有构造函数

    public static ChannelInfoList getInstance() {
        if (mChannelInfoList == null) {  //第一层校验
            synchronized (ChannelInfoList.class) {
                if (mChannelInfoList == null) {  //第二层校验
                    mChannelInfoList = new ChannelInfoList();
                }
            }
        }
        return mChannelInfoList;
    }


}
