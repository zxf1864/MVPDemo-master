package com.example.administrator.mvpdemo.event;

/**
 * Created by xiaofeizhang on 2018/2/24.
 */

public class RxBusBaseMessage {
    private int code;
    private Object object;

    public RxBusBaseMessage(int code, Object object) {
        this.code = code;
        this.object = object;
    }

    public RxBusBaseMessage() {

    }



    public int getCode() {
        return code;
    }

    public Object getObject() {
        return object;
    }
}