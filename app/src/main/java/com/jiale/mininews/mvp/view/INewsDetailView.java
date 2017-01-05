package com.jiale.mininews.mvp.view;

import com.jiale.mininews.bean.NewsDetailBean;

/**
 * Created by Karlo on 2016/12/14.
 */

public interface INewsDetailView extends IBaseView {
    void showData(NewsDetailBean bean);
}
