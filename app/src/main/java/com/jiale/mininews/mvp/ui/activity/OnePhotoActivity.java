package com.jiale.mininews.mvp.ui.activity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.jiale.mininews.R;
import com.jiale.mininews.utils.Constant;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Karlo on 2016/12/19.
 */

public class OnePhotoActivity extends BaseActivity {
    @BindView(R.id.onephoto_img)
    ImageView onephotoImg;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    private String photoUrl;
    private PopupWindow popupWindow;

    @Override
    public int getLayoutId() {
        return R.layout.activity_onephoto;
    }

    @Override
    protected void initEvent() {
        onephotoImg.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(OnePhotoActivity.this, "保存", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void initData() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) onephotoImg.getLayoutParams();
        layoutParams.setMargins(0, toolbar.getBottom() + 30, 0, 0);
        onephotoImg.setLayoutParams(layoutParams);
        photoUrl = getIntent().getStringExtra(Constant.ONEPHOTO_URL);
        Picasso.with(this).load(photoUrl).config(Bitmap.Config.ARGB_8888).error(R.mipmap.ic_load_fail).placeholder(R.color.photo_placeholder).into(onephotoImg);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
