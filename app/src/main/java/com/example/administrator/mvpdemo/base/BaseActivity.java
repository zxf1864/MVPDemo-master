package com.example.administrator.mvpdemo.base;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.administrator.mvpdemo.R;
import com.example.administrator.mvpdemo.ui.CustomWidgets.BadgeView;
import com.example.administrator.mvpdemo.ui.activity.MainActivity;

import org.reactivestreams.Subscription;

import java.lang.reflect.Method;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.subjects.PublishSubject;

/**
 * Created by xiaofeizhang on 2018/1/31.
 */
//
//public abstract class BaseActivity extends RxAppCompatActivity {
//
//
//}

public abstract class BaseActivity extends AppCompatActivity {

    protected Context mContext;
    protected Unbinder unBinder;

    public Toolbar getmToolBar() {
        return mToolBar;
    }

    private Toolbar mToolBar;

    private Subscription mSubscription;

    public final PublishSubject<ActivityLifeCycleEvent> lifecycleSubject = PublishSubject.create();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        lifecycleSubject.onNext(ActivityLifeCycleEvent.CREATE);
        super.onCreate(savedInstanceState);

        setContentView(getContentViewId());
        mContext = this;
        unBinder = ButterKnife.bind(this);

        mToolBar = (Toolbar) findViewById(R.id.toolbar);
        if (mToolBar!=null)
        { mToolBar.setTitle("");
        setSupportActionBar(mToolBar);}

        init();

        Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() {
            @Override
            public boolean queueIdle() {
                Log.i("IdleHandler","queueIdle");
                onInit();
                return false; //false 表示只监听一次IDLE事件,之后就不会再执行这个函数了.
            }
        });

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

    public MenuItem search;
    public MenuItem user;
    public MenuItem vip;

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        search = menu.findItem(R.id.action_search);
//
//        setUpCartMenuItem(menu);
//        return true;
//    }

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
                Toast.makeText(BaseActivity.this, "搜索", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_user:
                Toast.makeText(BaseActivity.this, "添加", Toast.LENGTH_SHORT).show();
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
            BadgeView badgeView = new BadgeView(BaseActivity.this, mCartView);
            badgeView.setBadgePosition(BadgeView.POSITION_TOP_RIGHT);
            badgeView.setText("111");
            mCartView.measure(0, 0);
            badgeView.setBadgeMargin(mCartView.getMeasuredWidth() / 55, mCartView.getMeasuredWidth() / 65);
            badgeView.show(true);
            actionView.measure(0, 0);
        }
    }


    //子类重写此函数即可,而不需要在onCreate()中去初始化.
    protected void onInit() {
        Log.e("BaseActivity", "onInit");
    }

    @Override
    protected void onPause() {
        lifecycleSubject.onNext(ActivityLifeCycleEvent.PAUSE);
        super.onPause();
    }

    @Override
    protected void onStop() {
        lifecycleSubject.onNext(ActivityLifeCycleEvent.STOP);
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        lifecycleSubject.onNext(ActivityLifeCycleEvent.DESTROY);
    }

    /**
     * 获取显示view的xml文件ID
     */
    protected abstract int getContentViewId();

    protected abstract void init();


//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        //主动解除订阅关系
//        if (mSubscription != null && !mSubscription.isUnsubscribed()) {
//            mSubscription.unsubscribe();
//        }
//    }

}
