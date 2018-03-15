package com.example.administrator.mvpdemo.ui.CustomWidgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.HorizontalScrollView;
import android.widget.ScrollView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaofeizhang on 2018/3/14.
 */


public class CHScrollView_V extends ScrollView {

    private Context context;
    float startx = 0;
    float offset;

    public CHScrollView_V(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.context = context;
    }

    public CHScrollView_V(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    public CHScrollView_V(Context context) {
        super(context);
        this.context = context;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        // 进行触摸赋值
        CHScrollViewVHelper.mTouchView = this;
        return super.onTouchEvent(ev);

    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        // 当当前的CHSCrollView被触摸时，滑动其它
        if (CHScrollViewVHelper.mTouchView == this) {
            onScrollChanged(l, t, oldl, oldt, 0);
        } else {
            super.onScrollChanged(l, t, oldl, oldt);
        }
    }

    public void onScrollChanged(int l, int t, int oldl, int oldt, int none) {
        for (CHScrollView_V scrollView : CHScrollViewVHelper.mHScrollViews) {
            // 防止重复滑动
            if (CHScrollViewVHelper.mTouchView != scrollView)
                scrollView.smoothScrollTo(l, t);
        }
    }

    public static class CHScrollViewVHelper {
        public static ScrollView mTouchView;
        public static List<CHScrollView_V> mHScrollViews = new ArrayList<CHScrollView_V>();

        public static void addHViews(final CHScrollView_V VScrollView, AutoListView autoListView) {
            if (!CHScrollViewVHelper.mHScrollViews.isEmpty()) {
                int size = CHScrollViewVHelper.mHScrollViews.size();
                CHScrollView_V scrollView = CHScrollViewVHelper.mHScrollViews.get(size - 1);
                final int scrollY = scrollView.getScrollY();
                // 第一次满屏后，向下滑动，有一条数据在开始时未加入
                if (scrollY != 0) {
                    autoListView.post(new Runnable() {
                        @Override
                        public void run() {
                            // 当listView刷新完成之后，把该条移动到最终位置
                            VScrollView.scrollTo(0, scrollY);
                        }
                    });
                }
            }
            CHScrollViewVHelper.mHScrollViews.add(VScrollView);
        }
    }
}
