package com.example.administrator.mvpdemo.service.view;

import com.example.administrator.mvpdemo.service.entity.Pgc;

/**
 * Created by xiaofeizhang on 2018/1/30.
 */


public interface PgcView extends View {
    void onSuccess(Pgc mPgc);
    void onError(String result);
}
