package com.example.administrator.mvpdemo.MyReCyclerView;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.View;

import com.example.administrator.mvpdemo.event.RxBus;
import com.example.administrator.mvpdemo.event.RxBusBaseMessage;
import com.example.administrator.mvpdemo.event.RxCodeConstants;
import com.example.administrator.mvpdemo.ui.CustomWidgets.FocusView;

/**
 * Created by xiaofeizhang on 2018/3/15.
 */

public class MyRecyclerView extends RecyclerView {
    public boolean JumpBack = false;

    public int Position;

    public MyRecyclerView(Context context,int postion_in_viewpager)
    {
        super(context);

        this.setBackgroundColor(Color.TRANSPARENT);

        Position = postion_in_viewpager;
    }

    private boolean dealKEYCODE_DPAD_RIGHT(View focusView, int dx)
    {
        View rightView = FocusFinder.getInstance().findNextFocus(this, focusView, View.FOCUS_RIGHT);
        if ((rightView != null)&&(rightView instanceof FocusView)) {
            rightView.requestFocusFromTouch();

            if(((FocusView) rightView).isCover())
                this.smoothScrollBy(dx , 0);

            return true;
        }
        else
        {
            if(this.canScrollHorizontally(1) == false)
            {
                ((FocusView)focusView).isRightEdge = true;
                RxBus.getInstance().send(RxCodeConstants.JUMP_2_RIGHT,new RxBusBaseMessage(Position,focusView));
                return true;
            }
            else
            {
                this.smoothScrollBy(dx , 0);
                return true;
            }

        }
    }

    private boolean deal_KEYCODE_DPAD_LEFT(View focusView,int dx)
    {
        View leftView = FocusFinder.getInstance().findNextFocus(this, focusView, View.FOCUS_LEFT);
        if ((leftView != null)&&(leftView instanceof FocusView)) {
            leftView.requestFocusFromTouch();

            if(((FocusView) leftView).isCover())
                this.smoothScrollBy(-dx , 0);

            return true;
        } else {
            if(this.canScrollHorizontally(-1) == false)
            {
                ((FocusView)focusView).isLeftEdge = true;
                RxBus.getInstance().send(RxCodeConstants.JUMP_2_LEFT,new RxBusBaseMessage(Position,focusView));
                return true;
            }
            else
            {
                this.smoothScrollBy(-dx , 0);
                return true;
            }

        }
    }


    private boolean mydispatchKeyEvent(KeyEvent event, View focusView , int dx)
    {
        boolean ret = false;

        switch (event.getKeyCode()) {
            case KeyEvent.KEYCODE_DPAD_RIGHT:
                if (event.getAction() == KeyEvent.ACTION_UP) {
                    return true;
                }
                else {
                    ret = dealKEYCODE_DPAD_RIGHT(focusView,dx);
                }
                break;


            case KeyEvent.KEYCODE_DPAD_LEFT:
                if (event.getAction() == KeyEvent.ACTION_UP) {
                    return true;
                } else {
                    ret =  deal_KEYCODE_DPAD_LEFT(focusView,dx);
                }
                break;
            case KeyEvent.KEYCODE_DPAD_DOWN:
                if (event.getAction() == KeyEvent.ACTION_UP) {
                    return true;
                } else {
                    View downView = FocusFinder.getInstance().findNextFocus(this, focusView, View.FOCUS_DOWN);
                    if ((downView != null)&&(downView instanceof FocusView)) {
                        downView.requestFocusFromTouch();

                        return true;
                    }
                    else
                    {
                        RxBus.getInstance().send(RxCodeConstants.JUMP_2_BOTTOMBAR,new RxBusBaseMessage());
                        return true;
                    }

                }

            case KeyEvent.KEYCODE_DPAD_UP:
                if (event.getAction() == KeyEvent.ACTION_UP) {
                    return true;
                } else {
                    View upView = FocusFinder.getInstance().findNextFocus(this, focusView, View.FOCUS_UP);
                    if ((upView != null)&&(upView instanceof FocusView)) {
                        upView.requestFocusFromTouch();

                        return true;
                    }
                    else
                    {
                        RxBus.getInstance().send(RxCodeConstants.JUMP_2_TOOLBAR,new RxBusBaseMessage());
                        return true;
                    }

                }



        }

        return ret;
    }

//    @Override
//    public boolean dispatchKeyEvent(KeyEvent event) {
//
//        boolean result = false;
//
//        View focusView = this.getFocusedChild();
//
//        if (focusView != null) {
//            int dx = (int)focusView.getX();
//            if (dx <=0)
//                dx = focusView.getWidth()*2;
//            result = mydispatchKeyEvent(event,focusView,dx);
//        }
//
//        return result?true:super.dispatchKeyEvent(event);
//    }

    private long mLastKeyDownTime = 0;
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {long current = System.currentTimeMillis();
        boolean res;
        if (current - mLastKeyDownTime < 150) {
            res = true;
        } else {
            res = super.onKeyDown(keyCode, event);
            mLastKeyDownTime = current;
        }
        return res;
    }
}
