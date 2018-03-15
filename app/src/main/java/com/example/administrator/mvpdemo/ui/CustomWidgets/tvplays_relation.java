package com.example.administrator.mvpdemo.ui.CustomWidgets;

/**
 * Created by xiaofeizhang on 2018/3/13.
 */

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.mvpdemo.Adapter.HomeAdapter;
import com.example.administrator.mvpdemo.Adapter.TVSelectorAdapter;
import com.example.administrator.mvpdemo.Model.ChannelInfoList;
import com.example.administrator.mvpdemo.R;


/**
 * Created by xiaofeizhang on 2018/3/13.
 */

public class tvplays_relation extends LinearLayout {

    private Context context;

    private RecyclerView mRvContent;

    private HorizontalScrollView mCH;

    private TextView mTitle;

    private LinearLayout ll;


    public tvplays_relation(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.context = context;
    }

    public tvplays_relation(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        LayoutInflater.from(context).inflate(R.layout.layout_tv_relation, this, true);

        mTitle = (TextView) findViewById(R.id.tv_relation_title);
        mTitle.setText("花絮");

        mRvContent = (RecyclerView)findViewById(R.id.tv_relation_rv);
        mRvContent.setLayoutManager(new GridLayoutManager(context,2,LinearLayoutManager.HORIZONTAL,false));
        TVSelectorAdapter homeAdapter = new TVSelectorAdapter(ChannelInfoList.getInstance().getmChannelInfos().get(0),mRvContent);
        mRvContent.setAdapter(homeAdapter);


        mCH = (HorizontalScrollView)findViewById(R.id.tv_relation_ch);

        ll = (LinearLayout)findViewById(R.id.tv_relation_ll);
        for(int i = 0; i<15;i++)
        {
            TextView tv = new TextView(context);
            tv.setText(String.valueOf(i));
            tv.setTextColor(Color.WHITE);
            tv.setPadding(20,20,20,20);
            tv.setFocusable(true);

            ll.addView(tv, new LinearLayout.LayoutParams(
                    LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
        }


    }

    public tvplays_relation(Context context) {
        super(context);
        this.context = context;


    }


}
