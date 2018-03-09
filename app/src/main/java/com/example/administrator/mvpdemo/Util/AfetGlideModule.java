package com.example.administrator.mvpdemo.Util;

import android.content.Context;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool;
import com.bumptech.glide.load.engine.cache.ExternalCacheDiskCacheFactory;
import com.bumptech.glide.load.engine.cache.LruResourceCache;
import com.bumptech.glide.load.engine.cache.MemorySizeCalculator;
import com.bumptech.glide.module.GlideModule;

/**
 * Created by xiaofeizhang on 2018/3/8.
 */

public class AfetGlideModule implements GlideModule {

@Override
public void applyOptions(Context context, GlideBuilder builder) {
        //获取内存计算器
        MemorySizeCalculator calculator = new MemorySizeCalculator(context);

        //获取Glide默认内存缓存大小
        int  defaultMemoryCacheSize = calculator.getMemoryCacheSize();
        //获取Glide默认图片池大小
        int  defaultBitmapPoolSize  = calculator.getBitmapPoolSize();
        //将数值修改为之前的1.1倍
        int  myMemoryCacheSize  = (int) (1.1 * defaultMemoryCacheSize);
        int  myBitmapPoolSize   = (int) (1.1 * defaultBitmapPoolSize);
        //修改默认值
        builder.setMemoryCache(new LruResourceCache(myMemoryCacheSize));
        builder.setBitmapPool(new LruBitmapPool(myBitmapPoolSize));

        //设置磁盘缓存
        builder.setDiskCache(new ExternalCacheDiskCacheFactory(context, myMemoryCacheSize));

        builder.setDecodeFormat(DecodeFormat.PREFER_ARGB_8888);
        }

        @Override
        public void registerComponents(Context context, Glide glide) {

        }

}
