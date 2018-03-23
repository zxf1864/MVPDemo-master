package com.example.administrator.mvpdemo.ui.CustomWidgets;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.mvpdemo.R;
import com.example.administrator.mvpdemo.base.BaseActivity;

import cn.bingoogolapple.badgeview.BGABadgeImageView;

/**
 * Created by xiaofeizhang on 2018/3/19.
 */

public class topbar_msg extends RelativeLayout {

    private Context context;

    private BGABadgeImageView mImg;

    private TextView mText;

    private View mView;

    public topbar_msg(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.context = context;
    }

    public topbar_msg(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        mView = LayoutInflater.from(context).inflate(R.layout.layout_toolbar_msg, this, true);

        mImg = (BGABadgeImageView)this.findViewById(R.id.toolbar_msg_img);
        mImg.showCirclePointBadge();

        mText = (TextView)this.findViewById(R.id.toolbar_msg_textView);

        mText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {

                if (hasFocus)
                {
                    mView.setBackgroundResource(R.drawable.home_message_view_bg_focused);
                }
                else
                {
                    mView.setBackgroundResource(0);
                }

            }
        });

    }

    public topbar_msg(Context context) {
        super(context);
        this.context = context;


    }

    public void hiddenBadge()
    {
        mImg.hiddenBadge();
    }

    public void SetImg(int id)
    {
        mImg.setImageResource(id);
    }

    public void SetText(String s)
    {
        mText.setText(s);
    }
}
