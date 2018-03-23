package com.example.administrator.mvpdemo.ui.activity;

import android.app.Activity;
import android.graphics.Color;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.administrator.mvpdemo.Adapter.HomeAdapter;
import com.example.administrator.mvpdemo.Adapter.TVCheckAdapter;
import com.example.administrator.mvpdemo.Adapter.TVSelectorAdapter;
import com.example.administrator.mvpdemo.Model.ChannelInfo;
import com.example.administrator.mvpdemo.Model.ChannelInfoList;
import com.example.administrator.mvpdemo.R;
import com.example.administrator.mvpdemo.Util.PlayVideoHelper;
import com.example.administrator.mvpdemo.base.BaseActivity;
import com.example.administrator.mvpdemo.service.entity.PgcInfo;
import com.example.administrator.mvpdemo.ui.CustomWidgets.CHScrollView;
import com.example.administrator.mvpdemo.ui.CustomWidgets.CHScrollView_V;
import com.example.administrator.mvpdemo.ui.CustomWidgets.SimpleVideoView;
import com.example.administrator.mvpdemo.ui.CustomWidgets.TextView_extend;
import com.example.administrator.mvpdemo.ui.CustomWidgets.topbar;

import butterknife.BindView;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by xiaofeizhang on 2018/3/14.
 */

public class TVCheckActivity extends BaseActivity {

    private PgcInfo.DataBean.VideosBean mVideosBean;

    private TextView mChannelName;

    private RecyclerView mRvContent;

    private CHScrollView_V mCH;

    private ScrollView mSv;

    private TextView mTitle;

    private TextView_extend mCheck;

    private LinearLayout ll;

    private topbar mTopbar;

    private LinearLayout mLoading;

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

        mLoading = (LinearLayout)findViewById(R.id.check_rv_loading);


//        img_detail.setClickable(true);
//
//        img_detail.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                PlayVideoHelper.playSohuOnlineVideo(TVDetailActivity.this, mVideosBean.getAid(), mVideosBean.getVid(),
//                        mVideosBean.getSite(), 0);
//            }
//        });

        mTopbar = (topbar)findViewById(R.id.check_topbar);
        mTopbar.HideRightInfo();

        mChannelName = (TextView)findViewById(R.id.tvcheck_name);
        mChannelName.setText(getIntent().getSerializableExtra("channelname").toString());

        mCheck = (TextView_extend) findViewById(R.id.checkcheck);
        mCheck.text.setText("筛选");
        mCheck.setFocusable(true);
        mCheck.setClickable(true);


        mTitle = (TextView) findViewById(R.id.tips);
        mTitle.setText("xxx行 按菜单键筛选");
        mTitle.setGravity(View.TEXT_ALIGNMENT_CENTER);
        mTitle.setTextColor(Color.WHITE);
        mTitle.setPadding(10,10,10,10);
        mTitle.setBackgroundResource(R.drawable.item_selector);

        mRvContent = (RecyclerView)findViewById(R.id.check_rv);
        mRvContent.setLayoutManager(new GridLayoutManager(TVCheckActivity.this,5,LinearLayoutManager.VERTICAL,false));
        TVCheckAdapter homeAdapter = new TVCheckAdapter(ChannelInfoList.getInstance().getmChannelInfos().get(1),mRvContent,this);
        mRvContent.setAdapter(homeAdapter);




        mSv = (ScrollView) findViewById(R.id.checklist_ch);

        ll = (LinearLayout)findViewById(R.id.checklist_ll);
        for(int i = 0; i<25;i++)
        {
            TextView tv = new TextView(TVCheckActivity.this);

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    300, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(0, 20, 0, 10);

            tv.setLayoutParams(params);

            tv.setText(String.valueOf(i));
            tv.setTextColor(Color.YELLOW);

            tv.setFocusable(true);
            tv.setClickable(true);
            tv.setBackgroundResource(R.drawable.selector_noshadow);
            tv.setTextColor(Color.WHITE);
            tv.setGravity(Gravity.CENTER);

            Flowable.just(i)
                    //将1.x中的Func1,2改为Function和BiFunction，Func3-9改为Function3-9
                    //多参数FuncN改为Function<Object[],R>

                    //这个第一个泛型为接收参数的数据类型，第二个泛型为转换后要发射的数据类型
                    .map(new Function<Integer , ChannelInfo>() {
                        @Override
                        public ChannelInfo apply(Integer  i) throws Exception {

                            return ChannelInfoList.getInstance().getmChannelInfos().get(i%5);
                        }
                    })
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Consumer<ChannelInfo>() {
                        @Override
                        public void accept(ChannelInfo ci) throws Exception {
                            tv.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                                @Override
                                public void onFocusChange(View v, boolean hasFocus) {

                                    if (hasFocus)
                                    {
                                       mLoading.setVisibility(View.VISIBLE);
                                        tv.setTextColor(Color.YELLOW);


                                        //延时3s刷新列表
                                        new Handler().postDelayed(new Runnable() {
                                            @Override
                                            public void run() {
                                                ((TVCheckAdapter)mRvContent.getAdapter()).SetData(ci);
                                                mLoading.setVisibility(View.INVISIBLE);
                                            }
                                        }, 1000);






                                    }
                                    else
                                    {
                                        tv.setTextColor(Color.WHITE);
                                    }

                                }
                            });
                        }
                    });




            ll.addView(tv);
        }

      mCheck.requestFocusFromTouch();
    }



}
