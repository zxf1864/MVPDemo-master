package com.example.administrator.mvpdemo.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.RectF;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.mvpdemo.Model.ChannelInfo;
import com.example.administrator.mvpdemo.Model.PgcInfoList;
import com.example.administrator.mvpdemo.R;
import com.example.administrator.mvpdemo.Util.ImageLoaderHelper;
import com.example.administrator.mvpdemo.service.entity.PgcInfo;
import com.example.administrator.mvpdemo.ui.CustomWidgets.AdapterMetroView;
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
    }


    @Override
    public int getItemViewType(int position) {
//        if(position == 1)
//            return 1;
//        else
            return 0;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //return new MyViewHolder(new AdapterMetroView(parent.getContext()));
        //return new MyViewHolder(new ImageView(parent.getContext()));
        //return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_normal_recycleview, parent, false));


        View item_view;

        if(viewType == 0)
        {
            item_view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_normal_recycleview, parent, false);
        }
        else
        {
            //item_view= new ImageCycleView(parent.getContext());
            item_view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_loopview_recycleview, parent, false);
        }

        item_view.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ((AdapterMetroView)v).onClicked();
            }
        });


        //return new MyViewHolder(item_view);
        return new MyViewHolder(item_view,parent.getContext());
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

        if (holder.image != null)
        {
            PgcInfo.DataBean.VideosBean vb;

            if(mItem.Videos.get(position)!=null)
            {
                vb = mItem.Videos.get(position);
            }
            else
            {
                vb = new PgcInfo.DataBean.VideosBean();
            }


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
            }
            else
            {
                holder.image.setImageResource(R.drawable.testpic1);
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

        public String imageurl = "";

        public RelativeLayout itemRL;
        public ImageCycleView imageCycleView;

        public Context myContext;

        public MyViewHolder(View itemView) {
            super(itemView);
            // 绑定视图

            //item可以获得焦点，需要设置这个属性。
            //itemView.setFocusable(true);

            image = (ImageView) itemView.findViewById(R.id.img);

            imageCycleView= (ImageCycleView) itemView.findViewById(R.id.imagecycleview);
            if (imageCycleView!=null)
              initImageCycleView(imageCycleView);

        }

        public MyViewHolder(View itemView, Context context) {
            super(itemView);
            // 绑定视图

            //item可以获得焦点，需要设置这个属性。
            //itemView.setFocusable(true);

            myContext = context;

            image = (ImageView) itemView.findViewById(R.id.img);

            imageCycleView= (ImageCycleView) itemView.findViewById(R.id.imagecycleview);
            if (imageCycleView!=null)
                initImageCycleView(imageCycleView);

        }
    }
}
