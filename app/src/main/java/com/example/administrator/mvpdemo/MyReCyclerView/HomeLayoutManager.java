package com.example.administrator.mvpdemo.MyReCyclerView;

import android.graphics.Rect;
import android.graphics.RectF;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.example.administrator.mvpdemo.ui.CustomWidgets.AdapterMetroView;
import com.example.administrator.mvpdemo.ui.CustomWidgets.ImageCycleView;

import java.util.ArrayList;

import static android.support.v7.widget.RecyclerView.HORIZONTAL;

/**
 * Created by xlg on 2017/5/17.
 */

public class HomeLayoutManager extends RecyclerView.LayoutManager {
    private LayoutState mLayoutState;
    private ArrayList<RectF> mItemRectFList;

    //用来判断是否到边界了
    private int mTotalW;

    //主要用来标志item是否已在当前界面上
    private final HiveBucket mBooleanMap = new HiveBucket();

    public HomeLayoutManager(ArrayList<RectF> itemRectFList) {
        mItemRectFList = itemRectFList;
        init();
        //this.setAutoMeasureEnabled(true);
    }

    private void init() {
        mLayoutState = new LayoutState();

        mBooleanMap.reset();
    }


//    private int[] mMeasuredDimension = new int[2];
//
//    @Override
//    public void onMeasure(RecyclerView.Recycler recycler, RecyclerView.State state, int widthSpec, int heightSpec) {
//        final int widthMode = View.MeasureSpec.getMode(widthSpec);
//        final int heightMode = View.MeasureSpec.getMode(heightSpec);
//        final int widthSize = View.MeasureSpec.getSize(widthSpec);
//        final int heightSize = View.MeasureSpec.getSize(heightSpec);
//        int width = 0;
//        int height = 0;
//        for (int i = 0; i < getItemCount(); i++) {
//            measureScrapChild(recycler, i,
//                    View.MeasureSpec.makeMeasureSpec(i, View.MeasureSpec.UNSPECIFIED),
//                    View.MeasureSpec.makeMeasureSpec(i, View.MeasureSpec.UNSPECIFIED),
//                    mMeasuredDimension);
//
//            width = width + mMeasuredDimension[0];
//            if (i == 0) {
//                height = mMeasuredDimension[1];
//            }
//
//
//        }
//        switch (widthMode) {
//            case View.MeasureSpec.EXACTLY:
//                width = widthSize;
//            case View.MeasureSpec.AT_MOST:
//            case View.MeasureSpec.UNSPECIFIED:
//        }
//
//        switch (heightMode) {
//            case View.MeasureSpec.EXACTLY:
//                height = heightSize;
//            case View.MeasureSpec.AT_MOST:
//            case View.MeasureSpec.UNSPECIFIED:
//        }
//
//        setMeasuredDimension(width, height);
//    }
//
//    private void measureScrapChild(RecyclerView.Recycler recycler, int position, int widthSpec, int heightSpec, int[] measuredDimension) {
//        View view = recycler.getViewForPosition(position);
//        if (view != null) {
//            RecyclerView.LayoutParams p = (RecyclerView.LayoutParams) view.getLayoutParams();
//            int childWidthSpec = ViewGroup.getChildMeasureSpec(widthSpec, getPaddingLeft() + getPaddingRight(), p.width);
//            int childHeightSpec = ViewGroup.getChildMeasureSpec(heightSpec, getPaddingTop() + getPaddingBottom(), p.height);
//            view.measure(childWidthSpec, childHeightSpec);
//            Rect outRect = new Rect();
//            calculateItemDecorationsForChild(view, outRect);
//            measuredDimension[0] = view.getMeasuredWidth() + p.leftMargin + p.rightMargin;
//            measuredDimension[1] = view.getMeasuredHeight() + p.bottomMargin + p.topMargin + outRect.bottom + outRect.top;
//            recycler.recycleView(view);
//        }
//    }





    @Override
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
//        super.onLayoutChildren(recycler, state);
        int itemCount = state.getItemCount();
        if (itemCount <= 0) {
            return;
        }
        if (state.isPreLayout()) {
            return;
        }
        //回收当前所有的view到Scrap里
        detachAndScrapAttachedViews(recycler);
        //初始化标志位
        mBooleanMap.reset();
        // 遍历所有的item
        fill(recycler, state);

    }

    /**
     * 获取某个childView在水平方向所占的空间
     *
     * @param view
     * @return
     */
    public int getDecoratedMeasurementHorizontal(View view) {
        final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams)
                view.getLayoutParams();
        return getDecoratedMeasuredWidth(view) + params.leftMargin
                + params.rightMargin;
    }

    /**
     * 获取某个childView在竖直方向所占的空间
     *
     * @param view
     * @return
     */
    public int getDecoratedMeasurementVertical(View view) {
        final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams)
                view.getLayoutParams();
        return getDecoratedMeasuredHeight(view) + params.topMargin
                + params.bottomMargin;
    }


    private void fill(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (state.isPreLayout()) {
            return;
        }
        //更新recycleview的控件位置
        updateLayoutState();
        mTotalW = 0;
        int itemCount = state.getItemCount();
        for (int i = 0; i < itemCount; i++) {
            // 得到当前position下的视图显示区域
            RectF bounds = new RectF(mItemRectFList.get(i));
            //需要根据你的实际情况来设置边界值
            if (bounds.right > mTotalW) {
                mTotalW = (int) bounds.right;
            }

            //注：这边事先获取item的位置来判断是否要显示在屏幕上后再来获取itemView的对象
            if (!mBooleanMap.get(i) && RectF.intersects(bounds, mLayoutState.containerRect)) {
                // 通过recycler得到该位置上的View，Recycler负责是否使用旧的还是生成新的View。
                View view = recycler.getViewForPosition(i);

                bounds.offset(mLayoutState.offsetX, mLayoutState.offsetY);
                // 然后我们将得到的View添加到Recycler中
                addView(view);
                //标志当前item已在界面上
                mBooleanMap.set(i);
                // 然后测量View带Margin的的尺寸
                measureChildWithMargins(view, 0, 0);

                int w = getDecoratedMeasurementHorizontal(view);
                int h = getDecoratedMeasurementVertical(view);



                ViewGroup.LayoutParams params= view.getLayoutParams();
                //获取当前控件的布局对象
                params.height=(int)bounds.height();//设置当前控件布局的高度
                params.width = (int)bounds.width();

                view.setLayoutParams(params);//将设置好的布局参数应用到控件中

                w = getDecoratedMeasurementHorizontal(view);
                h = getDecoratedMeasurementVertical(view);

                ((AdapterMetroView)view).SetMyWH((int)bounds.width(),(int)bounds.height());

                w = getDecoratedMeasurementHorizontal(view);
                h = getDecoratedMeasurementVertical(view);

                // 然后layout带Margin的View，将View放置到对应的位置
                layoutDecoratedWithMargins(view, (int) bounds.left, (int) bounds.top, (int) bounds.right, (int) bounds.bottom);
            }
        }
        //预留50的边界
        mTotalW += 50;
    }

    @Override
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
    }

    //水平滑动开关
    @Override
    public boolean canScrollHorizontally() {
        return true;
    }

    @Override
    public boolean canScrollVertically() {
        return super.canScrollVertically();
    }

    @Override
    public int scrollVerticallyBy(int dy, RecyclerView.Recycler recycler, RecyclerView.State state) {
        return super.scrollVerticallyBy(dy, recycler, state);
    }

    @Override
    public int scrollHorizontallyBy(int dx, RecyclerView.Recycler recycler, RecyclerView.State state) {
//

        //实际要滑动的距离
        int travel = dx;

        //判断是否到边界
        //如果滑动到最左边
        if (-mLayoutState.offsetX + dx < 0) {
            travel = mLayoutState.offsetX;
        } else if (-mLayoutState.offsetX + dx + getWidth() > mTotalW) {//如果滑动到最右部
            travel = mTotalW + mLayoutState.offsetX - getWidth();
        }


        //移动
        offsetChildrenHorizontal(-travel);
        //记录当前移动距离，绘制界面时需要用到
        mLayoutState.offsetX -= travel;
        //回收view的Recycle
        scrapOutSetViews(recycler);
        //重新绘制界面：在滑动过程中需要将新进入屏幕的view设置出来
        fill(recycler, state);
        return travel;
    }

    private void scrapOutSetViews(RecyclerView.Recycler recycler) {
        int count = getChildCount();
        for (int i = count - 1; i >= 0; i--) {
            View view = getChildAt(i);
            if (!RectF.intersects(new RectF(0, 0, getWidth(), getHeight()), new RectF(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()))) {
                int position = getPosition(view);
                mBooleanMap.clear(position);
                removeAndRecycleViewAt(i, recycler);
            }
        }
    }

    //更新父控件窗口位置
    private void updateLayoutState() {
        mLayoutState.containerRect.set(0, 0, getWidth(), getHeight());
        mLayoutState.containerRect.offset(-mLayoutState.offsetX, -mLayoutState.offsetY);
    }

    private class LayoutState {

        int offsetX;
        int offsetY;

        final RectF containerRect = new RectF();
    }
}
