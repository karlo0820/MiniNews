package com.jiale.mininews.mvp.listener;

import com.jiale.mininews.bean.NewsPhotoBean;

import java.util.List;

/**
 * Created by Karlo on 2016/12/15.
 */

public interface onLoadListener<T> {
    void loadSuccess(T t);
    void loadFail(String msg);
}
