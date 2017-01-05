package com.jiale.mininews.mvp.presenter.interfaces;

import com.jiale.mininews.bean.ChannelBean;

import java.util.List;

/**
 * Created by Karlo on 2016/12/13.
 */

public interface ChannelPresenter<T> {
    /*获取频道信息*/
    void getChannel();

    /*保存频道信息*/
    void saveChannel(T t);
}
