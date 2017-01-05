package com.jiale.mininews.mvp.view;

import com.jiale.mininews.bean.ChannelBean;

import java.util.List;

/**
 * Created by Karlo on 2016/12/13.
 */

public interface IChannelView extends IBaseView<List<ChannelBean>> {
    void getChannelSuccess(int DataType, List<ChannelBean> list);

    void getChannelError(String msg);
}
