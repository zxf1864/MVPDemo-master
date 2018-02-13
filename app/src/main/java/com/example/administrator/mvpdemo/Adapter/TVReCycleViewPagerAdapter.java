package com.example.administrator.mvpdemo.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.RectF;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;


import com.example.administrator.mvpdemo.MyReCyclerView.CustomLayoutManager;
import com.example.administrator.mvpdemo.MyReCyclerView.HomeLayoutManager;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import static android.view.ViewGroup.FOCUS_AFTER_DESCENDANTS;

/**
 * Created by xiaofeizhang on 2018/2/7.
 */

public class TVReCycleViewPagerAdapter extends PagerAdapter {

    private int[] colors = new int[]{
            Color.BLACK,
            Color.BLUE,
            Color.parseColor("#ff8040"),
            Color.YELLOW,
            Color.parseColor("#949449"),
            Color.RED,
            Color.GREEN,
            Color.GRAY,
            Color.parseColor("#8600ff"),
            Color.parseColor("#ff8040"),
            Color.GREEN,
            Color.parseColor("#5151a2"),
            Color.BLUE,
            Color.RED,
            Color.parseColor("#977c00"),
            Color.GREEN,
            Color.parseColor("#949449"),
            Color.parseColor("#804040")
    };

    private ArrayList<RectF> mItemRectFList;

    private List<ArrayList<RectF>> mItemRectFLists;

    private List<View> indicators = new ArrayList<>();//水平分页的指示器
    private ArrayList<HashMap<String, Object>> datas = new ArrayList<>();//RecyclerView数据集合
    private Context context;
    private LinearLayout llIndicators;//水平分页的容器

    private SparseArray<RecyclerView> mViewSparseArray;

    public void setDatas(ArrayList<HashMap<String, Object>> datas) {
        this.datas = datas;
    }

    public void setDatas(String[] inputStrs) {

        mItemRectFLists = new ArrayList<>();

        for (int i=0;i<inputStrs.length;i++)
        {
            mItemRectFList = new Gson().fromJson(inputStrs[i], new TypeToken<ArrayList<RectF>>() {
            }.getType());
            mItemRectFLists.add(mItemRectFList);
        }

        mViewSparseArray = new SparseArray<RecyclerView>(mItemRectFLists.size());

    }

    public List<View> getIndicators() {
        return indicators;
    }

    public TVReCycleViewPagerAdapter(Context context, LinearLayout llIndicators) {
        this.context = context;
        this.llIndicators = llIndicators;
    }



    public TVReCycleViewPagerAdapter(Context context) {
        this.context = context;


    }

    private RecyclerView getView(int position)
    {

        RecyclerView recyclerView = new RecyclerView(context) {};

        //http://blog.csdn.net/wx123ww/article/details/51567982
        recyclerView.setDescendantFocusability(FOCUS_AFTER_DESCENDANTS);
        //父控件和子控件之间的焦点获取的关系,意思是焦点优先级是 父亲在后代后面  不加这行会出现焦点有时丢失的问题


        recyclerView.setBackgroundColor(colors[position]);


        //2行显示。列数量通过item的宽度来控制，显示3列
        //绑定VirtualLayoutManager
        //CustomLayoutManager layoutManager = new CustomLayoutManager(context);

        HomeAdapter homeAdapter = new HomeAdapter(mItemRectFLists.get(position));
        recyclerView.setLayoutManager(new HomeLayoutManager(mItemRectFLists.get(position)));
        recyclerView.setAdapter(homeAdapter);


        return recyclerView;

    }

    /**
     * 计算水平分页的数量
     *
     * @return
     */
    @Override
    public int getCount() {
//        int count = datas.size() % 6;
//        int divide = datas.size() / 6;
//        return count == 0 ? divide : divide + 1;
        if (mItemRectFLists == null) return 0;
        return mItemRectFLists.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }


    @Override
    public RecyclerView instantiateItem(ViewGroup container, int position) {
        RecyclerView view = mViewSparseArray.get(position);
        if (view == null) {
            view = getView(position);
            mViewSparseArray.put(position, view);
        }




        //recyclerView.setLayoutManager(layoutManager);

//        MyAdapter Adapter_GridLayout  = new MyAdapter(context, datas) {
//            // 设置需要展示的数据总数,此处设置是8,即展示总数是8个,然后每行是4个(上面设置的)
//            // 为了展示效果,通过重写onBindViewHolder()将布局的第一个数据设置为gridLayoutHelper
//            @Override
//            public void onBindViewHolder(MainViewHolder holder, int position) {
//                super.onBindViewHolder(holder, position);
//                // 为了展示效果,将布局里不同位置的Item进行背景颜色设置
//                if (position < 2) {
//                    holder.itemView.setBackgroundColor(0x66cc0000 + (position - 6) * 128);
//                } else if (position % 2 == 0) {
//                    holder.itemView.setBackgroundColor(0xaa22ff22);
//                } else {
//                    holder.itemView.setBackgroundColor(0xccff22ff);
//                }
//
//
//
//                if (position == 0) {
//                    holder.Text.setText("Grid");
//                }
//            }
//        };
//        recyclerView.setAdapter(Adapter_GridLayout);


        //初始化指示器。position == 0只初始化一次;且有多页；
        for (int i = 0; position == 0 && getCount() != 1 && i < getCount(); i++) {
//            View indicator = new View(context);
//            Drawable drawable = context.getResources().getDrawable(R.drawable.indicator_selector);
//            indicator.setBackground(drawable);
//            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(24, 24);
//            params.setMarginEnd(10);
//            llIndicators.addView(indicator, params);
//            indicators.add(indicator);
        }




        //Adapter_onePlusNLayout.setOnItemClickListener(context);
        // 设置每个Item的点击事件


        //Adapter_GridLayout.setDatas(datas);
        //Adapter_GridLayout.notifyDataSetChanged();
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(mViewSparseArray.get(position));
    }

}
