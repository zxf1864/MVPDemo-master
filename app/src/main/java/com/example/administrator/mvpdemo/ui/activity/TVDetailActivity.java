package com.example.administrator.mvpdemo.ui.activity;

import android.net.Uri;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.administrator.mvpdemo.R;
import com.example.administrator.mvpdemo.Util.PlayVideoHelper;
import com.example.administrator.mvpdemo.base.BaseActivity;
import com.example.administrator.mvpdemo.service.entity.PgcInfo;
import com.example.administrator.mvpdemo.ui.CustomWidgets.SimpleVideoView;

import butterknife.BindView;

/**
 * Created by xiaofeizhang on 2018/3/9.
 */

public class TVDetailActivity extends BaseActivity {


    private PgcInfo.DataBean.VideosBean mVideosBean;
    @Override
    protected int getContentViewId() {
        return R.layout.activity_tvdetail;
    }


    private SimpleVideoView video;
    private String videoPath;
    @Override
    protected void onInit() {
//        Glide
//                .with(this)
//                .load(mVideosBean.getVer_pic())
//                .diskCacheStrategy(DiskCacheStrategy.ALL)
//                .placeholder(R.mipmap.default_pic)
//                .into(img_detail);

        video = (SimpleVideoView) findViewById(R.id.tv_play);
        //video.setInitPicture(getResources().getDrawable(R.mipmap.ic_launcher,null));
        //网络视频地址
        videoPath = "http://112.253.22.157/17/z/z/y/u/zzyuasjwufnqerzvyxgkuigrkcatxr/hc.yinyuetai.com/D046015255134077DDB3ACA0D7E68D45.flv";
        //本地视频路径
        //videoPath= "/storage/emulated/0/Android/data/com.boohee.one/.SPORT_VIDEOS/1pfl0bzsp1mhs3ur1cahe82x1.mp4";
        //videoPath = "/storage/emulated/0/tencent/QQfile_recv/这货是一条鳄鱼.mp4";
        video.setVideoUri(Uri.parse(videoPath));

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
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        video.suspend();
    }

    @Override
    public void onBackPressed(){
        if(video.isFullScreen()){
            video.setNoFullScreen();
        }else{
            super.onBackPressed();
        }
    }
}
