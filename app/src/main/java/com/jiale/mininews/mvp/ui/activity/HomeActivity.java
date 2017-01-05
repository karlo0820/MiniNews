package com.jiale.mininews.mvp.ui.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;

import com.jiale.mininews.R;
import com.jiale.mininews.mvp.ui.fragment.NewsFragment;
import com.jiale.mininews.mvp.ui.fragment.PhotoFragment;
import com.jiale.mininews.utils.LogUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends BaseActivity {
    private static final int NEWS = 0;
    private static final int PHOTO = 1;
    private static final int VIDEO = 2;
    private static final String TAG ="HomeActivity" ;
    @BindView(R.id.home_navi)
    NavigationView homeNavi;
    @BindView(R.id.homeDrawer)
    DrawerLayout homeDrawer;
    private FragmentManager manager;

    @Override
    public int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initEvent() {
        homeNavi.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navi_news: {
                        setFragment(NEWS);
                    }
                    break;
                    case R.id.navi_photo: {
                        setFragment(PHOTO);
                    }
                    break;
                    case R.id.navi_video: {

                    }
                    break;
                    case R.id.navi_about: {

                    }
                    break;
                    case R.id.navi_nightmode: {

                    }
                    break;
                }
                homeDrawer.closeDrawer(GravityCompat.START);
                return false;
            }
        });
    }


    @Override
    protected void initViews() {
        manager = getSupportFragmentManager();
        setFragment(NEWS);
    }

    @Override
    protected void initData() {

    }

    public void setToggle(Toolbar toolbar) {
        LogUtil.i(TAG,"setToggle");
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(HomeActivity.this, homeDrawer, toolbar, 0, 0);
        homeDrawer.addDrawerListener(toggle);
        toggle.syncState();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    private void setFragment(int type) {
        if (manager == null) {
            manager = getSupportFragmentManager();
        }
        switch (type) {
            case NEWS: {
                manager.beginTransaction().replace(R.id.home_framelayout, new NewsFragment()).commit();
            }
            break;
            case PHOTO: {
                manager.beginTransaction().replace(R.id.home_framelayout, new PhotoFragment()).commit();
            }
            break;
            case VIDEO: {

            }
            break;
        }
    }
}
