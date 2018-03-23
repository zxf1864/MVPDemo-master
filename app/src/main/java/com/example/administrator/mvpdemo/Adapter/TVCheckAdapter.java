package com.example.administrator.mvpdemo.Adapter;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Context;
import android.graphics.Color;
import android.graphics.RectF;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.administrator.mvpdemo.Bean.BannerBean;
import com.example.administrator.mvpdemo.Model.ChannelInfo;
import com.example.administrator.mvpdemo.Model.ItemAttribute;
import com.example.administrator.mvpdemo.R;
import com.example.administrator.mvpdemo.Util.AnimationUtil;
import com.example.administrator.mvpdemo.Util.Constants;
import com.example.administrator.mvpdemo.Util.ImageLoaderHelper;
import com.example.administrator.mvpdemo.event.RxBus;
import com.example.administrator.mvpdemo.event.RxBusBaseMessage;
import com.example.administrator.mvpdemo.event.RxCodeConstants;
import com.example.administrator.mvpdemo.service.entity.PgcInfo;
import com.example.administrator.mvpdemo.ui.CustomWidgets.BannerM;
import com.example.administrator.mvpdemo.ui.CustomWidgets.FocusView;
import com.example.administrator.mvpdemo.ui.CustomWidgets.ImageCycleView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.Unbinder;

/**
 * Created by xiaofeizhang on 2018/3/14.
 */

public class TVCheckAdapter extends RecyclerView.Adapter<TVCheckAdapter.MyViewHolder> {

    private ArrayList<RectF> mItemRectFList;
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


    private ChannelInfo mItem;

    public TVCheckAdapter(ArrayList<RectF> itemRectFList) {
        mItemRectFList = itemRectFList;
    }

    public TVCheckAdapter(ChannelInfo channelInfo,View v) {
        mItem = channelInfo;
        this.setHasStableIds(true);

    }


    private Context mContext;
    public TVCheckAdapter(ChannelInfo channelInfo,View v,Context context) {
        mItem = channelInfo;
        this.setHasStableIds(true);
        mContext = context;
    }



    private RelativeLayout mFooterLayout;//footer view
    private View mLoadingView; //分页加载中view

    /**
     * 清空footer view
     */
    private void removeFooterView() {
        mFooterLayout.removeAllViews();
    }


    /**
     * 添加新的footer view
     *
     * @param footerView
     */
    private void addFooterView(View footerView) {
        if (footerView == null) {
            return;
        }

        if (mFooterLayout == null) {
            mFooterLayout = new RelativeLayout(mContext);
        }
        removeFooterView();
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        mFooterLayout.addView(footerView, params);
    }

    /**
     * 初始化加载中布局
     *
     * @param loadingView
     */
    public void setLoadingView(View loadingView) {
        mLoadingView = loadingView;
        addFooterView(mLoadingView);
    }

    public void setLoadingView(int loadingId) {
        setLoadingView(LayoutInflater.from(mContext).inflate(loadingId, null));
    }










    public void SetData(ChannelInfo channelInfo)
    {
        mItem = channelInfo;
        this.notifyDataSetChanged();
    }


    @Override
    public int getItemViewType(int position) {
        if (mItem == null)
            return ItemAttribute.VideoItemType.EMPTY.ordinal();
        if(mItem.getmItemRectFList() == null)
            return ItemAttribute.VideoItemType.EMPTY.ordinal();
        if (mItem.getmItemRectFList().size() == 0)
            return ItemAttribute.VideoItemType.EMPTY.ordinal();


        ItemAttribute.VideoItemType type =  mItem.ItemAttributeS.get(position).ItemType;

        return type.ordinal();

//        if(position == 1)
//            return 1;
//        else
//            return 0;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


//    @Override
//    public void onViewDetachedFromWindow(MyViewHolder holder) {
//        super.onViewDetachedFromWindow(holder);
//        holder.itemView.clearAnimation();
//    }

    private int creat_count;
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View item_view;

        Log.i("TVCheckAdapter", "onCreateViewHolder: "+(creat_count++));

        ItemAttribute.VideoItemType Type = ItemAttribute.VideoItemType.values()[viewType];

        if (Type.equals(ItemAttribute.VideoItemType.EMPTY) )
        {
            item_view =LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleview_empty_item, parent, false);
        }
        else
            item_view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tvcheck_block, parent, false);

        item_view.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {

                if (v instanceof FocusView)
                {
                    if (hasFocus)
                    {
                        AnimatorSet scaleAnimation = AnimationUtil.startScaleToBigAnimation(item_view, Constants.SCALE_RATE, new Animator.AnimatorListener() {

                            @Override
                            public void onAnimationStart(Animator arg0) {

                            }

                            @Override
                            public void onAnimationRepeat(Animator arg0) {
                            }

                            @Override
                            public void onAnimationEnd(Animator arg0) {
                                item_view.getRootView().invalidate();
                            }

                            @Override
                            public void onAnimationCancel(Animator arg0) {
                            }
                        });
                    }
                    else
                    {
                        AnimatorSet scaleAnimation = AnimationUtil.startScaleToSmallAnimation(item_view, Constants.SCALE_RATE, new Animator.AnimatorListener() {

                            @Override
                            public void onAnimationStart(Animator arg0) {

                            }

                            @Override
                            public void onAnimationRepeat(Animator arg0) {
                            }

                            @Override
                            public void onAnimationEnd(Animator arg0) {
                                item_view.getRootView().invalidate();
                            }

                            @Override
                            public void onAnimationCancel(Animator arg0) {
                            }
                        });
                    }
                }

            }
        });


        ItemAttribute ia = new ItemAttribute();
        ia.ItemType = Type;

        return new MyViewHolder(item_view,parent.getContext(),ia);
    }

    private void initImageCycleView(ImageCycleView imageCycleView)
    {
        if(imageCycleView == null)
            return;

        imageCycleView.setCycle_T(ImageCycleView.CYCLE_T.CYCLE_VIEW_THREE_SCALE);
        /**装在数据的集合  文字描述*/
        ArrayList<String> imageDescList=new ArrayList<>();
        /**装在数据的集合  图片地址*/
        ArrayList<String> urlList=new ArrayList<>();

        /**添加数据*/
        urlList.add("http://attach.bbs.miui.com/forum/month_1012/101203122706c89249c8f58fcc.jpg");
        urlList.add("http://bbsdown10.cnmo.com/attachments/201308/06/091441rn5ww131m0gj55r0.jpg");
        urlList.add("http://attach.bbs.miui.com/forum/201604/05/001754vp6j0vmcj49f0evc.jpg.thumb.jpg");
        urlList.add("http://d.3987.com/taiqiumein_141001/007.jpg");
        urlList.add("http://attach.bbs.miui.com/forum/201604/05/100838d2b99k6ihk32a36a.jpg.thumb.jpg");
        imageDescList.add("滚动图片1");
        imageDescList.add("滚动图片2");
        imageDescList.add("滚动图片3");
        imageDescList.add("滚动图片4");
        imageDescList.add("滚动图片5");


        initCarsuelView(imageCycleView,imageDescList, urlList);
    }

    private void initBannerView(BannerM imageCycleView)
    {
        if(imageCycleView == null)
            return;


        List<BannerBean> bannerList = new ArrayList<>(4);
        BannerBean banner1 = new BannerBean("测试图片1", "http://attach.bbs.miui.com/forum/month_1012/101203122706c89249c8f58fcc.jpg", "");
        BannerBean banner2 = new BannerBean("测试图片2", "http://bbsdown10.cnmo.com/attachments/201308/06/091441rn5ww131m0gj55r0.jpg", "");
        BannerBean banner3 = new BannerBean("测试图片3", "http://attach.bbs.miui.com/forum/201604/05/001754vp6j0vmcj49f0evc.jpg.thumb.jpg", "");
        BannerBean banner4 = new BannerBean("测试图片4", "http://d.3987.com/taiqiumein_141001/007.jpg", "");
        BannerBean banner5 = new BannerBean("测试图片5", "http://attach.bbs.miui.com/forum/201604/05/100838d2b99k6ihk32a36a.jpg.thumb.jpg", "");
        bannerList.add(banner1);
        bannerList.add(banner2);
        bannerList.add(banner3);
        bannerList.add(banner4);
        bannerList.add(banner5);

        imageCycleView.setBannerBeanList(bannerList).show();


    }

    private int bind_count;

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Log.i("TVCheckAdapter", "onBindViewHolder: " + (bind_count++) );

//        ((FocusView) holder.itemView).viewholder = holder;

        PgcInfo.DataBean.VideosBean vb;

        if (holder.IA.ItemType.equals(ItemAttribute.VideoItemType.EMPTY))
            return;

        if(mItem.Videos.get(position)!=null)
        {
            vb = mItem.Videos.get(position);
        }
        else
        {
            vb = new PgcInfo.DataBean.VideosBean();
        }

        if (holder.image != null)
        {
            RectF rf = mItem.getmItemRectFList().get(position);
            GridLayoutManager.LayoutParams layoutParams =  (GridLayoutManager.LayoutParams)holder.itemView.getLayoutParams();
            if (layoutParams.height != rf.height())
            {
                layoutParams.height = (int)rf.height() ;
            }

            holder.itemView.setLayoutParams(layoutParams);

            if ((vb.getVer_pic()!=null)&&(vb.getVer_pic()!=holder.imageurl))
            {
                Glide
                        .with(holder.myContext)
                        .load(vb.getVer_pic())
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .placeholder(R.drawable.detail_poster_default)
                        .into(holder.image);

                holder.m_VideosBean = vb;

                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        RxBus.getInstance().send(RxCodeConstants.START_TVDETAIL,new RxBusBaseMessage(position,vb));
                    }
                });


                holder.imageurl = vb.getVer_pic();
            }

        }






    }

    /**初始化轮播图*/
    public void initCarsuelView(ImageCycleView imageCycleView,ArrayList<String> imageDescList,ArrayList<String>urlList) {

        ImageCycleView.ImageCycleViewListener mAdCycleViewListener = new ImageCycleView.ImageCycleViewListener() {
            @Override
            public void onImageClick(int position, View imageView) {
                /**实现点击事件*/
                Log.i("ImageCycleView", "onImageClick: "+position);
            }
            @Override
            public void displayImage(String imageURL, ImageView imageView) {
                /**在此方法中，显示图片，可以用自己的图片加载库，也可以用本demo中的（Imageloader）*/
                ImageLoaderHelper.getInstance().loadImage(imageURL, imageView);
            }
        };
        /**设置数据*/
        imageCycleView.setImageResources(imageDescList,urlList, mAdCycleViewListener);
        // 是否隐藏底部
        imageCycleView.hideBottom(false);
        imageCycleView.startImageCycle();
    }



    @Override
    public int getItemCount() {
        //return mItemRectFList.size();
        if (mItem == null)
            return 1;
        if(mItem.getmItemRectFList() == null)
            return 1;
        if (mItem.getmItemRectFList().size() == 0)
            return 1;

        return mItem.getmItemRectFList().size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.img_item_block)
        ImageView img_item_block;

        @BindView(R.id.banner_itembanner)
        BannerM banner_itembanner;

        @BindView(R.id.img_item_tvblock)
        ImageView img_item_tvblock;

        @BindView(R.id.img_item_textblock)
        ImageView img_item_textblock;

        @BindView(R.id.img_item_firstblock)
        ImageView img_item_firstblock;

        @BindView(R.id.img_item_roundblock)
        ImageView img_item_roundblock;

        @BindView(R.id.img_item_notextblock)
        ImageView img_item_notextblock;

        protected Unbinder unBinder;


        public TextView Text;
        public ImageView image;

        public ImageView refreshimage;

        public String imageurl = "";

        public RelativeLayout itemRL;
        //public ImageCycleView imageCycleView;

        public BannerM imageCycleView;

        public Context myContext;

        public ItemAttribute IA;

        public Animation mRefreshAnim;

        public PgcInfo.DataBean.VideosBean m_VideosBean;

        public void stopAnim() {
            mRefreshAnim.reset();
            refreshimage.clearAnimation();
            refreshimage.setBackgroundResource(0);
        }

        public void startAnim() {
            mRefreshAnim.reset();
            refreshimage.clearAnimation();
            refreshimage.setBackgroundResource(R.mipmap.refreshimg);
            refreshimage.startAnimation(mRefreshAnim);
        }

        public MyViewHolder(View itemView) {
            super(itemView);
            // 绑定视图

            //item可以获得焦点，需要设置这个属性。
            //itemView.setFocusable(true);

            image = (ImageView) itemView.findViewById(R.id.img);

            imageCycleView= (BannerM) itemView.findViewById(R.id.banner_itembanner);
            if (imageCycleView!=null)
                initBannerView(imageCycleView);

            mRefreshAnim = AnimationUtils.loadAnimation(myContext, R.anim.anim_rotate_refresh);
        }

        public MyViewHolder(View itemView, Context context) {
            super(itemView);
            // 绑定视图

            //item可以获得焦点，需要设置这个属性。
            //itemView.setFocusable(true);

            myContext = context;

            image = (ImageView) itemView.findViewById(R.id.img);

            imageCycleView= (BannerM) itemView.findViewById(R.id.banner_itembanner);
            if (imageCycleView!=null)
                initBannerView(imageCycleView);

            mRefreshAnim = AnimationUtils.loadAnimation(myContext, R.anim.anim_rotate_refresh);
        }

        public MyViewHolder(View itemView, Context context,ItemAttribute ia) {
            super(itemView);
            // 绑定视图

            //item可以获得焦点，需要设置这个属性。
            //itemView.setFocusable(true);


//            unBinder = ButterKnife.bind(itemView);
//
//            ButterKnife.bind(this, itemView);


            IA = ia;

            myContext = context;

            //         mRefreshAnim = AnimationUtils.loadAnimation(myContext, R.anim.anim_rotate_refresh);

            image = (ImageView) itemView.findViewById(R.id.img_item_tvcheck);

            if (image!=null)
                Glide
                        .with(myContext)
                        .load(R.drawable.detail_poster_default)
                        .into(image);


        }
    }
}
