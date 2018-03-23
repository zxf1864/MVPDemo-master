package com.example.administrator.mvpdemo.ui.CustomWidgets;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.mvpdemo.R;

/**
 * Created by xiaofeizhang on 2018/3/15.
 */

public class TextView_extend extends LinearLayout {

    private View mView;

    public TextView text;

    public ImageView img;

    public TextView_extend(Context context) {
        super(context);

    }

    public TextView_extend(Context context, AttributeSet attrs) {
        super(context, attrs);

        mView = LayoutInflater.from(context).inflate(R.layout.textview_extend, this, true);

        text =(TextView)findViewById(R.id.text_textciew_ext);

        img = (ImageView)findViewById(R.id.img_textciew_ext);


        mView.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {

                if (hasFocus)
                {
                    img.setImageResource(R.drawable.ic_grid_list_filter_focused);
                    text.setTextColor(Color.YELLOW);
                }
                else
                {
                    img.setImageResource(R.drawable.ic_grid_list_filter_normal);
                    text.setTextColor(Color.WHITE);
                }

            }
        });

    }



}
