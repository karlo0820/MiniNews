package com.jiale.mininews.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.jiale.mininews.R;
import com.jiale.mininews.bean.ChannelBean;
import com.jiale.mininews.utils.LogUtil;

import java.util.List;

import static android.R.string.no;

/**
 * Created by Karlo on 2016/12/13.
 */

public class ChannelAdapter extends AbsAdapter<ChannelBean> {
    private static final String TAG = "ChannelAdapter";
    public static final int EDIT = 1;
    public static final int NORMAL = 0;
    private boolean isDelete = false;
    private int mode = NORMAL;

    public ChannelAdapter(Context context, List<ChannelBean> data, boolean hasBottom, int... itemLayoutRes) {
        super(context, data, hasBottom, itemLayoutRes);
    }

    @Override
    public void cover(CommonViewHolder viewHolder, ChannelBean bean) {
        viewHolder.setText(R.id.channel_item_text, bean.getName());
//        if (mode == EDIT) {
        if (bean.getName().equals("头条")) {
            viewHolder.findView(R.id.channel_item_delete).setVisibility(View.INVISIBLE);
            LogUtil.i("TAG", "不改变的" + bean.getName());
            return;
        }
        if (isDelete) {
            viewHolder.findView(R.id.channel_item_delete).setVisibility(View.VISIBLE);
            LogUtil.i("TAG", "可见" + bean.getName());
        } else {
            viewHolder.findView(R.id.channel_item_delete).setVisibility(View.INVISIBLE);
            LogUtil.i("TAG", "不可见" + bean.getName());
        }
//        }
    }

    @Override
    public int getItemType(int position) {
        return 0;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    public int getMode() {
        return mode;
    }

    /**
     * 更改item频道的样式状态
     *
     * @param flag true 显示deleter ，false不显示delete
     */
    public void setChannelState(boolean flag) {
        if (isDelete == flag) {
            return;
        }
        isDelete = flag;
        notifyDataSetChanged();
    }

    public void addItem(ChannelBean bean) {
        data.add(bean);
        notifyItemChanged(data.size());
    }

    public ChannelBean removeItem(int position) {
        ChannelBean bean = data.remove(position);
        notifyItemRemoved(position);
        return bean;
    }
}
