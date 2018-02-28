package com.example.administrator.mvpdemo.service.presenter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.example.administrator.mvpdemo.Model.ChannelInfoList;
import com.example.administrator.mvpdemo.Model.PgcInfoList;
import com.example.administrator.mvpdemo.Model.PgcList;
import com.example.administrator.mvpdemo.Util.RxHelper;
import com.example.administrator.mvpdemo.base.ActivityLifeCycleEvent;
import com.example.administrator.mvpdemo.base.BasePresenter;
import com.example.administrator.mvpdemo.event.RxBus;
import com.example.administrator.mvpdemo.event.RxBusBaseMessage;
import com.example.administrator.mvpdemo.event.RxCodeConstants;
import com.example.administrator.mvpdemo.service.entity.Pgc;
import com.example.administrator.mvpdemo.service.entity.PgcInfo;
import com.example.administrator.mvpdemo.service.manager.DataManager;
import com.example.administrator.mvpdemo.service.view.ITestView;
import com.example.administrator.mvpdemo.ui.activity.MainActivity;

import java.util.List;

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

    private PgcInfo mPgcInfo;


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
                            try
                            {
                                //PgcList.getInstance().getmPgcs().put(mPgc.getData().get(0).getFirst_cate_code(),mPgc);
                            }
                            catch (Exception ex)
                            {
                                Log.e("getPgc", "onComplete: "+ex.toString() );
                            }

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

    public void getPgcInfo(int id,String apikey ,int page,int page_size,int cat,int is_pgc){
        manager.getPgcInfo(id,apikey , page, page_size, cat, is_pgc)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(RxHelper.<PgcInfo>bindUntilEvent(ActivityLifeCycleEvent.DESTROY,this.getActivity().lifecycleSubject)) // onDestroy取消订阅
                .subscribe(new Observer<PgcInfo>() {
                    @Override
                    public void onSubscribe(Disposable d) {


                    }
                    @Override
                    public void onComplete() {
                        if ((mPgcInfo != null)&&(mPgcInfo.getData().getVideos().size() > 0)){
                            //mPgcView.onSuccess(mPgc);
                            //PgcPresenter.super.getView().onSuccess(mPgc);
                            try
                            {
                                if(!PgcInfoList.getInstance().getmPgcInfos().containsKey(id)) {
                                    PgcInfoList.getInstance().getmPgcInfos().put(id, mPgc);
                                }

                                int i = Integer.parseInt(ChannelInfoList.getInstance().ch_map.get(String.valueOf(id)));


                                ChannelInfoList.getInstance().getmChannelInfos().get(i).setmPgcInfo(mPgcInfo);

                                RxBus.getInstance().send(RxCodeConstants.Get_PGC,new RxBusBaseMessage(i,mPgcInfo));


                            }
                            catch (Exception ex)
                            {
                                Log.e("getPgcInfo", "onComplete: " + ex.getMessage());
                            }

                        }
                        else
                        {
                            int i = Integer.parseInt(ChannelInfoList.getInstance().ch_map.get(String.valueOf(id)));

                            RxBus.getInstance().send(RxCodeConstants.Re_Get_PGC,new RxBusBaseMessage(i,new Object()));
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        PgcPresenter.super.getView().onError("请求失败！！");
                    }

                    @Override
                    public void onNext(PgcInfo pgcInfo) {
                        mPgcInfo = pgcInfo;
                    }

                });
    }



}
