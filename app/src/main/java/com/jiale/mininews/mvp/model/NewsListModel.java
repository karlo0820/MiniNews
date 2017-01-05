package com.jiale.mininews.mvp.model;

import static android.R.attr.id;

/**
 * Created by Karlo on 2016/12/12.
 */

public interface NewsListModel {
    /*从网络获取新闻数据*/
    void loadData(int requestType,String id,int page);
}
