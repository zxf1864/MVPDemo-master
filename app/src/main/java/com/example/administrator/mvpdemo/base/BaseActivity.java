package com.example.administrator.mvpdemo.base;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import org.reactivestreams.Subscription;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.subjects.PublishSubject;

/**
 * Created by xiaofeizhang on 2018/1/31.
 */
//
//public abstract class BaseActivity extends RxAppCompatActivity {
//
//
//}

public abstract class BaseActivity extends AppCompatActivity {

    protected Context mContext;
    protected Unbinder unBinder;

    private Subscription mSubscription;

    public final PublishSubject<ActivityLifeCycleEvent> lifecycleSubject = PublishSubject.create();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        lifecycleSubject.onNext(ActivityLifeCycleEvent.CREATE);
        super.onCreate(savedInstanceState);

        setContentView(getContentViewId());
        mContext = this;
        unBinder = ButterKnife.bind(this);

        init();

        Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() {
            @Override
            public boolean queueIdle() {
                Log.i("IdleHandler","queueIdle");
                onInit();
                return false; //false 表示只监听一次IDLE事件,之后就不会再执行这个函数了.
            }
        });

    }

    //子类重写此函数即可,而不需要在onCreate()中去初始化.
    protected void onInit() {
        Log.e("BaseActivity", "onInit");
    }

    @Override
    protected void onPause() {
        lifecycleSubject.onNext(ActivityLifeCycleEvent.PAUSE);
        super.onPause();
    }

    @Override
    protected void onStop() {
        lifecycleSubject.onNext(ActivityLifeCycleEvent.STOP);
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        lifecycleSubject.onNext(ActivityLifeCycleEvent.DESTROY);
    }

    /**
     * 获取显示view的xml文件ID
     */
    protected abstract int getContentViewId();

    protected abstract void init();


//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        //主动解除订阅关系
//        if (mSubscription != null && !mSubscription.isUnsubscribed()) {
//            mSubscription.unsubscribe();
//        }
//    }

}
