package com.example.administrator.mvpdemo.ui.view;

import android.content.Context;
import android.view.View;

import com.example.administrator.mvpdemo.base.BaseView;

/**
 * Created by xiaofeizhang on 2018/2/7.
 */

public class CustomTVview extends View implements BaseView {


    public CustomTVview(Context context) {
        super(context);

    }



    /**
     * 显示Loading
     */
    @Override
    public void showProgressDialog()
    {}

    /**
     * 隐藏Loading
     */
    @Override
    public void hideProgressDialog()
    {}

    /**
     * 显示错误信息
     *
     * @param msg 错误信息
     */
    @Override
    public void showError(String msg)
    {}


}
