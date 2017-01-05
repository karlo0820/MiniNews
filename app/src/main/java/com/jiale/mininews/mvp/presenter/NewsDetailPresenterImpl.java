package com.jiale.mininews.mvp.presenter;

import com.jiale.mininews.bean.NewsDetailBean;
import com.jiale.mininews.mvp.listener.onLoadListener;
import com.jiale.mininews.mvp.model.NewsDetailModelImpl;
import com.jiale.mininews.mvp.presenter.interfaces.NewsDetailPresenter;
import com.jiale.mininews.mvp.view.INewsDetailView;

/**
 * Created by Karlo on 2016/12/14.
 */
public class NewsDetailPresenterImpl implements NewsDetailPresenter, onLoadListener<NewsDetailBean> {
    private INewsDetailView newsDetailView;
    private NewsDetailModelImpl newsDetailModel;

    public NewsDetailPresenterImpl(INewsDetailView newsDetailView) {
        this.newsDetailView = newsDetailView;
        newsDetailModel = new NewsDetailModelImpl();
    }

    @Override
    public void getData(String postId) {
        newsDetailView.showProgress();
        newsDetailModel.loadDetial(postId, this);

    }

    @Override
    public void loadSuccess(NewsDetailBean bean) {
        newsDetailView.showData(bean);
        newsDetailView.hideProgress();
    }

    @Override
    public void loadFail(String msg) {
        newsDetailView.hideProgress();
    }
}
