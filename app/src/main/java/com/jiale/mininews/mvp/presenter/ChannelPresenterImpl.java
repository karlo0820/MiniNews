package com.jiale.mininews.mvp.presenter;

import android.content.Context;

import com.jiale.mininews.bean.ChannelBean;
import com.jiale.mininews.mvp.listener.onLoadChannelListener;
import com.jiale.mininews.mvp.model.ChannelModelImpl;
import com.jiale.mininews.mvp.presenter.interfaces.ChannelPresenter;
import com.jiale.mininews.mvp.view.IChannelView;

import java.util.List;


/**
 * Created by Karlo on 2016/12/13.
 */
public class ChannelPresenterImpl implements ChannelPresenter<ChannelBean>, onLoadChannelListener<ChannelBean> {
    public static final int TYPE_SELECT = 0;
    public static final int TYPE_UNSELECT = 1;
    private IChannelView iChannelView;
    private ChannelModelImpl channelModel;
    private Context context;

    public ChannelPresenterImpl(Context context, IChannelView iChannelView) {
        this.context = context;
        this.iChannelView = iChannelView;
        channelModel = new ChannelModelImpl();
    }

    @Override
    public void getChannel() {
        iChannelView.showProgress();
        channelModel.getChannelList(context, this);
    }

    @Override
    public void saveChannel(ChannelBean channelBean) {
        channelModel.saveChannel(context, channelBean);
    }


    @Override
    public void loadSelectSuccess(List<ChannelBean> t) {
        iChannelView.hideProgress();
        iChannelView.getChannelSuccess(TYPE_SELECT, t);
    }

    @Override
    public void loadUnSelectSuccess(List<ChannelBean> t) {
        iChannelView.hideProgress();
        iChannelView.getChannelSuccess(TYPE_UNSELECT, t);
    }

    @Override
    public void loadFail(String msg) {
        iChannelView.hideProgress();
        iChannelView.getChannelError(msg);
    }
}
