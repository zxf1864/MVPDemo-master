package com.example.administrator.mvpdemo.base;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

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
