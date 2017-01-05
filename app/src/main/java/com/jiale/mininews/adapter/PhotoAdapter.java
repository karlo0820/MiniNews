package com.jiale.mininews.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;

import com.jiale.mininews.R;
import com.jiale.mininews.bean.PhotoBean;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Karlo on 2016/12/17.
 */

public class PhotoAdapter extends AbsAdapter<PhotoBean> {
    public PhotoAdapter(Context context, List<PhotoBean> data, boolean hasBottom, int... itemLayoutRes) {
        super(context, data, hasBottom, itemLayoutRes);
    }

    @Override
    public void cover(CommonViewHolder viewHolder, PhotoBean bean) {
        View view = viewHolder.findView(R.id.photo_item_img);
        Picasso.with(view.getContext()).load(bean.getUrl()).config(Bitmap.Config.RGB_565).placeholder(R.color.photo_placeholder).into((ImageView) view);
    }

    @Override
    public int getItemType(int position) {
        return 0;
    }


    public void addAllData(List<PhotoBean> list) {
        data.addAll(list);
    }
    public void clearData() {
        data.clear();
    }
}
