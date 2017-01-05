package com.jiale.mininews.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jiale.mininews.R;
import com.jiale.mininews.bean.NewsBean;
import com.jiale.mininews.utils.LogUtil;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Karlo on 2016/12/12.
 */

public abstract class AbsAdapter<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    protected List<T> data;
    private LayoutInflater layoutInflater;
    private Context context;
    private int[] itemLayoutRes;
    protected boolean hasBottom = false;
    protected onItemClickListener listener;
    public static int BOTTOM_TYPE;
    public static int NORMAL = 1;
    public static int LODING = 2;
    private int loadState = 1;
    private CommonViewHolder bottomView;

    AbsAdapter(Context context, List<T> data, boolean hasBottom, int... itemLayoutRes) {
        this.data = data;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
        this.itemLayoutRes = itemLayoutRes;
        this.hasBottom = hasBottom;
        if (hasBottom) {
            BOTTOM_TYPE = itemLayoutRes.length;
        }
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public CommonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == BOTTOM_TYPE) {
            View view = layoutInflater.inflate(R.layout.newslist_item_loadmore, parent, false);
            CommonViewHolder footer = new CommonViewHolder(context, view);
            bottomView = footer;
            return footer;
        }
        View itemView = layoutInflater.inflate(itemLayoutRes[viewType], parent, false);
        final CommonViewHolder holder = new CommonViewHolder(context, itemView);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onItemClick(holder);
                }
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        CommonViewHolder viewHolder = (CommonViewHolder) holder;
        if (hasBottom && position + 1 == getItemCount()) {
            viewHolder.findView(R.id.newslist_loadmore_progressbar).setVisibility(View.VISIBLE);
            viewHolder.findView(R.id.newslist_loadmore_tv).setVisibility(View.VISIBLE);
            return;
        }
        cover(viewHolder, data.get(position));
    }

    public int getLoadState() {
        return loadState;
    }

    public void setLoadState(int loadState) {
        this.loadState = loadState;
    }

    public abstract void cover(CommonViewHolder viewHolder, T bean);

    public abstract int getItemType(int position);

    @Override
    public int getItemViewType(int position) {
        if (hasBottom && position + 1 == getItemCount()) {
            return BOTTOM_TYPE;
        }
        return getItemType(position);
    }


    @Override
    public int getItemCount() {
        if (data == null || data.size() == 0) {
            return 0;
        }
        if (hasBottom) {
            return data.size() + 1;
        }
        return data.size();
    }

    public void setListener(onItemClickListener listener) {
        this.listener = listener;
    }

    public interface onItemClickListener {
        void onItemClick(CommonViewHolder holder);
    }

    public static class CommonViewHolder extends RecyclerView.ViewHolder {
        private SparseArray<View> views;
        private Context context;

        CommonViewHolder(Context context, View itemView) {
            super(itemView);
            views = new SparseArray<>();
            this.context = context;
        }

        public void setText(int resId, String value) {
            View view = views.get(resId);
            if (view == null) {
                view = itemView.findViewById(resId);
                views.put(resId, view);
            }
            ((TextView) view).setText(value);
        }

        public View findView(int resId) {
            View view = views.get(resId);
            if (view == null) {
                view = itemView.findViewById(resId);
                views.put(resId, view);
            }
            return view;
        }

        public void setImg(int resId, String url) {
            View view = views.get(resId);
            if (view == null) {
                view = itemView.findViewById(resId);
                views.put(resId, view);
            }
            view.setVisibility(View.VISIBLE);
            Picasso.with(context).load(url).placeholder(R.color.photo_placeholder).into((ImageView) view);
        }
    }

    public void hideLoadMoreView() {
        if (hasBottom && loadState == NORMAL && bottomView != null) {
            bottomView.findView(R.id.newslist_loadmore_tv).setVisibility(View.GONE);
            bottomView.findView(R.id.newslist_loadmore_progressbar).setVisibility(View.GONE);
        }
    }
}
