package com.example.administrator.mvpdemo.service;



import com.example.administrator.mvpdemo.service.entity.Book;
import com.example.administrator.mvpdemo.service.entity.Pgc;
import com.example.administrator.mvpdemo.service.entity.PgcInfo;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;


/**
 * Created by win764-1 on 2016/12/12.
 */

public interface RetrofitService {
    @GET("book/search")
    Observable<Book> getSearchBooks(@Query("q") String name,
                                    @Query("tag") String tag, @Query("start") int start,
                                    @Query("count") int count);


    //http://open.mb.hd.sohu.com/v4/category/catecode/28.json?api_key=370f37af1847ee3308e77f86629f3955
    @Headers(RetrofitHelper.CACHE_CONTROL_AGE + RetrofitHelper.CACHE_STALE_SHORT)
    @GET("category/catecode/{id}.json")
    Observable<Pgc> getPgc(@Path("id") int id, @Query("api_key") String apikey);

    //http://open.mb.hd.sohu.com/v4/category/channel/28.json?api_key=370f37af1847ee3308e77f86629f3955&page=1&page_size=20&cat=125104&is_pgc=1
    //http://open.mb.hd.sohu.com/v4/category/channel/29.json?api_key=370f37af1847ee3308e77f86629f3955&page=1&page_size=20&cat=126119&is_pgc=1
    //http://open.mb.hd.sohu.com/v4/category/channel/30.json?api_key=370f37af1847ee3308e77f86629f3955&page=1&page_size=20&cat=127100&is_pgc=1
    //http://open.mb.hd.sohu.com/v4/category/channel/31.json?api_key=370f37af1847ee3308e77f86629f3955&page=1&page_size=20&cat=128020&is_pgc=1
    //http://open.mb.hd.sohu.com/v4/category/channel/32.json?api_key=370f37af1847ee3308e77f86629f3955&page=1&page_size=20&cat=129123&is_pgc=1
    //http://open.mb.hd.sohu.com/v4/category/channel/34.json?api_key=370f37af1847ee3308e77f86629f3955&page=1&page_size=20&cat=131113&is_pgc=1

    @Headers(RetrofitHelper.CACHE_CONTROL_AGE + RetrofitHelper.CACHE_STALE_SHORT)
    @GET("category/channel/{id}.json")
    Observable<PgcInfo> getPgcInfo(@Path("id") int id,
                               @Query("api_key") String apikey,
                               @Query("page") int page,
                               @Query("page_size") int page_size,
                               @Query("cat") int cat,
                               @Query("is_pgc") int is_pgc);

}
