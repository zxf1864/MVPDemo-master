package com.example.administrator.mvpdemo.ui.CustomWidgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.mvpdemo.R;
import com.example.administrator.mvpdemo.base.BaseActivity;

import retrofit2.http.PUT;

/**
 * Created by xiaofeizhang on 2018/3/19.
 */

public class topbar extends RelativeLayout{
    private Context context;

    private topbar_msg mMsg;
    private RelativeLayout mWeather;

    private ImageView mUser;

    private  ImageView mVip;

    private ImageView mSearch;

    private ImageView mlogo;

    private TextView mTime;

    public topbar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.context = context;
    }

    public topbar(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        LayoutInflater.from(context).inflate(R.layout.layout_topbar, this, true);

        mMsg = (topbar_msg)this.findViewById(R.id.topbar_msg);
        mWeather = (RelativeLayout) this.findViewById(R.id.topbar_weather);

        mSearch = (ImageView)this.findViewById(R.id.topbar_serch);

        mUser = (ImageView)this.findViewById(R.id.topbar_user);

        mVip =(ImageView)this.findViewById(R.id.topbar_vip);

        mlogo = (ImageView)this.findViewById(R.id.home_logo);

        mTime = (TextView)this.findViewById(R.id.home_time);

    }

    public topbar(Context context) {
        super(context);
        this.context = context;


    }

    public void HideRightInfo()
    {
        mWeather.setVisibility(INVISIBLE);
        mlogo.setVisibility(INVISIBLE);
        mTime.setVisibility(INVISIBLE);
    }

    private boolean mydispatchKeyEvent(KeyEvent event, View focusView , int dx)
    {
        boolean ret = false;

        switch (event.getKeyCode()) {
            case KeyEvent.KEYCODE_DPAD_RIGHT:
                if (event.getAction() == KeyEvent.ACTION_UP) {
                    return true;
                }
                else {
                    if(mWeather.hasFocus())
                    {
                        Animation shake = AnimationUtils.loadAnimation(mWeather.getContext(), R.anim.left_right_shake);
                        mWeather.startAnimation(shake);
                        return true;
                    }
                    else
                        return false;
                }


            case KeyEvent.KEYCODE_DPAD_LEFT:
                if (event.getAction() == KeyEvent.ACTION_UP) {
                    return true;
                } else {
                    if(mSearch.hasFocus())
                    {
                        Animation shake = AnimationUtils.loadAnimation(mSearch.getContext(), R.anim.left_right_shake);
                        mSearch.startAnimation(shake);
                        return true;
                    }
                    else
                        return false;

                }

            case KeyEvent.KEYCODE_DPAD_DOWN:
                if (event.getAction() == KeyEvent.ACTION_UP) {
                    return true;
                } else {
                   return false;
                }

            case KeyEvent.KEYCODE_DPAD_UP:
                if (event.getAction() == KeyEvent.ACTION_UP) {
                    return true;
                } else {
                    if (mSearch.hasFocus())
                    {
                        Animation shake = AnimationUtils.loadAnimation(mSearch.getContext(), R.anim.up_down_shake);
                        mSearch.startAnimation(shake);
                    }
                    else if (mUser.hasFocus())
                    {
                        Animation shake = AnimationUtils.loadAnimation(mUser.getContext(), R.anim.up_down_shake);
                        mUser.startAnimation(shake);
                    }
                    else if (mVip.hasFocus())
                    {
                        Animation shake = AnimationUtils.loadAnimation(mVip.getContext(), R.anim.up_down_shake);
                        mVip.startAnimation(shake);
                    }
                    else if (mMsg.hasFocus())
                    {
                        Animation shake = AnimationUtils.loadAnimation(mMsg.getContext(), R.anim.up_down_shake);
                        mMsg.startAnimation(shake);
                    }
                    else if (mWeather.hasFocus())
                    {
                        Animation shake = AnimationUtils.loadAnimation(mWeather.getContext(), R.anim.up_down_shake);
                        mWeather.startAnimation(shake);
                    }
                    else
                        return true;



                }



        }

        return ret;
    }


    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {

        boolean result = false;

        View focusView = this.getFocusedChild();

        if (focusView != null) {
            int dx = (int)focusView.getX();
            if (dx <=0)
                dx = focusView.getWidth()*2;
            result = mydispatchKeyEvent(event,focusView,dx);
        }

        return result?true:super.dispatchKeyEvent(event);
    }

}
