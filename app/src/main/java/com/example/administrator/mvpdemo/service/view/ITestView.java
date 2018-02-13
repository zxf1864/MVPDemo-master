package com.example.administrator.mvpdemo.service.view;

import com.example.administrator.mvpdemo.service.entity.Pgc;

/**
 * Created by xiaofeizhang on 2018/2/5.
 */

public interface ITestView {

    public void onSuccess(Pgc mPgc);
    public void onError(String result);
}
