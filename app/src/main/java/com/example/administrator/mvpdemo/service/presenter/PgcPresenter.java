package com.example.administrator.mvpdemo.service.presenter;

import android.content.Context;
import android.content.Intent;


import com.example.administrator.mvpdemo.Util.RxHelper;
import com.example.administrator.mvpdemo.base.ActivityLifeCycleEvent;
import com.example.administrator.mvpdemo.base.BasePresenter;
import com.example.administrator.mvpdemo.base.BaseView;
import com.example.administrator.mvpdemo.service.entity.Pgc;
import com.example.administrator.mvpdemo.service.manager.DataManager;

import com.example.administrator.mvpdemo.service.view.ITestView;
import com.example.administrator.mvpdemo.service.view.PgcView;
import com.example.administrator.mvpdemo.service.view.View;


import com.example.administrator.mvpdemo.ui.activity.MainActivity;
import com.google.gson.Gson;
import com.trello.rxlifecycle2.LifecycleProvider;
import com.trello.rxlifecycle2.android.ActivityEvent;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


/**
 * Created by xiaofeizhang on 2018/1/30.
 */

public class PgcPresenter extends BasePresenter<ITestView,MainActivity> implements Presenter {

    private DataManager manager;
    //private CompositeSubscription mCompositeSubscription;
    private Context mContext;
    //private PgcView mPgcView;
    private Pgc mPgc;



    public PgcPresenter(ITestView view, MainActivity activity) {
        super(view,activity);
        //this.mContext = mContext;

        onCreate();
    }

    @Override
    public void onCreate() {
        manager = new DataManager(mContext);
        //mCompositeSubscription = new CompositeSubscription();
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {
//        if (mCompositeSubscription.hasSubscriptions()){
//            mCompositeSubscription.unsubscribe();
//        }
    }

    @Override
    public void pause() {

    }

//    @Override
//    public void attachView(View view) {
//        mPgcView = (PgcView)view;
//    }

    @Override
    public void attachIncomingIntent(Intent intetn) {
    }
    public void getPgc(int id,String apikey){
        manager.getPgc(id,apikey)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(RxHelper.<Pgc>bindUntilEvent(ActivityLifeCycleEvent.DESTROY,this.getActivity().lifecycleSubject)) // onDestroy取消订阅
                .subscribe(new Observer<Pgc>() {
                    @Override
                    public void onSubscribe(Disposable d) {


                    }
                    @Override
                    public void onComplete() {
                        if (mPgc != null){
                            //mPgcView.onSuccess(mPgc);
                            PgcPresenter.super.getView().onSuccess(mPgc);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        PgcPresenter.super.getView().onError("请求失败！！");
                    }

                    @Override
                    public void onNext(Pgc Pgc) {
                        mPgc = Pgc;
                    }

                });
    }
}
