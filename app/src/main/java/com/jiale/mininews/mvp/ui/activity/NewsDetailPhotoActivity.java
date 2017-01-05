package com.jiale.mininews.mvp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jiale.mininews.R;
import com.jiale.mininews.adapter.NewsPhotoAdapter;
import com.jiale.mininews.bean.NewsPhotoBean;
import com.jiale.mininews.mvp.presenter.NewsPhotoPresenterImpl;
import com.jiale.mininews.mvp.view.INewsPhotoSetView;
import com.jiale.mininews.utils.AppUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Karlo on 2016/12/15.
 */

public class NewsDetailPhotoActivity extends BaseActivity implements INewsPhotoSetView {
    @BindView(R.id.newsdetail_photo_viewpager)
    ViewPager newsdetailPhotoViewpager;
    @BindView(R.id.newsdetail_photo_title)
    TextView newsdetailPhotoTitle;
    @BindView(R.id.newsdetail_photo_pagemarker)
    TextView newsdetailPhotoPagemarker;
    @BindView(R.id.newsdetail_photo_descri)
    TextView newsdetailPhotoDescri;
    @BindView(R.id.newslist_photo_footer)
    LinearLayout newslistPhotoFooter;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    //    private NewsPhotoBean bean;
    private NewsPhotoAdapter imgsAdapter;
    private List<ImageView> imgs;
    private NewsPhotoPresenterImpl newsPhotoPresenter;
    private String imgSum;
    private List<String> notes;
    private String source;

    @Override
    public int getLayoutId() {
        return R.layout.activity_newsdetail_photoset;
    }

    @Override
    protected void initEvent() {
        newsdetailPhotoViewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                newsdetailPhotoDescri.setText(notes.get(position));
                newsdetailPhotoPagemarker.setText((position + 1) + "/" + imgSum);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    protected void initViews() {
        ViewGroup.LayoutParams layoutParams = newsdetailPhotoViewpager.getLayoutParams();
        layoutParams.height = (int) (AppUtil.getWindowHeight() * 0.4);
        newsdetailPhotoViewpager.setLayoutParams(layoutParams);
        newsdetailPhotoViewpager.setAdapter(imgsAdapter);
    }

    @Override
    protected void initData() {
        notes = new ArrayList<>();
        imgs = new ArrayList<>();
        Intent intent = getIntent();
        String skipId = intent.getStringExtra("skipId");
        newsPhotoPresenter = new NewsPhotoPresenterImpl(this);
        newsPhotoPresenter.getPhotoData(makeSkipId(1, skipId), makeSkipId(2, skipId));
        imgsAdapter = new NewsPhotoAdapter(imgs, this);
    }

    private String makeSkipId(int type, String skipId) {
        Log.i("google.karlo", "makeSkipId: " + skipId.substring(4, 8));
        Log.i("google.karlo", "makeSkipId: " + skipId.substring(9));
        if (type == 1) {
            return skipId.substring(4, 8);
        }
        return skipId.substring(9);
    }


    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void initPhotoSetSuccess(NewsPhotoBean newsPhotoBean) {
//        bean = newsPhotoBean;
        imgSum = newsPhotoBean.getImgsum();
        source = newsPhotoBean.getSource();
        List<NewsPhotoBean.PhotosBean> photos = newsPhotoBean.getPhotos();
        for (NewsPhotoBean.PhotosBean photosBean : photos) {
            ImageView iv = new ImageView(this);
            iv.setTag(photosBean.getImgurl());
            imgs.add(iv);
            notes.add(photosBean.getNote());
        }
        newsdetailPhotoDescri.setText(notes.get(0));
        newsdetailPhotoPagemarker.setText(String.valueOf("1/" + imgSum));
        newsdetailPhotoTitle.setText(newsPhotoBean.getSetname());
        imgsAdapter.notifyDataSetChanged();
    }

    @Override
    public void initPhotoSetFail(String msg) {

    }

    @Override
    public void finish() {
        super.finish();
//        if (imgsAdapter != null) {
//            imgsAdapter.recycle();
//        }
    }
}
