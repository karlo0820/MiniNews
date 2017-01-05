package com.jiale.mininews.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.jiale.mininews.utils.AppUtil;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Karlo on 2016/12/15.
 */

public class NewsPhotoAdapter extends PagerAdapter {
    private List<ImageView> imgs;
    private Context context;
    private ViewPager.LayoutParams params;

    public NewsPhotoAdapter(List<ImageView> imgs, Context context) {
        this.imgs = imgs;
        this.context = context;
        params = new ViewPager.LayoutParams();
        params.width = ViewPager.LayoutParams.MATCH_PARENT;
        params.height = ViewPager.LayoutParams.MATCH_PARENT;
    }

    @Override
    public int getCount() {
        return imgs == null ? 0 : imgs.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView iv = imgs.get(position);
        iv.setScaleType(ImageView.ScaleType.CENTER_CROP);
        Picasso.with(context).load((String) iv.getTag()).config(Bitmap.Config.ARGB_8888).into(iv);
        container.addView(iv, params);
        return iv;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ImageView iv = imgs.get(position);
        container.removeView(iv);
//        BitmapDrawable drawable = (BitmapDrawable) iv.getDrawable();
//        if (drawable != null) {
//            Bitmap bitmap = drawable.getBitmap();
//            if (bitmap != null && !bitmap.isRecycled()) {
//                bitmap.recycle();
//            }
//        }
    }

//    public void recycle() {
//        for (ImageView iv : imgs) {
//            if (iv != null) {
//                BitmapDrawable drawable = (BitmapDrawable) iv.getDrawable();
//                if (drawable != null) {
//                    Bitmap bitmap = drawable.getBitmap();
//                    if (bitmap != null && !bitmap.isRecycled()) {
//                        bitmap.recycle();
//                    }
//                }
//            }
//        }
//    }
}
