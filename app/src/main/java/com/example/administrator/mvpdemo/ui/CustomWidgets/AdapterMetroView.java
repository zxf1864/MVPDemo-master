package com.example.administrator.mvpdemo.ui.CustomWidgets;

/**
 * Created by xiaofeizhang on 2018/2/11.
 */

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.example.administrator.mvpdemo.R;
import com.example.administrator.mvpdemo.Util.AnimationUtil;
import com.example.administrator.mvpdemo.Util.Constants;

/**
 * 获得焦点后凸显特效 实用与RecyclerView item布局
 *
 * @author chailiwei
 * @since 2015.01.08 13:40
 */
@SuppressLint("NewApi")
public class AdapterMetroView extends RelativeLayout {

    private Rect mBound;
    private Drawable mDrawable;
    private Rect mRect;
    private AnimatorSet scaleAnimation;
    private int shadowWidth;
    private int topShadowWidth;
    private int bottomShadowWidth;
    private int leftShadowWidth;
    private int rightShadowWidth;
    private Context context;
    private static final int refresh = 40;
    private boolean isRefresh = false;
    private boolean hasAnim = true;



    private int myWidth = 320;
    private int myHeight = 180;

    public void SetMyWH(int w,int h)
    {
        myWidth = w;
        myHeight=h;
    }

    private Handler mStartHandler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case refresh:
                    if (isRefresh) {
                        getRootView().invalidate();
                        mStartHandler.sendEmptyMessageDelayed(refresh, 10);
                    }
                    break;
            }
        }

        ;
    };



    public AdapterMetroView(Context context) {
        super(context);
        init(context, null);
    }

    public AdapterMetroView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context, attrs);
    }

    public AdapterMetroView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    protected void init(Context context, AttributeSet attrs) {
        this.context = context;
        setWillNotDraw(false);
        mRect = new Rect();
        mBound = new Rect();
        if (attrs != null) {
            TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.MetroView);
            mDrawable = a.getDrawable(R.styleable.MetroView_android_src);
            shadowWidth = a.getDimensionPixelSize(R.styleable.MetroView_shadowingWidth, 0);
            hasAnim = a.getBoolean(R.styleable.MetroView_hasAnim, true);
            if (shadowWidth == 0) {
                topShadowWidth = a.getDimensionPixelSize(R.styleable.MetroView_topShadowingWidth, getResources().getDimensionPixelOffset(R.dimen.dp_2));
                bottomShadowWidth = a.getDimensionPixelSize(R.styleable.MetroView_bottomShadowingWidth, getResources().getDimensionPixelOffset(R.dimen.dp_2));
                leftShadowWidth = a.getDimensionPixelSize(R.styleable.MetroView_leftShadowingWidth, getResources().getDimensionPixelOffset(R.dimen.dp_2));
                rightShadowWidth = a.getDimensionPixelSize(R.styleable.MetroView_rightShadowingWidth, getResources().getDimensionPixelOffset(R.dimen.dp_2));
            } else {
                topShadowWidth = shadowWidth;
                bottomShadowWidth = shadowWidth;
                leftShadowWidth = shadowWidth;
                rightShadowWidth = shadowWidth;
            }
            a.recycle();
        }
        if (mDrawable == null) {
            mDrawable = getResources().getDrawable(R.drawable.shadow);
        }
        setChildrenDrawingOrderEnabled(true);
    }


    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

//    @Override
//    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//
//
//        // 获取宽-测量规则的模式和大小
//        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
//        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
//
//        // 获取高-测量规则的模式和大小
//        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
//        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
//
//        // 设置wrap_content的默认宽 / 高值
//        // 默认宽/高的设定并无固定依据,根据需要灵活设置
//        // 类似TextView,ImageView等针对wrap_content均在onMeasure()对设置默认宽 / 高值有特殊处理,具体读者可以自行查看
//        int mWidth = 400;
//        int mHeight = 400;
//
//        // 当布局参数设置为wrap_content时，设置默认值
//        if (getLayoutParams().width == ViewGroup.LayoutParams.WRAP_CONTENT && getLayoutParams().height == ViewGroup.LayoutParams.WRAP_CONTENT) {
//            setMeasuredDimension(mWidth, mHeight);
//            // 宽 / 高任意一个布局参数为= wrap_content时，都设置默认值
//        } else if (getLayoutParams().width == ViewGroup.LayoutParams.WRAP_CONTENT) {
//            setMeasuredDimension(mWidth, heightSize);
//        } else if (getLayoutParams().height == ViewGroup.LayoutParams.WRAP_CONTENT) {
//            setMeasuredDimension(widthSize, mHeight);
//        }
//    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        super.onMeasure(widthMeasureSpec, heightMeasureSpec);


        setMeasuredDimension(myWidth, myHeight);
    }


    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (hasFocus() && mDrawable != null) {
            super.getDrawingRect(mRect);
            mBound.set(-leftShadowWidth + mRect.left, -topShadowWidth + mRect.top, rightShadowWidth + mRect.right, bottomShadowWidth + mRect.bottom);
            mDrawable.setBounds(mBound);
            canvas.save();
            mDrawable.draw(canvas);
            canvas.restore();
            if (isRefresh) {
                mStartHandler.sendEmptyMessageDelayed(refresh, 10);
            }
        }
        super.onDraw(canvas);
    }

    @Override
    protected void onFocusChanged(boolean gainFocus, int direction, Rect previouslyFocusedRect) {
        super.onFocusChanged(gainFocus, direction, previouslyFocusedRect);
        if (null != scaleAnimation) {
            scaleAnimation.cancel();
            scaleAnimation = null;
        }

        if (gainFocus) {
            //bringToFront();
            getRootView().requestLayout();
            getRootView().invalidate();
            if (hasAnim) {
                scaleAnimation = AnimationUtil.startScaleToBigAnimation(this, Constants.SCALE_RATE, new Animator.AnimatorListener() {

                    @Override
                    public void onAnimationStart(Animator arg0) {
                        isRefresh = true;
                    }

                    @Override
                    public void onAnimationRepeat(Animator arg0) {
                    }

                    @Override
                    public void onAnimationEnd(Animator arg0) {
                        getRootView().invalidate();
                        isRefresh = false;
                    }

                    @Override
                    public void onAnimationCancel(Animator arg0) {
                    }
                });
            }


        } else {
            if (hasAnim) {
                scaleAnimation = AnimationUtil.startScaleToSmallAnimation(this, Constants.SCALE_RATE, null);
            }
        }
    }

    public void onClicked()
    {
        scaleAnimation = AnimationUtil.startScaleToBigAnimation(this, Constants.SCALE_RATE, new Animator.AnimatorListener() {

            @Override
            public void onAnimationStart(Animator arg0) {
                isRefresh = true;
            }

            @Override
            public void onAnimationRepeat(Animator arg0) {
            }

            @Override
            public void onAnimationEnd(Animator arg0) {
                getRootView().invalidate();
                isRefresh = false;
            }

            @Override
            public void onAnimationCancel(Animator arg0) {
            }
        });
    }
}