package com.example.administrator.mvpdemo.Model;

import android.graphics.RectF;

import com.example.administrator.mvpdemo.service.entity.PgcInfo;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaofeizhang on 2018/2/26.
 */

public class ChannelInfo {

    public String getMkey() {
        return mkey;
    }


    private String mkey;

    public String getCat() {
        return cat;
    }

    private String cat;

    private String mlayoutstr;


    public float leftbound = 0.0f;
    public float rightbound ;
    public float topbound  = 0.0f;
    public float bottombound = 800.0f;

    private float findright()
    {
       float max =0;
       for(int i = 0; i <mItemRectFList.size();i++)
       {
           if (mItemRectFList.get(i).right > max)
               max = mItemRectFList.get(i).right;
       }
       return max;
    }



    public ArrayList<RectF> getmItemRectFList() {
        return mItemRectFList;
    }

    private ArrayList<RectF> mItemRectFList;

    public void setmPgcInfo(PgcInfo mPgcInfo) {
        this.mPgcInfo = mPgcInfo;
        Videos = mPgcInfo.getData().getVideos();

        if(Videos.size() == 20)
            isDataOver = true;

    }

    public List<ItemAttribute> getItemAttributeS() {
        return ItemAttributeS;
    }

    public List<ItemAttribute> ItemAttributeS;

    public boolean isDataOver = false;

    public int requestCount = 0;

    public PgcInfo getmPgcInfo() {
        return mPgcInfo;
    }

    public List<PgcInfo.DataBean.VideosBean> Videos;

    private PgcInfo mPgcInfo;

   public ChannelInfo(String key,String Catstr,String layoutstr,ItemAttribute.VideoItemType[] types)
   {
       mkey = key;
       cat = Catstr;
       mlayoutstr = layoutstr;

       mItemRectFList = new Gson().fromJson(mlayoutstr, new TypeToken<ArrayList<RectF>>() {
       }.getType());

       Videos = new ArrayList<>();

       ItemAttributeS = new ArrayList<>();

       for (int i = 0;i<mItemRectFList.size();i++)
       {
           PgcInfo.DataBean.VideosBean vb = new PgcInfo.DataBean.VideosBean();

           Videos.add(vb);

           ItemAttribute ia = new ItemAttribute();
           ia.ItemType = types[i];

           ItemAttributeS.add(ia);
       }

       rightbound = findright();
   }

}
