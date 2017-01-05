package com.jiale.mininews.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import com.jiale.mininews.R;
import com.jiale.mininews.bean.NewsBean;
import com.jiale.mininews.utils.Constant;

import java.util.List;

/**
 * Created by Karlo on 2016/12/12.
 */

public class NewsListAdapter extends AbsAdapter<NewsBean> {

    public NewsListAdapter(Context context, List<NewsBean> data, boolean hasBottom, int... itemLayoutRes) {
        super(context, data, hasBottom, itemLayoutRes);
    }

    @Override
    public void cover(CommonViewHolder viewHolder, NewsBean newsBean) {
        if (newsBean.getType() == 0) {
            viewHolder.setImg(R.id.newslist_cover, newsBean.getImgsrc());
        } else if (newsBean.getType() == 1) {
            if (Constant.PHOTOSET.equals(newsBean.getSkipType())) {
                viewHolder.setText(R.id.newslist_type, Constant.PHOTOSET_VALUE);
            } else if (Constant.LIVE.equals(newsBean.getSkipType())) {
                viewHolder.setText(R.id.newslist_type, newsBean.getTAG());
            }
            viewHolder.setImg(R.id.newslist_cover1, newsBean.getImgsrc());
            if (newsBean.getImgextra() != null) {
                for (int i = 0; i < newsBean.getImgextra().size(); i++) {
                    if (i == 2) {
                        break;
                    }
                    if (i % 2 == 0) {
                        viewHolder.setImg(R.id.newslist_cover2, newsBean.getImgextra().get(i).getImgsrc());
                    } else if (i % 2 == 1) {
                        viewHolder.setImg(R.id.newslist_cover3, newsBean.getImgextra().get(i).getImgsrc());
                    }
                }
            }
        }
        viewHolder.setText(R.id.newslist_title, newsBean.getTitle());
        viewHolder.setText(R.id.newslist_publictime, newsBean.getPtime());
        viewHolder.setText(R.id.newslist_src, newsBean.getSource());
    }


    @Override
    public int getItemType(int position) {
        return data.get(position).getType();
    }
}
