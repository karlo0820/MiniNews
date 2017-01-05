package com.jiale.mininews.mvp.ui.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

import com.jiale.mininews.R;

import butterknife.ButterKnife;

/**
 * Activity基类
 * Created by Karlo on 2016/12/12.
 */

public abstract class BaseActivity extends AppCompatActivity {
    protected static final int FADE_IN = R.anim.activity_fade_in;
    protected static final int FADE_OUT = R.anim.activity_fade_out;
    protected static final int NO_ANIM = R.anim.activity_no_anim;

    //    private static final String ENTER = "activity_in";
//    private static final String EXIT = "activity_out";
    public abstract int getLayoutId();

    protected int layoutId;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        layoutId = getLayoutId();
        setContentView(layoutId);
        ButterKnife.bind(this);
        hideStatus();
        initToolBar();
        initData();
        initViews();
        initEvent();
    }

    protected abstract void initEvent();

    protected abstract void initViews();

    protected abstract void initData();

    public void hideStatus() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
    }

    protected void initToolBar() {
        if (!(this instanceof HomeActivity)) {
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    finishAfterTransition();
                } else {
                    finish();
                }
            }
            break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void startActivity(Intent intent) {
        super.startActivity(intent);
        overridePendingTransition(FADE_IN, NO_ANIM);
    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode, Bundle options) {
        super.startActivityForResult(intent, requestCode, options);
    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        super.startActivityForResult(intent, requestCode);
        overridePendingTransition(FADE_IN, NO_ANIM);
    }

    @Override
    public void finish() {
        super.finish();
//        overridePendingTransition(NO_ANIM, FADE_OUT);
    }
}
