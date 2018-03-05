package com.example.administrator.mvpdemo.Adapter;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Context;
import android.graphics.Color;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
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

import com.example.administrator.mvpdemo.Bean.BannerBean;
import com.example.administrator.mvpdemo.Model.ChannelInfo;
import com.example.administrator.mvpdemo.Model.ChannelInfoList;
import com.example.administrator.mvpdemo.Model.ItemAttribute;
import com.example.administrator.mvpdemo.Model.PgcInfoList;
import com.example.administrator.mvpdemo.R;
import com.example.administrator.mvpdemo.Util.AnimationUtil;
import com.example.administrator.mvpdemo.Util.Constants;
import com.example.administrator.mvpdemo.Util.ImageLoaderHelper;
import com.example.administrator.mvpdemo.service.entity.PgcInfo;
import com.example.administrator.mvpdemo.ui.CustomWidgets.AdapterMetroView;
import com.example.administrator.mvpdemo.ui.CustomWidgets.BannerM;
import com.example.administrator.mvpdemo.ui.CustomWidgets.FocusView;
import com.example.administrator.mvpdemo.ui.CustomWidgets.ImageCycleView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by xlg on 2017/5/17.
 */

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder> {

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

    public HomeAdapter(ArrayList<RectF> itemRectFList) {
        mItemRectFList = itemRectFList;
    }

    public HomeAdapter(ChannelInfo channelInfo) {
        mItem = channelInfo;
        this.setHasStableIds(true);
    }


    @Override
    public int getItemViewType(int position) {

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

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //return new MyViewHolder(new AdapterMetroView(parent.getContext()));
        //return new MyViewHolder(new ImageView(parent.getContext()));
        //return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_normal_recycleview, parent, false));


        View item_view;

//        if(viewType == 0)
//        {
//            item_view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_normal_recycleview, parent, false);
//        }
//        else
//        {
//            //item_view= new ImageCycleView(parent.getContext());
//            item_view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_loopview_recycleview, parent, false);
//        }

        ItemAttribute.VideoItemType Type = ItemAttribute.VideoItemType.values()[viewType];

        switch (Type)
        {
            case FIRSTBLOCK:
                item_view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_firstblock, parent, false);
                break;
            case BANNER:
                item_view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_loopview_recycleview, parent, false);
                break;
            case BLOCK:
                item_view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_block, parent, false);
                break;
            case NOTEXTBLOCK:
                item_view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_notextblock, parent, false);
                break;
            case TEXTBLOCK:
                item_view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_textblock, parent, false);
                break;
            case TVBLOCK:
                //item_view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_normal_recycleview, parent, false);
                item_view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tvblock, parent, false);
                break;
            case ROUNDBLOCK:
                item_view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_roundblock, parent, false);
                break;
            default:
                item_view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_notextblock, parent, false);
                break;

        }


//        item_view.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//               if (v.hasFocus())
//               {
//                   AnimatorSet scaleAnimation = AnimationUtil.startScaleToBigAnimation(item_view, Constants.SCALE_RATE, new Animator.AnimatorListener() {
//
//                       @Override
//                       public void onAnimationStart(Animator arg0) {
//
//                       }
//
//                       @Override
//                       public void onAnimationRepeat(Animator arg0) {
//                       }
//
//                       @Override
//                       public void onAnimationEnd(Animator arg0) {
//                           item_view.getRootView().invalidate();
//                       }
//
//                       @Override
//                       public void onAnimationCancel(Animator arg0) {
//                       }
//                   });
//               }
//               else
//               {
//                   AnimatorSet scaleAnimation = AnimationUtil.startScaleToSmallAnimation(item_view, Constants.SCALE_RATE, new Animator.AnimatorListener() {
//
//                       @Override
//                       public void onAnimationStart(Animator arg0) {
//
//                       }
//
//                       @Override
//                       public void onAnimationRepeat(Animator arg0) {
//                       }
//
//                       @Override
//                       public void onAnimationEnd(Animator arg0) {
//                           item_view.getRootView().invalidate();
//                       }
//
//                       @Override
//                       public void onAnimationCancel(Animator arg0) {
//                       }
//                   });
//               }
//            }
//        });

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


        //return new MyViewHolder(item_view);
        //return new MyViewHolder(item_view,parent.getContext());

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

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
//        holder.Text.setText("1111");
//        holder.Text.setTextColor(Color.BLUE);
//        ((ImageView)holder.itemView).setImageResource(R.mipmap.ic_launcher);
//        ((ImageView)holder.itemView).setBackgroundColor(colors[position]);

//        ((ImageView)holder.itemView).setImageResource(R.mipmap.ic_launcher);
//        ((ImageView)holder.itemView).setBackgroundColor(colors[position]);

        //holder.Text.setText("item" + position);

        // 选择切换类型
        //ImageCycleView.CYCLE_T 有三种类型 ,效果如上图所示
        //CYCLE_VIEW_NORMAL  CYCLE_VIEW_THREE_SCALE   CYCLE_VIEW_ZOOM_IN   可以随意选择

        //initImageCycleView((ImageCycleView)item_view);

        try {
            //((AdapterMetroView) view).SetMyWH((int) bounds.width(), (int) bounds.height());
            ((FocusView) holder.itemView).isBottomEdge = false;
            ((FocusView) holder.itemView).isTopEdge = false;
            ((FocusView) holder.itemView).isLeftEdge = false;
            ((FocusView) holder.itemView).isRightEdge = false;

            if(mItem.getmItemRectFList().get(position).bottom == mItem.bottombound)
                ((FocusView) holder.itemView).isBottomEdge = true;

            if(mItem.getmItemRectFList().get(position).top == mItem.topbound)
                ((FocusView) holder.itemView).isTopEdge = true;

            if(mItem.getmItemRectFList().get(position).left == mItem.leftbound)
                ((FocusView) holder.itemView).isLeftEdge = true;

            if(mItem.getmItemRectFList().get(position).right == mItem.rightbound)
                ((FocusView) holder.itemView).isRightEdge = true;

        } catch (Exception ex) {
        }

        PgcInfo.DataBean.VideosBean vb;

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
            if(vb.getVer_pic() != null)
            {
                if(holder.imageurl != vb.getVer_pic())
                {
                    holder.imageurl = vb.getVer_pic();
                    Glide
                            .with(holder.myContext)
                            .load(vb.getVer_pic())
                            .into(holder.image);
                }
                if (holder.refreshimage != null)
                {
                    holder.stopAnim();
                }
            }
            else
            {
                if (holder.refreshimage != null)
                {
                    holder.startAnim();
                }
                holder.image.setImageResource(R.mipmap.default_pic);
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
        return mItem.getmItemRectFList().size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
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

            IA = ia;

            myContext = context;

            mRefreshAnim = AnimationUtils.loadAnimation(myContext, R.anim.anim_rotate_refresh);

            switch (ia.ItemType)
            {
                case BLOCK:
                    //itemRL = (RelativeLayout) itemView.findViewById(R.id.item_block_rl);
                    image = (ImageView) itemView.findViewById(R.id.img_item_block);
                    break;
                case BANNER:
                    //itemRL = (RelativeLayout) itemView.findViewById(R.id.item_banner_rl);
                    imageCycleView= (BannerM) itemView.findViewById(R.id.banner_itembanner);
                    if (imageCycleView!=null)
                        initBannerView(imageCycleView);
                    break;
                case TVBLOCK:
                    //itemRL = (RelativeLayout) itemView.findViewById(R.id.item_tvblock);
                    image = (ImageView) itemView.findViewById(R.id.img_item_tvblock);
                    break;
                case TEXTBLOCK:
                    //itemRL = (RelativeLayout) itemView.findViewById(R.id.item_textblock_rl);
                    image = (ImageView) itemView.findViewById(R.id.img_item_textblock);
                    break;
                case FIRSTBLOCK:
                    //itemRL = (RelativeLayout) itemView.findViewById(R.id.item_firstblock_rl);
                    image = (ImageView) itemView.findViewById(R.id.img_item_firstblock);
                    refreshimage = (ImageView) itemView.findViewById(R.id.refreshimg_item_firstblock);
                    break;
                case ROUNDBLOCK:
                    //itemRL = (RelativeLayout) itemView.findViewById(R.id.item_roundblock_rl);
                    image = (ImageView) itemView.findViewById(R.id.img_item_roundblock);
                    break;
                case NOTEXTBLOCK:
                    //itemRL = (RelativeLayout) itemView.findViewById(R.id.item_notextblock_rl);
                    image = (ImageView) itemView.findViewById(R.id.img_item_notextblock);
                    break;
            }


        }
    }
}
