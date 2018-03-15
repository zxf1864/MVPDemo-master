package com.example.administrator.mvpdemo.ui.CustomWidgets;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.HorizontalScrollView;

import com.example.administrator.mvpdemo.Adapter.TVReCycleViewPagerAdapter;
import com.example.administrator.mvpdemo.MyReCyclerView.HomeLayoutManager;

/**
 * Created by xiaofeizhang on 2018/2/22.
 */

public class CustomViewPager extends ViewPager{

    private int downX;
    private int downY;
    private int mTouchSlop;

    public CustomViewPager(Context context) {
        super(context);
        mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    public CustomViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }



//    @Override
//    public boolean onInterceptTouchEvent(MotionEvent e) {
//        int action = e.getAction();
//        switch (action) {
//            case MotionEvent.ACTION_DOWN:
//                downX = (int) e.getRawX();
//                downY = (int) e.getRawY();
//                break;
//            case MotionEvent.ACTION_MOVE:
//                int moveY = (int) e.getRawY();
//                if (Math.abs(moveY - downY) > mTouchSlop) {
//                    return true;
//                }
//        }
//        return super.onInterceptTouchEvent(e);
//    }

//    @Override
//    protected boolean canScroll(View v, boolean checkV, int dx, int x, int y) {
//        if (v != this && v instanceof ViewPager) {
//            return true;
//        }
//        return super.canScroll(v, checkV, dx, x, y);
//
//    }


//    @Override
//    protected boolean canScroll(View v, boolean checkV, int dx, int x, int y) {
//
//        TVReCycleViewPagerAdapter viewPager_adapter = (TVReCycleViewPagerAdapter)this.getAdapter();
//        RecyclerView rcv = (RecyclerView)(viewPager_adapter).getPrimaryItem();
//
//        HomeLayoutManager layoutManager = (HomeLayoutManager)rcv.getLayoutManager();
//        //GridLayoutManager layoutManager = (GridLayoutManager)rcv.getLayoutManager();
//
//        if(layoutManager.isSlidingToLast()&&(dx<0))
//            return false;
//        else if(layoutManager.isSlidingToFirst()&&(dx>0))
//            return false;
//        else
//            return true;
//
//    }
}
