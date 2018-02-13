package com.example.administrator.mvpdemo.service;



import com.example.administrator.mvpdemo.service.entity.Book;
import com.example.administrator.mvpdemo.service.entity.Pgc;

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



    @Headers(RetrofitHelper.CACHE_CONTROL_AGE + RetrofitHelper.CACHE_STALE_SHORT)
    @GET("category/catecode/{id}.json")
    Observable<Pgc> getPgc(@Path("id") int id, @Query("api_key") String apikey);

}
