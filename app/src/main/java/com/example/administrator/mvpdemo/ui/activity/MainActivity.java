package com.example.administrator.mvpdemo.ui.activity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Color;

import android.graphics.Rect;
import android.os.IBinder;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;


import android.widget.TextView;
import android.widget.Toast;


import com.example.administrator.mvpdemo.Adapter.HomeAdapter;
import com.example.administrator.mvpdemo.Adapter.MyItemClickListener;

import com.example.administrator.mvpdemo.Adapter.TVReCycleViewPagerAdapter;
import com.example.administrator.mvpdemo.Model.ChannelInfo;
import com.example.administrator.mvpdemo.Model.ChannelInfoList;
import com.example.administrator.mvpdemo.Model.PgcList;
import com.example.administrator.mvpdemo.MyReCyclerView.HomeLayoutManager;
import com.example.administrator.mvpdemo.R;
import com.example.administrator.mvpdemo.Util.StatusBarUtils;
import com.example.administrator.mvpdemo.base.BaseActivity;

import com.example.administrator.mvpdemo.event.Events;
import com.example.administrator.mvpdemo.event.RxBus;
import com.example.administrator.mvpdemo.event.RxBusBaseMessage;
import com.example.administrator.mvpdemo.event.RxCodeConstants;
import com.example.administrator.mvpdemo.service.ChannelDataService;
import com.example.administrator.mvpdemo.service.entity.Pgc;

import com.example.administrator.mvpdemo.service.presenter.PgcPresenter;

import com.example.administrator.mvpdemo.service.view.ITestView;

import com.example.administrator.mvpdemo.ui.CustomWidgets.BadgeView;
import com.example.administrator.mvpdemo.ui.CustomWidgets.CHScrollView;
import com.example.administrator.mvpdemo.ui.CustomWidgets.FocusView;
import com.example.administrator.mvpdemo.ui.LayoutData.LayoutData;


import java.lang.reflect.Method;




import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.functions.Consumer;

public class MainActivity extends BaseActivity implements ITestView,MyItemClickListener {

//    @BindView(R.id.myRecyclerView)
//    RecyclerView mRecyclerView;

    @BindView(R.id.id_viewpager)
    ViewPager mViewPager;

    @BindView(R.id.item_scroll_title)
    CHScrollView mCHScrollView;

    @BindView(R.id.common_broadcast_text)
    TextView common_broadcast_text;
    @BindView(R.id.recommend_text)
    TextView recommend_text;
    @BindView(R.id.TV_text)
    TextView TV_text;
    @BindView(R.id.VIP_text)
    TextView VIP_text;
    @BindView(R.id.Children_text)
    TextView Children_text;
    @BindView(R.id.TVShow_text)
    TextView TVShow_text;
    @BindView(R.id.Film_text)
    TextView Film_text;
    @BindView(R.id.Video_text)
    TextView Video_text;
    @BindView(R.id.More_text)
    TextView More_text;
    @BindView(R.id.Setting_text)
    TextView Setting_text;

    private Toolbar mToolBar;

    //private BookPresenter mBookPresenter = new BookPresenter(this);
    private PgcPresenter mPgcPresenter = new PgcPresenter(this,this);

    //private ArrayList<HashMap<String, Object>> listItem;

    @Override
    protected int getContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    protected void init()
    {
        mToolBar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolBar);

        //setAntiAlias();

        StatusBarUtils.setWindowStatusBarColor(this, Color.BLACK);

        attchCHclick();

        SetViewpager();


//        Intent startIntent = new Intent(this, ChannelDataService.class);
//        startService(startIntent);


        RxBus.getInstance().tObservable(RxCodeConstants.JUMP_2_BOTTOMBAR, RxBusBaseMessage.class)
                .subscribe(new Consumer<RxBusBaseMessage>() {
                    @Override
                    public void accept(RxBusBaseMessage rxBusBaseMessage) throws Exception {
                        Log.d("RxBus", "accept: ");
                        SetBottomBarItemsFocused();
                    }
                });


        RxBus.getInstance().tObservable(RxCodeConstants.Get_PGC, RxBusBaseMessage.class)
                .subscribe(new Consumer<RxBusBaseMessage>() {
                    @Override
                    public void accept(RxBusBaseMessage rxBusBaseMessage) throws Exception {
                        Log.d("RxBus", "accept: ");

                        RecyclerView rc = (RecyclerView) ((TVReCycleViewPagerAdapter)mViewPager.getAdapter()).getPrimaryItem();

                        //rc.getAdapter().notifyDataSetChanged();

                        rc.getAdapter().notifyItemRangeChanged(0,20);


                    }
                });

        RxBus.getInstance().tObservable(RxCodeConstants.ReCycleView_init, RxBusBaseMessage.class)
                .subscribe(new Consumer<RxBusBaseMessage>() {
                    @Override
                    public void accept(RxBusBaseMessage rxBusBaseMessage) throws Exception {
                        Log.d("RxBus", "accept: ");

                        ChannelInfo ci = ChannelInfoList.getInstance().getmChannelInfos().get(rxBusBaseMessage.getCode());

                        ci.requestCount = 0;

                        if(!ci.isDataOver) {
                            mPgcPresenter.getPgcInfo(Integer.parseInt(ci.getMkey()), "370f37af1847ee3308e77f86629f3955", 1, 20, Integer.parseInt(ci.getCat()), 1);
                        }

//                        RecyclerView rc = (RecyclerView) ((TVReCycleViewPagerAdapter) mViewPager.getAdapter()).getPrimaryItem();
//                        rc.getAdapter().notifyDataSetChanged();


                    }
                });

        RxBus.getInstance().tObservable(RxCodeConstants.Re_Get_PGC, RxBusBaseMessage.class)
                .subscribe(new Consumer<RxBusBaseMessage>() {
                    @Override
                    public void accept(RxBusBaseMessage rxBusBaseMessage) throws Exception {
                        Log.d("RxBus", "accept: ");

                        ChannelInfo ci = ChannelInfoList.getInstance().getmChannelInfos().get(rxBusBaseMessage.getCode());

                        ci.requestCount++;

                        if(ci.requestCount <10)
                        {
                            if(!ci.isDataOver)
                            {
                                mPgcPresenter.getPgcInfo(Integer.parseInt(ci.getMkey()),"370f37af1847ee3308e77f86629f3955",1,20,Integer.parseInt(ci.getCat()),1);
                            }
                        }


//                        RecyclerView rc = (RecyclerView) ((TVReCycleViewPagerAdapter)mViewPager.getAdapter()).getPrimaryItem();
//
//                        rc.getAdapter().notifyDataSetChanged();


                    }
                });


        RxBus.getInstance().tObservable(RxCodeConstants.JUMP_2_LEFT, RxBusBaseMessage.class)
                .subscribe(new Consumer<RxBusBaseMessage>() {
                    @Override
                    public void accept(RxBusBaseMessage rxBusBaseMessage) throws Exception {
                        Log.d("RxBus", "accept: ");

                        if (rxBusBaseMessage.getCode()==0)
                          return;

                        mViewPager.setCurrentItem(rxBusBaseMessage.getCode()-1);

                        TVReCycleViewPagerAdapter tva = (TVReCycleViewPagerAdapter)mViewPager.getAdapter();

                        RecyclerView rc = (RecyclerView)tva.getPrimaryItem();

                        HomeLayoutManager l = (HomeLayoutManager)rc.getLayoutManager();

                        rc.setDescendantFocusability(ViewGroup.FOCUS_BEFORE_DESCENDANTS);

                        FocusView preFocusView = (FocusView) rxBusBaseMessage.getObject();

                        for (int i =0;i<l.getChildCount();i++)
                        {
                            FocusView v = (FocusView) rc.getChildAt(i);
                            if((v!=null)&&(v.isRightEdge))
                            {

                                if(((v.bounds.bottom >= preFocusView.bounds.bottom)&&(v.bounds.top <preFocusView.bounds.bottom))
                                        ||((v.bounds.bottom >= preFocusView.bounds.top)&&(v.bounds.top <preFocusView.bounds.top)))
                                {
                                    v.requestFocus();
                                    break;
                                }
                            }

                        }

                        rc.setDescendantFocusability(ViewGroup.FOCUS_AFTER_DESCENDANTS);
                    }
                });

        RxBus.getInstance().tObservable(RxCodeConstants.JUMP_2_RIGHT, RxBusBaseMessage.class)
                .subscribe(new Consumer<RxBusBaseMessage>() {
                    @Override
                    public void accept(RxBusBaseMessage rxBusBaseMessage) throws Exception {
                        Log.d("RxBus", "accept: ");

                        if (rxBusBaseMessage.getCode()== ChannelInfoList.getInstance().getmChannelInfos().size() - 1)
                            return;

                        mViewPager.setCurrentItem(rxBusBaseMessage.getCode() + 1);

                        TVReCycleViewPagerAdapter tva = (TVReCycleViewPagerAdapter)mViewPager.getAdapter();

                        RecyclerView rc = (RecyclerView)tva.getPrimaryItem();

                        HomeAdapter ha = (HomeAdapter)rc.getAdapter();

                        rc.setDescendantFocusability(ViewGroup.FOCUS_BEFORE_DESCENDANTS);

                        FocusView preFocusView = (FocusView) rxBusBaseMessage.getObject();

                        for (int i =0;i<ha.getItemCount();i++)
                        {
                            FocusView v = (FocusView) rc.getChildAt(i);
                            if((v!=null)&&(v.isLeftEdge))
                            {
                                if(((v.bounds.bottom >= preFocusView.bounds.bottom)&&(v.bounds.top <preFocusView.bounds.bottom))
                                    ||((v.bounds.bottom >= preFocusView.bounds.top)&&(v.bounds.top <preFocusView.bounds.top)))
                                {
                                    v.requestFocus();
                                    break;
                                }
                            }

                        }

                        rc.setDescendantFocusability(ViewGroup.FOCUS_AFTER_DESCENDANTS);
                    }
                });


        RxBus.getInstance().tObservable(RxCodeConstants.JUMP_2_TOOLBAR, RxBusBaseMessage.class)
                .subscribe(new Consumer<RxBusBaseMessage>() {
                    @Override
                    public void accept(RxBusBaseMessage rxBusBaseMessage) throws Exception {
                        Log.d("RxBus", "accept: ");


                    }
                });


    }


    private TextView ChangeChannel(int position)
    {
        TextView name;
        switch (position)
        {
            case 0:
                name = common_broadcast_text;
                break;
            case 1:
                name = recommend_text;
                break;
            case 2:
                name = TV_text;
                break;
            case 3:
                name = VIP_text;
                break;
            case 4:
                name = Children_text;
                break;
            case 5:
                name = TVShow_text;
                break;
            case 6:
                name = Film_text;
                break;
            case 7:
                name = Video_text;
                break;
            case 8:
                name = More_text;

                break;
            case 9:
                name = Setting_text;

                break;
            default:
                name =null;
                break;
        }

        return name;
    }

    private void SetBottomBarItemsFocused()
    {
        TextView name = ChangeChannel(mViewPager.getCurrentItem());
        if(name!=null)
        {
            initCH();
            name.requestFocus();
        }

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

            //mAdapter.setDatas(LayoutData.GetLayoutData());

            mAdapter.setDatas(ChannelInfoList.getInstance().getmChannelInfos());

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
                    TextView name = ChangeChannel(position);
                    int dx =300*(position - currentIndex);

                    if(name!=null)
                    {
                        name.setTextColor(Color.RED);
                        name.setBackgroundResource(R.mipmap.underline);
                        checkCHVisible( name, dx);
                    }

                    currentIndex = position;

                    RxBus.getInstance().send(RxCodeConstants.ReCycleView_init,new RxBusBaseMessage(position,new Object()));
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
        Rect scrollRect = new Rect();
        mCHScrollView.getHitRect(scrollRect);
        //子控件在可视范围内（至少有一个像素在可视范围内）
        if (name.getGlobalVisibleRect(scrollRect)) {

        } else {
            ////子控件完全不在可视范围内
            mCHScrollView.smoothScrollBy(dx,0);
        }
    }


    private void attchCHItemsclick(TextView tv,int postion)
    {
        tv.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Log.i("匿名内部类", "点击事件");

                Animation shake = AnimationUtils.loadAnimation(v.getContext(), R.anim.left_right_shake);
                tv.startAnimation(shake);

                mViewPager.setCurrentItem(postion);

            }
        });

        tv.setOnFocusChangeListener(new View.OnFocusChangeListener(){

            @Override
            public void onFocusChange(View v, boolean hasFocus){
                if(hasFocus)
                {
                    tv.setTextColor(Color.YELLOW);
                    tv.setBackgroundResource(R.mipmap.underline);
                    mViewPager.setCurrentItem(postion);
                }
                else
                {
                    tv.setTextColor(Color.WHITE);
                    tv.setBackgroundResource(0);
                }
            }
         }


        );

    }

    private void attchCHclick()
    {

        attchCHItemsclick(common_broadcast_text,0);

        attchCHItemsclick(recommend_text,1);

        attchCHItemsclick(TV_text,2);

        attchCHItemsclick(VIP_text,3);

        attchCHItemsclick(Children_text,4);

        attchCHItemsclick(TVShow_text,5);

        attchCHItemsclick(Film_text,6);

        attchCHItemsclick(Video_text,7);

        attchCHItemsclick(More_text,8);

        attchCHItemsclick(Setting_text,9);

    }

    private void initCH()
    {
        common_broadcast_text.setTextColor(Color.WHITE);
        common_broadcast_text.setBackgroundResource(0);

        recommend_text.setTextColor(Color.WHITE);
        recommend_text.setBackgroundResource(0);

        TV_text.setTextColor(Color.WHITE);
        TV_text.setBackgroundResource(0);

        VIP_text.setTextColor(Color.WHITE);
        VIP_text.setBackgroundResource(0);

        Children_text.setTextColor(Color.WHITE);
        Children_text.setBackgroundResource(0);

        TVShow_text.setTextColor(Color.WHITE);
        TVShow_text.setBackgroundResource(0);

        Film_text.setTextColor(Color.WHITE);
        Film_text.setBackgroundResource(0);

        Video_text.setTextColor(Color.WHITE);
        Video_text.setBackgroundResource(0);

        More_text.setTextColor(Color.WHITE);
        More_text.setBackgroundResource(0);

        Setting_text.setTextColor(Color.WHITE);
        Setting_text.setBackgroundResource(0);
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

    }
    @Override
    public void onError(String result) {
        Toast.makeText(MainActivity.this,result, Toast.LENGTH_SHORT).show();
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


    @Override
    protected void onDestroy(){
        super.onDestroy();
        //mBookPresenter.onStop();
        if (mBound) {
            unbindService(mConnection);
            mBound = false;
        }
    }


    private ChannelDataService mService;

    private boolean mBound = false;


    private ServiceConnection mConnection = new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            ChannelDataService.MyBinder binder = (ChannelDataService.MyBinder) service;
            mService = binder.getService();
            mBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            mBound = false;
        }
    };

    public void bindService(View view) {
        Intent intent = new Intent(this, ChannelDataService.class);
        bindService(intent, mConnection, Context.BIND_AUTO_CREATE);
    }

    public void unBindService(View view) {
        if (mBound) {
            unbindService(mConnection);
            mBound = false;
        }
    }



}
