package com.example.administrator.mvpdemo.service.manager;

import android.content.Context;


import com.example.administrator.mvpdemo.service.RetrofitService;
import com.example.administrator.mvpdemo.service.RetrofitHelper;
import com.example.administrator.mvpdemo.service.entity.Book;
import com.example.administrator.mvpdemo.service.entity.Pgc;
import com.example.administrator.mvpdemo.service.entity.PgcInfo;

import io.reactivex.Observable;


/**
 * Created by win764-1 on 2016/12/12.
 */

public class DataManager {
    private RetrofitService mRetrofitService;
    public DataManager(Context context){
        this.mRetrofitService = RetrofitHelper.getInstance(context).getServer();
    }
    public Observable<Book> getSearchBooks(String name, String tag, int start, int count){
        return mRetrofitService.getSearchBooks(name,tag,start,count);
    }


    public  Observable<Pgc> getPgc(int catid, String apikey){
        return mRetrofitService.getPgc(catid,apikey);
    }

    public  Observable<PgcInfo> getPgcInfo(int catid, String apikey ,int page,int page_size,int cat,int is_pgc){
        return mRetrofitService.getPgcInfo(catid,apikey,page,page_size,cat,is_pgc);
    }
}
