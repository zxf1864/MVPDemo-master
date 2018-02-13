package com.example.administrator.mvpdemo.Util;

import android.support.annotation.NonNull;

import com.example.administrator.mvpdemo.base.ActivityLifeCycleEvent;
import com.example.administrator.mvpdemo.service.entity.HttpResult;


import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;


/**
 * Created by xiaofeizhang on 2018/2/2.
 */


public class RxHelper {

    /**
     * 利用Observable.takeUntil()停止网络请求
     *
     * @param event
     * @param lifecycleSubject
     * @param <T>
     * @return
     */
    @NonNull
    public static  <T> ObservableTransformer<T, T> bindUntilEvent(@NonNull final ActivityLifeCycleEvent event, final PublishSubject<ActivityLifeCycleEvent> lifecycleSubject) {
        return new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource<T> apply(Observable<T> upstream) {
                Observable<ActivityLifeCycleEvent> compareLifecycleObservable =
                        lifecycleSubject.filter(
                                new Predicate<ActivityLifeCycleEvent>() {
                                    @Override
                                    public boolean test(ActivityLifeCycleEvent activityLifeCycleEvent) throws Exception {
                                        return activityLifeCycleEvent.equals(event);
                                    }
                                }
                        ).take(1);
                return upstream.takeUntil(compareLifecycleObservable);
            }
        };
    }




    /**
     * @param <T>
     * @return
     */
//    public static <T> Observable.Transformer<HttpResult<T>, T> handleResult(final ActivityLifeCycleEvent event, final PublishSubject<ActivityLifeCycleEvent> lifecycleSubject) {
//        return new Observable.Transformer<HttpResult<T>, T>() {
//            @Override
//            public Observable<T> call(Observable<HttpResult<T>> tObservable) {
//                Observable<ActivityLifeCycleEvent> compareLifecycleObservable =
//                        lifecycleSubject.takeFirst(new Func1<ActivityLifeCycleEvent, Boolean>() {
//                            @Override
//                            public Boolean call(ActivityLifeCycleEvent activityLifeCycleEvent) {
//                                return activityLifeCycleEvent.equals(event);
//                            }
//                        });
//                return tObservable.flatMap(new Func1<HttpResult<T>, Observable<T>>() {
//                    @Override
//                    public Observable<T> call(HttpResult<T> result) {
//                        if (result.getCount() != 0) {
//                            return createData(result.getSubjects());
//                        } else {
//                            return Observable.error(new ApiException(result.getCount()));
//                        }
//                    }
//                }).takeUntil(compareLifecycleObservable).subscribeOn(Schedulers.io()).unsubscribeOn(Schedulers.io()).subscribeOn(AndroidSchedulers.mainThread()).observeOn(AndroidSchedulers.mainThread());
//            }
//        };
//    }

    /**
     *
     *
     */


    /**
     * 创建成功的数据
     *
     * @param data
     * @param <T>
     * @return
     */
//    private static <T> Observable<T> createData(final T data) {
//        return Observable.create(new Observable.OnSubscribe<T>() {
//            @Override
//            public void call(Subscriber<? super T> subscriber) {
//                try {
//                    subscriber.onNext(data);
//                    subscriber.onCompleted();
//                } catch (Exception e) {
//                    subscriber.onError(e);
//                }
//            }
//        });
//
//    }

}
