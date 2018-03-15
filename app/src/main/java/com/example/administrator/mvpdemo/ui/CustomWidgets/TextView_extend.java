package com.example.administrator.mvpdemo.ui.CustomWidgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewConfiguration;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.mvpdemo.R;

/**
 * Created by xiaofeizhang on 2018/3/15.
 */

public class TextView_extend extends LinearLayout {

    public TextView text;

    public ImageView img;

    public TextView_extend(Context context) {
        super(context);

    }

    public TextView_extend(Context context, AttributeSet attrs) {
        super(context, attrs);

        LayoutInflater.from(context).inflate(R.layout.textview_extend, this, true);

        text =(TextView)findViewById(R.id.text_textciew_ext);

        img = (ImageView)findViewById(R.id.img_textciew_ext);
    }



}
