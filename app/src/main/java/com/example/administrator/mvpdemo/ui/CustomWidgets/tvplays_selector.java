package com.example.administrator.mvpdemo.ui.CustomWidgets;

import android.content.Context;
import android.graphics.Color;
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

public class tvplays_selector extends LinearLayout {

    private Context context;

    private RecyclerView mRvContent;

    private HorizontalScrollView mCH;

    private TextView mTitle;

    private LinearLayout ll;


    public tvplays_selector(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.context = context;
    }

    public tvplays_selector(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        LayoutInflater.from(context).inflate(R.layout.layout_tvplay_select, this, true);

        mTitle = (TextView) findViewById(R.id.tvplays_selector_title);
        mTitle.setText("md");

        mRvContent = (RecyclerView)findViewById(R.id.tvplays_selector_rv);
        mRvContent.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
        TVSelectorAdapter homeAdapter = new TVSelectorAdapter(ChannelInfoList.getInstance().getmChannelInfos().get(0),mRvContent);
        mRvContent.setAdapter(homeAdapter);


        mCH = (HorizontalScrollView)findViewById(R.id.tvplays_selector_ch);

        ll = (LinearLayout)findViewById(R.id.tvplays_selector_ll);
        for(int i = 0; i<5;i++)
        {
            TextView tv = new TextView(context);
            tv.setText("123");
            tv.setTextColor(Color.YELLOW);
            tv.setPadding(20,20,20,20);
            tv.setFocusable(true);

                ll.addView(tv, new LinearLayout.LayoutParams(
                    LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
        }


    }

    public tvplays_selector(Context context) {
        super(context);
        this.context = context;


    }


}
