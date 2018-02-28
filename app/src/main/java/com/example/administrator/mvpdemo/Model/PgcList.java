package com.example.administrator.mvpdemo.Model;

import com.example.administrator.mvpdemo.service.entity.Pgc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xiaofeizhang on 2018/2/26.
 */

//饿汉式单例类.在类初始化时，已经自行实例化
//public class Singleton {
//    //static修饰的静态变量在内存中一旦创建，便永久存在
//    private static Singleton instance = new Singleton();
//    private Singleton (){}
//    public static Singleton getInstance() {
//        return instance;
//    }
//}


//    DCL双重校验模式
//public class Singleton {
//    private static Singleton singleton;  //静态变量
//    private Singleton (){}  //私有构造函数
//    public static Singleton getInstance() {
//        if (singleton == null) {  //第一层校验
//            synchronized (Singleton.class) {
//                if (singleton == null) {  //第二层校验
//                    singleton = new Singleton();
//                }
//            }
//        }
//        return singleton;
//    }
//}


//静态内部类单例模式
//public class Singleton {
//    private Singleton (){} ;//私有的构造函数
//    public static final Singleton getInstance() {
//        return SingletonHolder.INSTANCE;
//    }
//    //定义的静态内部类
//    private static class SingletonHolder {
//        private static final Singleton INSTANCE = new Singleton();  //创建实例的地方
//    }
//}

//    枚举单例
//public enum Singleton {  //enum枚举类
//    INSTANCE;
//    public void whateverMethod() {
//
//    }
//}

//使用容器实现单例模式
//public class SingletonManager {
//　　private static Map<String, Object> objMap = new HashMap<String,Object>();//使用HashMap作为缓存容器
//　　private Singleton() {
//　　}
//　　public static void registerService(String key, Objectinstance) {
//　　　　if (!objMap.containsKey(key) ) {
//　　　　　　objMap.put(key, instance) ;//第一次是存入Map
//　　　　}
//　　}
//　　public static ObjectgetService(String key) {
//　　　　return objMap.get(key) ;//返回与key相对应的对象
//　　}
//}

public class PgcList {

    private static PgcList mPgcList;  //静态变量

    public Map<Object, Object> getmPgcs() {
        return mPgcs;
    }

    private Map<Object, Object> mPgcs = new HashMap<Object,Object>();//使用HashMap作为缓存容器

    private PgcList (){
        mPgcs = new HashMap<Object,Object>();//使用HashMap作为缓存容器
    }  //私有构造函数

    public static PgcList getInstance() {
        if (mPgcList == null) {  //第一层校验
            synchronized (PgcList.class) {
                if (mPgcList == null) {  //第二层校验
                    mPgcList = new PgcList();
                }
            }
        }
        return mPgcList;
    }

}
