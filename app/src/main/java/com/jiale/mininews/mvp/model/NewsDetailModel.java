package com.jiale.mininews.mvp.model;

import com.jiale.mininews.mvp.listener.onLoadListener;

/**
 * Created by Karlo on 2016/12/14.
 */

public interface NewsDetailModel<T> {
    /*获取新闻详情数据*/
    void loadDetial(String postId,onLoadListener<T> listener);
}
