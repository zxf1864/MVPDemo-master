package com.example.administrator.mvpdemo.ui.CustomWidgets;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import com.example.administrator.mvpdemo.Adapter.HomeAdapter;
import com.example.administrator.mvpdemo.Util.AnimationUtil;
import com.example.administrator.mvpdemo.Util.Constants;

/**
 * Created by xiaofeizhang on 2018/2/28.
 */

public class FocusView extends RelativeLayout {

    public FocusView(Context context) {
        super(context);

    }

    public FocusView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

    }

    public FocusView(Context context, AttributeSet attrs) {
        super(context, attrs);

    }

    public boolean isTopEdge =false;
    public boolean isBottomEdge = false;
    public boolean isLeftEdge = false;
    public boolean isRightEdge = false;

    public boolean isShow = false;
    public boolean hasGlideShow = false;

    public int itemIndex;

    public RectF bounds = new RectF();


    /**
     * 检测是否被遮住显示不全
     * @return
     */
    public boolean isCover() {
        boolean cover = false;
        Rect rect = new Rect();
        cover = getGlobalVisibleRect(rect);

        int w = getMeasuredWidth();
        int h = getMeasuredHeight();

        int rw = rect.width();
        int rh = rect.height();

        if (cover) {
            if (rw >= w) {
               cover = false;
            }
        }
        return cover;
    }

}
