package com.jiale.mininews.mvp.presenter.interfaces;

import com.jiale.mininews.mvp.listener.onLoadTypeListener;


/**
 * presenter基类
 * Created by Karlo on 2016/12/12.
 */
public interface BasePresenter<T> extends onLoadTypeListener<T> {

    void loadData(int requestType ,String id);

}
