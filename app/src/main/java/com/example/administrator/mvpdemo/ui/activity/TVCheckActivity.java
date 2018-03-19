package com.example.administrator.mvpdemo.ui.activity;

import android.app.Activity;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.administrator.mvpdemo.Adapter.HomeAdapter;
import com.example.administrator.mvpdemo.Adapter.TVCheckAdapter;
import com.example.administrator.mvpdemo.Adapter.TVSelectorAdapter;
import com.example.administrator.mvpdemo.Model.ChannelInfoList;
import com.example.administrator.mvpdemo.R;
import com.example.administrator.mvpdemo.Util.PlayVideoHelper;
import com.example.administrator.mvpdemo.base.BaseActivity;
import com.example.administrator.mvpdemo.service.entity.PgcInfo;
import com.example.administrator.mvpdemo.ui.CustomWidgets.CHScrollView;
import com.example.administrator.mvpdemo.ui.CustomWidgets.CHScrollView_V;
import com.example.administrator.mvpdemo.ui.CustomWidgets.SimpleVideoView;
import com.example.administrator.mvpdemo.ui.CustomWidgets.TextView_extend;

import butterknife.BindView;

/**
 * Created by xiaofeizhang on 2018/3/14.
 */

public class TVCheckActivity extends BaseActivity {

    private PgcInfo.DataBean.VideosBean mVideosBean;



    private RecyclerView mRvContent;

    private CHScrollView_V mCH;

    private ScrollView mSv;

    private TextView mTitle;

    private TextView_extend mCheck;

    private LinearLayout ll;

    @Override
    protected int getContentViewId() {
        return R.layout.layout_tvlist_view;
    }

    @Override
    protected void onInit() {
//        Glide
//                .with(this)
//                .load(mVideosBean.getVer_pic())
//                .diskCacheStrategy(DiskCacheStrategy.ALL)
//                .placeholder(R.mipmap.default_pic)
//                .into(img_detail);



    }

    @Override
    protected void init(){
        mVideosBean = (PgcInfo.DataBean.VideosBean) getIntent().getSerializableExtra("VideosBean");

//        img_detail.setClickable(true);
//
//        img_detail.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                PlayVideoHelper.playSohuOnlineVideo(TVDetailActivity.this, mVideosBean.getAid(), mVideosBean.getVid(),
//                        mVideosBean.getSite(), 0);
//            }
//        });


        mCheck = (TextView_extend) findViewById(R.id.checkcheck);
        mCheck.text.setText("筛选");
        mCheck.setFocusable(true);
        mCheck.setClickable(true);


        mTitle = (TextView) findViewById(R.id.tips);
        mTitle.setText("xxx行 按菜单键筛选");
        mTitle.setFocusable(true);
        mTitle.setClickable(true);
        mTitle.setGravity(View.TEXT_ALIGNMENT_CENTER);
        mTitle.setTextColor(Color.WHITE);
        mTitle.setPadding(10,10,10,10);
        mTitle.setBackgroundResource(R.drawable.item_selector);

        mRvContent = (RecyclerView)findViewById(R.id.check_rv);
        mRvContent.setLayoutManager(new GridLayoutManager(TVCheckActivity.this,5,LinearLayoutManager.VERTICAL,false));
        TVCheckAdapter homeAdapter = new TVCheckAdapter(ChannelInfoList.getInstance().getmChannelInfos().get(1),mRvContent);
        mRvContent.setAdapter(homeAdapter);


        mSv = (ScrollView) findViewById(R.id.checklist_ch);

        ll = (LinearLayout)findViewById(R.id.checklist_ll);
        for(int i = 0; i<25;i++)
        {
            TextView tv = new TextView(TVCheckActivity.this);

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(0, 20, 0, 10);

            tv.setLayoutParams(params);

            tv.setText(String.valueOf(i));
            tv.setTextColor(Color.YELLOW);
            tv.setPadding(20,20,20,20);
            tv.setFocusable(true);
            tv.setClickable(true);
            tv.setBackgroundResource(R.drawable.selector_noshadow);
            tv.setTextColor(Color.WHITE);
            tv.setGravity(View.TEXT_ALIGNMENT_CENTER);

            ll.addView(tv);
        }

      mCheck.requestFocusFromTouch();
    }



}
