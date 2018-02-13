package com.example.administrator.mvpdemo.ui.activity;

import android.graphics.Color;

import android.graphics.Rect;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;

import android.support.v7.widget.Toolbar;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;


import android.widget.TextView;
import android.widget.Toast;


import com.example.administrator.mvpdemo.Adapter.MyItemClickListener;

import com.example.administrator.mvpdemo.Adapter.TVReCycleViewPagerAdapter;
import com.example.administrator.mvpdemo.R;
import com.example.administrator.mvpdemo.Util.StatusBarUtils;
import com.example.administrator.mvpdemo.base.BaseActivity;

import com.example.administrator.mvpdemo.service.entity.Pgc;

import com.example.administrator.mvpdemo.service.presenter.PgcPresenter;

import com.example.administrator.mvpdemo.service.view.ITestView;

import com.example.administrator.mvpdemo.ui.CustomWidgets.BadgeView;
import com.example.administrator.mvpdemo.ui.CustomWidgets.CHScrollView;


import java.lang.reflect.Method;




import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements ITestView,MyItemClickListener {


    @BindView(R.id.resulttext)
    TextView etResulttext;
    @BindView(R.id.button)
    Button etRequest;

//    @BindView(R.id.myRecyclerView)
//    RecyclerView mRecyclerView;

    @BindView(R.id.id_viewpager)
    ViewPager mViewPager;

    private Toolbar mToolBar;

    TextView common_broadcast_text;
    TextView recommend_text;
    TextView TV_text;
    TextView VIP_text;
    TextView Children_text;
    TextView TVShow_text;
    TextView Film_text;
    TextView Video_text;
    TextView More_text;
    TextView Setting_text;




//    private String mRectFMsg0 = "[{\"bottom\":353.0,\"left\":50.0,\"right\":245.0,\"top\":201.0}," +
//            "{\"bottom\":201.0,\"left\":830.0,\"right\":1220.0,\"top\":49.0}," +
//            "{\"bottom\":353.0,\"left\":245.0,\"right\":830.0,\"top\":49.0}," +
//            "{\"bottom\":805.0,\"left\":830.0,\"right\":1025.0,\"top\":353.0}," +
//            "{\"bottom\":201.0,\"left\":50.0,\"right\":245.0,\"top\":49.0}," +
//            "{\"bottom\":805.0,\"left\":245.0,\"right\":830.0,\"top\":353.0}," +
//            "{\"bottom\":805.0,\"left\":1025.0,\"right\":1220.0,\"top\":353.0}," +
//            "{\"bottom\":805.0,\"left\":50.0,\"right\":245.0,\"top\":353.0}," +
//            "{\"bottom\":353.0,\"left\":830.0,\"right\":1220.0,\"top\":201.0}," +
//
//            "{\"bottom\":353.0,\"left\":1220.0,\"right\":1415.0,\"top\":201.0}," +
//            "{\"bottom\":201.0,\"left\":2000.0,\"right\":2390.0,\"top\":49.0}," +
//            "{\"bottom\":353.0,\"left\":1415.0,\"right\":2000.0,\"top\":49.0}," +
//            "{\"bottom\":805.0,\"left\":2000.0,\"right\":2195.0,\"top\":353.0}," +
//            "{\"bottom\":201.0,\"left\":1220.0,\"right\":1415.0,\"top\":49.0}," +
//            "{\"bottom\":805.0,\"left\":1415.0,\"right\":2000.0,\"top\":353.0}," +
//            "{\"bottom\":805.0,\"left\":2195.0,\"right\":2390.0,\"top\":353.0}," +
//            "{\"bottom\":805.0,\"left\":1220.0,\"right\":1415.0,\"top\":353.0}," +
//            "{\"bottom\":353.0,\"left\":2000.0,\"right\":2390.0,\"top\":201.0},]";

    private String mRectFMsg0 = "[{\"bottom\":600.0,\"left\":0.0,\"right\":900.0,\"top\":0.0}," +
                                "{\"bottom\":800.0,\"left\":0.0,\"right\":450.0,\"top\":600.0}," +
                                "{\"bottom\":800.0,\"left\":450.0,\"right\":900.0,\"top\":600.0}," +
                                "{\"bottom\":450.0,\"left\":900.0,\"right\":1500.0,\"top\":0.0}," +
                                "{\"bottom\":800.0,\"left\":900.0,\"right\":1500.0,\"top\":450.0}," +
                                "{\"bottom\":450.0,\"left\":1500.0,\"right\":2100.0,\"top\":0.0}," +
                                "{\"bottom\":800.0,\"left\":1500.0,\"right\":2100.0,\"top\":450.0},]";


    private String mRectFMsg1 = "[{\"bottom\":450.0,\"left\":0.0,\"right\":700.0,\"top\":0.0}," +
            "{\"bottom\":800.0,\"left\":0.0,\"right\":375.0,\"top\":450.0}," +
            "{\"bottom\":650.0,\"left\":375.0,\"right\":700.0,\"top\":450.0}," +
            "{\"bottom\":800.0,\"left\":375.0,\"right\":700.0,\"top\":650.0}," +

            "{\"bottom\":450.0,\"left\":700.0,\"right\":1200.0,\"top\":0.0}," +
            "{\"bottom\":800.0,\"left\":700.0,\"right\":1200.0,\"top\":450.0}," +

            "{\"bottom\":450.0,\"left\":1200.0,\"right\":1700.0,\"top\":0.0}," +
            "{\"bottom\":800.0,\"left\":1200.0,\"right\":1700.0,\"top\":450.0}," +

            "{\"bottom\":450.0,\"left\":1700.0,\"right\":2200.0,\"top\":0.0}," +
            "{\"bottom\":800.0,\"left\":1700.0,\"right\":2200.0,\"top\":450.0}," +

            "{\"bottom\":450.0,\"left\":2200.0,\"right\":2700.0,\"top\":0.0}," +
            "{\"bottom\":800.0,\"left\":2200.0,\"right\":2700.0,\"top\":450.0}," +

            "{\"bottom\":450.0,\"left\":2700.0,\"right\":3200.0,\"top\":0.0}," +
            "{\"bottom\":800.0,\"left\":2700.0,\"right\":3200.0,\"top\":450.0}," +

            "{\"bottom\":450.0,\"left\":3200.0,\"right\":3700.0,\"top\":0.0}," +
            "{\"bottom\":800.0,\"left\":3200.0,\"right\":3700.0,\"top\":450.0}," +

            "{\"bottom\":450.0,\"left\":3700.0,\"right\":4200.0,\"top\":0.0}," +
            "{\"bottom\":800.0,\"left\":3700.0,\"right\":4200.0,\"top\":450.0},]";

    private String mRectFMsg2 = "[{\"bottom\":450.0,\"left\":0.0,\"right\":700.0,\"top\":0.0}," +
            "{\"bottom\":650.0,\"left\":0.0,\"right\":375.0,\"top\":450.0}," +
            "{\"bottom\":800.0,\"left\":0.0,\"right\":375.0,\"top\":650.0}," +
            "{\"bottom\":650.0,\"left\":375.0,\"right\":700.0,\"top\":450.0}," +
            "{\"bottom\":800.0,\"left\":375.0,\"right\":700.0,\"top\":650.0}," +

            "{\"bottom\":450.0,\"left\":700.0,\"right\":1200.0,\"top\":0.0}," +
            "{\"bottom\":800.0,\"left\":700.0,\"right\":1200.0,\"top\":450.0}," +

            "{\"bottom\":450.0,\"left\":1200.0,\"right\":1700.0,\"top\":0.0}," +
            "{\"bottom\":800.0,\"left\":1200.0,\"right\":1700.0,\"top\":450.0}," +

            "{\"bottom\":450.0,\"left\":1700.0,\"right\":2200.0,\"top\":0.0}," +
            "{\"bottom\":800.0,\"left\":1700.0,\"right\":2200.0,\"top\":450.0}," +

            "{\"bottom\":450.0,\"left\":2200.0,\"right\":2700.0,\"top\":0.0}," +
            "{\"bottom\":800.0,\"left\":2200.0,\"right\":2700.0,\"top\":450.0}," +

            "{\"bottom\":450.0,\"left\":2700.0,\"right\":3200.0,\"top\":0.0}," +
            "{\"bottom\":800.0,\"left\":2700.0,\"right\":3200.0,\"top\":450.0}," +

            "{\"bottom\":450.0,\"left\":3200.0,\"right\":3700.0,\"top\":0.0}," +
            "{\"bottom\":800.0,\"left\":3200.0,\"right\":3700.0,\"top\":450.0}," +

            "{\"bottom\":450.0,\"left\":3700.0,\"right\":4200.0,\"top\":0.0}," +
            "{\"bottom\":800.0,\"left\":3700.0,\"right\":4200.0,\"top\":450.0},]";




    private String mRectFMsg3 = "[{\"bottom\":450.0,\"left\":0.0,\"right\":700.0,\"top\":0.0}," +
            "{\"bottom\":650.0,\"left\":0.0,\"right\":375.0,\"top\":450.0}," +
            "{\"bottom\":800.0,\"left\":0.0,\"right\":375.0,\"top\":650.0}," +
            "{\"bottom\":650.0,\"left\":375.0,\"right\":700.0,\"top\":450.0}," +
            "{\"bottom\":800.0,\"left\":375.0,\"right\":700.0,\"top\":650.0}," +

            "{\"bottom\":450.0,\"left\":700.0,\"right\":1200.0,\"top\":0.0}," +
            "{\"bottom\":800.0,\"left\":700.0,\"right\":1200.0,\"top\":450.0}," +

            "{\"bottom\":450.0,\"left\":1200.0,\"right\":1700.0,\"top\":0.0}," +
            "{\"bottom\":800.0,\"left\":1200.0,\"right\":1700.0,\"top\":450.0}," +

            "{\"bottom\":450.0,\"left\":1700.0,\"right\":2200.0,\"top\":0.0}," +
            "{\"bottom\":800.0,\"left\":1700.0,\"right\":2200.0,\"top\":450.0}," +

            "{\"bottom\":450.0,\"left\":2200.0,\"right\":2700.0,\"top\":0.0}," +
            "{\"bottom\":800.0,\"left\":2200.0,\"right\":2700.0,\"top\":450.0}," +

            "{\"bottom\":450.0,\"left\":2700.0,\"right\":3200.0,\"top\":0.0}," +
            "{\"bottom\":800.0,\"left\":2700.0,\"right\":3200.0,\"top\":450.0}," +

            "{\"bottom\":450.0,\"left\":3200.0,\"right\":3700.0,\"top\":0.0}," +
            "{\"bottom\":800.0,\"left\":3200.0,\"right\":3700.0,\"top\":450.0}," +

            "{\"bottom\":450.0,\"left\":3700.0,\"right\":4200.0,\"top\":0.0}," +
            "{\"bottom\":800.0,\"left\":3700.0,\"right\":4200.0,\"top\":450.0},]";




    private String mRectFMsg4 = "[{\"bottom\":200.0,\"left\":0.0,\"right\":400.0,\"top\":0.0}," +
            "{\"bottom\":400.0,\"left\":0.0,\"right\":400.0,\"top\":200.0}," +
            "{\"bottom\":600.0,\"left\":0.0,\"right\":400.0,\"top\":400.0}," +
            "{\"bottom\":800.0,\"left\":0.0,\"right\":400.0,\"top\":600.0}," +


            "{\"bottom\":400.0,\"left\":400.0,\"right\":800.0,\"top\":0.0}," +
            "{\"bottom\":800.0,\"left\":400.0,\"right\":800.0,\"top\":400.0}," +

            "{\"bottom\":400.0,\"left\":800.0,\"right\":1200.0,\"top\":0.0}," +
            "{\"bottom\":800.0,\"left\":800.0,\"right\":1200.0,\"top\":400.0}," +

            "{\"bottom\":400.0,\"left\":1200.0,\"right\":1600.0,\"top\":0.0}," +
            "{\"bottom\":800.0,\"left\":1200.0,\"right\":1600.0,\"top\":400.0}," +

            "{\"bottom\":400.0,\"left\":1600.0,\"right\":2000.0,\"top\":0.0}," +
            "{\"bottom\":800.0,\"left\":1600.0,\"right\":2000.0,\"top\":400.0}," +

            "{\"bottom\":400.0,\"left\":2000.0,\"right\":2400.0,\"top\":0.0}," +
            "{\"bottom\":800.0,\"left\":2000.0,\"right\":2400.0,\"top\":400.0}," +

            "{\"bottom\":400.0,\"left\":2400.0,\"right\":2800.0,\"top\":0.0}," +
            "{\"bottom\":800.0,\"left\":2400.0,\"right\":2800.0,\"top\":400.0}," +

            "{\"bottom\":400.0,\"left\":2800.0,\"right\":3200.0,\"top\":0.0}," +
            "{\"bottom\":800.0,\"left\":2800.0,\"right\":3200.0,\"top\":400.0}," +

            "{\"bottom\":400.0,\"left\":3200.0,\"right\":3600.0,\"top\":0.0}," +
            "{\"bottom\":800.0,\"left\":3200.0,\"right\":3600.0,\"top\":400.0},]";





    private String mRectFMsg5 = "[{\"bottom\":200.0,\"left\":0.0,\"right\":400.0,\"top\":0.0}," +
            "{\"bottom\":400.0,\"left\":0.0,\"right\":400.0,\"top\":200.0}," +
            "{\"bottom\":600.0,\"left\":0.0,\"right\":400.0,\"top\":400.0}," +
            "{\"bottom\":800.0,\"left\":0.0,\"right\":400.0,\"top\":600.0}," +


            "{\"bottom\":400.0,\"left\":400.0,\"right\":1200.0,\"top\":0.0}," +
            "{\"bottom\":800.0,\"left\":400.0,\"right\":1200.0,\"top\":400.0}," +

            "{\"bottom\":400.0,\"left\":1200.0,\"right\":2000.0,\"top\":0.0}," +
            "{\"bottom\":800.0,\"left\":1200.0,\"right\":2000.0,\"top\":400.0}," +

            "{\"bottom\":400.0,\"left\":2000.0,\"right\":2400.0,\"top\":0.0}," +
            "{\"bottom\":800.0,\"left\":2000.0,\"right\":2400.0,\"top\":400.0}," +

            "{\"bottom\":400.0,\"left\":2400.0,\"right\":3200.0,\"top\":0.0}," +
            "{\"bottom\":800.0,\"left\":2400.0,\"right\":3200.0,\"top\":400.0}," +


            "{\"bottom\":400.0,\"left\":3200.0,\"right\":4000.0,\"top\":0.0}," +
            "{\"bottom\":800.0,\"left\":3200.0,\"right\":4000.0,\"top\":400.0}," +

            "{\"bottom\":400.0,\"left\":4000.0,\"right\":4400.0,\"top\":0.0}," +
            "{\"bottom\":800.0,\"left\":4000.0,\"right\":4400.0,\"top\":400.0}," +

            "{\"bottom\":400.0,\"left\":4400.0,\"right\":5200.0,\"top\":0.0}," +
            "{\"bottom\":800.0,\"left\":4400.0,\"right\":5200.0,\"top\":400.0},]";





    private String mRectFMsg6 = "[{\"bottom\":200.0,\"left\":0.0,\"right\":400.0,\"top\":0.0}," +
            "{\"bottom\":400.0,\"left\":0.0,\"right\":400.0,\"top\":200.0}," +
            "{\"bottom\":600.0,\"left\":0.0,\"right\":400.0,\"top\":400.0}," +
            "{\"bottom\":800.0,\"left\":0.0,\"right\":400.0,\"top\":600.0}," +


            "{\"bottom\":400.0,\"left\":400.0,\"right\":1200.0,\"top\":0.0}," +
            "{\"bottom\":800.0,\"left\":400.0,\"right\":1200.0,\"top\":400.0}," +

            "{\"bottom\":400.0,\"left\":1200.0,\"right\":2000.0,\"top\":0.0}," +
            "{\"bottom\":800.0,\"left\":1200.0,\"right\":2000.0,\"top\":400.0}," +

            "{\"bottom\":400.0,\"left\":2000.0,\"right\":2400.0,\"top\":0.0}," +
            "{\"bottom\":800.0,\"left\":2000.0,\"right\":2400.0,\"top\":400.0}," +

            "{\"bottom\":400.0,\"left\":2400.0,\"right\":3200.0,\"top\":0.0}," +
            "{\"bottom\":800.0,\"left\":2400.0,\"right\":3200.0,\"top\":400.0}," +


            "{\"bottom\":400.0,\"left\":3200.0,\"right\":4000.0,\"top\":0.0}," +
            "{\"bottom\":800.0,\"left\":3200.0,\"right\":4000.0,\"top\":400.0}," +

            "{\"bottom\":400.0,\"left\":4000.0,\"right\":4400.0,\"top\":0.0}," +
            "{\"bottom\":800.0,\"left\":4000.0,\"right\":4400.0,\"top\":400.0}," +

            "{\"bottom\":400.0,\"left\":4400.0,\"right\":5200.0,\"top\":0.0}," +
            "{\"bottom\":800.0,\"left\":4400.0,\"right\":5200.0,\"top\":400.0},]";





    private String mRectFMsg7 ="[{\"bottom\":200.0,\"left\":0.0,\"right\":400.0,\"top\":0.0}," +
            "{\"bottom\":400.0,\"left\":0.0,\"right\":400.0,\"top\":200.0}," +
            "{\"bottom\":600.0,\"left\":0.0,\"right\":400.0,\"top\":400.0}," +
            "{\"bottom\":800.0,\"left\":0.0,\"right\":400.0,\"top\":600.0}," +


            "{\"bottom\":400.0,\"left\":400.0,\"right\":1400.0,\"top\":0.0}," +
            "{\"bottom\":600.0,\"left\":400.0,\"right\":900.0,\"top\":400.0}," +
            "{\"bottom\":800.0,\"left\":400.0,\"right\":900.0,\"top\":600.0}," +
            "{\"bottom\":600.0,\"left\":900.0,\"right\":1400.0,\"top\":400.0}," +
            "{\"bottom\":800.0,\"left\":900.0,\"right\":1400.0,\"top\":600.0}," +


            "{\"bottom\":400.0,\"left\":1400.0,\"right\":2000.0,\"top\":0.0}," +
            "{\"bottom\":800.0,\"left\":1400.0,\"right\":2000.0,\"top\":400.0}," +

            "{\"bottom\":400.0,\"left\":2000.0,\"right\":2400.0,\"top\":0.0}," +
            "{\"bottom\":800.0,\"left\":2000.0,\"right\":2400.0,\"top\":400.0}," +

            "{\"bottom\":400.0,\"left\":2400.0,\"right\":3200.0,\"top\":0.0}," +
            "{\"bottom\":800.0,\"left\":2400.0,\"right\":3200.0,\"top\":400.0}," +


            "{\"bottom\":400.0,\"left\":3200.0,\"right\":4000.0,\"top\":0.0}," +
            "{\"bottom\":800.0,\"left\":3200.0,\"right\":4000.0,\"top\":400.0}," +

            "{\"bottom\":400.0,\"left\":4000.0,\"right\":4400.0,\"top\":0.0}," +
            "{\"bottom\":800.0,\"left\":4000.0,\"right\":4400.0,\"top\":400.0}," +

            "{\"bottom\":400.0,\"left\":4400.0,\"right\":5200.0,\"top\":0.0}," +
            "{\"bottom\":800.0,\"left\":4400.0,\"right\":5200.0,\"top\":400.0},]";






    private String mRectFMsg8 = "[{\"bottom\":800.0,\"left\":0.0,\"right\":300.0,\"top\":0.0}," +
            "{\"bottom\":800.0,\"left\":300.0,\"right\":500.0,\"top\":0.0}," +
            "{\"bottom\":800.0,\"left\":500.0,\"right\":700.0,\"top\":0.0}," +
            "{\"bottom\":800.0,\"left\":700.0,\"right\":900.0,\"top\":0.0}," +
            "{\"bottom\":800.0,\"left\":900.0,\"right\":1100.0,\"top\":0.0}," +
            "{\"bottom\":800.0,\"left\":1100.0,\"right\":1300.0,\"top\":0.0}," +
            "{\"bottom\":800.0,\"left\":1300.0,\"right\":1500.0,\"top\":0.0}," +
            "{\"bottom\":800.0,\"left\":1500.0,\"right\":1700.0,\"top\":0.0}," +
            "{\"bottom\":800.0,\"left\":1700.0,\"right\":1900.0,\"top\":0.0}," +

            "{\"bottom\":800.0,\"left\":1900.0,\"right\":2100.0,\"top\":0.0},]";




    private String mRectFMsg9 = "[{\"bottom\":453.0,\"left\":50.0,\"right\":245.0,\"top\":301.0}," +
            "{\"bottom\":301.0,\"left\":830.0,\"right\":1220.0,\"top\":49.0}," +
            "{\"bottom\":453.0,\"left\":245.0,\"right\":830.0,\"top\":49.0}," +
            "{\"bottom\":805.0,\"left\":830.0,\"right\":1025.0,\"top\":453.0}," +
            "{\"bottom\":301.0,\"left\":50.0,\"right\":245.0,\"top\":49.0}," +
            "{\"bottom\":805.0,\"left\":245.0,\"right\":830.0,\"top\":453.0}," +
            "{\"bottom\":805.0,\"left\":1025.0,\"right\":1220.0,\"top\":453.0}," +
            "{\"bottom\":805.0,\"left\":50.0,\"right\":245.0,\"top\":453.0}," +
            "{\"bottom\":453.0,\"left\":830.0,\"right\":1220.0,\"top\":301.0}," +

            "{\"bottom\":453.0,\"left\":1220.0,\"right\":1415.0,\"top\":301.0}," +
            "{\"bottom\":301.0,\"left\":2000.0,\"right\":2390.0,\"top\":49.0}," +
            "{\"bottom\":453.0,\"left\":1415.0,\"right\":2000.0,\"top\":49.0}," +
            "{\"bottom\":805.0,\"left\":2000.0,\"right\":2195.0,\"top\":453.0}," +
            "{\"bottom\":301.0,\"left\":1220.0,\"right\":1415.0,\"top\":49.0}," +
            "{\"bottom\":805.0,\"left\":1415.0,\"right\":2000.0,\"top\":453.0}," +
            "{\"bottom\":805.0,\"left\":2195.0,\"right\":2390.0,\"top\":453.0}," +
            "{\"bottom\":805.0,\"left\":1220.0,\"right\":1415.0,\"top\":453.0}," +
            "{\"bottom\":453.0,\"left\":2000.0,\"right\":2390.0,\"top\":301.0},]";


    //private BookPresenter mBookPresenter = new BookPresenter(this);
    private PgcPresenter mPgcPresenter = new PgcPresenter(this,this);

    //private ArrayList<HashMap<String, Object>> listItem;

    private String[] inputStrs = {mRectFMsg0,mRectFMsg1,mRectFMsg2,mRectFMsg3,mRectFMsg4,mRectFMsg5,mRectFMsg6,mRectFMsg7,mRectFMsg8,mRectFMsg9};


    @Override
    protected int getContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    protected void init()
    {
        mToolBar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolBar);

        setAntiAlias();

        StatusBarUtils.setWindowStatusBarColor(this, Color.BLACK);

        attchCHclick();

        SetViewpager();


    }

    private void SetViewpager()
    {
        TVReCycleViewPagerAdapter mAdapter = new TVReCycleViewPagerAdapter(mViewPager.getContext());

        try {
            /**
             * 步骤3:设置需要存放的数据
             * */
//            listItem = new ArrayList<HashMap<String, Object>>();
//            for (int i = 0; i < 10; i++) {
//                HashMap<String, Object> map = new HashMap<String, Object>();
//                map.put("ItemTitle", "第" + i + "个");
//                map.put("ItemImage", R.mipmap.ic_launcher);
//                listItem.add(map);
//
//            }

            mAdapter.setDatas(inputStrs);
            mViewPager.setAdapter(mAdapter);
            mViewPager.setBackgroundColor(Color.RED);

            TextView name = (TextView)findViewById(R.id.common_broadcast_text);
            name.setTextColor(Color.RED);

            mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener()
            {
                public int getCurrentIndex() {
                    return currentIndex;
                }

                private int currentIndex = 0;

                @Override
                public void onPageSelected(int position)
                {
                    initCH();
                    TextView name;
                    int dx =300*(position - currentIndex);
                    switch (position)
                    {
                        case 0:
                            name = (TextView)findViewById(R.id.common_broadcast_text);
                            break;
                        case 1:
                            name = (TextView)findViewById(R.id.recommend_text);
                            break;
                        case 2:
                            name = (TextView)findViewById(R.id.TV_text);
                            break;
                        case 3:
                            name = (TextView)findViewById(R.id.VIP_text);
                            break;
                        case 4:
                            name = (TextView)findViewById(R.id.Children_text);
                            break;
                        case 5:
                            name = (TextView)findViewById(R.id.TVShow_text);
                            break;
                        case 6:
                            name = (TextView)findViewById(R.id.Film_text);
                            break;
                        case 7:
                            name = (TextView)findViewById(R.id.Video_text);
                            break;
                        case 8:
                            name = (TextView)findViewById(R.id.More_text);

                            break;
                        case 9:
                            name = (TextView)findViewById(R.id.Setting_text);

                            break;
                        default:
                            name =null;
                            break;
                    }

                    if(name!=null)
                    {
                        name.setTextColor(Color.RED);
                        checkCHVisible( name, dx);
                    }

                    currentIndex = position;

                }

                @Override
                public void onPageScrolled(int arg0, float arg1, int arg2)
                {

                }

                @Override
                public void onPageScrollStateChanged(int arg0)
                {

                }
            });


        }
        catch (Exception ex)
        {
            Log.d("ViewPager",ex.toString());
        }



    }

    private void checkCHVisible(TextView name,int dx)
    {
        CHScrollView ch = (CHScrollView)findViewById(R.id.item_scroll_title);
        Rect scrollRect = new Rect();
        ch.getHitRect(scrollRect);
        //子控件在可视范围内（至少有一个像素在可视范围内）
        if (name.getGlobalVisibleRect(scrollRect)) {

        } else {
            ////子控件完全不在可视范围内
            ch.smoothScrollBy(dx,0);
        }
    }

    private void attchCHclick()
    {
        common_broadcast_text =(TextView)findViewById(R.id.common_broadcast_text);
        common_broadcast_text.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Log.i("匿名内部类", "点击事件");

                Animation shake = AnimationUtils.loadAnimation(v.getContext(), R.anim.left_right_shake);
                common_broadcast_text.startAnimation(shake);

                mViewPager.setCurrentItem(0);

            }
        });


        recommend_text =(TextView)findViewById(R.id.recommend_text);
        recommend_text.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Log.i("匿名内部类", "点击事件");

                Animation shake = AnimationUtils.loadAnimation(v.getContext(), R.anim.left_right_shake);
                recommend_text.startAnimation(shake);

                mViewPager.setCurrentItem(1);

            }
        });

        TV_text =(TextView)findViewById(R.id.TV_text);
        TV_text.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Log.i("匿名内部类", "点击事件");

                Animation shake = AnimationUtils.loadAnimation(v.getContext(), R.anim.left_right_shake);
                TV_text.startAnimation(shake);

                mViewPager.setCurrentItem(2);

            }
        });

        VIP_text =(TextView)findViewById(R.id.VIP_text);
        VIP_text.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Log.i("匿名内部类", "点击事件");

                Animation shake = AnimationUtils.loadAnimation(v.getContext(), R.anim.left_right_shake);
                VIP_text.startAnimation(shake);

                mViewPager.setCurrentItem(3);

            }
        });

        Children_text =(TextView)findViewById(R.id.Children_text);
        Children_text.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Log.i("匿名内部类", "点击事件");

                Animation shake = AnimationUtils.loadAnimation(v.getContext(), R.anim.left_right_shake);
                Children_text.startAnimation(shake);

                mViewPager.setCurrentItem(4);

            }
        });

        TVShow_text =(TextView)findViewById(R.id.TVShow_text);
        TVShow_text.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Log.i("匿名内部类", "点击事件");

                Animation shake = AnimationUtils.loadAnimation(v.getContext(), R.anim.left_right_shake);
                TVShow_text.startAnimation(shake);

                mViewPager.setCurrentItem(5);

            }
        });

        Film_text =(TextView)findViewById(R.id.Film_text);
        Film_text.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Log.i("匿名内部类", "点击事件");

                Animation shake = AnimationUtils.loadAnimation(v.getContext(), R.anim.left_right_shake);
                Film_text.startAnimation(shake);

                mViewPager.setCurrentItem(6);

            }
        });

        Video_text =(TextView)findViewById(R.id.Video_text);
        Video_text.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Log.i("匿名内部类", "点击事件");

                Animation shake = AnimationUtils.loadAnimation(v.getContext(), R.anim.left_right_shake);
                Video_text.startAnimation(shake);

                mViewPager.setCurrentItem(7);

            }
        });

        More_text =(TextView)findViewById(R.id.More_text);
        More_text.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Log.i("匿名内部类", "点击事件");

                Animation shake = AnimationUtils.loadAnimation(v.getContext(), R.anim.left_right_shake);
                More_text.startAnimation(shake);

                mViewPager.setCurrentItem(8);

            }
        });

        Setting_text =(TextView)findViewById(R.id.Setting_text);
        Setting_text.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Log.i("匿名内部类", "点击事件");

                Animation shake = AnimationUtils.loadAnimation(v.getContext(), R.anim.left_right_shake);
                Setting_text.startAnimation(shake);

                mViewPager.setCurrentItem(9);

            }
        });



    }

    private void initCH()
    {
        TextView name = (TextView)findViewById(R.id.common_broadcast_text);
        name.setTextColor(Color.WHITE);
        name = (TextView)findViewById(R.id.recommend_text);
        name.setTextColor(Color.WHITE);
        name = (TextView)findViewById(R.id.TV_text);
        name.setTextColor(Color.WHITE);
        name = (TextView)findViewById(R.id.VIP_text);
        name.setTextColor(Color.WHITE);
        name = (TextView)findViewById(R.id.Children_text);
        name.setTextColor(Color.WHITE);
        name = (TextView)findViewById(R.id.TVShow_text);
        name.setTextColor(Color.WHITE);
        name = (TextView)findViewById(R.id.Film_text);
        name.setTextColor(Color.WHITE);
        name = (TextView)findViewById(R.id.Video_text);
        name.setTextColor(Color.WHITE);
        name = (TextView)findViewById(R.id.More_text);
        name.setTextColor(Color.WHITE);
        name = (TextView)findViewById(R.id.Setting_text);
        name.setTextColor(Color.WHITE);
    }

    private void setAntiAlias()
    {
        TextView name = (TextView)findViewById(R.id.common_broadcast_text);
        //抗锯齿
        name.getPaint().setAntiAlias(true);

    }


//    private void initReCycleView()
//    {
//        //绑定VirtualLayoutManager
//        VirtualLayoutManager layoutManager = new VirtualLayoutManager(this);
//        mRecyclerView.setLayoutManager(layoutManager);
//
//
//        /**
//         * 步骤2：设置组件复用回收池
//         * */
//        RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
//        mRecyclerView.setRecycledViewPool(viewPool);
//        viewPool.setMaxRecycledViews(0, 10);
//
//        /**
//         * 步骤3:设置需要存放的数据
//         * */
//        listItem = new ArrayList<HashMap<String, Object>>();
//        for (int i = 0; i < 100; i++) {
//            HashMap<String, Object> map = new HashMap<String, Object>();
//            map.put("ItemTitle", "第" + i + "行");
//            map.put("ItemImage", R.mipmap.ic_launcher);
//            listItem.add(map);
//
//        }
//
//
//        /**
//         设置Grid布局
//         */
//        GridLayoutHelper gridLayoutHelper = new GridLayoutHelper(3);
//        // 在构造函数设置每行的网格个数
//
//        // 公共属性
//        gridLayoutHelper.setItemCount(36);// 设置布局里Item个数
//        gridLayoutHelper.setPadding(20, 20, 20, 20);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
//        gridLayoutHelper.setMargin(20, 20, 20, 20);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
//        // gridLayoutHelper.setBgColor(Color.GRAY);// 设置背景颜色
//        gridLayoutHelper.setAspectRatio(6);// 设置设置布局内每行布局的宽与高的比
//
//
//        // gridLayoutHelper特有属性
//        gridLayoutHelper.setWeights(new float[]{40, 30, 30});//设置每行中 每个网格宽度 占 每行总宽度 的比例
//        gridLayoutHelper.setVGap(20);// 控制子元素之间的垂直间距
//        gridLayoutHelper.setHGap(20);// 控制子元素之间的水平间距
//        gridLayoutHelper.setAutoExpand(false);//是否自动填充空白区域
//        gridLayoutHelper.setSpanCount(3);// 设置每行多少个网格
//        // 通过自定义SpanSizeLookup来控制某个Item的占网格个数
//        gridLayoutHelper.setSpanSizeLookup(new GridLayoutHelper.SpanSizeLookup() {
//            @Override
//            public int getSpanSize(int position) {
//                if (position > 7) {
//                    return 3;
//                    // 第7个位置后,每个Item占3个网格
//                } else {
//                    return 2;
//                    // 第7个位置前,每个Item占2个网格
//                }
//            }
//        });
//
//        MyAdapter Adapter_GridLayout  = new MyAdapter(this, gridLayoutHelper,36, listItem) {
//            // 设置需要展示的数据总数,此处设置是8,即展示总数是8个,然后每行是4个(上面设置的)
//            // 为了展示效果,通过重写onBindViewHolder()将布局的第一个数据设置为gridLayoutHelper
//            @Override
//            public void onBindViewHolder(MainViewHolder holder, int position) {
//                super.onBindViewHolder(holder, position);
//                // 为了展示效果,将布局里不同位置的Item进行背景颜色设置
//                if (position < 2) {
//                    holder.itemView.setBackgroundColor(0x66cc0000 + (position - 6) * 128);
//                } else if (position % 2 == 0) {
//                    holder.itemView.setBackgroundColor(0xaa22ff22);
//                } else {
//                    holder.itemView.setBackgroundColor(0xccff22ff);
//                }
//
//
//
//                if (position == 0) {
//                    holder.Text.setText("Grid");
//                }
//            }
//        };
//
//        Adapter_GridLayout.setOnItemClickListener(this);
//        // 设置每个Item的点击事件
//
//        /**
//         *步骤5:将生成的LayoutHelper 交给Adapter，并绑定到RecyclerView 对象
//         **/
//
//        // 1. 设置Adapter列表（同时也是设置LayoutHelper列表）
//        List<DelegateAdapter.Adapter> adapters = new LinkedList<>();
//
//        // 2. 将上述创建的Adapter对象放入到DelegateAdapter.Adapter列表里
////        adapters.add(Adapter_linearLayout) ;
////        adapters.add(Adapter_StickyLayout) ;
////        adapters.add(Adapter_ScrollFixLayout) ;
//        adapters.add(Adapter_GridLayout) ;
////        adapters.add(Adapter_FixLayout) ;
////        adapters.add(Adapter_FloatLayout) ;
////        adapters.add(Adapter_ColumnLayout) ;
////        adapters.add(Adapter_SingleLayout) ;
////        adapters.add(Adapter_onePlusNLayout) ;
////        adapters.add(Adapter_StaggeredGridLayout) ;
//
//
//        //
//        // 3. 创建DelegateAdapter对象 & 将layoutManager绑定到DelegateAdapter
//        DelegateAdapter delegateAdapter = new DelegateAdapter(layoutManager);
//
//        // 4. 将DelegateAdapter.Adapter列表绑定到DelegateAdapter
//        delegateAdapter.setAdapters(adapters);
//
//        // 5. 将delegateAdapter绑定到recyclerView
//        mRecyclerView.setAdapter(delegateAdapter);
//
//
//
//
//
//    }


    @Override
    public void onSuccess(Pgc mPgc)
    {
        etResulttext.setText(mPgc.toString());
    }
    @Override
    public void onError(String result) {
        Toast.makeText(MainActivity.this,result, Toast.LENGTH_SHORT).show();
    }


    @OnClick({R.id.button})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                mPgcPresenter.getPgc(31, "370f37af1847ee3308e77f86629f3955");
                break;
        }
    }


    /**
     *步骤7:实现Item点击事件
     **/
    // 点击事件的回调函数
    @Override
    public void onItemClick(View view, int postion) {
        System.out.println("点击了第"+postion+"行");
        //Toast.makeText(this, (String) listItem.get(postion).get("ItemTitle"), Toast.LENGTH_SHORT).show();
    }




    @Override
    public boolean onMenuOpened(int featureId, Menu menu) {
        if (menu != null) {
            if (menu.getClass().getSimpleName().equalsIgnoreCase("MenuBuilder")) {
                try {
                    Method method = menu.getClass().getDeclaredMethod("setOptionalIconsVisible", Boolean.TYPE);
                    method.setAccessible(true);
                    method.invoke(menu, true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return super.onMenuOpened(featureId, menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        getMenuInflater().inflate(R.menu.menu_main, menu);

        setUpCartMenuItem(menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (item.getItemId())
        {
            case R.id.action_search:
                Toast.makeText(MainActivity.this, "搜索", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_user:
                Toast.makeText(MainActivity.this, "添加", Toast.LENGTH_SHORT).show();
                //startAddDev();
                break;
//            case R.id.action_vip:
//                Toast.makeText(MainActivity.this, "设置", Toast.LENGTH_SHORT).show();
//                break;
        }


        return super.onOptionsItemSelected(item);
    }

    private void setUpCartMenuItem(Menu menu) {
        MenuItem item = menu.findItem(R.id.action_msg);
        View actionView = MenuItemCompat.getActionView(item);
        View mCartView = ((ViewGroup) actionView).getChildAt(0);
        if (mCartView != null) {
            BadgeView badgeView = new BadgeView(MainActivity.this, mCartView);
            badgeView.setBadgePosition(BadgeView.POSITION_TOP_RIGHT);
            badgeView.setText("111");
            mCartView.measure(0, 0);
            badgeView.setBadgeMargin(mCartView.getMeasuredWidth() / 55, mCartView.getMeasuredWidth() / 65);
            badgeView.show(true);
            actionView.measure(0, 0);
        }
    }


//    @Override
//    protected void onDestroy(){
//        super.onDestroy();
//        //mBookPresenter.onStop();
//    }
}
