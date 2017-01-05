package com.jiale.mininews.mvp.listener;

import java.util.List;

/**
 * Created by Karlo on 2016/12/13.
 */

public interface onLoadChannelListener<T> {
    void loadSelectSuccess(List<T> t);

    void loadUnSelectSuccess(List<T> t);

    void loadFail(String msg);
}
