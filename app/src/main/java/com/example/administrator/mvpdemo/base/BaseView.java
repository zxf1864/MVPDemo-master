package com.example.administrator.mvpdemo.base;

/**
 * Created by xiaofeizhang on 2018/1/31.
 */

public interface BaseView {

    /**
     * 显示Loading
     */
    void showProgressDialog();

    /**
     * 隐藏Loading
     */
    void hideProgressDialog();

    /**
     * 显示错误信息
     *
     * @param msg 错误信息
     */
    void showError(String msg);
}
