package com.example.administrator.mvpdemo.ui.CustomWidgets;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.mvpdemo.R;
import com.example.administrator.mvpdemo.base.QuickAdapter;

import java.util.ArrayList;
import java.util.List;

import static com.example.administrator.mvpdemo.ui.CustomWidgets.BannerM.INDEX_POSITION_RIGHT;

/**
 * Created by xiaofeizhang on 2018/3/26.
 */

public class FBanner extends RelativeLayout {

    private Context context;

    private RecyclerView mRecycleview;

    private QuickAdapter<String> mAdapter;

    public FBanner(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.context = context;
        Init();
    }

    public FBanner(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        Init();
    }

    public FBanner(Context context) {
        super(context);
        this.context = context;
        Init();
    }

    private int mInterval;
    private boolean isShowIndicator;
    private int currentIndex;
    private Handler handler = new Handler();
    private Runnable playTask = new Runnable() {

        @Override
        public void run() {
            mRecycleview.smoothScrollToPosition(++currentIndex);
            if (isShowIndicator) {
                //switchIndicator();
            }
            handler.postDelayed(this, mInterval);
        }
    };


    /**
     * 设置轮播间隔时间
     *
     * @param millisecond 时间毫秒
     */
    public void setIndicatorInterval(int millisecond) {
        this.mInterval = millisecond;
    }


    private boolean isPlaying;
    private boolean isAutoPlaying = true;
    /**
     * 设置是否自动播放（上锁）
     *
     * @param playing 开始播放
     */
    private synchronized void setPlaying(boolean playing) {
        if (isAutoPlaying) {
            if (!isPlaying && playing && mAdapter != null && mAdapter.getItemCount() > 2) {
                handler.postDelayed(playTask, mInterval);
                isPlaying = true;
            } else if (isPlaying && !playing) {
                handler.removeCallbacksAndMessages(null);
                isPlaying = false;
            }
        }
    }

    /**
     * 设置是否禁止滚动播放
     *
     * @param isAutoPlaying true  是自动滚动播放,false 是禁止自动滚动
     */
    public void setRvAutoPlaying(boolean isAutoPlaying) {
        this.isAutoPlaying = isAutoPlaying;
    }



    private void Init()
    {
        LayoutInflater.from(context).inflate(R.layout.item_fbanner, this, true);
        mRecycleview = (RecyclerView)findViewById(R.id.f_banner);
        ((DefaultItemAnimator) mRecycleview.getItemAnimator()).setSupportsChangeAnimations(false);
        mRecycleview.setLayoutManager(new GridLayoutManager(context,1,LinearLayoutManager.HORIZONTAL,false));

        mAdapter = new QuickAdapter<String>(initData()) {
            @Override
            public int getLayoutId(int viewType) {
                return R.layout.item_notextblock;
            }

            @Override
            public void convert(VH holder, String data, int position) {
                ImageView imageView = holder.getView(R.id.img_item_notextblock);
                Glide.with(context).load(data).into(imageView);
                //holder.itemView.setOnClickListener();  此处添加点击事件
            }

            @Override
            public int getItemViewType(int position) {
                return super.getItemViewType(position);
            }
        };

        mAdapter.setHasStableIds(true);
        //((SimpleItemAnimator)mRv.getItemAnimator()).setSupportsChangeAnimations(false);
        mRecycleview.setAdapter(mAdapter);

        mRecycleview.addOnScrollListener(new RecyclerView.OnScrollListener() {

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    if(currentIndex>=mAdapter.getItemCount())
                        currentIndex=0;


                    for (int i = 0; i < mAdapter.getItemCount(); i++) {
                        if (currentIndex % mAdapter.getItemCount() == i) {
                            vList.get(i).setBackgroundDrawable(gradientDrawableSelected);
                        } else {
                            vList.get(i).setBackgroundDrawable(gradientDrawable);
                        }
                        tvText.setText("测试图片" + currentIndex);
                    }
//                    int first = ((LinearLayoutManager) recyclerView.getLayoutManager()).findFirstVisibleItemPosition();
//                    int last = ((LinearLayoutManager) recyclerView.getLayoutManager()).findLastVisibleItemPosition();
//                    if (first == last && currentIndex != last) {
//                        currentIndex = last;
//                        if (isShowIndicator && isTouched) {
//                            isTouched = false;
//                            switchIndicator();
//                        }
//                    }
//                    else currentIndex = 0;
                }
            }
        });

        initIndexList();

        setIndicatorInterval(5000);
        setPlaying(isAutoPlaying);
    }


    //圆点指示器控件
    private List<View> vList;
    //控制圆点View的形状，未选中的颜色
    private GradientDrawable gradientDrawable;
    //控制圆点View的形状，选中的颜色
    private GradientDrawable gradientDrawableSelected;
    //选中圆点的颜色值，默认为#FF3333
    private int indexColorResId;
    //图片对应的文字描述
    private TextView tvText;
    //圆点指示器的位置，提供两种布局
    private int indexPosition = INDEX_POSITION_RIGHT;
    /**
     * 初始化圆点指示器，根据indexPosition来加载不同的布局
     */
    private void initIndexList() {
        int count = mAdapter.getItemCount();
        vList = new ArrayList<>(count);
        LinearLayout llIndex;
        if (indexPosition == INDEX_POSITION_RIGHT) {
            ViewStub vsIndexRight = (ViewStub) findViewById(R.id.fbanner_index_right);
            vsIndexRight.inflate();
            llIndex = (LinearLayout) findViewById(R.id.ll_index_right);
            tvText = (TextView) findViewById(R.id.tv_text);
        } else {
            ViewStub vsIndexBottom = (ViewStub) findViewById(R.id.fbanner_index_bottom);
            vsIndexBottom.inflate();
            llIndex = (LinearLayout) findViewById(R.id.ll_index_bottom);
            tvText = (TextView) findViewById(R.id.tv_text);
        }
        //默认第一张图片的文字描述
        tvText.setText("测试图片" + currentIndex);
        //使用GradientDrawable构造圆形控件
        gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(GradientDrawable.OVAL);
        gradientDrawable.setColor(context.getResources().getColor(R.color.text));
        gradientDrawableSelected = new GradientDrawable();
        gradientDrawableSelected.setShape(GradientDrawable.OVAL);
        if (indexColorResId != 0) {
            gradientDrawableSelected.setColor(indexColorResId);
        } else {
            gradientDrawableSelected.setColor(context.getResources().getColor(R.color.mainColor));
        }

        for (int i = 0; i < count; i++) {
            View view = new View(context);
            LinearLayout.LayoutParams lpView = new LinearLayout.LayoutParams(ConvertM.dp2px(context, 8), ConvertM.dp2px(context, 8));
            lpView.rightMargin = ConvertM.dp2px(context, 4);
            view.setLayoutParams(lpView);
            if (0 == i) {
                view.setBackgroundDrawable(gradientDrawableSelected);
            } else {
                view.setBackgroundDrawable(gradientDrawable);
            }
            view.bringToFront();
            vList.add(view);
            llIndex.addView(view);
        }
    }


    public List<String> initData(){
        String[] images = {"http://attach.bbs.miui.com/forum/month_1012/101203122706c89249c8f58fcc.jpg",
                "http://bbsdown10.cnmo.com/attachments/201308/06/091441rn5ww131m0gj55r0.jpg",
                "http://attach.bbs.miui.com/forum/201604/05/001754vp6j0vmcj49f0evc.jpg.thumb.jpg",
                "http://d.3987.com/taiqiumein_141001/007.jpg",
                "http://attach.bbs.miui.com/forum/201604/05/100838d2b99k6ihk32a36a.jpg.thumb.jpg"};
        ArrayList<String> list = new ArrayList<>();
        for(String image:images){
            list.add(image);
        }
        return list;
    }


}
